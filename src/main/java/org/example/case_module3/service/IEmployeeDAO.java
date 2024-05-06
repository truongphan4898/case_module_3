package org.example.case_module3.service;

import org.example.case_module3.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeDAO {
    public List<Employee> findAllEmployee();
    public Employee selectEmployee(int id);
    public void insertEmployee(Employee employee) throws SQLException;
    public boolean deleteEmployee(int id) throws SQLException;
    public boolean updateEmployee(Employee employee) throws SQLException;
}
