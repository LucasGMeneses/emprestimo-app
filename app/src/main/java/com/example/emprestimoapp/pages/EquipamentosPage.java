package com.example.emprestimoapp.pages;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.emprestimoapp.R;
import com.example.emprestimoapp.models.AppDatabase;
import com.example.emprestimoapp.models.entity.Equipamentos;

import java.util.List;

public class EquipamentosPage extends Fragment {
    private List<Equipamentos> equipamentos;
    private ListView lista;

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
        lista = (ListView) view.findViewById(R.id.lista);
        getActivity().getApplicationContext().deleteDatabase("EmpresaX"); //remove o banco de dados
        ///adiciona um novo equipamento
        Equipamentos equip = new Equipamentos("luvas","thor");
        AppDatabase db = AppDatabase.getDatabase(getActivity().getApplicationContext());
        db.equipamentosTable().insertAll(equip);

        equipamentos = db.equipamentosTable().getAll();
        ArrayAdapter<Equipamentos> adapter = new ArrayAdapter<Equipamentos>(getContext(), android.R.layout.simple_list_item_1, equipamentos);
        lista.setAdapter(adapter);
    }
}