<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list-pizzas.jsp</title>
</head>
<header>
    <h1></h1>
  </header>
<body>


	<h2>${order.customer.firstName}&nbsp;${order.customer.lastName}'s
		cart:</h2>
	<table>
		<c:forEach var="eachPizza" items="${order.pizzas}"
			varStatus="theCount">
			<tr>
				<td>Pizza ${theCount.count}</td>
				<td>Size:</td>
				<td>${eachPizza.size}</td>

				<td>Toppings:</td>
				<td>${eachPizza.topping }</td>
				
			</tr>
			<tr><td><form action="deletePizza" method="post">
						<input type="hidden" name="pizzaId" value="${theCount.count}" />
						<input type="submit" value="Delete pizza">
					</form></td></tr>
		</c:forEach>
	</table>
	
	<div>
	<form action="orderPizza" method="post">
		<input type="hidden" name="customerId" value="${order.customer.id}" />
		<input type="submit" value="Add more pizza">
	</form>
	</div>
	<form action="placeOrder" method="post">
		<input type="hidden" name="customerId" value="${order.customer.id}" />
		<input type="submit" value="Place Order">
	</form>






	
	 
	 
	 
</body>
</html>