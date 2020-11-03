package com.example.ezyfood.Foods;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.OrderActivity;
import com.example.ezyfood.Product;
import com.example.ezyfood.R;
import com.google.gson.Gson;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private ArrayList<Product> listFood;

    public FoodAdapter(ArrayList<Product> listFood) {
        this.listFood = listFood;
    }

    @NonNull
    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_foods, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FoodAdapter.FoodViewHolder holder, final int position) {
        holder.tvFoodName.setText(listFood.get(position).getName());
        holder.tvFoodPrice.setText("Rp " + listFood.get(position).getPrice());

        holder.btnFoodBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Product> temp = new ArrayList<Product>();
                temp.add(new Product( holder.tvFoodName.getText().toString(),listFood.get(position).getPrice(),1));
                Intent intent = new Intent(v.getContext(), OrderActivity.class);
                intent.putExtra("drink",new Gson().toJson(temp));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return  (listFood != null) ? listFood.size() : 0;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{

        private TextView tvFoodName, tvFoodPrice;
        private Button btnFoodBuy;

        public FoodViewHolder(View view){
            super(view);
            tvFoodName = view.findViewById(R.id.tvFoodName);
            tvFoodPrice = view.findViewById(R.id.tvFoodPrice);
            btnFoodBuy = view.findViewById(R.id.btnFoodBuy);
        }

    }
}
