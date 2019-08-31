package com.eeit.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/GetAllEmpsHtml","/getAllEmps.html"})
public class GetAllEmpsHtml extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   Connection conn;
   public void init() {
	   try {
		   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		   String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=servdb";
		   conn= DriverManager.getConnection(connUrl,"sa","P@ssw0rd");
	   } catch(ClassNotFoundException e) {
		   e.printStackTrace();
	   } catch (SQLException e) {
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
   
    public GetAllEmpsHtml() {
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
			out.write("<div align = center><h2>員工資料</h2>");
			out.write("<table border = 1><tr bgcolor='#a8fefa'>");
			out.write("<th>員工編號<th>姓名<th>到職日<th>薪水<th>部門編號<th>職稱");
			while(rs.next()) {
				out.write("<tr><td>"+rs.getString("empno"));
				out.write("<td>"+rs.getString("ename"));
				out.write("<td>"+rs.getString("hiredate").substring(0,10));
				out.write("<td>"+rs.getString("salary"));
				out.write("<td>"+rs.getString("deptno"));
				out.write("<td>"+rs.getString("title"));
				count++;
			}
			out.write("</table><h3>共"+count+"筆員工資料</h3></div></body></html>");
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
