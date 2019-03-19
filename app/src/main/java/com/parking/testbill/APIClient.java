package com.parking.testbill;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static APIService getAPI(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.themoviedb.org/3/movie/")
//                .build();
//     return   retrofit.create(APIService.class);
        Retrofit retrofit = getClient();
        return retrofit.create(APIService.class);
    }



        private static Retrofit retrofit = null;

        static Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        static OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS).build();
        public static Retrofit getClient(){
            if (retrofit==null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.themoviedb.org/3/movie/")
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }
            return retrofit;
        }
    }

