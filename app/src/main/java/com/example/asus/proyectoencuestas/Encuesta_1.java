package com.example.asus.proyectoencuestas;

import java.util.Calendar;

public class Encuesta_1 {


    private String Id;

    private int Id_enc;

    private String Enc_enc;

    private String Fyh_enc;

    private String Fv1_enc;

    private String Fv2_enc;

    private String Fv3_enc;

    private String Hog_enc;

    private String Dom_enc;

    private String Dis_enc;

    private int Seg_enc;

    private int Viv_enc;

    private String Sup_enc;

    private int SupM1_enc;

    private int SupM2_enc;

    private int SupM3_enc;

    private String Cod_enc;

    private int CodM1_enc;

    private int CodM2_enc;

    private int CodM3_enc;

    private String Njh_Q1_enc;

    private int Tvi_Q2a_enc;

    private String Nombre_Calle;

    private String Num_Q2a_enc;

    private String Int_Q2a_enc;

    private int Pis_Q2a_enc;

    private String Eta_Q2a_enc;

    private String Mzn_Q2a_enc;

    private String Lote_Q2a_enc;



    //private int Km_Q2a_enc;

    private double Km_Q2a_enc;



    private String Zon_Q2a_enc;

    private String Tel_Q2a_enc;

    private int NedQ3_enc;

    private int RMen6H_Q4_enc;

    private int RMen6M_Q4_enc;

    private int RMay6H_Q4_enc;

    private int RMay6M_Q4_enc;

    private int REmhH_Q4_enc;

    private int REmhM_Q4_enc;

    private int Rdt_Q5a_enc;

    private int Tviv_Q5b_enc;

    private int Hab_Q5c_enc;

    private int Ing_Q6_enc;    //INT O DOUBLE???

    private int Bici_Und_Q7_enc;

    private int Bici_Ant1_Q7_enc;

    private int Bici_Ant2_Q7_enc;

    private int Bici_Ant3_Q7_enc;

    private int Bici_Ant4_Q7_enc;

    private int Moto_Und_Q7_enc;

    private int Moto_Ant1_Q7_enc;

    private int Moto_Ant2_Q7_enc;

    private int Moto_Ant3_Q7_enc;

    private int Moto_Ant4_Q7_enc;

    private int Carro_Und_Q7_enc;

    private int Carro_Ant1_Q7_enc;

    private int Carro_Ant2_Q7_enc;

    private int Carro_Ant3_Q7_enc;

    private int Carro_Ant4_Q7_enc;

    private int Rural_Und_Q7_enc;

    private int Rural_Ant1_Q7_enc;

    private int Rural_Ant2_Q7_enc;

    private int Rural_Ant3_Q7_enc;

    private int Rural_Ant4_Q7_enc;

    private int Micro_Und_Q7_enc;

    private int Micro_Ant1_Q7_enc;

    private int Micro_Ant2_Q7_enc;

    private int Micro_Ant3_Q7_enc;

    private int Micro_Ant4_Q7_enc;

    private int Omnib_Und_Q7_enc;

    private int Omnib_Ant1_Q7_enc;

    private int Omnib_Ant2_Q7_enc;

    private int Omnib_Ant3_Q7_enc;

    private int Omnib_Ant4_Q7_enc;

    private int Camio_Und_Q7_enc;

    private int Camio_Ant1_Q7_enc;

    private int Camio_Ant2_Q7_enc;

    private int Camio_Ant3_Q7_enc;

    private int Camio_Ant4_Q7_enc;

    private int Trail_Und_Q7_enc;

    private int Trail_Ant1_Q7_enc;

    private int Trail_Ant2_Q7_enc;

    private int Trail_Ant3_Q7_enc;

    private int Trail_Ant4_Q7_enc;

    private int Otro_Und_Q7_enc;

    private int Otro_Ant1_Q7_enc;

    private int Otro_Ant2_Q7_enc;

    private int Otro_Ant3_Q7_enc;

    private int Otro_Ant4_Q7_enc;

    private boolean Telev_Q8_enc;

    private int Telev_Und_Q8_enc;

    private boolean Telef_Q8_enc;

    private int Telef_Und_Q8_enc;

    private boolean Refri_Q8_enc;

    private int Refri_Und_Q8_enc;

    private boolean Lavad_Q8_enc;

    private int Lavad_Und_Q8_enc;

    private boolean Compu_Q8_enc;

    private int Compu_Und_Q8_enc;

    private boolean Aspir_Q8_enc;

    private int Aspir_Und_Q8_enc;

    private boolean Cogas_Q8_enc;

    private int Cogas_Und_Q8_enc;

    private boolean Coele_Q8_enc;

    private int Coele_Und_Q8_enc;

    private boolean Micro_Q8_enc;

    private int Micro_Und_Q8_enc;

    private int Sta_enc;

    private String Coordenadas_Ubicacion;


