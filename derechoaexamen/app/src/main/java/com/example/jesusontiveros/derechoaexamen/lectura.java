package com.example.jesusontiveros.derechoaexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    public  void regresar (View v){
        Intent intent = new Intent(getBaseContext(), qr.class);
        startActivity(intent);
        this.finish();
    }
}
