package com.hebut.bookshare.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Class Name: EncodeFilter</p>
 * <P>Package: com.hebut.bookshare.filter</p>
 * <p>Description: 对所有的请求设置中文字符集过滤</p>
 * <p>CopyRight: Hebut</p>
 * @author Administrator
 * @date 2016年12月6日 下午5:00:51
 */
public class EncodeFilter implements Filter {

	private FilterConfig filterConfig;
    public EncodeFilter() {}
    
	public void destroy() {
		
	}

	/* 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		//在过滤器doFilter中首先要强制转类型
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		//获取web.xml中的初始化选用中文字符集参数
		String encode = filterConfig.getInitParameter("encode");
		req.setCharacterEncoding(encode);
		res.setHeader("Content-Type", "text/html;charset="+encode);
		res.setCharacterEncoding(encode);
		
		chain.doFilter(req, res);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//在初始化时候，将web.xml中的初始化参数传给该类的私有属性
		this.filterConfig = fConfig;
	}

}