    private int Numvis_enc;

    private String Zonce_enc;

    private String Manza_enc;

    private int MatPrePa_enc;

    private int MatPrePi_enc;

    private int TipAlum_enc;

    private int TipAgua_enc;

    private int TipHig_enc;

    private String Not_enc;

    private boolean Enc_Reemplazo;

    private String OtroMat_Paredes;

    private String OtroMat_Pisos;

    private String OtroTipo_Alum;

    private String OtroTipo_Agua;

    private String OtroTipo_Vehiculo;



    private int Mototaxi_Unidades;

    private int Mototaxi_Ant1;

    private int Mototaxi_Ant2;

    private int Mototaxi_Ant3;

    private int Mototaxi_Ant4;

    private int Taxi_Unidades;

    private int Taxi_Ant1;

    private int Taxi_Ant2;

    private int Taxi_Ant3;

    private int Taxi_Ant4;

    private String OtroTipo_ServHigienico;







    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getId_enc() {
        return Id_enc;
    }

    public void setId_enc(int id_enc) {
        Id_enc = id_enc;
    }

    public String getEnc_enc() {
        return Enc_enc;
    }

    public void setEnc_enc(String enc_enc) {
        Enc_enc = enc_enc;
    }

   /* public Calendar getFyh_enc() {
        return Fyh_enc;
    }

    public void setFyh_enc(Calendar fyh_enc) {
        Fyh_enc = fyh_enc;
    }
    */

    public String getFyh_enc() {
        return Fyh_enc;
    }

    public void setFyh_enc(String fyh_enc) {
        Fyh_enc = fyh_enc;
    }
/*
    public Calendar getFv1_enc() {
        return Fv1_enc;
    }

    public void setFv1_enc(Calendar fv1_enc) {
        Fv1_enc = fv1_enc;
    }

    public Calendar getFv2_enc() {
        return Fv2_enc;
    }

    public void setFv2_enc(Calendar fv2_enc) {
        Fv2_enc = fv2_enc;
    }

    public Calendar getFv3_enc() {
        return Fv3_enc;
    }

    public void setFv3_enc(Calendar fv3_enc) {
        Fv3_enc = fv3_enc;
    }
*/

    public String getFv1_enc() {
        return Fv1_enc;
    }

    public void setFv1_enc(String fv1_enc) {
        Fv1_enc = fv1_enc;
    }

    public String getFv2_enc() {
        return Fv2_enc;
    }

    public void setFv2_enc(String fv2_enc) {
        Fv2_enc = fv2_enc;
    }

    public String getFv3_enc() {
        return Fv3_enc;
    }

    public void setFv3_enc(String fv3_enc) {
        Fv3_enc = fv3_enc;
    }

    public String getHog_enc() {
        return Hog_enc;
    }

    public void setHog_enc(String hog_enc) {
        Hog_enc = hog_enc;
    }

    public String getDom_enc() {
        return Dom_enc;
    }

    public void setDom_enc(String dom_enc) {
        Dom_enc = dom_enc;
    }

    public String getDis_enc() {
        return Dis_enc;
    }

    public void setDis_enc(String dis_enc) {
        Dis_enc = dis_enc;
    }

    public int getSeg_enc() {
        return Seg_enc;
    }

    public void setSeg_enc(int seg_enc) {
        Seg_enc = seg_enc;
    }

    public int getViv_enc() {
        return Viv_enc;
    }

    public void setViv_enc(int viv_enc) {
        Viv_enc = viv_enc;
    }

    public String getSup_enc() {
        return Sup_enc;
    }

    public void setSup_enc(String sup_enc) {
        Sup_enc = sup_enc;
    }

    public int getSupM1_enc() {
        return SupM1_enc;
    }

    public void setSupM1_enc(int supM1_enc) {
        SupM1_enc = supM1_enc;
    }

    public int getSupM2_enc() {
        return SupM2_enc;
    }

    public void setSupM2_enc(int supM2_enc) {
        SupM2_enc = supM2_enc;
    }

    public int getSupM3_enc() {
        return SupM3_enc;
    }

    public void setSupM3_enc(int supM3_enc) {
        SupM3_enc = supM3_enc;
    }

    public String getCod_enc() {
        return Cod_enc;
    }

    public void setCod_enc(String cod_enc) {
        Cod_enc = cod_enc;
    }

    public int getCodM1_enc() {
        return CodM1_enc;
    }

    public void setCodM1_enc(int codM1_enc) {
        CodM1_enc = codM1_enc;
    }

    public int getCodM2_enc() {
        return CodM2_enc;
    }

    public void setCodM2_enc(int codM2_enc) {
        CodM2_enc = codM2_enc;
    }

    public int getCodM3_enc() {
        return CodM3_enc;
    }

    public void setCodM3_enc(int codM3_enc) {
        CodM3_enc = codM3_enc;
    }

