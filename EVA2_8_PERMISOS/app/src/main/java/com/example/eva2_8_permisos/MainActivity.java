package com.example.eva2_8_permisos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static int PERMISO_LLAMAR = 100;
    Button btnCall;
    EditText edtTxtNum;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCall = findViewById(R.id.btnCall);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

            Toast.makeText(this, "NO TIENES PERMISOS", Toast.LENGTH_SHORT).show();
            btnCall.setEnabled(false);
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    PERMISO_LLAMAR);
        }else{
            Toast.makeText(this, "YA TIENES PERMISOS", Toast.LENGTH_SHORT).show();
            btnCall.setEnabled(true);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        edtTxtNum = findViewById(R.id.edtTxtNum);
    }

    public void onClick(View view) {
        String sTel = "tel: " + edtTxtNum.getText().toString();
        intent = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISO_LLAMAR:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    btnCall.setEnabled(true);
                    Toast.makeText(this, "PERMISO CONCEDIDO", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "PERMISO DENEGADO", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}