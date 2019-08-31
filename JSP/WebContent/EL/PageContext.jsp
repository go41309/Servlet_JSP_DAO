<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PageContext</title>
</head>
<body>
<H3>EL隱含物件pageContext</H3>
\${pageContext.request.queryString}:${pageContext.request.queryString}<br>
\${pageContext.request.requestURL}:${pageContext.request.requestURL}<br>
\${pageContext.request.contextPath}:${pageContext.request.contextPath}<br>
\${pageContext.request.method}:${pageContext.request.method}<br>
\${pageContext.request.protocol}:${pageContext.request.protocol}<br>
\${pageContext.request.remoteUser}:${pageContext.request.remoteUser}<br>
\${pageContext.request.remoteAddr}:${pageContext.request.remoteAddr}<br>
\${pageContext.session.id}:${pageContext.session.id}<br>
\${pageContext.servletContext.serverInfo}:${pageContext.servletContext.serverInfo}<br>

</body>
</html>