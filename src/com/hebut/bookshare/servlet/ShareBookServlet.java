package com.hebut.bookshare.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hebut.bookshare.biz.IBookBiz;
import com.hebut.bookshare.biz.IPressBiz;
import com.hebut.bookshare.biz.impl.BookBizImpl;
import com.hebut.bookshare.biz.impl.PressBizImpl;
import com.hebut.bookshare.po.Book;
import com.hebut.bookshare.po.Press;
import com.hebut.bookshare.po.User;
import com.hebut.bookshare.utils.RequestToBean;
import com.hebut.bookshare.utils.UUIDProvider;

public class ShareBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShareBookServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//预先设置文件上传的文件夹
		String filepath = this.getServletContext().getRealPath("/upload");
		//用commons包下的ServletFileUpload判断request对象中是不是包含文件上传信息（即是否包含二进制流文件）
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
			//如果包含文件上传信息，就在服务器上创建一个数据缓冲区
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//在这个factory中创建可以处理request请求上传文件的类
			ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
			try{
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");
				//把request对象解析成一个个的fileitem文件
				List<FileItem> items = servletFileUpload.parseRequest(request);
				//用迭代器完成items的上传操作
				Iterator<FileItem> iters = items.iterator();
//				boolean message = false;
				boolean bookflag = false;
				boolean picflag  =false;
				
				Book book = new Book();
				
				while(iters.hasNext()){
					FileItem item = iters.next();
					if(item.isFormField()){
						processFormItem(item, book);
					}else{
						String filename = item.getName();
						int index = filename.lastIndexOf(".");
						String suffix = filename.substring(index).trim();
						
						if(suffix.equals(".jpg") || suffix.equals(".png")){
							picflag = processUpLoadPicFileItem(item, filepath, book.getBookid(),suffix, response);
						}else if(suffix.equals(".pdf") || suffix.equals(".txt") || suffix.equals(".doc") ){
							bookflag = processUpLoadBookFileItem(item, filepath, book.getBookid(), suffix, response);
						}else{
							RequestDispatcher dispatcher = request.getRequestDispatcher("share?resCode=203");
							dispatcher.forward(request, response);
						}
				if(bookflag && picflag){
					IBookBiz iBookBiz = new BookBizImpl();
					boolean addflag = iBookBiz.addBook(book);
					if(addflag){
						response.sendRedirect("self?resCode=201");
					}else{
						request.setAttribute("book", book);
						RequestDispatcher dispatcher = request.getRequestDispatcher("share?resCode=202");
						dispatcher.forward(request, response);
					}
				}}}}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void processFormItem(FileItem item, Book book){
		String value = item.getString();
		String name = item.getName();
		String fieldname = item.getFieldName();
		System.out.println("name:"+name+"/"+value+"/fieldname:"+fieldname);
	}
	
	private boolean processUpLoadBookFileItem(FileItem item,String filepath, String bookid, String suffix,HttpServletResponse response){
		try{
			long filesize = item.getSize();
			if(filesize>1024*1024*200){
				response.getWriter().print("{message:'上传书籍超过【200M】，文件太大！请换一种分享方式！'}");
				return false;
			}
			File uploadFile = new File(filepath,bookid+suffix);
			item.write(uploadFile);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean processUpLoadPicFileItem(FileItem item,String filepath,String picid,String suffix, HttpServletResponse response){
		try{
			long filesize = item.getSize();
			if(filesize>1024*1024*10){
				response.getWriter().print("{message:'上传图片超过【10M】，图片太大！请换一种分享方式！'}");
				return false;
			}
			File uploadFile = new File(filepath,picid+suffix);
			item.write(uploadFile);
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
