package com.example.firstapplication.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.firstapplication.dao.UserDao;
import com.example.firstapplication.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
