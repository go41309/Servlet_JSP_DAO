package com.eeit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eeit.bean.EmpBean;

public class EmpDaoImpl implements IEmpDao {
	private Connection conn;
	String addstr = "Insert into employee(empno,ename,hiredate,salary,deptno,title)Values(?,?,?,?,?,?)";
	String updstr = "Update employee set ename=?, hiredate=?, salary=?, deptno=?, title=? Where empno=?";
	String delstr = "Delete from employee where empno=?";
	String qrystr = "SELECT * FROM employee where empno=?";
	String qrydb = "SELECT * FROM employee";
	
	@Override
	public void add(EmpBean eb) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(addstr);
		stmt.setString(1, eb.getEmpno());
		stmt.setString(2, eb.getEname());
		stmt.setString(3, eb.getHiredate());
		stmt.setString(4, eb.getSalary());
		stmt.setString(5, eb.getDeptno());
		stmt.setString(6, eb.getTitle());
		stmt.execute();
		stmt.close();
	}

	@Override
	public void update(EmpBean eb) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(updstr);
		stmt.setString(1, eb.getEname());
		stmt.setString(2, eb.getHiredate());
		stmt.setString(3, eb.getSalary());
		stmt.setString(4, eb.getDeptno());
		stmt.setString(5, eb.getTitle());
		stmt.setString(6, eb.getEmpno());
		
	}

	@Override
	public void delete(EmpBean eb) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(delstr);
		stmt.setString(1, eb.getEmpno());
	}

	@Override
	public void findById(EmpBean eb) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(qrystr);
		stmt.setString(1, eb.getEmpno());
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			eb.setEmpno(rs.getString("empno"));
			eb.setEname(rs.getString("ename"));
			eb.setHiredate(rs.getString("hiredate"));
			eb.setSalary(rs.getString("salary"));
			eb.setDeptno(rs.getString("deptno"));
			eb.setTitle(rs.getString("title"));
		}
	}

	@Override
	public List<EmpBean> querydb() throws SQLException {
		List<EmpBean> emps = new ArrayList<EmpBean>();
		PreparedStatement stmt = conn.prepareStatement(qrydb);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			EmpBean eb = new EmpBean();
			eb.setEmpno(rs.getString("empno"));
			eb.setEname(rs.getString("ename"));
			eb.setHiredate(rs.getString("hiredate"));
			eb.setSalary(rs.getString("salary"));
			eb.setDeptno(rs.getString("deptno"));
			eb.setTitle(rs.getString("title"));
			emps.add(eb);
		}
		rs.close();
		stmt.close();
		return emps;
	}

	@Override
	public void connection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=servdb";
			conn = DriverManager.getConnection(connUrl, "sa", "P@ssw0rd");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}