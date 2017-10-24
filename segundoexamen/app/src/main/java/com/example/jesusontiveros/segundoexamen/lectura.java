package com.example.jesusontiveros.segundoexamen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class lectura extends AppCompatActivity {

    RadioButton tarjeta,efectivo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectura);
        String data = getIntent().getStringExtra("TEXTO");
        String[] info = data.split(",");
        TextView marca = (TextView)findViewById(R.id.txtMarca);
        TextView modelo = (TextView)findViewById(R.id.txtModelo);
        TextView ano = (TextView)findViewById(R.id.txtano);
        TextView adeudo = (TextView)findViewById(R.id.txtAdeudo);
        tarjeta = (RadioButton) findViewById(R.id.rdbTarjeta);
        efectivo = (RadioButton) findViewById(R.id.rdbEfectivo);
        marca.setText("Marca "+info[0]);
        modelo.setText("Modelo "+info[1]);
        ano.setText("Año "+info[2]);
        adeudo.setText("Adeudo "+info[3]);
    }

    public void pagar(View v){
        if (tarjeta.isChecked()){
            Toast.makeText(getApplicationContext(),"Gracias por pagar con tarjetaa.",Toast.LENGTH_SHORT).show();
        }
        if (efectivo.isChecked()){
            Toast.makeText(getApplicationContext(),"Gracias por pagar con efectivo.",Toast.LENGTH_SHORT).show();
        }

    }
}
