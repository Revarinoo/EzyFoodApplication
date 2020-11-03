package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ezyfood.OrderComplete.CompleteActivity;
import com.google.gson.Gson;
import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyOrderAdapter myOrderAdapter;
    private ArrayList<Product> aDrink = new ArrayList<Product>();
    private ArrayList<Product> temp = new ArrayList<Product>();
    private TextView tvTotal;
    private Button btnPay;
    private static boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        getSupportActionBar().hide();

        tvTotal = findViewById(R.id.tvTotal);
        btnPay = findViewById(R.id.btnPay);

        aDrink = (ArrayList<Product>) OrderActivity.drinks.clone();

        if(flag) {
            aDrink.clear();
            OrderActivity.drinks.clear();
            flag = false;
            btnPay.setVisibility(View.INVISIBLE);
        }
        if(aDrink.size()<1) {
            btnPay.setVisibility(View.INVISIBLE);
        }

        recyclerView = findViewById(R.id.recyclerviewOrder);
        myOrderAdapter = new MyOrderAdapter(aDrink);

        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(MyOrderActivity.this);
        recyclerView.setLayoutManager(layoutManager1);
        recyclerView.setAdapter(myOrderAdapter);


        total(aDrink);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = (ArrayList<Product>) aDrink.clone();
                Intent intent = new Intent(MyOrderActivity.this, CompleteActivity.class);
                intent.putExtra("dataProduct",new Gson().toJson(temp));
                flag = true;
                startActivity(intent);
            }
        });

        myOrderAdapter.onItemClickListener(new MyOrderAdapter.onItemClickListener() {
            @Override
            public void DeleteClick(int position) {
                Toast toast = Toast.makeText(getApplicationContext(),aDrink.get(position).getName() + " Berhasil dihapus",Toast.LENGTH_SHORT);
                toast.show();
                aDrink.remove(position);
                OrderActivity.drinks.remove(position);
                total(aDrink);
                if(aDrink.size()<1)btnPay.setVisibility(View.INVISIBLE);
                myOrderAdapter.notifyItemRemoved(position);
            }
        });

    }

    private void total(ArrayList<Product> list){
        int totalPrice = 0;
        for(int i=0;i<list.size();i++){
            totalPrice += list.get(i).getPrice();
        }
        tvTotal.setText("Total : Rp "+totalPrice);

    }


}