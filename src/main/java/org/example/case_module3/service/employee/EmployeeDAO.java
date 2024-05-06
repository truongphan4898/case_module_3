package org.example.case_module3.service.employee;

import org.example.case_module3.model.Employee;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {
    private final String jdbsName = "root";
    private final String jdbcPassword = "admin123456";
    private final String jdbcURL = "jdbc:mysql://localhost:3306/EmployeeManagement";
    private static final String SELECT_ALL_EMPLOYEE = "select * from Employees;";
    private static final String SELECT_EMPLOYEE = "select * from Employees where employee_id=?;";
    private static final String INSERT_EMPLOYEE = "INSERT INTO Employees (name, date_of_birth, gender, address, department_id, position_id) VALUES (?,?,?,?,?,?);";
    private static final String DELETE_EMPLOYEE = "delete from Employees where employee_id=?;";
    private static final String UPDATE_EMPLOYEE = "update Employees set name=?, date_of_birth=?, gender=?, address=?, department_id=?, position_id=? where employee_id=?;";
    public EmployeeDAO(){}
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
    public Employee selectById(int id) {
        Employee employee = null;
        try( Connection connection=getConnection();
             PreparedStatement preparedStatement= connection.prepareStatement(SELECT_EMPLOYEE)){
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int employeeId = resultSet.getInt("employee_id");
                String name = resultSet.getString("name");
                LocalDate dob = resultSet.getDate("date_of_birth").toLocalDate();
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                int departmentID= resultSet.getInt("department_id");
                int positionID=resultSet.getInt("position_id");
                employee = new Employee(employeeId,name,dob,gender,address,departmentID,positionID);
            }
        }
        catch (SQLException e){
            printSQLException(e);
        }
        return employee;

    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ALL_EMPLOYEE)){
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int employeeId = resultSet.getInt("employee_id");
                String name = resultSet.getString("name");
                LocalDate dob = resultSet.getDate("date_of_birth").toLocalDate();
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                int departmentID= resultSet.getInt("department_id");
                int positionID=resultSet.getInt("position_id");
                employeeList.add(new Employee(employeeId,name,dob,gender,address,departmentID,positionID));
            }

        }
        catch (SQLException e){
            printSQLException(e);
        }
        return employeeList;
    }

    @Override
    public void insert(Employee employee) throws SQLException {
        System.out.println(INSERT_EMPLOYEE);
        try(Connection connection= getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(INSERT_EMPLOYEE)) {
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setDate(2, Date.valueOf(employee.getDob()));
            preparedStatement.setString(3,employee.getGender());
            preparedStatement.setString(4,employee.getAddress());
            preparedStatement.setInt(5,employee.getIdDepartment());
            preparedStatement.setInt(6,employee.getIdDepartment());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }

    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        boolean rowDelete;
        try(Connection connection=getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(DELETE_EMPLOYEE)){
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate()>0;
        }
        return rowDelete;
    }

    @Override
    public boolean updateById(Employee employee) throws SQLException {
        boolean rowUpdate;
        try(Connection connection= getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE)){
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setDate(2, Date.valueOf(employee.getDob()));
            preparedStatement.setString(3,employee.getGender());
            preparedStatement.setString(4,employee.getAddress());
            preparedStatement.setInt(5,employee.getIdDepartment());
            preparedStatement.setInt(6,employee.getIdPosition());
            preparedStatement.setInt(7,employee.getId());
            rowUpdate = preparedStatement.executeUpdate() >0 ;
        }
        return  rowUpdate;
    }
    private void printSQLException(SQLException exception){
        for (Throwable e:exception){
            if(e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQLState "+((SQLException) e).getSQLState());
                System.err.println("SQLCode "+((SQLException)e).getErrorCode());
                System.err.println("message "+e.getMessage());
                Throwable throwable = exception.getCause();
                while (throwable != null){
                    System.out.println("cause "+ throwable);
                    throwable=throwable.getCause();
                }
            }
        }
    }
}
