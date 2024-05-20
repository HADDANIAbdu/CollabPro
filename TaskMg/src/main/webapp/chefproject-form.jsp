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
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${Chef_pr != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${Chef_pr == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${Chef_pr != null}">
            			Edit ChefProject
            		</c:if>
						<c:if test="${Chef_pr == null}">
            			Add New ChefProject
            		</c:if>
					</h2>
				</caption>

				<c:if test="${Chef_pr != null}">
					<input type="hidden" name="id" value="<c:out value='${Chef_pr.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>ChefProject Name</label> <input type="text"
						value="<c:out value='${Chef_pr.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>ChefProject Email</label> <input type="text"
						value="<c:out value='${Chef_pr.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>ChefProject Country</label> <input type="text"
						value="<c:out value='${Chef_pr.country}' />" class="form-control"
						name="country">
				</fieldset>
				<fieldset class="form-group">
					<label>ChefProject Department</label> <input type="text"
						value="<c:out value='${Chef_pr.department}' />" class="form-control"
						name="department">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>