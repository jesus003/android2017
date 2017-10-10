package com.example.jesusontiveros.listaactividad;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jesusontiveros.inicio;

public class MainActivity extends Activity {
    private ListView lista;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.lista);

        String[] companeros={"Flaca","Bryan","Chuy","Victor","Ian","Yepiz","Jacob"};

        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(lista.getContext(),android.R.layout.simple_list_item_1,companeros);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {

                String selectedFromList =(String) (lista.getItemAtPosition(myItemInt));
                Intent intent = new Intent(getBaseContext(), inicio.class);
                switch (selectedFromList){
                    case "Flaca":

                        intent.putExtra("NOMBRE", "Flaca");
                        startActivity(intent);

                        break;
                    case "Bryan":
                        intent.putExtra("NOMBRE", "Bryan");
                        startActivity(intent);
                        break;
                    case "Chuy":
                        intent.putExtra("NOMBRE", "Chuy");
                        startActivity(intent);
                        break;
                    case "Ian":
                        intent.putExtra("NOMBRE", "Ian");
                        startActivity(intent);
                        break;
                    case "Yepiz":
                        intent.putExtra("NOMBRE", "Yepiz");
                        startActivity(intent);
                        break;
                    case "Jacob":
                        intent.putExtra("NOMBRE", "Jacobo");
                        startActivity(intent);
                        break;
                    case "Victor":
                        intent.putExtra("NOMBRE", "Victor");
                        startActivity(intent);
                        break;
                }
            }
        });
    }


}