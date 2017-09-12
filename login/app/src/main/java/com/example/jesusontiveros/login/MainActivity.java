package com.example.jesusontiveros.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText u,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        u = (EditText)findViewById(R.id.txtUsuario);
        c = (EditText)findViewById(R.id.txtContra);
    }

    public  void login (View v){
        if (u.length()>0&&c.length()>0){

            String usuario = u.getText().toString();
            String contra = c.getText().toString();
            if (isValidEmail(usuario)){
                if (usuario.equals("jesusontiveros003@gmail.com")&&contra.equals("1234")){
                    Intent intent = new Intent(getApplicationContext(),inicioo.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),"Usuario o contrase;a erroneos.",Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(),"El usuario no es un email valido.",Toast.LENGTH_LONG).show();
            }

        }
        else {
            Toast.makeText(getApplicationContext(),"Debe ingresar todos los campos.",Toast.LENGTH_LONG).show();
        }
    }
    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
