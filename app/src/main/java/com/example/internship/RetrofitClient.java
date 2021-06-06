package com.example.internship;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static String A_URL="https://restcountries.eu/rest/";

    public static Retrofit getRetrofitInstance(){
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(A_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
