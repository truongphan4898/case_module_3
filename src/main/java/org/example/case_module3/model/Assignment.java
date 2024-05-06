package org.example.case_module3.model;

import java.time.LocalDate;

public class Assignment {
    private int id;
    private int idEmployee;
    private int idProject;
    private LocalDate startDate;
    private LocalDate endDate;

    public Assignment() {
    }

    public Assignment(int idEmployee, int idProject, LocalDate startDate, LocalDate endDate) {
        this.idEmployee = idEmployee;
        this.idProject = idProject;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Assignment(int id, int idEmployee, int idProject, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.idProject = idProject;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
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
