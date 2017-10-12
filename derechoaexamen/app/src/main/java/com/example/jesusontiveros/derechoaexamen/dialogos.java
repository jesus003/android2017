package com.example.jesusontiveros.derechoaexamen;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class dialogos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogos);
    }
    public void DialogImagen(View vv) {
        final AlertDialog builder = new AlertDialog.Builder(this).create();
        LayoutInflater inflater = this.getLayoutInflater();
        View v = inflater.inflate(R.layout.imagen, null);
        builder.setView(v);

        builder.show();
    }
    public  void regresar (View v){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
        this.finish();
    }

}
