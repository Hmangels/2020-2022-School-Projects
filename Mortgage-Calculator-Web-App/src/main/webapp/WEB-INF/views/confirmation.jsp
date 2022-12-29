<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
</head>
<style>
table, th, td {
  border:1px solid black;
}
</style>
<body>


<table style="width:40%">
  <tr>
    <th>Payment No.</th>
    <th>Principal Paid</th>
    <th>Interest Paid</th>
    <th>Outstanding Balance</th>
  </tr>
  <c:forEach var = "eachRow" items = "${amorList}">
  <tr>
    <td>${eachRow[0]}</td>
    <td>${eachRow[1]}</td>
    <td>${eachRow[2]}</td>
    <td>${eachRow[3]}</td>
  </tr>
  </c:forEach>
  
</table>
	
</body>
</html>