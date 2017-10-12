package com.example.jesusontiveros.derechoaexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class pasardatos extends AppCompatActivity {

    EditText nom,ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasardatos);
        nom = (EditText)findViewById(R.id.txtN);
        ad = (EditText)findViewById(R.id.txtA);

    }
    public  void regresar (View v){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
        this.finish();
    }
    public  void avanzar (View v){
        if (nom.length()>0 && ad.length()>0){
            Intent intent = new Intent(getBaseContext(), datosconcatenados.class);
            intent.putExtra("NOMBRE",nom.getText().toString()+" "+ad.getText().toString());
            startActivity(intent);
            this.finish();
        }

    }
}
