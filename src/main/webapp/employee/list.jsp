<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List all employee</title>
    <c:import url="../bootstrap/lib.jsp"/>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Employee Management</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Salary</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Assignment</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col">
            <h1 class="text-center">Employee Management</h1>
            <div class="text-center">
                <h2><a href="/employee?action=create" class="btn btn-success">Add new Employee</a></h2>
            </div>
            <div class="table-responsive">
                <table class="table table-striped">
                    <caption><h2>List employee</h2></caption>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>EmployeeID</th>
                        <th>Day of birth</th>
                        <th>Gender</th>
                        <th>Address</th>
                        <th>Department</th>
                        <th>Position</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="emp" items="${employeeList}">
                        <tr>
                            <td><c:out value="${emp.employeeId}"/></td>
                            <td><a href="/employee?action=view&id=${emp.employeeId}"><c:out value="${emp.name}"/></a></td>
                            <td><c:out value="${emp.dob}"/></td>
                            <td><c:out value="${emp.gender}"/></td>
                            <td><c:out value="${emp.address}"/></td>
                            <td><c:out value="${emp.departmentName}"/></td>
                            <td><c:out value="${emp.positionName}"/> </td>
                            <td>
                                <a href="/employee?action=edit&id=${emp.employeeId}" class="btn btn-primary">Edit</a>
                            </td>
                            <td>
                                <button onclick="deleteInfo(${emp.employeeId},'${emp.name}')" type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="employee" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Confirm Delete</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input id="id" hidden name="id">
                    <input name="action" value="delete" hidden>
                    <p>Are you sure you want to delete employee <span style="color: red" id="name"></span>?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    function deleteInfo(id, name) {
        document.getElementById("id").value = id;
        document.getElementById("name").innerText = name;
    }
</script>
</body>
</html>
