package com.example.ezyfood.Snacks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ezyfood.Foods.FoodsActivity;
import com.example.ezyfood.Product;
import com.example.ezyfood.R;

import java.util.ArrayList;

public class SnacksActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SnackAdapter snackAdapter;
    protected ArrayList<Product> aSnack = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);

        getSupportActionBar().setTitle("Snack");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getDataSnack();

        recyclerView = findViewById(R.id.recyclerviewSnack);
        snackAdapter = new SnackAdapter(aSnack);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SnacksActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(snackAdapter);
    }

    private void getDataSnack(){

        aSnack.add(new Product("Chitato",123,1,R.drawable.snack5));
        aSnack.add(new Product("French Fries",123,1,R.drawable.snack6));
        aSnack.add(new Product("Chitos",123,1,R.drawable.snack1));
        aSnack.add(new Product("Lays",123,1,R.drawable.snack2));
        aSnack.add(new Product("Taro",123,1,R.drawable.snack4));
        aSnack.add(new Product("Jetz",123,1,R.drawable.snack3));
    }
}