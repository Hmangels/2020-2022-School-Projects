<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list-orders.jsp</title>
</head>
<header>
	   
	<h1>Customer List</h1>
</header>
<body>

	<table>
		<tr>
			<th>ORDER ID</th>
			<th>Size</th>
			<th>Toppings</th>

		</tr>
		<c:forEach var="eachStudent" items="${orders}">
			<tr>
				<td>${eachStudent.id}</td>

				<td><c:forEach var="pizza" items="${eachStudent.pizzas}">
				Size:${pizza.size} Toppings: ${pizza.topping}
				<br />
					</c:forEach></td>
				<td>
					<form action="deleteOrder" method="post">
						<input type="hidden" name="orderId" value="${eachStudent.id}" />
						<input type="submit" value="Delete Order">
					</form>
			</tr>
		</c:forEach>
	</table>
	<div>
		<form action="list" method="get">
			<input type="submit" value="Back to customer List" />
		</form>
	</div>
	<form action="orderPizza" method="post">
		<input type="hidden" name="customerId" value="${customerId}" /> <input
			type="submit" value="Place another order" />
	</form>


</body>
</html>