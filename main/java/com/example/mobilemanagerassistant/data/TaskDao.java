package com.example.mobilemanagerassistant.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mobilemanagerassistant.model.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insertTask();

    @Update
    void updateTask();

    @Delete
    void deleteTask();

    @Query(value = "SELECT * FROM tasks_table")
    LiveData<List<Task>> getAllTasks();
}
