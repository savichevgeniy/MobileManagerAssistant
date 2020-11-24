package com.example.mobilemanagerassistant.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;



@Entity(tableName = "projects_table")
public class Project extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name_project")
    private String NameProject;

    @ColumnInfo(name = "customer_project")
    private String customerProject;

    @ColumnInfo(name = "deadline_project")
    private String deadlineProject;



    public Project() {
    }

    public Project(int idProject, String nameProject, String customerProject, String deadlineProject) {
        this.id = idProject;
        this.NameProject = nameProject;
        this.customerProject = customerProject;
        this.deadlineProject = deadlineProject;
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Bindable
    public String getNameProject() {
        return NameProject;
    }

    public void setNameProject(String nameProject) {
        NameProject = nameProject;
        notifyPropertyChanged(BR.nameProject);
    }

    @Bindable
    public String getCustomerProject() {
        return customerProject;
    }

    public void setCustomerProject(String customerProject) {
        this.customerProject = customerProject;
        notifyPropertyChanged(BR.customerProject);
    }

    @Bindable
    public String getDeadlineProject() {
        return deadlineProject;
    }

    public void setDeadlineProject(String deadlineProject) {
        this.deadlineProject = deadlineProject;
        notifyPropertyChanged(BR.deadlineProject);
    }
}
