<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders</title>
</head>
<body>
	<h1>Orders</h1>
	<p>Screen for Orders</p>


	<table>
		<tr>
			<h3>
				Total Orders :
				<form:form method="POST" action="/PizzaOrder/getTotalOrders">
					<table>
						<tr>
							<td><input type="submit" value="TotalOrders" /></td>
						</tr>
					</table>
				</form:form>
			</h3>
		</tr>
		<br>
		<br>
		<tr>
			<h3>
				Total Italian Orders :
				<form:form method="POST"
					action="/PizzaOrder/getTotalItalianPizzaOrders">
					<table>
						<tr>
							<td><input type="submit" value="Italian" /></td>
						</tr>
					</table>
				</form:form>
			</h3>
			<br>
			<br>
		</tr>
		<h3>
			Total Indian Orders :
			<form:form method="POST" action="/PizzaOrder/getTotalIndianPizzaOrders">
				<table>
					<tr>
						<td><input type="submit" value="Indian" /></td>
					</tr>
				</table>
			</form:form>
		</h3>
		<br>
		</tr>
	</table>
	<br>
	<br>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>5 Latest Orders</th>
			<th>    </th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.pizza_id}</td>
				<td>${list.crust}</td>
				<td>${list.toppingstype}</td>
				<td>${list.quantity}</td>
				<td>${list.price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>