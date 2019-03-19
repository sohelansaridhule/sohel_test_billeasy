package com.parking.testbill;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callAPI();
    }

    private void callAPI() {
        APIService api = APIClient.getAPI();
        Call<JsonObject> call = api.getMovies("d1d3e6e701db9ef2f11181db40023b93");

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                 if (response.isSuccessful()){
                     JsonArray jsonArray = response.body().get("results").getAsJsonArray();

                 }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
}
