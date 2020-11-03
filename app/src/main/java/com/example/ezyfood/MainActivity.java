package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ezyfood.Drinks.DrinksActivity;
import com.example.ezyfood.Foods.FoodsActivity;
import com.example.ezyfood.Snacks.SnacksActivity;
import com.example.ezyfood.TopUp.TopUpActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCekOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnCekOrder = findViewById(R.id.btnCekOrder);

        btnCekOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(MainActivity.this, MyOrderActivity.class);
            }
        });

    }

    public void ClickDrinks(View view){
        redirectActivity(MainActivity.this, DrinksActivity.class);
    }

    public void ClickFoods(View view){
       redirectActivity(MainActivity.this, FoodsActivity.class);
    }

    public void ClickSnacks(View view){
        redirectActivity(MainActivity.this, SnacksActivity.class);
    }

    public void ClickTopUp(View view){
        redirectActivity(MainActivity.this, TopUpActivity.class);
    }

    private void redirectActivity(Activity activity, Class aClass) {
        Intent intent = new Intent(activity,aClass);

        activity.startActivity(intent);
    }
}