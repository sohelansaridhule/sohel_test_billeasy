package com.parking.testbill;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @GET("users/{user}/repos")
    Call<JsonObject> getMovies(@Query("api_key") String api_key);

}
