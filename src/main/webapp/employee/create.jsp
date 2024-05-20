<%--
  Created by IntelliJ IDEA.
  User: phantruong
  Date: 06/05/2024
  Time: 15:07
  To change this template use File | Settings | File Templates.

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create Employee</title>
    <c:import url="../bootstrap/lib.jsp"/>
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
                <h2>Add New Employee</h2>
            </caption>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Day of birth:</th>
                <td>
                    <input type="text" name="dob" id="dob" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <input type="text" name="gender" id="gender" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <th>PositionID:</th>
                <td>
                    <select name="idPosition">
                        <c:forEach var="position" items="${positionList}">
                            <option value="${position.id}">${position.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>DepartmentID:</th>
                <td>
                    <select name = "idDepartment">
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
