package com.example.firstapplication.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.firstapplication.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    public void addUser(User user);

    @Query("select * from users")
    public List<User> findAll();
}
