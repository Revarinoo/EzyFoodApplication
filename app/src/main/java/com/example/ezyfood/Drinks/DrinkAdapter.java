package com.example.ezyfood.Drinks;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.OrderActivity;
import com.example.ezyfood.Product;
import com.example.ezyfood.R;
import com.google.gson.Gson;

import java.util.ArrayList;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder> {

    private ArrayList<Product> listDrink;
    private Context context;

    public DrinkAdapter(ArrayList<Product> listDrink) {
        this.listDrink = listDrink;
    }

    @NonNull
    @Override
    public DrinkAdapter.DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_drinks, parent, false);
        context = parent.getContext();
        return new DrinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DrinkAdapter.DrinkViewHolder holder, final int position) {
        holder.tvName.setText(listDrink.get(position).getName());
        holder.tvPrice.setText("Rp " + listDrink.get(position).getPrice());
        holder.imageView.setImageDrawable(context.getResources().getDrawable(listDrink.get(position).getImage()));
        final Product p = listDrink.get(position);
        holder.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Product> temp = new ArrayList<Product>();
                temp.add(new Product( holder.tvName.getText().toString(),listDrink.get(position).getPrice(),1,p.getImage()));
                Intent intent = new Intent(v.getContext(), OrderActivity.class);
                intent.putExtra("drink",new Gson().toJson(temp));
                v.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return (listDrink != null) ? listDrink.size() : 0;
    }

    public class DrinkViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName, tvPrice;
        private Button btnBuy;
        private ImageView imageView;

        public DrinkViewHolder(View view){
            super(view);
            tvName = view.findViewById(R.id.tvName);
            tvPrice = view.findViewById(R.id.tvPrice);
            btnBuy = view.findViewById(R.id.btnBuy);
            imageView = view.findViewById(R.id.imageDrink);
        }

    }
}
