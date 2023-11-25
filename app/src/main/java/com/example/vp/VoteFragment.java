package com.example.vp;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.*;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

public class VoteFragment extends Fragment {

    boolean flag1 = false;
    boolean flag2 = false;
    boolean flag3 = false;
    boolean flag4 = false;

    public VoteFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vote, container, false);
        ImageButton imageButton1 = rootView.findViewById(R.id.voiting1);;
        TextView textButton1 = rootView.findViewById(R.id.voitingtext1);;
        ImageButton imageButton2 = rootView.findViewById(R.id.voiting2);;
        TextView textButton2 = rootView.findViewById(R.id.voitingtext2);;
        ImageButton imageButton3 = rootView.findViewById(R.id.voiting3);;
        TextView textButton3 = rootView.findViewById(R.id.voitingtext3);;
        ImageButton imageButton4 = rootView.findViewById(R.id.voiting4);;
        TextView textButton4 = rootView.findViewById(R.id.voitingtext4);;


        imageButton1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                // меняем изображение на кнопке
                if (flag1) {
                    imageButton1.setImageResource(R.drawable.vote1);
                    textButton1.setTextColor(0xAAD9D9D9);
                }
                else {
                    // возвращаем первую картинку
                    imageButton1.setImageResource(R.drawable.vote2);
                    textButton1.setTextColor(0xAA31A742);
                    imageButton2.setImageResource(R.drawable.vote1);
                    textButton2.setTextColor(0xAAD9D9D9);
                    imageButton3.setImageResource(R.drawable.vote1);
                    textButton3.setTextColor(0xAAD9D9D9);
                    imageButton4.setImageResource(R.drawable.vote1);
                    textButton4.setTextColor(0xAAD9D9D9);
                    flag2 = false;
                    flag3 = false;
                    flag4 = false;
                }
                flag1 = !flag1;
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                // меняем изображение на кнопке
                if (flag2) {
                    imageButton2.setImageResource(R.drawable.vote1);
                    textButton2.setTextColor(0xAAD9D9D9);
                }
                else {
                    // возвращаем первую картинку
                    imageButton2.setImageResource(R.drawable.vote2);
                    textButton2.setTextColor(0xAA31A742);
                    imageButton1.setImageResource(R.drawable.vote1);
                    textButton1.setTextColor(0xAAD9D9D9);
                    imageButton3.setImageResource(R.drawable.vote1);
                    textButton3.setTextColor(0xAAD9D9D9);
                    imageButton4.setImageResource(R.drawable.vote1);
                    textButton4.setTextColor(0xAAD9D9D9);
                    flag1 = false;
                    flag3 = false;
                    flag4 = false;
                }
                flag2 = !flag2;
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                // меняем изображение на кнопке
                if (flag3) {
                    imageButton3.setImageResource(R.drawable.vote1);
                    textButton3.setTextColor(0xAAD9D9D9);
                }
                else {
                    // возвращаем первую картинку
                    imageButton3.setImageResource(R.drawable.vote2);
                    textButton3.setTextColor(0xAA31A742);
                    imageButton1.setImageResource(R.drawable.vote1);
                    textButton1.setTextColor(0xAAD9D9D9);
                    imageButton2.setImageResource(R.drawable.vote1);
                    textButton2.setTextColor(0xAAD9D9D9);
                    imageButton4.setImageResource(R.drawable.vote1);
                    textButton4.setTextColor(0xAAD9D9D9);
                    flag1 = false;
                    flag2 = false;
                    flag4 = false;
                }
                flag3 = !flag3;
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                // меняем изображение на кнопке
                if (flag4) {
                    imageButton4.setImageResource(R.drawable.vote1);
                    textButton4.setTextColor(0xAAD9D9D9);
                }
                else {
                    // возвращаем первую картинку
                    imageButton4.setImageResource(R.drawable.vote2);
                    textButton4.setTextColor(0xAA31A742);
                    imageButton1.setImageResource(R.drawable.vote1);
                    textButton1.setTextColor(0xAAD9D9D9);
                    imageButton2.setImageResource(R.drawable.vote1);
                    textButton2.setTextColor(0xAAD9D9D9);
                    imageButton3.setImageResource(R.drawable.vote1);
                    textButton3.setTextColor(0xAAD9D9D9);
                    flag1 = false;
                    flag2 = false;
                    flag3 = false;
                }
                flag4 = !flag4;
            }
        });
        return rootView;
    }
}