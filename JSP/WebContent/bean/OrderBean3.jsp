<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.text.*"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Using JavaBeans with JSP</title>
</head>
<body>
	<div align="center">
		<H3>Using JavaBeans with JSP</H3>
		<jsp:useBean id="order" class="com.eeit.bean.OrderBean" />
		<jsp:setProperty name="order" property="*"/>
		<table border="1">
			<tr><th>book no.<th>unit price<th>quantity<th>subTotal
			<tr align="right">
				<td><jsp:getProperty name="order" property="bookno" />
				<td>$<jsp:getProperty name="order" property="price" />
				<td><jsp:getProperty name="order" property="quantity" />
				<% NumberFormat f=NumberFormat.getInstance();
					if(f instanceof DecimalFormat){
						((DecimalFormat) f).applyPattern("#0.0");
					}
						out.write("<td>"+f.format(order.getSubTotal()));%>
		</table>
	</div>
</body>
</html>