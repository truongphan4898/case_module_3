<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phantruong
  Date: 06/05/2024
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Detail</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>

<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="employee?action=employee">List All Employee</a>
    </h2>
</center>
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">
                    <h2 class="text-center">Employee Detail</h2>
                </div>
                <div class="card-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th>ID:</th>
                            <td><c:out value="${employee.employeeId}"/></td>
                        </tr>
                        <tr>
                            <th>Name:</th>
                            <td><c:out value="${employee.name}"/></td>
                        </tr>
                        <tr>
                            <th>Day of Birth:</th>
                            <td><c:out value="${employee.dob}" /></td>
                        </tr>
                        <tr>
                            <th>Gender:</th>
                            <td><c:out value="${employee.gender}"/></td>
                        </tr>
                        <tr>
                            <th>Address:</th>
                            <td><c:out value="${employee.address}"/></td>
                        </tr>
                        <tr>
                            <th>Department ID:</th>

                            <td><c:out value="${employee.departmentName}"/></td>
                        </tr>
                        <tr>
                            <th>Position ID:</th>
                            <td><c:out value="${employee.positionName}"/></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
