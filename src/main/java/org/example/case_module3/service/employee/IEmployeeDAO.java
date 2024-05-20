package org.example.case_module3.service.employee;

import org.example.case_module3.model.Employee;
import org.example.case_module3.model.dto.EmployeeDTO;
import org.example.case_module3.service.IGeneric;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeDAO extends IGeneric<Employee> {
    public List<EmployeeDTO> getAll();
    public EmployeeDTO findById(int id);

}