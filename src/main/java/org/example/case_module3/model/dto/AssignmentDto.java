package org.example.case_module3.dto;

import java.time.LocalDate;

public class AssignmentDto {
    private int idEmployee;
    private String employeeName;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;

    public AssignmentDto(int idEmployee, String employeeName, String projectName, LocalDate startDate, LocalDate endDate) {
        this.idEmployee = idEmployee;
        this.employeeName = employeeName;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public AssignmentDto() {
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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