    public String getNjh_Q1_enc() {
        return Njh_Q1_enc;
    }

    public void setNjh_Q1_enc(String njh_Q1_enc) {
        Njh_Q1_enc = njh_Q1_enc;
    }

    public int getTvi_Q2a_enc() {
        return Tvi_Q2a_enc;
    }

    public void setTvi_Q2a_enc(int tvi_Q2a_enc) {
        Tvi_Q2a_enc = tvi_Q2a_enc;
    }

    public String getNombre_Calle() {
        return Nombre_Calle;
    }

    public void setNombre_Calle(String nombre_Calle) {
        Nombre_Calle = nombre_Calle;
    }

    public String getNum_Q2a_enc() {
        return Num_Q2a_enc;
    }

    public void setNum_Q2a_enc(String num_Q2a_enc) {
        Num_Q2a_enc = num_Q2a_enc;
    }

    public String getInt_Q2a_enc() {
        return Int_Q2a_enc;
    }

    public void setInt_Q2a_enc(String int_Q2a_enc) {
        Int_Q2a_enc = int_Q2a_enc;
    }

    public int getPis_Q2a_enc() {
        return Pis_Q2a_enc;
    }

    public void setPis_Q2a_enc(int pis_Q2a_enc) {
        Pis_Q2a_enc = pis_Q2a_enc;
    }

    public String getEta_Q2a_enc() {
        return Eta_Q2a_enc;
    }

    public void setEta_Q2a_enc(String eta_Q2a_enc) {
        Eta_Q2a_enc = eta_Q2a_enc;
    }

    public String getMzn_Q2a_enc() {
        return Mzn_Q2a_enc;
    }

    public void setMzn_Q2a_enc(String mzn_Q2a_enc) {
        Mzn_Q2a_enc = mzn_Q2a_enc;
    }

    public String getLote_Q2a_enc() {
        return Lote_Q2a_enc;
    }

    public void setLote_Q2a_enc(String lote_Q2a_enc) {
        Lote_Q2a_enc = lote_Q2a_enc;
    }


/*
    public int getKm_Q2a_enc() {
        return Km_Q2a_enc;
    }

    public void setKm_Q2a_enc(int km_Q2a_enc) {
        Km_Q2a_enc = km_Q2a_enc;
    }
 */


    public double getKm_Q2a_enc() {
        return Km_Q2a_enc;
    }

    public void setKm_Q2a_enc(double km_Q2a_enc) {
        Km_Q2a_enc = km_Q2a_enc;
    }

    public String getZon_Q2a_enc() {
        return Zon_Q2a_enc;
    }

    public void setZon_Q2a_enc(String zon_Q2a_enc) {
        Zon_Q2a_enc = zon_Q2a_enc;
    }

    public String getTel_Q2a_enc() {
        return Tel_Q2a_enc;
    }

    public void setTel_Q2a_enc(String tel_Q2a_enc) {
        Tel_Q2a_enc = tel_Q2a_enc;
    }

    public int getNedQ3_enc() {
        return NedQ3_enc;
    }

    public void setNedQ3_enc(int nedQ3_enc) {
        NedQ3_enc = nedQ3_enc;
    }

    public int getRMen6H_Q4_enc() {
        return RMen6H_Q4_enc;
    }

    public void setRMen6H_Q4_enc(int RMen6H_Q4_enc) {
        this.RMen6H_Q4_enc = RMen6H_Q4_enc;
    }

    public int getRMen6M_Q4_enc() {
        return RMen6M_Q4_enc;
    }

    public void setRMen6M_Q4_enc(int RMen6M_Q4_enc) {
        this.RMen6M_Q4_enc = RMen6M_Q4_enc;
    }

    public int getRMay6H_Q4_enc() {
        return RMay6H_Q4_enc;
    }

    public void setRMay6H_Q4_enc(int RMay6H_Q4_enc) {
        this.RMay6H_Q4_enc = RMay6H_Q4_enc;
    }

    public int getRMay6M_Q4_enc() {
        return RMay6M_Q4_enc;
    }

    public void setRMay6M_Q4_enc(int RMay6M_Q4_enc) {
        this.RMay6M_Q4_enc = RMay6M_Q4_enc;
    }

    public int getREmhH_Q4_enc() {
        return REmhH_Q4_enc;
    }

    public void setREmhH_Q4_enc(int REmhH_Q4_enc) {
        this.REmhH_Q4_enc = REmhH_Q4_enc;
    }

    public int getREmhM_Q4_enc() {
        return REmhM_Q4_enc;
    }

    public void setREmhM_Q4_enc(int REmhM_Q4_enc) {
        this.REmhM_Q4_enc = REmhM_Q4_enc;
    }

    public int getRdt_Q5a_enc() {
        return Rdt_Q5a_enc;
    }

    public void setRdt_Q5a_enc(int rdt_Q5a_enc) {
        Rdt_Q5a_enc = rdt_Q5a_enc;
    }

