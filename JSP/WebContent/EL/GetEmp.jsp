<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>員工資料</title></head>
<body>
<div align="center">
<h2>員工資料</h2>
<jsp:useBean id="emp" scope="request" class="com.eeit.bean.EmpBean"/>
<table border="1">
	<tr><td>員工編號
	<td>${emp.empno}
	<tr><td>姓名
	<td>${emp.ename}
	<tr><td>到職日
	<td>${emp.hiredate}
	<tr><td>薪水
	<td>${emp.salary}
	<tr><td>部門編號
	<td>${emp.deptno}
	<tr><td>職稱
	<td>${emp.title}
</table>
</div></body>
</html>