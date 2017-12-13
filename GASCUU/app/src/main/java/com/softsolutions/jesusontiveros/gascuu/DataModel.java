package com.softsolutions.jesusontiveros.gascuu;

import java.io.Serializable;
import java.nio.channels.FileLock;
import java.util.Comparator;

/**
 * Created by Jesus Ontiveros on 11/12/2017.
 */

public  class DataModel implements Serializable {

    String nombre;
    String fecha;
    String direccion;
    String producto;
    double precio,lat,lon;
    float distancia = 0;


    public DataModel(String nombre, String fecha, String direccion, String producto,double precio,double lat, double lon,float distancia) {
        this.nombre=nombre;
        this.fecha=fecha;
        this.direccion=direccion;
        this.producto=producto;
        this.precio=precio;
        this.lat=lat;
        this.lon=lon;
        this.distancia = distancia;
    }


    public String getNombre() {
        return nombre;
    }


    public String getFecha() {
        return fecha;
    }


    public String getDireccion() {
        return direccion;
    }


    public String getProducto() {
        return producto;
    }
    public double getPrecio() {
        return precio;
    }
    public double getLat() {
        return lat;
    }
    public double getLon() {
        return lon;
    }
    public float getDistancia(){
        return distancia;
    }

    public static Comparator<DataModel> sortUbicacion = new Comparator<DataModel>() {

        public int compare(DataModel s1, DataModel s2) {

            int rollno1 = (int) s1.getDistancia();
            int rollno2 =(int) s2.getDistancia();
            return rollno1-rollno2;
        }};



}