    public int getTviv_Q5b_enc() {
        return Tviv_Q5b_enc;
    }

    public void setTviv_Q5b_enc(int tviv_Q5b_enc) {
        Tviv_Q5b_enc = tviv_Q5b_enc;
    }

    public int getHab_Q5c_enc() {
        return Hab_Q5c_enc;
    }

    public void setHab_Q5c_enc(int hab_Q5c_enc) {
        Hab_Q5c_enc = hab_Q5c_enc;
    }

    public int getIng_Q6_enc() {
        return Ing_Q6_enc;
    }

    public void setIng_Q6_enc(int ing_Q6_enc) {
        Ing_Q6_enc = ing_Q6_enc;
    }

    public int getBici_Und_Q7_enc() {
        return Bici_Und_Q7_enc;
    }

    public void setBici_Und_Q7_enc(int bici_Und_Q7_enc) {
        Bici_Und_Q7_enc = bici_Und_Q7_enc;
    }

    public int getBici_Ant1_Q7_enc() {
        return Bici_Ant1_Q7_enc;
    }

    public void setBici_Ant1_Q7_enc(int bici_Ant1_Q7_enc) {
        Bici_Ant1_Q7_enc = bici_Ant1_Q7_enc;
    }

    public int getBici_Ant2_Q7_enc() {
        return Bici_Ant2_Q7_enc;
    }

    public void setBici_Ant2_Q7_enc(int bici_Ant2_Q7_enc) {
        Bici_Ant2_Q7_enc = bici_Ant2_Q7_enc;
    }

    public int getBici_Ant3_Q7_enc() {
        return Bici_Ant3_Q7_enc;
    }

    public void setBici_Ant3_Q7_enc(int bici_Ant3_Q7_enc) {
        Bici_Ant3_Q7_enc = bici_Ant3_Q7_enc;
    }

    public int getBici_Ant4_Q7_enc() {
        return Bici_Ant4_Q7_enc;
    }

    public void setBici_Ant4_Q7_enc(int bici_Ant4_Q7_enc) {
        Bici_Ant4_Q7_enc = bici_Ant4_Q7_enc;
    }

    public int getMoto_Und_Q7_enc() {
        return Moto_Und_Q7_enc;
    }

    public void setMoto_Und_Q7_enc(int moto_Und_Q7_enc) {
        Moto_Und_Q7_enc = moto_Und_Q7_enc;
    }

    public int getMoto_Ant1_Q7_enc() {
        return Moto_Ant1_Q7_enc;
    }

    public void setMoto_Ant1_Q7_enc(int moto_Ant1_Q7_enc) {
        Moto_Ant1_Q7_enc = moto_Ant1_Q7_enc;
    }

    public int getMoto_Ant2_Q7_enc() {
        return Moto_Ant2_Q7_enc;
    }

    public void setMoto_Ant2_Q7_enc(int moto_Ant2_Q7_enc) {
        Moto_Ant2_Q7_enc = moto_Ant2_Q7_enc;
    }

    public int getMoto_Ant3_Q7_enc() {
        return Moto_Ant3_Q7_enc;
    }

    public void setMoto_Ant3_Q7_enc(int moto_Ant3_Q7_enc) {
        Moto_Ant3_Q7_enc = moto_Ant3_Q7_enc;
    }

    public int getMoto_Ant4_Q7_enc() {
        return Moto_Ant4_Q7_enc;
    }

    public void setMoto_Ant4_Q7_enc(int moto_Ant4_Q7_enc) {
        Moto_Ant4_Q7_enc = moto_Ant4_Q7_enc;
    }

    public int getCarro_Und_Q7_enc() {
        return Carro_Und_Q7_enc;
    }

    public void setCarro_Und_Q7_enc(int carro_Und_Q7_enc) {
        Carro_Und_Q7_enc = carro_Und_Q7_enc;
    }

    public int getCarro_Ant1_Q7_enc() {
        return Carro_Ant1_Q7_enc;
    }

    public void setCarro_Ant1_Q7_enc(int carro_Ant1_Q7_enc) {
        Carro_Ant1_Q7_enc = carro_Ant1_Q7_enc;
    }

    public int getCarro_Ant2_Q7_enc() {
        return Carro_Ant2_Q7_enc;
    }

    public void setCarro_Ant2_Q7_enc(int carro_Ant2_Q7_enc) {
        Carro_Ant2_Q7_enc = carro_Ant2_Q7_enc;
    }

    public int getCarro_Ant3_Q7_enc() {
        return Carro_Ant3_Q7_enc;
    }

    public void setCarro_Ant3_Q7_enc(int carro_Ant3_Q7_enc) {
        Carro_Ant3_Q7_enc = carro_Ant3_Q7_enc;
    }

    public int getCarro_Ant4_Q7_enc() {
        return Carro_Ant4_Q7_enc;
    }

