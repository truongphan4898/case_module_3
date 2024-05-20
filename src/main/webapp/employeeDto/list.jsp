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
        <caption><h2>List salary</h2></caption>
        <tr>

            <th>EmployeeID</th>
            <th>Employee Name</th>
            <th>Position Name</th>
            <th>Department Name</th>
            <c:forEach var="emp" items="${employeeDtoList}">
        <tr>


            <td><c:out value="${emp.id}"/></td>
            <td><<c:out value="${emp.employeeName}"/></td>
             <td><c:out value="${emp.positionName}"/> </td>
            <td><c:out value="${emp.departmentName}"/></td>


        </tr>
        </c:forEach>

    </table>
</div>


</body>
</html>
