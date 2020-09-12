package com.rocktech.gads;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface1 {

    @GET("/api/skilliq")
    Call<List<User>> getUsers();


    @GET("/api/skilliq")
    Call<List<User>> getAll(@Query("name") String name,
                            @Query("score") Integer hours,
                            @Query("country") String country);

//    @GET("api/skilliq/{name}")
//    Call<User> getName(@Path("name") String name);
}
