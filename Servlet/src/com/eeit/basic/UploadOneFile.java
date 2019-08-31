package com.eeit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/UploadOneFile")
@MultipartConfig
public class UploadOneFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UploadOneFile() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Part part = request.getPart("photo");
		InputStream in = part.getInputStream();
		String header = part.getHeader("Content-Disposition");
		System.out.println(header);
		String filename = header.substring(header.indexOf("filename=\"")+13,
				header.lastIndexOf("\""));
		
		FileOutputStream out = new FileOutputStream("D:/uploadFiles/"+filename);
		byte[] buf = new byte[1024];
		int length;
		while((length = in.read(buf))!=-1)
			out.write(buf,0,length);
		in.close();
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
