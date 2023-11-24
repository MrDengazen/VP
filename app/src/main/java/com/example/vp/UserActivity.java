package com.example.vp;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserActivity extends AppCompatActivity
        implements BottomNavigationView
        .OnItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);

        bottomNavigationView
                .setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.main);
    }
    MainFragment mainFragment = new MainFragment();
    MenuFragment menuFragment = new MenuFragment();
    CartFragment cartFragment = new CartFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    VoteFragment voteFragment = new VoteFragment();
    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {
        Log.d("WER", String.valueOf(item.getItemId() == R.id.main));
        switch (item.getItemId()) {
            case R.id.main:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, mainFragment)
                        .commit();
                return true;

            case R.id.menu:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, menuFragment)
                        .commit();
                return true;

            case R.id.proflie:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, profileFragment)
                        .commit();
                return true;
            case R.id.vote:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, voteFragment)
                        .commit();
                return true;
            case R.id.cart:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, cartFragment)
                        .commit();
                return true;

        }
        return false;
    }
}