    public void setCarro_Ant4_Q7_enc(int carro_Ant4_Q7_enc) {
        Carro_Ant4_Q7_enc = carro_Ant4_Q7_enc;
    }

    public int getRural_Und_Q7_enc() {
        return Rural_Und_Q7_enc;
    }

    public void setRural_Und_Q7_enc(int rural_Und_Q7_enc) {
        Rural_Und_Q7_enc = rural_Und_Q7_enc;
    }

    public int getRural_Ant1_Q7_enc() {
        return Rural_Ant1_Q7_enc;
    }

    public void setRural_Ant1_Q7_enc(int rural_Ant1_Q7_enc) {
        Rural_Ant1_Q7_enc = rural_Ant1_Q7_enc;
    }

    public int getRural_Ant2_Q7_enc() {
        return Rural_Ant2_Q7_enc;
    }

    public void setRural_Ant2_Q7_enc(int rural_Ant2_Q7_enc) {
        Rural_Ant2_Q7_enc = rural_Ant2_Q7_enc;
    }

    public int getRural_Ant3_Q7_enc() {
        return Rural_Ant3_Q7_enc;
    }

    public void setRural_Ant3_Q7_enc(int rural_Ant3_Q7_enc) {
        Rural_Ant3_Q7_enc = rural_Ant3_Q7_enc;
    }

    public int getRural_Ant4_Q7_enc() {
        return Rural_Ant4_Q7_enc;
    }

    public void setRural_Ant4_Q7_enc(int rural_Ant4_Q7_enc) {
        Rural_Ant4_Q7_enc = rural_Ant4_Q7_enc;
    }

    public int getMicro_Und_Q7_enc() {
        return Micro_Und_Q7_enc;
    }

    public void setMicro_Und_Q7_enc(int micro_Und_Q7_enc) {
        Micro_Und_Q7_enc = micro_Und_Q7_enc;
    }

    public int getMicro_Ant1_Q7_enc() {
        return Micro_Ant1_Q7_enc;
    }

    public void setMicro_Ant1_Q7_enc(int micro_Ant1_Q7_enc) {
        Micro_Ant1_Q7_enc = micro_Ant1_Q7_enc;
    }

    public int getMicro_Ant2_Q7_enc() {
        return Micro_Ant2_Q7_enc;
    }

    public void setMicro_Ant2_Q7_enc(int micro_Ant2_Q7_enc) {
        Micro_Ant2_Q7_enc = micro_Ant2_Q7_enc;
    }

    public int getMicro_Ant3_Q7_enc() {
        return Micro_Ant3_Q7_enc;
    }

    public void setMicro_Ant3_Q7_enc(int micro_Ant3_Q7_enc) {
        Micro_Ant3_Q7_enc = micro_Ant3_Q7_enc;
    }

    public int getMicro_Ant4_Q7_enc() {
        return Micro_Ant4_Q7_enc;
    }

    public void setMicro_Ant4_Q7_enc(int micro_Ant4_Q7_enc) {
        Micro_Ant4_Q7_enc = micro_Ant4_Q7_enc;
    }

    public int getOmnib_Und_Q7_enc() {
        return Omnib_Und_Q7_enc;
    }

    public void setOmnib_Und_Q7_enc(int omnib_Und_Q7_enc) {
        Omnib_Und_Q7_enc = omnib_Und_Q7_enc;
    }

    public int getOmnib_Ant1_Q7_enc() {
        return Omnib_Ant1_Q7_enc;
    }

    public void setOmnib_Ant1_Q7_enc(int omnib_Ant1_Q7_enc) {
        Omnib_Ant1_Q7_enc = omnib_Ant1_Q7_enc;
    }

    public int getOmnib_Ant2_Q7_enc() {
        return Omnib_Ant2_Q7_enc;
    }

    public void setOmnib_Ant2_Q7_enc(int omnib_Ant2_Q7_enc) {
        Omnib_Ant2_Q7_enc = omnib_Ant2_Q7_enc;
    }

    public int getOmnib_Ant3_Q7_enc() {
        return Omnib_Ant3_Q7_enc;
    }

    public void setOmnib_Ant3_Q7_enc(int omnib_Ant3_Q7_enc) {
        Omnib_Ant3_Q7_enc = omnib_Ant3_Q7_enc;
    }

    public int getOmnib_Ant4_Q7_enc() {
        return Omnib_Ant4_Q7_enc;
    }

    public void setOmnib_Ant4_Q7_enc(int omnib_Ant4_Q7_enc) {
        Omnib_Ant4_Q7_enc = omnib_Ant4_Q7_enc;
    }

    public int getCamio_Und_Q7_enc() {
        return Camio_Und_Q7_enc;
    }

    public void setCamio_Und_Q7_enc(int camio_Und_Q7_enc) {
        Camio_Und_Q7_enc = camio_Und_Q7_enc;
    }

