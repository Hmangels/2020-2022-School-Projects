<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add-to-order.jsp</title>
</head>
<body>
<b></b>

	<form:form action="addPizza" modelAttribute="newPizza">
		
		
		
		<table>

			<tr>
				<td>Size:</td>
				<td><form:select path="size">
						<form:option value="Small">Small</form:option>
						<form:option value="Medium">Medium </form:option>
						<form:option value="Large">Large</form:option>
					</form:select></td>
			</tr>
			<tr>
			<td>Toppings:</td>
				<td><form:checkboxes path="topping" items="${toppingsList}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add pizza to cart" /></td>
			</tr>
		</table>

	</form:form>>
</body>
</html>