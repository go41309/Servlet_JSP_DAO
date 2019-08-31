<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String[] greetings=new String[4];
	greetings[0]="Hello World!";
	greetings[1]="Have a good time.";
	greetings[2]="Happy New Year!";
	greetings[3]="Nice to meet you.";
	
	ArrayList<String> names=new ArrayList<>();
	names.add("Kun Yeh");
	names.add("Bruce King");
	names.add("Leon Wu");
	
	request.setAttribute("greetings",greetings);
	request.setAttribute("names",names);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="<c:foreach/>的用法" /></title>
</head>
<body>
	<c:forEach items="${greetings}" var="item"> ${item}<br></c:forEach><p>
	<c:forEach items="${names}" var="item"> ${item}<br></c:forEach><p>
	<c:forEach items="${greetings}" var="item" begin="1" step="2"> ${item}<br></c:forEach><p>
	<c:forEach items="${names}" var="item" varStatus="s"><h4><c:out value="${item}"/>的四種屬性:</h4>
	index:${s.index}<br>
	count:${s.count}<br>
	first:${s.first}<br>
	last:${s.last}<br>
</c:forEach>
</body>
</html>