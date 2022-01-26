<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Management Application</title>
 <link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Movie Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/MovieDetailsServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${movie != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${movie == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${movie != null}">
Edit Movie
</c:if>
						<c:if test="${movie == null}">
Add New Movie
</c:if>
					</h2>
				</caption>
				<c:if test="${movie != null}">
					<input type="hidden" name="oriTitle"
						value="<c:out
value='${movie.title}' />" />
				</c:if>
				
				
				<fieldset class="form-group">
					<label>Movie Title</label> <input type="text"
						value="<c:out
value='${movie.title}' />" class="form-control"
						name="title" required="required">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Story</label> <input type="text"
						value="<c:out
value='${movie.story}' />" class="form-control"
						name="story">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Cast</label> <input type="text"
						value="<c:out
value='${movie.cast}' />" class="form-control"
						name="cast">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label> Genre</label> <input type="text"
						value="<c:out
value='${movie.genre}' />" class="form-control"
						name="genre">
				</fieldset>
				
							<fieldset class="form-group">
					<label> Rating</label> <input type="text"
						value="<c:out
value='${movie.rating}' />" class="form-control"
						name="rating">
				</fieldset>
				
							<fieldset class="form-group">
					<label> Duration</label> <input type="text"
						value="<c:out
value='${movie.duration}' />" class="form-control"
						name="duration">
				</fieldset>
				
							<fieldset class="form-group">
					<label> Release Date </label> <input type="text"
						value="<c:out
value='${movie.releasedate}' />" class="form-control"
						name="releasedate">
				</fieldset>
				
							<fieldset class="form-group">
					<label> Ticket Link</label> <input type="text"
						value="<c:out
value='${movie.ticketurl}' />" class="form-control"
						name="ticketurl">
				</fieldset>
				
							<fieldset class="form-group">
					<label> Trailer Link</label> <input type="text"
						value="<c:out
value='${movie.trailerurl}' />" class="form-control"
						name="trailerurl">
				</fieldset>
				
							<fieldset class="form-group">
					<label> Movie Image</label> <input type="text"
						value="<c:out
value='${movie.image}' />" class="form-control"
						name="image">
				</fieldset>
				
				
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>


</body>
</html>