    public int getCamio_Ant1_Q7_enc() {
        return Camio_Ant1_Q7_enc;
    }

    public void setCamio_Ant1_Q7_enc(int camio_Ant1_Q7_enc) {
        Camio_Ant1_Q7_enc = camio_Ant1_Q7_enc;
    }

    public int getCamio_Ant2_Q7_enc() {
        return Camio_Ant2_Q7_enc;
    }

    public void setCamio_Ant2_Q7_enc(int camio_Ant2_Q7_enc) {
        Camio_Ant2_Q7_enc = camio_Ant2_Q7_enc;
    }

    public int getCamio_Ant3_Q7_enc() {
        return Camio_Ant3_Q7_enc;
    }

    public void setCamio_Ant3_Q7_enc(int camio_Ant3_Q7_enc) {
        Camio_Ant3_Q7_enc = camio_Ant3_Q7_enc;
    }

    public int getCamio_Ant4_Q7_enc() {
        return Camio_Ant4_Q7_enc;
    }

    public void setCamio_Ant4_Q7_enc(int camio_Ant4_Q7_enc) {
        Camio_Ant4_Q7_enc = camio_Ant4_Q7_enc;
    }

    public int getTrail_Und_Q7_enc() {
        return Trail_Und_Q7_enc;
    }

    public void setTrail_Und_Q7_enc(int trail_Und_Q7_enc) {
        Trail_Und_Q7_enc = trail_Und_Q7_enc;
    }

    public int getTrail_Ant1_Q7_enc() {
        return Trail_Ant1_Q7_enc;
    }

    public void setTrail_Ant1_Q7_enc(int trail_Ant1_Q7_enc) {
        Trail_Ant1_Q7_enc = trail_Ant1_Q7_enc;
    }

    public int getTrail_Ant2_Q7_enc() {
        return Trail_Ant2_Q7_enc;
    }

    public void setTrail_Ant2_Q7_enc(int trail_Ant2_Q7_enc) {
        Trail_Ant2_Q7_enc = trail_Ant2_Q7_enc;
    }

    public int getTrail_Ant3_Q7_enc() {
        return Trail_Ant3_Q7_enc;
    }

    public void setTrail_Ant3_Q7_enc(int trail_Ant3_Q7_enc) {
        Trail_Ant3_Q7_enc = trail_Ant3_Q7_enc;
    }

    public int getTrail_Ant4_Q7_enc() {
        return Trail_Ant4_Q7_enc;
    }

    public void setTrail_Ant4_Q7_enc(int trail_Ant4_Q7_enc) {
        Trail_Ant4_Q7_enc = trail_Ant4_Q7_enc;
    }

    public int getOtro_Und_Q7_enc() {
        return Otro_Und_Q7_enc;
    }

    public void setOtro_Und_Q7_enc(int otro_Und_Q7_enc) {
        Otro_Und_Q7_enc = otro_Und_Q7_enc;
    }

    public int getOtro_Ant1_Q7_enc() {
        return Otro_Ant1_Q7_enc;
    }

    public void setOtro_Ant1_Q7_enc(int otro_Ant1_Q7_enc) {
        Otro_Ant1_Q7_enc = otro_Ant1_Q7_enc;
    }

    public int getOtro_Ant2_Q7_enc() {
        return Otro_Ant2_Q7_enc;
    }

    public void setOtro_Ant2_Q7_enc(int otro_Ant2_Q7_enc) {
        Otro_Ant2_Q7_enc = otro_Ant2_Q7_enc;
    }

    public int getOtro_Ant3_Q7_enc() {
        return Otro_Ant3_Q7_enc;
    }

    public void setOtro_Ant3_Q7_enc(int otro_Ant3_Q7_enc) {
        Otro_Ant3_Q7_enc = otro_Ant3_Q7_enc;
    }

    public int getOtro_Ant4_Q7_enc() {
        return Otro_Ant4_Q7_enc;
    }

    public void setOtro_Ant4_Q7_enc(int otro_Ant4_Q7_enc) {
        Otro_Ant4_Q7_enc = otro_Ant4_Q7_enc;
    }

    public boolean isTelev_Q8_enc() {
        return Telev_Q8_enc;
    }

    public void setTelev_Q8_enc(boolean telev_Q8_enc) {
        Telev_Q8_enc = telev_Q8_enc;
    }

    public int getTelev_Und_Q8_enc() {
        return Telev_Und_Q8_enc;
    }

    public void setTelev_Und_Q8_enc(int telev_Und_Q8_enc) {
        Telev_Und_Q8_enc = telev_Und_Q8_enc;
    }

    public boolean isTelef_Q8_enc() {
        return Telef_Q8_enc;
    }

    public void setTelef_Q8_enc(boolean telef_Q8_enc) {
        Telef_Q8_enc = telef_Q8_enc;
    }

