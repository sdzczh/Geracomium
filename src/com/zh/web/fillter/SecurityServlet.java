package com.zh.web.fillter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zh.pojo.Admin;
import com.zh.pojo.User;
public class SecurityServlet extends HttpServlet implements Filter{
	 private static final long serialVersionUID = 1L;

	    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
	           HttpServletRequest request=(HttpServletRequest)arg0;   
	           HttpServletResponse response  =(HttpServletResponse) arg1;    
	           Object admin = request.getSession().getAttribute("admin");
	           Object user = request.getSession().getAttribute("user");
	           String url=request.getRequestURI();   
	           if(url.indexOf("login")<0 && url.indexOf("userLogin")<0){
		           if((admin==null || "".equals(admin)) && (user==null || "".equals(user))) {      
		                    response.sendRedirect(request.getContextPath()+"/login.jsp");
		            }else{
		            	arg2.doFilter(arg0, arg1);   
		            }
	           }else{
	        	   arg2.doFilter(arg0, arg1);   
	           }
	           
	    }
	    public void init(FilterConfig arg0) throws ServletException {
	    }

}
