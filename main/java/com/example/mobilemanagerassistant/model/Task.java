package com.example.mobilemanagerassistant.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "tasks_table", foreignKeys = @ForeignKey(entity = Project.class,
        parentColumns = "idProject", childColumns = "idTask", onDelete = ForeignKey.CASCADE))
public class Task extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_task")
    private int idTask;

    @ColumnInfo(name = "name_task")
    private String nameTask;

    @ColumnInfo(name = "name_employee")
    private String nameEmployee;

    @ColumnInfo(name = "deadline_task")
    private Date deadlineTask;

    public Task(int idTask, String nameTask, String nameEmployee, Date deadlineTask) {
        this.idTask = idTask;
        this.nameTask = nameTask;
        this.nameEmployee = nameEmployee;
        this.deadlineTask = deadlineTask;
    }

    @Bindable
    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    @Bindable
    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    @Bindable
    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

   @Bindable
    public Date getDeadlineTask() {
        return deadlineTask;
    }

    public void setDeadlineTask(Date deadlineTask) {
        this.deadlineTask = deadlineTask;
    }
}
