package com.example.mobilemanagerassistant.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProjectDao {

    @Insert
    void insert();

    @Update
    void update();

    @Delete
    void delete();

    @Query(value = "SELECT * FROM projects_table")
    LiveData<List<Project>> getAllProjects();
}
