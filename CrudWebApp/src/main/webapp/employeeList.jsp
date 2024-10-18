
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Employee List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.email}</td>
                <td>${employee.department}</td>
                <td>${employee.salary}</td>
                <td>
                    <a href="EmployeeServlet?action=edit&id=${employee.id}">Edit</a> |
                    <a href="EmployeeServlet?action=delete&id=${employee.id}" 
                       onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="index.html">Add New Employee</a>
</body>
</html>
