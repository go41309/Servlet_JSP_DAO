package com.eeit.forward;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eeit.bean.EmpBean;
import com.eeit.dao.EmpDaoImpl;
import com.eeit.dao.IEmpDao;



@WebServlet("/GetAllEmps")
public class GetAllEmps extends HttpServlet {
	private static final long serialVersionUID = 1L;     
   Connection conn;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<EmpBean> emps=new ArrayList<EmpBean>();
		try {
			IEmpDao edao = new EmpDaoImpl();
			edao.connection();
			emps = edao.querydb();
			edao.close();
			request.setAttribute("emps", emps);
			RequestDispatcher rd = request.getRequestDispatcher("html/GetAllEmps.jsp");
			rd.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
