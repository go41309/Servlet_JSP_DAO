<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="emp" class="com.eeit.bean.EmpBean" scope="request"/>
<jsp:setProperty name="emp" property="ename" value="pan"/>
<jsp:setProperty name="emp" property="salary" value="56000"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AccessBean</title>
</head>
<body>
<h3>寫法1</h3>
姓名:${emp.ename}<br>
薪水:${emp.salary}<br>
<h3>寫法2</h3>
姓名:${emp["ename"]}<br>
薪水:${emp["salary"]}<br>
薪水:${emp['salary']}<br>
</body>
</html>