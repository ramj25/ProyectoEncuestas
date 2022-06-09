package com.example.asus.proyectoencuestas;

public class Detalle_de_Viajes_Anexo_1 implements InterfacePersonaViaje{


    private String Id;

    private String Enc_dvia;

    private int Per_dvia;

    private int Via_dvia;

    private String Doc_Encuestador;

    private String OriDis_Q17_dvia;

    private String OriDir_Q17_dvia;

    private String OriRef_Q17_dvia;

    private String OriZtra_Q17_dvia;  //String??

    private int OriLug_Q18_dvia;

    private int OriHor_Q19_dvia;

    private int OriMin_Q19_dvia;

    private int OriAmPm_Q19_dvia;

    private String DesDis_Q20_dvia;

    private String DesDir_Q20_dvia;

    private String DesRef_Q20_dvia;

    private String DesZtra_Q20_dvia;  //String??

    private int DesLug_Q21_dvia;

    private int DesHor_Q22_dvia;

    private int DesMin_Q22_dvia;

    private int DesAmPm_Q22_dvia;

    private int Pro_Q23_dvia;

    private int TraMed1_Q24a_dvia;

    private int TraTpo1_Q24b_dvia;

    private double TraCos1_Q24c_dvia;                  // SE CAMBIARON LOS 7 COSTOS DE TRAMO!

    private String Transb12_Q24d_dvia;

    private int Transb12_Q24e_dvia;  //Tipo??

    private int TraMed2_Q24a_dvia;

    private int TraTpo2_Q24b_dvia;

    private double TraCos2_Q24c_dvia;

    private String Transb23_Q24d_dvia;

    private int Transb23_Q24e_dvia; //Tipo??

    private int TraMed3_Q24a_dvia;

    private int TraTpo3_Q24b_dvia;

    private double TraCos3_Q24c_dvia;

    private String Transb34_Q24d_dvia;

    private int Transb34_Q24e_dvia; //Tipo??

    private int TraMed4_Q24a_dvia;

    private int TraTpo4_Q24b_dvia;

    private double TraCos4_Q24c_dvia;

    private String Transb45_Q24d_dvia;

    private int Transb45_Q24e_dvia; //Tipo??

    private int TraMed5_Q24a_dvia;

    private int TraTpo5_Q24b_dvia;

    private double TraCos5_Q24c_dvia;

    private String Transb56_Q24d_dvia;

    private int Transb56_Q24e_dvia; //Tipo??

    private int TraMed6_Q24a_dvia;

    private int TraTpo6_Q24b_dvia;

    private double TraCos6_Q24c_dvia;

    private String Transb67_Q24d_dvia;

    private int Transb67_Q24e_dvia; //Tipo??

    private int TraMed7_Q24a_dvia;

    private int TraTpo7_Q24b_dvia;

    private double TraCos7_Q24c_dvia;

    private int Mcar_Q25_dvia;

    private int Esta_Q26a_dvia;

    private int Pago_Q26b_dvia;

   // private int Tar_Q26c_dvia;

    private double Tar_Q26c_dvia;

    private int TraRazem1_Q29_dvia;

    private int Tranutp1_Q30_dvia;

    private int NdsBusDis_Q30_dvia;

    private int NdsBusTpo_Q30_dvia;

    private double NdsBusTar_Q30_dvia;      //VER SI HAY PROBLEMAS CON ESTE Y LOS 2 ULTIMOS REGISTROS A LA HORA DE SUBIR A LA BASE DE DATOS POR SER DOUBLE (AHORA 3)

    private int NdsBustrb_Q30_dvia;

    private int NdsTaxiDis_Q30_dvia;

    private int NdsTaxiTpo_Q30_dvia;

    private int NdsTaxiTar_Q30_dvia;

    private int NdsCarroTpo_Q30_dvia;

    private int NdsCarroCos_Q30_dvia;

    private double NdsCarroPea_Q30_dvia;

    private double NdsCarroEsta_Q30_dvia;

    private String Coordenadas_Origen;

    private String Coordenadas_Destino;


    private double PeaViaQ26d_dvia;

    private int FreViaQ26e_dvia;

    private boolean VialarQ27_dvia;

    private int MedQ28_dvia;

