<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<script>
     function validForm(){
              var email = document.myForm.email.value;
              var password = document.myForm.password.value;

               if(email == null || email == ""){
           	   alert("email can't be null ");
           	   
                  return false;
           	   }

               else if(password == null || password == "" || password.length < 6){
                       alert(" invalid password ")
                       return false;
                   }
         }
 

     </script>

</body>
<center>
	<h3>Emplyee Login</h3>
	<body>

		<form name="myForm" action="/EmployeeManagement/loginSuccess"
			method="post" onsubmit="return validForm()">
			<table>

				<tr>
					<td>Email</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<td><input type="submit" value="Login"></td>
				</tr>


			</table>
		</form>

	</body>
</center>





</html>