package com.example.aubergine;

import com.example.aubergine.model.AOE;
import com.example.aubergine.model.RestAOEResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface AOERestAPI {
    @GET("civilizations")
    Call<RestAOEResponse> getListAOE();
}
