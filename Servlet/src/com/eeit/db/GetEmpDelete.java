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


@WebServlet("/GetEmpDelete")
public class GetEmpDelete extends HttpServlet {
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
   
    public GetEmpDelete() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String empno = request.getParameter("empno");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String qryStmt = "Delete from employee where empno=?";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, empno);
			stmt.execute();
			out.write("該員工資料已刪除");
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
