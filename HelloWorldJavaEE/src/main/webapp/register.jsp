<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="RegisterServlet" method="post">
	
	
	<div class="input">
                <div class="input-addon">
                    <i class="material-icons">Enter Username</i>
                </div>
                <input id="username" placeholder="Username" type="text" name="userName" required class="validate" autocomplete="off">
            </div>
	
	
	<div class="input">
                <div class="input-addon">
                    <i class="material-icons">Enter Email</i>
                </div>
                <input id="email" placeholder="Email" type="email" name="email" required class="validate" autocomplete="off">
            </div>

           

            <div class="input">
                <div class="input-addon">
                    <i class="material-icons">Enter Password</i>
                </div>
                <input id="password" placeholder="Password" type="password"  name="password" required class="validate" autocomplete="off">
            </div>

       

           
			
			<select name="gender">
			<option>Male</option>
			<option>Female</option>
			

		</select> <input type="submit" value="Call Servlet" />

	</form>

</body>
</html>