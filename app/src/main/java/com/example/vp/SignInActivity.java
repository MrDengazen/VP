package com.example.vp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SignInActivity extends AppCompatActivity {

    private static final String TAG = "TEST";
    SharedPreferences sPref;
    boolean is_logged = false;
    boolean is_admin = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        if(!isNetworkAvailable(this)){
            setContentView(R.layout.activity_sign_in_offline);
        }
        else{
            setContentView(R.layout.activity_sign_in);
            EditText password_field = findViewById(R.id.password_field);
            EditText username_field = findViewById(R.id.username_field);
            Button sign_in_button = findViewById(R.id.sign_in);
            sPref = getSharedPreferences("user", Context.MODE_PRIVATE);
            is_logged = sPref.getBoolean("is_logged", false);
            if(is_logged)
            {
                is_admin = sPref.getBoolean("is_admin", false);
                if(is_admin){
                    Intent intent2 = new Intent(this, SignUpActivity.class);
                    startActivity(intent2);
                }else{
                    Intent intent2 = new Intent(this, UserActivity.class);
                    startActivity(intent2);
                }
            }
            else {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                ArrayList<Map<String, Object>> users = new ArrayList<>();
                db.collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                users.add(document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
                sign_in_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String username = username_field.getText().toString();
                        String password = password_field.getText().toString();
                        if (username.length() > 0 && password.length() > 0) {
                            for (Map<String, Object> user : users) {
                                String user_password = Objects.requireNonNull(user.get("password")).toString();
                                String user_username = Objects.requireNonNull(user.get("username")).toString();
                                if (user_username.equals(username) && user_password.equals(password)) {
                                    SharedPreferences.Editor editor = sPref.edit();
                                    editor.putBoolean("is_logged", true);
                                    if ((boolean) Objects.requireNonNull(user.get("isadmin"))) {
                                        editor.putBoolean("is_admin", true);
                                        editor.apply();
                                        Intent intent2 = new Intent(v.getContext(), SignUpActivity.class);
                                        startActivity(intent2);
                                    } else {
                                        editor.putBoolean("is_admin", false);
                                        editor.apply();
                                        Intent intent2 = new Intent(v.getContext(), UserActivity.class);
                                        startActivity(intent2);
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
    }
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager conMan = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(conMan.getActiveNetworkInfo() != null && conMan.getActiveNetworkInfo().isConnected())
            return true;
        else
            return false;
    }
}