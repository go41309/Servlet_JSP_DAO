package com.eeit.dao;

import java.sql.SQLException;
import java.util.List;

import com.eeit.bean.EmpBean;

public interface IEmpDao {
	public void add(EmpBean eb) throws SQLException;
	public void update(EmpBean eb) throws SQLException;
	public void delete(EmpBean eb) throws SQLException;
	public void findById(EmpBean eb) throws SQLException;
	public void connection() throws SQLException;
	public void close() throws SQLException;
	public List<EmpBean> querydb() throws SQLException;
}
