<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglibs.jsp"%>
${user.email}
<br />
<br />
<jsp:include page="../jsp/add-blog.jsp"></jsp:include>
<br />
<br />

<ul class="nav nav-tabs" role="tablist">
	<c:forEach items="${user.blogs}" var="blog">
		<li class="nav-item"><a class="nav-link" data-toggle="tab"
			href="#blog_${blog.id}" role="tab">${blog.name}</a></li>
	</c:forEach>
</ul>

<!-- Tab panes -->
<div class="tab-content">
	<c:forEach items="${user.blogs}" var="blog">
		<div class="tab-pane" id="blog_${blog.id}" role="tabpanel">
			<br /> <a href='<spring:url value="/blog/remove/${blog.id}.html" />'
				class='btn btn-outline-danger btn-sm'>Delete Blog</a> <br /> <br />
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
		</div>
	</c:forEach>
</div>