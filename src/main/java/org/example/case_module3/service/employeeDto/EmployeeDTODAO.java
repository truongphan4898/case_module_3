package org.example.case_module3.service.employeeDto;

import org.example.case_module3.model.dto.EmployeeDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDTODAO implements IEmployeeDTO{
    private final String jdbsName = "root";
    private final String jdbcPassword = "admin123456";
    private final String jdbcURL = "jdbc:mysql://localhost:3306/EmployeeManagement";
    private static final String SELECT_ALL = "SELECT Employees.employee_id, Employees.name AS employee_name,Employees.date_of_birth AS Dayofbirth, Employees.gender AS gender,Employees.address AS adress,  Positions.name AS position_name, Departments.name AS department_name\n" +
            "FROM Employees\n" +
            "         INNER JOIN Positions ON Employees.position_id = Positions.position_id\n" +
            "         INNER JOIN Departments ON Employees.department_id = Departments.department_id;\n";
    public EmployeeDTODAO(){}
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
    public List<EmployeeDTO> findAll() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        Connection connection = getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                LocalDate dob = resultSet.getDate("Dayofbirth").toLocalDate();
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                String positionName = resultSet.getString("position_name");
                String departmentName = resultSet.getString("department_name");
                employeeDTOList.add(new EmployeeDTO(id,employeeName,dob,gender,address,positionName,departmentName));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeDTOList;

    }

    @Override
    public EmployeeDTO selectById(int id) {
        return null;
    }

    @Override
    public void insert(EmployeeDTO ob) throws SQLException {

    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateById(EmployeeDTO ob) throws SQLException {
        return false;
    }


}
