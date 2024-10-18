<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><!--form tag  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insurance Report</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="pb-3 pt-3 container">
		<h1>Insurance Report</h1>

		<form:form action="search" modelAttribute="search" method="POST">

			<tr>
				<td>Plans Name:</td>
				<td><form:select path="plansName">
						<form:option value="">-Select-</form:option>
						<form:options items="${names}" />
					</form:select></td>

				<td>Plans Status:</td>
				<td><form:select path="plansStatus">
						<form:option value="">-Select-</form:option>
						<form:options items="${status}" />
					</form:select></td>

				<td>Gender:</td>
				<td><form:select path="citizenGender">
						<form:option value="">-Select-</form:option>
						<form:option value="Male">Male</form:option>
						<form:option value="Fe-Male">Fe-Male</form:option>
					</form:select></td>
			</tr>

			<br />
			<br />

			<tr>
				<td>Start Date:</td>
				<td><form:input path="startDate" type="Date" /></td>

				<td>End Date:</td>
				<td><form:input path="endDate" type="Date" /></td>

			</tr>
			<br />
			<br />

			<tr>
				<a class="btn btn-secondary" href="/">Reset</a>
				<form:button class="btn btn-primary">Search</form:button>
			</tr>

			<hr />

			<table class="table table-striped">
				<thead>
					<tr>
						<th>Sr.No</th>
						<th>Citizen Name</th>
						<th>Citizen Gender</th>
						<th>Citizen phone</th>
						<th>Plan Name</th>
						<th>Plan Status</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Benefit Amount</th>
					</tr>

				</thead>
				<tbody>
					<c:forEach items="${plansList}" var="plans" varStatus="index">
						<tr>
							<td>${index.count}</td>
							<td>${plans.citizenName}</td>
							<td>${plans.citizenGender}</td>
							<td>${plans.citizenPhone}</td>
							<td>${plans.plansName}</td>
							<td>${plans.plansStatus}</td>
							<td>${plans.startDate}</td>
							<td>${plans.endDate}</td>
							<td>${plans.benefitAmount}</td>
						</tr>
					</c:forEach>

					<tr>
						<c:if test="${empty plansList}">
							<td colspan="9" style="text-align: center">No Data Found</td>
						</c:if>
					</tr>

				</tbody>
			</table>

			<hr />

			<tr>
				<td>Export:</td>
				<td><a href="/excel">Excel</a></td>
				<td><a href="/pdf">Pdf</a></td>
			</tr>




		</form:form>


	</div>







	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

</body>
</html>