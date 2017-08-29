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
        String nombre = "Jesus";
        String apellido = "Ontiveros";
        Toast toast = Toast.makeText(getApplicationContext(),nombre+" "+apellido,Toast.LENGTH_LONG);
        toast.show();
    }
}
