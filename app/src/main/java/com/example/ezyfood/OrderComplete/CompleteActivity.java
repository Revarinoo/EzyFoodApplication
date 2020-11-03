package com.example.ezyfood.OrderComplete;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ezyfood.Product;
import com.example.ezyfood.MainActivity;
import com.example.ezyfood.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CompleteActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CompleteAdapter completeAdapter;
    private ArrayList<Product> aDrink = new ArrayList<Product>();
    private Button btnHome;
    private TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);
        getSupportActionBar().hide();

        btnHome = findViewById(R.id.btnHome);
        txtTotal = findViewById(R.id.txtTotal);

        Type type = new TypeToken<ArrayList<Product>>() {
        }.getType();
        aDrink = new Gson().fromJson(getIntent().getStringExtra("dataProduct"), type);

        total(aDrink);
        recyclerView = findViewById(R.id.recyclerviewComplete);
        completeAdapter = new CompleteAdapter(aDrink);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CompleteActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(completeAdapter);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompleteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void total(ArrayList<Product> list){
        int totalPrice = 0;
        for(int i=0;i<list.size();i++){
            totalPrice += list.get(i).getPrice();
        }
        txtTotal.setText("Rp "+totalPrice);

    }
}