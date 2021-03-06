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
public interface EmprestimoDao {
    @Query("SELECT * FROM emprestimo")
    List<Emprestimo> getAll();

    @Query("SELECT * FROM emprestimo WHERE numEmpres = :numEmpres")
    Emprestimo get(int numEmpres);

    @Query("SELECT * FROM emprestimo WHERE numEmpres IN (:numEmpres)")
    List<Emprestimo> loadAllByIds(int[] numEmpres);

    @Update
    void updateEmprestimo(Emprestimo emprestimo);

    @Insert
    void insertAll(Emprestimo... emprestimos);

    @Query("DELETE FROM emprestimo WHERE numEmpres = :numEmpres")
    void delete(int numEmpres);

    @Query("DELETE FROM emprestimo")
    void deleteAll();
}
