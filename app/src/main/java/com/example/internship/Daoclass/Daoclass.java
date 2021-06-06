package com.example.internship.Daoclass;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.internship.Entity.RoomModel;

import java.util.List;

@Dao
public interface Daoclass {

    @Insert
    void insertAllData(RoomModel roomModel);

    @Query("select * from region")
    List<RoomModel> getAllData();

    @Query("DELETE FROM region")
    void delete();
}
