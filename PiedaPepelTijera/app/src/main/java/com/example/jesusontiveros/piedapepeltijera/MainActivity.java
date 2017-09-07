package com.example.jesusontiveros.piedapepeltijera;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int i =0;
    ImageView img;
    private SensorManager mSensorMgr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        img= (ImageView) findViewById(R.id.imgF);
        final Resources resources = getResources();
        ShakeListener mShaker = new ShakeListener(this);
        mShaker.setOnShakeListener(new ShakeListener.OnShakeListener () {
            public void onShake()
            {
                Random rand = new Random();
                int n = (int) (Math.random() * 3) + 1;
                switch (n){
                    case 1:
                        Toast toastPiedra = Toast.makeText(getApplicationContext(),"Piedra",Toast.LENGTH_SHORT);
                        toastPiedra.show();
                        img.setImageDrawable(resources.getDrawable(R.drawable.piedra));
                        break;
                    case 2:
                        Toast toastPapel = Toast.makeText(getApplicationContext(),"Papel",Toast.LENGTH_SHORT);
                        toastPapel.show();
                        img.setImageDrawable(resources.getDrawable(R.drawable.papel));
                        break;
                    case 3:
                        Toast toastTijera = Toast.makeText(getApplicationContext(),"TIjera",Toast.LENGTH_SHORT);
                        toastTijera.show();
                        img.setImageDrawable(resources.getDrawable(R.drawable.tijera));
                        break;
                }
            }
        });
    }



}
