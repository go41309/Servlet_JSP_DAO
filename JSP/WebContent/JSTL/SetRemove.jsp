<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	session.setAttribute("user", "pan");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="<c:Remove/>的用法" /></title>
</head>
<body>
	<c:set var="number" value="10" />
	<c:set var="number" scope="request">20</c:set>
	<c:set var="number" value="30" scope="session"/>
	
	初始設定<br>
	pageScope.number:<c:out value="${pageScope.number}" default="No value"/><br>
	requestScope.number:<c:out value="${requestScope.number}" default="No value"/><br>
	sessionScope.number:<c:out value="${sessionScope.number}" default="No value"/><br>

	<c:out value='<c:remove var="number" scope="request"/>後'/><br>
	<c:remove var="number" scope="request"/>
	pageScope.number:<c:out value="${pageScope.number}" default="No value"/><br>
	requestScope.number:<c:out value="${requestScope.number}" default="No value"/><br>
	sessionScope.number:<c:out value="${sessionScope.number}" default="No value"/><br>
	
	<c:out value='<c:remove var="number" scope="request"/>後'/><br>
	<c:remove var="number"/>
	pageScope.number:<c:out value="${pageScope.number}" default="No value"/><br>
	requestScope.number:<c:out value="${requestScope.number}" default="No value"/><br>
	sessionScope.number:<c:out value="${sessionScope.number}" default="No value"/><br>
	
</body>
</html>