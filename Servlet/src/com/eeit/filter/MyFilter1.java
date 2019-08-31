package com.eeit.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/FilterDemo")
public class MyFilter1 implements Filter {

   
    public MyFilter1() {
    }

	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.write("Pre-processing of MyFilter1<br>");
		chain.doFilter(request, response);
		out.write("Post-processing of MyFilter1<br>");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
