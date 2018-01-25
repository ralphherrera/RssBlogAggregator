<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table>
	<thead></thead>
	<tbody>
		<tr>
			<td>
				<c:forEach items="${users}" var="user">
				<h4>
				${user.id} <br>
				${user.firstname} <br>
				${user.lastname} <br>
				${user.email} <br>
				${user.blogs} <br>
				${user.firstname} <br>
				</h4>
				</c:forEach>
			
			</td>

		</tr>

	</tbody>

</table>