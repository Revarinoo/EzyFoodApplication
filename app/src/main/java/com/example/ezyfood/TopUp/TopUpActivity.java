package com.example.ezyfood.TopUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ezyfood.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class TopUpActivity extends AppCompatActivity {

    private Button btnTopUp;
    private EditText etAmount;
    private TextView tvBalance;
    protected static long balance = 0;
    protected static ArrayList<Long> temp = new ArrayList<Long>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        getSupportActionBar().setTitle("Top Up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnTopUp = findViewById(R.id.btnTopUp);
        etAmount = findViewById(R.id.etAmount);
        tvBalance = findViewById(R.id.tvBalance);

        try {
            btnTopUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        balance += Long.parseLong(etAmount.getText().toString());
                        temp.add(balance);
                        Toast.makeText(getApplicationContext(),"Balance added!",Toast.LENGTH_SHORT).show();
                        tvBalance.setText(String.valueOf(balance));
                    }catch (Exception e){
                        Log.e("Failed", String.valueOf(e));
                        Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
                    }

                }
            });

            temp.add(balance);
            tvBalance.setText(String.valueOf(temp.get(temp.size()-1)));
        }catch (NumberFormatException nfe){
                Log.i("Failed", String.valueOf(nfe));
        }
    }


}