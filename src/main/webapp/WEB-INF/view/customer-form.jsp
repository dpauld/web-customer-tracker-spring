<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
    prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add a new Customer</title>
	<!-- Reference our style sheet -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
			<!-- ${pageContext.request.contextPath} -->
		</div>
	</div>
	<div id="container">
		<h3>Save customer</h3>
		<form:form modelAttribute="customer" action="saveCustomer" method="POST">
			
		<!-- Add a hidden tag for specifying path for customer id, so that spring knows which id to use and spring can use its setId for updating the customer -->
			<form:hidden path="id"></form:hidden>
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" placeholder="John"/></td>
					</tr>
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" placeholder="Doe"></form:input></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" placeholder="john@gmail.com"></form:input></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"></input></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
	<div style="clear; both"></div>
	<p>
		<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
	</p>
</body>
</html>