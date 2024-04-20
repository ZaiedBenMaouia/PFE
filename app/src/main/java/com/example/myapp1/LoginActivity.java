package com.example.myapp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        btnLogin = findViewById(R.id.btn_login);

        // Set onClick listener for the login button
        btnLogin.setOnClickListener(v -> {
            Intent i = new Intent(LoginActivity.this, InscriptionActivity.class);
            startActivity(i);
            // Perform login logic here
        });
    }
}