package com.example.mobilemanagerassistant.model;

import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_user")
    private int idUser;

    @ColumnInfo(name = "user_name")
    private String userName;

    @ColumnInfo(name = "user_password")
    private String userPassword;

    public User(int idUser, String userName, String userPassword) {
        this.idUser = idUser;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    @Bindable
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Bindable
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
