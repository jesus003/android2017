package com.example.jesusontiveros.imgjesusontiveros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText peso,estatura;
    TextView status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = (TextView)findViewById(R.id.lblStatus);
    }
    public void calcularMasaCorporal(View v){
        peso =(EditText)findViewById(R.id.txtPeso);
        estatura=(EditText)findViewById(R.id.txtEstatura);
        if (peso.length()>0  && estatura.length()>0 ) {
            double p = Double.parseDouble(peso.getText().toString());
            double e = Double.parseDouble(estatura.getText().toString());
            double imc = p / (e * e);
            if (imc > 19 && imc < 24.9) {
                status.setText("El paciente se encuentra en el peso adecuado");
            } else {
                status.setText("El paciente NO se encuentra en el peso adecuado");
            }
        }else {
            Toast toast =  Toast.makeText(this,"Debe ingresar todos los valores",Toast.LENGTH_LONG);
            toast.show();

        }
    }
}
