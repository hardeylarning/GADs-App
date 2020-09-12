package com.rocktech.gads;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://gadsapi.herokuapp.com";
    public static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (null == retrofit){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
