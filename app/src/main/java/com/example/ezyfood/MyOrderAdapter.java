package com.example.ezyfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyOrderViewHolder> {

    private ArrayList<Product> Order = new ArrayList<Product>();
    private onItemClickListener listener;
    private Context context;

    public interface onItemClickListener{
        void DeleteClick(int position);
    }

    public void onItemClickListener (onItemClickListener listener){
        this.listener = listener;
    }

    public MyOrderAdapter(ArrayList<Product> Order) {
        this.Order = Order;
    }

    @NonNull
    @Override
    public MyOrderAdapter.MyOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_my_order, parent, false);
        context = parent.getContext();
        return new MyOrderViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyOrderAdapter.MyOrderViewHolder holder, final int position) {

        final Product order = Order.get(position);
        holder.tvMyName.setText(Order.get(position).getName());
        holder.tvMyPrice.setText("Rp " + Order.get(position).getPrice());
        holder.tvMyQty.setText(String.valueOf(Order.get(position).getQty()));
        holder.imageView.setImageDrawable(context.getResources().getDrawable(order.getImage()));

    }

    @Override
    public int getItemCount() {
        return (Order != null) ? Order.size() : 0;
    }


    public class MyOrderViewHolder extends RecyclerView.ViewHolder{

        TextView tvMyName, tvMyQty, tvMyPrice;
        Button btnDelete;
        ImageView imageView;

        public MyOrderViewHolder(@NonNull View view, final onItemClickListener listener) {
            super(view);
            tvMyName = view.findViewById(R.id.tvMyName);
            tvMyQty = view.findViewById(R.id.tvMyQty);
            tvMyPrice = view.findViewById(R.id.tvMyPrice);
            btnDelete = view.findViewById(R.id.btnDelete);
            imageView = view.findViewById(R.id.imageMyOrder);

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
