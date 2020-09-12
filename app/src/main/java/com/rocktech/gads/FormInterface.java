package com.rocktech.gads;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface FormInterface {

    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<Form> submitForm(@Field("entry.1824927963") String email,
                          @Field("entry.1877115667") String name,
                          @Field("entry.2006916086") String last,
                          @Field("entry.284483984") String project);

}