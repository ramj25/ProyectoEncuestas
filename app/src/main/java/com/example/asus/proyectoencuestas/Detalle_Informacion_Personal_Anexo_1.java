package com.example.asus.proyectoencuestas;

import java.util.ArrayList;

public class Detalle_Informacion_Personal_Anexo_1 implements InterfacePersonaViaje{

    //SE HA INCLUIDO EL CAMPO "TRANSIENT" viajes PARA EL CONJUNTO DE VIAJES ASOCIADOS A UNA PERSONA, VER ASI ESTO CAUSA PROBLEMAS AL SUBIR A AZURE!!!!!!!!!!

    private String Id;

    private String Enc_inpe;

    private int Per_inpe;

    private String Doc_inpe;

    private String Nom_inpe;

    private int Par_Q9_inpe;

    private int Sex_Q10_inpe;

    private int Edad_Q11_inpe;

    private int Disc_Q12a_inpe;

    private int Ayuv_Q12b_inpe;

    private int Ocu_Q13_inpe;

    private int Act_Q14_inpe;

    private int Lic_Q15a_inpe;

    private String Ema_Q15b_inpe;

    private String TraDis_Q16a_inpe;

    private String TraDir_Q16a_inpe;

    private String TraRef_Q16a_inpe;

    private String EstDis_Q16a_inpe;

    private String EstDir_Q16a_inpe;

    private String EstRef_Q16a_inpe;

    private String Coordenadas_Trabajo;

    private String Coordenadas_Estudio;


    private int OpeCelQ16_inpe;


    private boolean Consentimiento_Persona;

    private String Celular_Persona;

    private int ViajeMasLargo_Persona;


    private transient ArrayList<Detalle_de_Viajes_Anexo_1> viajes;



    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getEnc_inpe() {
        return Enc_inpe;
    }

    public void setEnc_inpe(String enc_inpe) {
        Enc_inpe = enc_inpe;
    }

    public int getPer_inpe() {
        return Per_inpe;
    }

    public void setPer_inpe(int per_inpe) {
        Per_inpe = per_inpe;
    }

    public String getDoc_inpe() {
        return Doc_inpe;
    }

    public void setDoc_inpe(String doc_inpe) {
        Doc_inpe = doc_inpe;
    }

    public String getNom_inpe() {
        return Nom_inpe;
    }

    public void setNom_inpe(String nom_inpe) {
        Nom_inpe = nom_inpe;
    }

    public int getPar_Q9_inpe() {
        return Par_Q9_inpe;
    }

    public void setPar_Q9_inpe(int par_Q9_inpe) {
        Par_Q9_inpe = par_Q9_inpe;
    }

    public int getSex_Q10_inpe() {
        return Sex_Q10_inpe;
    }

    public void setSex_Q10_inpe(int sex_Q10_inpe) {
        Sex_Q10_inpe = sex_Q10_inpe;
    }

    public int getEdad_Q11_inpe() {
        return Edad_Q11_inpe;
    }

    public void setEdad_Q11_inpe(int edad_Q11_inpe) {
        Edad_Q11_inpe = edad_Q11_inpe;
    }

    public int getDisc_Q12a_inpe() {
        return Disc_Q12a_inpe;
    }

    public void setDisc_Q12a_inpe(int disc_Q12a_inpe) {
        Disc_Q12a_inpe = disc_Q12a_inpe;
    }

    public int getAyuv_Q12b_inpe() {
        return Ayuv_Q12b_inpe;
    }

    public void setAyuv_Q12b_inpe(int ayuv_Q12b_inpe) {
        Ayuv_Q12b_inpe = ayuv_Q12b_inpe;
    }

    public int getOcu_Q13_inpe() {
        return Ocu_Q13_inpe;
    }

    public void setOcu_Q13_inpe(int ocu_Q13_inpe) {
        Ocu_Q13_inpe = ocu_Q13_inpe;
    }

    public int getAct_Q14_inpe() {
        return Act_Q14_inpe;
    }

