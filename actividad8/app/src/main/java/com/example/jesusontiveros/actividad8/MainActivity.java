package com.example.jesusontiveros.actividad8;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText n, a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        n = (EditText)findViewById(R.id.txtNombre);
        a = (EditText)findViewById(R.id.txtApellido);
        ShakeListener mShaker = new ShakeListener(this);
        mShaker.setOnShakeListener(new ShakeListener.OnShakeListener () {
            public void onShake() {
                n.setText("");
                a.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        String nn = n.getText().toString();
        String aa = a.getText().toString();
        if (id == R.id.btn1) {

            if (nn.length()>0 && aa.length()>0){
                Toast toast = Toast.makeText(getApplicationContext(),nn +" "+aa,Toast.LENGTH_LONG);
                toast.show();
            }
        }
        if (id == R.id.btn2) {

            if (nn.length()>0 && aa.length()>0){
                Toast toast = Toast.makeText(getApplicationContext(),aa +" "+nn,Toast.LENGTH_LONG);
                toast.show();
            }
        }

        if (id == R.id.btn3) {

            n.setText("");
            a.setText("");
        }

        return super.onOptionsItemSelected(item);
    }
}
