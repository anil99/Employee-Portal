<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
    <center><h1>Employee Registration</h1></center>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<script>
		function validForm() {
			 var email = document.myForm.email.value;
			
			 var name = document.myForm.name.value;
			var salary = document.myForm.salary.value;
			var contact = document.myForm.contact.value;
			var designation = document.myForm.designation.value;
			var password = document.myForm.password.value;

			if (name == null || name == "") {
				alert("Name can't be blank");
				return false;
			} else if (email == null || email == "") {
				alert("email can't be null ")
				return false;
			} else if (designation == null || designation == "") {
				alert("invalid designation")
				return false;
			}

			else if (contact == null || contact == "") {
				alert("invalid contact")
				return false;
			}

			else if (salary == null || salary == "") {
				alert("invalid salary")
				return false;
			}

			else if (password == null || password == "" || password.length <6) {
				alert("invalid password")
				return false;
			}

			
		}
	</script>
<body>
<center>
	<form name="myForm" action="/EmployeeManagement/registerSuccess"
		method="post" onsubmit="return validForm()">
		<table>

			<tr>
				<td>User Name</td>
				<td><input type="text" name="name"></td>
			</tr>

			<tr>
				<td>password</td>
				<td><input type="text" name="password"></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>


			<tr>
				<td>contact</td>
				<td><input type="text" name="contact"></td>
			</tr>

			<tr>
				<td>salary</td>
				<td><input type="text" name="salary"></td>
			</tr>

			<tr>
				<td>designation</td>
				<td><input type="text" name="designation"></td>
			</tr>

			<tr>
				<td>Country</td>
				<td><select name="country">
						<option value="India">India</option>
						<option value="US">US</option>
						<option value="Other">Other</option>
				</select></td>
			</tr>

			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>


		</table>
	</form>
</center>
</body>
</html>