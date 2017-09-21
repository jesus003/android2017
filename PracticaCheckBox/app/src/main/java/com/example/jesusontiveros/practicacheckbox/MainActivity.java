package com.example.jesusontiveros.practicacheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox recuerdame;
    EditText pass,numeros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recuerdame = (CheckBox)findViewById(R.id.chbxRecuerdame);
        pass = (EditText) findViewById(R.id.txtPassword);
        numeros =(EditText)findViewById(R.id.txtNumeros);
        if (recuerdame.isChecked()==true){
            Toast.makeText(getApplicationContext(),"Esta marcado",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),"No esta marcado",Toast.LENGTH_SHORT).show();
        }
        numeros.addTextChangedListener(new TextWatcher() {

            // the user's changes are saved here
            public void onTextChanged(CharSequence c, int start, int before, int count) {
               if (numeros.getText().length()>0){
                   int num =Integer.parseInt(numeros.getText().toString());
                   if (num>1000){
                      recuerdame.setChecked(true);
                   }else {
                       recuerdame.setChecked(false);
                   }

               }
            }

            public void beforeTextChanged(CharSequence c, int start, int count, int after) {
                // this space intentionally left blank
            }

            public void afterTextChanged(Editable c) {
                // this one too
            }
        });
    }
    public void checkedChange(View v){
        if (recuerdame.isChecked()==true){
            pass.setInputType(InputType.TYPE_CLASS_TEXT);
            Toast.makeText(getApplicationContext(),"Esta marcado",Toast.LENGTH_SHORT).show();
        }else {
            pass.setInputType(InputType.TYPE_CLASS_TEXT |
                    InputType.TYPE_TEXT_VARIATION_PASSWORD);
            Toast.makeText(getApplicationContext(),"No esta marcado",Toast.LENGTH_SHORT).show();
        }
    }
}
