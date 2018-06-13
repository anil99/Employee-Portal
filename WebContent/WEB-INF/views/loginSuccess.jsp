<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<table>

			<tr>
				<td>User Name</td>
				<td>${user.name}</td>
			</tr>

			<tr>
				<td>Email</td>
				<td>${user.email}</td>
			</tr>


			<tr>
				<td>Salary</td>
				<td>${user.salary}</td>
			</tr>

			<tr>
				<td>contact</td>
				<td>${user.contact}</td>
			</tr>

			<tr>
				<td>Designation</td>
				<td>${user.designation}</td>
			</tr>
			
			
			<tr>
				<td>Attendance</td>
				<td>${user.attendace}</td>
			</tr>

		</table>
	</center>
	
	 <a href = "/EmployeeManagement/employeeEdit/">Edit Details</a>

</body>
</html>