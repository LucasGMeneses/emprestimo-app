package com.example.emprestimoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.emprestimoapp.models.AppDatabase;
import com.example.emprestimoapp.models.entity.Equipamentos;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppDatabase db;
    private List<Equipamentos> equipamentos;
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.lista);
        db = AppDatabase.getDatabase(getApplicationContext());

    }

    @Override
    protected void onResume() {
        super.onResume();
        getApplicationContext().deleteDatabase("EmpresaX"); //remove o banco de dados
        //adiciona um novo equipamento
        Equipamentos equip = new Equipamentos("luvas","thor");
        db.equipamentosTable().insertAll(equip);

        equipamentos = db.equipamentosTable().getAll();
        ArrayAdapter<Equipamentos> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, equipamentos);

        list.setAdapter(adapter);

    }
}