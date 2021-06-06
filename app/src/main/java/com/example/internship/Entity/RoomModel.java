package com.example.internship.Entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "region")
public class RoomModel {
    @PrimaryKey(autoGenerate = true)
    private int key;

    @ColumnInfo(name="name")
    private String name;

    @ColumnInfo(name="capital")
    private String capital;

    @ColumnInfo(name="flag")
    private String flag;

    @ColumnInfo(name="region")
    private String region;

    @ColumnInfo(name="subregion")
    private String subregion;

    @ColumnInfo(name="population")
    private String population;

    @ColumnInfo(name="languages")
    private String languages;

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
//    @ColumnInfo(name="borders")
//    private List<String> borders;
//
//    public List<String> getBorders() {
//        return borders;
//    }
//
//    public void setBorders(List<String> borders) {
//        this.borders = borders;
//    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
