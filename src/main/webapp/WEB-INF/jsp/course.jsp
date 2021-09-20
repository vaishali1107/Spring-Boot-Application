<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
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
	</div>
	<%@ include file="common/footer.jspf"%>