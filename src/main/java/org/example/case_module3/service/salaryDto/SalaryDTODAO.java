package org.example.case_module3.service.salaryDto;

import org.example.case_module3.model.dto.SalaryDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaryDTODAO implements ISalaryDTO{
    private final String jdbsName = "root";
    private final String jdbcPassword = "admin123456";
    private final String jdbcURL = "jdbc:mysql://localhost:3306/EmployeeManagement";
    private static final String SELECT_ALL = "SELECT Employees.employee_id AS employee_id, Employees.name AS employee_name, Salaries.salary\n" +
            "FROM Employees\n" +
            "         JOIN Salaries ON Employees.employee_id = Salaries.employee_id;";
    public SalaryDTODAO(){}
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
    public List<SalaryDto> findAll() {
        List<SalaryDto>salaryDtoList= new ArrayList<>();
        Connection connection = getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            System.out.println(preparedStatement);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int id= resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                float salary = resultSet.getFloat("salary");
                salaryDtoList.add(new SalaryDto(id,employeeName,salary) );

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salaryDtoList;
    }

    @Override
    public SalaryDto selectById(int id) {
        return null;
    }

    @Override
    public void insert(SalaryDto ob) throws SQLException {

    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateById(SalaryDto ob) throws SQLException {
        return false;
    }


}
