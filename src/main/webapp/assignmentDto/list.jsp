<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phantruong
  Date: 06/05/2024
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List all employee</title>
</head>
<body>
<center>
    <h1>Employee Management</h1>
    <h2><a href="/employee?action=employee">back to main</a></h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List employee</h2></caption>
        <tr>
            <th>Employee ID</th>
            <th>Employee Name</th>
            <th>Project Name</th>
            <th>Start Date</th>
            <th>End Date</th>

            <c:forEach var="emp" items="${assignmentDtoList}">
        <tr>


            <td><c:out value="${emp.idEmployee}"/></td>
            <td><c:out value="${emp.employeeName}"/></td>
            <td><c:out value="${emp.projectName}"/></td>
            <td><c:out value="${emp.gender}"/></td>
            <td><c:out value="${emp.address}"/></td>
            <td><c:out value="${emp.idDepartment}"/></td>
            <td><c:out value="${emp.idPosition}"/> </td>
            <td>
                <a href="/employee?action=edit&id=${emp.id}">Edit</a>
                <a href="/employee?action=delete&id=${emp.id}">Delete</a>
            </td>
        </tr>
        </c:forEach>

    </table>
</div>


</body>
</html>
