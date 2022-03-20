package com.example.talonview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class SwapFragment extends Fragment {
    private EditText upEdt, downEdt;
    private View view;
    int btc = 41000;
    int ltc = 134;
    int xrp = 2;
    int ada = 3;
    public SwapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_swap, container, false);
        upEdt = view.findViewById(R.id.topEdt);
        downEdt = view.findViewById(R.id.downEdt);
        upEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    String currentValue = upEdt.getText().toString();
                    int currentV = Integer.parseInt(currentValue);
                    float ma = currentV*btc;
                    float maa = ma/ltc;
                    String mann = String.valueOf(maa);
                    downEdt.setText(mann);
                }catch (Exception ignored){
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;
    }
    public void Cal(){



    }
}