package com.example.jesusontiveros.centgradostofahrenheit;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl;
    EditText grd,F;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void convertir(View v){
        rl=(RelativeLayout)findViewById(R.id.back);

        grd =(EditText)findViewById(R.id.txtGrados);
        F =(EditText)findViewById(R.id.txtFahrenheit);
        if(grd.length()>0){
            double centigrados = Double.parseDouble(grd.getText().toString());
            double gradosF = (centigrados*1.8)+32;
            F.setText("Grados Fahrenheit:"+gradosF);
            if (gradosF>100){

                rl.setBackgroundColor(Color.parseColor("#800000"));
            }
            else {
                rl.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        } else {
            Toast toast = Toast.makeText(this,"Agregue todos los datos.",Toast.LENGTH_LONG);
        }
    }

}
