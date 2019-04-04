package com.example.aubergine;

import com.example.aubergine.model.AOE;
import com.example.aubergine.model.RestAOEResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.content.Intent;
import android.util.Log;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class MainController {
    private final MyActivity MyActivity;

    private static MainController instance = null;

    public static MainController getInstance(MyActivity MyActivity){
        if(instance == null){
            instance = new MainController(MyActivity);
        }
        return instance;
    }

    public MainController(MyActivity MyActivity) {
        this.MyActivity = MyActivity;
    }

    public void onCreate() {
        MyActivity.showLoader();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //On crée un objet retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://age-of-empires-2-api.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //On crée notre interface RestApi
        AOERestAPI aoeRestAPI = retrofit.create(AOERestAPI.class);

        //On récupére un objet call.
        /*Call<List <AOE>> call = AOERestAPI.getListAOE();

        call.enqueue(new Callback<List<AOE>>() {
            @Override
            public void onResponse(Call<List<AOE>> call, Response<List<AOE>> response) {
                List<AOE> listAOE = response.body();
                MyActivity.showList(listAOE);
                MyActivity.hideLoader();
            }

            @Override
            public void onFailure(Call<List<AOE>> call, Throwable t) {
                Log.d("Erreur", "API ERROR");
            }
        });*/
        Call<RestAOEResponse> call = aoeRestAPI.getListAOE();

        call.enqueue(new Callback<RestAOEResponse>() {
            @Override
            public void onResponse(Call<RestAOEResponse> call, Response<RestAOEResponse> response) {
                RestAOEResponse restAOEResponse = response.body();
                List<AOE> listAOE = restAOEResponse.getCivilizations();
                MyActivity.showList(listAOE);
                MyActivity.hideLoader();
            }

            @Override
            public void onFailure(Call<RestAOEResponse> call, Throwable t) {
                Log.d("Erreur", "API ERROR");
            }
        });
    }

    public void onItemClicked(AOE itemClicked){

    }
}
