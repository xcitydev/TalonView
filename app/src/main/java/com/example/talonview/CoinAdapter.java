package com.example.talonview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.ViewHolder> {
    public ArrayList<Data> coinData = new ArrayList<>();
    public Context mContext;

    public CoinAdapter(ArrayList<Data> coinData, Context mContext) {
        this.coinData = coinData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CoinAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_view,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(mContext).load(coinData.get(position).img).into(holder.imageCoin);
        holder.coinValue.setText(coinData.get(position).coinValue);
        holder.coinName.setText(coinData.get(position).coinName);
        holder.coinPrice.setText(coinData.get(position).coinPrice);
        holder.coinEqv.setText(coinData.get(position).coinEqv);
        holder.coinAmt.setText(coinData.get(position).coinAmt);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CoinActivity.class);
                intent.putExtra("coinName",coinData.get(position).coinName);
                intent.putExtra("coinValue",coinData.get(position).coinValue);
                intent.putExtra("coinPrice",coinData.get(position).coinPrice);
                intent.putExtra("coinImg",coinData.get(position).img);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return coinData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView coinPrice, coinValue, coinAmt, coinEqv, coinName;
        public ImageView imageCoin;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coinAmt = itemView.findViewById(R.id.coinAmt);
            coinEqv = itemView.findViewById(R.id.coinEqv);
            coinName = itemView.findViewById(R.id.coinName);
            coinPrice = itemView.findViewById(R.id.coinPrice);
            coinValue = itemView.findViewById(R.id.coinValue);
            imageCoin = itemView.findViewById(R.id.imgI);
        }
    }
}
