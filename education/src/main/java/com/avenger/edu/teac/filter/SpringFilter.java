package com.avenger.edu.teac.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/teacher.html")
public class SpringFilter implements Filter {

	
	String[] pages = new String[] {"/teacher.html","/student.html","/manager.html"};
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		
		String path = req.getRequestURI();
		boolean needFilter = isNeedFilter(path);
		 if (!needFilter) { 
	            chain.doFilter(request, response);
	        } else { 
	          if(session!=null&&session.getAttribute("teacher") != null){
	                chain.doFilter(request, response);
	            }else{
	            	resp.sendRedirect("/index.html");
	            }
	        }
		
	}
	public boolean isNeedFilter(String uri) {

        for (String includeUrl : pages) {
            if(includeUrl.equals(uri)) {
                return true;
            }
        }

        return false;
    }
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	
}
