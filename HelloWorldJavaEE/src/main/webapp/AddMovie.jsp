<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="MovieServlet" method="post" >
Title: <input type ="text" name="title">
Story: <input type ="text" name="story">
Cast: <input type ="text" name="cast">
Genre: <input type ="text" name="genre">
Rating: <input type ="text" name="rating">
Duration: <input type ="text" name="duration">
Release Date: <input type ="text" name="date">
Buy: <input type ="text" name="buy">
Trailer: <input type ="text" name="trailer">
Image: <input type ="text" name="image">


<input type ="submit" value="Call Servlet"/>

</form>

</body>
</html>