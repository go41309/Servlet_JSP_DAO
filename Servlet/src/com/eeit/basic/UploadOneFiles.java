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

import org.omg.CORBA.portable.OutputStream;

@WebServlet("/UploadOneFiles")
@MultipartConfig
public class UploadOneFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadOneFiles() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String header = null;
		String filename = null;
		InputStream in = null;
		FileOutputStream out = null;
		int count=0;
		for (Part part : request.getParts()) {
			in = part.getInputStream();
			header = part.getHeader("Content-Disposition");
			 System.out.println(header);
				
			if (header.indexOf("\\") != -1) {
				filename = header.substring(header.lastIndexOf("\\"), header.lastIndexOf("\""));
			} else {
				filename = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
			}

			if (filename.length() != 0) {
				out = new FileOutputStream("D:/uploadFiles/" + filename);
				byte[] buf = new byte[1024];
				int length;
				while ((length = in.read(buf)) != -1)
					out.write(buf, 0, length);
			} else {
				count++;
				if(count==request.getParts().size()) {
					response.getWriter().append("<h1>please type<h1>");
				}
				continue;
				
			}
			in.close();
		    out.close();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
