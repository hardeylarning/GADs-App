package com.rocktech.gads;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiPost {
    private static final String BASE_URL = "https://docs.google.com/forms/d/e/";
    public static Retrofit retrofit = null;

    public static Retrofit postForm() {
        if (null == retrofit) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
