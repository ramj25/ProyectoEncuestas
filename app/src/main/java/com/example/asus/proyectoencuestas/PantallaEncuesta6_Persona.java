package com.example.asus.proyectoencuestas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class PantallaEncuesta6_Persona extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_encuesta6__persona);


        TextView txtNombre=findViewById(R.id.txtNombre);
        Spinner spnSexo=findViewById(R.id.spnSexo);
        Spinner spnEdad=findViewById(R.id.spnEdad);
        Spinner spnDiscapacidad=findViewById(R.id.spnDiscapacidad);
        Spinner spnAyuda=findViewById(R.id.spnAyuda);
        Spinner spnOcupacion=findViewById(R.id.spnOcupacion);
        Spinner spnActividad=findViewById(R.id.spnActividad);
        Spinner spnLicencia=findViewById(R.id.spnLicencia);
        TextView txtCorreo=findViewById(R.id.txtCorreo);

        Button btnNuevoViaje=findViewById(R.id.btnNuevoViaje);
        RecyclerView recViajes=findViewById(R.id.recViajes);








        btnNuevoViaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),PantallaEncuesta6_Viaje.class);
                startActivity(i);



            }
        });



    }
}
