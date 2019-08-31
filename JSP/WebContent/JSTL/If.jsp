<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="<c:if/>的用法" /></title>
</head>
<body>
	<c:if test = "${param.password == '1234'}" var="condition">
	${param.user}歡迎光臨！
	</c:if><br>
	執行結果為${condition}
</body>
</html>