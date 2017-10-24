package com.example.jesusontiveros.segundoexamen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText usuario,contra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = (EditText)findViewById(R.id.txtUsuario);
        contra = (EditText)findViewById(R.id.txtContra);

    }
    public  void iniciar(View v){
        if(usuario.length()>0 && contra.length()>0){
            if (usuario.getText().toString().equals("segundoparcial") && contra.getText().toString().equals("1")){
                Intent intent = new Intent(getBaseContext(), inicio.class);
                startActivity(intent);
                finish();
            } else {
                dialog("Advertencia","Usuario y/o contraseña incorrectos.");
            }
        }
        else{
            dialog("Advertencia","Debe llenar todos los datos.");
        }
    }

    public void dialog(String titulo,String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titulo)
                .setMessage(mensaje)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        builder.show();
    }
}
