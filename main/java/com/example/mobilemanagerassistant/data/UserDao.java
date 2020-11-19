package com.example.mobilemanagerassistant.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mobilemanagerassistant.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertUser();

    @Update
    void updateUser();

    @Delete
    void deleteUser();

    @Query(value = "SELECT * FROM user_table")
    LiveData<List<User>> getAllUsers();

}
