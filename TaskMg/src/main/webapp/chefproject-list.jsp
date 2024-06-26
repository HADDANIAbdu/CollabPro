<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.google.com" class="navbar-brand"> CollabPro </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">ChefsProjects</a></li>
				<li><a href="<%=request.getContextPath()%>/projects"
					class="nav-link">Projects</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Chefs Projects</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New ChefProject</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Country</th>
						<th>Department</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="Chef_pr" items="${listChefProject}">

						<tr>
							<td><c:out value="${Chef_pr.id}" /></td>
							<td><c:out value="${Chef_pr.name}" /></td>
							<td><c:out value="${Chef_pr.email}" /></td>
							<td><c:out value="${Chef_pr.country}" /></td>
							<td><c:out value="${Chef_pr.department}" /></td>
							<td><a href="edit?id=<c:out value='${Chef_pr.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${Chef_pr.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>