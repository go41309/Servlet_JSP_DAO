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


@WebServlet("/GetEmpUpdate")
public class GetEmpUpdate extends HttpServlet {
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
   
    public GetEmpUpdate() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String hiredate = request.getParameter("hiredate");
		String salary = request.getParameter("salary");
		String deptno = request.getParameter("deptno");
		String title = request.getParameter("title");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String qryStmt = "SELECT * FROM employee WHERE empno = ?";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, empno);
			ResultSet rs = stmt.executeQuery();
			out.write("<html><body bgcolor = '#fdf5e6'>");
			out.write("<div align = center><h2>員工資料</h2>");
			out.write("<form method = 'post' action='GetEmpUpdate2'>");
			if(rs.next()) {
				out.write("<table width=60%>");
				out.write("<input type='hidden' name='empno' value="+rs.getString("empno")+">");
				out.write("<tr><td>姓名<td>"+"<input type='text' name='ename' value="+rs.getString("ename")+">");
				out.write("<tr><td>到職日<td>"+"<input type='text' name='hiredate' value="+rs.getString("hiredate")+">");
				out.write("<tr><td>薪水<td>"+"<input type='text' name='salary' value="+rs.getString("salary")+">");
				out.write("<tr><td>部門編號<td>"+"<input type='text' name='deptno' value="+rs.getString("deptno")+">");
				out.write("<tr><td>職稱<td>"+"<input type='text' name='title' value="+rs.getString("title")+">");
				out.write("</table>");	
				out.write("<input type='submit' name='送出'></form></div>");
			}else{
				out.write("找不到</div>");
			}
			out.write("</body></html>");
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
