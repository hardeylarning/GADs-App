package com.rocktech.gads;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/api/hours")
    Call<List<TopHour>> getTop();


//    @GET("api/skilliq/{name}")
//    Call<User> getName(@Path("name") String name);
}
