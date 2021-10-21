package com.example.pruebalista;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   // private String[] ciudades;
    private List<Vista> vistas;
    ListView lw;
    TextView tv;


            // el set contenView tiene que ir antes que el findView..
            //donde ponerle a la lista el adaptador
            // para personalizar el muestreo de informacion tenemos que crear un nuevo adapter, o sobrescribir el getView del
            // ArrayAdapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ciudades= new String[]{"Micasa", "Carro", "casoplon", "Micasa", "Carro", "casoplon", "Micasa", "Carro", "casoplon", "Micasa", "Carro", "casoplon", "Micasa", "Carro", "casoplon", "Micasa", "Carro", "casoplon"};
        //ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ciudades);
        //ArrayAdapter adapter = new ArrayAdapter(this, R.layout.row, R.id.textView2, ciudades);

        vistas = new ArrayList<Vista>(); // agragar un boton que añada uno

        vistas.add(new Vista(R.drawable.casoplon, 2000, "Casoplon"));
        vistas.add(new Vista(R.drawable.coche, 200, "Carro"));
        vistas.add(new Vista(R.drawable.coche, 200, "Carro"));
        vistas.add(new Vista(R.drawable.descarga, 5, "Casita"));
        vistas.add(new Vista(R.drawable.descarga, 5, "Casita"));
        vistas.add(new Vista(R.drawable.coche, 200, "Carro"));
        vistas.add(new Vista(R.drawable.casoplon, 2000, "Casoplon"));
        vistas.add(new Vista(R.drawable.casoplon, 2000, "Casoplon"));
        vistas.add(new Vista(R.drawable.coche, 200, "Carro"));
        vistas.add(new Vista(R.drawable.coche, 200, "Carro"));
        vistas.add(new Vista(R.drawable.descarga, 5, "Casita"));
        vistas.add(new Vista(R.drawable.descarga, 5, "Casita"));
        vistas.add(new Vista(R.drawable.coche, 200, "Carro"));
        vistas.add(new Vista(R.drawable.casoplon, 2000, "Casoplon"));

        lw = findViewById(R.id._dynamic);
        tv= findViewById(R.id.textView);
        //lw.setAdapter(adapter);
       // lw.setAdapter(new AdaptadorPersonalizado(this, R.layout.row, R.id.textView2, ciudades));
        lw.setAdapter(new AdaptadorPersonalizado(this, R.layout.row, R.id.textView2, vistas));
        // no me reconoce el R.id.TextView2


        lw.setOnItemClickListener(this::clickVista);
    }



    private class AdaptadorPersonalizado extends ArrayAdapter {
        public AdaptadorPersonalizado(Context c, int row, int textView2, List<Vista> vistas) {

            /**
             * GetViewTypeCOunt() el numero total de layouts hay
             * getItemViewType(posicion) para esta vista que layout le corresponde
             */
            super(c,row,textView2,vistas);
        }


        @Override
        public View getView(int position,  View convertView, ViewGroup parent) {/**
         El convertView es la vista anterior para reciclarla

         */
            View vista = super.getView(position, convertView, parent);
            ImageView icon = vista.findViewById(R.id.imageView);
            TextView tv = vista.findViewById(R.id.textView3);

            icon.setImageResource(vistas.get(position).getResourse());
            tv.setText(Integer.toString(vistas.get(position).precio));

            return vista;
        }
    }

   /*
    private class AdaptadorPersonalizado extends ArrayAdapter {

        public AdaptadorPersonalizado(Context c, int row, int textView2, String[] ciudades) {
            super(c,row,textView2,ciudades);
        }

        @Override
        public View getView(int position,  View convertView, ViewGroup parent) {
            View row = super.getView(position, convertView, parent);
            ImageView icon = row.findViewById(R.id.imageView);

            switch (ciudades[position]){

                case "Micasa":{ icon.setImageResource(R.drawable.descarga);}break;
                case "Carro":{icon.setImageResource(R.drawable.coche);}break;
                case "casoplon":{icon.setImageResource(R.drawable.casoplon);}break;

            }
            return row;
        }
    }

    private void clickLista(AdapterView<?> adapterView, View view, int i, long l) {

        tv.setText(ciudades[i]);
    }
    */

    private void clickVista(AdapterView<?> adapterView, View view, int i, long l) {

        tv.setText(vistas.get(i).getNombre());
    }

    /**
     * Vista que va a contener la informacion de cada objeto guardado con su referencia a la imagen
     *
     */
    private class Vista {

        private int resourse, precio;
        private String nombre;

        public Vista(int resourse, int precio, String nombre) {
            this.resourse = resourse;
            this.precio = precio;
            this.nombre = nombre;
        }

        public int getResourse() {
            return resourse;
        }

        public int getPrecio() {
            return precio;
        }

        public String getNombre() {
            return nombre;
        }


    }

}

