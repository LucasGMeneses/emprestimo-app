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
import com.example.emprestimoapp.models.entity.Emprestimo;
import com.example.emprestimoapp.models.entity.Equipamentos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class EmprestimosPage extends Fragment {
    private List<Emprestimo> emprestimos;
    private ListView lista;
    private FloatingActionButton fab;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_emprestimo_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        lista = (ListView) view.findViewById(R.id.lista);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), EditarEmprestimoPage.class);
                intent.putExtra("action", emprestimos.get(i).getNumEmpres());
                startActivity(intent);
            }
        });

        // adicionar novo item
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditarEmprestimoPage.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        //listando...
        AppDatabase db = AppDatabase.getDatabase(getActivity().getApplicationContext());
        emprestimos = db.emprestimoTable().getAll();
        ArrayAdapter<Emprestimo> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, emprestimos);
        lista.setAdapter(adapter);
    }
}
