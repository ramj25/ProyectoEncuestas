package com.example.asus.proyectoencuestas;

import android.content.DialogInterface;
import android.content.Intent;
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
import java.util.List;
import java.util.Map;

public class PantallaEncuesta1_Persona extends AppCompatActivity {


    static AdaptadorListaPersonas1 adapter;
    public static ArrayList<Detalle_de_Viajes_Anexo_1> listaViajes=new ArrayList<>();


    public static String coordTrabajo;
    public static String coordEstudio;


    //public boolean alMenosUnViaje; (?)

    public boolean valNombrePersona;
    public boolean valCorreoElectronicoPersona;
    public boolean valDireccionCentroTrabajo;
    public boolean valReferenciaCentroTrabajo;
    public boolean valDireccionCentroEstudios;
    public boolean valReferenciaCentroEstudios;




    static Map<String,Boolean> vals2=new HashMap<String,Boolean>();
    static {
        // vals.put("alMenosUnViaje", null);
        vals2.put("valNombrePersona", null);
        vals2.put("valCorreoElectronicoPersona", null);
        vals2.put("valDireccionCentroTrabajo", null);
        vals2.put("valReferenciaCentroTrabajo", null);
        vals2.put("valDireccionCentroEstudios", null);
        vals2.put("valReferenciaCentroEstudios", null);

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_encuesta1__persona);


        coordEstudio=null;
        coordTrabajo=null;


        final TextView txtNombrePersona=findViewById(R.id.txtNombrePersona);

        final Spinner spnParentesco=findViewById(R.id.spnParentesco);
        final Spinner spnSexoPersona=findViewById(R.id.spnSexoPersona);
        final Spinner spnEdadPersona=findViewById(R.id.spnEdadPersona);
        final Spinner spnDiscapacidad=findViewById(R.id.spnDiscapacidad);
        final Spinner spnAyudaViajar=findViewById(R.id.spnAyudaViajar);
        final Spinner spnOcupacion=findViewById(R.id.spnOcupacion);
        final Spinner spnActividad=findViewById(R.id.spnActividad);
        final Spinner spnLicenciaConducir=findViewById(R.id.spnLicenciaConducir);

        final TextView txtCorreoElectronicoPersona=findViewById(R.id.txtCorreoElectronicoPersona);

        final Spinner spnDistritoCentroTrabajo=findViewById(R.id.spnDistritoCentroTrabajo);
        final TextView txtDireccionCentroTrabajo=findViewById(R.id.txtDireccionCentroTrabajo);
        final TextView txtReferenciaCentroTrabajo=findViewById(R.id.txtReferenciaCentroTrabajo);

        final Spinner spnDistritoCentroEstudios=findViewById(R.id.spnDistritoCentroEstudios);
        final TextView txtDireccionCentroEstudios=findViewById(R.id.txtDireccionCentroEstudios);
        final TextView txtReferenciaCentroEstudios=findViewById(R.id.txtReferenciaCentroEstudios);

        final Spinner spnOperadorCelular=findViewById(R.id.spnOperadorCelular);

        final Spinner spnStatusViaje=findViewById(R.id.spnStatusViaje);

        Button btnCrearViaje=findViewById(R.id.btnCrearViaje);
        RecyclerView recViaje=findViewById(R.id.recViaje);

        Button btnGuardarPersona=findViewById(R.id.btnGuardarPersona);

        Button btnCoordenadasTrabajo=findViewById(R.id.btnCoordenadasTrabajo);
        Button btnCoordenadasEstudio=findViewById(R.id.btnCoordenadasEstudio);





