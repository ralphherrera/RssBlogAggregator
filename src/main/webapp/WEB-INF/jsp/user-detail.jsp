<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglibs.jsp"%>

${user.email}

<c:forEach items="${user.blogs}" var="blog">
	<h3>${blog.url}</h3>
	<h4>${blog.name}</h4>
	<table class="table table-bordered table-hover tabled-striped">
		<thead>
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th>Date</th>
				<th>Link</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${blog.items}" var="item">
				<tr>
					<td>${item.title}</td>
					<td>${item.description}</td>
					<td>${item.publishedDate}</td>
					<td>${item.link}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:forEach>