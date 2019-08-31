<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="<c:choose/>的用法" /></title>
</head>
<body>
	<c:choose>
	<c:when test="${param.password == '1234'}">
		${param.user} Welcome!
	</c:when>
	<c:otherwise>密碼錯誤，請重新輸入!
	</c:otherwise>
	</c:choose>
</body>
</html>