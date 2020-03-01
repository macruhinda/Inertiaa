package com.example.inertia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class DrinkElement extends AppCompatActivity implements Adapter.ItemClickListener {
    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drinks);

        recyclerView=findViewById(R.id.alldrinks);

        ArrayList<String> elements = new ArrayList<>();
        elements.add("Redbull");
        elements.add("Black Label");
        elements.add("4 Casins");
        elements.add("Kitoko");
        elements.add("Ngule");
        elements.add("Malwa");

        //set up the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new Adapter(this,elements);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {

    }
}