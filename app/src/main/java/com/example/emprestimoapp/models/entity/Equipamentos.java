package com.example.emprestimoapp.models.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.emprestimoapp.models.AppDatabase;
import com.example.emprestimoapp.pages.EquipamentosPage;

import java.util.List;

@Entity(tableName = "equipamentos")
public class Equipamentos {
    @PrimaryKey(autoGenerate = true)
    int equipamentosId = 0;
    @ColumnInfo
    String nomeEquip;
    @ColumnInfo
    String marca;

    public Equipamentos(String nomeEquip, String marca) {
        this.nomeEquip = nomeEquip;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Equipamentos{" +
                "equipamentosId=" + equipamentosId +
                ", nomeEquip='" + nomeEquip + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    public String getNomeEquip() {
        return nomeEquip;
    }

    public void setNomeEquip(String nomeEquip) {
        this.nomeEquip = nomeEquip;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getEquipamentosId() {
        return equipamentosId;
    }

    public void setEquipamentosId(int equipamentosId) {
        this.equipamentosId = equipamentosId;
    }
}
