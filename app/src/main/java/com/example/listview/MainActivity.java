package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private String[] itens = {
            "Rio de janeiro", "Ceará", "São Benedito",
            "Alto feliz", "Cariré"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listaLocais);

        // Cria adaptador para a lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

        //Adicionar adaptador para a lista
        lista.setAdapter(adaptador);

        //Adicionar clique na lista
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String localSelecionado = lista.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),
                        localSelecionado,
                        Toast.LENGTH_LONG
                        ).show();
            }
        });
    }
}
