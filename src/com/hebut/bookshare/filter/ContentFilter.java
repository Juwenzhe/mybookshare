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


public class ContentFilter implements Filter {

    public ContentFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	/* 实现过滤
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//过滤器中首先强制转换ServletRequest为HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		ContentReplaceHttpServletRequestWrapper wrapper = new ContentReplaceHttpServletRequestWrapper(req);
	
		chain.doFilter(wrapper, res);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
