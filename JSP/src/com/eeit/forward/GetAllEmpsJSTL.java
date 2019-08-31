package com.eeit.forward;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/GetAllEmpsJSTL")
public class GetAllEmpsJSTL extends HttpServlet {
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
   
    public GetAllEmpsJSTL() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<com.eeit.bean.EmpBean> emps=new ArrayList<com.eeit.bean.EmpBean>();
		try {
			String qryStmt = "SELECT * FROM employee";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				com.eeit.bean.EmpBean eb = new com.eeit.bean.EmpBean();
				eb.setEmpno(rs.getString("empno"));
				eb.setEname(rs.getString("ename"));
				eb.setHiredate(rs.getString("hiredate"));
				eb.setSalary(rs.getString("salary"));
				eb.setDeptno(rs.getString("deptno"));
				eb.setTitle(rs.getString("title"));
				emps.add(eb);
			}
			request.setAttribute("emps", emps);
			stmt.close();
			RequestDispatcher rd = request.getRequestDispatcher("/JSTL/GetAllEmps.jsp");
			rd.forward(request, response);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
