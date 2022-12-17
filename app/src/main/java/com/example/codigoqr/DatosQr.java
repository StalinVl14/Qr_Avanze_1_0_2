package com.example.codigoqr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class DatosQr extends AppCompatActivity  {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_qr);

        IntentIntegrator integrator = new IntentIntegrator( DatosQr.this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        integrator.setPrompt("Lector - QR");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(true);
        integrator.setBarcodeImageEnabled(true);
        integrator.initiateScan();
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {

        IntentResult result  = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result !=null){
            if(result.getContents()== null){
                Toast.makeText(this,"Lectura cancelada", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this,result.getContents(), Toast.LENGTH_LONG).show();
                //txtResultado.setText(result.getContents());
            }
        }else {

            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
