<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- to enable support for jstl tags -->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>List Customers</title>
	
	<!-- Reference our style sheet -->
	
	<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
<!--List Customers - coming soon-->
<div id="wrapper">
	<div id="header">
		<h2>CRM - Customer Relationship Manager</h2>
		<!-- ${pageContext.request.contextPath} -->
	</div>
</div>
<div id="container">
	<div id="content">
		<!-- put new button: add customer -->
		<input type="button" value="Add Customer" 
		onCLick="window.location.href='showFormForAdd'; return false;"
		class="add-button"/>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			<!-- added taglib directive to enable jstl tags support -->
			<c:forEach var="tempCustomer" items="${customers}">
			
				<!-- Construct and update link with customer Id -->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id}"></c:param>
				</c:url>
				
				<!-- Construct and delete link with customer Id -->
				<c:url var="deleteLink" value="/customer/deleteCustomer">
					<c:param name="customerId" value="${tempCustomer.id}"></c:param>
				</c:url>
				<tr>
					<td>${tempCustomer.firstName}</td>
					<td>${tempCustomer.lastName}</td>
					<td>${tempCustomer.email}</td>
					<td>
						<!-- Display the update link -->
						<a href='${updateLink}'>Update</a>
						|
						<a href='${deleteLink}' onClick="return confirm('Are you sure you want to delete this customer?');">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</div>
</body>
</html>
