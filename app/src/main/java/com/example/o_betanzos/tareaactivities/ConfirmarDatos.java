package com.example.o_betanzos.tareaactivities;

import android.content.Intent;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros   = getIntent().getExtras();

        final String nombre       = parametros.getString(getResources().getString(R.string.pnombre));
        final int dia             = parametros.getInt(getResources().getString(R.string.pdia));
        final int mes             = parametros.getInt(getResources().getString(R.string.pmes));
        final int year            = parametros.getInt(getResources().getString(R.string.pyear));
        final String telefono     = parametros.getString(getResources().getString(R.string.ptelefono));
        final String email        = parametros.getString(getResources().getString(R.string.pemail));
        final String descripcion  = parametros.getString(getResources().getString(R.string.pdescripcion));

        TextView tvNombre           = (TextView) findViewById(R.id.tvNombre);
        TextView tvFechaNacimiento  = (TextView) findViewById(R.id.tvFechaNacimiento);
        TextView tvTelefono         = (TextView) findViewById(R.id.tvTelefono);
        TextView tvEmail            = (TextView) findViewById(R.id.tvEmail);
        TextView tvDescripcion      = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.           setText("Nombre: "          + nombre);
        tvFechaNacimiento.  setText("Fecha Nacimiento: " + String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(year));
        tvTelefono.         setText("No. Teléfono: "    + telefono);
        tvEmail.            setText("Email "            + email);
        tvDescripcion.      setText("Descripcion: "     + descripcion);

        Button btnEditar = (Button) findViewById(R.id.btnEditar);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmarDatos.this,MainActivity.class);
                intent.putExtra(getResources().getString(R.string.pnombre), nombre);
                intent.putExtra(getResources().getString(R.string.ptelefono), telefono);
                intent.putExtra(getResources().getString(R.string.pemail), email);
                intent.putExtra(getResources().getString(R.string.pdescripcion),descripcion);
                intent.putExtra(getResources().getString(R.string.pdia),dia);
                intent.putExtra(getResources().getString(R.string.pmes),mes);
                intent.putExtra(getResources().getString(R.string.pyear),year);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}
