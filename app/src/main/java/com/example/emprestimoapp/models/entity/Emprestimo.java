package com.example.emprestimoapp.models.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "emprestimo",
        foreignKeys = @ForeignKey(entity = Equipamentos.class,
                parentColumns = "equipamentosId", childColumns = "equipamentoId"))
public class Emprestimo {
    @PrimaryKey(autoGenerate = true)
    int numEmpres = 0;
    @ColumnInfo
    int equipamentoId; // foreign key
    @ColumnInfo
    String nomePessoa;
    @ColumnInfo
    String telefone;
    @ColumnInfo
    String data;
    @ColumnInfo
    boolean devolvido;

    public Emprestimo(int equipamentoId, String nomePessoa, String telefone, String data) {
        this.equipamentoId = equipamentoId;
        this.nomePessoa = nomePessoa;
        this.telefone = telefone;
        this.data = data;
        this.devolvido = false;
    }


    public int getNumEmpres() {
        return numEmpres;
    }

    public void setNumEmpres(int numEmpres) {
        this.numEmpres = numEmpres;
    }

    public int getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(int equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

}
