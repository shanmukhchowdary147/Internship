package com.example.internship;

import com.example.internship.Models.LangModel;
import com.example.internship.Models.Model1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {
    @GET("v2/region/asia")
    Call<List<Model1>> getAllDAta();

}