        String[] listaParentesco={"Selec.","Jefe","Conyuge (Esposo, Conviviente, Compañero)","Hijo(a)","Yerno/Nuera","Nieto(a)","Padre/Suegro","Otro Pariente","Trabajador Doméstico","Otra Persona (No Pariente)"};
        ArrayAdapter<String> adapterParentesco = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaParentesco);
        spnParentesco.setAdapter(adapterParentesco);

        String[] listaSexoPersona={"--","Hombre","Mujer"};
        ArrayAdapter<String> adapterSexoPersona = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaSexoPersona);
        spnSexoPersona.setAdapter(adapterSexoPersona);

        String[] listaEdadPersona={"--","0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","101","102","103","104","105","106","107","108","109"};
        ArrayAdapter<String> adapterEdadPersona = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaEdadPersona);
        spnEdadPersona.setAdapter(adapterEdadPersona);

        String[] listaDiscapacidad={"--","Si","No"};
        ArrayAdapter<String> adapterDiscapacidad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDiscapacidad);
        spnDiscapacidad.setAdapter(adapterDiscapacidad);

        String[] listaAyudaViajar={"--","Si","No"};
        ArrayAdapter<String> adapterAyudaViajar = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAyudaViajar);
        spnAyudaViajar.setAdapter(adapterAyudaViajar);

        String[] listaOcupacion={"Seleccionar","Gerente, Jefe, Patrón","Profesional Independiente","Empleado de Oficina","Tecnico Independiente","Obrero","Vendedor","Trabajador Independiente no Especificado","Policia/FFAA","Chofer","Vigilante","Estudiante Primaria/Secundaria","Estudiante Superior","Estudiante Trabajador","Ama de Casa","Trabajador de Hogar","Desocupado / Jubilado","Otros"};
        ArrayAdapter<String> adapterOcupacion = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaOcupacion);
        spnOcupacion.setAdapter(adapterOcupacion);

        String[] listaActividad={"Seleccionar","Agricultura","Pesca","Mineria","Manufactura","Electricidad","Construccion","Comercio, Restaurante, Hotel","Transporte, Comunicaciones, Almacenaje","Finanzas, Seguros","Educacion","Trabajo Social/Salud","Servicio Publico","Servicio Privado","Servicio Domestico","Otros"};
        ArrayAdapter<String> adapterActividad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaActividad);
        spnActividad.setAdapter(adapterActividad);

        String[] listaLicenciaConducir={"--","Si","No"};
        ArrayAdapter<String> adapterLicenciaConducir = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaLicenciaConducir);
        spnLicenciaConducir.setAdapter(adapterLicenciaConducir);

        String[] listaOperadorCelular={"Seleccionar","Movistar","Claro","Entel","Bitel","Tuenti","No tiene"};
        ArrayAdapter<String> adapterOperadorCelular = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaOperadorCelular);
        spnOperadorCelular.setAdapter(adapterOperadorCelular);

        String[] listaStatusViaje={"Seleccionar","Viaja","No Viaja","No se pudo recabar datos","No quiso dar datos"};
        ArrayAdapter<String> adapterStatusViaje = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaStatusViaje);
        spnStatusViaje.setAdapter(adapterStatusViaje);


        //SPINNERS TEMPORALES (?):


        String[] listaDistritoCentroTrabajo={"Seleccionar","Cercado de Lima","Ancon","Ate","Barranco","Breña","Carabayllo","Comas","Chaclacayo","Chorrillos","El Agustino","Jesus Maria","La Molina","La Victoria","Lince","Lurigancho","Lurin","Magdalena del Mar","Miraflores","Pachacamac","Pucusana","Pueblo Libre","Puente Piedra","Punta Negra","Punta Hermosa","Rimac","San Bartolo","San Isidro","Independencia","San Juan de Miraflores","San Luis","San Martin de Porres","San Miguel","Santiago de Surco","Surquillo","Villa Maria del Triunfo","San Juan de Lurigancho","Santa Maria del Mar","Santa Rosa","Los Olivos","Cieneguilla","San Borja","Villa el Salvador","Santa Anita","Bellavista","Callao","Carmen de la Legua","La Perla","La Punta","Ventanilla","Mi Peru"};
        ArrayAdapter<String> adapterDistritoCentroTrabajo = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDistritoCentroTrabajo);
        spnDistritoCentroTrabajo.setAdapter(adapterDistritoCentroTrabajo);

        String[] listaDistritoCentroEstudios={"Seleccionar","Cercado de Lima","Ancon","Ate","Barranco","Breña","Carabayllo","Comas","Chaclacayo","Chorrillos","El Agustino","Jesus Maria","La Molina","La Victoria","Lince","Lurigancho","Lurin","Magdalena del Mar","Miraflores","Pachacamac","Pucusana","Pueblo Libre","Puente Piedra","Punta Negra","Punta Hermosa","Rimac","San Bartolo","San Isidro","Independencia","San Juan de Miraflores","San Luis","San Martin de Porres","San Miguel","Santiago de Surco","Surquillo","Villa Maria del Triunfo","San Juan de Lurigancho","Santa Maria del Mar","Santa Rosa","Los Olivos","Cieneguilla","San Borja","Villa el Salvador","Santa Anita","Bellavista","Callao","Carmen de la Legua","La Perla","La Punta","Ventanilla","Mi Peru"};
        ArrayAdapter<String> adapterDistritoCentroEstudios = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDistritoCentroEstudios);
        spnDistritoCentroEstudios.setAdapter(adapterDistritoCentroEstudios);



        // A MAS TARDAR EN ESTE PUNTO, TODOS LOS CONTROLES (TextView) YA DEBEN TENER LOS VALORES INICIALES APROPIADOS (O BIEN VACIOS O BIEN EXTRAIDOS DE UN REGISTRO INCOMPLETO SELECCIONADO EN LA PANT. ANTERIOR)




        recViaje.setItemViewCacheSize(25);
        recViaje.setLayoutManager(new LinearLayoutManager(this));
        adapter=new AdaptadorListaPersonas1(this,listaViajes);
        recViaje.setAdapter(adapter);
        recViaje.setItemAnimator(null);






        if(LoginActivity.modificarPersona==true){


            Detalle_Informacion_Personal_Anexo_1 up= PantallaEncuesta1.listaPersonas.get(LoginActivity.indiceModificarPersona);


            txtNombrePersona.setText(up.getNom_inpe());

            spnParentesco.setSelection(up.getPar_Q9_inpe());

            spnSexoPersona.setSelection(up.getSex_Q10_inpe());

            spnEdadPersona.setSelection(eSpinner(spnEdadPersona,""+up.getEdad_Q11_inpe()));

            spnDiscapacidad.setSelection(up.getDisc_Q12a_inpe());

            spnAyudaViajar.setSelection(up.getAyuv_Q12b_inpe());

            spnOcupacion.setSelection(up.getOcu_Q13_inpe());

            spnActividad.setSelection(up.getAct_Q14_inpe());

            spnLicenciaConducir.setSelection(up.getLic_Q15a_inpe());


            spnOperadorCelular.setSelection(up.getOpeCelQ16_inpe());


            txtCorreoElectronicoPersona.setText(up.getEma_Q15b_inpe());

            spnDistritoCentroTrabajo.setSelection(eSpinner(spnDistritoCentroTrabajo,up.getTraDis_Q16a_inpe()));

            txtDireccionCentroTrabajo.setText(up.getTraDir_Q16a_inpe());

            txtReferenciaCentroTrabajo.setText(up.getTraRef_Q16a_inpe());

            spnDistritoCentroEstudios.setSelection(eSpinner(spnDistritoCentroEstudios,up.getEstDis_Q16a_inpe()));

            txtDireccionCentroEstudios.setText(up.getEstDir_Q16a_inpe());

            txtReferenciaCentroEstudios.setText(up.getEstRef_Q16a_inpe());


            spnStatusViaje.setSelection(up.getViajeMasLargo_Persona());                    // 5/5 A CAMBIAR






            listaViajes.clear();


            for(Detalle_de_Viajes_Anexo_1 reg : up.getViajes()){

                listaViajes.add(reg);

            }

            adapter.notifyDataSetChanged();




         /*
            listaViajes=(ArrayList<Detalle_de_Viajes_Anexo_1>)up.getViajes().clone();

            adapter.notifyDataSetChanged();

         */





            PantallaEncuesta1.listaPersonas.remove(LoginActivity.indiceModificarPersona);

            PantallaEncuesta1.adapterPersonas.notifyItemRemoved(LoginActivity.indiceModificarPersona);

            LoginActivity.modificarPersona=false;

            LoginActivity.indiceModificarPersona=-100;


        }






        validarCampo(txtNombrePersona, "valNombrePersona","^[a-zA-Z-'. áéíóúÁÉÍÓÚÑñÜü]{2,63}$");

        validarCampo(txtCorreoElectronicoPersona, "valCorreoElectronicoPersona","^(|[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+)$");

        validarCampo(txtDireccionCentroTrabajo,"valDireccionCentroTrabajo","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñ]{0,63}$");

        validarCampo(txtReferenciaCentroTrabajo,"valReferenciaCentroTrabajo","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñ]{0,63}$");

        validarCampo(txtDireccionCentroEstudios,"valDireccionCentroEstudios","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñ]{0,63}$");

        validarCampo(txtReferenciaCentroEstudios,"valReferenciaCentroEstudios","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñ]{0,63}$");






        //ANTIGUA UBICACION DEL BLOQUE recViaje






        txtNombrePersona.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

             //   System.out.println(listaViajes.size());
             //   if(listaViajes.size()>0){ System.out.println(listaViajes.get(listaViajes.size()-1).getOriDis_Q17_dvia());}

                validarCampo(txtNombrePersona, "valNombrePersona","^[a-zA-Z-'. áéíóúÁÉÍÓÚÑñÜü]{2,63}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        txtCorreoElectronicoPersona.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {    //^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$

                validarCampo(txtCorreoElectronicoPersona, "valCorreoElectronicoPersona","^(|[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+)$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        txtDireccionCentroTrabajo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtDireccionCentroTrabajo,"valDireccionCentroTrabajo","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñ]{0,63}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        txtReferenciaCentroTrabajo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtReferenciaCentroTrabajo,"valReferenciaCentroTrabajo","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñ]{0,63}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        txtDireccionCentroEstudios.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtDireccionCentroEstudios,"valDireccionCentroEstudios","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñ]{0,63}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        txtReferenciaCentroEstudios.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtReferenciaCentroEstudios,"valReferenciaCentroEstudios","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñ]{0,63}$");

            //   System.out.println(coordTrabajo+"            "+coordEstudio+"         "+PantallaEncuesta1_Viaje.coordOrigen+"           "+PantallaEncuesta1_Viaje.coordDestino);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btnCrearViaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  System.out.println("zxcvb "+vals2.get("valNombrePersona")+vals2.get("valCorreoElectronicoPersona")+vals2.get("valDireccionCentroTrabajo")+vals2.get("valReferenciaCentroTrabajo")+vals2.get("valDireccionCentroEstudios")+vals2.get("valReferenciaCentroEstudios"));

                Intent i=new Intent(getApplicationContext(),PantallaEncuesta1_Viaje.class);
                startActivity(i);

            }
        });



        btnCoordenadasTrabajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginActivity.switchMapas=1;

                Intent i = new Intent(getApplicationContext(), MapsActivity.class);

                startActivity(i);





            }
        });



        btnCoordenadasEstudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginActivity.switchMapas=2;

                Intent i = new Intent(getApplicationContext(), MapsActivity.class);

                startActivity(i);





            }
        });



        btnGuardarPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //PREGUNTAR POR OTROS CAMPOS O COSAS QUE INCLUIR EN LA VALIDACION

                AlertDialog alertDialog = new AlertDialog.Builder(PantallaEncuesta1_Persona.this).create();
                alertDialog.setTitle("No se puede añadir el Registro");

                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                //ES NECESARIA ESTA VALIDACION? PREGUNTAR



