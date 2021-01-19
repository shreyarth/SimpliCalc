<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<head>
<title>First Web Application</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>
	<div class="container">


		<form:form method="post" modelAttribute="task">
			<form:hidden path="id" />
			<fieldset class="form-group">
				<form:label path="taskName">Task Name</form:label>
				<form:input path="taskName" type="text" class="form-control"
					required="required" />
				<form:errors path="taskName" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="startDate">Start Date</form:label>
				<form:input path="startDate" type="text" class="form-control"
					required="required" />
				<form:errors path="startDate" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="endDate">End Date</form:label>
				<form:input path="endDate" type="text" class="form-control"
					required="required" />
				<form:errors path="endDate" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="description">Description</form:label>
				<form:input path="description" type="text" class="form-control"
					required="required" />
				<form:errors path="description" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="email">Email</form:label>
				<form:input path="email" type="email" class="form-control"
					required="required" />
				<form:errors path="email" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="severity">Severity</form:label>
				<form:errors path="severity" cssClass="text-warning" />
				<form:select path="severity">
					<option value="high">High</option>
					<option value="medium">Medium</option>
					<option value="low">Low</option>
				</form:select>
			</fieldset>
			<button type="submit" class="btn btn-danger">Add</button>
		</form:form>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
	<script>
		$('#startDate').datepicker({
			format : 'dd/mm/yyyy'
		});
		$('#endDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>

</body>
</html>