package com.example.asus.proyectoencuestas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class PantallaEncuesta6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_encuesta6);



        TextView txtNumHogar=findViewById(R.id.txtNumHogar);
        TextView txtDireccionHogar=findViewById(R.id.txtDireccionHogar);
        TextView txtTeleCel=findViewById(R.id.txtTeleCel);
        Spinner spnNivelSE=findViewById(R.id.spnNivelSE);

        Spinner spnHombresMenores=findViewById(R.id.spnHombresMenores);
        Spinner spnHombresMayores=findViewById(R.id.spnHombresMayores);
        Spinner spnHombresEmpleados=findViewById(R.id.spnHombresEmpleados);
        Spinner spnMujeresMenores=findViewById(R.id.spnMujeresMenores);
        Spinner spnMujeresMayores=findViewById(R.id.spnMujeresMayores);
        Spinner spnMujeresEmpleadas=findViewById(R.id.spnMujeresEmpleadas);

        TextView txtZonaTransito=findViewById(R.id.txtZonaTransito);
        Spinner spnTipoPropiedad=findViewById(R.id.spnTipoPropiedad);
        Spinner spnTipoConstruccion=findViewById(R.id.spnTipoConstruccion);
        Spinner spnNumeroHabitaciones=findViewById(R.id.spnNumeroHabitaciones);
        Spinner spnIngresoHogar=findViewById(R.id.spnIngresoHogar);
        Spinner spnNivelEducacionJefe=findViewById(R.id.spnNivelEducacionJefe);




    }
}