    public int getTelef_Und_Q8_enc() {
        return Telef_Und_Q8_enc;
    }

    public void setTelef_Und_Q8_enc(int telef_Und_Q8_enc) {
        Telef_Und_Q8_enc = telef_Und_Q8_enc;
    }

    public boolean isRefri_Q8_enc() {
        return Refri_Q8_enc;
    }

    public void setRefri_Q8_enc(boolean refri_Q8_enc) {
        Refri_Q8_enc = refri_Q8_enc;
    }

    public int getRefri_Und_Q8_enc() {
        return Refri_Und_Q8_enc;
    }

    public void setRefri_Und_Q8_enc(int refri_Und_Q8_enc) {
        Refri_Und_Q8_enc = refri_Und_Q8_enc;
    }

    public boolean isLavad_Q8_enc() {
        return Lavad_Q8_enc;
    }

    public void setLavad_Q8_enc(boolean lavad_Q8_enc) {
        Lavad_Q8_enc = lavad_Q8_enc;
    }

    public int getLavad_Und_Q8_enc() {
        return Lavad_Und_Q8_enc;
    }

    public void setLavad_Und_Q8_enc(int lavad_Und_Q8_enc) {
        Lavad_Und_Q8_enc = lavad_Und_Q8_enc;
    }

    public boolean isCompu_Q8_enc() {
        return Compu_Q8_enc;
    }

    public void setCompu_Q8_enc(boolean compu_Q8_enc) {
        Compu_Q8_enc = compu_Q8_enc;
    }

    public int getCompu_Und_Q8_enc() {
        return Compu_Und_Q8_enc;
    }

    public void setCompu_Und_Q8_enc(int compu_Und_Q8_enc) {
        Compu_Und_Q8_enc = compu_Und_Q8_enc;
    }

    public boolean isAspir_Q8_enc() {
        return Aspir_Q8_enc;
    }

    public void setAspir_Q8_enc(boolean aspir_Q8_enc) {
        Aspir_Q8_enc = aspir_Q8_enc;
    }

    public int getAspir_Und_Q8_enc() {
        return Aspir_Und_Q8_enc;
    }

    public void setAspir_Und_Q8_enc(int aspir_Und_Q8_enc) {
        Aspir_Und_Q8_enc = aspir_Und_Q8_enc;
    }

    public boolean isCogas_Q8_enc() {
        return Cogas_Q8_enc;
    }

    public void setCogas_Q8_enc(boolean cogas_Q8_enc) {
        Cogas_Q8_enc = cogas_Q8_enc;
    }

    public int getCogas_Und_Q8_enc() {
        return Cogas_Und_Q8_enc;
    }

    public void setCogas_Und_Q8_enc(int cogas_Und_Q8_enc) {
        Cogas_Und_Q8_enc = cogas_Und_Q8_enc;
    }

    public boolean isCoele_Q8_enc() {
        return Coele_Q8_enc;
    }

    public void setCoele_Q8_enc(boolean coele_Q8_enc) {
        Coele_Q8_enc = coele_Q8_enc;
    }

    public int getCoele_Und_Q8_enc() {
        return Coele_Und_Q8_enc;
    }

    public void setCoele_Und_Q8_enc(int coele_Und_Q8_enc) {
        Coele_Und_Q8_enc = coele_Und_Q8_enc;
    }

    public boolean isMicro_Q8_enc() {
        return Micro_Q8_enc;
    }

    public void setMicro_Q8_enc(boolean micro_Q8_enc) {
        Micro_Q8_enc = micro_Q8_enc;
    }

    public int getMicro_Und_Q8_enc() {
        return Micro_Und_Q8_enc;
    }

    public void setMicro_Und_Q8_enc(int micro_Und_Q8_enc) {
        Micro_Und_Q8_enc = micro_Und_Q8_enc;
    }

    public int getSta_enc() {
        return Sta_enc;
    }

    public void setSta_enc(int sta_enc) {
        Sta_enc = sta_enc;
    }



    public String getCoordenadas_Ubicacion() {
        return Coordenadas_Ubicacion;
    }

    public void setCoordenadas_Ubicacion(String coordenadas_Ubicacion) {
        Coordenadas_Ubicacion = coordenadas_Ubicacion;
    }


    public int getNumvis_enc() {
        return Numvis_enc;
    }

    public void setNumvis_enc(int numvis_enc) {
        Numvis_enc = numvis_enc;
    }

    public String getZonce_enc() {
        return Zonce_enc;
    }

    public void setZonce_enc(String zonce_enc) {
        Zonce_enc = zonce_enc;
    }

    public String getManza_enc() {
        return Manza_enc;
    }

    public void setManza_enc(String manza_enc) {
        Manza_enc = manza_enc;
    }

    public int getMatPrePa_enc() {
        return MatPrePa_enc;
    }

