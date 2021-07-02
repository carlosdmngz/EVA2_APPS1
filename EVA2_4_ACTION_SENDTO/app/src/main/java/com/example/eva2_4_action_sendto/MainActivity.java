package com.example.eva2_4_action_sendto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtmen, edtnum;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtmen = findViewById(R.id.edtmen);
        edtnum = findViewById(R.id.edtnum);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(this);
    }
    
    public void onClick (View view){
        String sTel, sMensa;

        sTel = "smsto:" + edtnum.getText().toString();
        sMensa = edtmen.getText().toString();

        Intent intent = new Intent(
           Intent.ACTION_SENDTO, Uri.parse(sTel)
        );
        intent.putExtra("sms_body", sMensa);
        startActivity(intent);
    }

}