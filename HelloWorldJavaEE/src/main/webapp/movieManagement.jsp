<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
img {
  display: block;
  margin-left: auto;
  margin-right: auto;
}
* {
	box-sizing: border-box;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Float four columns side by side */
.column {
	float: center;
	width: 50%;
	padding: 10px 10px;
	
}

/* Remove extra left and right margins, due to padding */
.row {
	margin: 0 -5px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Responsive columns */
@media screen and (max-width: 600px) {
	.column {
		width: 100%;
		display: block;
		margin-bottom: 20px;
	}
}

/* Style the counter cards */
.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	padding: 16px;
	text-align: center;
	background-color: #f1f1f1;
}
.center {
  display: flex;
  justify-content: center;
  align-items: center;
  
}
</style>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Movie Review</title>
</head>
<body>

	<h3 class="text-center">List of Movies</h3>
	<hr>
	<div class="container text-left">
		<!-- Add new user button redirects to the register.jsp page -->
		<a href="<%=request.getContextPath()%>/AddMovie.jsp"
			class="center">Add New Movie</a>
	</div>
	<div class="container text-left">
		<!-- Add new user button redirects to the register.jsp page -->
		<a href="<%=request.getContextPath()%>/UserServlet/dashboard"
			class="center">See Users</a>
	</div>
	<br>

	<div>

		<div>


			<c:forEach var="movie" items="${listMovies}">

				<div class="container text-center">
					<div class="row">
						<div class="column">
							<div class="card">
								<div class="movie-title">
									<h2>Movie: ${movie.title}</h2>
								</div>

								<img class="movie-title" src="${movie.image}" width="500"
									height="500">

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
									<p>Release Date: ${movie.releasedate}
									<p>
								</div>

								<div class="movie-title">
									<p>Buy tickets: ${movie.ticketurl}
									<p>
								</div>


								<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
								<td><a href="edit?title=<c:out value='${movie.title}'
/>">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="delete?title=<c:out
value='${movie.title}' />">Delete</a></td>
							</div>
						</div>

					</div>
				</div>
				<br>



			</c:forEach>
		</div>
	</div>

</body>
</html>