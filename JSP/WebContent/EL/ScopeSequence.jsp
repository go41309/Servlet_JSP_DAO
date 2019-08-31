<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%session.setAttribute("user","pan");
  pageContext.setAttribute("customer","pan1");
  request.setAttribute("customer","pan2");
  session.setAttribute("customer","pan3");
  application.setAttribute("customer","pan4");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scope</title>
</head>
<body>
user 屬性的值:${user}<p>
customer 屬性的值:${customer}<p>
pageContext.customer=${pageScope.customer}<p>
repuest.customer=${requestScope.customer}<p>
session.customer=${sessionScope.customer}<p>
application.customer=${applicationScope.customer}<p>
</body>
</html>