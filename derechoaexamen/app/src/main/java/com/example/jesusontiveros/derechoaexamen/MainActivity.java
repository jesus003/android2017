package com.example.jesusontiveros.derechoaexamen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
    private ListView lista;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.lista);

        String[] companeros={"1.Escanear código QR","2.Pasar datos entre Actividades","3.Dialogos","4.Grid","5.Salir"};

        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(lista.getContext(),android.R.layout.simple_list_item_1,companeros);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {

                String selectedFromList =(String) (lista.getItemAtPosition(myItemInt));

                switch (selectedFromList){
                    case "1.Escanear código QR":
                        Intent intent = new Intent(getBaseContext(), qr.class);
                        startActivity(intent);
                        finish();

                        break;
                    case "2.Pasar datos entre Actividades":
                        Intent i = new Intent(getBaseContext(), pasardatos.class);
                        startActivity(i);
                        finish();
                        break;
                    case "3.Dialogos":
                        Intent d = new Intent(getBaseContext(), dialogos.class);
                        startActivity(d);
                        finish();
                        break;
                    case "4.Grid":
                        Intent p = new Intent(getBaseContext(), principal.class);
                        startActivity(p);
                        finish();
                        break;
                    case "5.Salir":

                        finish();
                        break;

                }
            }
        });
    }


}