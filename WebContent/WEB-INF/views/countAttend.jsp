<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Attendence</h1>  

	<br>
<table border="2" width="70%" cellpadding="2">  
<tr><th>contact</th><th>Name</th><th>Attendance</th></tr>  
     <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.contact}</td>  
   <td>${emp.name}</td>  
  
  <td> ${emp.attendace }
   </td>
   </tr>  
   </c:forEach>
   
   </table>  
    

</body>
</html>