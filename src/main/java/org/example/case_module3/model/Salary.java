package org.example.case_module3.model;

import java.time.LocalDate;

public class Salary {
    private int id;
    private int idEmployee;
    private  float salary;
    private LocalDate startDate;
    private LocalDate endDate;

    public Salary(int idEmployee, float salary, LocalDate startDate, LocalDate endDate) {
        this.idEmployee = idEmployee;
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Salary(int id, int idEmployee, float salary, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Salary() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
