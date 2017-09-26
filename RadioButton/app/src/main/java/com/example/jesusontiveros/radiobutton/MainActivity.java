package com.example.jesusontiveros.radiobutton;

import android.hardware.display.VirtualDisplay;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton masculino,femenino;
    EditText txt1,txt2,txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        masculino = (RadioButton)findViewById(R.id.rdbMasculino);
        femenino = (RadioButton)findViewById(R.id.rdbFemenino);
        txt1 = (EditText) findViewById(R.id.txt1);
        txt2 = (EditText) findViewById(R.id.txt2);
        txt3 = (EditText) findViewById(R.id.txt3);
    }
    public void BMasculino (View v){

        Toast.makeText(getApplicationContext(),"Mesculino",Toast.LENGTH_SHORT).show();
        txt1.setVisibility(View.VISIBLE);
        txt2.setVisibility(View.VISIBLE);
        txt3.setVisibility(View.VISIBLE);
    }
    public void BFemenino (View v){

        Toast.makeText(getApplicationContext(),"Femenino",Toast.LENGTH_SHORT).show();
        txt1.setVisibility(View.VISIBLE);
        txt2.setVisibility(View.VISIBLE);
        txt3.setVisibility(View.INVISIBLE);
    }


}
