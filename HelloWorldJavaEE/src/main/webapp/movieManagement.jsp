<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="row">
		<div class="container">
			<h3 class="text-center">List of Movies</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/AddMovie.jsp"
					class="btn btnsuccess">Add New Movie</a>
			</div>
			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table">
				<thead>
					<tr>
						<th>Title</th>
						<th>Story</th>
						<th>Cast</th>
						<th>Genre</th>
						<th>Rating</th>
						<th>Duration</th>
						<th>Release Date</th>
						<th>Ticket Url</th>
						<th>Trailer Url</th>
						<th>Image</th>
					</tr>
				</thead>
				<!-- Pass in the list of users receive via the Servlet’s response to a loop
-->
				<tbody>
					<c:forEach var="movie" items="${listMovies}">
						<!-- For each user in the database, display their
information accordingly -->
						<tr>
							<td><c:out value="${movie.title}" /></td>
							<td><c:out value="${movie.story}" /></td>
							<td><c:out value="${movie.cast}" /></td>
							<td><c:out value="${movie.genre}" /></td>
							<td><c:out value="${movie.rating}" /></td>
							<td><c:out value="${movie.duration}" /></td>
							<td><c:out value="${movie.releasedate}" /></td>
							<td><c:out value="${movie.ticketurl}" /></td>
							<td><c:out value="${movie.trailerurl}" /></td>
							<td><c:out value="${movie.image}" /></td>
							
							<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
							<td><a href="edit?name=<c:out value='${movie.title}'
/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?title=<c:out
value='${movie.title}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>