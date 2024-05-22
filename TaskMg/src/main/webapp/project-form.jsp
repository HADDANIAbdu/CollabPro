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
				<a href="https://www.javaguides.net" class="navbar-brand"> CollabPro </a>
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${project != null}">
					<form action="update_pr" method="post">
				</c:if>
				<c:if test="${project == null}">
					<form action="insert_pr" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${project != null}">
            			Edit Project
            		</c:if>
						<c:if test="${project == null}">
            			Add New Project
            		</c:if>
					</h2>
				</caption>

				<c:if test="${project != null}">
					<input type="hidden" name="pr_id" value="<c:out value='${project.pr_id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Project Chef ID</label> <input type="text"
						value="<c:out value='${project.chef_id}' />" class="form-control"
						name="chef_id" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Project Title</label> <input type="text"
						value="<c:out value='${project.title}' />" class="form-control"
						name="title" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Project Description</label> <input type="text"
						value="<c:out value='${project.description}' />" class="form-control"
						name="description">
				</fieldset>

				<fieldset class="form-group">
					<label>Project Starting Date</label> <input type="Date"
						value="<c:out value='${project.start_date}' />" class="form-control"
						name="start_date">
				</fieldset>
				<fieldset class="form-group">
					<label>Project Ending Date</label> <input type="Date"
						value="<c:out value='${project.end_date}' />" class="form-control"
						name="end_date">
				</fieldset>
				<fieldset class="form-group">
					<label>Project Duration</label> <input type="text"
						value="<c:out value='${project.duration}' />" class="form-control"
						name="duration">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>