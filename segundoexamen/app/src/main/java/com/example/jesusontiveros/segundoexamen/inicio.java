package com.example.jesusontiveros.segundoexamen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

        String[] companeros={"1.Leer placa","2.Vehiculos Afiliados","3.Acerca de","4.Cerrar sesión "};

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
                    /*case "3.Dialogos":
                        Intent d = new Intent(getBaseContext(), dialogos.class);
                        startActivity(d);
                        finish();
                        break;
                    case "4.Grid":
                        Intent p = new Intent(getBaseContext(), principal.class);
                        startActivity(p);
                        finish();
                        break;*/
                    case "5.Salir":

                        dialogCerrar();

                        break;

                }
            }
        });
    }

    public void dialogCerrar() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cerrar applicacion")
                .setMessage("Seguro que desea cerrar la aplicacion?.")
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }
    public void info(String data) {
        final AlertDialog builder = new AlertDialog.Builder(this).create();
        LayoutInflater inflater = this.getLayoutInflater();
        View v = inflater.inflate(R.layout.infovehiculo, null);
        builder.setView(v);

        //String[] info = data.split(",");
        TextView marca = (TextView) v.findViewById(R.id.txtMarca);
        TextView modelo = (TextView) v.findViewById(R.id.txtModelo);
        TextView ano = (TextView) v.findViewById(R.id.txtano);
        TextView adeudo = (TextView) v.findViewById(R.id.txtAdeudo);

        builder.show();
    }
}