    public void setAct_Q14_inpe(int act_Q14_inpe) {
        Act_Q14_inpe = act_Q14_inpe;
    }

    public int getLic_Q15a_inpe() {
        return Lic_Q15a_inpe;
    }

    public void setLic_Q15a_inpe(int lic_Q15a_inpe) {
        Lic_Q15a_inpe = lic_Q15a_inpe;
    }

    public String getEma_Q15b_inpe() {
        return Ema_Q15b_inpe;
    }

    public void setEma_Q15b_inpe(String ema_Q15b_inpe) {
        Ema_Q15b_inpe = ema_Q15b_inpe;
    }

    public String getTraDis_Q16a_inpe() {
        return TraDis_Q16a_inpe;
    }

    public void setTraDis_Q16a_inpe(String traDis_Q16a_inpe) {
        TraDis_Q16a_inpe = traDis_Q16a_inpe;
    }

    public String getTraDir_Q16a_inpe() {
        return TraDir_Q16a_inpe;
    }

    public void setTraDir_Q16a_inpe(String traDir_Q16a_inpe) {
        TraDir_Q16a_inpe = traDir_Q16a_inpe;
    }

    public String getTraRef_Q16a_inpe() {
        return TraRef_Q16a_inpe;
    }

    public void setTraRef_Q16a_inpe(String traRef_Q16a_inpe) {
        TraRef_Q16a_inpe = traRef_Q16a_inpe;
    }

    public String getEstDis_Q16a_inpe() {
        return EstDis_Q16a_inpe;
    }

    public void setEstDis_Q16a_inpe(String estDis_Q16a_inpe) {
        EstDis_Q16a_inpe = estDis_Q16a_inpe;
    }

    public String getEstDir_Q16a_inpe() {
        return EstDir_Q16a_inpe;
    }

    public void setEstDir_Q16a_inpe(String estDir_Q16a_inpe) {
        EstDir_Q16a_inpe = estDir_Q16a_inpe;
    }

    public String getEstRef_Q16a_inpe() {
        return EstRef_Q16a_inpe;
    }

    public void setEstRef_Q16a_inpe(String estRef_Q16a_inpe) {
        EstRef_Q16a_inpe = estRef_Q16a_inpe;
    }

    public String getCoordenadas_Trabajo() {
        return Coordenadas_Trabajo;
    }

    public void setCoordenadas_Trabajo(String coordenadas_Trabajo) {
        Coordenadas_Trabajo = coordenadas_Trabajo;
    }

    public String getCoordenadas_Estudio() {
        return Coordenadas_Estudio;
    }

    public void setCoordenadas_Estudio(String coordenadas_Estudio) {
        Coordenadas_Estudio = coordenadas_Estudio;
    }


    public int getOpeCelQ16_inpe() {
        return OpeCelQ16_inpe;
    }

    public void setOpeCelQ16_inpe(int opeCelQ16_inpe) {
        OpeCelQ16_inpe = opeCelQ16_inpe;
    }


    public boolean isConsentimiento_Persona() {
        return Consentimiento_Persona;
    }

    public void setConsentimiento_Persona(boolean consentimiento_Persona) {
        Consentimiento_Persona = consentimiento_Persona;
    }

    public String getCelular_Persona() {
        return Celular_Persona;
    }

    public void setCelular_Persona(String celular_Persona) {
        Celular_Persona = celular_Persona;
    }

    public int getViajeMasLargo_Persona() {
        return ViajeMasLargo_Persona;
    }

    public void setViajeMasLargo_Persona(int viajeMasLargo_Persona) {
        ViajeMasLargo_Persona = viajeMasLargo_Persona;
    }

    public ArrayList<Detalle_de_Viajes_Anexo_1> getViajes() {
        return viajes;
    }

    public void setViajes(ArrayList<Detalle_de_Viajes_Anexo_1> viajes) {
        this.viajes = viajes;
    }
}
