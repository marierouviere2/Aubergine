package com.example.aubergine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.aubergine.model.AOE;
import com.example.aubergine.model.OnClick;

import java.util.List;


public class MyActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ProgressBar loader;

    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        loader =  findViewById(R.id.loader);

        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        controller = new MainController(this);
        controller.onCreate();
    }

    public void showLoader(){
        loader.setVisibility(View.VISIBLE);
    }

    public void hideLoader(){
        loader.setVisibility(View.GONE);
    }

    public void showList(List<AOE> list){
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // define an adapter
        mAdapter = new MyAdapter(list, getApplicationContext(), new OnClick() {
            @Override
            public void onClick(AOE item) {
                Toast.makeText(getApplicationContext(), item.getName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("name", item.getName());
                /*intent.putExtra("id", item.getId());
                intent.putExtra("expansion", item.getExpansion());
                intent.putExtra("army_type", item.getArmy_type());*/
                //intent.putExtra("civilization_bonus", item.getCivilization_bonus());
                //rajouter le reste
                MyActivity.this.startActivity(intent);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }
}

