package com.example.talonview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class WalletFragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    CoinAdapter coinAdapter;
    ArrayList<Data> dataArrayList;

    public WalletFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_wallet, container, false);
        recyclerView = view.findViewById(R.id.recycleview);
        dataArrayList = new ArrayList<>();
        dataArrayList.add(new Data("Algo", R.drawable.ic_algol,"$23","+34%","1","~0.9"));
        dataArrayList.add(new Data("Yieldly", R.drawable.yld,"$123","+102%","1","~9"));
        dataArrayList.add(new Data("Talon", R.drawable.tal,"$17","+10302%","1","~19"));
        dataArrayList.add(new Data("Xrp", R.drawable.xrp,"$3","+10%","1","~7"));
        dataArrayList.add(new Data("ADA", R.drawable.ada,"$3","+0.23%","1","~12"));
        dataArrayList.add(new Data("ADA", R.drawable.ada,"$3","+102%","1","~59"));
        dataArrayList.add(new Data("ADA", R.drawable.ada,"$3","+12%","1","~32"));

        coinAdapter = new CoinAdapter(dataArrayList, getContext());
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(coinAdapter);
        return view;
    }
}