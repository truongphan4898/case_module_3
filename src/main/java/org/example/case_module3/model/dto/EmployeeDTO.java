package org.example.case_module3.model.dto;

import java.time.LocalDate;

public class EmployeeDTO {
    private int employeeId;
    private String name;
    private LocalDate dob;
    private String gender;

    private String address;

    private String positionName;
    private String departmentName;

    public EmployeeDTO(int employeeId, String name, LocalDate dob, String gender, String address, String positionName, String departmentName) {
        this.employeeId = employeeId;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.positionName = positionName;
        this.departmentName = departmentName;
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

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
