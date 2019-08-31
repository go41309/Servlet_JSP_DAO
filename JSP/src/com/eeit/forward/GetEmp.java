package com.eeit.forward;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetEmp")
public class GetEmp extends HttpServlet {
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
   
    public GetEmp() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String empno = request.getParameter("empno");
		try {
			String qryStmt = "SELECT * FROM employee WHERE empno = ?";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, empno);
			ResultSet rs = stmt.executeQuery();
			com.eeit.bean.EmpBean emp = new com.eeit.bean.EmpBean();
			if(rs.next()) {
				emp.setEmpno(rs.getString("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getString("hiredate").substring(0,10));
				emp.setSalary(rs.getString("salary"));
				emp.setDeptno(rs.getString("deptno"));
				emp.setTitle(rs.getString("title"));
			}
			request.setAttribute("emp",emp);
			stmt.close();
			RequestDispatcher rd = request.getRequestDispatcher("/forward/GetEmp.jsp");
			rd.forward(request, response);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
