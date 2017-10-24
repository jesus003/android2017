package com.example.jesusontiveros.segundoexamen;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class grid extends AppCompatActivity

 implements AdapterView.OnItemClickListener {
        private GridView gridView;
        private AdaptadorDeCoches adaptador;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_grid);
            gridView = (GridView) findViewById(R.id.grid);
            adaptador = new AdaptadorDeCoches(this);
            gridView.setAdapter(adaptador);
            gridView.setOnItemClickListener(this);
        }





        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Coche item = (Coche) parent.getItemAtPosition(position);


        }
    public  void regresar (View v){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
        this.finish();
    }

}

