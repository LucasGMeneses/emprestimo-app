package com.example.emprestimoapp.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.emprestimoapp.R;
import com.example.emprestimoapp.models.AppDatabase;
import com.example.emprestimoapp.models.entity.Equipamentos;

public class EditarEquipamentoPage extends AppCompatActivity {
    private Button btnAcao;
    private Button btnCancelar;
    private Button btnDeletar;
    private EditText equipText;
    private EditText marcaText;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_equipamentos_page);

        // binding xml
        btnAcao = findViewById(R.id.btnAcao);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnDeletar = findViewById(R.id.btnDeletar);
        equipText = findViewById(R.id.nomeEquip);
        marcaText = findViewById(R.id.marcaEquip);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        int id = intent.getIntExtra("action",0);
        db = AppDatabase.getDatabase(getApplicationContext().getApplicationContext());


        if (id == 0){
            setTitle("Adicionar Equipamento");
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
            setTitle("Editar Equipamento");
            btnAcao.setText("Atualizar");
            btnDeletar.setVisibility(View.VISIBLE);

            Equipamentos equip = db.equipamentosTable().get(id);
            equipText.setText(equip.getNomeEquip());
            marcaText.setText(equip.getMarca());

            btnAcao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    atualizar(equip);
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
        Equipamentos equip = new Equipamentos(equipText.getText().toString(), marcaText.getText().toString());
        db.equipamentosTable().insertAll(equip);
    }

    protected void atualizar(Equipamentos equip){

        equip.setNomeEquip(equipText.getText().toString());
        equip.setMarca(marcaText.getText().toString());

        db.equipamentosTable().updateEquipamento(equip);
    }

    protected void delete(int id){
        db.equipamentosTable().delete(id);
    }


}