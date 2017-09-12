package com.example.jesusontiveros.actividad9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView m1,m2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m1 = (TextView)findViewById(R.id.txtM1);
        m2 = (TextView)findViewById(R.id.txtM2);
        ShakeListener mShaker = new ShakeListener(this);
        mShaker.setOnShakeListener(new ShakeListener.OnShakeListener () {
            public void onShake()
            {
                m1.setText("0");
                m2.setText("0");
            }
        });
    }

    public  void sum1(View v){
        int n = Integer.parseInt(m1.getText().toString());
        if (n!=15) {
            int sum = n + 1;
            m1.setText(""+sum);
        }else {
            Toast.makeText(getApplicationContext(),"El jugador 1 ha ganado",Toast.LENGTH_LONG).show();
        }
    }

    public  void sum2(View v) {
        int n = Integer.parseInt(m2.getText().toString());
        if (n < 15) {
            int sum = n + 1;
            m2.setText(""+sum);
        } else {
            Toast.makeText(getApplicationContext(), "El jugador 2 ha ganado", Toast.LENGTH_LONG).show();
        }
    }
    public  void res1(View v) {
        int n = Integer.parseInt(m1.getText().toString());
        if (n >0) {
            int sum = n - 1;
            m1.setText(""+sum);
        }
    }

    public  void res2(View v) {
        int n = Integer.parseInt(m2.getText().toString());
        if (n >0) {
            int sum = n - 1;
            m2.setText("" + sum);
        }
    }
}
