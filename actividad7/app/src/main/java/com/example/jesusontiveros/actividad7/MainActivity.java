package com.example.jesusontiveros.actividad7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n=(EditText)findViewById(R.id.txtNumero);
    }

    public void check (View v){
        if (n.getText().length()>0){
        int num = Integer.parseInt(n.getText().toString());
        int res=num%2;
        if(num==0){
            Toast.makeText(getApplicationContext(), "No debe ser 0", Toast.LENGTH_LONG).show();
            n.setText("");
        }else {
            if (res == 0) {
                Toast.makeText(getApplicationContext(), "Primo", Toast.LENGTH_LONG).show();
                n.setText("");
            } else {
                Toast.makeText(getApplicationContext(), "No Primo", Toast.LENGTH_LONG).show();
                n.setText("");
            }
        }
        }
        else {
            Toast.makeText(getApplicationContext(), "Ingrese un numero", Toast.LENGTH_LONG).show();
        }
    }
}
