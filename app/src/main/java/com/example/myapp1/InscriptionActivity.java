package com.example.myapp1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class InscriptionActivity extends AppCompatActivity {

    private Spinner spinnerUserType;
    private Button btnRegister;
    private ImageView connexionBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        // Initialize views
        spinnerUserType = findViewById(R.id.spinner_user_type);
        btnRegister = findViewById(R.id.btn_register);
        connexionBtn = findViewById(R.id.connexion_back_textview);

        // Setup spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.user_types,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUserType.setAdapter(adapter);

        // Set onClick listener for the register button
        btnRegister.setOnClickListener(v -> {
            Intent i = new Intent(InscriptionActivity.this, HomeActivity.class);
            startActivity(i);
            // Perform registration logic here
        });
        connexionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Rediriger vers l'activité d'inscription
                Intent intent = new Intent(InscriptionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
