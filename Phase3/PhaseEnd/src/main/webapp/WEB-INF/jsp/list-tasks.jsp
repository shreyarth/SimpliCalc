<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>

<head>
<title>Tasks for ${name}</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="container">
		<table class="table table-striped">
			<caption>Your tasks are</caption>
			<thead>
				<tr>
					<th>Task Name</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Description</th>
					<th>Email</th>
					<th>Severity</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tasks}" var="task">
					<tr>
						<td>${task.taskName}</td>
						<td><fmt:formatDate value="${task.startDate}"
								pattern="dd/MM/yyyy" /></td>
						<td><fmt:formatDate value="${task.endDate}"
								pattern="dd/MM/yyyy" /></td>
						<td>${task.description}</td>
						<td>${task.email}</td>
						<td>${task.severity}</td>
						<td><a type="button" class="btn btn-success"
							href="/updatetask?id=${task.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/deletetask?id=${task.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/addtask">Add a Task</a>
		</div>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>