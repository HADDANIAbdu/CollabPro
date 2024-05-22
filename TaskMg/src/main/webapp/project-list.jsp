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
		<div class="container">
			<h3 class="text-center">List of Projects</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new_pr" class="btn btn-success">Add
					New Project</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Project ID</th>
						<th>Title</th>
						<th>Description</th>
						<th>Starting date</th>
						<th>Ending date</th>
						<th>Duration</th>
						<th>Chef ID</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pr" items="${listProject}">

						<tr>
							<td><c:out value="${pr.pr_id}" /></td>
							<td><c:out value="${pr.title}" /></td>
							<td><c:out value="${pr.description}" /></td>
							<td><c:out value="${pr.start_date}" /></td>
							<td><c:out value="${pr.end_date}" /></td>
							<td><c:out value="${pr.duration}" /></td>
							<td><c:out value="${pr.chef_id}" /></td>
							<td><a href="edit_pr?pr_id=<c:out value='${pr.pr_id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete_pr?pr_id=<c:out value='${pr.pr_id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>