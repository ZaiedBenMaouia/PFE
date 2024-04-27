package com.example.myapp1;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.zxing.Result;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

//import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannQrcodeActivity extends AppCompatActivity {

    //Todo: Il faut enlever le code en commentaire et déplacer le nouveau code ici

//    private static final int CAMERA_PERMISSION_REQUEST_CODE = 200;
//    private ZXingScannerView scannerView;
//    private Button scanButton;
//
//    @SuppressLint("WrongViewCast")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_scan_qr);
//
//        scannerView = findViewById(R.id.camera_preview);
//        scanButton = findViewById(R.id.btn_scan);
//
//        scanButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startScanning();
//            }
//        });
//
//        // Demander l'autorisation de la caméra si elle n'est pas déjà accordée
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
//        }
//    }
//
//    private void startScanning() {
//        scannerView.setResultHandler(this);
//        scannerView.startCamera();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        if (scannerView != null) {
//            scannerView.stopCamera();
//        }
//    }
//
//    @Override
//    public void handleResult(Result rawResult) {
//        // Gérer le résultat du scan ici
//        Toast.makeText(this, "QR Code scanned: " + rawResult.getText(), Toast.LENGTH_SHORT).show();
//
//        // Reprendre le scan
//        scannerView.resumeCameraPreview(this);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                startScanning();
//            } else {
//                Toast.makeText(this, "Camera permission is required to scan QR codes", Toast.LENGTH_SHORT).show();
//                finish(); // Fermer l'activité si l'autorisation n'est pas accordée
//            }
//        }
//    }
}


