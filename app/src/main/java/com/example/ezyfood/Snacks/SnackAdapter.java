package com.example.ezyfood.Snacks;

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

public class SnackAdapter extends RecyclerView.Adapter<SnackAdapter.SnackViewHolder> {

    private ArrayList<Product> listSnack;
    private Context context;

    public SnackAdapter(ArrayList<Product> listSnack) {
        this.listSnack = listSnack;
    }

    @NonNull
    @Override
    public SnackAdapter.SnackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_snacks, parent, false);
        context = parent.getContext();
        return new SnackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SnackAdapter.SnackViewHolder holder, final int position) {
        final Product p = listSnack.get(position);
        holder.tvSnackName.setText(listSnack.get(position).getName());
        holder.tvSnackPrice.setText("Rp " + listSnack.get(position).getPrice());
        holder.imageView.setImageDrawable(context.getResources().getDrawable(listSnack.get(position).getImage()));

        holder.btnSnackBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Product> temp = new ArrayList<Product>();
                temp.add(new Product( holder.tvSnackName.getText().toString(),listSnack.get(position).getPrice(),1,p.getImage()));
                Intent intent = new Intent(v.getContext(), OrderActivity.class);
                intent.putExtra("drink",new Gson().toJson(temp));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return  (listSnack != null) ? listSnack.size() : 0;
    }

    public class SnackViewHolder extends RecyclerView.ViewHolder{

        private TextView tvSnackName, tvSnackPrice;
        private Button btnSnackBuy;
        ImageView imageView;

        public SnackViewHolder(@NonNull View view) {
            super(view);
            tvSnackName = view.findViewById(R.id.tvSnackName);
            tvSnackPrice = view.findViewById(R.id.tvSnackPrice);
            btnSnackBuy = view.findViewById(R.id.btnSnackBuy);
            imageView = view.findViewById(R.id.imageSnack);
        }
    }
}
