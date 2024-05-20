package org.example.case_module3.service.asignmentDto;

import org.example.case_module3.model.dto.AssignmentDto;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AssignmentDTODAO implements IAssignmentDTODAO{
    private final String jdbsName = "root";
    private final String jdbcPassword = "admin123456";
    private final String jdbcURL = "jdbc:mysql://localhost:3306/EmployeeManagement";
    private static final String SELECT_ALL = "SELECT Employees.employee_id AS employee_id, Employees.name AS employee_name, Projects.name AS project_name, Projects.start_date, Projects.end_date\n" +
            "FROM Employees\n" +
            "         JOIN Assignments ON Employees.employee_id = Assignments.employee_id\n" +
            "         JOIN Projects ON Assignments.project_id = Projects.project_id;\n";
    public AssignmentDTODAO(){}
    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbsName,jdbcPassword);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;

    }
    @Override
    public List<AssignmentDto> findAll() {
        List<AssignmentDto>assignmentDtoList=new ArrayList<>();
        Connection connection = getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String projectName = resultSet.getString("project_name");
                LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
                LocalDate endDate = resultSet.getDate("end_date").toLocalDate();
                assignmentDtoList.add(new AssignmentDto(id,employeeName,projectName,startDate,endDate));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return assignmentDtoList;
    }

    @Override
    public AssignmentDto selectById(int id) {
        return null;
    }

    @Override
    public void insert(AssignmentDto ob) throws SQLException {

    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateById(AssignmentDto ob) throws SQLException {
        return false;
    }
}
