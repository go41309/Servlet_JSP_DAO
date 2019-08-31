package com.eeit.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/GetAllEmpsDs2")
public class GetAllEmpsDs2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @Resource(name="jdbc/servdb") 
     private DataSource ds;
   Connection conn;
   public void init() {
	   try {
		  conn = ds.getConnection();
	   }  catch (SQLException e) {
		e.printStackTrace();
	} 
	   
   }  // end of inint()
   
   public void destroy() {
	   if(conn!=null) {
		   try {
			   conn.close();
		   }catch (SQLException e) {
				e.printStackTrace();
			}
	   }
   }
   
    public GetAllEmpsDs2() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int count = 0;
		try {
			String qryStmt = "SELECT * FROM employee";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();
			out.write("<html><body bgcolor = '#fdf5e6'>");
			out.write("<div align = center><h2>���u���</h2>");
			out.write("<table border = 1><tr bgcolor='#a8fefa'>");
			out.write("<th>���u�s��<th>�m�W<th>��¾��<th>�~��<th>�����s��<th>¾��");
			while(rs.next()) {
				out.write("<tr><td>"+rs.getString("empno"));
				out.write("<td>"+rs.getString("ename"));
				out.write("<td>"+rs.getString("hiredate").substring(0,10));
				out.write("<td>"+rs.getString("salary"));
				out.write("<td>"+rs.getString("deptno"));
				out.write("<td>"+rs.getString("title"));
				count++;
			}
			out.write("</table><h3>�@"+count+"�����u���</h3></div></body></html>");
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
