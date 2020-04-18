package com.example.proyecto.entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.proyecto.persistencia.room.Tabla;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(tableName = Tabla.MOVIMIENTO)
@NoArgsConstructor
public class Movimiento {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idMovimiento")
    private Integer idMovimiento;
    @ColumnInfo(name = "idUsuario")
    private Integer idUsuario;

}
