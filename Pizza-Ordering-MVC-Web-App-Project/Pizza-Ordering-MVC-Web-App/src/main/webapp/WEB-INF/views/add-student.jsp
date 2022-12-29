<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add-customer.jsp</title>
</head>
<body>
<b>Please enter Customer info:</b>

	<form:form action="processStudent" modelAttribute="customer"
		method="post">
		<form:hidden path="id"/>
		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Street:</td>
				<td><form:input path="street" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td>State:</td>
				<td>
			<form:select path="state">
				<form:option value="MI">MI </form:option>
				<form:option value="OH">OH </form:option>
				<form:option value="CA">CA </form:option>
				<form:option value="TX">TX </form:option>
			</form:select>
			</td>
			</tr>
			<tr>
				<td>Zip:</td>
				<td><form:input path="zip" /></td>
			</tr>
			<tr>
			<td></td>
			<td><input type = "submit" value ="Save Customer" /></td>
			</tr>
		</table>

	</form:form>
<a href = ${pageContext.request.contextPath}/student/list>Back To Customer List</a>
</body>
</html>