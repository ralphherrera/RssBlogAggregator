<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglibs.jsp"%>

<h1>Hello</h1>

<!-- Tab panes -->
<table class="table table-bordered table-hover tabled-striped" id="tableBlog" >
	<thead>
		<tr>
			<th>Source</th>
			<th>Date</th>
			<th>Title</th>
			<th>Description</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${items}" var="item">
			<tr>
				<td><c:out value="${item.blog.name}" /></td>
				<td><c:out value="${item.publishedDate}" /></td>
				<td><c:out value="${item.title}" /></td>
				<td><a href='<c:out value="${item.link}" />'> <c:out
							value="${item.description}" /></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
