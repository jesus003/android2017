package com.example.jesusontiveros.primerparcial;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText total, actual,prom;
    ConstraintLayout back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total =(EditText)findViewById(R.id.txtTotal);
        actual =(EditText)findViewById(R.id.txtActual);
        prom =(EditText)findViewById(R.id.txtPromedio);
        back =(ConstraintLayout) findViewById(R.id.back);
    }
    public   void  sumar5(View v){
        int act = Integer.parseInt(actual.getText().toString());
        actual.setText(""+(act+5));
    }
    public  void  sumar15(View v){
        int act = Integer.parseInt(actual.getText().toString());
        actual.setText(""+(act+15));
    }
    public  void  sumar30(View v){
        int act = Integer.parseInt(actual.getText().toString());
        actual.setText(""+(act+30));
    }
    public  void  sumar50(View v){
        int act = Integer.parseInt(actual.getText().toString());
        actual.setText(""+(act+50));
    }
    public  void  calcularT(View v){
        int a = Integer.parseInt(total.getText().toString());
        Toast.makeText(getApplicationContext(),"Se tienen "+(a*80)+" Manzanas en la produccion total.",Toast.LENGTH_LONG).show();
    }
    public  void  calcularA(View v){
        int a = Integer.parseInt(actual.getText().toString());

        Toast.makeText(getApplicationContext(),"Se tienen "+(a*80)+" Manzanas en la produccion actual.",Toast.LENGTH_LONG).show();
    }
    public  void  calcularPromedio(View v){
        int act = Integer.parseInt(actual.getText().toString());
        int tot = Integer.parseInt(total.getText().toString());
        double promedio= act*100;
        promedio=promedio/tot;
        prom.setText(""+promedio);
        if (promedio>=70){
            back.setBackgroundColor(Color.parseColor("#FF0000"));
        }else {
            back.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
    }
}
