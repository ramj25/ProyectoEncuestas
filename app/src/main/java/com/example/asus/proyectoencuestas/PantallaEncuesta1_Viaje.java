package com.example.asus.proyectoencuestas;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PantallaEncuesta1_Viaje extends AppCompatActivity {


    AdaptadorListaViaje adapterViaje;
    ArrayList<Object> listaViajes=new ArrayList<>();


    public static String coordOrigen;
    public static String coordDestino;

    public static String autoCompletado;


    public static TextView lblCoordenadasOrigen;
    public static TextView lblCoordenadasDestino;



    //public boolean alMenosUnTramo; (?)


    public boolean valDireccionOrigenViaje;
    public boolean valReferenciaOrigenViaje;

    public boolean valDireccionDestinoViaje;
    public boolean valReferenciaDestinoViaje;

    public boolean valNumeroCelular;

    //public boolean CAMPO NUMERO UNO DEL RECYCLER (STRING, VALIDAR CADA REGISTRO INGRESADO, DONDE SEA NECESARIO)
    //public boolean CAMPO NUMERO DOS DEL RECYCLER (INT, VALIDAR CADA REGISTRO INGRESADO, DONDE SEA NECESARIO)




    static Map<String,Boolean> vals3=new HashMap<String,Boolean>();
    static {
        // vals.put("alMenosUnTramo", null);
        vals3.put("valDireccionOrigenViaje", null);
        vals3.put("valReferenciaOrigenViaje", null);
        vals3.put("valDireccionDestinoViaje", null);
        vals3.put("valReferenciaDestinoViaje", null);
        vals3.put("valNumeroCelular", null);
        vals3.put("valOtraFrecuencia", null);


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_encuesta1__viaje);


        coordOrigen=null;
        coordDestino=null;


        final Spinner spnDistritoOrigenViaje=findViewById(R.id.spnDistritoOrigenViaje);
        final Spinner spnZonaTransitoOrigen=findViewById(R.id.spnZonaTransitoOrigen);                  //ES UN SPINNER O UN TEXTVIEW? (VALIDAR DE SER TEXTVIEW)
        final TextView txtDireccionOrigenViaje=findViewById(R.id.txtDireccionOrigenViaje);
        final TextView txtReferenciaOrigenViaje=findViewById(R.id.txtReferenciaOrigenViaje);
        final Spinner spnLugarOrigen=findViewById(R.id.spnLugarOrigen);

        final Spinner spnHoraSalidaViaje=findViewById(R.id.spnHoraSalidaViaje);
        final Spinner spnMinutoSalidaViaje=findViewById(R.id.spnMinutoSalidaViaje);
        final Spinner spnAmopmOrigen=findViewById(R.id.spnAmopmOrigen);


        final Spinner spnDistritoDestinoViaje=findViewById(R.id.spnDistritoDestinoViaje);
        final Spinner spnZonaTransitoDestino=findViewById(R.id.spnZonaTransitoDestino);                  //ES UN SPINNER O UN TEXTVIEW? (VALIDAR DE SER TEXTVIEW)
        final TextView txtDireccionDestinoViaje=findViewById(R.id.txtDireccionDestinoViaje);
        final TextView txtReferenciaDestinoViaje=findViewById(R.id.txtReferenciaDestinoViaje);
        final Spinner spnLugarDestino=findViewById(R.id.spnLugarDestino);

        final Spinner spnHoraLlegadaViaje=findViewById(R.id.spnHoraLlegadaViaje);
        final Spinner spnMinutoLlegadaViaje=findViewById(R.id.spnMinutoLlegadaViaje);
        final Spinner spnAmopmDestino=findViewById(R.id.spnAmopmDestino);


        final Spinner spnPropositoViaje=findViewById(R.id.spnPropositoViaje);


        Button btnCrearTramoViaje=findViewById(R.id.btnCrearTramoViaje);
        final RecyclerView recTramoViaje=findViewById(R.id.recTramoViaje);


        final Spinner spnManejoCarro=findViewById(R.id.spnManejoCarro);
        final Spinner spnLugarEstacionamiento=findViewById(R.id.spnLugarEstacionamiento);
        final Spinner spnPagoEstacionamiento=findViewById(R.id.spnPagoEstacionamiento);
        final Spinner spnTarifaEstacionamiento=findViewById(R.id.spnTarifaEstacionamiento);


        final Spinner spnPorqueNoTransportePublico=findViewById(R.id.spnPorqueNoTransportePublico);
        final Spinner spnRazonMedioTransporte=findViewById(R.id.spnRazonMedioTransporte);


        final Spinner spnTarifa1=findViewById(R.id.spnTarifa1);
        final Spinner spnTiempoViaje1=findViewById(R.id.spnTiempoViaje1);
        final Spinner spnNumeroTransbordos1=findViewById(R.id.spnNumeroTransbordos1);
        final Spinner spnDistanciaParadero1=findViewById(R.id.spnDistanciaParadero1);


        final Spinner spnTarifa2=findViewById(R.id.spnTarifa2);
        final Spinner spnTiempoViaje2=findViewById(R.id.spnTiempoViaje2);
        final Spinner spnDistanciaParadero2=findViewById(R.id.spnDistanciaParadero2);


        final Spinner spnPeaje3=findViewById(R.id.spnPeaje3);
        final Spinner spnTiempoViaje3=findViewById(R.id.spnTiempoViaje3);
        final Spinner spnCostoViaje3=findViewById(R.id.spnCostoViaje3);
        final Spinner spnEstacionamiento3=findViewById(R.id.spnEstacionamiento3);


        final Spinner spnDiaViaje=findViewById(R.id.spnDiaViaje);
        final Spinner spnMesViaje=findViewById(R.id.spnMesViaje);


        final Spinner spnPeajesViaje=findViewById(R.id.spnPeajesViaje);
        final Spinner spnFrecuenciaViaje=findViewById(R.id.spnFrecuenciaViaje);


        final Spinner spnViajeMasLargo=findViewById(R.id.spnViajeMasLargo);
        final Spinner spnMedioTrans=findViewById(R.id.spnMedioTrans);
        final Spinner spnPorqueNoUtiliza=findViewById(R.id.spnPorqueNoUtiliza);
        final Spinner spnConsentimiento=findViewById(R.id.spnConsentimiento);
        final TextView txtNumeroCelular=findViewById(R.id.txtNumeroCelular);


        final TextView txtOtraFrecuencia=findViewById(R.id.txtOtraFrecuencia);


        Button btnGuardarViaje=findViewById(R.id.btnGuardarViaje);

        Button btnCoordenadasOrigen=findViewById(R.id.btnCoordenadasOrigen);
        Button btnCoordenadasDestino=findViewById(R.id.btnCoordenadasDestino);


        lblCoordenadasOrigen=findViewById(R.id.lblCoordenadasOrigen);
        lblCoordenadasDestino=findViewById(R.id.lblCoordenadasDestino);



        Button btnCopiar=findViewById(R.id.btnCopiar);







        String[] listaLugarOrigen={"Seleccionar","Residencial","Oficina","Industrial","Educacional","Comercial","Recreacional","Medico","Restaurante","Otro"};
        ArrayAdapter<String> adapterLugarOrigen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaLugarOrigen);
        spnLugarOrigen.setAdapter(adapterLugarOrigen);

        String[] listaHoraSalidaViaje={"--","0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
        ArrayAdapter<String> adapterHoraSalidaViaje = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaHoraSalidaViaje);
        spnHoraSalidaViaje.setAdapter(adapterHoraSalidaViaje);

        String[] listaMinutoSalidaViaje={"--","0","5","10","15","20","25","30","35","40","45","50","55"};
        ArrayAdapter<String> adapterMinutoSalidaViaje = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaMinutoSalidaViaje);
        spnMinutoSalidaViaje.setAdapter(adapterMinutoSalidaViaje);

        String[] listaAmopmOrigen={"--","AM","PM"};
        ArrayAdapter<String> adapterAmopmOrigen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAmopmOrigen);
        spnAmopmOrigen.setAdapter(adapterAmopmOrigen);

        String[] listaLugarDestino={"Seleccionar","Residencial","Oficina","Industrial","Educacional","Comercial","Recreacional","Medico","Restaurante","Otro"};
        ArrayAdapter<String> adapterLugarDestino = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaLugarDestino);
        spnLugarDestino.setAdapter(adapterLugarDestino);

        String[] listaHoraLlegadaViaje={"--","0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
        ArrayAdapter<String> adapterHoraLlegadaViaje = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaHoraLlegadaViaje);
        spnHoraLlegadaViaje.setAdapter(adapterHoraLlegadaViaje);

        String[] listaMinutoLlegadaViaje={"--","0","5","10","15","20","25","30","35","40","45","50","55"};
        ArrayAdapter<String> adapterMinutoLlegadaViaje = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaMinutoLlegadaViaje);
        spnMinutoLlegadaViaje.setAdapter(adapterMinutoLlegadaViaje);

        String[] listaAmopmDestino={"--","AM","PM"};
        ArrayAdapter<String> adapterAmopmDestino = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAmopmDestino);
        spnAmopmDestino.setAdapter(adapterAmopmDestino);

        String[] listaPropositoViaje={"Seleccionar","A Trabajar","A Estudiar","Por Trabajo","Volver al Centro de Trabajo","Compras","A Comer","Esparcimiento","Llevar a un Familiar","Otro Particular","Volver a Casa"};
        ArrayAdapter<String> adapterPropositoViaje = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPropositoViaje);
        spnPropositoViaje.setAdapter(adapterPropositoViaje);

        String[] listaManejoCarro={"--","Si","No"};
        ArrayAdapter<String> adapterManejoCarro = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaManejoCarro);
        spnManejoCarro.setAdapter(adapterManejoCarro);

        String[] listaLugarEstacionamiento={"Seleccionar","Calle","Estacionamiento","No"};
        ArrayAdapter<String> adapterLugarEstacionamiento = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaLugarEstacionamiento);
        spnLugarEstacionamiento.setAdapter(adapterLugarEstacionamiento);

        String[] listaPagoEstacionamiento={"Seleccionar","Pagado","Gratis"};
        ArrayAdapter<String> adapterPagoEstacionamiento = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPagoEstacionamiento);
        spnPagoEstacionamiento.setAdapter(adapterPagoEstacionamiento);

       // String[] listaTarifaEstacionamiento={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
        String[] listaTarifaEstacionamiento={"0","0.1","0.2","0.3","0.4","0.5","0.6","0.7","0.8","0.9","1.0","1.1","1.2","1.3","1.4","1.5","1.6","1.7","1.8","1.9","2.0","2.1","2.2","2.3","2.4","2.5","2.6","2.7","2.8","2.9","3.0","3.1","3.2","3.3","3.4","3.5","3.6","3.7","3.8","3.9","4.0","4.1","4.2","4.3","4.4","4.5","4.6","4.7","4.8","4.9","5.0","5.1","5.2","5.3","5.4","5.5","5.6","5.7","5.8","5.9","6.0","6.1","6.2","6.3","6.4","6.5","6.6","6.7","6.8","6.9","7.0","7.1","7.2","7.3","7.4","7.5","7.6","7.7","7.8","7.9","8.0","8.1","8.2","8.3","8.4","8.5","8.6","8.7","8.8","8.9","9.0","9.1","9.2","9.3","9.4","9.5","9.6","9.7","9.8","9.9","10.0","10.1","10.2","10.3","10.4","10.5","10.6","10.7","10.8","10.9","11.0","11.1","11.2","11.3","11.4","11.5","11.6","11.7","11.8","11.9","12.0","12.1","12.2","12.3","12.4","12.5","12.6","12.7","12.8","12.9","13.0","13.1","13.2","13.3","13.4","13.5","13.6","13.7","13.8","13.9","14.0","14.1","14.2","14.3","14.4","14.5","14.6","14.7","14.8","14.9","15.0","15.1","15.2","15.3","15.4","15.5","15.6","15.7","15.8","15.9","16.0","16.1","16.2","16.3","16.4","16.5","16.6","16.7","16.8","16.9","17.0","17.1","17.2","17.3","17.4","17.5","17.6","17.7","17.8","17.9","18.0","18.1","18.2","18.3","18.4","18.5","18.6","18.7","18.8","18.9","19.0","19.1","19.2","19.3","19.4","19.5","19.6","19.7","19.8","19.9","20.0","20.1","20.2","20.3","20.4","20.5","20.6","20.7","20.8","20.9","21.0","21.1","21.2","21.3","21.4","21.5","21.6","21.7","21.8","21.9","22.0","22.1","22.2","22.3","22.4","22.5","22.6","22.7","22.8","22.9","23.0","23.1","23.2","23.3","23.4","23.5","23.6","23.7","23.8","23.9","24.0","24.1","24.2","24.3","24.4","24.5","24.6","24.7","24.8","24.9","25.0","25.1","25.2","25.3","25.4","25.5","25.6","25.7","25.8","25.9","26.0","26.1","26.2","26.3","26.4","26.5","26.6","26.7","26.8","26.9","27.0","27.1","27.2","27.3","27.4","27.5","27.6","27.7","27.8","27.9","28.0","28.1","28.2","28.3","28.4","28.5","28.6","28.7","28.8","28.9","29.0","29.1","29.2","29.3","29.4","29.5","29.6","29.7","29.8","29.9","30.0"};
        ArrayAdapter<String> adapterTarifaEstacionamiento = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTarifaEstacionamiento);
        spnTarifaEstacionamiento.setAdapter(adapterTarifaEstacionamiento);

        String[] listaRazonMedioTransporte={"Seleccionar","Tiempo de Viaje","Precio","Comodidad","Seguridad","Conveniencia","No hay otra opcion","Otros"};
        ArrayAdapter<String> adapterRazonMedioTransporte = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaRazonMedioTransporte);
        spnRazonMedioTransporte.setAdapter(adapterRazonMedioTransporte);

        String[] listaPorqueNoTransportePublico={"Seleccionar","No esta disponible","Esta disponible, pero es incomodo","No es incomodo, pero prefiero otros"};
        ArrayAdapter<String> adapterPorqueNoTransportePublico = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPorqueNoTransportePublico);
        spnPorqueNoTransportePublico.setAdapter(adapterPorqueNoTransportePublico);

        String[] listaDistanciaParadero1={"0","50","100","250","500","1000","2000","3000","4000","5000"};
        ArrayAdapter<String> adapterDistanciaParadero1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDistanciaParadero1);
        spnDistanciaParadero1.setAdapter(adapterDistanciaParadero1);

        String[] listaTiempoViaje1={"0","5","10","15","20","30","45","60","90","120","150","180","240"};
        ArrayAdapter<String> adapterTiempoViaje1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTiempoViaje1);
        spnTiempoViaje1.setAdapter(adapterTiempoViaje1);

        String[] listaTarifa1={"0","0.5","0.6","0.7","0.8","0.9","1","1.2","1.5","1.8","2","2.2","2.5","2.8","3","3.2","3.5","3.8","4","4.2","4.5","4.8","5"};
        ArrayAdapter<String> adapterTarifa1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTarifa1);
        spnTarifa1.setAdapter(adapterTarifa1);

        String[] listaNumeroTransbordos1={"0","1","2","3","4","5"};
        ArrayAdapter<String> adapterNumeroTransbordos1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNumeroTransbordos1);
        spnNumeroTransbordos1.setAdapter(adapterNumeroTransbordos1);

        String[] listaDistanciaParadero2={"0","50","100","250","500","1000","2000","3000","4000","5000"};
        ArrayAdapter<String> adapterDistanciaParadero2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDistanciaParadero2);
        spnDistanciaParadero2.setAdapter(adapterDistanciaParadero2);

        String[] listaTiempoViaje2={"0","5","10","15","20","30","45","60","90","120","150","180","240"};
        ArrayAdapter<String> adapterTiempoViaje2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTiempoViaje2);
        spnTiempoViaje2.setAdapter(adapterTiempoViaje2);

        String[] listaTarifa2={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
        ArrayAdapter<String> adapterTarifa2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTarifa2);
        spnTarifa2.setAdapter(adapterTarifa2);

        String[] listaTiempoViaje3={"0","5","10","15","20","30","45","60","90","120","150","180","240"};
        ArrayAdapter<String> adapterTiempoViaje3 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTiempoViaje3);
        spnTiempoViaje3.setAdapter(adapterTiempoViaje3);

        String[] listaCostoViaje3={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
        ArrayAdapter<String> adapterCostoViaje3 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaCostoViaje3);
        spnCostoViaje3.setAdapter(adapterCostoViaje3);

        String[] listaPeaje3={"0","0.5","1","1.5","2","2.5","3","3.5","4","4.5","5","5.5","6","6.5","7","7.5","8","8.5","9","9.5","10","10.5","11","11.5","12","12.5","13","13.5","14","14.5","15","15.5","16","16.5","17","17.5","18","18.5","19","19.5","20","20.5","21","21.5","22","22.5","23","23.5","24","24.5","25","25.5","26","26.5","27","27.5","28","28.5","29","29.5","30"};
        ArrayAdapter<String> adapterPeaje3 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPeaje3);
        spnPeaje3.setAdapter(adapterPeaje3);

        String[] listaEstacionamiento3={"0","0.5","1","1.5","2","2.5","3","3.5","4","4.5","5","5.5","6","6.5","7","7.5","8","8.5","9","9.5","10","10.5","11","11.5","12","12.5","13","13.5","14","14.5","15","15.5","16","16.5","17","17.5","18","18.5","19","19.5","20","20.5","21","21.5","22","22.5","23","23.5","24","24.5","25","25.5","26","26.5","27","27.5","28","28.5","29","29.5","30","30.5","31","31.5","32","32.5","33","33.5","34","34.5","35","35.5","36","36.5","37","37.5","38","38.5","39","39.5","40","40.5","41","41.5","42","42.5","43","43.5","44","44.5","45","45.5","46","46.5","47","47.5","48","48.5","49","49.5","50"};
        ArrayAdapter<String> adapterEstacionamiento3 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaEstacionamiento3);
        spnEstacionamiento3.setAdapter(adapterEstacionamiento3);

       // String[] listaDiaViaje={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String[] listaDiaViaje={"--","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        ArrayAdapter<String> adapterDiaViaje = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDiaViaje);
        spnDiaViaje.setAdapter(adapterDiaViaje);

        //String[] listaMesViaje={"0","1","2","3","4","5","6","7","8","9","10","11","12"};
        String[] listaMesViaje={"--","3","4","5","6","7","8"};
        ArrayAdapter<String> adapterMesViaje = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaMesViaje);
        spnMesViaje.setAdapter(adapterMesViaje);

        String[] listaPeajesViaje={"0","1.0","1.1","1.2","1.3","1.4","1.5","1.6","1.7","1.8","1.9","2.0","2.1","2.2","2.3","2.4","2.5","2.6","2.7","2.8","2.9","3.0","3.1","3.2","3.3","3.4","3.5","3.6","3.7","3.8","3.9","4.0","4.1","4.2","4.3","4.4","4.5","4.6","4.7","4.8","4.9","5.0","5.1","5.2","5.3","5.4","5.5","5.6","5.7","5.8","5.9","6.0","6.1","6.2","6.3","6.4","6.5","6.6","6.7","6.8","6.9","7.0","7.1","7.2","7.3","7.4","7.5","7.6","7.7","7.8","7.9","8.0","8.1","8.2","8.3","8.4","8.5","8.6","8.7","8.8","8.9","9.0","9.1","9.2","9.3","9.4","9.5","9.6","9.7","9.8","9.9","10.0","10.1","10.2","10.3","10.4","10.5","10.6","10.7","10.8","10.9","11.0","11.1","11.2","11.3","11.4","11.5","11.6","11.7","11.8","11.9","12.0","12.1","12.2","12.3","12.4","12.5","12.6","12.7","12.8","12.9","13.0","13.1","13.2","13.3","13.4","13.5","13.6","13.7","13.8","13.9","14.0","14.1","14.2","14.3","14.4","14.5","14.6","14.7","14.8","14.9","15.0","15.1","15.2","15.3","15.4","15.5","15.6","15.7","15.8","15.9","16.0","16.1","16.2","16.3","16.4","16.5","16.6","16.7","16.8","16.9","17.0","17.1","17.2","17.3","17.4","17.5","17.6","17.7","17.8","17.9","18.0","18.1","18.2","18.3","18.4","18.5","18.6","18.7","18.8","18.9","19.0","19.1","19.2","19.3","19.4","19.5","19.6","19.7","19.8","19.9","20.0","20.1","20.2","20.3","20.4","20.5","20.6","20.7","20.8","20.9","21.0","21.1","21.2","21.3","21.4","21.5","21.6","21.7","21.8","21.9","22.0","22.1","22.2","22.3","22.4","22.5","22.6","22.7","22.8","22.9","23.0","23.1","23.2","23.3","23.4","23.5","23.6","23.7","23.8","23.9","24.0","24.1","24.2","24.3","24.4","24.5","24.6","24.7","24.8","24.9","25.0","25.1","25.2","25.3","25.4","25.5","25.6","25.7","25.8","25.9","26.0","26.1","26.2","26.3","26.4","26.5","26.6","26.7","26.8","26.9","27.0","27.1","27.2","27.3","27.4","27.5","27.6","27.7","27.8","27.9","28.0","28.1","28.2","28.3","28.4","28.5","28.6","28.7","28.8","28.9","29.0","29.1","29.2","29.3","29.4","29.5","29.6","29.7","29.8","29.9","30.0"};
        ArrayAdapter<String> adapterPeajesViaje = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPeajesViaje);
        spnPeajesViaje.setAdapter(adapterPeajesViaje);

        String[] listaFrecuenciaViaje={"Seleccionar","7 dias a la Semana","6 dias a la Semana","5 dias a la Semana","4 dias a la Semana","3 dias a la Semana","2 dias a la Semana","1 dia a la Semana","Otra"};
        ArrayAdapter<String> adapterFrecuenciaViaje = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaFrecuenciaViaje);
        spnFrecuenciaViaje.setAdapter(adapterFrecuenciaViaje);

        String[] listaViajeMasLargo={"No","Si"};
        ArrayAdapter<String> adapterViajeMasLargo = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaViajeMasLargo);
        spnViajeMasLargo.setAdapter(adapterViajeMasLargo);

        String[] listaMedioTrans={"Seleccionar","Carro Particular","Motocicleta / Cuatrimoto","Bicicleta / Patineta","Taxi","Taxi App","Colectivo","Bus, microbus o Combi","Corredor","Metropolitano","Alimentador","Tren electrico","Mototaxi"};
        ArrayAdapter<String> adapterMedioTrans = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaMedioTrans);
        spnMedioTrans.setAdapter(adapterMedioTrans);

        String[] listaConsentimiento={"No","Si"};
        ArrayAdapter<String> adapterConsentimiento = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaConsentimiento);
        spnConsentimiento.setAdapter(adapterConsentimiento);

        String[] listaPorqueNoUtiliza={"Seleccionar","No esta disponible","Esta disponible, pero es incomodo","No es incomodo, pero prefiero otros"};
        ArrayAdapter<String> adapterPorqueNoUtiliza = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPorqueNoUtiliza);
        spnPorqueNoUtiliza.setAdapter(adapterPorqueNoUtiliza);


        //SPINNERS TEMPORALES (?):


        String[] listaZonaTransitoOrigen={"Seleccionar","Zona Transito 1","Zona Transito 2"};
        ArrayAdapter<String> adapterZonaTransitoOrigen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaZonaTransitoOrigen);
        spnZonaTransitoOrigen.setAdapter(adapterZonaTransitoOrigen);

        String[] listaZonaTransitoDestino={"Seleccionar","Zona Transito 1","Zona Transito 2"};
        ArrayAdapter<String> adapterZonaTransitoDestino = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaZonaTransitoDestino);
        spnZonaTransitoDestino.setAdapter(adapterZonaTransitoDestino);


     //   String[] listaDistritoOrigenViaje={"Seleccionar","Cercado de Lima","Ancon","Ate","Barranco","Breña","Carabayllo","Comas","Chaclacayo","Chorrillos","El Agustino","Jesus Maria","La Molina","La Victoria","Lince","Lurigancho","Lurin","Magdalena del Mar","Miraflores","Pachacamac","Pucusana","Pueblo Libre","Puente Piedra","Punta Negra","Punta Hermosa","Rimac","San Bartolo","San Isidro","Independencia","San Juan de Miraflores","San Luis","San Martin de Porres","San Miguel","Santiago de Surco","Surquillo","Villa Maria del Triunfo","San Juan de Lurigancho","Santa Maria del Mar","Santa Rosa","Los Olivos","Cieneguilla","San Borja","Villa el Salvador","Santa Anita","Bellavista","Callao","Carmen de la Legua","La Perla","La Punta","Ventanilla","Mi Peru"};
        String[] listaDistritoOrigenViaje={"Seleccionar","Ancon","Ate","Barranco","Breña","Carabayllo","Chaclacayo","Chorrillos","Cieneguilla","Comas","El Agustino","Independencia","Jesus Maria","La Molina","La Victoria","Lima (Cercado)","Lince","Los Olivos","Lurigancho","Lurin","Magdalena del Mar","Miraflores","Pachacamac","Pucusana","Pueblo Libre","Puente Piedra","Punta Hermosa","Punta Negra","Rimac","San Bartolo","San Borja","San Isidro","San Juan de Lurigancho","San Juan de Miraflores","San Luis","San Martin de Porres","San Miguel","Santa Anita","Santa Maria del Mar","Santa Rosa","Santiago de Surco","Surquillo","Villa el Salvador","Villa Maria del Triunfo","Bellavista","Callao","Carmen de la Legua","La Perla","La Punta","Ventanilla","Mi Peru","Barranca","Huacho","Chancay","Huaral","Canta","Santa Rosa de Quives","San Antonio","Matucana","Santa Eulalia","Surco","Antioquia","Chilca","Mala","Asia","Imperial","Panamericana Norte","Carretera a Canta","Carretera Central","Panamericana Sur"};
        ArrayAdapter<String> adapterDistritoOrigenViaje = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDistritoOrigenViaje);
        spnDistritoOrigenViaje.setAdapter(adapterDistritoOrigenViaje);

     //   String[] listaDistritoDestinoViaje={"Seleccionar","Cercado de Lima","Ancon","Ate","Barranco","Breña","Carabayllo","Comas","Chaclacayo","Chorrillos","El Agustino","Jesus Maria","La Molina","La Victoria","Lince","Lurigancho","Lurin","Magdalena del Mar","Miraflores","Pachacamac","Pucusana","Pueblo Libre","Puente Piedra","Punta Negra","Punta Hermosa","Rimac","San Bartolo","San Isidro","Independencia","San Juan de Miraflores","San Luis","San Martin de Porres","San Miguel","Santiago de Surco","Surquillo","Villa Maria del Triunfo","San Juan de Lurigancho","Santa Maria del Mar","Santa Rosa","Los Olivos","Cieneguilla","San Borja","Villa el Salvador","Santa Anita","Bellavista","Callao","Carmen de la Legua","La Perla","La Punta","Ventanilla","Mi Peru"};
        String[] listaDistritoDestinoViaje={"Seleccionar","Ancon","Ate","Barranco","Breña","Carabayllo","Chaclacayo","Chorrillos","Cieneguilla","Comas","El Agustino","Independencia","Jesus Maria","La Molina","La Victoria","Lima (Cercado)","Lince","Los Olivos","Lurigancho","Lurin","Magdalena del Mar","Miraflores","Pachacamac","Pucusana","Pueblo Libre","Puente Piedra","Punta Hermosa","Punta Negra","Rimac","San Bartolo","San Borja","San Isidro","San Juan de Lurigancho","San Juan de Miraflores","San Luis","San Martin de Porres","San Miguel","Santa Anita","Santa Maria del Mar","Santa Rosa","Santiago de Surco","Surquillo","Villa el Salvador","Villa Maria del Triunfo","Bellavista","Callao","Carmen de la Legua","La Perla","La Punta","Ventanilla","Mi Peru","Barranca","Huacho","Chancay","Huaral","Canta","Santa Rosa de Quives","San Antonio","Matucana","Santa Eulalia","Surco","Antioquia","Chilca","Mala","Asia","Imperial","Panamericana Norte","Carretera a Canta","Carretera Central","Panamericana Sur"};
        ArrayAdapter<String> adapterDistritoDestinoViaje = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDistritoDestinoViaje);
        spnDistritoDestinoViaje.setAdapter(adapterDistritoDestinoViaje);








        // A MAS TARDAR EN ESTE PUNTO, TODOS LOS CONTROLES (TextView) YA DEBEN TENER LOS VALORES INICIALES APROPIADOS (O BIEN VACIOS O BIEN EXTRAIDOS DE UN REGISTRO INCOMPLETO SELECCIONADO EN LA PANT. ANTERIOR)





         //PEGAR ESTE BLOQUE EN LA LINEA 407: ?????

        recTramoViaje.setItemViewCacheSize(20);
        recTramoViaje.setLayoutManager(new LinearLayoutManager(this));
        adapterViaje=new AdaptadorListaViaje(this,listaViajes);
        recTramoViaje.setAdapter(adapterViaje);




        //ESTE ES EL LUGAR INDICADO, NO INTERFIERE CON NADA?



        if(LoginActivity.modificarViaje==true){





            System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");

            final Detalle_de_Viajes_Anexo_1 mod=PantallaEncuesta1_Persona.listaViajes.get(LoginActivity.indiceModificarViaje);


            spnDistritoOrigenViaje.setSelection(eSpinner(spnDistritoOrigenViaje,mod.getOriDis_Q17_dvia()));

            txtDireccionOrigenViaje.setText(mod.getOriDir_Q17_dvia());

            txtReferenciaOrigenViaje.setText(mod.getOriRef_Q17_dvia());

            spnZonaTransitoOrigen.setSelection(eSpinner(spnZonaTransitoOrigen,mod.getOriZtra_Q17_dvia()));

            spnLugarOrigen.setSelection(mod.getOriLug_Q18_dvia());

            spnHoraSalidaViaje.setSelection(eSpinner(spnHoraSalidaViaje,""+mod.getOriHor_Q19_dvia()));

            spnMinutoSalidaViaje.setSelection(eSpinner(spnMinutoSalidaViaje,""+mod.getOriMin_Q19_dvia()));

            spnAmopmOrigen.setSelection(mod.getOriAmPm_Q19_dvia());

            spnDistritoDestinoViaje.setSelection(eSpinner(spnDistritoDestinoViaje,mod.getDesDis_Q20_dvia()));

            txtDireccionDestinoViaje.setText(mod.getDesDir_Q20_dvia());

            txtReferenciaDestinoViaje.setText(mod.getDesRef_Q20_dvia());

            spnZonaTransitoDestino.setSelection(eSpinner(spnZonaTransitoDestino,mod.getDesZtra_Q20_dvia()));

            spnLugarDestino.setSelection(mod.getDesLug_Q21_dvia());

            spnHoraLlegadaViaje.setSelection(eSpinner(spnHoraLlegadaViaje,""+mod.getDesHor_Q22_dvia()));

            spnMinutoLlegadaViaje.setSelection(eSpinner(spnMinutoLlegadaViaje,""+mod.getDesMin_Q22_dvia()));

            spnAmopmDestino.setSelection(mod.getDesAmPm_Q22_dvia());

            spnPropositoViaje.setSelection(mod.getPro_Q23_dvia());






            listaViajes.add(new Object());
            adapterViaje.notifyItemInserted(0);

            if(mod.getTraMed2_Q24a_dvia()!=0){
                listaViajes.add(new Object());
                adapterViaje.notifyItemInserted(1);
            }

            if(mod.getTraMed3_Q24a_dvia()!=0){
                listaViajes.add(new Object());
                adapterViaje.notifyItemInserted(2);
            }

            if(mod.getTraMed4_Q24a_dvia()!=0){
                listaViajes.add(new Object());
                adapterViaje.notifyItemInserted(3);
            }

            if(mod.getTraMed5_Q24a_dvia()!=0){
                listaViajes.add(new Object());
                adapterViaje.notifyItemInserted(4);
            }

            if(mod.getTraMed6_Q24a_dvia()!=0){
                listaViajes.add(new Object());
                adapterViaje.notifyItemInserted(5);
            }

            if(mod.getTraMed7_Q24a_dvia()!=0){
                listaViajes.add(new Object());
                adapterViaje.notifyItemInserted(6);
            }






            AlertDialog alertDialog = new AlertDialog.Builder(PantallaEncuesta1_Viaje.this).create();
            alertDialog.setTitle("Atención");


            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {

                    Spinner spnAlt=recTramoViaje.findViewHolderForAdapterPosition(0).itemView.findViewById(R.id.spnMedioViaje);
                    spnAlt.setSelection(mod.getTraMed1_Q24a_dvia()-1);

                    spnAlt=recTramoViaje.findViewHolderForAdapterPosition(0).itemView.findViewById(R.id.spnTiempoViaje);
                    spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTraTpo1_Q24b_dvia()));

                    spnAlt=recTramoViaje.findViewHolderForAdapterPosition(0).itemView.findViewById(R.id.spnCostoViaje);
                  //  spnAlt.setSelection(mod.getTraCos1_Q24c_dvia());
                    spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTraCos1_Q24c_dvia()));


                    spnAlt=recTramoViaje.findViewHolderForAdapterPosition(0).itemView.findViewById(R.id.spnTransbordo);
                    spnAlt.setSelection(eSpinner(spnAlt,mod.getTransb12_Q24d_dvia()));

                    spnAlt=recTramoViaje.findViewHolderForAdapterPosition(0).itemView.findViewById(R.id.spnNumeroTransbordo);
                    spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTransb12_Q24e_dvia()));


                    if(mod.getTraMed2_Q24a_dvia()!=0){

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(1).itemView.findViewById(R.id.spnMedioViaje);
                        spnAlt.setSelection(mod.getTraMed2_Q24a_dvia()-1);

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(1).itemView.findViewById(R.id.spnTiempoViaje);
                        spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTraTpo2_Q24b_dvia()));

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(1).itemView.findViewById(R.id.spnCostoViaje);
                      //  spnAlt.setSelection(mod.getTraCos2_Q24c_dvia());
                        spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTraCos2_Q24c_dvia()));


                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(1).itemView.findViewById(R.id.spnTransbordo);
                        spnAlt.setSelection(eSpinner(spnAlt,mod.getTransb23_Q24d_dvia()));

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(1).itemView.findViewById(R.id.spnNumeroTransbordo);
                        spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTransb23_Q24e_dvia()));


                    }


                    if(mod.getTraMed3_Q24a_dvia()!=0){

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(2).itemView.findViewById(R.id.spnMedioViaje);
                        spnAlt.setSelection(mod.getTraMed3_Q24a_dvia()-1);

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(2).itemView.findViewById(R.id.spnTiempoViaje);
                        spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTraTpo3_Q24b_dvia()));

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(2).itemView.findViewById(R.id.spnCostoViaje);
                      //  spnAlt.setSelection(mod.getTraCos3_Q24c_dvia());
                        spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTraCos3_Q24c_dvia()));


                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(2).itemView.findViewById(R.id.spnTransbordo);
                        spnAlt.setSelection(eSpinner(spnAlt,mod.getTransb34_Q24d_dvia()));

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(2).itemView.findViewById(R.id.spnNumeroTransbordo);
                        spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTransb34_Q24e_dvia()));

                    }

                    if(mod.getTraMed4_Q24a_dvia()!=0){

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(3).itemView.findViewById(R.id.spnMedioViaje);
                        spnAlt.setSelection(mod.getTraMed4_Q24a_dvia()-1);

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(3).itemView.findViewById(R.id.spnTiempoViaje);
                        spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTraTpo4_Q24b_dvia()));

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(3).itemView.findViewById(R.id.spnCostoViaje);
                      //  spnAlt.setSelection(mod.getTraCos4_Q24c_dvia());
                        spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTraCos4_Q24c_dvia()));


                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(3).itemView.findViewById(R.id.spnTransbordo);
                        spnAlt.setSelection(eSpinner(spnAlt,mod.getTransb45_Q24d_dvia()));

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(3).itemView.findViewById(R.id.spnNumeroTransbordo);
                        spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTransb45_Q24e_dvia()));


                    }


                    if(mod.getTraMed5_Q24a_dvia()!=0){

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(4).itemView.findViewById(R.id.spnMedioViaje);
                        spnAlt.setSelection(mod.getTraMed5_Q24a_dvia()-1);

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(4).itemView.findViewById(R.id.spnTiempoViaje);
                        spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTraTpo5_Q24b_dvia()));

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(4).itemView.findViewById(R.id.spnCostoViaje);
                      //  spnAlt.setSelection(mod.getTraCos5_Q24c_dvia());
                        spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTraCos5_Q24c_dvia()));


                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(4).itemView.findViewById(R.id.spnTransbordo);
                        spnAlt.setSelection(eSpinner(spnAlt,mod.getTransb56_Q24d_dvia()));

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(4).itemView.findViewById(R.id.spnNumeroTransbordo);
                        spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTransb56_Q24e_dvia()));

                    }


                    if(mod.getTraMed6_Q24a_dvia()!=0){

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(5).itemView.findViewById(R.id.spnMedioViaje);
                        spnAlt.setSelection(mod.getTraMed6_Q24a_dvia()-1);

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(5).itemView.findViewById(R.id.spnTiempoViaje);
                        spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTraTpo6_Q24b_dvia()));

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(5).itemView.findViewById(R.id.spnCostoViaje);
                     //   spnAlt.setSelection(mod.getTraCos6_Q24c_dvia());
                        spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTraCos6_Q24c_dvia()));


                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(5).itemView.findViewById(R.id.spnTransbordo);
                        spnAlt.setSelection(eSpinner(spnAlt,mod.getTransb67_Q24d_dvia()));

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(5).itemView.findViewById(R.id.spnNumeroTransbordo);
                        spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTransb67_Q24e_dvia()));

                    }


                    if(mod.getTraMed7_Q24a_dvia()!=0){

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(6).itemView.findViewById(R.id.spnMedioViaje);
                        spnAlt.setSelection(mod.getTraMed7_Q24a_dvia()-1);

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(6).itemView.findViewById(R.id.spnTiempoViaje);
                        spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTraTpo7_Q24b_dvia()));

                        spnAlt=recTramoViaje.findViewHolderForAdapterPosition(6).itemView.findViewById(R.id.spnCostoViaje);
                      //  spnAlt.setSelection(mod.getTraCos7_Q24c_dvia());
                        spnAlt.setSelection(eSpinner(spnAlt,""+mod.getTraCos7_Q24c_dvia()));


                    }



                }
            });


            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.dismiss();

                        }
                    });


            alertDialog.setMessage("Revise sus datos y presione 'Añadir Viaje' cuando este listo para actualizar su registro.");
            alertDialog.show();



            //Spinner spnAlt=recTramoViaje.findViewHolderForAdapterPosition(0).itemView.findViewById(R.id.spnMedioViaje);
            //spnAlt.setSelection(mod.getTraMed1_Q24a_dvia());









            spnManejoCarro.setSelection(mod.getMcar_Q25_dvia());

            spnLugarEstacionamiento.setSelection(mod.getEsta_Q26a_dvia());

            spnPagoEstacionamiento.setSelection(mod.getPago_Q26b_dvia());

            spnTarifaEstacionamiento.setSelection(eSpinner(spnTarifaEstacionamiento,""+mod.getTar_Q26c_dvia()));

            spnRazonMedioTransporte.setSelection(mod.getTraRazem1_Q29_dvia());

            spnPorqueNoTransportePublico.setSelection(mod.getTranutp1_Q30_dvia());

            spnDistanciaParadero1.setSelection(eSpinner(spnDistanciaParadero1,""+mod.getNdsBusDis_Q30_dvia()));

            spnTiempoViaje1.setSelection(eSpinner(spnTiempoViaje1,""+mod.getNdsBusTpo_Q30_dvia()));

            spnTarifa1.setSelection(eSpinner(spnTarifa1,""+mod.getNdsBusTar_Q30_dvia()));

            spnNumeroTransbordos1.setSelection(eSpinner(spnNumeroTransbordos1,""+mod.getNdsBustrb_Q30_dvia()));

            spnDistanciaParadero2.setSelection(eSpinner(spnDistanciaParadero2,""+mod.getNdsTaxiDis_Q30_dvia()));

            spnTiempoViaje2.setSelection(eSpinner(spnTiempoViaje2,""+mod.getNdsTaxiTpo_Q30_dvia()));

            spnTarifa2.setSelection(eSpinner(spnTarifa2,""+mod.getNdsTaxiTar_Q30_dvia()));

            spnTiempoViaje3.setSelection(eSpinner(spnTiempoViaje3,""+mod.getNdsCarroTpo_Q30_dvia()));

            spnCostoViaje3.setSelection(eSpinner(spnCostoViaje3,""+mod.getNdsCarroCos_Q30_dvia()));

            spnPeaje3.setSelection(eSpinner(spnPeaje3,""+mod.getNdsCarroPea_Q30_dvia()));

            spnEstacionamiento3.setSelection(eSpinner(spnEstacionamiento3,mod.getNdsCarroEsta_Q30_dvia()+""));

            coordOrigen=mod.getCoordenadas_Origen();  //cambio 3

            coordDestino=mod.getCoordenadas_Destino();  //cambio 4

            spnDiaViaje.setSelection(eSpinner(spnDiaViaje,""+mod.getDia_Viaje()));

            spnMesViaje.setSelection(eSpinner(spnMesViaje,""+mod.getMes_Viaje()));

            spnPeajesViaje.setSelection(eSpinner(spnPeajesViaje,mod.getPeaViaQ26d_dvia()+""));

            spnFrecuenciaViaje.setSelection(mod.getFreViaQ26e_dvia());


            if(mod.isVialarQ27_dvia()){
                spnViajeMasLargo.setSelection(1);
            }
            else{
                spnViajeMasLargo.setSelection(0);
            }

            spnMedioTrans.setSelection(mod.getMedQ28_dvia());

            spnPorqueNoUtiliza.setSelection(mod.getPqnutpQ30_dvia());

            if(mod.isConsenQ31_dvia()){
                spnConsentimiento.setSelection(1);
            }
            else{
                spnConsentimiento.setSelection(0);
            }

            txtNumeroCelular.setText(""+mod.getNumCelQ32_dvia());

            txtOtraFrecuencia.setText(mod.getOtraFrecuenciaViaje());




            PantallaEncuesta1_Persona.listaViajes.remove(LoginActivity.indiceModificarViaje);

            PantallaEncuesta1_Persona.adapter.notifyItemRemoved(LoginActivity.indiceModificarViaje);

            LoginActivity.modificarViaje=false;

            LoginActivity.indiceModificarViaje=-100;



        }





        if(coordOrigen==null){
            lblCoordenadasOrigen.setText("No hay coordenadas guardadas");
        }
        else{
            lblCoordenadasOrigen.setText("Coordenadas: "+coordOrigen);
        }


        if(coordDestino==null){
            lblCoordenadasDestino.setText("No hay coordenadas guardadas");
        }
        else{
            lblCoordenadasDestino.setText("Coordenadas: "+coordDestino);
        }






        validarCampo(txtDireccionOrigenViaje,"valDireccionOrigenViaje","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñÜü'?¿!¡]{2,63}$");

        validarCampo(txtReferenciaOrigenViaje,"valReferenciaOrigenViaje","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñÜü'?¿!¡]{0,63}$");

        validarCampo(txtDireccionDestinoViaje,"valDireccionDestinoViaje","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñÜü'?¿!¡]{2,63}$");

        validarCampo(txtReferenciaDestinoViaje,"valReferenciaDestinoViaje","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñÜü'?¿!¡]{0,63}$");

        validarCampo(txtNumeroCelular, "valNumeroCelular","^(|0|[0-9]{7,12})$");

        validarCampo(txtOtraFrecuencia, "valOtraFrecuencia","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñÜü'?¿!¡]{0,63}$");




        // "^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñ]{0,63}$"











        txtDireccionOrigenViaje.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtDireccionOrigenViaje,"valDireccionOrigenViaje","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñÜü'?¿!¡]{2,63}$");
                //System.out.println(listaViajes.size());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        txtReferenciaOrigenViaje.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtReferenciaOrigenViaje,"valReferenciaOrigenViaje","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñÜü'?¿!¡]{0,63}$");

            //    System.out.println(PantallaEncuesta1_Persona.coordTrabajo+"            "+PantallaEncuesta1_Persona.coordEstudio+"         "+coordOrigen+"           "+coordDestino);



            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        txtDireccionDestinoViaje.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtDireccionDestinoViaje,"valDireccionDestinoViaje","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñÜü'?¿!¡]{2,63}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        txtReferenciaDestinoViaje.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtReferenciaDestinoViaje,"valReferenciaDestinoViaje","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñÜü'?¿!¡]{0,63}$");

                //Spinner sp=recTramoViaje.findViewHolderForAdapterPosition(0).itemView.findViewById(R.id.spnMedioViaje);
                //Spinner sp2=recTramoViaje.findViewHolderForAdapterPosition(1).itemView.findViewById(R.id.spnCostoViaje);
                //System.out.println("zxcvb "+vals3.get("valDireccionOrigenViaje")+vals3.get("valReferenciaOrigenViaje")+vals3.get("valDireccionDestinoViaje")+vals3.get("valReferenciaDestinoViaje"));
                //System.out.println("pos "+spnLugarOrigen.getSelectedItemPosition()+"     "+sp.getSelectedItemPosition()+sp2.getSelectedItem());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        txtNumeroCelular.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtNumeroCelular, "valNumeroCelular","^(|0|[0-9]{7,12})$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        txtOtraFrecuencia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtOtraFrecuencia, "valOtraFrecuencia","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñÜü'?¿!¡]{0,63}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });








        btnCrearTramoViaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                listaViajes.add(new Object());
                adapterViaje.notifyItemInserted(listaViajes.size()-1);

            }
        });




        btnCoordenadasOrigen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginActivity.switchMapas=3;

                autoCompletado=txtDireccionOrigenViaje.getText().toString();

                Intent i = new Intent(getApplicationContext(), MapsActivity.class);

                startActivity(i);





            }
        });



        btnCoordenadasDestino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginActivity.switchMapas=4;

                autoCompletado=txtDireccionDestinoViaje.getText().toString();

                Intent i = new Intent(getApplicationContext(), MapsActivity.class);

                startActivity(i);





            }
        });






        btnCopiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(PantallaEncuesta1_Persona.listaViajes.size()>0) {

                    txtDireccionOrigenViaje.setText(PantallaEncuesta1_Persona.listaViajes.get(PantallaEncuesta1_Persona.listaViajes.size() - 1).getDesDir_Q20_dvia());

                    txtReferenciaOrigenViaje.setText(PantallaEncuesta1_Persona.listaViajes.get(PantallaEncuesta1_Persona.listaViajes.size() - 1).getDesRef_Q20_dvia());

                    spnDistritoOrigenViaje.setSelection(eSpinner(spnDistritoOrigenViaje,PantallaEncuesta1_Persona.listaViajes.get(PantallaEncuesta1_Persona.listaViajes.size() -1).getDesDis_Q20_dvia()));

                    spnLugarOrigen.setSelection(PantallaEncuesta1_Persona.listaViajes.get(PantallaEncuesta1_Persona.listaViajes.size() - 1).getDesLug_Q21_dvia());


                }

            }
        });








        btnGuardarViaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //PREGUNTAR POR OTROS CAMPOS O COSAS QUE INCLUIR EN LA VALIDACION

                AlertDialog alertDialog = new AlertDialog.Builder(PantallaEncuesta1_Viaje.this).create();
                alertDialog.setTitle("No se puede añadir el Registro");

                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });


                if(listaViajes.size()<1){

                    alertDialog.setMessage("No hay ningun Tramo creado. Todo viaje debe contar con al menos 1 tramo.");
                    alertDialog.show();

                }


                else if( (spnConsentimiento.getSelectedItemPosition()==0 && txtNumeroCelular.getText().toString().length()>1) || (spnConsentimiento.getSelectedItemPosition()==1 && txtNumeroCelular.getText().toString().length()<6 ) ){

                    alertDialog.setMessage("Si el encuestado dio su consentimiento debe ingresar su numero de celular en el campo correspondiente. Si no lo dio, no debe ingresar numero alguno.");
                    alertDialog.show();

                }



                else if(coordOrigen==null || coordDestino==null){

                    alertDialog.setMessage("No ha grabado las coordenadas de origen y/o destino. Intentelo nuevamente.");
                    alertDialog.show();

                }

                else if((spnFrecuenciaViaje.getSelectedItemPosition()==8 && txtOtraFrecuencia.getText().toString().length()<2) ){

                    alertDialog.setMessage("Ha seleccionado la opción 'Otro' en el campo 'Frecuencia de Viaje', especifique de que frecuencia se trata en el campo de texto debajo del mismo.");
                    alertDialog.show();

                }



                else if( (spnDiaViaje.getSelectedItemPosition()==31 && spnMesViaje.getSelectedItemPosition()==2) || (spnDiaViaje.getSelectedItemPosition()==31 && spnMesViaje.getSelectedItemPosition()==4) || (spnDiaViaje.getSelectedItemPosition()==23 && spnMesViaje.getSelectedItemPosition()==1) || (spnDiaViaje.getSelectedItemPosition()==24 && spnMesViaje.getSelectedItemPosition()==1) || (spnDiaViaje.getSelectedItemPosition()==30 && spnMesViaje.getSelectedItemPosition()==1) || (spnDiaViaje.getSelectedItemPosition()==31 && spnMesViaje.getSelectedItemPosition()==1) || (spnDiaViaje.getSelectedItemPosition()==6 && spnMesViaje.getSelectedItemPosition()==2) || (spnDiaViaje.getSelectedItemPosition()==7 && spnMesViaje.getSelectedItemPosition()==2) || (spnDiaViaje.getSelectedItemPosition()==13 && spnMesViaje.getSelectedItemPosition()==2) || (spnDiaViaje.getSelectedItemPosition()==14 && spnMesViaje.getSelectedItemPosition()==2) || (spnDiaViaje.getSelectedItemPosition()==20 && spnMesViaje.getSelectedItemPosition()==2) || (spnDiaViaje.getSelectedItemPosition()==21 && spnMesViaje.getSelectedItemPosition()==2) || (spnDiaViaje.getSelectedItemPosition()==27 && spnMesViaje.getSelectedItemPosition()==2) || (spnDiaViaje.getSelectedItemPosition()==28 && spnMesViaje.getSelectedItemPosition()==2) || (spnDiaViaje.getSelectedItemPosition()==4 && spnMesViaje.getSelectedItemPosition()==3) || (spnDiaViaje.getSelectedItemPosition()==5 && spnMesViaje.getSelectedItemPosition()==3) || (spnDiaViaje.getSelectedItemPosition()==11 && spnMesViaje.getSelectedItemPosition()==3) || (spnDiaViaje.getSelectedItemPosition()==12 && spnMesViaje.getSelectedItemPosition()==3) || (spnDiaViaje.getSelectedItemPosition()==18 && spnMesViaje.getSelectedItemPosition()==3) || (spnDiaViaje.getSelectedItemPosition()==19 && spnMesViaje.getSelectedItemPosition()==3) || (spnDiaViaje.getSelectedItemPosition()==25 && spnMesViaje.getSelectedItemPosition()==3) || (spnDiaViaje.getSelectedItemPosition()==26 && spnMesViaje.getSelectedItemPosition()==3) || (spnDiaViaje.getSelectedItemPosition()==1 && spnMesViaje.getSelectedItemPosition()==4) || (spnDiaViaje.getSelectedItemPosition()==2 && spnMesViaje.getSelectedItemPosition()==4) || (spnDiaViaje.getSelectedItemPosition()==8 && spnMesViaje.getSelectedItemPosition()==4) || (spnDiaViaje.getSelectedItemPosition()==9 && spnMesViaje.getSelectedItemPosition()==4) || (spnDiaViaje.getSelectedItemPosition()==15 && spnMesViaje.getSelectedItemPosition()==4) || (spnDiaViaje.getSelectedItemPosition()==16 && spnMesViaje.getSelectedItemPosition()==4) || (spnDiaViaje.getSelectedItemPosition()==22 && spnMesViaje.getSelectedItemPosition()==4) || (spnDiaViaje.getSelectedItemPosition()==23 && spnMesViaje.getSelectedItemPosition()==4) || (spnDiaViaje.getSelectedItemPosition()==29 && spnMesViaje.getSelectedItemPosition()==4) || (spnDiaViaje.getSelectedItemPosition()==30 && spnMesViaje.getSelectedItemPosition()==4) || (spnDiaViaje.getSelectedItemPosition()==6 && spnMesViaje.getSelectedItemPosition()==5) || (spnDiaViaje.getSelectedItemPosition()==7 && spnMesViaje.getSelectedItemPosition()==5) || (spnDiaViaje.getSelectedItemPosition()==13 && spnMesViaje.getSelectedItemPosition()==5) || (spnDiaViaje.getSelectedItemPosition()==14 && spnMesViaje.getSelectedItemPosition()==5) || (spnDiaViaje.getSelectedItemPosition()==20 && spnMesViaje.getSelectedItemPosition()==5) || (spnDiaViaje.getSelectedItemPosition()==21 && spnMesViaje.getSelectedItemPosition()==5) || (spnDiaViaje.getSelectedItemPosition()==27 && spnMesViaje.getSelectedItemPosition()==5) || (spnDiaViaje.getSelectedItemPosition()==28 && spnMesViaje.getSelectedItemPosition()==5) || (spnDiaViaje.getSelectedItemPosition()==3 && spnMesViaje.getSelectedItemPosition()==6) || (spnDiaViaje.getSelectedItemPosition()==4 && spnMesViaje.getSelectedItemPosition()==6) || (spnDiaViaje.getSelectedItemPosition()==10 && spnMesViaje.getSelectedItemPosition()==6) || (spnDiaViaje.getSelectedItemPosition()==11 && spnMesViaje.getSelectedItemPosition()==6) || (spnDiaViaje.getSelectedItemPosition()==17 && spnMesViaje.getSelectedItemPosition()==6) || (spnDiaViaje.getSelectedItemPosition()==18 && spnMesViaje.getSelectedItemPosition()==6) || (spnDiaViaje.getSelectedItemPosition()==24 && spnMesViaje.getSelectedItemPosition()==6) || (spnDiaViaje.getSelectedItemPosition()==25 && spnMesViaje.getSelectedItemPosition()==6) || (spnDiaViaje.getSelectedItemPosition()==31 && spnMesViaje.getSelectedItemPosition()==6) ){

                    alertDialog.setMessage("El día de viaje que ha ingresado corresponde a un Sábado, Domingo u otro día no válido. Intentelo nuevamente.");
                    alertDialog.show();

                }



                else if(spnDistritoOrigenViaje.getSelectedItemPosition()==0 || spnLugarOrigen.getSelectedItemPosition()==0 || spnDistritoDestinoViaje.getSelectedItemPosition()==0 || spnLugarDestino.getSelectedItemPosition()==0 || spnPropositoViaje.getSelectedItemPosition()==0 || spnFrecuenciaViaje.getSelectedItemPosition()==0 || spnHoraSalidaViaje.getSelectedItemPosition()==0 || spnMinutoSalidaViaje.getSelectedItemPosition()==0 || spnHoraLlegadaViaje.getSelectedItemPosition()==0 || spnMinutoLlegadaViaje.getSelectedItemPosition()==0 || spnMesViaje.getSelectedItemPosition()==0 || spnDiaViaje.getSelectedItemPosition()==0 ){

                    alertDialog.setMessage("Ha pasado por alto algún campo, debe elegir una opción en cada uno de ellos y no dejar la opción por defecto 'Seleccionar' o '--'.");
                    alertDialog.show();

                }


                else if(vals3.get("valDireccionOrigenViaje")!=true || vals3.get("valReferenciaOrigenViaje")!=true || vals3.get("valDireccionDestinoViaje")!=true ||vals3.get("valReferenciaDestinoViaje")!=true  || vals3.get("valNumeroCelular")!=true || vals3.get("valOtraFrecuencia")!=true){

                    alertDialog.setMessage("Ha ingresado caracteres no permitidos o ha dejado vacio algun campo obligatorio. Intentelo nuevamente.");
                    alertDialog.show();

                }

                else{

                    Detalle_de_Viajes_Anexo_1 viaje= new Detalle_de_Viajes_Anexo_1();


                    viaje.setOriDis_Q17_dvia(spnDistritoOrigenViaje.getSelectedItem().toString());

                    viaje.setOriDir_Q17_dvia(txtDireccionOrigenViaje.getText().toString());

                    viaje.setOriRef_Q17_dvia(txtReferenciaOrigenViaje.getText().toString());

                    viaje.setOriZtra_Q17_dvia(spnZonaTransitoOrigen.getSelectedItem().toString());

                    viaje.setOriLug_Q18_dvia(spnLugarOrigen.getSelectedItemPosition());

                    viaje.setOriHor_Q19_dvia(Integer.parseInt(spnHoraSalidaViaje.getSelectedItem().toString()));

                    viaje.setOriMin_Q19_dvia(Integer.parseInt(spnMinutoSalidaViaje.getSelectedItem().toString()));

                    viaje.setOriAmPm_Q19_dvia(spnAmopmOrigen.getSelectedItemPosition());

                    viaje.setDesDis_Q20_dvia(spnDistritoDestinoViaje.getSelectedItem().toString());

                    viaje.setDesDir_Q20_dvia(txtDireccionDestinoViaje.getText().toString());

                    viaje.setDesRef_Q20_dvia(txtReferenciaDestinoViaje.getText().toString());

                    viaje.setDesZtra_Q20_dvia(spnZonaTransitoDestino.getSelectedItem().toString());

                    viaje.setDesLug_Q21_dvia(spnLugarDestino.getSelectedItemPosition());

                    viaje.setDesHor_Q22_dvia(Integer.parseInt(spnHoraLlegadaViaje.getSelectedItem().toString()));

                    viaje.setDesMin_Q22_dvia(Integer.parseInt(spnMinutoLlegadaViaje.getSelectedItem().toString()));

                    viaje.setDesAmPm_Q22_dvia(spnAmopmDestino.getSelectedItemPosition());

                    viaje.setPro_Q23_dvia(spnPropositoViaje.getSelectedItemPosition());

                    Spinner spnAux=recTramoViaje.findViewHolderForAdapterPosition(0).itemView.findViewById(R.id.spnMedioViaje);
                    viaje.setTraMed1_Q24a_dvia(spnAux.getSelectedItemPosition()+1);

                    spnAux=recTramoViaje.findViewHolderForAdapterPosition(0).itemView.findViewById(R.id.spnTiempoViaje);
                    viaje.setTraTpo1_Q24b_dvia(Integer.parseInt(spnAux.getSelectedItem().toString()));

                    spnAux=recTramoViaje.findViewHolderForAdapterPosition(0).itemView.findViewById(R.id.spnCostoViaje);
                  //  viaje.setTraCos1_Q24c_dvia(spnAux.getSelectedItemPosition());
                    viaje.setTraCos1_Q24c_dvia(Double.parseDouble(spnAux.getSelectedItem().toString()));


                    spnAux=recTramoViaje.findViewHolderForAdapterPosition(0).itemView.findViewById(R.id.spnTransbordo);
                    viaje.setTransb12_Q24d_dvia(spnAux.getSelectedItem().toString());

                    spnAux=recTramoViaje.findViewHolderForAdapterPosition(0).itemView.findViewById(R.id.spnNumeroTransbordo);
                    viaje.setTransb12_Q24e_dvia(Integer.parseInt(spnAux.getSelectedItem().toString()));

                    if(listaViajes.size()>=2){

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(1).itemView.findViewById(R.id.spnMedioViaje);
                        viaje.setTraMed2_Q24a_dvia(spnAux.getSelectedItemPosition()+1);

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(1).itemView.findViewById(R.id.spnTiempoViaje);
                        viaje.setTraTpo2_Q24b_dvia(Integer.parseInt(spnAux.getSelectedItem().toString()));

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(1).itemView.findViewById(R.id.spnCostoViaje);
                       // viaje.setTraCos2_Q24c_dvia(spnAux.getSelectedItemPosition());
                        viaje.setTraCos2_Q24c_dvia(Double.parseDouble(spnAux.getSelectedItem().toString()));


                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(1).itemView.findViewById(R.id.spnTransbordo);
                        viaje.setTransb23_Q24d_dvia(spnAux.getSelectedItem().toString());

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(1).itemView.findViewById(R.id.spnNumeroTransbordo);
                        viaje.setTransb23_Q24e_dvia(Integer.parseInt(spnAux.getSelectedItem().toString()));

                    }

                    if(listaViajes.size()>=3){

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(2).itemView.findViewById(R.id.spnMedioViaje);
                        viaje.setTraMed3_Q24a_dvia(spnAux.getSelectedItemPosition()+1);

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(2).itemView.findViewById(R.id.spnTiempoViaje);
                        viaje.setTraTpo3_Q24b_dvia(Integer.parseInt(spnAux.getSelectedItem().toString()));

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(2).itemView.findViewById(R.id.spnCostoViaje);
                       // viaje.setTraCos3_Q24c_dvia(spnAux.getSelectedItemPosition());
                        viaje.setTraCos3_Q24c_dvia(Double.parseDouble(spnAux.getSelectedItem().toString()));


                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(2).itemView.findViewById(R.id.spnTransbordo);
                        viaje.setTransb34_Q24d_dvia(spnAux.getSelectedItem().toString());

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(2).itemView.findViewById(R.id.spnNumeroTransbordo);
                        viaje.setTransb34_Q24e_dvia(Integer.parseInt(spnAux.getSelectedItem().toString()));

                    }

                    if(listaViajes.size()>=4){

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(3).itemView.findViewById(R.id.spnMedioViaje);
                        viaje.setTraMed4_Q24a_dvia(spnAux.getSelectedItemPosition()+1);

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(3).itemView.findViewById(R.id.spnTiempoViaje);
                        viaje.setTraTpo4_Q24b_dvia(Integer.parseInt(spnAux.getSelectedItem().toString()));

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(3).itemView.findViewById(R.id.spnCostoViaje);
                        //viaje.setTraCos4_Q24c_dvia(spnAux.getSelectedItemPosition());
                        viaje.setTraCos4_Q24c_dvia(Double.parseDouble(spnAux.getSelectedItem().toString()));


                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(3).itemView.findViewById(R.id.spnTransbordo);
                        viaje.setTransb45_Q24d_dvia(spnAux.getSelectedItem().toString());

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(3).itemView.findViewById(R.id.spnNumeroTransbordo);
                        viaje.setTransb45_Q24e_dvia(Integer.parseInt(spnAux.getSelectedItem().toString()));

                    }

                    if(listaViajes.size()>=5){

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(4).itemView.findViewById(R.id.spnMedioViaje);
                        viaje.setTraMed5_Q24a_dvia(spnAux.getSelectedItemPosition()+1);

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(4).itemView.findViewById(R.id.spnTiempoViaje);
                        viaje.setTraTpo5_Q24b_dvia(Integer.parseInt(spnAux.getSelectedItem().toString()));

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(4).itemView.findViewById(R.id.spnCostoViaje);
                       // viaje.setTraCos5_Q24c_dvia(spnAux.getSelectedItemPosition());
                        viaje.setTraCos5_Q24c_dvia(Double.parseDouble(spnAux.getSelectedItem().toString()));


                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(4).itemView.findViewById(R.id.spnTransbordo);
                        viaje.setTransb56_Q24d_dvia(spnAux.getSelectedItem().toString());

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(4).itemView.findViewById(R.id.spnNumeroTransbordo);
                        viaje.setTransb56_Q24e_dvia(Integer.parseInt(spnAux.getSelectedItem().toString()));

                    }

                    if(listaViajes.size()>=6){

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(5).itemView.findViewById(R.id.spnMedioViaje);
                        viaje.setTraMed6_Q24a_dvia(spnAux.getSelectedItemPosition()+1);

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(5).itemView.findViewById(R.id.spnTiempoViaje);
                        viaje.setTraTpo6_Q24b_dvia(Integer.parseInt(spnAux.getSelectedItem().toString()));

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(5).itemView.findViewById(R.id.spnCostoViaje);
                      //  viaje.setTraCos6_Q24c_dvia(spnAux.getSelectedItemPosition());
                        viaje.setTraCos6_Q24c_dvia(Double.parseDouble(spnAux.getSelectedItem().toString()));


                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(5).itemView.findViewById(R.id.spnTransbordo);
                        viaje.setTransb67_Q24d_dvia(spnAux.getSelectedItem().toString());

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(5).itemView.findViewById(R.id.spnNumeroTransbordo);
                        viaje.setTransb67_Q24e_dvia(Integer.parseInt(spnAux.getSelectedItem().toString()));

                    }

                    if(listaViajes.size()>=7){

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(6).itemView.findViewById(R.id.spnMedioViaje);
                        viaje.setTraMed7_Q24a_dvia(spnAux.getSelectedItemPosition()+1);

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(6).itemView.findViewById(R.id.spnTiempoViaje);
                        viaje.setTraTpo7_Q24b_dvia(Integer.parseInt(spnAux.getSelectedItem().toString()));

                        spnAux=recTramoViaje.findViewHolderForAdapterPosition(6).itemView.findViewById(R.id.spnCostoViaje);
                       // viaje.setTraCos7_Q24c_dvia(spnAux.getSelectedItemPosition());
                        viaje.setTraCos7_Q24c_dvia(Double.parseDouble(spnAux.getSelectedItem().toString()));


                    }

                    viaje.setMcar_Q25_dvia(spnManejoCarro.getSelectedItemPosition());

                    viaje.setEsta_Q26a_dvia(spnLugarEstacionamiento.getSelectedItemPosition());

                    viaje.setPago_Q26b_dvia(spnPagoEstacionamiento.getSelectedItemPosition());

                    viaje.setTar_Q26c_dvia(Double.parseDouble(spnTarifaEstacionamiento.getSelectedItem().toString()));    // SE CAMBIO EL PARSE DE INT A DOUBLE ACA

                    viaje.setTraRazem1_Q29_dvia(spnRazonMedioTransporte.getSelectedItemPosition());

                    viaje.setTranutp1_Q30_dvia(spnPorqueNoTransportePublico.getSelectedItemPosition());

                    viaje.setNdsBusDis_Q30_dvia(Integer.parseInt(spnDistanciaParadero1.getSelectedItem().toString()));

                    viaje.setNdsBusTpo_Q30_dvia(Integer.parseInt(spnTiempoViaje1.getSelectedItem().toString()));

                    viaje.setNdsBusTar_Q30_dvia(Double.parseDouble(spnTarifa1.getSelectedItem().toString()));

                    viaje.setNdsBustrb_Q30_dvia(Integer.parseInt(spnNumeroTransbordos1.getSelectedItem().toString()));

                    viaje.setNdsTaxiDis_Q30_dvia(Integer.parseInt(spnDistanciaParadero2.getSelectedItem().toString()));

                    viaje.setNdsTaxiTpo_Q30_dvia(Integer.parseInt(spnTiempoViaje2.getSelectedItem().toString()));

                    viaje.setNdsTaxiTar_Q30_dvia(Integer.parseInt(spnTarifa2.getSelectedItem().toString()));

                    viaje.setNdsCarroTpo_Q30_dvia(Integer.parseInt(spnTiempoViaje3.getSelectedItem().toString()));

                    viaje.setNdsCarroCos_Q30_dvia(Integer.parseInt(spnCostoViaje3.getSelectedItem().toString()));

                    viaje.setNdsCarroPea_Q30_dvia(Double.parseDouble(spnPeaje3.getSelectedItem().toString()));

                    viaje.setNdsCarroEsta_Q30_dvia(Double.parseDouble(spnEstacionamiento3.getSelectedItem().toString()));

                    viaje.setCoordenadas_Origen(coordOrigen);  //cambio1

                    viaje.setCoordenadas_Destino(coordDestino);  //cambio 2

                    viaje.setDia_Viaje(spnDiaViaje.getSelectedItem().toString());

                    viaje.setMes_Viaje(spnMesViaje.getSelectedItem().toString());

                    viaje.setPeaViaQ26d_dvia(Double.parseDouble(spnPeajesViaje.getSelectedItem().toString()));

                    viaje.setFreViaQ26e_dvia(spnFrecuenciaViaje.getSelectedItemPosition());

                    if(spnViajeMasLargo.getSelectedItemPosition()==1){
                    viaje.setVialarQ27_dvia(true);}
                    else{viaje.setVialarQ27_dvia(false);}

                    viaje.setMedQ28_dvia(spnMedioTrans.getSelectedItemPosition());

                    viaje.setPqnutpQ30_dvia(spnPorqueNoUtiliza.getSelectedItemPosition());

                    if(spnConsentimiento.getSelectedItemPosition()==1){
                        viaje.setConsenQ31_dvia(true);
                    }else{viaje.setConsenQ31_dvia(false);}

                    if(txtNumeroCelular.getText().toString().equals("")){
                        viaje.setNumCelQ32_dvia(0);
                    }else{
                    viaje.setNumCelQ32_dvia(Integer.parseInt(txtNumeroCelular.getText().toString()));}

                    viaje.setOtraFrecuenciaViaje(txtOtraFrecuencia.getText().toString());



                 //   Intent intent = new Intent(getBaseContext(), PantallaEncuesta1_Persona.class);
                    PantallaEncuesta1_Persona.listaViajes.add(viaje);
                    PantallaEncuesta1_Persona.adapter.notifyItemInserted(PantallaEncuesta1_Persona.listaViajes.size()-1);
                    finish(); //ver si esto funciona
                 //   startActivity(intent);


                }


            }
        });


    }


    @Override
    public void onBackPressed() {

        AlertDialog alertDialog = new AlertDialog.Builder(PantallaEncuesta1_Viaje.this).create();
        alertDialog.setTitle("Atención");

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "QUEDARME AQUI",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DESCARTAR DATOS",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

        alertDialog.setMessage("Si decide volver a la pantalla anterior se perderán todos los datos que ha ingresado en esta pantalla. Use el botón 'Añadir Viaje' para guardar sus datos correctamente.");
        alertDialog.show();

    }




    public int eSpinner(Spinner spinner, String myString){

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                return i;
            }
        }

        return 0;

    }





    public void validarCampo(TextView textView, String val, String regex){



        if(textView.getText().toString().matches(regex)){

            vals3.put(val,true);

            System.out.println("aaaaaaaaaaaaaaaaaaaaaa");

        }
        else{
            vals3.put(val,false);

            System.out.println("bbbbbbbbbbbbbbbbbb");
        }


    }

}
