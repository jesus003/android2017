package com.example.jesusontiveros.scannerqr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class lectura extends AppCompatActivity {

    EditText txt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectura);
        txt =(EditText)findViewById(R.id.txtLeido);
        String s = getIntent().getStringExtra("TEXTO");
        txt.setText(s);
    }
}
