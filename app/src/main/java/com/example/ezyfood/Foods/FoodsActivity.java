package com.example.ezyfood.Foods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ezyfood.Drinks.DrinkAdapter;
import com.example.ezyfood.Drinks.DrinksActivity;
import com.example.ezyfood.Product;
import com.example.ezyfood.R;

import java.util.ArrayList;

public class FoodsActivity extends AppCompatActivity {

    private RecyclerView recyclerView1;
    private FoodAdapter foodAdapter;
    protected ArrayList<Product> aFood = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        getSupportActionBar().setTitle("Food");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getDataFood();
        recyclerView1 = findViewById(R.id.recyclerviewFood);
        foodAdapter = new FoodAdapter(aFood);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FoodsActivity.this);

        recyclerView1.setLayoutManager(layoutManager);

        recyclerView1.setAdapter(foodAdapter);
    }


    private void getDataFood(){

        aFood.add(new Product("Nasi Padang",123,1));
        aFood.add(new Product("Ayam Kremes",123,1));
        aFood.add(new Product("Sushi",123,1));
        aFood.add(new Product("Ayam Geprek",123,1));
        aFood.add(new Product("Daging Sapi",123,1));
        aFood.add(new Product("Nasi Kuning",123,1));
    }
}