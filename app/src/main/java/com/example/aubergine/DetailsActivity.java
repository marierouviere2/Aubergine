package com.example.aubergine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getIncommingIntent();
    }

    private void getIncommingIntent(){
        if(getIntent().hasExtra("name")){
            String nom = getIntent().getStringExtra("name");
            setTextAOE(nom);
        }/*
        if(getIntent().hasExtra("id")){
            String idd = getIntent().getStringExtra(("id"));
            setTextAOE(idd);
        }
        if(getIntent().hasExtra("expansion")){
            String expansion = getIntent().getStringExtra(("expansion"));
            setTextAOE(expansion);
        }
        if(getIntent().hasExtra("army_type")){
            String army = getIntent().getStringExtra(("army_type"));
            setTextAOE(army);
        }*/
    }

    private void setTextAOE(String nom){
        TextView nomCiv = findViewById(R.id.name);
        nomCiv.setText(nom);
    }
}
