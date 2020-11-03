package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ezyfood.Drinks.DrinksActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    private TextView tvOrderName, tvOrderPrice, tvOrderQty;
    protected ArrayList<Product> drink1 = new ArrayList<Product>();
    private Button btnOrderMore, btnMyOrder;

    protected static ArrayList<Product> drinks = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        tvOrderName = findViewById(R.id.tvOrderName);
        tvOrderPrice = findViewById(R.id.tvOrderPrice);
        tvOrderQty = findViewById(R.id.tvOrderQty);
        btnMyOrder = findViewById(R.id.btnMyOrder);
        btnOrderMore = findViewById(R.id.btnOrderMore);

        getSupportActionBar().hide();

        Type type = new TypeToken<ArrayList<Product>>() {
        }.getType();
        drink1 = new Gson().fromJson(getIntent().getStringExtra("drink"), type);

        tvOrderName.setText(drink1.get(0).getName());
        tvOrderPrice.setText("Rp "+ drink1.get(0).getPrice());
        tvOrderQty.setText("Quantity\n      "+drink1.get(0).getQty());

        drinks.add(new Product(drink1.get(0).getName(),drink1.get(0).getPrice(),drink1.get(0).getQty()));

        btnOrderMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, MyOrderActivity.class);
                startActivity(intent);
        }
        });

    }

}