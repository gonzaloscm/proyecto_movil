package com.example.proyecto.persistencia.room.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.proyecto.entidades.usuario;
import java.util.List;

@Dao
public interface UsuarioDAO {
    @Insert
    void insert(usuario usuario);

    @Delete
    void delete(usuario usuario);

    @Query("DELETE FROM usuario WHERE idUsuario=:idUsuario")
    void deleteByIdUsuario(Integer idUsuario);

    @Query("SELECT * FROM usuario")
    List<usuario> listar();
}
