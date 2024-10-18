<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Edit Employee</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Edit Employee</h2>
    <form action="EmployeeServlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${employee.id}">

        Name: <input type="text" name="name" value="${employee.name}" required><br>
        Email: <input type="email" name="email" value="${employee.email}" required><br>
        Department: <input type="text" name="department" value="${employee.department}" required><br>
        Salary: <input type="number" name="salary" value="${employee.salary}" step="0.01" required><br>

        <button type="submit">Update</button>
    </form>
</body>
</html>
