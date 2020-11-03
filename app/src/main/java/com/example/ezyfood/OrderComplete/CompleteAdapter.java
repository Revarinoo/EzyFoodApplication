package com.example.ezyfood.OrderComplete;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.Product;
import com.example.ezyfood.R;

import java.util.ArrayList;

public class CompleteAdapter extends RecyclerView.Adapter<CompleteAdapter.CompleteViewHolder> {

    private ArrayList<Product> listDrink = new ArrayList<Product>();

    public CompleteAdapter(ArrayList<Product> listDrink) {
        this.listDrink = listDrink;
    }

    @NonNull
    @Override
    public CompleteAdapter.CompleteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_order_complete, parent, false);
        return new CompleteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompleteAdapter.CompleteViewHolder holder, int position) {
            holder.txtName.setText(listDrink.get(position).getName());
            holder.txtPrice.setText("Rp "+listDrink.get(position).getPrice());
            holder.txtQty.setText(String.valueOf(listDrink.get(position).getQty()));
    }

    @Override
    public int getItemCount() {
        return (listDrink != null) ? listDrink.size() : 0;
    }

    public class CompleteViewHolder extends RecyclerView.ViewHolder{

        TextView txtPrice, txtName, txtQty;

        public CompleteViewHolder(@NonNull View view) {
            super(view);
            txtName = view.findViewById(R.id.txtName);
            txtPrice = view.findViewById(R.id.txtPrice);
            txtQty = view.findViewById(R.id.txtQty);
        }
    }
}
