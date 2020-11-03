package com.example.ezyfood.Drinks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ezyfood.Product;
import com.example.ezyfood.R;

import java.util.ArrayList;

public class DrinksActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DrinkAdapter drinkAdapter;
    private ArrayList<Product> aDrinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);


        getSupportActionBar().setTitle("Drinks");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getData();
        recyclerView = findViewById(R.id.recyclerview);
        drinkAdapter = new DrinkAdapter(aDrinks);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DrinksActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(drinkAdapter);



    }

    public void getData(){
        aDrinks = new ArrayList<>();
        aDrinks.add(new Product("Air Mineral",123,1));
        aDrinks.add(new Product("Jus Apel",123,1));
        aDrinks.add(new Product("Jus Melon",123,1));
        aDrinks.add(new Product("Jus Jeruk",123,1));
        aDrinks.add(new Product("Jus Tomat",123,1));
        aDrinks.add(new Product("Jus Sirsak",123,1));
    }
}