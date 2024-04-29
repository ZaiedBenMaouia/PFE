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
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.google.zxing.BarcodeFormat;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;

    // deux bouton pour la gérération du code QR
    private Button btnGenerate;
    private ImageView imageQRCode;

    TextView signupTextView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        btnLogin = findViewById(R.id.btn_login);
        btnGenerate = findViewById(R.id.btnGenerate);
        imageQRCode = findViewById(R.id.imageQRCode);
        signupTextView = findViewById(R.id.signup_textview);

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

        signupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Rediriger vers l'activité d'inscription
                Intent intent = new Intent(MainActivity.this, InscriptionActivity.class);
                startActivity(intent);
            }
        });
    }

    //Scenner le code QR (il faut la changer dans la classe ScanQrcodeActivity)
    public void startQRScan(View view) {
        // Initialiser le scanner de codes QR
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setOrientationLocked(false); // Si tu veux faire la rotation du camera (c est un Boolean)
        integrator.setPrompt("Scannez un code QR");
        integrator.initiateScan();
    }

    //Scenner le code QR (il faut la changer dans la classe ScanQrcodeActivity)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Récupérer le résultat du scan
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                // Si le scan est annulé
                Toast.makeText(this, "Scan annulé", Toast.LENGTH_LONG).show();
            } else {
                // Si un code QR est détecté
                String scannedData = result.getContents();
                Toast.makeText(this, "Code QR détecté : " + scannedData, Toast.LENGTH_LONG).show();
            }
        }
    }

    // Pour la génération du code QR (il faut la changer dans la classe GenerateQrcodeActivity)
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
