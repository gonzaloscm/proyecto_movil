package com.example.proyecto.persistencia.room.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.proyecto.entidades.Movimiento;
import com.example.proyecto.entidades.usuario;
import com.example.proyecto.persistencia.room.DAO.MovimientoDAO;
import com.example.proyecto.persistencia.room.DAO.UsuarioDAO;


/**
 * Listado de entities
 */

@Database(entities = {
        usuario.class,
        Movimiento.class}, version = DataBaseHelper.VERSION_BASE_DATOS, exportSchema = false)

public abstract class DataBaseHelper extends RoomDatabase {

    public static final int VERSION_BASE_DATOS = 1;
    public static final String NOMBRE_BASE_DATOS = "proyecto";
    private static DataBaseHelper instace;


    public static DataBaseHelper getSimpleDB(Context context){
        if (instace == null) {
            instace = Room.databaseBuilder(context, DataBaseHelper.class, NOMBRE_BASE_DATOS).build();
        }
        return instace;
    }

    public static DataBaseHelper getDBMainThread(Context context){
        if (instace == null) {
            instace = Room.databaseBuilder(context, DataBaseHelper.class, NOMBRE_BASE_DATOS).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instace;
    }


    /**
     * Listado de DAO
     */

    public abstract UsuarioDAO getUsarioDAO();

    public abstract MovimientoDAO getMovimientoDAO();


}
