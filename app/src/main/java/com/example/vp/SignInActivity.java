package com.example.vp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class SignInActivity extends AppCompatActivity {

    private static final String TAG = "TEST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        EditText password_field = findViewById(R.id.password_field);
        EditText username_field = findViewById(R.id.username_field);
        Button sign_in_button = findViewById(R.id.sign_in);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        ArrayList<Map<String, Object>> users = new ArrayList<>();
        db.collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        users.add(document.getData());
                        System.out.println(users);
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
                            if ((boolean) Objects.requireNonNull(user.get("isadmin"))) {
                                Intent myIntent = new Intent(SignInActivity.this, SignUpActivity.class);
                                startActivity(myIntent);
                            }
                        }
                    }
                }
            }
        });
    }
}