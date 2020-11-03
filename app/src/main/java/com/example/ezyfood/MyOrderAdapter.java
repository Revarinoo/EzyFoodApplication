package com.example.ezyfood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyOrderViewHolder> {

    private ArrayList<Product> drink2 = new ArrayList<Product>();
    private onItemClickListener listener;

    public interface onItemClickListener{
        void DeleteClick(int position);
    }

    public void onItemClickListener (onItemClickListener listener){
        this.listener = listener;
    }

    public MyOrderAdapter(ArrayList<Product> drink2) {
        this.drink2 = drink2;
    }

    @NonNull
    @Override
    public MyOrderAdapter.MyOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_my_order, parent, false);
        return new MyOrderViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyOrderAdapter.MyOrderViewHolder holder, final int position) {

        final Product drink = drink2.get(position);
        holder.tvMyName.setText(drink2.get(position).getName());
        holder.tvMyPrice.setText("Rp " + drink2.get(position).getPrice());
        holder.tvMyQty.setText(String.valueOf(drink2.get(position).getQty()));

    }

    @Override
    public int getItemCount() {
        return (drink2 != null) ? drink2.size() : 0;
    }


    public class MyOrderViewHolder extends RecyclerView.ViewHolder{

        TextView tvMyName, tvMyQty, tvMyPrice;
        Button btnDelete;

        public MyOrderViewHolder(@NonNull View view, final onItemClickListener listener) {
            super(view);
            tvMyName = view.findViewById(R.id.tvMyName);
            tvMyQty = view.findViewById(R.id.tvMyQty);
            tvMyPrice = view.findViewById(R.id.tvMyPrice);
            btnDelete = view.findViewById(R.id.btnDelete);


            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.DeleteClick(position);
                        }
                    }
                }
            });
        }
    }
}
