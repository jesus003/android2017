package com.softsolutions.jesusontiveros.gascuu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jesus Ontiveros on 11/12/2017.
 */

public class CustomAdapter extends ArrayAdapter<DataModel> implements View.OnClickListener{

    private ArrayList<DataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtNombre;
        TextView txtFecha;
        TextView txtPrecio,txtProducto;
        ImageView info;
    }



    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext=context;

    }


    @Override
    public void onClick(View v) {


        int position=(Integer) v.getTag();
        Object object= getItem(position);
        DataModel dataModel=(DataModel)object;




        switch (v.getId())
        {

            case R.id.item_info:


                Intent i = new Intent(v.getContext(),mapa.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("lat",dataModel.getLat());
                i.putExtra("lon",dataModel.getLon());
                i.putExtra("Nombre",dataModel.getNombre());
                v.getContext().startActivity(i);

                break;


        }


    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {


            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtNombre = (TextView) convertView.findViewById(R.id.txtNombre);
            viewHolder.txtFecha = (TextView) convertView.findViewById(R.id.txtfecha);
            viewHolder.txtPrecio = (TextView) convertView.findViewById(R.id.p_magna);
            viewHolder.txtProducto = (TextView) convertView.findViewById(R.id.p_producto);
            viewHolder.info = (ImageButton) convertView.findViewById(R.id.item_info);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        try {
            viewHolder.txtNombre.setText(dataModel.getNombre());
            viewHolder.txtFecha.setText(String.format("%.2f", (dataModel.getDistancia()/1000))+" KM");
            viewHolder.txtPrecio.setText(" $" + dataModel.getPrecio());

            switch(dataModel.getProducto()){
                case "Diésel":
                    viewHolder.txtProducto.setTextColor(Color.BLACK);
                    viewHolder.txtProducto.setText("" + dataModel.getProducto());
                    break;
                case "Premium (con contenido mínimo de 92 octanos)":
                    viewHolder.txtProducto.setTextColor(Color.RED);
                    viewHolder.txtProducto.setText("" + dataModel.getProducto().substring(0, 7));
                    break;
                case "Regular (con contenido menor a 92 octanos)":
                    viewHolder.txtProducto.setTextColor(Color.GREEN);
                    viewHolder.txtProducto.setText("" + dataModel.getProducto().substring(0, 7));
                    break;
            }


            viewHolder.info.setOnClickListener(this);
            viewHolder.info.setTag(position);
            // Return the completed view to render on screen
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return convertView;
    }




}
