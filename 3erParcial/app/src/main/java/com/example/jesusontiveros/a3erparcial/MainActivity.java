package com.example.jesusontiveros.a3erparcial;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String JsonURL = "https://api.myjson.com/bins/isbnv";
    String data = "";
    RequestQueue requestQueue;
    TextView nombre,ap,am,dir,lon,ts;
    ImageView img;
    String coordenadas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Creates the Volley request queue
        requestQueue = Volley.newRequestQueue(this);

        nombre = (TextView)findViewById(R.id.lblNombre);
        ap = (TextView)findViewById(R.id.lblAP);
        am = (TextView)findViewById(R.id.lblAM);
        dir = (TextView)findViewById(R.id.lblDireccion);
        lon = (TextView)findViewById(R.id.lblLongitud);
        ts = (TextView)findViewById(R.id.lblTipoSangre);
        img = (ImageView)findViewById(R.id.imgPerfil);
        // Creating the JsonObjectRequest class called obreq, passing required parameters:
        //GET is used to fetch data from the server, JsonURL is the URL to be fetched from.
        JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.GET, JsonURL,
                // The third parameter Listener overrides the method onResponse() and passes
                //JSONObject as a parameter
                new Response.Listener<JSONObject>() {

                    // Takes the response from the JSON request
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject obj = response.getJSONObject("datos");
                            // Retrieves the string labeled "colorName" and "description" from
                            //the response JSON Object
                            //and converts them into javascript objects
                            nombre.setText("Nombre: "+obj.getString("nombre"));
                            ap.setText("A. Paterno: "+obj.getString("ap"));
                            am.setText("A. Materno: "+obj.getString("am"));
                            dir.setText("Direccion: "+obj.getString("direccion"));
                            lon.setText("Coordernas: "+obj.getString("latd"));
                            coordenadas=obj.getString("latd");
                            ts.setText("Tipo Sangre: "+obj.getString("tip"));
                            String ss =obj.getString("foto");
                            byte[] decodedString = Base64.decode(obj.getString("foto"), Base64.DEFAULT);
                            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                            img.setImageBitmap(decodedByte);

                        }
                        // Try and catch are included to handle any errors due to JSON
                        catch (JSONException e) {
                            // If an error occurs, this prints the error to the log
                            e.printStackTrace();
                        }
                    }
                },
                // The final parameter overrides the method onErrorResponse() and passes VolleyError
                //as a parameter
                new Response.ErrorListener() {
                    @Override
                    // Handles errors that occur due to Volley
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                    }
                }
        );
        // Adds the JSON object request "obreq" to the request queue
        requestQueue.add(obreq);
    }
    public  void ubicame(View v){
        Intent i = new Intent(MainActivity.this, MapsActivity.class);
        i.putExtra("coordenadas", coordenadas);
        MainActivity.this.startActivity(i);
    }
}
