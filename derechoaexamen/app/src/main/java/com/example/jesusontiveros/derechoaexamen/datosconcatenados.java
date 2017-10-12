package com.example.jesusontiveros.derechoaexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class datosconcatenados extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datosconcatenados);
        txt =(TextView) findViewById(R.id.txtNombre);
        String s = getIntent().getStringExtra("NOMBRE");
        txt.setText(s);
    }
    public  void regresar (View v){
        Intent intent = new Intent(getBaseContext(), pasardatos.class);
        startActivity(intent);
        this.finish();
    }
}
