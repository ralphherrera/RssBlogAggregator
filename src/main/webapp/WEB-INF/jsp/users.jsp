<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table class="table table-bordered table-hover tabled-striped">
	<thead>
		<tr>
			<th>#</th>
			<th>Email</th>
			<th>Firstname</th>
			<th>Lastname</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>
					<a href='<spring:url value="/users/${user.id}.html" />'>
						${user.email} </a>
				</td>
				<td>${user.firstname}</td>
				<td>${user.lastname}</td>
			</tr>
		</c:forEach>
	</tbody>

</table>