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
public class GenerateQrcodeActivity extends AppCompatActivity {
    // deux bouton pour la gérération du code QR
    private Button btnGenerate;
    private ImageView imageQRCode;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qrcode);
        btnGenerate = findViewById(R.id.btnGenerate);
        imageQRCode = findViewById(R.id.imageQRCode);

        // Set onClick listener for the login button
        btnGenerate.setOnClickListener(v-> {
                    Intent intent = new Intent(GenerateQrcodeActivity.this, GenerateQrcodeActivity.class);
                    startActivity(intent);
                });

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