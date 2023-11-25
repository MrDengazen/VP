package com.example.vp;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.io.*;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    public MainFragment(){
    }
    View myView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_main, container, false);
        RadioGroup radioGroup = myView.findViewById(R.id.rg);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i) {
                    case R.id.all:
                        System.out.println(14);
                        break;
                    case R.id.china:
                        Log.i("123", "china");
                        break;
                    case R.id.italy: Log.i("123", "italy");
                        break;
                    case R.id.france: Log.i("123", "france");
                        break;

                    default:
                        break;
                }
            }
        });
        return myView;
    }
}
