package com.example.internship;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.internship.Daoclass.Daoclass;
import com.example.internship.Entity.RoomModel;

@Database(entities = {RoomModel.class},version = 1)
@TypeConverters({Converters.class})
public abstract class DatabaseClass extends RoomDatabase {

    public abstract Daoclass getDao();

    private static DatabaseClass instance;

    static DatabaseClass getDatabase(final Context context){
        if(instance==null){
            synchronized (DatabaseClass.class){
                instance= Room.databaseBuilder(context,DatabaseClass.class,"DATABASE").allowMainThreadQueries().build();
            }
        }
        return instance;
    }
}
