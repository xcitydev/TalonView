package com.example.talonview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public SharedPreferences sharedPreferences;
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
        setContentView(R.layout.activity_main);

        MeowBottomNavigation bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.add(new MeowBottomNavigation.Model(1, R.drawable.news));
        bottomNavigationView.add(new MeowBottomNavigation.Model(2, R.drawable.world));
        bottomNavigationView.add(new MeowBottomNavigation.Model(3, R.drawable.wallet));
        bottomNavigationView.add(new MeowBottomNavigation.Model(4, R.drawable.swap));
        bottomNavigationView.add(new MeowBottomNavigation.Model(5, R.drawable.settings));
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NewsFragment()).commit();
        bottomNavigationView.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment selectedItem = null;
                switch (item.getId()){
                    case 1:
                        selectedItem = new NewsFragment();
                        break;
                    case 2:
                        selectedItem = new DappFragment();
                        break;
                    case 3:
                        selectedItem = new WalletFragment();
                        break;
                    case 4:
                        selectedItem = new SwapFragment();
                        break;
                    case 5:
                        selectedItem = new SettingsFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedItem).commit();
            }
        });
        bottomNavigationView.setCount(1, "10");
        bottomNavigationView.show(2,true);
        bottomNavigationView.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

            }
        });
        bottomNavigationView.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

            }
        });
    }
}