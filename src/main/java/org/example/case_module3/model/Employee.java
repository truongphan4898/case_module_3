package org.example.case_module3.model;

import java.time.LocalDate;

public class Employee {
    private int employeeId;
    private String name;
    private LocalDate dob;
    private String gender;

    private String address;
    private int positionId;
    private int departmentId;

    public Employee() {
    }

    public Employee(String name, LocalDate dob, String gender, String address, int positionId, int departmentId) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.positionId = positionId;
        this.departmentId = departmentId;
    }

    public Employee(int employeeId, String name, LocalDate dob, String gender, String address, int positionId, int departmentId) {
        this.employeeId = employeeId;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.positionId = positionId;
        this.departmentId = departmentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
