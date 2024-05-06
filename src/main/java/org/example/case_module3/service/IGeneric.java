package org.example.case_module3.service;

import org.example.case_module3.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IGeneric <T> {
    public List<T> findAll();
    public T selectById(int id);
    public void insert(T ob) throws SQLException;
    public boolean deleteById(int id) throws SQLException;
    public boolean updateById(T ob) throws SQLException;

}
