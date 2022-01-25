<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="col-sm-6 col-md-4 col-lg-3 movie-tile text-center">
	
	<div class="container">
			<h3 class="text-center">List of Movies</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/AddMovie.jsp"
					class="btn btnsuccess">Add New Movie</a>
			</div>
			
	<c:forEach var="movie" items="${listMovies}">
	
		<div class="movie-title">
			<h2>${movie.title}</h2>
		</div>
		
			<img class='movie-img' src="${movie.image}" width="220"
				height="342">

				<div class="movie-title">
					<h4>Synopsis: ${movie.story}</h4>
				</div>
				
				<div class="movie-title">
					<h5>Cast: ${movie.cast}</h5>
				</div>
				
				<div class="movie-title">
					<h6>Genre: ${movie.genre}</h6>
				</div>
				
				<div class="movie-title">
					<p>Rating: ${movie.rating} stars</p>
				</div>
				
				<div class="movie-title">
					<p>Duration: ${movie.duration}</p>
				</div>
				
				<div class="movie-title">
					<p>Release Date: ${movie.releasedate}<p>
				</div>
				
				<div class="movie-title">
					<p>Buy tickets: ${movie.ticketurl}<p>
				</div>
				
				<div class="movie-title">
					<p>Trailer: ${movie.ticketurl}<p>
				</div>
				


				<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
							<td><a href="edit?title=<c:out value='${movie.title}'
/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?title=<c:out
value='${movie.title}' />">Delete</a></td>
				
				</c:forEach>	
		</div>
		</div>
		
	
</body>
</html>