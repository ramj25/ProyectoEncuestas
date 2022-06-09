package com.example.asus.proyectoencuestas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SyncActivity extends AppCompatActivity {

      static AdaptadorLista adapter;
      static ArrayList<Encuesta_1> lista;

   // SQLite sql=new SQLite(this,"ProyectoEncuestas",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);

        //PREGUNTAR POR INSERCION SELECTIVA DE REGISTROS CON CHECK BOX Y POR LISTA DE REGISTROS INCOMPLETOS

        Button btnEncuestas=findViewById(R.id.btnEncuesta);
        final Button btnSync=findViewById(R.id.btnSync);
        final RecyclerView recRegistros=findViewById(R.id.recRegistros);


        lista=listarBase(this);





       // final SQLiteHelper helper=new SQLiteHelper(this,"ENCUESTAS", null,1);

       /*
        System.out.println("FILAS: "+helper.getNumeroFilas("encuesta1"));

        for(Registro reg:lista){
            System.out.println("-----------------------------------------------");
            System.out.println("REG: "+reg.getUbicacion());
        }
*/

        recRegistros.setLayoutManager(new LinearLayoutManager(this));
        adapter=new AdaptadorLista(this,lista);
        recRegistros.setAdapter(adapter);

     //   System.out.println("abcdefghi----------------------");
     //   System.out.println(helper.getNumeroFilas("encuesta1")+"--------------------------------------");



        btnEncuestas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             //   System.out.println(helper.getNumeroFilas("encuesta1")+"--------------------------------------");

            //    System.out.println("-------------NUMERO DE CAMPOS: "+sql.numeroColumnas("Encuesta_1"));


           /*     Intent i=new Intent(getApplicationContext(), MainActivity.class);

                startActivity(i);

*/


                PantallaEncuesta1.listaPersonas.clear();
                //notify aca??????????????????????????????????????????

                Intent i=new Intent(getApplicationContext(), PantallaEncuesta1.class);

                startActivity(i);




            }
        });



        btnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //PARTE 1 A BORRAR SI HAY ERROR

                int cnt=0;

                String cod="9999999";

                for(int y=0;y<lista.size();y++){

                    CheckBox chkx=recRegistros.findViewHolderForAdapterPosition(y).itemView.findViewById(R.id.chk1);

                    if(chkx.isChecked()){
                        cnt=cnt+1;
                        cod="" + lista.get(y).getId_enc();
                    }

                }


                if(cnt>1){

                    AlertDialog alertDialog = new AlertDialog.Builder(SyncActivity.this).create();
                    alertDialog.setTitle("No sincronice mas de un registro a la vez");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });

                    alertDialog.setMessage("Sincronice sus registros de uno en uno para que puedan ser validados correctamente.");
                    alertDialog.show();


                }

                else {   //HASTA EL FINAL


                    //PARTE 1 ACABA ACA , COMIENZA PARTE 2



                    String est="Vacio";


                    SQLite ayuda=new SQLite(SyncActivity.this,"BDEncuestasEscom", null,3);

                    SQLiteDatabase info=ayuda.getReadableDatabase();

                    Cursor lect=info.rawQuery("SELECT * FROM Encuesta_1 WHERE Id_enc = " + cod, null );

                    if(lect.moveToFirst()){

                        do{

                            est=lect.getString(lect.getColumnIndex("Hog_enc"));

                        }while(lect.moveToNext());
                    }

                    lect.close();

                    info.close();



                    if((est.equals("Vacio") || est.equals("Completada"))==false){     //FORMULAR CONDICION ASI?


                        AlertDialog alerta = new AlertDialog.Builder(SyncActivity.this).create();
                        alerta.setTitle("No puede sincronizar encuestas que no haya marcado como completadas");

                        alerta.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });

                        alerta.setMessage("La encuesta que esta tratando de sincronizar no ha sido marcada como completada, si cree que esta lista para sincronizar cambie a 'Completada' el campo Status de la Encuesta.");
                        alerta.show();



                    }

                    else {

                        //HASTA EL FINAL , PARTE 2 ACABA ACA , TENER EN CUENTA LLAVES CIERRE SI SE QUIERE CAMBIAR ALGO





                        btnSync.setEnabled(false);

                        new Handler().postDelayed(new Runnable() {

                            @Override
                            public void run() {
                                // This method will be executed once the timer is over
                                btnSync.setEnabled(true);


                            }
                        }, 20000);


                        System.out.println("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");

                        for (int i = 0; i < lista.size(); i++) {

                            CheckBox ch = recRegistros.findViewHolderForAdapterPosition(i).itemView.findViewById(R.id.chk1);

                            if (ch.isChecked()) {

                                final SQLite help = new SQLite(SyncActivity.this, "BDEncuestasEscom", null, 3);

                                //  SQLiteHelper help=new SQLiteHelper(SyncActivity.this,"BDEncuestasEscom", null,1);

                                SQLiteDatabase b = help.getReadableDatabase();

                                final String codigo = "" + lista.get(i).getId_enc();

                                Cursor curs = b.rawQuery("SELECT * FROM Encuesta_1 WHERE Id_enc = " + codigo, null);

                                //  Cursor curs=b.rawQuery("SELECT * FROM Encuesta_1 WHERE Id_enc = ?", new String []{codigo});

                                final Encuesta_1 enc = new Encuesta_1();

                                if (curs.moveToFirst()) {

                                    do {
                                        enc.setId_enc(curs.getInt(curs.getColumnIndex("Id_enc")));
                                        enc.setEnc_enc(curs.getString(curs.getColumnIndex("Enc_enc")));
                                        enc.setFyh_enc(curs.getString(curs.getColumnIndex("Fyh_enc")));
                                        if (curs.getString(curs.getColumnIndex("Fv1_enc")) != null) {
                                            enc.setFv1_enc(curs.getString(curs.getColumnIndex("Fv1_enc")));
                                        }
                                        if (curs.getString(curs.getColumnIndex("Fv2_enc")) != null) {
                                            enc.setFv2_enc(curs.getString(curs.getColumnIndex("Fv2_enc")));
                                        }
                                        if (curs.getString(curs.getColumnIndex("Fv3_enc")) != null) {
                                            enc.setFv3_enc(curs.getString(curs.getColumnIndex("Fv3_enc")));
                                        }
                                        enc.setHog_enc(curs.getString(curs.getColumnIndex("Hog_enc")));
                                        enc.setDom_enc(curs.getString(curs.getColumnIndex("Dom_enc")));
                                        enc.setDis_enc(curs.getString(curs.getColumnIndex("Dis_enc")));
                                        enc.setSeg_enc(curs.getInt(curs.getColumnIndex("Seg_enc")));
                                        enc.setViv_enc(curs.getInt(curs.getColumnIndex("Viv_enc")));
                                        enc.setSup_enc(curs.getString(curs.getColumnIndex("Sup_enc")));
                                        enc.setSupM1_enc(curs.getInt(curs.getColumnIndex("SupM1_enc")));
                                        enc.setSupM2_enc(curs.getInt(curs.getColumnIndex("SupM2_enc")));
                                        enc.setSupM3_enc(curs.getInt(curs.getColumnIndex("SupM3_enc")));
                                        enc.setCod_enc(curs.getString(curs.getColumnIndex("Cod_enc")));
                                        enc.setCodM1_enc(curs.getInt(curs.getColumnIndex("CodM1_enc")));
                                        enc.setCodM2_enc(curs.getInt(curs.getColumnIndex("CodM2_enc")));
                                        enc.setCodM3_enc(curs.getInt(curs.getColumnIndex("CodM3_enc")));
                                        enc.setNjh_Q1_enc(curs.getString(curs.getColumnIndex("Njh_Q1_enc")));
                                        enc.setTvi_Q2a_enc(curs.getInt(curs.getColumnIndex("Tvi_Q2a_enc")));
                                        enc.setNombre_Calle(curs.getString(curs.getColumnIndex("Nombre_Calle")));
                                        enc.setNum_Q2a_enc(curs.getString(curs.getColumnIndex("Num_Q2a_enc")));
                                        enc.setInt_Q2a_enc(curs.getString(curs.getColumnIndex("Int_Q2a_enc")));
                                        enc.setPis_Q2a_enc(curs.getInt(curs.getColumnIndex("Pis_Q2a_enc")));
                                        enc.setEta_Q2a_enc(curs.getString(curs.getColumnIndex("Eta_Q2a_enc")));
                                        enc.setMzn_Q2a_enc(curs.getString(curs.getColumnIndex("Mzn_Q2a_enc")));
                                        enc.setLote_Q2a_enc(curs.getString(curs.getColumnIndex("Lote_Q2a_enc")));
                                        enc.setKm_Q2a_enc(curs.getDouble(curs.getColumnIndex("Km_Q2a_enc")));          //CAMBIO
                                        enc.setZon_Q2a_enc(curs.getString(curs.getColumnIndex("Zon_Q2a_enc")));
                                        enc.setTel_Q2a_enc(curs.getString(curs.getColumnIndex("Tel_Q2a_enc")));
                                        enc.setNedQ3_enc(curs.getInt(curs.getColumnIndex("NedQ3_enc")));
                                        enc.setRMen6H_Q4_enc(curs.getInt(curs.getColumnIndex("RMen6H_Q4_enc")));
                                        enc.setRMen6M_Q4_enc(curs.getInt(curs.getColumnIndex("RMen6M_Q4_enc")));
                                        enc.setRMay6H_Q4_enc(curs.getInt(curs.getColumnIndex("RMay6H_Q4_enc")));
                                        enc.setRMay6M_Q4_enc(curs.getInt(curs.getColumnIndex("RMay6M_Q4_enc")));
                                        enc.setREmhH_Q4_enc(curs.getInt(curs.getColumnIndex("REmhH_Q4_enc")));
                                        enc.setREmhM_Q4_enc(curs.getInt(curs.getColumnIndex("REmhM_Q4_enc")));
                                        enc.setRdt_Q5a_enc(curs.getInt(curs.getColumnIndex("Rdt_Q5a_enc")));
                                        enc.setTviv_Q5b_enc(curs.getInt(curs.getColumnIndex("Tviv_Q5b_enc")));
                                        enc.setHab_Q5c_enc(curs.getInt(curs.getColumnIndex("Hab_Q5c_enc")));
                                        enc.setIng_Q6_enc(curs.getInt(curs.getColumnIndex("Ing_Q6_enc")));
                                        enc.setBici_Und_Q7_enc(curs.getInt(curs.getColumnIndex("Bici_Und_Q7_enc")));
                                        enc.setBici_Ant1_Q7_enc(curs.getInt(curs.getColumnIndex("Bici_Ant1_Q7_enc")));
                                        enc.setBici_Ant2_Q7_enc(curs.getInt(curs.getColumnIndex("Bici_Ant2_Q7_enc")));
                                        enc.setBici_Ant3_Q7_enc(curs.getInt(curs.getColumnIndex("Bici_Ant3_Q7_enc")));
                                        enc.setBici_Ant4_Q7_enc(curs.getInt(curs.getColumnIndex("Bici_Ant4_Q7_enc")));
                                        enc.setMoto_Und_Q7_enc(curs.getInt(curs.getColumnIndex("Moto_Und_Q7_enc")));
                                        enc.setMoto_Ant1_Q7_enc(curs.getInt(curs.getColumnIndex("Moto_Ant1_Q7_enc")));
                                        enc.setMoto_Ant2_Q7_enc(curs.getInt(curs.getColumnIndex("Moto_Ant2_Q7_enc")));
                                        enc.setMoto_Ant3_Q7_enc(curs.getInt(curs.getColumnIndex("Moto_Ant3_Q7_enc")));
                                        enc.setMoto_Ant4_Q7_enc(curs.getInt(curs.getColumnIndex("Moto_Ant4_Q7_enc")));
                                        enc.setCarro_Und_Q7_enc(curs.getInt(curs.getColumnIndex("Carro_Und_Q7_enc")));
                                        enc.setCarro_Ant1_Q7_enc(curs.getInt(curs.getColumnIndex("Carro_Ant1_Q7_enc")));
                                        enc.setCarro_Ant2_Q7_enc(curs.getInt(curs.getColumnIndex("Carro_Ant2_Q7_enc")));
                                        enc.setCarro_Ant3_Q7_enc(curs.getInt(curs.getColumnIndex("Carro_Ant3_Q7_enc")));
                                        enc.setCarro_Ant4_Q7_enc(curs.getInt(curs.getColumnIndex("Carro_Ant4_Q7_enc")));
                                        enc.setRural_Und_Q7_enc(curs.getInt(curs.getColumnIndex("Rural_Und_Q7_enc")));
                                        enc.setRural_Ant1_Q7_enc(curs.getInt(curs.getColumnIndex("Rural_Ant1_Q7_enc")));
                                        enc.setRural_Ant2_Q7_enc(curs.getInt(curs.getColumnIndex("Rural_Ant2_Q7_enc")));
                                        enc.setRural_Ant3_Q7_enc(curs.getInt(curs.getColumnIndex("Rural_Ant3_Q7_enc")));
                                        enc.setRural_Ant4_Q7_enc(curs.getInt(curs.getColumnIndex("Rural_Ant4_Q7_enc")));
                                        enc.setMicro_Und_Q7_enc(curs.getInt(curs.getColumnIndex("Micro_Und_Q7_enc")));
                                        enc.setMicro_Ant1_Q7_enc(curs.getInt(curs.getColumnIndex("Micro_Ant1_Q7_enc")));
                                        enc.setMicro_Ant2_Q7_enc(curs.getInt(curs.getColumnIndex("Micro_Ant2_Q7_enc")));
                                        enc.setMicro_Ant3_Q7_enc(curs.getInt(curs.getColumnIndex("Micro_Ant3_Q7_enc")));
                                        enc.setMicro_Ant4_Q7_enc(curs.getInt(curs.getColumnIndex("Micro_Ant4_Q7_enc")));
                                        enc.setOmnib_Und_Q7_enc(curs.getInt(curs.getColumnIndex("Omnib_Und_Q7_enc")));
                                        enc.setOmnib_Ant1_Q7_enc(curs.getInt(curs.getColumnIndex("Omnib_Ant1_Q7_enc")));
                                        enc.setOmnib_Ant2_Q7_enc(curs.getInt(curs.getColumnIndex("Omnib_Ant2_Q7_enc")));
                                        enc.setOmnib_Ant3_Q7_enc(curs.getInt(curs.getColumnIndex("Omnib_Ant3_Q7_enc")));
                                        enc.setOmnib_Ant4_Q7_enc(curs.getInt(curs.getColumnIndex("Omnib_Ant4_Q7_enc")));
                                        enc.setCamio_Und_Q7_enc(curs.getInt(curs.getColumnIndex("Camio_Und_Q7_enc")));
                                        enc.setCamio_Ant1_Q7_enc(curs.getInt(curs.getColumnIndex("Camio_Ant1_Q7_enc")));
                                        enc.setCamio_Ant2_Q7_enc(curs.getInt(curs.getColumnIndex("Camio_Ant2_Q7_enc")));
                                        enc.setCamio_Ant3_Q7_enc(curs.getInt(curs.getColumnIndex("Camio_Ant3_Q7_enc")));
                                        enc.setCamio_Ant4_Q7_enc(curs.getInt(curs.getColumnIndex("Camio_Ant4_Q7_enc")));
                                        enc.setTrail_Und_Q7_enc(curs.getInt(curs.getColumnIndex("Trail_Und_Q7_enc")));
                                        enc.setTrail_Ant1_Q7_enc(curs.getInt(curs.getColumnIndex("Trail_Ant1_Q7_enc")));
                                        enc.setTrail_Ant2_Q7_enc(curs.getInt(curs.getColumnIndex("Trail_Ant2_Q7_enc")));
                                        enc.setTrail_Ant3_Q7_enc(curs.getInt(curs.getColumnIndex("Trail_Ant3_Q7_enc")));
                                        enc.setTrail_Ant4_Q7_enc(curs.getInt(curs.getColumnIndex("Trail_Ant4_Q7_enc")));
                                        enc.setOtro_Und_Q7_enc(curs.getInt(curs.getColumnIndex("Otro_Und_Q7_enc")));
                                        enc.setOtro_Ant1_Q7_enc(curs.getInt(curs.getColumnIndex("Otro_Ant1_Q7_enc")));
                                        enc.setOtro_Ant2_Q7_enc(curs.getInt(curs.getColumnIndex("Otro_Ant2_Q7_enc")));
                                        enc.setOtro_Ant3_Q7_enc(curs.getInt(curs.getColumnIndex("Otro_Ant3_Q7_enc")));
                                        enc.setOtro_Ant4_Q7_enc(curs.getInt(curs.getColumnIndex("Otro_Ant4_Q7_enc")));
                                        if (curs.getInt(curs.getColumnIndex("Telev_Q8_enc")) == 0) {
                                            enc.setTelev_Q8_enc(false);
                                        } else {
                                            enc.setTelev_Q8_enc(true);
                                        } //ESTOS PUEDEN GENERAR PROB XQ AZURE USA INT?
                                        enc.setTelev_Und_Q8_enc(curs.getInt(curs.getColumnIndex("Telev_Und_Q8_enc")));
                                        if (curs.getInt(curs.getColumnIndex("Telef_Q8_enc")) == 0) {
                                            enc.setTelef_Q8_enc(false);
                                        } else {
                                            enc.setTelef_Q8_enc(true);
                                        } //ESTOS PUEDEN GENERAR PROB XQ AZURE USA INT?
                                        enc.setTelef_Und_Q8_enc(curs.getInt(curs.getColumnIndex("Telef_Und_Q8_enc")));
                                        if (curs.getInt(curs.getColumnIndex("Refri_Q8_enc")) == 0) {
                                            enc.setRefri_Q8_enc(false);
                                        } else {
                                            enc.setRefri_Q8_enc(true);
                                        } //ESTOS PUEDEN GENERAR PROB XQ AZURE USA INT?
                                        enc.setRefri_Und_Q8_enc(curs.getInt(curs.getColumnIndex("Refri_Und_Q8_enc")));
                                        if (curs.getInt(curs.getColumnIndex("Lavad_Q8_enc")) == 0) {
                                            enc.setLavad_Q8_enc(false);
                                        } else {
                                            enc.setLavad_Q8_enc(true);
                                        } //ESTOS PUEDEN GENERAR PROB XQ AZURE USA INT?
                                        enc.setLavad_Und_Q8_enc(curs.getInt(curs.getColumnIndex("Lavad_Und_Q8_enc")));
                                        if (curs.getInt(curs.getColumnIndex("Compu_Q8_enc")) == 0) {
                                            enc.setCompu_Q8_enc(false);
                                        } else {
                                            enc.setCompu_Q8_enc(true);
                                        } //ESTOS PUEDEN GENERAR PROB XQ AZURE USA INT?
                                        enc.setCompu_Und_Q8_enc(curs.getInt(curs.getColumnIndex("Compu_Und_Q8_enc")));
                                        if (curs.getInt(curs.getColumnIndex("Aspir_Q8_enc")) == 0) {
                                            enc.setAspir_Q8_enc(false);
                                        } else {
                                            enc.setAspir_Q8_enc(true);
                                        } //ESTOS PUEDEN GENERAR PROB XQ AZURE USA INT?
                                        enc.setAspir_Und_Q8_enc(curs.getInt(curs.getColumnIndex("Aspir_Und_Q8_enc")));
                                        if (curs.getInt(curs.getColumnIndex("Cogas_Q8_enc")) == 0) {
                                            enc.setCogas_Q8_enc(false);
                                        } else {
                                            enc.setCogas_Q8_enc(true);
                                        } //ESTOS PUEDEN GENERAR PROB XQ AZURE USA INT?
                                        enc.setCogas_Und_Q8_enc(curs.getInt(curs.getColumnIndex("Cogas_Und_Q8_enc")));
                                        if (curs.getInt(curs.getColumnIndex("Coele_Q8_enc")) == 0) {
                                            enc.setCoele_Q8_enc(false);
                                        } else {
                                            enc.setCoele_Q8_enc(true);
                                        } //ESTOS PUEDEN GENERAR PROB XQ AZURE USA INT?
                                        enc.setCoele_Und_Q8_enc(curs.getInt(curs.getColumnIndex("Coele_Und_Q8_enc")));
                                        if (curs.getInt(curs.getColumnIndex("Micro_Q8_enc")) == 0) {
                                            enc.setMicro_Q8_enc(false);
                                        } else {
                                            enc.setMicro_Q8_enc(true);
                                        } //ESTOS PUEDEN GENERAR PROB XQ AZURE USA INT?
                                        enc.setMicro_Und_Q8_enc(curs.getInt(curs.getColumnIndex("Micro_Und_Q8_enc")));
                                        enc.setSta_enc(curs.getInt(curs.getColumnIndex("Sta_enc")));
                                        enc.setMatPrePa_enc(curs.getInt(curs.getColumnIndex("MatPrePa_enc")));
                                        enc.setMatPrePi_enc(curs.getInt(curs.getColumnIndex("MatPrePi_enc")));
                                        enc.setTipAlum_enc(curs.getInt(curs.getColumnIndex("TipAlum_enc")));
                                        enc.setTipAgua_enc(curs.getInt(curs.getColumnIndex("TipAgua_enc")));
                                        enc.setTipHig_enc(curs.getInt(curs.getColumnIndex("TipHig_enc")));
                                        enc.setNot_enc(curs.getString(curs.getColumnIndex("Not_enc")));
                                        enc.setZonce_enc(curs.getString(curs.getColumnIndex("Zonce_enc")));
                                        enc.setManza_enc(curs.getString(curs.getColumnIndex("Manza_enc")));
                                        enc.setOtroTipo_Vehiculo(curs.getString(curs.getColumnIndex("OtroTipo_Vehiculo")));
                                        enc.setOtroMat_Paredes(curs.getString(curs.getColumnIndex("OtroMat_Paredes")));
                                        enc.setOtroMat_Pisos(curs.getString(curs.getColumnIndex("OtroMat_Pisos")));
                                        enc.setOtroTipo_Alum(curs.getString(curs.getColumnIndex("OtroTipo_Alum")));
                                        enc.setOtroTipo_Agua(curs.getString(curs.getColumnIndex("OtroTipo_Agua")));
                                        enc.setOtroTipo_ServHigienico(curs.getString(curs.getColumnIndex("OtroTipo_ServHigienico")));

                                        enc.setMototaxi_Unidades(curs.getInt(curs.getColumnIndex("Mototaxi_Unidades")));
                                        enc.setMototaxi_Ant1(curs.getInt(curs.getColumnIndex("Mototaxi_Ant1")));
                                        enc.setMototaxi_Ant2(curs.getInt(curs.getColumnIndex("Mototaxi_Ant2")));
                                        enc.setMototaxi_Ant3(curs.getInt(curs.getColumnIndex("Mototaxi_Ant3")));
                                        enc.setMototaxi_Ant4(curs.getInt(curs.getColumnIndex("Mototaxi_Ant4")));
                                        enc.setTaxi_Unidades(curs.getInt(curs.getColumnIndex("Taxi_Unidades")));
                                        enc.setTaxi_Ant1(curs.getInt(curs.getColumnIndex("Taxi_Ant1")));
                                        enc.setTaxi_Ant2(curs.getInt(curs.getColumnIndex("Taxi_Ant2")));
                                        enc.setTaxi_Ant3(curs.getInt(curs.getColumnIndex("Taxi_Ant3")));
                                        enc.setTaxi_Ant4(curs.getInt(curs.getColumnIndex("Taxi_Ant4")));

                                        enc.setCoordenadas_Ubicacion(curs.getString(curs.getColumnIndex("Coordenadas_Ubicacion")));

                                        enc.setHog_enc(curs.getString(curs.getColumnIndex("Hog_enc")));


                                    } while (curs.moveToNext());
                                }

                                curs.close();


                                Cursor curso = b.rawQuery("SELECT * FROM Detalle_Informacion_Personal_Anexo_1 WHERE Enc_inpe =?", new String[]{codigo});  //EN EL FUTURO SE PODRIA CAMBIAR EL UNO POR UN VALOR EN SELECTION ARGS QUE SE PASE DESEDE EL PARAMETRO DEL METODO
                                //listarBase(VALOR) PARA CUANDO SE TENGAN QUE LISTAR COMPLETAS E INCOMPLETAS

                                final ArrayList<Detalle_Informacion_Personal_Anexo_1> listaPer = new ArrayList<>();


                                if (curso.moveToFirst()) {

                                    do {

                                        Detalle_Informacion_Personal_Anexo_1 per = new Detalle_Informacion_Personal_Anexo_1();


                                        per.setEnc_inpe(curso.getString(curso.getColumnIndex("Enc_inpe")));
                                        per.setPer_inpe(curso.getInt(curso.getColumnIndex("Per_inpe")));
                                        per.setDoc_inpe(curso.getString(curso.getColumnIndex("Doc_inpe")));
                                        per.setNom_inpe(curso.getString(curso.getColumnIndex("Nom_inpe")));
                                        per.setPar_Q9_inpe(curso.getInt(curso.getColumnIndex("Par_Q9_inpe")));
                                        per.setSex_Q10_inpe(curso.getInt(curso.getColumnIndex("Sex_Q10_inpe")));
                                        per.setEdad_Q11_inpe(curso.getInt(curso.getColumnIndex("Edad_Q11_inpe")));
                                        per.setDisc_Q12a_inpe(curso.getInt(curso.getColumnIndex("Disc_Q12a_inpe")));
                                        per.setAyuv_Q12b_inpe(curso.getInt(curso.getColumnIndex("Ayuv_Q12b_inpe")));
                                        per.setOcu_Q13_inpe(curso.getInt(curso.getColumnIndex("Ocu_Q13_inpe")));
                                        per.setAct_Q14_inpe(curso.getInt(curso.getColumnIndex("Act_Q14_inpe")));
                                        per.setLic_Q15a_inpe(curso.getInt(curso.getColumnIndex("Lic_Q15a_inpe")));

                                        per.setOpeCelQ16_inpe(curso.getInt(curso.getColumnIndex("OpeCelQ16_inpe")));

                                        per.setEma_Q15b_inpe(curso.getString(curso.getColumnIndex("Ema_Q15b_inpe")));
                                        per.setTraDis_Q16a_inpe(curso.getString(curso.getColumnIndex("TraDis_Q16a_inpe")));
                                        per.setTraDir_Q16a_inpe(curso.getString(curso.getColumnIndex("TraDir_Q16a_inpe")));
                                        per.setTraRef_Q16a_inpe(curso.getString(curso.getColumnIndex("TraRef_Q16a_inpe")));
                                        per.setEstDis_Q16a_inpe(curso.getString(curso.getColumnIndex("EstDis_Q16a_inpe")));
                                        per.setEstDir_Q16a_inpe(curso.getString(curso.getColumnIndex("EstDir_Q16a_inpe")));
                                        per.setEstRef_Q16a_inpe(curso.getString(curso.getColumnIndex("EstRef_Q16a_inpe")));

                                        per.setViajeMasLargo_Persona(curso.getInt(curso.getColumnIndex("ViajeMasLargo_Persona")));             // 3/5 A CAMBIAR


                                        listaPer.add(per);
                                    } while (curso.moveToNext());
                                }
                                curso.close();


                                Cursor cu = b.rawQuery("SELECT * FROM Detalle_de_Viajes_Anexo_1 WHERE Enc_dvia =?", new String[]{codigo});  //EN EL FUTURO SE PODRIA CAMBIAR EL UNO POR UN VALOR EN SELECTION ARGS QUE SE PASE DESEDE EL PARAMETRO DEL METODO
                                //listarBase(VALOR) PARA CUANDO SE TENGAN QUE LISTAR COMPLETAS E INCOMPLETAS

                                final ArrayList<Detalle_de_Viajes_Anexo_1> listaVia = new ArrayList<>();


                                if (cu.moveToFirst()) {

                                    do {

                                        Detalle_de_Viajes_Anexo_1 via = new Detalle_de_Viajes_Anexo_1();


                                        via.setEnc_dvia(cu.getString(cu.getColumnIndex("Enc_dvia")));
                                        via.setPer_dvia(cu.getInt(cu.getColumnIndex("Per_dvia")));
                                        via.setVia_dvia(cu.getInt(cu.getColumnIndex("Via_dvia")));
                                        via.setDoc_Encuestador(cu.getString(cu.getColumnIndex("Doc_Encuestador")));
                                        via.setOriDis_Q17_dvia(cu.getString(cu.getColumnIndex("OriDis_Q17_dvia")));
                                        via.setOriDir_Q17_dvia(cu.getString(cu.getColumnIndex("OriDir_Q17_dvia")));
                                        via.setOriRef_Q17_dvia(cu.getString(cu.getColumnIndex("OriRef_Q17_dvia")));
                                        via.setOriZtra_Q17_dvia(cu.getString(cu.getColumnIndex("OriZtra_Q17_dvia")));
                                        via.setOriLug_Q18_dvia(cu.getInt(cu.getColumnIndex("OriLug_Q18_dvia")));
                                        via.setOriHor_Q19_dvia(cu.getInt(cu.getColumnIndex("OriHor_Q19_dvia")));
                                        via.setOriMin_Q19_dvia(cu.getInt(cu.getColumnIndex("OriMin_Q19_dvia")));
                                        via.setOriAmPm_Q19_dvia(cu.getInt(cu.getColumnIndex("OriAmPm_Q19_dvia")));
                                        via.setDesDis_Q20_dvia(cu.getString(cu.getColumnIndex("DesDis_Q20_dvia")));
                                        via.setDesDir_Q20_dvia(cu.getString(cu.getColumnIndex("DesDir_Q20_dvia")));
                                        via.setDesRef_Q20_dvia(cu.getString(cu.getColumnIndex("DesRef_Q20_dvia")));
                                        via.setDesZtra_Q20_dvia(cu.getString(cu.getColumnIndex("DesZtra_Q20_dvia")));
                                        via.setDesLug_Q21_dvia(cu.getInt(cu.getColumnIndex("DesLug_Q21_dvia")));
                                        via.setDesHor_Q22_dvia(cu.getInt(cu.getColumnIndex("DesHor_Q22_dvia")));
                                        via.setDesMin_Q22_dvia(cu.getInt(cu.getColumnIndex("DesMin_Q22_dvia")));
                                        via.setDesAmPm_Q22_dvia(cu.getInt(cu.getColumnIndex("DesAmPm_Q22_dvia")));
                                        via.setPro_Q23_dvia(cu.getInt(cu.getColumnIndex("Pro_Q23_dvia")));
                                        via.setTraMed1_Q24a_dvia(cu.getInt(cu.getColumnIndex("TraMed1_Q24a_dvia")));
                                        via.setTraTpo1_Q24b_dvia(cu.getInt(cu.getColumnIndex("TraTpo1_Q24b_dvia")));
                                        via.setTraCos1_Q24c_dvia(cu.getDouble(cu.getColumnIndex("TraCos1_Q24c_dvia")));     //CAMBIO
                                        via.setTransb12_Q24d_dvia(cu.getString(cu.getColumnIndex("Transb12_Q24d_dvia")));
                                        via.setTransb12_Q24e_dvia(cu.getInt(cu.getColumnIndex("Transb12_Q24e_dvia")));
                                        via.setTraMed2_Q24a_dvia(cu.getInt(cu.getColumnIndex("TraMed2_Q24a_dvia")));
                                        via.setTraTpo2_Q24b_dvia(cu.getInt(cu.getColumnIndex("TraTpo2_Q24b_dvia")));
                                        via.setTraCos2_Q24c_dvia(cu.getDouble(cu.getColumnIndex("TraCos2_Q24c_dvia")));      //CAMBIO
                                        via.setTransb23_Q24d_dvia(cu.getString(cu.getColumnIndex("Transb23_Q24d_dvia")));
                                        via.setTransb23_Q24e_dvia(cu.getInt(cu.getColumnIndex("Transb23_Q24e_dvia")));
                                        via.setTraMed3_Q24a_dvia(cu.getInt(cu.getColumnIndex("TraMed3_Q24a_dvia")));
                                        via.setTraTpo3_Q24b_dvia(cu.getInt(cu.getColumnIndex("TraTpo3_Q24b_dvia")));
                                        via.setTraCos3_Q24c_dvia(cu.getDouble(cu.getColumnIndex("TraCos3_Q24c_dvia")));       //CAMBIO
                                        via.setTransb34_Q24d_dvia(cu.getString(cu.getColumnIndex("Transb34_Q24d_dvia")));
                                        via.setTransb34_Q24e_dvia(cu.getInt(cu.getColumnIndex("Transb34_Q24e_dvia")));
                                        via.setTraMed4_Q24a_dvia(cu.getInt(cu.getColumnIndex("TraMed4_Q24a_dvia")));
                                        via.setTraTpo4_Q24b_dvia(cu.getInt(cu.getColumnIndex("TraTpo4_Q24b_dvia")));
                                        via.setTraCos4_Q24c_dvia(cu.getDouble(cu.getColumnIndex("TraCos4_Q24c_dvia")));        //CAMBIO
                                        via.setTransb45_Q24d_dvia(cu.getString(cu.getColumnIndex("Transb45_Q24d_dvia")));
                                        via.setTransb45_Q24e_dvia(cu.getInt(cu.getColumnIndex("Transb45_Q24e_dvia")));
                                        via.setTraMed5_Q24a_dvia(cu.getInt(cu.getColumnIndex("TraMed5_Q24a_dvia")));
                                        via.setTraTpo5_Q24b_dvia(cu.getInt(cu.getColumnIndex("TraTpo5_Q24b_dvia")));
                                        via.setTraCos5_Q24c_dvia(cu.getDouble(cu.getColumnIndex("TraCos5_Q24c_dvia")));         //CAMBIO
                                        via.setTransb56_Q24d_dvia(cu.getString(cu.getColumnIndex("Transb56_Q24d_dvia")));
                                        via.setTransb56_Q24e_dvia(cu.getInt(cu.getColumnIndex("Transb56_Q24e_dvia")));
                                        via.setTraMed6_Q24a_dvia(cu.getInt(cu.getColumnIndex("TraMed6_Q24a_dvia")));
                                        via.setTraTpo6_Q24b_dvia(cu.getInt(cu.getColumnIndex("TraTpo6_Q24b_dvia")));
                                        via.setTraCos6_Q24c_dvia(cu.getDouble(cu.getColumnIndex("TraCos6_Q24c_dvia")));          //CAMBIO
                                        via.setTransb67_Q24d_dvia(cu.getString(cu.getColumnIndex("Transb67_Q24d_dvia")));
                                        via.setTransb67_Q24e_dvia(cu.getInt(cu.getColumnIndex("Transb67_Q24e_dvia")));
                                        via.setTraMed7_Q24a_dvia(cu.getInt(cu.getColumnIndex("TraMed7_Q24a_dvia")));
                                        via.setTraTpo7_Q24b_dvia(cu.getInt(cu.getColumnIndex("TraTpo7_Q24b_dvia")));
                                        via.setTraCos7_Q24c_dvia(cu.getDouble(cu.getColumnIndex("TraCos7_Q24c_dvia")));           //CAMBIO
                                        via.setMcar_Q25_dvia(cu.getInt(cu.getColumnIndex("Mcar_Q25_dvia")));
                                        via.setEsta_Q26a_dvia(cu.getInt(cu.getColumnIndex("Esta_Q26a_dvia")));
                                        via.setPago_Q26b_dvia(cu.getInt(cu.getColumnIndex("Pago_Q26b_dvia")));
                                        via.setTar_Q26c_dvia(cu.getDouble(cu.getColumnIndex("Tar_Q26c_dvia")));
                                        via.setTraRazem1_Q29_dvia(cu.getInt(cu.getColumnIndex("TraRazem1_Q29_dvia")));           //NO BORRAR
                                        via.setTranutp1_Q30_dvia(cu.getInt(cu.getColumnIndex("Tranutp1_Q30_dvia")));
                                        via.setNdsBusDis_Q30_dvia(cu.getInt(cu.getColumnIndex("NdsBusDis_Q30_dvia")));
                                        via.setNdsBusTpo_Q30_dvia(cu.getInt(cu.getColumnIndex("NdsBusTpo_Q30_dvia")));
                                        via.setNdsBusTar_Q30_dvia(cu.getDouble(cu.getColumnIndex("NdsBusTar_Q30_dvia"))); //PUEDE CAUSAR ERRORES (DOUBLE)
                                        via.setNdsBustrb_Q30_dvia(cu.getInt(cu.getColumnIndex("NdsBustrb_Q30_dvia")));
                                        via.setNdsTaxiDis_Q30_dvia(cu.getInt(cu.getColumnIndex("NdsTaxiDis_Q30_dvia")));
                                        via.setNdsTaxiTpo_Q30_dvia(cu.getInt(cu.getColumnIndex("NdsTaxiTpo_Q30_dvia")));
                                        via.setNdsTaxiTar_Q30_dvia(cu.getInt(cu.getColumnIndex("NdsTaxiTar_Q30_dvia")));
                                        via.setNdsCarroTpo_Q30_dvia(cu.getInt(cu.getColumnIndex("NdsCarroTpo_Q30_dvia")));
                                        via.setNdsCarroCos_Q30_dvia(cu.getInt(cu.getColumnIndex("NdsCarroCos_Q30_dvia")));
                                        via.setNdsCarroPea_Q30_dvia(cu.getDouble(cu.getColumnIndex("NdsCarroPea_Q30_dvia"))); //PUEDE CAUSAR ERRORES (DOUBLE)
                                        via.setNdsCarroEsta_Q30_dvia(cu.getDouble(cu.getColumnIndex("NdsCarroEsta_Q30_dvia"))); //PUEDE CAUSAR ERRORES (DOUBLE)

                                        via.setCoordenadas_Origen(cu.getString(cu.getColumnIndex("Coordenadas_Origen")));  //cambio 9 IF NOT NULL?
                                        via.setCoordenadas_Destino(cu.getString(cu.getColumnIndex("Coordenadas_Destino")));  //cambio 10 IF NOT NULL?

                                        via.setDia_Viaje(cu.getString(cu.getColumnIndex("Dia_Viaje")));
                                        via.setMes_Viaje(cu.getString(cu.getColumnIndex("Mes_Viaje")));

                                        via.setPeaViaQ26d_dvia(cu.getDouble(cu.getColumnIndex("PeaViaQ26d_dvia")));
                                        via.setFreViaQ26e_dvia(cu.getInt(cu.getColumnIndex("FreViaQ26e_dvia")));

                                        if (cu.getInt(cu.getColumnIndex("VialarQ27_dvia")) == 0) {
                                            via.setVialarQ27_dvia(false);
                                        } else {
                                            via.setVialarQ27_dvia(true);
                                        } //PUEDE CAUSAR ERROR
                                        via.setMedQ28_dvia(cu.getInt(cu.getColumnIndex("MedQ28_dvia")));
                                        via.setPqnutpQ30_dvia(cu.getInt(cu.getColumnIndex("PqnutpQ30_dvia")));
                                        if (cu.getInt(cu.getColumnIndex("ConsenQ31_dvia")) == 0) {
                                            via.setConsenQ31_dvia(false);
                                        } else {
                                            via.setConsenQ31_dvia(true);
                                        } //PUEDE CAUSAR ERROR
                                        via.setNumCelQ32_dvia(cu.getInt(cu.getColumnIndex("NumCelQ32_dvia")));

                                        via.setOtraFrecuenciaViaje(cu.getString(cu.getColumnIndex("OtraFrecuenciaViaje")));


                                        listaVia.add(via);
                                    } while (cu.moveToNext());
                                }
                                cu.close();


                                b.close();




                        /*


                        final boolean[] exito = new boolean[1];

                        do{
                            exito[0] =true;

                            final boolean[] exitoDelete = {true};
                            do{
                                exitoDelete[0] =true;

                                System.out.println("---------------------------------------------------------------------------------------------------------------------------");

                                   @SuppressLint("StaticFieldLeak") AsyncTask<Void,Void,Void>task = new AsyncTask<Void, Void, Void>() {
                                        @Override
                                        protected Void doInBackground(Void... voids) {

                                            boolean x1=true;

                                            try {
                                                List<Encuesta_1> result1 = LoginActivity.mClient.getTable(Encuesta_1.class)
                                                        .where()
                                                        .field("Id_enc").eq(codigo)
                                                        .execute()
                                                        .get();

                                                for(Encuesta_1 t1 : result1){

                                                    System.out.println("--------------------- "+t1.getId());

                                                    LoginActivity.mClient.getTable(Encuesta_1.class).delete(t1.getId());

                                                }



                                            } catch (InterruptedException e) {
                                                System.out.println("----------------------------FALLO UN SELECT1a");
                                                e.printStackTrace();
                                                exitoDelete[0] =false;

                                            } catch (ExecutionException e) {
                                                System.out.println("----------------------------FALLO UN SELECT1b");
                                                e.printStackTrace();
                                                exitoDelete[0] =false;

                                            } catch (Exception e) {
                                                System.out.println("----------------------------FALLO UN SELECT1c");
                                                e.printStackTrace();
                                               exitoDelete[0] =false;

                                            }

                                            System.out.println("DELETE 1111111111111111111111111111111111111111111111111111 "+ exitoDelete[0]);

                                            return null;

                                        }
                                    };

                                   Boolean async1=true;


                                 task.execute();


                                @SuppressLint("StaticFieldLeak") AsyncTask<Void,Void,Void>task2 = new AsyncTask<Void, Void, Void>() {
                                    @Override
                                    protected Void doInBackground(Void... voids) {

                                        boolean x2=true;

                                        try {

                                            List<Detalle_Informacion_Personal_Anexo_1> result1 = LoginActivity.mClient.getTable(Detalle_Informacion_Personal_Anexo_1.class)
                                                    .where()
                                                    .field("Enc_inpe").eq(codigo)
                                                    .execute()
                                                    .get();

                                            for(Detalle_Informacion_Personal_Anexo_1 t1 : result1){

                                                System.out.println("--------------------- "+t1.getId());

                                                LoginActivity.mClient.getTable(Detalle_Informacion_Personal_Anexo_1.class).delete(t1.getId());

                                            }



                                        } catch (InterruptedException e) {
                                            System.out.println("----------------------------FALLO UN SELECT2a");
                                            e.printStackTrace();
                                            exitoDelete[0] =false;

                                        } catch (ExecutionException e) {
                                            System.out.println("----------------------------FALLO UN SELECT2b");
                                            e.printStackTrace();
                                           exitoDelete[0] =false;

                                        } catch (Exception e) {
                                            System.out.println("----------------------------FALLO UN SELECT2c");
                                            e.printStackTrace();
                                           exitoDelete[0] =false;

                                        }

                                        System.out.println("DELETE 222222222222222222222222222222222222222222222222222222222 "+ exitoDelete[0]);

                                        return null;

                                    }
                                };

                                Boolean async2=true;

                                task2.execute();



                                @SuppressLint("StaticFieldLeak") AsyncTask<Void,Void,Void>task3 = new AsyncTask<Void, Void, Void>() {
                                    @Override
                                    protected Void doInBackground(Void... voids) {

                                        boolean x3=true;

                                        try {
                                            List<Detalle_de_Viajes_Anexo_1> result1 = LoginActivity.mClient.getTable(Detalle_de_Viajes_Anexo_1.class)
                                                    .where()
                                                    .field("Enc_dvia").eq(codigo)
                                                    .execute()
                                                    .get();

                                            for(Detalle_de_Viajes_Anexo_1 t1 : result1){

                                                System.out.println("--------------------- "+t1.getId());

                                                LoginActivity.mClient.getTable(Detalle_de_Viajes_Anexo_1.class).delete(t1.getId());

                                            }



                                        } catch (InterruptedException e) {
                                            System.out.println("----------------------------FALLO UN SELECT3a");
                                            e.printStackTrace();
                                            exitoDelete[0] =false;

                                        } catch (ExecutionException e) {
                                            System.out.println("----------------------------FALLO UN SELECT3b");
                                            e.printStackTrace();
                                            exitoDelete[0] =false;

                                        } catch (Exception e) {
                                            System.out.println("----------------------------FALLO UN SELECT3c");
                                            e.printStackTrace();
                                            exitoDelete[0] =false;

                                        }

                                        System.out.println("DELETE 33333333333333333333333333333333333333333333333333333333333333333333333 "+ exitoDelete[0]);

                                        return null;

                                    }
                                };


                                Boolean async3=true;

                                task3.execute();



                                System.out.println("DELETE FINALLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL "+ exitoDelete[0]);

                            }
                            while(!exitoDelete[0]); //SIEMPRE VA A SER TRUE PORQUE LOS 3 DEELETE SON ASYNC, CORREIGR




                            System.out.println("ESTO TIENE QUE EJECUTARSE DESPUES DEL DELETE FINALLL");

                            LoginActivity.mClient.getTable(Encuesta_1.class).insert(enc, new TableOperationCallback<Encuesta_1>() {
                                @Override
                                public void onCompleted(Encuesta_1 entity, Exception exception, ServiceFilterResponse response) {

                                    if (exception == null){

                                        System.out.println("Insercion Exitosa 1");

                                    }
                                    else{

                                        exito[0] =false;

                                    }


                                }
                            });



                            for(int f = 0; f<listaPer.size(); f++){

                                LoginActivity.mClient.getTable(Detalle_Informacion_Personal_Anexo_1.class).insert(listaPer.get(f), new TableOperationCallback<Detalle_Informacion_Personal_Anexo_1>() {
                                    @Override
                                    public void onCompleted(Detalle_Informacion_Personal_Anexo_1 entity, Exception exception, ServiceFilterResponse response) {


                                        if (exception == null) {
                                            System.out.println("Insercion Exitosa 2");


                                        }

                                        else{

                                            exception.printStackTrace();
                                            System.out.println("Insercion Fallida 2 "+exception.getMessage());

                                            exito[0] =false;


                                        }


                                    }
                                });
                            }



                            for(int g = 0; g<listaVia.size(); g++){

                                LoginActivity.mClient.getTable(Detalle_de_Viajes_Anexo_1.class).insert(listaVia.get(g), new TableOperationCallback<Detalle_de_Viajes_Anexo_1>() {

                                    @Override
                                    public void onCompleted(Detalle_de_Viajes_Anexo_1 entity, Exception exception, ServiceFilterResponse response) {


                                        if (exception == null) {
                                            System.out.println("Insercion Exitosa 3");


                                        }

                                        else{

                                            exception.printStackTrace();
                                            System.out.println("Insercion Fallida 3 "+exception.getMessage());



                                            exito[0] =false;


                                        }

                                    }
                                });
                            }



                            if(exito[0]==true){


                                System.out.println("INSERCION PERFECTA EN AZURE");

                                // SQLiteHelper h=new SQLiteHelper(getApplicationContext(),"BDEncuestasEscom", null,1);
                                SQLiteDatabase ba=help.getWritableDatabase();
                                ba.execSQL("UPDATE Encuesta_1 SET Sta_enc = 3 WHERE Id_enc = "+codigo);

                                lista.clear();

                                lista.addAll(listarBase(getApplicationContext()));

                                adapter.notifyDataSetChanged();




                            }




                        }
                        while(!exito[0]);


*/


                                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

                                LoginActivity.mClient.getTable(Encuesta_1.class).insert(enc, new TableOperationCallback<Encuesta_1>() {


                                    @Override
                                    public void onCompleted(Encuesta_1 entity, Exception exception, ServiceFilterResponse response) {


                                        if (exception == null) {
                                            System.out.println("Insercion Exitosa 1");


                                            final boolean[] abc = {true};

                                            for (int i = 0; i < listaPer.size() && abc[0] == true; i++) {

                                                LoginActivity.mClient.getTable(Detalle_Informacion_Personal_Anexo_1.class).insert(listaPer.get(i), new TableOperationCallback<Detalle_Informacion_Personal_Anexo_1>() {
                                                    @Override
                                                    public void onCompleted(Detalle_Informacion_Personal_Anexo_1 entity, Exception exception, ServiceFilterResponse response) {


                                                        if (exception == null) {
                                                            System.out.println("Insercion Exitosa 2");


                                                        } else {

                                                            exception.printStackTrace();
                                                            System.out.println("Insercion Fallida 2 " + exception.getMessage());
                                                            //DELETE IF EXISTS ALL PERSONAS
                                                            //DELETE ENCUESTA
                                                            abc[0] = false;


                                                        }


                                                    }
                                                });
                                            }


                                            if (abc[0] == true) {


                                                final boolean[] xyz = {true};

                                                for (int i = 0; i < listaVia.size() && xyz[0] == true; i++) {

                                                    LoginActivity.mClient.getTable(Detalle_de_Viajes_Anexo_1.class).insert(listaVia.get(i), new TableOperationCallback<Detalle_de_Viajes_Anexo_1>() {

                                                        @Override
                                                        public void onCompleted(Detalle_de_Viajes_Anexo_1 entity, Exception exception, ServiceFilterResponse response) {


                                                            if (exception == null) {
                                                                System.out.println("Insercion Exitosa 3");


                                                            } else {

                                                                exception.printStackTrace();
                                                                System.out.println("Insercion Fallida 3 " + exception.getMessage());
                                                                //DELETE IF EXISTS ALL VIAJES
                                                                //DELETE ALL PERSONAS
                                                                //DELETE ENCUESTA
                                                                xyz[0] = false;


                                                            }

                                                        }
                                                    });
                                                }


                                                if (xyz[0] == true) {


                                                    System.out.println("INSERCION PERFECTA EN AZURE");

                                                    // SQLiteHelper h=new SQLiteHelper(getApplicationContext(),"BDEncuestasEscom", null,1);
                                                    SQLiteDatabase ba = help.getWritableDatabase();
                                                    ba.execSQL("UPDATE Encuesta_1 SET Sta_enc = 3 WHERE Id_enc = " + codigo);

                                                    lista.clear();

                                                    lista.addAll(listarBase(getApplicationContext()));

                                                    adapter.notifyDataSetChanged();


                                                }


                                            }


                                        } else {
                                            exception.printStackTrace();
                                            System.out.println("Insercion Fallida 1" + exception.getMessage());


                                            //  LoginActivity.mClient.getTable(Encuesta_1.class).delete(enc);


                                            //DELETE IF EXISTS ENCUESTA

                                        }


                                    }
                                });


                            }

                        }

/*
                for(int i=0;i<lista.size();i++){

                    CheckBox ch=recRegistros.findViewHolderForAdapterPosition(i).itemView.findViewById(R.id.chk1);

                    if(ch.isChecked()){

                        System.out.println("bbbbbbbbbbbbbbbbbbb");

                        final EncuestaPrueba item = new EncuestaPrueba();
                        item.setCodigo(1);
                        item.setUsuario("1");                                                                                    //CAMBIAR
                        item.setNombres(lista.get(i).getNombres());
                        item.setApellidos(lista.get(i).getApellidos());
                        item.setEdad(lista.get(i).getEdad());
                        item.setNivel(lista.get(i).getNivel());
                        item.setUbicacion(lista.get(i).getUbicacion());
                        final int finalI = i;
                        LoginActivity.mClient.getTable(EncuestaPrueba.class).insert(item, new TableOperationCallback<EncuestaPrueba>() {

                            @Override
                            public void onCompleted(EncuestaPrueba entity, Exception exception, ServiceFilterResponse response) {
                                if (exception == null) {
                                    System.out.println("Insercion Exitosa");


                                    SQLiteDatabase base=helper.getWritableDatabase();
                                    int xyz=finalI+1;

                                   // base.execSQL("DELETE FROM encuesta1 WHERE ROWID='"+ finalI +1+"'");
                                    base.delete("encuesta1","rowid="+xyz,null);
                                    base.execSQL("VACUUM");
                                    base.close();

                                    System.out.println(helper.getNumeroFilas("encuesta1"+" ---------------------------------------"));




                                } else {
                                    exception.printStackTrace();
                                    System.out.println("Insercion Fallida"+exception.getMessage());
                                }
                            }
                        });
                    }
                }

*/


                    }   //CIERRE DEL OTRO ELSE

                }  // CIERRE DEL ELSE

            }
        });


    }

    public static ArrayList<Encuesta_1> listarBase(Context context){
       /* SQLiteHelper helper=new SQLiteHelper(this,"BDEncuestasEscom", null,1);
        SQLiteDatabase base=helper.getReadableDatabase();

        Cursor cursor=base.rawQuery("SELECT * FROM Encuesta_1", null);

        ArrayList<Registro> lista= new ArrayList<>();
        if(cursor.moveToFirst()){

            do{
                String nombres=cursor.getString(0);
                String apellidos=cursor.getString(1);
                int edad=cursor.getInt(2);
                int nivel=cursor.getInt(3);
                String ubicacion=cursor.getString(4);
             //   System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT "+cursor.getInt(5));

                Registro reg=new Registro();

                reg.setNombres(nombres);
                reg.setApellidos(apellidos);
                reg.setEdad(edad);
                reg.setNivel(nivel);
                reg.setUbicacion(ubicacion);
                lista.add(reg);
            }while(cursor.moveToNext());
        }
        cursor.close();

        base.close();

        return lista;
        */

        SQLite h=new SQLite(context,"BDEncuestasEscom", null,3);

        SQLiteDatabase base=h.getReadableDatabase();

        Cursor cursor=base.rawQuery("SELECT * FROM Encuesta_1 WHERE Sta_enc =?", new String []{"1"});  //EN EL FUTURO SE PODRIA CAMBIAR EL UNO POR UN VALOR EN SELECTION ARGS QUE SE PASE DESEDE EL PARAMETRO DEL METODO
        //listarBase(VALOR) PARA CUANDO SE TENGAN QUE LISTAR COMPLETAS E INCOMPLETAS

        ArrayList<Encuesta_1> lista= new ArrayList<>();


        if(cursor.moveToFirst()){

            do{
                String id=cursor.getString(cursor.getColumnIndex("Id_enc"));
                String calle=cursor.getString(cursor.getColumnIndex("Nombre_Calle"));
                String numero=cursor.getString(cursor.getColumnIndex("Num_Q2a_enc"));
                String distrito=cursor.getString(cursor.getColumnIndex("Dis_enc"));

                Encuesta_1 reg=new Encuesta_1();

                reg.setId_enc(Integer.parseInt(id));
                reg.setNombre_Calle(calle);
                reg.setNum_Q2a_enc(numero);
                reg.setDis_enc(distrito);

                lista.add(reg);
            }while(cursor.moveToNext());
        }
        cursor.close();

        base.close();

        return lista;

    }




    /*

    public void pruebaInicial(){

        SQLiteHelper helper=new SQLiteHelper(this,"BDEncuestasEscom", null,1);
        SQLiteDatabase base=helper.getReadableDatabase();




        Cursor cursor=base.rawQuery("SELECT * FROM Encuesta_1", null);

        if(cursor.moveToFirst()){

            do{

                System.out.println(cursor.getString(cursor.getColumnIndex("Id"))+"  "+cursor.getString(cursor.getColumnIndex("Id")));

                String nombres=cursor.getString(0);
                String apellidos=cursor.getString(1);
                int edad=cursor.getInt(2);
                int nivel=cursor.getInt(3);
                String ubicacion=cursor.getString(4);


            }while(cursor.moveToNext());
        }
        cursor.close();





        base.close();
    }

*/


}
