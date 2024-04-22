package com.example.myapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity  extends AppCompatActivity {
    private Button btnLogin;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Tu peux mettre ton business ici ...
        // Assuming your XML layout file is named activity_main.xml
        setContentView(R.layout.activity_main);

        // Initialize views
        btnLogin = findViewById(R.id.btn_login);

        // Set onClick listener for the login button
        btnLogin.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, InscriptionActivity.class);
            startActivity(i);
            // Perform login logic here
        });
    }
}