    private int PqnutpQ30_dvia;

    private boolean ConsenQ31_dvia;

    private int NumCelQ32_dvia;

    private int Total_Viajes;

    private String Dia_Viaje;

    private String Mes_Viaje;


    private String OtraFrecuenciaViaje;

    private String Fecha_Viaje;





    public String getDoc_Encuestador() {
        return Doc_Encuestador;
    }

    public void setDoc_Encuestador(String doc_Encuestador) {
        Doc_Encuestador = doc_Encuestador;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getEnc_dvia() {
        return Enc_dvia;
    }

    public void setEnc_dvia(String enc_dvia) {
        Enc_dvia = enc_dvia;
    }

    public int getPer_dvia() {
        return Per_dvia;
    }

    public void setPer_dvia(int per_dvia) {
        Per_dvia = per_dvia;
    }

    public int getVia_dvia() {
        return Via_dvia;
    }

    public void setVia_dvia(int via_dvia) {
        Via_dvia = via_dvia;
    }

    public String getOriDis_Q17_dvia() {
        return OriDis_Q17_dvia;
    }

    public void setOriDis_Q17_dvia(String oriDis_Q17_dvia) {
        OriDis_Q17_dvia = oriDis_Q17_dvia;
    }

    public String getOriDir_Q17_dvia() {
        return OriDir_Q17_dvia;
    }

    public void setOriDir_Q17_dvia(String oriDir_Q17_dvia) {
        OriDir_Q17_dvia = oriDir_Q17_dvia;
    }

    public String getOriRef_Q17_dvia() {
        return OriRef_Q17_dvia;
    }

    public void setOriRef_Q17_dvia(String oriRef_Q17_dvia) {
        OriRef_Q17_dvia = oriRef_Q17_dvia;
    }

    public String getOriZtra_Q17_dvia() {
        return OriZtra_Q17_dvia;
    }

    public void setOriZtra_Q17_dvia(String oriZtra_Q17_dvia) {
        OriZtra_Q17_dvia = oriZtra_Q17_dvia;
    }

    public int getOriLug_Q18_dvia() {
        return OriLug_Q18_dvia;
    }

    public void setOriLug_Q18_dvia(int oriLug_Q18_dvia) {
        OriLug_Q18_dvia = oriLug_Q18_dvia;
    }

    public int getOriHor_Q19_dvia() {
        return OriHor_Q19_dvia;
    }

    public void setOriHor_Q19_dvia(int oriHor_Q19_dvia) {
        OriHor_Q19_dvia = oriHor_Q19_dvia;
    }

    public int getOriMin_Q19_dvia() {
        return OriMin_Q19_dvia;
    }

    public void setOriMin_Q19_dvia(int oriMin_Q19_dvia) {
        OriMin_Q19_dvia = oriMin_Q19_dvia;
    }

    public int getOriAmPm_Q19_dvia() {
        return OriAmPm_Q19_dvia;
    }

    public void setOriAmPm_Q19_dvia(int oriAmPm_Q19_dvia) {
        OriAmPm_Q19_dvia = oriAmPm_Q19_dvia;
    }

    public String getDesDis_Q20_dvia() {
        return DesDis_Q20_dvia;
    }

    public void setDesDis_Q20_dvia(String desDis_Q20_dvia) {
        DesDis_Q20_dvia = desDis_Q20_dvia;
    }

    public String getDesDir_Q20_dvia() {
        return DesDir_Q20_dvia;
    }

    public void setDesDir_Q20_dvia(String desDir_Q20_dvia) {
        DesDir_Q20_dvia = desDir_Q20_dvia;
    }

    public String getDesRef_Q20_dvia() {
        return DesRef_Q20_dvia;
    }

    public void setDesRef_Q20_dvia(String desRef_Q20_dvia) {
        DesRef_Q20_dvia = desRef_Q20_dvia;
    }

    public String getDesZtra_Q20_dvia() {
        return DesZtra_Q20_dvia;
    }

    public void setDesZtra_Q20_dvia(String desZtra_Q20_dvia) {
        DesZtra_Q20_dvia = desZtra_Q20_dvia;
    }

    public int getDesLug_Q21_dvia() {
        return DesLug_Q21_dvia;
    }

    public void setDesLug_Q21_dvia(int desLug_Q21_dvia) {
        DesLug_Q21_dvia = desLug_Q21_dvia;
    }

    public int getDesHor_Q22_dvia() {
        return DesHor_Q22_dvia;
    }

    public void setDesHor_Q22_dvia(int desHor_Q22_dvia) {
        DesHor_Q22_dvia = desHor_Q22_dvia;
    }

    public int getDesMin_Q22_dvia() {
        return DesMin_Q22_dvia;
    }

    public void setDesMin_Q22_dvia(int desMin_Q22_dvia) {
        DesMin_Q22_dvia = desMin_Q22_dvia;
    }

    public int getDesAmPm_Q22_dvia() {
        return DesAmPm_Q22_dvia;
    }

    public void setDesAmPm_Q22_dvia(int desAmPm_Q22_dvia) {
        DesAmPm_Q22_dvia = desAmPm_Q22_dvia;
    }

    public int getPro_Q23_dvia() {
        return Pro_Q23_dvia;
    }

    public void setPro_Q23_dvia(int pro_Q23_dvia) {
        Pro_Q23_dvia = pro_Q23_dvia;
    }

    public int getTraMed1_Q24a_dvia() {
        return TraMed1_Q24a_dvia;
    }

    public void setTraMed1_Q24a_dvia(int traMed1_Q24a_dvia) {
        TraMed1_Q24a_dvia = traMed1_Q24a_dvia;
    }

    public int getTraTpo1_Q24b_dvia() {
        return TraTpo1_Q24b_dvia;
    }

    public void setTraTpo1_Q24b_dvia(int traTpo1_Q24b_dvia) {
        TraTpo1_Q24b_dvia = traTpo1_Q24b_dvia;
    }

    /*

    public int getTraCos1_Q24c_dvia() {
        return TraCos1_Q24c_dvia;
    }

    public void setTraCos1_Q24c_dvia(int traCos1_Q24c_dvia) {
        TraCos1_Q24c_dvia = traCos1_Q24c_dvia;
    }

    */

    public String getTransb12_Q24d_dvia() {
        return Transb12_Q24d_dvia;
    }

    public void setTransb12_Q24d_dvia(String transb12_Q24d_dvia) {
        Transb12_Q24d_dvia = transb12_Q24d_dvia;
    }

    public int getTransb12_Q24e_dvia() {
        return Transb12_Q24e_dvia;
    }

    public void setTransb12_Q24e_dvia(int transb12_Q24e_dvia) {
        Transb12_Q24e_dvia = transb12_Q24e_dvia;
    }

    public int getTraMed2_Q24a_dvia() {
        return TraMed2_Q24a_dvia;
    }

    public void setTraMed2_Q24a_dvia(int traMed2_Q24a_dvia) {
        TraMed2_Q24a_dvia = traMed2_Q24a_dvia;
    }

    public int getTraTpo2_Q24b_dvia() {
        return TraTpo2_Q24b_dvia;
    }

    public void setTraTpo2_Q24b_dvia(int traTpo2_Q24b_dvia) {
        TraTpo2_Q24b_dvia = traTpo2_Q24b_dvia;
    }

    /*

    public int getTraCos2_Q24c_dvia() {
        return TraCos2_Q24c_dvia;
    }

    public void setTraCos2_Q24c_dvia(int traCos2_Q24c_dvia) {
        TraCos2_Q24c_dvia = traCos2_Q24c_dvia;
    }

*/

    public String getTransb23_Q24d_dvia() {
        return Transb23_Q24d_dvia;
    }

    public void setTransb23_Q24d_dvia(String transb23_Q24d_dvia) {
        Transb23_Q24d_dvia = transb23_Q24d_dvia;
    }

    public int getTransb23_Q24e_dvia() {
        return Transb23_Q24e_dvia;
    }

    public void setTransb23_Q24e_dvia(int transb23_Q24e_dvia) {
        Transb23_Q24e_dvia = transb23_Q24e_dvia;
    }

    public int getTraMed3_Q24a_dvia() {
        return TraMed3_Q24a_dvia;
    }

    public void setTraMed3_Q24a_dvia(int traMed3_Q24a_dvia) {
        TraMed3_Q24a_dvia = traMed3_Q24a_dvia;
    }

    public int getTraTpo3_Q24b_dvia() {
        return TraTpo3_Q24b_dvia;
    }

    public void setTraTpo3_Q24b_dvia(int traTpo3_Q24b_dvia) {
        TraTpo3_Q24b_dvia = traTpo3_Q24b_dvia;
    }

    /*

    public int getTraCos3_Q24c_dvia() {
        return TraCos3_Q24c_dvia;
    }

    public void setTraCos3_Q24c_dvia(int traCos3_Q24c_dvia) {
        TraCos3_Q24c_dvia = traCos3_Q24c_dvia;
    }

*/

    public String getTransb34_Q24d_dvia() {
        return Transb34_Q24d_dvia;
    }

    public void setTransb34_Q24d_dvia(String transb34_Q24d_dvia) {
        Transb34_Q24d_dvia = transb34_Q24d_dvia;
    }

    public int getTransb34_Q24e_dvia() {
        return Transb34_Q24e_dvia;
    }

    public void setTransb34_Q24e_dvia(int transb34_Q24e_dvia) {
        Transb34_Q24e_dvia = transb34_Q24e_dvia;
    }

    public int getTraMed4_Q24a_dvia() {
        return TraMed4_Q24a_dvia;
    }

    public void setTraMed4_Q24a_dvia(int traMed4_Q24a_dvia) {
        TraMed4_Q24a_dvia = traMed4_Q24a_dvia;
    }

    public int getTraTpo4_Q24b_dvia() {
        return TraTpo4_Q24b_dvia;
    }

    public void setTraTpo4_Q24b_dvia(int traTpo4_Q24b_dvia) {
        TraTpo4_Q24b_dvia = traTpo4_Q24b_dvia;
    }

    /*

    public int getTraCos4_Q24c_dvia() {
        return TraCos4_Q24c_dvia;
    }

    public void setTraCos4_Q24c_dvia(int traCos4_Q24c_dvia) {
        TraCos4_Q24c_dvia = traCos4_Q24c_dvia;
    }

*/

    public String getTransb45_Q24d_dvia() {
        return Transb45_Q24d_dvia;
    }

    public void setTransb45_Q24d_dvia(String transb45_Q24d_dvia) {
        Transb45_Q24d_dvia = transb45_Q24d_dvia;
    }

    public int getTransb45_Q24e_dvia() {
        return Transb45_Q24e_dvia;
    }

    public void setTransb45_Q24e_dvia(int transb45_Q24e_dvia) {
        Transb45_Q24e_dvia = transb45_Q24e_dvia;
    }

    public int getTraMed5_Q24a_dvia() {
        return TraMed5_Q24a_dvia;
    }

    public void setTraMed5_Q24a_dvia(int traMed5_Q24a_dvia) {
        TraMed5_Q24a_dvia = traMed5_Q24a_dvia;
    }

    public int getTraTpo5_Q24b_dvia() {
        return TraTpo5_Q24b_dvia;
    }

    public void setTraTpo5_Q24b_dvia(int traTpo5_Q24b_dvia) {
        TraTpo5_Q24b_dvia = traTpo5_Q24b_dvia;
    }

    /*

    public int getTraCos5_Q24c_dvia() {
        return TraCos5_Q24c_dvia;
    }

    public void setTraCos5_Q24c_dvia(int traCos5_Q24c_dvia) {
        TraCos5_Q24c_dvia = traCos5_Q24c_dvia;
    }

*/

    public String getTransb56_Q24d_dvia() {
        return Transb56_Q24d_dvia;
    }

    public void setTransb56_Q24d_dvia(String transb56_Q24d_dvia) {
        Transb56_Q24d_dvia = transb56_Q24d_dvia;
    }

    public int getTransb56_Q24e_dvia() {
        return Transb56_Q24e_dvia;
    }

    public void setTransb56_Q24e_dvia(int transb56_Q24e_dvia) {
        Transb56_Q24e_dvia = transb56_Q24e_dvia;
    }

    public int getTraMed6_Q24a_dvia() {
        return TraMed6_Q24a_dvia;
    }

    public void setTraMed6_Q24a_dvia(int traMed6_Q24a_dvia) {
        TraMed6_Q24a_dvia = traMed6_Q24a_dvia;
    }

    public int getTraTpo6_Q24b_dvia() {
        return TraTpo6_Q24b_dvia;
    }

    public void setTraTpo6_Q24b_dvia(int traTpo6_Q24b_dvia) {
        TraTpo6_Q24b_dvia = traTpo6_Q24b_dvia;
    }

    /*

    public int getTraCos6_Q24c_dvia() {
        return TraCos6_Q24c_dvia;
    }

    public void setTraCos6_Q24c_dvia(int traCos6_Q24c_dvia) {
        TraCos6_Q24c_dvia = traCos6_Q24c_dvia;
    }

*/

    public String getTransb67_Q24d_dvia() {
        return Transb67_Q24d_dvia;
    }

    public void setTransb67_Q24d_dvia(String transb67_Q24d_dvia) {
        Transb67_Q24d_dvia = transb67_Q24d_dvia;
    }

    public int getTransb67_Q24e_dvia() {
        return Transb67_Q24e_dvia;
    }

    public void setTransb67_Q24e_dvia(int transb67_Q24e_dvia) {
        Transb67_Q24e_dvia = transb67_Q24e_dvia;
    }

    public int getTraMed7_Q24a_dvia() {
        return TraMed7_Q24a_dvia;
    }

    public void setTraMed7_Q24a_dvia(int traMed7_Q24a_dvia) {
        TraMed7_Q24a_dvia = traMed7_Q24a_dvia;
    }

    public int getTraTpo7_Q24b_dvia() {
        return TraTpo7_Q24b_dvia;
    }

    public void setTraTpo7_Q24b_dvia(int traTpo7_Q24b_dvia) {
        TraTpo7_Q24b_dvia = traTpo7_Q24b_dvia;
    }

    /*

    public int getTraCos7_Q24c_dvia() {
        return TraCos7_Q24c_dvia;
    }

    public void setTraCos7_Q24c_dvia(int traCos7_Q24c_dvia) {
        TraCos7_Q24c_dvia = traCos7_Q24c_dvia;
    }

*/

    public int getMcar_Q25_dvia() {
        return Mcar_Q25_dvia;
    }

    public void setMcar_Q25_dvia(int mcar_Q25_dvia) {
        Mcar_Q25_dvia = mcar_Q25_dvia;
    }

    public int getEsta_Q26a_dvia() {
        return Esta_Q26a_dvia;
    }

    public void setEsta_Q26a_dvia(int esta_Q26a_dvia) {
        Esta_Q26a_dvia = esta_Q26a_dvia;
    }

    public int getPago_Q26b_dvia() {
        return Pago_Q26b_dvia;
    }

    public void setPago_Q26b_dvia(int pago_Q26b_dvia) {
        Pago_Q26b_dvia = pago_Q26b_dvia;
    }


   /*
    public int getTar_Q26c_dvia() {
        return Tar_Q26c_dvia;
    }

    public void setTar_Q26c_dvia(int tar_Q26c_dvia) {
        Tar_Q26c_dvia = tar_Q26c_dvia;
    }
*/

    public double getTar_Q26c_dvia() {
        return Tar_Q26c_dvia;
    }

    public void setTar_Q26c_dvia(double tar_Q26c_dvia) {
        Tar_Q26c_dvia = tar_Q26c_dvia;
    }






    public int getTraRazem1_Q29_dvia() {
        return TraRazem1_Q29_dvia;
    }

    public void setTraRazem1_Q29_dvia(int traRazem1_Q29_dvia) {
        TraRazem1_Q29_dvia = traRazem1_Q29_dvia;
    }

    public int getTranutp1_Q30_dvia() {
        return Tranutp1_Q30_dvia;
    }

    public void setTranutp1_Q30_dvia(int tranutp1_Q30_dvia) {
        Tranutp1_Q30_dvia = tranutp1_Q30_dvia;
    }

    public int getNdsBusDis_Q30_dvia() {
        return NdsBusDis_Q30_dvia;
    }

    public void setNdsBusDis_Q30_dvia(int ndsBusDis_Q30_dvia) {
        NdsBusDis_Q30_dvia = ndsBusDis_Q30_dvia;
    }

    public int getNdsBusTpo_Q30_dvia() {
        return NdsBusTpo_Q30_dvia;
    }

    public void setNdsBusTpo_Q30_dvia(int ndsBusTpo_Q30_dvia) {
        NdsBusTpo_Q30_dvia = ndsBusTpo_Q30_dvia;
    }

    public double getNdsBusTar_Q30_dvia() {
        return NdsBusTar_Q30_dvia;
    }

    public void setNdsBusTar_Q30_dvia(double ndsBusTar_Q30_dvia) {
        NdsBusTar_Q30_dvia = ndsBusTar_Q30_dvia;
    }

    public int getNdsBustrb_Q30_dvia() {
        return NdsBustrb_Q30_dvia;
    }

    public void setNdsBustrb_Q30_dvia(int ndsBustrb_Q30_dvia) {
        NdsBustrb_Q30_dvia = ndsBustrb_Q30_dvia;
    }

    public int getNdsTaxiDis_Q30_dvia() {
        return NdsTaxiDis_Q30_dvia;
    }

    public void setNdsTaxiDis_Q30_dvia(int ndsTaxiDis_Q30_dvia) {
        NdsTaxiDis_Q30_dvia = ndsTaxiDis_Q30_dvia;
    }

    public int getNdsTaxiTpo_Q30_dvia() {
        return NdsTaxiTpo_Q30_dvia;
    }

    public void setNdsTaxiTpo_Q30_dvia(int ndsTaxiTpo_Q30_dvia) {
        NdsTaxiTpo_Q30_dvia = ndsTaxiTpo_Q30_dvia;
    }

    public int getNdsTaxiTar_Q30_dvia() {
        return NdsTaxiTar_Q30_dvia;
    }

    public void setNdsTaxiTar_Q30_dvia(int ndsTaxiTar_Q30_dvia) {
        NdsTaxiTar_Q30_dvia = ndsTaxiTar_Q30_dvia;
    }

    public int getNdsCarroTpo_Q30_dvia() {
        return NdsCarroTpo_Q30_dvia;
    }

    public void setNdsCarroTpo_Q30_dvia(int ndsCarroTpo_Q30_dvia) {
        NdsCarroTpo_Q30_dvia = ndsCarroTpo_Q30_dvia;
    }

    public int getNdsCarroCos_Q30_dvia() {
        return NdsCarroCos_Q30_dvia;
    }

    public void setNdsCarroCos_Q30_dvia(int ndsCarroCos_Q30_dvia) {
        NdsCarroCos_Q30_dvia = ndsCarroCos_Q30_dvia;
    }

    public double getNdsCarroPea_Q30_dvia() {
        return NdsCarroPea_Q30_dvia;
    }

    public void setNdsCarroPea_Q30_dvia(double ndsCarroPea_Q30_dvia) {
        NdsCarroPea_Q30_dvia = ndsCarroPea_Q30_dvia;
    }

    public double getNdsCarroEsta_Q30_dvia() {
        return NdsCarroEsta_Q30_dvia;
    }

    public void setNdsCarroEsta_Q30_dvia(double ndsCarroEsta_Q30_dvia) {
        NdsCarroEsta_Q30_dvia = ndsCarroEsta_Q30_dvia;
    }

    public String getCoordenadas_Origen() {
        return Coordenadas_Origen;
    }

    public void setCoordenadas_Origen(String coordenadas_Origen) {
        Coordenadas_Origen = coordenadas_Origen;
    }

    public String getCoordenadas_Destino() {
        return Coordenadas_Destino;
    }

    public void setCoordenadas_Destino(String coordenadas_Destino) {
        Coordenadas_Destino = coordenadas_Destino;
    }


    public double getPeaViaQ26d_dvia() {
        return PeaViaQ26d_dvia;
    }

    public void setPeaViaQ26d_dvia(double peaViaQ26d_dvia) {
        PeaViaQ26d_dvia = peaViaQ26d_dvia;
    }

    public int getFreViaQ26e_dvia() {
        return FreViaQ26e_dvia;
    }

    public void setFreViaQ26e_dvia(int freViaQ26e_dvia) {
        FreViaQ26e_dvia = freViaQ26e_dvia;
    }

    public boolean isVialarQ27_dvia() {
        return VialarQ27_dvia;
    }

    public void setVialarQ27_dvia(boolean vialarQ27_dvia) {
        VialarQ27_dvia = vialarQ27_dvia;
    }

    public int getMedQ28_dvia() {
        return MedQ28_dvia;
    }

    public void setMedQ28_dvia(int medQ28_dvia) {
        MedQ28_dvia = medQ28_dvia;
    }

    public int getPqnutpQ30_dvia() {
        return PqnutpQ30_dvia;
    }

    public void setPqnutpQ30_dvia(int pqnutpQ30_dvia) {
        PqnutpQ30_dvia = pqnutpQ30_dvia;
    }

    public boolean isConsenQ31_dvia() {
        return ConsenQ31_dvia;
    }

    public void setConsenQ31_dvia(boolean consenQ31_dvia) {
        ConsenQ31_dvia = consenQ31_dvia;
    }

    public int getNumCelQ32_dvia() {
        return NumCelQ32_dvia;
    }

    public void setNumCelQ32_dvia(int numCelQ32_dvia) {
        NumCelQ32_dvia = numCelQ32_dvia;
    }

    public int getTotal_Viajes() {
        return Total_Viajes;
    }

    public void setTotal_Viajes(int total_Viajes) {
        Total_Viajes = total_Viajes;
    }

    public String getDia_Viaje() {
        return Dia_Viaje;
    }

    public void setDia_Viaje(String dia_Viaje) {
        Dia_Viaje = dia_Viaje;
    }

    public String getMes_Viaje() {
        return Mes_Viaje;
    }

    public void setMes_Viaje(String mes_Viaje) {
        Mes_Viaje = mes_Viaje;
    }


    public String getOtraFrecuenciaViaje() {
        return OtraFrecuenciaViaje;
    }

    public void setOtraFrecuenciaViaje(String otraFrecuenciaViaje) {
        OtraFrecuenciaViaje = otraFrecuenciaViaje;
    }

    public String getFecha_Viaje() {
        return Fecha_Viaje;
    }

    public void setFecha_Viaje(String fecha_Viaje) {
        Fecha_Viaje = fecha_Viaje;
    }



    //NUEVOS GET/SETTERS:


    public double getTraCos1_Q24c_dvia() {
        return TraCos1_Q24c_dvia;
    }

    public void setTraCos1_Q24c_dvia(double traCos1_Q24c_dvia) {
        TraCos1_Q24c_dvia = traCos1_Q24c_dvia;
    }

    public double getTraCos2_Q24c_dvia() {
        return TraCos2_Q24c_dvia;
    }

    public void setTraCos2_Q24c_dvia(double traCos2_Q24c_dvia) {
        TraCos2_Q24c_dvia = traCos2_Q24c_dvia;
    }

    public double getTraCos3_Q24c_dvia() {
        return TraCos3_Q24c_dvia;
    }

    public void setTraCos3_Q24c_dvia(double traCos3_Q24c_dvia) {
        TraCos3_Q24c_dvia = traCos3_Q24c_dvia;
    }

    public double getTraCos4_Q24c_dvia() {
        return TraCos4_Q24c_dvia;
    }

    public void setTraCos4_Q24c_dvia(double traCos4_Q24c_dvia) {
        TraCos4_Q24c_dvia = traCos4_Q24c_dvia;
    }

    public double getTraCos5_Q24c_dvia() {
        return TraCos5_Q24c_dvia;
    }

    public void setTraCos5_Q24c_dvia(double traCos5_Q24c_dvia) {
        TraCos5_Q24c_dvia = traCos5_Q24c_dvia;
    }

    public double getTraCos6_Q24c_dvia() {
        return TraCos6_Q24c_dvia;
    }

    public void setTraCos6_Q24c_dvia(double traCos6_Q24c_dvia) {
        TraCos6_Q24c_dvia = traCos6_Q24c_dvia;
    }

    public double getTraCos7_Q24c_dvia() {
        return TraCos7_Q24c_dvia;
    }

    public void setTraCos7_Q24c_dvia(double traCos7_Q24c_dvia) {
        TraCos7_Q24c_dvia = traCos7_Q24c_dvia;
    }
}
