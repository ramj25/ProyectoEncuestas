package com.example.asus.proyectoencuestas;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite extends SQLiteOpenHelper {   //SE MODIFICO LA VERSION DE LA BASE DE DATOS EN LAS 4 INSTANCIAS DE LA CLASE SQLite


    //ANTIGUAS TABLAS ENCUESTA 1:

    String crearTabla="CREATE TABLE Encuesta_1(Id TEXT,Id_enc INTEGER,Enc_enc TEXT,Fyh_enc TEXT,Fv1_enc TEXT,Fv2_enc TEXT,Fv3_enc TEXT,Hog_enc TEXT,Dom_enc TEXT,Dis_enc TEXT,Seg_enc INTEGER,Viv_enc INTEGER,Sup_enc TEXT,SupM1_enc INTEGER,SupM2_enc INTEGER,SupM3_enc INTEGER,Cod_enc TEXT,CodM1_enc INTEGER,CodM2_enc INTEGER,CodM3_enc INTEGER,Njh_Q1_enc TEXT,Tvi_Q2a_enc INTEGER,Nombre_Calle TEXT,Num_Q2a_enc TEXT,Int_Q2a_enc TEXT,Pis_Q2a_enc INTEGER,Eta_Q2a_enc TEXT,Mzn_Q2a_enc TEXT,Lote_Q2a_enc TEXT,Km_Q2a_enc INTEGER,Zon_Q2a_enc TEXT,Tel_Q2a_enc TEXT,NedQ3_enc INTEGER,RMen6H_Q4_enc INTEGER,RMen6M_Q4_enc INTEGER,RMay6H_Q4_enc INTEGER,RMay6M_Q4_enc INTEGER,REmhH_Q4_enc INTEGER,REmhM_Q4_enc INTEGER,Rdt_Q5a_enc INTEGER,Tviv_Q5b_enc INTEGER,Hab_Q5c_enc INTEGER,Ing_Q6_enc INTEGER,Bici_Und_Q7_enc INTEGER,Bici_Ant1_Q7_enc INTEGER,Bici_Ant2_Q7_enc INTEGER,Bici_Ant3_Q7_enc INTEGER,Bici_Ant4_Q7_enc INTEGER,Moto_Und_Q7_enc INTEGER,Moto_Ant1_Q7_enc INTEGER,Moto_Ant2_Q7_enc INTEGER,Moto_Ant3_Q7_enc INTEGER,Moto_Ant4_Q7_enc INTEGER,Carro_Und_Q7_enc INTEGER,Carro_Ant1_Q7_enc INTEGER,Carro_Ant2_Q7_enc INTEGER,Carro_Ant3_Q7_enc INTEGER,Carro_Ant4_Q7_enc INTEGER,Rural_Und_Q7_enc INTEGER,Rural_Ant1_Q7_enc INTEGER,Rural_Ant2_Q7_enc INTEGER,Rural_Ant3_Q7_enc INTEGER,Rural_Ant4_Q7_enc INTEGER,Micro_Und_Q7_enc INTEGER,Micro_Ant1_Q7_enc INTEGER,Micro_Ant2_Q7_enc INTEGER,Micro_Ant3_Q7_enc INTEGER,Micro_Ant4_Q7_enc INTEGER,Omnib_Und_Q7_enc INTEGER,Omnib_Ant1_Q7_enc INTEGER,Omnib_Ant2_Q7_enc INTEGER,Omnib_Ant3_Q7_enc INTEGER,Omnib_Ant4_Q7_enc INTEGER,Camio_Und_Q7_enc INTEGER,Camio_Ant1_Q7_enc INTEGER,Camio_Ant2_Q7_enc INTEGER,Camio_Ant3_Q7_enc INTEGER,Camio_Ant4_Q7_enc INTEGER,Trail_Und_Q7_enc INTEGER,Trail_Ant1_Q7_enc INTEGER,Trail_Ant2_Q7_enc INTEGER,Trail_Ant3_Q7_enc INTEGER,Trail_Ant4_Q7_enc INTEGER,Otro_Und_Q7_enc INTEGER,Otro_Ant1_Q7_enc INTEGER,Otro_Ant2_Q7_enc INTEGER,Otro_Ant3_Q7_enc INTEGER,Otro_Ant4_Q7_enc INTEGER,Telev_Q8_enc INTEGER,Telev_Und_Q8_enc INTEGER,Telef_Q8_enc INTEGER,Telef_Und_Q8_enc INTEGER,Refri_Q8_enc INTEGER,Refri_Und_Q8_enc INTEGER,Lavad_Q8_enc INTEGER,Lavad_Und_Q8_enc INTEGER,Compu_Q8_enc INTEGER,Compu_Und_Q8_enc INTEGER,Aspir_Q8_enc INTEGER,Aspir_Und_Q8_enc INTEGER,Cogas_Q8_enc INTEGER,Cogas_Und_Q8_enc INTEGER,Coele_Q8_enc INTEGER,Coele_Und_Q8_enc INTEGER,Micro_Q8_enc INTEGER,Micro_Und_Q8_enc INTEGER,Sta_enc INTEGER)";

    String crearTablaPersonas="CREATE TABLE Detalle_Informacion_Personal_Anexo_1(Id TEXT,Enc_inpe TEXT,Per_inpe INTEGER,Doc_inpe TEXT,Nom_inpe TEXT,Par_Q9_inpe INTEGER,Sex_Q10_inpe INTEGER,Edad_Q11_inpe INTEGER,Disc_Q12a_inpe INTEGER,Ayuv_Q12b_inpe INTEGER,Ocu_Q13_inpe INTEGER,Act_Q14_inpe INTEGER,Lic_Q15a_inpe INTEGER,Ema_Q15b_inpe TEXT,TraDis_Q16a_inpe TEXT,TraDir_Q16a_inpe TEXT,TraRef_Q16a_inpe TEXT,EstDis_Q16a_inpe TEXT,EstDir_Q16a_inpe TEXT,EstRef_Q16a_inpe TEXT)";

    String crearTablaViajes="CREATE TABLE Detalle_de_Viajes_Anexo_1(Id TEXT,Enc_dvia TEXT,Per_dvia INTEGER,Via_dvia INTEGER,Doc_Encuestador TEXT,OriDis_Q17_dvia TEXT,OriDir_Q17_dvia TEXT,OriRef_Q17_dvia TEXT,OriZtra_Q17_dvia TEXT,OriLug_Q18_dvia INTEGER,OriHor_Q19_dvia INTEGER,OriMin_Q19_dvia INTEGER,OriAmPm_Q19_dvia INTEGER,DesDis_Q20_dvia TEXT,DesDir_Q20_dvia TEXT,DesRef_Q20_dvia TEXT,DesZtra_Q20_dvia TEXT,DesLug_Q21_dvia INTEGER,DesHor_Q22_dvia INTEGER,DesMin_Q22_dvia INTEGER,DesAmPm_Q22_dvia INTEGER,Pro_Q23_dvia INTEGER,TraMed1_Q24a_dvia INTEGER,TraTpo1_Q24b_dvia INTEGER,TraCos1_Q24c_dvia INTEGER,Transb12_Q24d_dvia TEXT,Transb12_Q24e_dvia INTEGER,TraMed2_Q24a_dvia INTEGER,TraTpo2_Q24b_dvia INTEGER,TraCos2_Q24c_dvia INTEGER,Transb23_Q24d_dvia TEXT,Transb23_Q24e_dvia INTEGER,TraMed3_Q24a_dvia INTEGER,TraTpo3_Q24b_dvia INTEGER,TraCos3_Q24c_dvia INTEGER,Transb34_Q24d_dvia TEXT,Transb34_Q24e_dvia INTEGER,TraMed4_Q24a_dvia INTEGER,TraTpo4_Q24b_dvia INTEGER,TraCos4_Q24c_dvia INTEGER,Transb45_Q24d_dvia TEXT,Transb45_Q24e_dvia INTEGER,TraMed5_Q24a_dvia INTEGER,TraTpo5_Q24b_dvia INTEGER,TraCos5_Q24c_dvia INTEGER,Transb56_Q24d_dvia TEXT,Transb56_Q24e_dvia INTEGER,TraMed6_Q24a_dvia INTEGER,TraTpo6_Q24b_dvia INTEGER,TraCos6_Q24c_dvia INTEGER,Transb67_Q24d_dvia TEXT,Transb67_Q24e_dvia INTEGER,TraMed7_Q24a_dvia INTEGER,TraTpo7_Q24b_dvia INTEGER,TraCos7_Q24c_dvia INTEGER,Mcar_Q25_dvia INTEGER,Esta_Q26a_dvia INTEGER,Pago_Q26b_dvia INTEGER,Tar_Q26c_dvia INTEGER,TraRazem1_Q29_dvia INTEGER,Tranutp1_Q30_dvia INTEGER,NdsBusDis_Q30_dvia INTEGER,NdsBusTpo_Q30_dvia INTEGER,NdsBusTar_Q30_dvia REAL,NdsBustrb_Q30_dvia INTEGER,NdsTaxiDis_Q30_dvia INTEGER,NdsTaxiTpo_Q30_dvia INTEGER,NdsTaxiTar_Q30_dvia INTEGER,NdsCarroTpo_Q30_dvia INTEGER,NdsCarroCos_Q30_dvia INTEGER,NdsCarroPea_Q30_dvia REAL,NdsCarroEsta_Q30_dvia REAL)";



    //TABLAS ACTUALES ENCUESTA 1:

    String crearTablaUsuarios="CREATE TABLE Usuarios_Encuestas(Doc_usr TEXT,Pwd_usr TEXT,Sup_usr TEXT,Car_usr INTEGER,Dom_usr INTEGER,Sta_usr INTEGER,Enc1_usr INTEGER,Enc6_usr INTEGER)";

    String crearTablaSeguimiento="CREATE TABLE Seguimiento_Encuesta_1(Id_seg INTEGER,Enc_seg TEXT,Doc_seg TEXT,Freg_seg TEXT,Lugi_seg TEXT,Fgra_seg TEXT,Lugg_seg TEXT,Per_seg INTEGER,Pers_seg INTEGER,Vias_Seg INTEGER,Not_seg TEXT)";


    String crearTablaV2="CREATE TABLE Encuesta_1(Id TEXT,Id_enc INTEGER,Enc_enc TEXT,Fyh_enc TEXT,Fv1_enc TEXT,Fv2_enc TEXT,Fv3_enc TEXT,Hog_enc TEXT,Dom_enc TEXT,Dis_enc TEXT,Seg_enc INTEGER,Viv_enc INTEGER,Sup_enc TEXT,SupM1_enc INTEGER,SupM2_enc INTEGER,SupM3_enc INTEGER,Cod_enc TEXT,CodM1_enc INTEGER,CodM2_enc INTEGER,CodM3_enc INTEGER,Njh_Q1_enc TEXT,Tvi_Q2a_enc INTEGER,Nombre_Calle TEXT,Num_Q2a_enc TEXT,Int_Q2a_enc TEXT,Pis_Q2a_enc INTEGER,Eta_Q2a_enc TEXT,Mzn_Q2a_enc TEXT,Lote_Q2a_enc TEXT,Km_Q2a_enc INTEGER,Zon_Q2a_enc TEXT,Tel_Q2a_enc TEXT,NedQ3_enc INTEGER,RMen6H_Q4_enc INTEGER,RMen6M_Q4_enc INTEGER,RMay6H_Q4_enc INTEGER,RMay6M_Q4_enc INTEGER,REmhH_Q4_enc INTEGER,REmhM_Q4_enc INTEGER,Rdt_Q5a_enc INTEGER,Tviv_Q5b_enc INTEGER,Hab_Q5c_enc INTEGER,Ing_Q6_enc INTEGER,Bici_Und_Q7_enc INTEGER,Bici_Ant1_Q7_enc INTEGER,Bici_Ant2_Q7_enc INTEGER,Bici_Ant3_Q7_enc INTEGER,Bici_Ant4_Q7_enc INTEGER,Moto_Und_Q7_enc INTEGER,Moto_Ant1_Q7_enc INTEGER,Moto_Ant2_Q7_enc INTEGER,Moto_Ant3_Q7_enc INTEGER,Moto_Ant4_Q7_enc INTEGER,Carro_Und_Q7_enc INTEGER,Carro_Ant1_Q7_enc INTEGER,Carro_Ant2_Q7_enc INTEGER,Carro_Ant3_Q7_enc INTEGER,Carro_Ant4_Q7_enc INTEGER,Rural_Und_Q7_enc INTEGER,Rural_Ant1_Q7_enc INTEGER,Rural_Ant2_Q7_enc INTEGER,Rural_Ant3_Q7_enc INTEGER,Rural_Ant4_Q7_enc INTEGER,Micro_Und_Q7_enc INTEGER,Micro_Ant1_Q7_enc INTEGER,Micro_Ant2_Q7_enc INTEGER,Micro_Ant3_Q7_enc INTEGER,Micro_Ant4_Q7_enc INTEGER,Omnib_Und_Q7_enc INTEGER,Omnib_Ant1_Q7_enc INTEGER,Omnib_Ant2_Q7_enc INTEGER,Omnib_Ant3_Q7_enc INTEGER,Omnib_Ant4_Q7_enc INTEGER,Camio_Und_Q7_enc INTEGER,Camio_Ant1_Q7_enc INTEGER,Camio_Ant2_Q7_enc INTEGER,Camio_Ant3_Q7_enc INTEGER,Camio_Ant4_Q7_enc INTEGER,Trail_Und_Q7_enc INTEGER,Trail_Ant1_Q7_enc INTEGER,Trail_Ant2_Q7_enc INTEGER,Trail_Ant3_Q7_enc INTEGER,Trail_Ant4_Q7_enc INTEGER,Otro_Und_Q7_enc INTEGER,Otro_Ant1_Q7_enc INTEGER,Otro_Ant2_Q7_enc INTEGER,Otro_Ant3_Q7_enc INTEGER,Otro_Ant4_Q7_enc INTEGER,Telev_Q8_enc INTEGER,Telev_Und_Q8_enc INTEGER,Telef_Q8_enc INTEGER,Telef_Und_Q8_enc INTEGER,Refri_Q8_enc INTEGER,Refri_Und_Q8_enc INTEGER,Lavad_Q8_enc INTEGER,Lavad_Und_Q8_enc INTEGER,Compu_Q8_enc INTEGER,Compu_Und_Q8_enc INTEGER,Aspir_Q8_enc INTEGER,Aspir_Und_Q8_enc INTEGER,Cogas_Q8_enc INTEGER,Cogas_Und_Q8_enc INTEGER,Coele_Q8_enc INTEGER,Coele_Und_Q8_enc INTEGER,Micro_Q8_enc INTEGER,Micro_Und_Q8_enc INTEGER,Sta_enc INTEGER,Not_enc TEXT,Numvis_enc INTEGER,MatPrePa_enc INTEGER,MatPrePi_enc INTEGER,TipAlum_enc INTEGER,TipAgua_enc INTEGER,TipHig_enc INTEGER,Enc_Reemplazo INTEGER,Zonce_enc TEXT,Manza_enc TEXT,Coordenadas_Ubicacion TEXT,OtroMat_Paredes TEXT,OtroMat_Pisos TEXT,OtroTipo_Alum TEXT,OtroTipo_Agua TEXT,OtroTipo_Vehiculo TEXT)";

    String crearTablaPersonasV2="CREATE TABLE Detalle_Informacion_Personal_Anexo_1(Id TEXT,Enc_inpe TEXT,Per_inpe INTEGER,Doc_inpe TEXT,Nom_inpe TEXT,Par_Q9_inpe INTEGER,Sex_Q10_inpe INTEGER,Edad_Q11_inpe INTEGER,Disc_Q12a_inpe INTEGER,Ayuv_Q12b_inpe INTEGER,Ocu_Q13_inpe INTEGER,Act_Q14_inpe INTEGER,Lic_Q15a_inpe INTEGER,Ema_Q15b_inpe TEXT,TraDis_Q16a_inpe TEXT,TraDir_Q16a_inpe TEXT,TraRef_Q16a_inpe TEXT,EstDis_Q16a_inpe TEXT,EstDir_Q16a_inpe TEXT,EstRef_Q16a_inpe TEXT,OpeCelQ16_inpe INTEGER)";

    String crearTablaViajesV2="CREATE TABLE Detalle_de_Viajes_Anexo_1(Id TEXT,Enc_dvia TEXT,Per_dvia INTEGER,Via_dvia INTEGER,Doc_Encuestador TEXT,OriDis_Q17_dvia TEXT,OriDir_Q17_dvia TEXT,OriRef_Q17_dvia TEXT,OriZtra_Q17_dvia TEXT,OriLug_Q18_dvia INTEGER,OriHor_Q19_dvia INTEGER,OriMin_Q19_dvia INTEGER,OriAmPm_Q19_dvia INTEGER,DesDis_Q20_dvia TEXT,DesDir_Q20_dvia TEXT,DesRef_Q20_dvia TEXT,DesZtra_Q20_dvia TEXT,DesLug_Q21_dvia INTEGER,DesHor_Q22_dvia INTEGER,DesMin_Q22_dvia INTEGER,DesAmPm_Q22_dvia INTEGER,Pro_Q23_dvia INTEGER,TraMed1_Q24a_dvia INTEGER,TraTpo1_Q24b_dvia INTEGER,TraCos1_Q24c_dvia INTEGER,Transb12_Q24d_dvia TEXT,Transb12_Q24e_dvia INTEGER,TraMed2_Q24a_dvia INTEGER,TraTpo2_Q24b_dvia INTEGER,TraCos2_Q24c_dvia INTEGER,Transb23_Q24d_dvia TEXT,Transb23_Q24e_dvia INTEGER,TraMed3_Q24a_dvia INTEGER,TraTpo3_Q24b_dvia INTEGER,TraCos3_Q24c_dvia INTEGER,Transb34_Q24d_dvia TEXT,Transb34_Q24e_dvia INTEGER,TraMed4_Q24a_dvia INTEGER,TraTpo4_Q24b_dvia INTEGER,TraCos4_Q24c_dvia INTEGER,Transb45_Q24d_dvia TEXT,Transb45_Q24e_dvia INTEGER,TraMed5_Q24a_dvia INTEGER,TraTpo5_Q24b_dvia INTEGER,TraCos5_Q24c_dvia INTEGER,Transb56_Q24d_dvia TEXT,Transb56_Q24e_dvia INTEGER,TraMed6_Q24a_dvia INTEGER,TraTpo6_Q24b_dvia INTEGER,TraCos6_Q24c_dvia INTEGER,Transb67_Q24d_dvia TEXT,Transb67_Q24e_dvia INTEGER,TraMed7_Q24a_dvia INTEGER,TraTpo7_Q24b_dvia INTEGER,TraCos7_Q24c_dvia INTEGER,Mcar_Q25_dvia INTEGER,Esta_Q26a_dvia INTEGER,Pago_Q26b_dvia INTEGER,Tar_Q26c_dvia INTEGER,TraRazem1_Q29_dvia INTEGER,Tranutp1_Q30_dvia INTEGER,NdsBusDis_Q30_dvia INTEGER,NdsBusTpo_Q30_dvia INTEGER,NdsBusTar_Q30_dvia REAL,NdsBustrb_Q30_dvia INTEGER,NdsTaxiDis_Q30_dvia INTEGER,NdsTaxiTpo_Q30_dvia INTEGER,NdsTaxiTar_Q30_dvia INTEGER,NdsCarroTpo_Q30_dvia INTEGER,NdsCarroCos_Q30_dvia INTEGER,NdsCarroPea_Q30_dvia REAL,NdsCarroEsta_Q30_dvia REAL,PeaViaQ26d_dvia REAL,FreViaQ26e_dvia INTEGER,Coordenadas_Origen TEXT,Coordenadas_Destino TEXT,VialarQ27_dvia INTEGER,MedQ28_dvia INTEGER,PqnutpQ30_dvia INTEGER,ConsenQ31_dvia INTEGER,NumCelQ32_dvia INTEGER,Total_Viajes INTEGER,Dia_Viaje TEXT,Mes_Viaje TEXT)";



    String crearTablaV3="CREATE TABLE Encuesta_1(Id TEXT,Id_enc INTEGER,Enc_enc TEXT,Fyh_enc TEXT,Fv1_enc TEXT,Fv2_enc TEXT,Fv3_enc TEXT,Hog_enc TEXT,Dom_enc TEXT,Dis_enc TEXT,Seg_enc INTEGER,Viv_enc INTEGER,Sup_enc TEXT,SupM1_enc INTEGER,SupM2_enc INTEGER,SupM3_enc INTEGER,Cod_enc TEXT,CodM1_enc INTEGER,CodM2_enc INTEGER,CodM3_enc INTEGER,Njh_Q1_enc TEXT,Tvi_Q2a_enc INTEGER,Nombre_Calle TEXT,Num_Q2a_enc TEXT,Int_Q2a_enc TEXT,Pis_Q2a_enc INTEGER,Eta_Q2a_enc TEXT,Mzn_Q2a_enc TEXT,Lote_Q2a_enc TEXT,Km_Q2a_enc INTEGER,Zon_Q2a_enc TEXT,Tel_Q2a_enc TEXT,NedQ3_enc INTEGER,RMen6H_Q4_enc INTEGER,RMen6M_Q4_enc INTEGER,RMay6H_Q4_enc INTEGER,RMay6M_Q4_enc INTEGER,REmhH_Q4_enc INTEGER,REmhM_Q4_enc INTEGER,Rdt_Q5a_enc INTEGER,Tviv_Q5b_enc INTEGER,Hab_Q5c_enc INTEGER,Ing_Q6_enc INTEGER,Bici_Und_Q7_enc INTEGER,Bici_Ant1_Q7_enc INTEGER,Bici_Ant2_Q7_enc INTEGER,Bici_Ant3_Q7_enc INTEGER,Bici_Ant4_Q7_enc INTEGER,Moto_Und_Q7_enc INTEGER,Moto_Ant1_Q7_enc INTEGER,Moto_Ant2_Q7_enc INTEGER,Moto_Ant3_Q7_enc INTEGER,Moto_Ant4_Q7_enc INTEGER,Carro_Und_Q7_enc INTEGER,Carro_Ant1_Q7_enc INTEGER,Carro_Ant2_Q7_enc INTEGER,Carro_Ant3_Q7_enc INTEGER,Carro_Ant4_Q7_enc INTEGER,Rural_Und_Q7_enc INTEGER,Rural_Ant1_Q7_enc INTEGER,Rural_Ant2_Q7_enc INTEGER,Rural_Ant3_Q7_enc INTEGER,Rural_Ant4_Q7_enc INTEGER,Micro_Und_Q7_enc INTEGER,Micro_Ant1_Q7_enc INTEGER,Micro_Ant2_Q7_enc INTEGER,Micro_Ant3_Q7_enc INTEGER,Micro_Ant4_Q7_enc INTEGER,Omnib_Und_Q7_enc INTEGER,Omnib_Ant1_Q7_enc INTEGER,Omnib_Ant2_Q7_enc INTEGER,Omnib_Ant3_Q7_enc INTEGER,Omnib_Ant4_Q7_enc INTEGER,Camio_Und_Q7_enc INTEGER,Camio_Ant1_Q7_enc INTEGER,Camio_Ant2_Q7_enc INTEGER,Camio_Ant3_Q7_enc INTEGER,Camio_Ant4_Q7_enc INTEGER,Trail_Und_Q7_enc INTEGER,Trail_Ant1_Q7_enc INTEGER,Trail_Ant2_Q7_enc INTEGER,Trail_Ant3_Q7_enc INTEGER,Trail_Ant4_Q7_enc INTEGER,Otro_Und_Q7_enc INTEGER,Otro_Ant1_Q7_enc INTEGER,Otro_Ant2_Q7_enc INTEGER,Otro_Ant3_Q7_enc INTEGER,Otro_Ant4_Q7_enc INTEGER,Telev_Q8_enc INTEGER,Telev_Und_Q8_enc INTEGER,Telef_Q8_enc INTEGER,Telef_Und_Q8_enc INTEGER,Refri_Q8_enc INTEGER,Refri_Und_Q8_enc INTEGER,Lavad_Q8_enc INTEGER,Lavad_Und_Q8_enc INTEGER,Compu_Q8_enc INTEGER,Compu_Und_Q8_enc INTEGER,Aspir_Q8_enc INTEGER,Aspir_Und_Q8_enc INTEGER,Cogas_Q8_enc INTEGER,Cogas_Und_Q8_enc INTEGER,Coele_Q8_enc INTEGER,Coele_Und_Q8_enc INTEGER,Micro_Q8_enc INTEGER,Micro_Und_Q8_enc INTEGER,Sta_enc INTEGER,Not_enc TEXT,Numvis_enc INTEGER,MatPrePa_enc INTEGER,MatPrePi_enc INTEGER,TipAlum_enc INTEGER,TipAgua_enc INTEGER,TipHig_enc INTEGER,Enc_Reemplazo INTEGER,Zonce_enc TEXT,Manza_enc TEXT,Coordenadas_Ubicacion TEXT,OtroMat_Paredes TEXT,OtroMat_Pisos TEXT,OtroTipo_Alum TEXT,OtroTipo_Agua TEXT,OtroTipo_Vehiculo TEXT,Mototaxi_Unidades INTEGER,Mototaxi_Ant1 INTEGER,Mototaxi_Ant2 INTEGER,Mototaxi_Ant3 INTEGER,Mototaxi_Ant4 INTEGER,Taxi_Unidades INTEGER,Taxi_Ant1 INTEGER,Taxi_Ant2 INTEGER,Taxi_Ant3 INTEGER,Taxi_Ant4 INTEGER,OtroTipo_ServHigienico TEXT)";

    String crearTablaPersonasV3="CREATE TABLE Detalle_Informacion_Personal_Anexo_1(Id TEXT,Enc_inpe TEXT,Per_inpe INTEGER,Doc_inpe TEXT,Nom_inpe TEXT,Par_Q9_inpe INTEGER,Sex_Q10_inpe INTEGER,Edad_Q11_inpe INTEGER,Disc_Q12a_inpe INTEGER,Ayuv_Q12b_inpe INTEGER,Ocu_Q13_inpe INTEGER,Act_Q14_inpe INTEGER,Lic_Q15a_inpe INTEGER,Ema_Q15b_inpe TEXT,TraDis_Q16a_inpe TEXT,TraDir_Q16a_inpe TEXT,TraRef_Q16a_inpe TEXT,EstDis_Q16a_inpe TEXT,EstDir_Q16a_inpe TEXT,EstRef_Q16a_inpe TEXT,OpeCelQ16_inpe INTEGER,Consentimiento_Persona INTEGER,Celular_Persona TEXT,ViajeMasLargo_Persona INTEGER)";

    String crearTablaViajesV3="CREATE TABLE Detalle_de_Viajes_Anexo_1(Id TEXT,Enc_dvia TEXT,Per_dvia INTEGER,Via_dvia INTEGER,Doc_Encuestador TEXT,OriDis_Q17_dvia TEXT,OriDir_Q17_dvia TEXT,OriRef_Q17_dvia TEXT,OriZtra_Q17_dvia TEXT,OriLug_Q18_dvia INTEGER,OriHor_Q19_dvia INTEGER,OriMin_Q19_dvia INTEGER,OriAmPm_Q19_dvia INTEGER,DesDis_Q20_dvia TEXT,DesDir_Q20_dvia TEXT,DesRef_Q20_dvia TEXT,DesZtra_Q20_dvia TEXT,DesLug_Q21_dvia INTEGER,DesHor_Q22_dvia INTEGER,DesMin_Q22_dvia INTEGER,DesAmPm_Q22_dvia INTEGER,Pro_Q23_dvia INTEGER,TraMed1_Q24a_dvia INTEGER,TraTpo1_Q24b_dvia INTEGER,TraCos1_Q24c_dvia INTEGER,Transb12_Q24d_dvia TEXT,Transb12_Q24e_dvia INTEGER,TraMed2_Q24a_dvia INTEGER,TraTpo2_Q24b_dvia INTEGER,TraCos2_Q24c_dvia INTEGER,Transb23_Q24d_dvia TEXT,Transb23_Q24e_dvia INTEGER,TraMed3_Q24a_dvia INTEGER,TraTpo3_Q24b_dvia INTEGER,TraCos3_Q24c_dvia INTEGER,Transb34_Q24d_dvia TEXT,Transb34_Q24e_dvia INTEGER,TraMed4_Q24a_dvia INTEGER,TraTpo4_Q24b_dvia INTEGER,TraCos4_Q24c_dvia INTEGER,Transb45_Q24d_dvia TEXT,Transb45_Q24e_dvia INTEGER,TraMed5_Q24a_dvia INTEGER,TraTpo5_Q24b_dvia INTEGER,TraCos5_Q24c_dvia INTEGER,Transb56_Q24d_dvia TEXT,Transb56_Q24e_dvia INTEGER,TraMed6_Q24a_dvia INTEGER,TraTpo6_Q24b_dvia INTEGER,TraCos6_Q24c_dvia INTEGER,Transb67_Q24d_dvia TEXT,Transb67_Q24e_dvia INTEGER,TraMed7_Q24a_dvia INTEGER,TraTpo7_Q24b_dvia INTEGER,TraCos7_Q24c_dvia INTEGER,Mcar_Q25_dvia INTEGER,Esta_Q26a_dvia INTEGER,Pago_Q26b_dvia INTEGER,Tar_Q26c_dvia INTEGER,TraRazem1_Q29_dvia INTEGER,Tranutp1_Q30_dvia INTEGER,NdsBusDis_Q30_dvia INTEGER,NdsBusTpo_Q30_dvia INTEGER,NdsBusTar_Q30_dvia REAL,NdsBustrb_Q30_dvia INTEGER,NdsTaxiDis_Q30_dvia INTEGER,NdsTaxiTpo_Q30_dvia INTEGER,NdsTaxiTar_Q30_dvia INTEGER,NdsCarroTpo_Q30_dvia INTEGER,NdsCarroCos_Q30_dvia INTEGER,NdsCarroPea_Q30_dvia REAL,NdsCarroEsta_Q30_dvia REAL,PeaViaQ26d_dvia REAL,FreViaQ26e_dvia INTEGER,Coordenadas_Origen TEXT,Coordenadas_Destino TEXT,VialarQ27_dvia INTEGER,MedQ28_dvia INTEGER,PqnutpQ30_dvia INTEGER,ConsenQ31_dvia INTEGER,NumCelQ32_dvia INTEGER,Total_Viajes INTEGER,Dia_Viaje TEXT,Mes_Viaje TEXT,OtraFrecuenciaViaje TEXT,Fecha_Viaje TEXT)";






    public SQLite(Context context, String nombreBD, SQLiteDatabase.CursorFactory factory, int version){

        super(context,nombreBD,factory,version);

    }


    public long numeroFilas(String nombreTabla) {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, nombreTabla);
        db.close();
        return count;
    }


    public long numeroColumnas(String nombreTabla){

        Cursor cursor = getReadableDatabase().query(nombreTabla, null, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.getColumnCount() > 0) {
                return cursor.getColumnCount();
            } else {
                return 0;
            }
        } else {
            return 0;
        }

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        /*
        db.execSQL(crearTabla);

        db.execSQL(crearTablaPersonas);

        db.execSQL(crearTablaViajes);
*/



        db.execSQL(crearTablaUsuarios);

        db.execSQL(crearTablaSeguimiento);

        db.execSQL(crearTablaV3);  //antes V2

        db.execSQL(crearTablaPersonasV3);  //ANTES V2

        db.execSQL(crearTablaViajesV3);  //antes V2


        System.out.println("--------------------------------------------------------------------------------------------------------- BASE DE DATOS CREADA!");


    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        if (oldVersion < 2) {


            db.execSQL(crearTablaUsuarios);

            db.execSQL(crearTablaSeguimiento);



            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN Not_enc TEXT");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN Numvis_enc INTEGER");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN MatPrePa_enc INTEGER");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN MatPrePi_enc INTEGER");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN TipAlum_enc INTEGER");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN TipAgua_enc INTEGER");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN TipHig_enc INTEGER");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN Enc_Reemplazo INTEGER");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN Zonce_enc TEXT");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN Manza_enc TEXT");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN Coordenadas_Ubicacion TEXT");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN OtroMat_Paredes TEXT");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN OtroMat_Pisos TEXT");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN OtroTipo_Alum TEXT");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN OtroTipo_Agua TEXT");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN OtroTipo_Vehiculo TEXT");


            db.execSQL("ALTER TABLE Detalle_Informacion_Personal_Anexo_1 ADD COLUMN OpeCelQ16_inpe INTEGER");


            db.execSQL("ALTER TABLE Detalle_de_Viajes_Anexo_1 ADD COLUMN PeaViaQ26d_dvia REAL");

            db.execSQL("ALTER TABLE Detalle_de_Viajes_Anexo_1 ADD COLUMN FreViaQ26e_dvia INTEGER");

            db.execSQL("ALTER TABLE Detalle_de_Viajes_Anexo_1 ADD COLUMN Coordenadas_Origen TEXT");

            db.execSQL("ALTER TABLE Detalle_de_Viajes_Anexo_1 ADD COLUMN Coordenadas_Destino TEXT");

            db.execSQL("ALTER TABLE Detalle_de_Viajes_Anexo_1 ADD COLUMN VialarQ27_dvia INTEGER");

            db.execSQL("ALTER TABLE Detalle_de_Viajes_Anexo_1 ADD COLUMN MedQ28_dvia INTEGER");

         //   db.execSQL("ALTER TABLE Detalle_de_Viajes_Anexo_1 ADD COLUMN TraRazem1_Q29_dvia INTEGER");

            db.execSQL("ALTER TABLE Detalle_de_Viajes_Anexo_1 ADD COLUMN PqnutpQ30_dvia INTEGER");

            db.execSQL("ALTER TABLE Detalle_de_Viajes_Anexo_1 ADD COLUMN ConsenQ31_dvia INTEGER");

            db.execSQL("ALTER TABLE Detalle_de_Viajes_Anexo_1 ADD COLUMN NumCelQ32_dvia INTEGER");

            db.execSQL("ALTER TABLE Detalle_de_Viajes_Anexo_1 ADD COLUMN Total_Viajes INTEGER");

            db.execSQL("ALTER TABLE Detalle_de_Viajes_Anexo_1 ADD COLUMN Dia_Viaje TEXT");

            db.execSQL("ALTER TABLE Detalle_de_Viajes_Anexo_1 ADD COLUMN Mes_Viaje TEXT");




            System.out.println("-------------------------------------------------------------------------------------------------------------- (UPGRADE A VERSION 2)");


            }



        if (oldVersion < 3){


            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN Mototaxi_Unidades INTEGER");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN Mototaxi_Ant1 INTEGER");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN Mototaxi_Ant2 INTEGER");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN Mototaxi_Ant3 INTEGER");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN Mototaxi_Ant4 INTEGER");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN Taxi_Unidades INTEGER");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN Taxi_Ant1 INTEGER");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN Taxi_Ant2 INTEGER");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN Taxi_Ant3 INTEGER");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN Taxi_Ant4 INTEGER");

            db.execSQL("ALTER TABLE Encuesta_1 ADD COLUMN OtroTipo_ServHigienico TEXT");


            db.execSQL("ALTER TABLE Detalle_Informacion_Personal_Anexo_1 ADD COLUMN Consentimiento_Persona INTEGER");

            db.execSQL("ALTER TABLE Detalle_Informacion_Personal_Anexo_1 ADD COLUMN Celular_Persona TEXT");

            db.execSQL("ALTER TABLE Detalle_Informacion_Personal_Anexo_1 ADD COLUMN ViajeMasLargo_Persona INTEGER");


            db.execSQL("ALTER TABLE Detalle_de_Viajes_Anexo_1 ADD COLUMN OtraFrecuenciaViaje TEXT");

            db.execSQL("ALTER TABLE Detalle_de_Viajes_Anexo_1 ADD COLUMN Fecha_Viaje TEXT");



            System.out.println("-------------------------------------------------------------------------------------------------------------- (UPGRADE A VERSION 3)");
        }



            System.out.println("-------------------------------------------------------------------------------------------------------------- UPGRADE DISPARADO");

    }
}
