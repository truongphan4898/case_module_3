package org.example.case_module3.dto;

public class SalaryDto {
    private int idEmployee;
    private String name;
    private float salary;

    public SalaryDto(int idEmployee, String name, float salary) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.salary = salary;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
