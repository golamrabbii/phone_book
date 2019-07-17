package com.example.sqlite;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DAO {



    @Insert
    public void insert(Info info);

    @Query("select * from info")
    public List<Info> getInfo();



}
