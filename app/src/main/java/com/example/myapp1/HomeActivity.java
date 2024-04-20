package com.example.myapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button generateQRBtn,scanQRBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        generateQRBtn = findViewById(R.id.idbtnGenerateQR);
        scanQRBtn = findViewById(R.id.idbtnScanQR);
        generateQRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(HomeActivity.this,GenerateQrcodeActivity.class);
                startActivity(i);
            }
        });
        scanQRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(HomeActivity.this,ScannQrcodeActivity.class);
                startActivity(i);
            }
        });

    }
}