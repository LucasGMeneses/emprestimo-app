package com.example.emprestimoapp.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.emprestimoapp.R;
import com.example.emprestimoapp.models.AppDatabase;
import com.example.emprestimoapp.models.entity.Emprestimo;
import com.example.emprestimoapp.models.entity.Equipamentos;

import java.util.ArrayList;
import java.util.List;

public class EditarEmprestimoPage extends AppCompatActivity {
    private Button btnAcao;
    private Button btnCancelar;
    private Button btnDeletar;

    private EditText nomeText;
    private EditText dataText;
    private EditText telText;
    private CheckBox check;
    private Spinner spin;
    private AppDatabase db;
    private int idEquip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_emprestimo_page);

        // binding xml
        btnAcao = findViewById(R.id.btnAcao);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnDeletar = findViewById(R.id.btnDeletar);

        nomeText = findViewById(R.id.nomePessoa);
        dataText = findViewById(R.id.data);
        telText = findViewById(R.id.tel);
        check = findViewById(R.id.check);
        spin = findViewById(R.id.spin);


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        int id = intent.getIntExtra("action",0);

        db = AppDatabase.getDatabase(getApplicationContext().getApplicationContext());
        ArrayList<Equipamentos> equipamentos = (ArrayList<Equipamentos>) db.equipamentosTable().getAll();
        ArrayAdapter<Equipamentos> adapter = new ArrayAdapter<Equipamentos>(getApplicationContext(), android.R.layout.simple_spinner_item, equipamentos);
        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                idEquip = equipamentos.get(i).getEquipamentosId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        if (id == 0){
            setTitle("Adicionar Emprestimo");
            btnAcao.setText("salvar");
            btnAcao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    inserir();
                    finish();
                }
            });
        }
        else{
            setTitle("Editar Emprestimo");
            btnAcao.setText("Atualizar");
            btnDeletar.setVisibility(View.VISIBLE);

            Emprestimo emprestimo = db.emprestimoTable().get(id);

            int i; // index do id equipamento
            for (i = 0; i < equipamentos.toArray().length;i++){
                if(equipamentos.get(i).getEquipamentosId() == emprestimo.getEquipamentoId())
                    break;
            }
            spin.setSelection(i);

            nomeText.setText(emprestimo.getNomePessoa());
            telText.setText(emprestimo.getTelefone());
            dataText.setText(emprestimo.getData());
            check.setChecked(emprestimo.isDevolvido());
            btnAcao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    atualizar(emprestimo);
                    finish();
                }
            });
        }

        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete(id);
                finish();
            }
        });
    }
    protected void inserir(){
        Emprestimo emp = new Emprestimo(nomeText.getText().toString(),
                telText.getText().toString(),
                dataText.getText().toString(),
                idEquip);
        emp.setDevolvido(check.isChecked());
        db.emprestimoTable().insertAll(emp);
    }

    protected void atualizar(Emprestimo emp){

        emp.setNomePessoa(nomeText.getText().toString());
        emp.setTelefone(telText.getText().toString());
        emp.setData(dataText.getText().toString());
        emp.setDevolvido(check.isChecked());
        emp.setEquipamentoId(idEquip);
        db.emprestimoTable().updateEmprestimo(emp);
    }

    protected void delete(int id){
        db.emprestimoTable().delete(id);
    }
}