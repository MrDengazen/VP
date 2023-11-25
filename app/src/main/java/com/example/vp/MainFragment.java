package com.example.vp;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
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
        Fragment allFragment = new AllFragment();
        Fragment chinaFragment = new ChinaFragment();
        Fragment franceFragment = new FranceFragment();
        Fragment italyFragment = new ItalyFragment();
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.kitchen, allFragment)
                .commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i) {
                    case R.id.all:
                        getChildFragmentManager()
                                .beginTransaction()
                                .replace(R.id.kitchen, allFragment)
                                .commit();
                        break;
                    case R.id.china:
                        getChildFragmentManager()
                                .beginTransaction()
                                .replace(R.id.kitchen, chinaFragment)
                                .commit();
                        break;
                    case R.id.italy:
                        getChildFragmentManager()
                                .beginTransaction()
                                .replace(R.id.kitchen, franceFragment)
                                .commit();
                        break;
                    case R.id.france:
                        getChildFragmentManager()
                                .beginTransaction()
                                .replace(R.id.kitchen, italyFragment)
                                .commit();
                        break;

                    default:
                        break;
                }
            }
        });
        return myView;
    }
}