/*
                if(listaViajes.size()<1){

                    alertDialog.setMessage("No hay ningun Viaje creado. Toda persona debe contar con al menos 1 viaje.");
                    alertDialog.show();

                }
                else
*/


                if( (spnEdadPersona.getSelectedItemPosition()<13 && spnParentesco.getSelectedItemPosition()==1) || (spnParentesco.getSelectedItemPosition()==6 && spnEdadPersona.getSelectedItemPosition()<25) || (spnParentesco.getSelectedItemPosition()==4 && spnEdadPersona.getSelectedItemPosition()<13)){

                    alertDialog.setMessage("El parentezco informado no es compatible con la edad registrada.");
                    alertDialog.show();

                }
                else





                if(spnEdadPersona.getSelectedItemPosition()<16 && spnLicenciaConducir.getSelectedItemPosition()==1 ){

                    alertDialog.setMessage("Una persona con la edad registrada no puede tener licencia de conducir.");
                    alertDialog.show();

                }
                else





                if( (spnStatusViaje.getSelectedItemPosition()==1 && listaViajes.size()<1) || (spnStatusViaje.getSelectedItemPosition()==2 && listaViajes.size()>0) || (spnStatusViaje.getSelectedItemPosition()==3 && listaViajes.size()>0) || (spnStatusViaje.getSelectedItemPosition()==4 && listaViajes.size()>0) ){

                    alertDialog.setMessage("La cantidad de viajes que ha registrado para esta persona no se condice con lo que ingresó en el campo de Status de Viaje.");
                    alertDialog.show();

                }
                else





                 if(spnParentesco.getSelectedItemPosition()==0 || spnSexoPersona.getSelectedItemPosition()==0 || spnDiscapacidad.getSelectedItemPosition()==0 || spnAyudaViajar.getSelectedItemPosition()==0 || spnOcupacion.getSelectedItemPosition()==0 || spnActividad.getSelectedItemPosition()==0 || spnLicenciaConducir.getSelectedItemPosition()==0 || spnOperadorCelular.getSelectedItemPosition()==0 || spnStatusViaje.getSelectedItemPosition()==0  || spnEdadPersona.getSelectedItemPosition()==0 ){

                     alertDialog.setMessage("Ha pasado por alto algún campo, debe elegir una opción en cada uno de ellos y no dejar la opción por defecto.");
                     alertDialog.show();

                 }


                 else


                    if(vals2.get("valNombrePersona")!=true || vals2.get("valCorreoElectronicoPersona")!=true || vals2.get("valDireccionCentroTrabajo")!=true ||vals2.get("valReferenciaCentroTrabajo")!=true || vals2.get("valDireccionCentroEstudios")!=true || vals2.get("valReferenciaCentroEstudios")!=true){

                    alertDialog.setMessage("Ha ingresado caracteres no permitidos o ha dejado vacio algun campo obligatorio. Intentelo nuevamente.");
                    alertDialog.show();

                }



                else{

                    Detalle_Informacion_Personal_Anexo_1 persona=new Detalle_Informacion_Personal_Anexo_1();

                    persona.setViajes(new ArrayList<>(listaViajes));

                    persona.setNom_inpe(txtNombrePersona.getText().toString());

                    persona.setPar_Q9_inpe(spnParentesco.getSelectedItemPosition());

                    persona.setSex_Q10_inpe(spnSexoPersona.getSelectedItemPosition());

                    persona.setEdad_Q11_inpe(Integer.parseInt(spnEdadPersona.getSelectedItem().toString()));

                    persona.setDisc_Q12a_inpe(spnDiscapacidad.getSelectedItemPosition());

                    persona.setAyuv_Q12b_inpe(spnAyudaViajar.getSelectedItemPosition());

                    persona.setOcu_Q13_inpe(spnOcupacion.getSelectedItemPosition());

                    persona.setAct_Q14_inpe(spnActividad.getSelectedItemPosition());

                    persona.setLic_Q15a_inpe(spnLicenciaConducir.getSelectedItemPosition());


                    persona.setOpeCelQ16_inpe(spnOperadorCelular.getSelectedItemPosition());


                    persona.setEma_Q15b_inpe(txtCorreoElectronicoPersona.getText().toString());

                    persona.setTraDis_Q16a_inpe(spnDistritoCentroTrabajo.getSelectedItem().toString());

                    persona.setTraDir_Q16a_inpe(txtDireccionCentroTrabajo.getText().toString());

                    persona.setTraRef_Q16a_inpe(txtReferenciaCentroTrabajo.getText().toString());

                    persona.setEstDis_Q16a_inpe(spnDistritoCentroEstudios.getSelectedItem().toString());

                    persona.setEstDir_Q16a_inpe(txtDireccionCentroEstudios.getText().toString());

                    persona.setEstRef_Q16a_inpe(txtReferenciaCentroEstudios.getText().toString());


                    persona.setViajeMasLargo_Persona(spnStatusViaje.getSelectedItemPosition());        // 1/5 A CAMBIAR



                   // Intent i=new Intent(getBaseContext(), PantallaEncuesta1.class);
                    PantallaEncuesta1.listaPersonas.add(persona);
                    PantallaEncuesta1.adapterPersonas.notifyItemInserted(PantallaEncuesta1.listaPersonas.size()-1);
                    finish(); //ver si esto funciona
                   // startActivity(i);


                }


            }
        });



    }


    @Override
    public void onBackPressed() {

        AlertDialog alertDialog = new AlertDialog.Builder(PantallaEncuesta1_Persona.this).create();
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

        alertDialog.setMessage("Si decide volver a la pantalla anterior se perderán todos los datos que ha ingresado en esta pantalla. Use el botón 'Añadir Persona' para guardar sus datos correctamente.");
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

            vals2.put(val,true);

            System.out.println("aaaaaaaaaaaaaaaaaaaaaa");

        }
        else{
            vals2.put(val,false);

            System.out.println("bbbbbbbbbbbbbbbbbb");
        }


    }

}
