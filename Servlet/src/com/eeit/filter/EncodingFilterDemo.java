package com.eeit.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EncodingFilterDemo")
public class EncodingFilterDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public EncodingFilterDemo() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("<html><body><h2>Hello everyone,�j�a�n!!!</h2></body></html>").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
