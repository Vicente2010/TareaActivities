package com.example.o_betanzos.tareaactivities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText tiNombre      = (EditText) findViewById(R.id.tiNombre);
        final EditText tiTelefono    = (EditText) findViewById(R.id.tiTelefono);
        final EditText tiEmail       = (EditText) findViewById(R.id.tiEmail);
        final EditText tiDescripcion = (EditText) findViewById(R.id.tiDescripcion);
        final DatePicker dpFechaNacimiento    = (DatePicker)  findViewById(R.id.dpFechaNacimiento);
        Button      btnNext             = (Button)      findViewById(R.id.btnNext);


        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class );
                intent.putExtra(getResources().getString(R.string.pnombre),tiNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdia),dpFechaNacimiento.getDayOfMonth());
                intent.putExtra(getResources().getString(R.string.pmes),dpFechaNacimiento.getMonth());
                intent.putExtra(getResources().getString(R.string.pyear),dpFechaNacimiento.getYear());
                intent.putExtra(getResources().getString(R.string.ptelefono),tiTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail),tiEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion),tiDescripcion.getText().toString());
                startActivityForResult(intent,1);


            }



        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode ==1){
            if (resultCode==RESULT_OK){

                Bundle parametros = getIntent().getExtras();
                    if (parametros != null){
                       /*
                    String nombre   = parametros.getString(getResources().getString(R.string.pnombre));

                    String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
                    String email    = parametros.getString(getResources().getString(R.string.pemail));
                    String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));
                    */
                        int dia         = parametros.getInt(getResources().getString(R.string.pdia));
                        int mes         = parametros.getInt(getResources().getString(R.string.pmes));
                        int year        = parametros.getInt(getResources().getString(R.string.pyear));

                        EditText tiNombre      = (EditText) findViewById(R.id.tiNombre);
                        EditText tiTelefono    = (EditText) findViewById(R.id.tiTelefono);
                        EditText tiEmail       = (EditText) findViewById(R.id.tiEmail);
                        EditText tiDescripcion = (EditText) findViewById(R.id.tiDescripcion);
                        DatePicker dpFechaNacimiento    = (DatePicker)  findViewById(R.id.dpFechaNacimiento);

                        tiNombre.setText(parametros.getString(getResources().getString(R.string.pnombre)));
                        tiTelefono.setText(parametros.getString(getResources().getString(R.string.ptelefono)));
                        tiEmail.setText(parametros.getString(getResources().getString(R.string.pemail)));
                        tiDescripcion.setText(parametros.getString(getResources().getString(R.string.pemail)));
                        dpFechaNacimiento.init(dia,mes,year,null);
                    }
                    
            }
        }
    }


}
