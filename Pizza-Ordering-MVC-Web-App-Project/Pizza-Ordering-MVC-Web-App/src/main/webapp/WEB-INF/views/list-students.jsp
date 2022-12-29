<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list-customer.jsp</title>
</head>
<header>
    <h1>Customer List</h1>
  </header>
<body>
	
	<table>
	<%-- First Name - Last Name - Street - City - State - Zip Code --%>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Street</th>
			<th>City</th>
			<th>State</th>
			<th>Zip Code</th>
		</tr>
		<c:forEach var="eachStudent" items="${customers}">
		
	<%--<c:url var = "updateLink" value = "/student/updateStudent">
		<c:param name= "customerId" value ="${eachStudent.id}" />
		</c:url>
		<c:url var = "deleteLink" value = "/student/deleteStudent">
		<c:param name= "studentId" value ="${eachStudent.id}" />
		</c:url>
		<c:url var = "orderHistoryLink" value = "/student/orderHistory">
		<c:param name= "customerId" value ="${eachStudent.id}" />
		</c:url>--%>

			<tr>
				<td>${eachStudent.firstName}</td>
				<td>${eachStudent.lastName}</td>
				<td>${eachStudent.street}</td>
				<td>${eachStudent.city}</td>
				<td>${eachStudent.state}</td>
				<td>${eachStudent.zip}</td>


				<td><form:form action="updateCustomer" method="post">
						<input type="hidden" name="customerId" value="${eachStudent.id}" />
						<input type="submit" value="Update Customer Info" />
					</form:form></td>
				<td><form:form action="orderHistory" method="post">
						<input type="hidden" name="customerId" value="${eachStudent.id}" />
						<input type="submit" value="Order History" />
					</form:form></td>
				<td><form:form action="orderPizza" modelAttribute="newPizza"
						method="post">
						<input type="hidden" name="customerId" value="${eachStudent.id}" />
						<input type="submit" value="Order Pizza" />
					</form:form></td>
			</tr>
		</c:forEach>
	</table>
	<form action="addStudent" method="post"> <%-- Replace addStudent with Add New Customer --%>
		<input type="submit" value="Add New Customer" />
	</form>
</body>
</html>