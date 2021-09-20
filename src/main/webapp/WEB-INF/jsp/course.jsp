<html>
<!-- JSTL has tags which we can use -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>COURSE DETAILS for ${name}</title>
</head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<body>
<body>
	<div class="container">
		<table class="table table-striped">
			<caption>Your Courses are</caption>
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it Done?</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${courses}" var="course">
					<tr>
						<td>${course.desc}</td>
						<td>${course.targetDate}</td>
						<td>${course.done}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-course?id=${course.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-course?id=${course.id}">Delete</a></td>
							
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-course">Add a Course</a>
		</div>

		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>

</body>

</html>