package com.example.tugasrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<PahlawanModel> modelPahlawans = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvPahlawan);
        recyclerView.setHasFixedSize(true);
        modelPahlawans.addAll(PahlawanData.getListData());

        showRecyclerList();
    }
    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapterPahlawan = new Adapter(this);
        adapterPahlawan.setModelPahlawans(modelPahlawans);
        recyclerView.setAdapter(adapterPahlawan);
    }
}
