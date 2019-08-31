<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<%
	ArrayList<String> greetings = new ArrayList<>();
	greetings.add("Hello World");
	greetings.add("Have a nice day");
	pageContext.setAttribute("Greetings",greetings);
	
	HashMap<String, String> tel=new HashMap<>();
	tel.put("John","0912345678");
	tel.put("Bruce","02-2222222");
	tel.put("Bruce","02-66316622");
	pageContext.setAttribute("mobile",tel);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PageContext</title>
</head>
<body>
${Greetings[0] }<br>
${Greetings[1] }<br>
${Greetings[2] }<br>
The mobile of John:${mobile.John }<br>
The mobile of Bruce:${mobile['Bruce'] }<br>
The mobile of John:${mobile["Tom"] }<br>

<!-- expra-a null -->
${Greeti[0] }<br>

<!-- expra-b null -->

</body>
</html>