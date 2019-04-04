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
            String idd = getIntent().getStringExtra(("id"));
            String expansion = getIntent().getStringExtra(("expansion"));
            String army = getIntent().getStringExtra(("army_type"));
            setTextAOE(nom,idd,expansion,army);
        }
    }

    private void setTextAOE(String nom,String idd,String expansion,String army){
        TextView nomCiv = findViewById(R.id.name);
        nomCiv.setText(nom);

        TextView iddCiv = findViewById(R.id.idd);
        iddCiv.setText(idd);

        TextView expCiv = findViewById(R.id.expansion);
        expCiv.setText(expansion);

        TextView armyCiv = findViewById(R.id.army);
        armyCiv.setText(army);

    }
}
