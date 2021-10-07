package com.example.emprestimoapp.models.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.emprestimoapp.models.entity.Emprestimo;
import com.example.emprestimoapp.models.entity.Equipamentos;

import java.util.List;

@Dao
public interface EquipamentosDao {
    @Query("SELECT * FROM equipamentos")
    List<Equipamentos> getAll();

    @Query("SELECT * FROM equipamentos WHERE equipamentosId IN (:equipamentosIds)")
    List<Equipamentos> loadAllByIds(int[] equipamentosIds);

    @Update
    void updateEquipamento(Equipamentos equipamentos);

    @Insert
    void insertAll(Equipamentos... equipamentos);

    @Query("DELETE FROM equipamentos WHERE equipamentosId = :equipId")
    void delete(int equipId);

    @Query("DELETE FROM equipamentos")
    void deleteAll();
}
