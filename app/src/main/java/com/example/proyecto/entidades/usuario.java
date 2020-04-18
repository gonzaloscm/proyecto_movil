package com.example.proyecto.entidades;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.proyecto.persistencia.room.Tabla;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity(tableName = Tabla.USUARIO)
@NoArgsConstructor
public class usuario {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idUsuario")
    private Integer idUsuario;

    @ColumnInfo(name = "nombre")
    private String nombre;

    @ColumnInfo(name = "apellido")
    private String apellido;

    @ColumnInfo(name = "edad")
    private Double edad;

}
