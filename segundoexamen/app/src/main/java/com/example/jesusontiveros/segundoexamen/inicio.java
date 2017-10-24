package com.example.jesusontiveros.segundoexamen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class inicio extends AppCompatActivity {
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);lista = (ListView) findViewById(R.id.lista);

        String[] companeros={"1.Leer placa","2.Vehiculos Afiliados","3.Acerca de","4.Cerrar sesión"};

        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(lista.getContext(),android.R.layout.simple_list_item_1,companeros);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {

                String selectedFromList =(String) (lista.getItemAtPosition(myItemInt));

                switch (selectedFromList){
                    case "1.Leer placa":
                        Intent intent = new Intent(getBaseContext(), qr.class);
                        startActivity(intent);

                        break;
                    case "2.Vehiculos Afiliados":
                        Intent i = new Intent(getBaseContext(), grid.class);
                        startActivity(i);
                        break;
                    case "3.Acerca de":
                        dialog("Acerca de:","Jesus Ontiveros Ruiz - 3549");
                        break;
                    case "4.Cerrar sesión":
                        Intent p = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(p);
                        finish();
                        break;


                }
            }
        });
    }

    public void dialog(String titulo,String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titulo)
                .setMessage(mensaje)
                .setPositiveButton("Pagina Web", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/jesus003/android2017/"));
                        startActivity(browserIntent);
                    }
                })
                .setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        builder.show();
    }

}
