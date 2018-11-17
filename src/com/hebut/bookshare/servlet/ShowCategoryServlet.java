package com.hebut.bookshare.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class ShowCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ShowCategoryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JSONObject options = new JSONObject();
		JSONObject obj = new JSONObject();
		obj.put("title", "{'text':'图书类别比例'}");
		obj.put("tooltip", "{}");
		obj.put("legend", "{data:['数量']}");
		obj.put("xAxis", "{data:['java编程','大数据技术','虚拟机技术','前端设计','云计算']}");
		obj.put("yAxis", "{}");
		obj.put("series", "[{name:'数量',type:'bar',data:[5,4,3,2,4]}]");
		options.put("options",obj);
		System.out.println(options);
		response.getWriter().print(options);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
