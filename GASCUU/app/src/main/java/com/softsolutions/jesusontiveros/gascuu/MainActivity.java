package com.softsolutions.jesusontiveros.gascuu;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ArrayList<DataModel> dataModels;
    ArrayList<DataModel> dataModelsOrdenado;
    ListView listView;
    private static CustomAdapter adapter;
    String JsonURL = "http://api-reportediario.cre.gob.mx/api/EstacionServicio/Petroliferos?entidadId=08&municipioId=019";
    String data = "";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestQueue = Volley.newRequestQueue(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listView = (ListView) findViewById(R.id.list);



        dataModels = new ArrayList<>();
        final Location actual = getUbicacion();
        JsonArrayRequest obreq = new JsonArrayRequest(Request.Method.GET, JsonURL,
                // The third parameter Listener overrides the method onResponse() and passes
                //JSONObject as a parameter
                new Response.Listener<JSONArray>() {

                    // Takes the response from the JSON request
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i <response.length(); i++) {
                                JSONObject gasolinera = response.getJSONObject(i);
                                String nombre = gasolinera.getString("Nombre");
                                String fecha = gasolinera.getString("FechaAplicacion");
                                String direccion = gasolinera.getString("Direccion");
                                String producto = gasolinera.getString("SubProducto");
                                double precio = gasolinera.getDouble("PrecioVigente");
                                direccion = direccion+",Chihuahua,Chihuahua";
                                LatLng latLng = getCoordenadas(direccion);
                                float distancia=10000;
                                if(latLng!=null){
                                    distancia = getDistancia(actual,latLng);
                                }
                                Log.e("vuelta", ""+i);
                                try{
                                    if(latLng!=null) {
                                        dataModels.add(new DataModel(nombre, fecha, direccion, producto, precio, latLng.latitude, latLng.longitude,distancia));
                                    }
                                }
                                catch (Exception e){
                                    e.printStackTrace();
                                }

                            }
                            Collections.sort(dataModels, DataModel.sortUbicacion);

                            dataModelsOrdenado = dataModels;
                            for(int i=(dataModelsOrdenado.size()-1); i>20;i--){
                                dataModelsOrdenado.remove(i);
                            }


                            adapter = new CustomAdapter(dataModelsOrdenado, getApplicationContext());

                            listView.setAdapter(adapter);
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                    DataModel dataModel = dataModelsOrdenado.get(position);

                                    Snackbar.make(view, dataModel.getNombre() + "\n" + dataModel.getDireccion(), Snackbar.LENGTH_LONG)
                                            .setAction("No action", null).show();

                                }
                            });
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    // Handles errors that occur due to Volley
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error" + error.getMessage());
                    }
                }
        );
        // Adds the JSON object request "obreq" to the request queue
        requestQueue.add(obreq);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();



    }

    public float getDistancia(Location locationA,LatLng locationB){
        float distancia=100000;
        try {
            Location b = new Location("Punto B");
            b.setLatitude(locationB.latitude);
            b.setLongitude(locationB.longitude);
           distancia = locationA.distanceTo(b);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  distancia;
    }
    public Location getUbicacion() {
        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return null;
        }
        Location location = locationManager.getLastKnownLocation(locationManager
                .getBestProvider(criteria, false));
        return  location;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public  LatLng  getCoordenadas(String direccion){
        List<Address> addressList = null;
        LatLng latLng=null;
        if(direccion!=null || !direccion.equals("")){
            Geocoder geocoder = new Geocoder(this);
            try{
                addressList = geocoder.getFromLocationName(direccion,1);
            }
            catch(IOException e){
                e.printStackTrace();
            }
            try{
                Address  address = addressList.get(0);
                float zoomLevel = 12.0f;
                latLng = new LatLng(address.getLatitude(),address.getLongitude());
            }
            catch (Exception e){
                e.printStackTrace();
                return null;
            }


        }
        return latLng;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.btnubicacion) {
        } else if (id == R.id.Btnprecio) {
            Intent intent = new Intent(this, Precio.class);
            intent.putExtra("list", dataModels);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
