package org.example.case_module3.model;

import java.time.LocalDate;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private LocalDate dob;
    private String gender;
    private String address;
    private int idPosition;
    private int idDepartment;

    public Employee(){}

    public Employee(int id, String name, LocalDate dob, String gender, String address, int idPosition, int idDepartment) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.idPosition = idPosition;
        this.idDepartment = idDepartment;
    }

    public Employee(String name, LocalDate dob, String gender, String address, int idPosition, int idDepartment) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.idPosition = idPosition;
        this.idDepartment = idDepartment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }
}
