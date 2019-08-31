<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.ArrayList, com.eeit.bean.EmpBean"%>
<%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>員工資料</title></head>
<body>
<div align="center">
<h2>員工資料</h2>
<form method="post" action="../InsertEmp"><input type="submit" value="新增資料"></form><br>
<form method="post" action="../QryEmp"><input type="submit" value="查詢資料"></form><br>
<table border="1">
<tr bgcolor="#a8fefa"><th>員工編號<th>姓名<th>到職日<th>薪水<th>部門編號<th>職稱<th>刪除<th>修改
	<% ArrayList<EmpBean> al=(ArrayList<EmpBean>)request.getAttribute("emps");
	for(int i=0;i<al.size();i++){%>
	<tr><td><%=(al.get(i)).getEmpno()%>
	<td><%=(al.get(i)).getEname()%>
	<td><%=(al.get(i)).getHiredate()%>
	<td><%=(al.get(i)).getSalary()%>
	<td><%=(al.get(i)).getDeptno()%>
	<td><%=(al.get(i)).getTitle()%>
	<td><form method="post" action="../DelEmp"><input type="submit" value="刪除"></form>
	<td><form method="post" action="../ToUptEmp"><input type="submit" value="修改"></form>
	<%}%>
</table>
<h3>共<%=al.size() %>筆員工資料</h3>
</div></body>
</html>