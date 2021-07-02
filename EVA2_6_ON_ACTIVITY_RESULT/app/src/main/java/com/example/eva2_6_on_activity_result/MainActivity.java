package com.example.eva2_6_on_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final static int CODIGO_SECUN = 1000;
    final static int CODIGO_CONTACTOS = 2000;
    final static int CODIGO_GALERIA = 3000;

    Button btnGo;
    Intent intent, intentCont,intentGaleria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, Secundaria.class);
        intentCont = new Intent(Intent.ACTION_PICK, android.provider.ContactsContract.Contacts.CONTENT_URI);
        intentGaleria= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);


    }

    @Override
    public void onStart() {
        super.onStart();
        btnGo = findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("DATOS","Información enviada desde principal!");
                startActivityForResult(intent, CODIGO_SECUN);

            }

        });

    }
    public void onClickCont (View v) {
        startActivityForResult(intentCont,CODIGO_CONTACTOS);

    }
    public void onClickGaleria (View v) {
        startActivityForResult(intentGaleria,CODIGO_GALERIA);

    }
    @Override
    protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        //AQUI PROCESAMOS LA RESPUESTA DE LA ACTIVIDAD
        //1. IDENTIFICAR LA ACTIVIDAD QUE DEVOLVIÓ EL RESULTADO
        //IDENTIFICAR SI SE DEVOLVIÓ UN VALOR O NO
        //LEER LOS DATOS (INTENT)
        switch (requestCode) {
            case CODIGO_SECUN:
                if (resultCode == Activity.RESULT_OK) {//SI ME DEVOLVIÓ UN VALOR
                    //LEER LOS DATOS
                    Toast.makeText(this, data.getStringExtra("VALOR"), Toast.LENGTH_SHORT).show();
                }
                break;
            case CODIGO_CONTACTOS:
                if (resultCode == Activity.RESULT_OK) {
                    String returnedData = data.getDataString();
                    Toast.makeText(this, returnedData, Toast.LENGTH_SHORT).show();
                }
                break;
            case CODIGO_GALERIA:
                if (resultCode == Activity.RESULT_OK) {
                    String returnedData = data.getDataString();
                    Toast.makeText(this, returnedData, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}