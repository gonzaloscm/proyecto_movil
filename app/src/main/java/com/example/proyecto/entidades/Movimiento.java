package com.example.proyecto.entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.proyecto.persistencia.room.Tabla;



@Entity(tableName = Tabla.MOVIMIENTO)

public class Movimiento {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idMovimiento")
    private Integer idMovimiento;
    @ColumnInfo(name = "idUsuario")
    private Integer idUsuario;

    public Movimiento() {
        super();
    }

    @NonNull
    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(@NonNull Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
