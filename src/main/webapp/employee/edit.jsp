<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phantruong
  Date: 06/05/2024
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="employee?action=employee">List All Employee</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Employee
                </h2>
            </caption>

                <tr>
                    <th>ID:</th>
                    <th><input hidden name="employeeId" value="<c:out value='${employee.employeeId}' />"/></th>
                </tr>

            <tr>
                <th> Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${employee.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Day of birth:</th>
                <td>
                    <input type="text" name="dob" size="45"
                           value="<c:out value='${employee.dob}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <input type="text" name="gender" size="45"
                           value="<c:out value='${employee.gender}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${employee.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Position:</th>
                <td>
                    <select name="positionId">
                        <c:forEach var="position" items="${positionList}">
                            <option value="${position.id}">${position.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Department:</th>
                <td>
                    <select name = "departmentId">
                        <c:forEach var="department" items="${departmentList}">
                            <option value="${department.id}">${department.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
