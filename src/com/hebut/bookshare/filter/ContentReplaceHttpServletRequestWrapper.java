package com.hebut.bookshare.filter;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class ContentReplaceHttpServletRequestWrapper extends HttpServletRequestWrapper {

	public ContentReplaceHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	//首先加载keywords.properties,利用反射加载properties文件的标准流程！背下来
	private static Properties keywords = new Properties();
	static{
		try {
			keywords.load(ContentReplaceHttpServletRequestWrapper.class.getResourceAsStream("keywords.properties"));
		} catch (IOException e) {
			System.out.println("加载配置文件失败！");
		}
	}
	
	/**
	 * @description: 过滤文本域
	 * @author: Administrator
	 * @param: textarea
	 * @return String
	 * @exception
	 * @date 2016年12月6日 下午7:44:19
	 */
	public String doReplace(String textarea){
		
		for (Object oldtemp: keywords.keySet()) {
			String oldword = oldtemp.toString();
			String newword = keywords.getProperty(oldword);
			textarea.replaceAll(oldword, newword);
		} 
		return textarea;
	}
	
	/* 
	 * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
	 * 重写这个方法，当用户请求过滤的属性name名称叫argument时候，对该name属性名称的text区域进行过滤
	 */
	@Override
	public String getParameter(String name) {

		if("argument".equals(name)){
			String oldStr = super.getParameter(name);
			String newStr = this.doReplace(oldStr);
			return newStr;
		}
		return super.getParameter(name);
	}	
}
