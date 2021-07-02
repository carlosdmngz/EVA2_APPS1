package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    EditText edtNombre,edtApe,edtTarj,edtEdad;
    RadioButton rdTrab,rdEst,rdDes;
    RadioGroup rdGp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this,MainActivity2.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        edtNombre = findViewById(R.id.edtNombre);
        edtApe = findViewById(R.id.edtApe);
        edtTarj = findViewById(R.id.edtTarj);
        edtEdad = findViewById(R.id.edtEdad);
        rdTrab = findViewById(R.id.rdTrab);
        rdEst = findViewById(R.id.rdEst);
        rdDes = findViewById(R.id.rdDes);
        rdGp = findViewById(R.id.rdGp);
    }

    public void onClick(View v){
        intent.putExtra("NOMBRE",edtNombre.getText().toString());
        intent.putExtra("APELLIDO",edtApe.getText().toString());
        intent.putExtra("CORREO",edtTarj.getText().toString());
        int dEdad = 0;
        dEdad = Integer.parseInt(edtEdad.getText().toString());
        intent.putExtra("EDAD",dEdad);
        intent.putExtra("OCUPACION",rdGp.getCheckedRadioButtonId());
        startActivity(intent);
    }
}