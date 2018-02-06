<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../layout/taglibs.jsp"%>
<table class="table table-bordered table-hover tabled-striped">

	<c:if test="${param.success eq true}">
		<br />
		<div class="alert alert-danger">
			User has been <strong>Deleted</strong>
		</div>
	</c:if>
	<thead>
		<tr>
			<th>#</th>
			<th>Email</th>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Date Registered</th>
			<th>---</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td><a href='<spring:url value="/users/${user.id}.html" />'>
						${user.email} </a></td>
				<td>${user.firstname}</td>
				<td>${user.lastname}</td>
				<td>${user.dateRegistered}</td>

				<c:choose>
					<c:when test="${loggedInUser eq user.email}">
						<td>---</td>
					</c:when>
					<c:otherwise>
						<td><a
							href='<spring:url value="/user/remove/${user.id}.html" />'
							class='btn btn-outline-danger btn-sm'>Delete user</a></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
	</tbody>

</table>