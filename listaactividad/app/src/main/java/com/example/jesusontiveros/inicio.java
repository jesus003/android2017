package com.example.jesusontiveros;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jesusontiveros.listaactividad.R;

public class inicio extends AppCompatActivity {

    TextView nombres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        nombres = (TextView)findViewById(R.id.lblNombres);
        String s = getIntent().getStringExtra("NOMBRE");
        nombres.setText(s);

    }

}
