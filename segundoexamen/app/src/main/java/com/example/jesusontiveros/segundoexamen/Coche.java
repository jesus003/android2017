package com.example.jesusontiveros.segundoexamen;

/**
 * Created by root on 23/10/17.
 */

public class Coche {
    private String nombre;
    private int idDrawable;

    public Coche(String nombre, int idDrawable) {
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public static Coche[] ITEMS = {
            new Coche("Jaguar", R.drawable.jaguar_f_type_2015),
            new Coche("Mercedes", R.drawable.mercedes_benz_amg_gt),
            new Coche("Mazda", R.drawable.mazda_mx5_2015),
            new Coche("Porsche", R.drawable.porsche_911_gts),
            new Coche("BMW", R.drawable.bmw_serie6_cabrio_2015),
            new Coche("Ford", R.drawable.ford_mondeo),
            new Coche("Volvo", R.drawable.volvo_v60_crosscountry),
            new Coche("Jaguar", R.drawable.jaguar_xe),
            new Coche("VW", R.drawable.volkswagen_golf_r_variant_2015),
            new Coche("Seat", R.drawable.seat_leon_st_cupra),
    };

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Coche
     */
    public static Coche getItem(int id) {
        for (Coche item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
