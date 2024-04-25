package com.example.myapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.nio.channels.WritePendingException;

public class GenerateQrcodeActivity extends AppCompatActivity {
    private TextView qrCodeTV;
    private ImageView qrCodeIV;
    private TextInputEditText dataEdt;
    private Button generateQRbtn;
    private QRGEncoder qrgEncoder;
    private Bitmap bitmap;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qrcode);
        qrCodeTV = findViewById(R.id.idTVGenerateQR);
        qrCodeIV = findViewById(R.id.idIVQrcode);
        dataEdt = findViewById(R.id.idTextInputLayout);
        generateQRbtn = findViewById(R.id.idbtnGenerateQR);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            generateQRbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String data = dataEdt.getText().toString();
                    if (data.isEmpty()) {
                        Toast.makeText(GenerateQrcodeActivity.this, "please enter some data to generate QR Code ..", Toast.LENGTH_SHORT).show();

                    } else {
                        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
                        Display display = manager.getDefaultDisplay();
                        Point point = new Point();
                        display.getSize(point);
                        int width = point.x;
                        int height = point.y;
                        int dimen = width < height ? width : height;
                        dimen = dimen * 3 / 4;

                        Object QRGContents = null;

                        //TODO Modifier la classe QRGEncoder (Ajout de constructeur avec param)
                        //  qrgEncoder = new QRGEncoder(dataEdt.getText().toString(), null, QRGContents.Type.TEXT, dimen);
                        try {
                            bitmap = qrgEncoder.encodeAsBitmap();
                            qrCodeTV.setVisibility(View.GONE);
                            qrCodeIV.setImageBitmap(bitmap);
                            // Start the ResultActivity
                            Intent intent = new Intent(GenerateQrcodeActivity.this, Qr_code.class);
                            intent.putExtra("data", data); // Pass any data you want to the ResultActivity
                            startActivity(intent);

                        } catch (WritePendingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}