package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto.entidades.usuario;
import com.example.proyecto.persistencia.room.room.DataBaseHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.txtNombre)
    public EditText txtNombre;

    @BindView(R.id.txtApellido)
    public EditText txtApellido;

    @BindView(R.id.txtEdad)
    public EditText txtEdad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void guardar(View view) {
        String nombreUsuario = txtNombre.getText().toString();
        String apellidoUsuario = txtApellido.getText().toString();
        Double valorEdad = toDouble(txtEdad.getText().toString());

        if (validarInformacion(nombreUsuario,apellidoUsuario,valorEdad)){
            usuario usuario = getUsuario(nombreUsuario,apellidoUsuario,valorEdad);

          new InsercionUsuario().execute(usuario);
          finish();
        }
    }

    private usuario getUsuario(String nombreUsuario, String apellidoUsuario, Double valorEdad) {
        usuario usuario = new usuario();
        usuario.setNombre(nombreUsuario);
        usuario.setApellido(apellidoUsuario);
        usuario.setEdad(valorEdad);
        return usuario;
    }

    private boolean validarInformacion(String nombreUsuario, String apellidoUsuario, Double valorEdad){
        boolean esValido = true;
        if ("".equals(nombreUsuario)){
            txtNombre.setError(getString(R.string.requerido));
            esValido = false;
        }
        if ("".equals(apellidoUsuario)){
            txtApellido.setError(getString(R.string.requerido));
            esValido = false;
        }
        if (valorEdad == 0){
            txtEdad.setError(getString(R.string.requerido));
        }
        return esValido;
    }

    private Double toDouble(String valor) {
        return "".equals(valor)?0:Double.parseDouble(valor);
    }

    private class InsercionUsuario extends AsyncTask<usuario,Void,Void>{

        @Override
        protected Void doInBackground(usuario... usuarios) {

            DataBaseHelper.getSimpleDB(getApplicationContext()).getUsarioDAO().insert(usuarios[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(getApplicationContext(),getString(R.string.successfully), Toast.LENGTH_SHORT).show();
            super.onPostExecute(aVoid);
        }
    }
}
