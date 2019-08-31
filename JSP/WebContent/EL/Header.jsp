<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
</head>
<body>
<!-- 寫法1，用[] -->
主機名:${header["host"] }<br>
接受的言語:${header["accept-language"]}<br>
使用的瀏覽器與作業系統:${header["user-agent"]}<br>

<%-- 寫法2，用「.」
主機名:${header.host}<br>
接受的言語:${header.accept-language}<br>  有「-」不可以用「.」
使用的瀏覽器與作業系統:${header.user-agent}<br>  有「-」不可以用「.」
 --%>
</body>
</html>