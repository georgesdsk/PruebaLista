package com.example.pruebalista;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pruebalista.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] ciudades;
    ListView lw;
    TextView tv;

            //con array adapter(this) android.R.layout..(2º) el array de datos (3º)
            // el set contenView tiene que ir antes que el findView..
            //donde ponerle a la lista el adaptador
            // para

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ciudades= new String[]{"Micasa", "Carro", "casoplon", "Micasa", "Carro", "casoplon", "Micasa", "Carro", "casoplon", "Micasa", "Carro", "casoplon", "Micasa", "Carro", "casoplon", "Micasa", "Carro", "casoplon"};
        ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ciudades);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.row, R.id.textView2, ciudades);

        lw = findViewById(R.id._dynamic);
        tv= findViewById(R.id.textView);
        lw.setAdapter(adapter);
        
        lw.setOnItemClickListener(this::clickLista);
        
        
    }

    private void clickLista(AdapterView<?> adapterView, View view, int i, long l) {

        tv.setText(ciudades[i]);

    }


}