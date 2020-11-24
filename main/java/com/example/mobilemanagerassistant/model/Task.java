package com.example.mobilemanagerassistant.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;



@Entity(tableName = "tasks_table", foreignKeys =
        @ForeignKey(entity = Project.class, parentColumns = "id",
                childColumns = "id_project,", onDelete = ForeignKey.CASCADE))
public class Task extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_task")
    private int idTask;

    @ColumnInfo(name = "name_task")
    private String nameTask;

    @ColumnInfo(name = "name_employee")
    private String nameEmployee;

    @ColumnInfo(name = "position_employee")
    private String positionEmployee;

    @ColumnInfo(name = "deadline_task")
    private String deadlineTask;

    @ColumnInfo(name = "id_project")
    private int idProject;

    @Ignore
    public Task() {
    }

    public Task(int idTask, String nameTask, String nameEmployee,
                String deadlineTask, int idProject, String positionEmployee) {
        this.idTask = idTask;
        this.nameTask = nameTask;
        this.nameEmployee = nameEmployee;
        this.positionEmployee = positionEmployee;
        this.deadlineTask = deadlineTask;
        this.idProject = idProject;
    }

    @Bindable
    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
        notifyPropertyChanged(BR.idTask);
    }

    @Bindable
    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
        notifyPropertyChanged(BR.nameTask);
    }

    @Bindable
    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
        notifyPropertyChanged(BR.nameEmployee);
    }

    @Bindable
    public String getPositionEmployee() {
        return positionEmployee;
    }

    public void setPositionEmployee(String positionEmployee) {
        this.positionEmployee = positionEmployee;
        notifyPropertyChanged(BR.positionEmployee);
    }

    @Bindable
    public String getDeadlineTask() {
        return deadlineTask;
    }

    public void setDeadlineTask(String deadlineTask) {
        this.deadlineTask = deadlineTask;
        notifyPropertyChanged(BR.deadlineTask);
    }

    @Bindable
    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProjectInTask) {
        this.idProject = idProjectInTask;
        notifyPropertyChanged(BR.idProject);
    }

}
