package com.example.emprestimoapp.models;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.emprestimoapp.models.dao.EmprestimoDao;
import com.example.emprestimoapp.models.dao.EquipamentosDao;
import com.example.emprestimoapp.models.entity.Emprestimo;
import com.example.emprestimoapp.models.entity.Equipamentos;

@Database(entities = {Equipamentos.class, Emprestimo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static  AppDatabase INSTANCE;
    public static AppDatabase getDatabase(Context context){

        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "EmpresaX").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
    public abstract EquipamentosDao equipamentosTable();
    public abstract EmprestimoDao emprestimoTable();
}
