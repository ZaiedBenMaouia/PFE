package com.example.myapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.graphics.Bitmap;
import android.widget.Toast;

import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.google.zxing.BarcodeFormat;

public class MainActivity  extends AppCompatActivity {
    private Button btnLogin;

    // deux bouton pour la gérération du code QR
    private Button btnGenerate;
    private ImageView imageQRCode;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        btnLogin = findViewById(R.id.btn_login);
        btnGenerate = findViewById(R.id.btnGenerate);
        imageQRCode = findViewById(R.id.imageQRCode);

        // Set onClick listener for the login button
        btnLogin.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, InscriptionActivity.class);
            startActivity(i);
            // Perform login logic here
        });

        // Set onClick listener for the generate QR code button
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateQRCode("Mettre le texte ou le lien que tu veux générer!!!");
            }
        });
    }

    private void generateQRCode(String textToEncode) {
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        try {
            Bitmap bitmap = barcodeEncoder.encodeBitmap(textToEncode, BarcodeFormat.QR_CODE, 400, 400);
            imageQRCode.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
            Toast.makeText(this, "Erreur lors de la génération du QR code", Toast.LENGTH_SHORT).show();
        }
    }
}