    public void setMatPrePa_enc(int matPrePa_enc) {
        MatPrePa_enc = matPrePa_enc;
    }

    public int getMatPrePi_enc() {
        return MatPrePi_enc;
    }

    public void setMatPrePi_enc(int matPrePi_enc) {
        MatPrePi_enc = matPrePi_enc;
    }

    public int getTipAlum_enc() {
        return TipAlum_enc;
    }

    public void setTipAlum_enc(int tipAlum_enc) {
        TipAlum_enc = tipAlum_enc;
    }

    public int getTipAgua_enc() {
        return TipAgua_enc;
    }

    public void setTipAgua_enc(int tipAgua_enc) {
        TipAgua_enc = tipAgua_enc;
    }

    public int getTipHig_enc() {
        return TipHig_enc;
    }

    public void setTipHig_enc(int tipHig_enc) {
        TipHig_enc = tipHig_enc;
    }

    public String getNot_enc() {
        return Not_enc;
    }

    public void setNot_enc(String not_enc) {
        Not_enc = not_enc;
    }

    public boolean isEnc_Reemplazo() {
        return Enc_Reemplazo;
    }

    public void setEnc_Reemplazo(boolean enc_Reemplazo) {
        Enc_Reemplazo = enc_Reemplazo;
    }

    public String getOtroMat_Paredes() {
        return OtroMat_Paredes;
    }

    public void setOtroMat_Paredes(String otroMat_Paredes) {
        OtroMat_Paredes = otroMat_Paredes;
    }

    public String getOtroMat_Pisos() {
        return OtroMat_Pisos;
    }

    public void setOtroMat_Pisos(String otroMat_Pisos) {
        OtroMat_Pisos = otroMat_Pisos;
    }

    public String getOtroTipo_Alum() {
        return OtroTipo_Alum;
    }

    public void setOtroTipo_Alum(String otroTipo_Alum) {
        OtroTipo_Alum = otroTipo_Alum;
    }

    public String getOtroTipo_Agua() {
        return OtroTipo_Agua;
    }

    public void setOtroTipo_Agua(String otroTipo_Agua) {
        OtroTipo_Agua = otroTipo_Agua;
    }

    public String getOtroTipo_Vehiculo() {
        return OtroTipo_Vehiculo;
    }

    public void setOtroTipo_Vehiculo(String otroTipo_Vehiculo) {
        OtroTipo_Vehiculo = otroTipo_Vehiculo;
    }


    public int getMototaxi_Unidades() {
        return Mototaxi_Unidades;
    }

    public void setMototaxi_Unidades(int mototaxi_Unidades) {
        Mototaxi_Unidades = mototaxi_Unidades;
    }

    public int getMototaxi_Ant1() {
        return Mototaxi_Ant1;
    }

    public void setMototaxi_Ant1(int mototaxi_Ant1) {
        Mototaxi_Ant1 = mototaxi_Ant1;
    }

    public int getMototaxi_Ant2() {
        return Mototaxi_Ant2;
    }

    public void setMototaxi_Ant2(int mototaxi_Ant2) {
        Mototaxi_Ant2 = mototaxi_Ant2;
    }

    public int getMototaxi_Ant3() {
        return Mototaxi_Ant3;
    }

    public void setMototaxi_Ant3(int mototaxi_Ant3) {
        Mototaxi_Ant3 = mototaxi_Ant3;
    }

    public int getMototaxi_Ant4() {
        return Mototaxi_Ant4;
    }

    public void setMototaxi_Ant4(int mototaxi_Ant4) {
        Mototaxi_Ant4 = mototaxi_Ant4;
    }

    public int getTaxi_Unidades() {
        return Taxi_Unidades;
    }

    public void setTaxi_Unidades(int taxi_Unidades) {
        Taxi_Unidades = taxi_Unidades;
    }

    public int getTaxi_Ant1() {
        return Taxi_Ant1;
    }

    public void setTaxi_Ant1(int taxi_Ant1) {
        Taxi_Ant1 = taxi_Ant1;
    }

    public int getTaxi_Ant2() {
        return Taxi_Ant2;
    }

    public void setTaxi_Ant2(int taxi_Ant2) {
        Taxi_Ant2 = taxi_Ant2;
    }

    public int getTaxi_Ant3() {
        return Taxi_Ant3;
    }

    public void setTaxi_Ant3(int taxi_Ant3) {
        Taxi_Ant3 = taxi_Ant3;
    }

    public int getTaxi_Ant4() {
        return Taxi_Ant4;
    }

    public void setTaxi_Ant4(int taxi_Ant4) {
        Taxi_Ant4 = taxi_Ant4;
    }

    public String getOtroTipo_ServHigienico() {
        return OtroTipo_ServHigienico;
    }

    public void setOtroTipo_ServHigienico(String otroTipo_ServHigienico) {
        OtroTipo_ServHigienico = otroTipo_ServHigienico;
    }
}
