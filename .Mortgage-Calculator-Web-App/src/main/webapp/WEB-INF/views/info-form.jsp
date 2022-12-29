<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>info form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="mortgage">
		<table>
			<tr>
				<td>Principal:</td>
				<td><form:input path="principal" /></td>
			</tr>
			<tr>
				<td>Down Payment:</td>
				<td><form:input path="downPayment" /></td>
			</tr>
			<tr>
				<td>Interest :</td>
				<td><form:input path="interest" /></td>
			</tr>
			<tr>
				<td>Loan Term :</td>
				<td><form:input path="loanTerm" /></td>
			</tr>
			<tr>
				<td />
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>