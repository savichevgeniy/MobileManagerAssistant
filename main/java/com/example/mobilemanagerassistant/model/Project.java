package com.example.mobilemanagerassistant.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "projects_table")
public class Project extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_Project")
    private int idProject;

    @ColumnInfo(name = "name_project")
    private String NameProject;

    @ColumnInfo(name = "customer_project")
    private String customerProject;

    @ColumnInfo(name = "deadline_project")
    private Date deadlineProject;

    public Project(int idProject, String nameProject, String customerProject, Date deadlineProject) {
        this.idProject = idProject;
        this.NameProject = nameProject;
        this.customerProject = customerProject;
        this.deadlineProject = deadlineProject;
    }

    @Bindable
    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    @Bindable
    public String getNameProject() {
        return NameProject;
    }

    public void setNameProject(String nameProject) {
        NameProject = nameProject;
    }

    @Bindable
    public String getCustomerProject() {
        return customerProject;
    }

    public void setCustomerProject(String customerProject) {
        this.customerProject = customerProject;
    }

    @Bindable
    public Date getDeadlineProject() {
        return deadlineProject;
    }

    public void setDeadlineProject(Date deadlineProject) {
        this.deadlineProject = deadlineProject;
    }
}
