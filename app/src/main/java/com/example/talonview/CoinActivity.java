package com.example.talonview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class CoinActivity extends AppCompatActivity {
    public SharedPreferences sharedPreferences;
    private String coinName, coinValue, coinPrice, coinSymbol;
    private int img;
    private ImageView imgView, bax;
    private TextView name, price, value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("MyPref",MODE_PRIVATE);
        String isOn = sharedPreferences.getString("isOn","");
        if (isOn.contains("true")){
            setTheme(R.style.Light);
        }else if (isOn.contains("false")){
            setTheme(R.style.dark);
        }
        setContentView(R.layout.activity_coin);
        LineChart chart;
        ArrayList<Entry> dataSet = new ArrayList<>();
        coinName = getIntent().getStringExtra("coinName");
        coinValue = getIntent().getStringExtra("coinValue");
        coinPrice = getIntent().getStringExtra("coinPrice");
        coinSymbol = getIntent().getStringExtra("coinPrice");
        img = getIntent().getIntExtra("coinImg",1);

        dataSet.add(new Entry(10f,100f));
        dataSet.add(new Entry(20f,200f));
        dataSet.add(new Entry(30f,300f));
        dataSet.add(new Entry(40f,400f));
        dataSet.add(new Entry(50f,500f));
        dataSet.add(new Entry(60f,600f));
        chart = findViewById(R.id.graph);
        LineDataSet lineData = new LineDataSet(dataSet, "Entries");
        LineData lineData1 = new LineData(lineData);
        chart.setData(lineData1);

        imgView = findViewById(R.id.coinLogo);
        bax = findViewById(R.id.bax);
        name = findViewById(R.id.coinNameCoinAct);
        price = findViewById(R.id.coinPLay1);
        value = findViewById(R.id.btcSmall);

        Glide.with(this).load(img).into(imgView);
        name.setText(coinName);
        price.setText(coinPrice);
        value.setText(coinValue);

        bax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    
}