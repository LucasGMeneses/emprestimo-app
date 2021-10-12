package com.example.emprestimoapp.pages;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.emprestimoapp.R;
import com.example.emprestimoapp.models.AppDatabase;
import com.example.emprestimoapp.models.entity.Equipamentos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class EquipamentosPage extends Fragment {
    private List<Equipamentos> equipamentos;
    private ListView lista;
    private FloatingActionButton fab;
    public EquipamentosPage() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_equipamentos_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        lista = (ListView) view.findViewById(R.id.lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), EditarEquipamentoPage.class);
                intent.putExtra("action", equipamentos.get(i).getEquipamentosId());
                startActivity(intent);
            }
        });

        // adicionar novo item
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditarEquipamentoPage.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        //listando...
        AppDatabase db = AppDatabase.getDatabase(getActivity().getApplicationContext());
        equipamentos = db.equipamentosTable().getAll();
        ArrayAdapter<Equipamentos> adapter = new ArrayAdapter<Equipamentos>(getContext(), android.R.layout.simple_list_item_1, equipamentos);
        lista.setAdapter(adapter);
    }
}