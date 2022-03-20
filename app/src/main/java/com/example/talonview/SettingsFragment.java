package com.example.talonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Objects;

public class SettingsFragment extends Fragment {

    private Switch changeMode;
    private View view;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("MyPref",Context.MODE_PRIVATE);
        String isOn = sharedPreferences.getString("isOn","");
        changeMode = view.findViewById(R.id.changeMode);
        if (isOn.contains("true")){
            changeMode.setChecked(false);
        }else if (isOn.contains("false")){
            changeMode.setChecked(true);
        }
        changeMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("isOn", "false");
                    editor.apply();
                    Toast.makeText(getContext(), "Restart your app to see changes", Toast.LENGTH_SHORT).show();
                    changeMode.setChecked(true);
                }else{
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("isOn", "true");
                    editor.apply();
                    Toast.makeText(getContext(),"Restart your app to see changes", Toast.LENGTH_SHORT).show();
                    changeMode.setChecked(false);
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}