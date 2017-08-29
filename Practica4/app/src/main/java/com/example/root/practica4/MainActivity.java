package com.example.root.practica4;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int num = 3;
        int precio = 40;
        int total = num*precio;
        if(total>80){
            Toast toast = Toast.makeText(getApplicationContext(),"Soda gratis :D",Toast.LENGTH_LONG);
            toast.show();
        }else {
            Toast toast = Toast.makeText(getApplicationContext(),"No tienes una soda gratis :(",Toast.LENGTH_LONG);
            toast.show();
        }

    }
}
