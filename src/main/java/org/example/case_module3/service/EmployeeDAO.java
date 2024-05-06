package org.example.case_module3.service;

import org.example.case_module3.model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO{
    private final String jdbsName = "root";
    private final String jdbcPassword = "admin123456";
    private final String jdbcURL = "jdbc:mysql://localhost:3306";
    private static final String SELECT_ALL_EMPLOYEE = "select * from Employees;";
    private static final String SELECT_EMPLOYEE = "select * from Employees where employee_id=?;";
    private static final String INSERT_EMPLOYEE = "INSERT INTO Employees (name, date_of_birth, gender, address, department_id, position_id) VALUES (?,?,?,?,?,?);";
    private static final String DELETE_EMPLOYEE = "delete from Employees where employee_id=?;";
    private static final String UPDATE_EMPLOYEE = "update Employees set name=?, date_of_birth=?, gender=?, address=?, department_id=?, position_id=? where employee_id=?;";
    private EmployeeDAO(){}
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
    public Employee selectEmployee(int id) {

    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {

    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return false;
    }
}
