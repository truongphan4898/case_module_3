package org.example.case_module3.service.department;

import org.example.case_module3.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO implements IDepartmentDAO{
    private final String jdbsName = "root";
    private final String jdbcPassword = "admin123456";
    private final String jdbcURL = "jdbc:mysql://localhost:3306/EmployeeManagement";
    private static final String SELECT_ALL = "select * from Departments;";
    public DepartmentDAO(){}
    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(jdbcURL,jdbsName,jdbcPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    @Override
    public List<Department> findAll() {
        List<Department> departmentList = new ArrayList<>();
        Connection connection = getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("department_id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                departmentList.add(new Department(id,name,description));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departmentList;

    }

    @Override
    public Department selectById(int id) {
        return null;
    }

    @Override
    public void insert(Department ob) throws SQLException {

    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateById(Department ob) throws SQLException {
        return false;
    }
}
