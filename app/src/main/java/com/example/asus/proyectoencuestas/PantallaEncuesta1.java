package com.example.asus.proyectoencuestas;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.microsoft.windowsazure.mobileservices.table.DateTimeOffset;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PantallaEncuesta1 extends AppCompatActivity {

    public int switchFechas;

    AdaptadorListaVehiculos adapter;
    ArrayList<Object> listaVehiculos=new ArrayList<>();

    static AdaptadorListaPersonas1 adapterPersonas;
    public static ArrayList<Detalle_Informacion_Personal_Anexo_1> listaPersonas=new ArrayList<>();




    public static String coordUbicacion;
    public static TextView lblCoordenadasUbicacion;




    public String fechaCreacion;

    public String f1;
    public String f2;
    public String f3;



    public Calendar fecha1;
    public Calendar fecha2;
    public Calendar fecha3;


    public boolean alMenosUnaPersona;

    public boolean valFecha1;
    public boolean valFecha2;
    public boolean valFecha3;

    public boolean valNumeroHogar;

    public boolean valSupervisor;
    public boolean valCodificador;

    public boolean valNombreCalle;

    public boolean valNumeroPuerta;
    public boolean valInterior;

    public boolean valEtapa;
    public boolean valManzana;
    public boolean valLote;
    public boolean valKilometro;
    public boolean valTelCel;

    public boolean valNombreJefeHogar;

  //  public boolean valIngresoMensual;



    static Map<String,Boolean> vals=new HashMap<String,Boolean>();
    static {
   // vals.put("alMenosUnaPersona", null);
    vals.put("valFecha1", null);
    vals.put("valFecha2", null);
    vals.put("valFecha3", null);
    vals.put("valNumeroHogar", null);
    vals.put("valSupervisor", null);
    vals.put("valCodificador", null);
    vals.put("valNombreCalle",null);
    vals.put("valNumeroPuerta", null);
    vals.put("valInterior", null);
    vals.put("valEtapa", null);
    vals.put("valManzana", null);
    vals.put("valLote", null);
    vals.put("valKilometro", null);
    vals.put("valTelCel", null);
    vals.put("valNombreJefeHogar",null);
    vals.put("valNotas",null);
    vals.put("valZonaCensal",null);
    vals.put("valManzanaHogar",null);
    vals.put("valOtroVehiculo",null);
    vals.put("valOtroMaterialParedes",null);
    vals.put("valOtroMaterialPisos",null);
    vals.put("valOtroTipoAlumbrado",null);
    vals.put("valOtroTipoAbastecimientoAgua",null);
    vals.put("valOtroTipoServiciosHigienicos",null);


  //  vals.put("valIngresoMensual",null);


}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_encuesta1);


        coordUbicacion=null;


        final SQLite sqlite= new SQLite(this,"BDEncuestasEscom", null,3);




        //VER TMB LAS COSAS POR HACER EN LA CLASE MAINACTIVITY

        //CAMPO DE FECHA DE LA TPMA DE ENCUESTA OBTENIDO AUTOMATICAMENTE? Y CON QUE FECHA (FECHA PRIMERA TOMA INCOMPLETA, FECHA ENCUESTA COMPLETA, FECHA SINCROPNIZACION)?

        //VER CUAL ES EL TIPO DE FECHA/HORA CORRECTO PARA LA INSERCION A LA BASE DE DATOS Y CAMBIARLE EL TIPO A LOS 4 CAMPOS DE PantallaEncuesta1 DE SER NECESARIO

        //ASEGURARME DE QUE TODOS LOS CAMPOS NUMERICOS (INT O DOUBLE) SEAN LOS CORCTOS ANTES DE LA INSERCION

        //GENERALIZAR LA PANTALLA DE SINCRONIZACION PARA PODER USARLA EN TODAS LAS ENCUESTAS

        //TENER EN CUENTA QUE CON LOS REGISTROS DE SQLITE INCOMPLETOS SE NECESITARIA VALIDAR NO SOLO ONCHANGE SINO TMB EN EL ONCREATE DEL ACTIVITY NI BIEN SE PASEN LOS VALORES

        //CASTEAR A DATE Y BOOLEAN LOS CAMPOS GUARDADOS EN SQLITE (GUARDADOS COMO TEXT Y INTEGER)

        //VER CON QUE LISTAS SE TIENEN QUE LLENAR LOS 4(?) PRIMEROS SPINNERS, CREARLES SUS ADAPTADORES Y VALIDARLOS SOLO DE SER NECESARIO

        //AVERIGUAR QUE TIPO DE DATOS SON LAS CASILLAS DE SUPERVISOR Y CODIFICADOR PARA USAR LA ESTRUCTURA (RADIO BUTTON, CHECKBOX) NECESARIA Y VALIDAR DE SER NECESARIO


        //BUSCAR BUG EN RECYCLERVIEW (COMO EL DE LA CREACION DE REGISTROS DESPUES DE HABER BORRADO UNO) Y ARREGLARLOS

        //CAMBIAR LABELS PANTALLA SOBRE TRANSBORDO (EN FILA_VIAJE) CUANDO SEPA QUE SON LOS CAMPOS


        //EL DOCUMENTO DE IDENTIDAD DEL ENCUESTADOR EN LA PARTE PERSONA DE LA ENCUESTA 1 Y EL NUMERO DE HOGAR TMB SE TOMA AUTOMATICAMENTE DESDE EL INICIO DE LA ENCUESTA (VER COMO SOLUCIONAR ESTO EN CASO SE CREEN USUARIOS SIN DNI)

        //IGUALMENTE CON LOS PRIMEROS CAMPOS DE LA TABLA VIAJE

        //PREGUNTAR SI ES NECESARIO QUE EN LOS SPINNERS DEL RECYCLERVIEW DE VIAJE (Y OTROS) HALLA "0" POR DEFAULT, SI ES NECESARIO O NO IMPLEMENTAR LOS RANGOS DADOS [0,240], ETC

        //EN EL FUTURO PODRIA SER NECESARIO CAMBIAR ALGUNOS POPUS DE "FALTAN DATOS O DATOS ERRONEOS" CUANDO SE IMPLEMENTE LO DE LOS DATOS INCOMPLETOS

        //EN EL FUTURO HACER QUE EL POPUP DE LA VALIDACION TE DIGA CUAL ES EL CAMPO INCORRECTO/INCOMPLETO

        //OCULTAR O IMPLEMENTAR BOTON PARA MODIFICAR REGISTROS DE UN RECYCLER VIEW SI ME LO PIDEN

        //ASEGURRME DE QUE VALIDACIONES SE EJECUTEN TAMBIEN AL CARGAR PANTALLA PARA CORRECTO FUNCIONAMIENTO DE VALIDACION

        //PREGUNTAR SI ES NECESARIO QUE CAMPOS FINALES DE LA PANTALLA VIAJE SE DESACTIVEN CUANDO SE SELECCIONE UNA OPCION DE VEHICULO Y SE CAMBIO SUS VALOES A ZERO O SI SOLO BASTA
        //DEJARLO COMO ESTA Y PASAR LOS VALORES NECESARIOS EN ZERO CUANDO SE GRABE EN LA BASE DE DATOS (NO OLVIDAR HACER ESTO!!!!!!!!!!!!!!!!!!!!!!!!!!!)

        //PROPONER UNA OPCION NEUTRA EN LAS LISTAS QUE LO NECESITEN COMO LAS DEL FINAL DE LA ENCUESTA VIAJE EJ. INCLUIR 0 EN LOS RANGOS

        //AVISARLE A JUAN CARLOS QUE CAMBIE LOS INDICES DE SUS TABLAS PARA QUE COMIENCEN POR 0 Y NO POR 1 PORQUE LAS LISTAS DE LOS SPINNERS COMIENZAN POR 0 POR DEFAULT

        //IMPLEMENTAR EN EL FUTURO VALIDACIONES MAS COMPLEJAS COMO POR EJEMPLO LA DE ESTACIONAMIENTO Y TARIFA (NO ACEPTAR TARIFA=0 SI SE SELECCIONA QUE EL ESTAC. ES PAGADO) O PLANTEAR DEJARLO COMO TRAMPA PARA VER SI SALTAN CAMPOS?

        //PREGUNTAR SI CAMPOS CONDICIONALES DE ENCUESTA VIAJES (COMO PORQUE ELIGIO ESTE MEDIO TRANSPORTE?) NECESITAN SER VALIDADOS

        //DISCAPACIDAD Y "NECESITA AYUDA PARA VIAJAR" TIENEN "SI" POR DEFECTO EN LA PANTALLA DE PERSONA (PREGUNTAR Y CAMBIAR DE SER NECESARIO)

        //PROYECTO ES SOLO DE LIMA Y JC A PASADO DISTRITOS DE TODOS EL PERU (PREGUNTAR)

        //AVERIGUAR QUE PASA SI EL METODO DE CONEXION AL AZURE DE LA PRIMERA PANTALLA SE EJECUTA SIN CONEXION A INTERNET

        //BORRAR O HACER INTERACTIVO EL MENSAJE DE "NO HAY REGISTROS POR SINCRONIZAR" DE EL SYNC ACTIVITY

        //IMPORTANTE:

        //PEDIR LISTAS PARA DISTRITO (O CON TEXTVIEW?), ZONA TRANSITO Y PRIMERA FILA DE PRIMERA PANTALLA Y VALIDAR DE SER NECESARIO (DE CAMBIAR ALGUN SPINNER POR UN TEXTVIEW)

        //AVERIGUAR COMO VALIDAR LAS 3 FECHAS Y QUE AL MENOS HAYA UN REGISTRO DE PERSONA EN LA PANTALLA PRINCIPAL (Y AL MENOS UN VIAJE EN LA SGTE) (Y AL MENOS UN TRAMO EN LA SGTE)

        //JUAN  CARLOS SE OLVIDO DEL CAMPO NOMBRE DE CALLE EN LAS BASES DE DATOS, SE CREO UNO EN TODAS LAS BASES DE DATOS, AVISARLE!!!!!!!!!

        //PREGUNTAR HOY TMB DE UNA VEZ POR LOS 2 CAMPOS DEL RECYCLER DE TRAMOS Y VALIDARLOS COMO SIEMPRE SI ES QUE ES NECESARIO (SI SON TEXTVIEWS Y NO SPINNERS)


        //LISTA DE CAMPOS TEMPORALES QUE PUEDEN CAMBIAR (AVERIGUAR):

        //ZONA TRANSITO (VARIOS), DISTRITOS (VARIOS),PRIMERA FILA PRIMERA PANTALLA (3 + DISTRITO), TRANSBORDO Y NUMERO TRANSBORODO (AMBOS EN RECYCLER DE TRAMOS)


        //ASEGURARME DE QUE TODOS LAS LISTAS UTILIZADAS COINCIDAN CON LO QUE EL CLIENTE QUIERE (TENER EN CUENTA LOS CAMBIOS HECHOS COMO LA ELIMINACION DEL ZERO POR DEFAULT)

        //IMPLEMENTAR GOOGLE MAPS Y AVERGIUAR EN QUE CAMPOS IRIAN LAS COORDENADAS Y EN REEMPLAZO DE QUE CAMPOS

        //DISEÑAR TODAS LAS INTERFACES DE USUARIO EN BASE A LA TABLET DADA!!!!!!!!!!!!!!!!!!!

        //TESTEAR TODAS LOS CASOS EN LOS QUE USO EL "SWITCH" DEL ADAPTADOR DOBLE (EJ. EN LA ELIMINACION DEL ADAPTADOR USADO CON PERSONAS)

        //NO OLVIDAR QUE EL PASO DE ACTIVITY LUEGO DE GRABASR EN LA BD SQLITE EN PANTALLA 1 TIENE QUE SER CON finish(), no intent()

        //TERMINAR PRIMERO CAMINO PRINCIPAL DE HASTA REGISTRO EN BD AZURE CON MUESTRA DE RESULTADOS PARCIALES EN RECYCLER VIEWS Y LUEGO COMENZAR CON LOS "MODIFICAR" Y EL MANEJO DE REGISTRO INCOMPLETO


        //SE ESTA UTLIZANDO EL KEYWORD "TRANSIENT" PARA EL ARRAYLIST EN EL DTO DE PERSONA, TENER EN CUENTA QUE ESTO ES ALGO QUE PUEDE CAUSAR PROBLEMAS AL SUBIR A AZURE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


        //SEGUIR BUSCANDO ESCENARIOS EN LOS QUE LOS PASES DE INFORMACION ENTRE LOS 3 ACTIVITIES NO FUNCIONE BIEN (ES MUY PROBABLE QUE HAYAN MAS!) Y VER SI LA SOLUCION IMPLEMENTADA RESISTE (O MEJORARLA)
        //(2 BOTONES DE PASE DE "REGRESO" MAS PASO DE LA PRIMERA PANTALLA A LA SEGUNDA)


        //ASEGURARME DE QUE  LOS 3 CALENDAR DE PANT.1, EL SWITCHFECHA(?) Y FUTUROS CAMPOS COMO ALGUNO DE GOOGLE MAPS
        //ESTEN TODOS CON LOS VALORES CORRECTOS EN TODOS LOS ESCENARIOS DE CAMBIO DE PANTALLA POSIBLES!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        //PREGUNTAR YA COMO QUIEREN QUE SE HAGA EL MANEJO DE LAS 3 FECHAS DE LA PANTALLA 1 Y TRABAJAR TODAS LAS VALIDACIONES E INTERACCIONES ENTRE PANTALLAS DE ACUERDO A LO QUE PIDAN

        //VER TMB PARA QUE SON LOS RADIO BUTTON DE LA PANTALLA 1 , HACERLOS COMO QUIERAN Y VALIDAR Y MANEJAR PANTALLAS DE ACUERDO A ELLO TMB, COMO CON LAS FECHAS, AÑADIR LABELS

        //IMPLEMENTAR SUBIDA DE REGISTROS INCOMPLETOS A AZURE (COORDINAR), CON REEMPLAZO DE DATOS CUANDO ESTOS SE COMPLETEN


        //DE SER SOLICITADO, HACER CAMPOS ADICIONELS PARA LAS COORDENADAS DE TODAS LAS DIRECCIONES EN LAS BASES DE DATOS E IMPLEMENTAR UN BOTON EN LOS FOMULARIOS EN LOS QUE BUSCAR CON GOOGLE PLACES
        //LA DIRECCION INGRESADA EN LOS TEXTBOX (SOLO FUNCIONA CON INTERNET)

        //DESPUES DE AVERIGUAR QUE ES LO QUE QUIEREN QUE SE INGRESE EN TODOS LOS DATOS DEL FORMULARIO, HACER LOS CAMBIOS RESPECTIVOS EN BS E INTERFACE CON TODAS LAS VALIDACIONES E INTERACCIONES ENTRE PANTALLAS REQUERIDAS

        //FALTA LA VALIDACION DEL CAMPO NOOMBRE DEL JEFE DE HOGAR DE LA PANTALLA 1 !!! INCLUIRLA!!!!!

        //VER TODOS LOS COMENTARIOS DE LAS INSERCIONES DE LOS CAMPOS A LA BASE DE DATOS SQLITE Y PREGUNTAR / ACLARAR DUDAS AL RESPECTO


        //TENER EN CUENTA TMB EL CAMPO STA_ENC, QUE PUEDE VARIAR EN EL FUTURO DE ACUERDO AL TIPO DE ENCUESTA QUE SE GRABE

        //LA BASE DE DATOS SE CREA AHI????????????????????? (AL COMENZAR LA PRIMERA PANTALLA)? VER SI LOS DATOS PERSISTEN!!!!!!!!!!!!!!!!!!!!

        //VER SI ES NECESARIO CREAR LLAVES FORANEAS, ETC PARA LAS TABLAS DE SQLITE Y AZURE


        //NO OLVIDAR PASAR EL DNI ENCUESTADOR DESDE LA PRIMERA PANTALLA HASTA ESTA , E INCLUIRLO EN LAS 3 TABLAS (ENCUESTA, PERSONA VIAJE) DE AMBAS BD!!!!!

        //TENER EN CUENTA Y AVISAR JC QUE SE INCLUYO UN CAMPO DNI_ENCUESTADOR EN LAS TABLAS DE VIAJES TMB

        //ASEGURARME DE QUE LOS NUMEROS DE PERSONA DE UN VIAJE COINCIDAN CON EL DE LA PERSONA QUE LE CORRESPONDE

        //ES NECESARIO UN NOTIFY() EN EL BOTON PARA GRABAR EN SQLITE PARA QUE EL NUEVO REGISTRO APAREZCA EN EL RECYCLER VIEW DEL SYNC ACTIVITY ?

        //EL FINISH() (Y EL NOTIFY()) DEL BOTON GUARDAR ENCUESTA IRIAN DONDE ESTAN O EN EL FINALLY?

        //HACER UN POPUP EN CASO HAYA UN ERROR EN LA INSERCION DE LA ENCUESTA A LA BASE DE DATOS SQLITE


        //TESTEAR EXHAUSTIVAMENTE QUE LOS REGISTROS GRABADOS EN EL SQLITE SEAN LOS CORRECTOS

        //IMPLEMENTAR EN LA DOBLE LISTA CON SWITCH PARA SELECCIONAR REGISTROS COMPLETOS E INCOMPLETOS EN LA SYNC ACTIVITY?

        //IMPLEMENTAR EN EL SYNC ACTIVITY BOTONES PARA MARCAR Y DESMARCAR TODOS LOS CHECKBOX

        //NO OLVIDAR IMPLEMENTAR EN EL FUTURO BOTONES MODIFICAR Y BORRAR(?) REGISTROS EN LOS ITEMS DE LA LISTA DE LA PANTALLA SYNC ACTIVITY

        //IMPLEMENTAR EL MENSAJE DE "NO HAY REGISTROS POR SINCRONIZAR" EN EL SYNC ACTIVITY QUE APAREZCA CUANDO NO HAYAN REGISTROS

        //NO OLVIDAR UTLIZAR TRANSACCIONES PARA SUBIR A AZURE TAMBIEN

        //QUE LA LISTA DE LA PANTALLA SYNC ESTE ACTUALIZADA SIEMPRE ES FUNDAMENTAL XQ TIENE QUE VER CON LA INSERCION EN AZURE, NO ES UNA SIMPLE LISTA

        //2 COSAS QUE PODRIAN HACER QUE LA INSERCION A AZURE SE CAIGA: EL INDICE DE LOS CHECKBOX CAMBIA JUNTO CON EL DE LA LISTA DE SYNC ACTIVITY Y LAS VARIABLES DE LAS CLASES BEAN SON int y NO INTEGER LO QUE PUEDE GENERAR ERRORES CON NULL

        //IMPLEMENTAR UN POPUP AL PRESIONAR EL BOTON "SINCRONIZAR" SIN NINGUN CHECKBOX MARCADO? , VER QUE PASA SI SE HACE

        //LA INSERCION DE LAS 4 FECHAS AL AZURE SE DEJO COMO COMENTARIO POR MIENTRAS, VER COMO SOLUCIONAR EL PROBLEMA Y CORREGIR EL BOTON SINCRONIZAR

        //SE LE CAMBIO EL NOMBRE AL CAMPO DEL FIELD: Tel_Q2a_enc DE Tel_Q2b_enc

        //VER SI LOS ULTIMOS 9 BOOLEANS DE LA PANTALLA 1 SE INSERTAN CON LOS VALORES INDICADOS

        //TENER EN CUENTA QUE LOS TIPOS DE LOS DTO SON PRIMITIVOS, ESTO PUEDE HACER QUE SE LES DE VALORES POR DEFECTO INADECUADOS A LOS CAMPOS, VER SI ES ASI Y SI ES NECESARIO BUSCAR SOLUCIONARLO

        //SI LA INSERCION EN AZURE ""ES EXITOSA"" SEGUN AZURE, SIEMPRE GRABA LOS DATOS???

        //HAY ERRORES EN AZURE POR TIMEOUT?? INTENTAR CON INSERCIONES PESADAS Y CON VARIAS TABLAS DETALLE

        //VER SI LOS CHECKBOX SE "CORREN" AL HACER INSERCIONES MULTIPLES

        //IMPLEMENTAR LAS ELIMINACIONES DE AZURE EN LOS 3 LUGARES QUE FALTAN,  TENER EN CUENTA QUE LOS DELETE DE REPUESTO TMB PUEDEN FALLAR X LO QUE NO SON PERFECTAS  EVALUAR ALTERNATIVAS:
        //HACER CODIGO EN ACCESS PARA DESCARTAR DUPLICADOS POR CODIGO  Y REGISTROS INCOMPLETOS (SIN TODOS SUS DETALLES), AVISAR USUARIOS QUE SI NO PUEDEN SINC UN REGISTRO AVISEN, ETC
        //NOTIFICAR DE TODOS ESTOS ASUNTOS A JUAN CARLOS

        //HACER PRUEBAS DE AZURE DE TODOS LOS TIPOS

        //ASEGURARSE DE QUE SI SE SINCRONIZAN VARIOS REGISTROS Y POR EJEMPLO, SOLO HAY UN ERROR EN EL DETALLE DE UNO DE ELLOS, SE TIENE QUE HACER ROLLBACK TODAS LAS 3 TABLAS, PERO SOLO DE ESE REGISTRO, LOS QUE ESTAN BIEN NO!

        //USAR DOBLE VALIDACION DE USUARIO Y CLAVE PARA USUARIOS NUEVOS Y SIN INTERNET? TMB, NO OLVIDAR QUE PUEDEN HABER ROLES PARA LAS ENC 1 Y 6 EN LA 2° PANTALLA (VALIDAR CON DOBLE BD TMB?)

        //HAY UN CAMPO LLAMADO Hog_enc que aparece en el SQLITE PERO NO EN EL ACCESS Y NO SE SABE QUE ES LO QUE HACE, PREGUNTAR

        //LOS ERRORES POR TIMEOUT TAMBIEN PRODUCER INSERCIONES A MEDIAS A AZURE, BUSCAR FORMAS PARA CORREGIR ESTO

        //HABRIAN 2 POSIBLES PROBLEMAS DE INSERCION DA AZURE: DUPLICADOS (SOLUCIONAR EN ACCESS) Y INFO INCOMPLETA (RECUPERAR MANUALMENTE DE CELULARES DE ENCUESTADORES?)

        //PROBAR MULTIPLES VECES EL BOTON MODIFICAR REGISTRO DE LAS 2 PRIMERAS PANTALLAS 1  (SOBRE TODOS BUSCAR ERRORES DE TIPO NULLS, ETC)

        //EN LAS DISTINATAS PANTALLAS, PONER BACKGROUND DE UN COLOR DIFERENTE A LOS CAMPOS OBLIGATORIOS

        //EN EL BOTON MODIFICAR DE LA PANTALLA SYNC (PARA MODIFICAR REGISTROS YA INGRESADOS) SE BORRAN LAS FILAS DE LAS 3 TABLAS CON EL MISMO COD. HOGAR EN LUGAR DE SOLO CAMBIARLES EL STATUS
        //FILA 1428 DE PANTALLAENCUESTA1 APROX. CAMBIAR ESTO Y LO QUE SEA NECESARIO DE MANERA QUE SOLO SE LE CAMBIA EL STATUS A ESTOS REGISTROS EN EL FUTURO!!!!

        //AVERIGUAR PORQUE EL CODIGO PARA SETEAR EN LOS SPINNERS LOS VALORES A MODIFICAR NO FUNCIONA CON LOS ULTIMOS 3 DOUBLES EN LA PANTALLA VIAJES (HORAS Y MINUTOS TAMPOCO FUNCIONAN?)

        //INCLUIR EN LA RECUPERACION DE DATOS (CON EL BOTON DE MODIFICAR REGISTRO) LAS FECHAS DE LA PANTALLA1 (JALARLAS DE LA BASE DE DATOS), ADEMAS JALAR TMB LOS 2 VALORES CORRECTOS DE LOS RADIOGROUP

        //HAN ENVIADO AL CORREO EXCEL NUEVOS CON ALGUNOS CAMBIOS EN LAS COLUMNAS DE LAS ENCUESTAS, REVISAR Y CORREGIR

        //ASEGURARME DE QUE TODOS LOS DATOS INCLUIDOS LOS DE LAS LISTAS DE LOS 2 DETALLES , ESTEN BIEN LUEGO DE MODIFICAR UN REGISTRO SQLITE (HACER PRUEBAS CON VARIOS BTNES MODIFICAR Y CON AZURE)

        //ADVERTIR JC SOBRE POSIBILIDAD QUE SE BORREN LOS DATOS DE LOS ENCUESTADORES SI SALEN DE UNA PANTALLA CON EL BACK BUTTON LUEGO DE UN "MODIFICAR" (ASEGURARME DE QUE ESTE DE ACUERDO QUE CON EL POPUP ES SUFICIENTE)

        //EL RECYCLER DE LOS VEHICULOS EN LA PANTALLA 1  NO FUNCIONA LUEGO DE PRESIONAR "MODIFICAR" , SOLUCIONAR !!!!!!!!!!!!!! (ES PORQUE SE EJECUTE DESPUES DE ELIMINAR LOS REGISTROS)

        //SOLUCIONAR PROBLEMA OCASIONAL DE DOBLE INICIALIZACION DE AZURE EN LA PANTALLA LOGIN (java.lang.IllegalStateException: AzureServiceAdapter is already initialized)

        //QUE PASA SI PRESIONA EL BOTON SINCRONIZAR SIN INTERNET? CONTROLAR EL ERROR SI ES NECESARIO

        //SOLUCIONAR SCROLL DE LA PNATALLA HACIA ARRIBA CUANDO SE SELECCIONA UN SPINNER CON LA TABLET HUAWEI

        //ASEGURARME DE QUE EL CAMBIO EN EL ASPECTO DEL BOTON MODIFICAR DEL REGISTRO EN EL SYNC ACTIVITY TMB SE VEA BIEN EN LA TABLET SAMSUNG

        //SOLUCIONAR POSIBLE LEAK DE MEMORIA DEL METODO ONCLICK DEL BOTON SINCRONIZAR!!!! (CERRAR EL CURSOR / BASE DATOS CON UN FINALLY)

        //VER SI ES NECESARIO IMPLEMENTAR UN BOTON ELIMINAR POR CADA REGISTRO EN LA PANTALLA SYNC ACTIVITY!


        //PROPONERLE A JUANCARLOS:

        //NO DISTINGUIR ENTRE ENCUESTAS COMPLETAS E INCOMPLETAS EN EL SYNC ACTIVITY Y EN EL PEOR DE LOS CASOS IMPLEMENTAR UN CAMPO SIMPLE EN LAS ENCUESTAS QUE DISTINGA ENTRE AMBAS!

        //SI SE VAN A UTLIZAR TRIGGERS PARA VALIDAR DATOS REPETIDOS HACER 3 TABLAS Y 3 TRIGGERS MAS PARA LA ENCUESTA6 SIGUIENDO EL SCRIPT DE TRIGGERS GUARDADO EN DOCUMENTOS!!!!!!!!!!!!!!!!!!!!
        //NO FUNCIONA COMO TRIGGER PERO DISTINCT * SI FILTRA DUPLICADOS

        //INTENTAR SINCRONIZAR 1 REGISTRO POR 1 Y LOCKEAR EL BOTON SI SIGUEN HABIENDO PROBLEMAS CON LA SINCRONIZACION

        //QUEDAMOS CON JC EN QUE LOS DUPLICADOS LOS ASUME EL Y NO HAY UPDATE A LAS TABLAS AZURE, ASEGURARME DE QUE SOLO  HAYAN DUPLICADOS DE CABECERA Y AYUDARLO A MANEJARLOS!!!


        //POR DEFECTO QUE LOS CHECKBOX DE SYNC ACTIVITY ESTEN DESACTIVADOS

        //NO OLVIDAR "PINTAR" CAMPOS OBLIGATORIOS: TELCEL, NUMEROHOGAR, CALLE, NUMERO CASA,JEFE HOGAR

        // VER SI SUPERVISOR Y CODIFICADOR SON OBLIGATORIOS TMB (PINTARLOS SI SON OBLIGATORIOS, MODIFICAR VALIDACION SI NO)

        //EN LA PANTALLA PERSONA VER SI CORREO ELECTRONICO Y LAS 2 DIRECCIONES SON OBLIGATORIAS O SOLO UNA DE LAS DOS Y PINTAR TODOS LOS QUE SEAN OBLIGATORIOS DE ACUERDO A ESTO
        //DE IGUAL MANERA CON LAS DIRECCIONES DE LA PANTALLA VIAJES

        //SE CAMBIARON LAS LISTAS QUE GENERABAN PROBLEMAS (3 DOUBLES, 2 HORAS Y 2 MINUTOS) BORRANDOLE LOS DECIMALES, VER QUE NO HAYA PROBLEMA CON ESTO

        //AMPLIAR CANTIDAD DE CARACTERES COMO ARROBA O ASTERISCO EN LAS EXPRESIONES REGULARES DE VALIDACIONES DE CAMPOS COMO NOTAS

        //HAY DETALLES EN LA INSERCION DEL NUEVO NUMERO CELULAR DE LA PANTALLA VIAJES POR SER UN INT CUANDO DEBERIA SER UN STRING (EJ. ESCRIBE 0 EN EL TEXTVIEW EN REINSERCION Y ELIMINA CEROS SI COMIENZA POR CERO), CORREGIR





        //ENCUESTA 6:

        //SE INCLUYO EL DNI ENCUESTADOR EN LAS TABLAS PERSONA6 Y VIAJE6 DE LA BASE DE DATOS ACCESS, AVISAR JUAN CARLOS

        //ESPERAR Y PEDIR INFORMACION QUE FALTE SOBRE LOS CAMPOS: RESPUESTAS A LAS PREGUNTAS 22, 23, 28 Y 29 DEL DOCUMENTO QUE LE MANDO A LA EMPRESA JUAN CARLOS

        //LAS FECHAS DE TODAS LAS ENCUESTAS 6 SE REEMPLAZARAN EN TODOS LADOS POR TIPOS STRING, NOTIFICAR JUAN CARLOS

        //INTENTAR REALIZAR UN PROCEDURE CON COMMIT EN AZURE E INSERTAR REGISTROS DE LA ENCUESTA 6 CON ESE PROCEDURE





        Button btnFecha1=findViewById(R.id.btnFecha1);
        Button btnFecha2=findViewById(R.id.btnFecha2);
        Button btnFecha3=findViewById(R.id.btnFecha3);

        final Spinner spnDominio=findViewById(R.id.spnDominio);
        final Spinner spnDistrito=findViewById(R.id.spnDistrito);
        final Spinner spnSegmento=findViewById(R.id.spnSegmento);
        final Spinner spnVivienda=findViewById(R.id.spnVivienda);

        final TextView txtNumeroHogar=findViewById(R.id.txtNumeroHogar);
        final TextView txtSupervisor=findViewById(R.id.txtSupervisor);
        final TextView txtCodificador=findViewById(R.id.txtCodificador);

        RadioGroup rbgSupervisor=findViewById(R.id.rbgSupervisor);
        final RadioButton rbSupervisor1=findViewById(R.id.rbSupervisor1);
        final RadioButton rbSupervisor2=findViewById(R.id.rbSupervisor2);
        final RadioButton rbSupervisor3=findViewById(R.id.rbSupervisor3);

        RadioGroup rbgCodificador=findViewById(R.id.rbgCodificador);
        final RadioButton rbCodificador1=findViewById(R.id.rbCodificador1);
        final RadioButton rbCodificador2=findViewById(R.id.rbCodificador2);
        final RadioButton rbCodificador3=findViewById(R.id.rbCodificador3);

        final TextView txtNombreJefeHogar=findViewById(R.id.txtNombreJefeHogar);
        final Spinner spnTipoVia=findViewById(R.id.spnTipoVia);
        final TextView txtNombreCalle=findViewById(R.id.txtNombre_Calle);
        final TextView txtNumeroPuerta=findViewById(R.id.txtNumeroPuerta);
        final TextView txtInterior=findViewById(R.id.txtInterior);
        final Spinner spnPiso=findViewById(R.id.spnPiso);
        final TextView txtEtapa=findViewById(R.id.txtEtapa);
        final TextView txtManzana=findViewById(R.id.txtManzana);
        final TextView txtLote=findViewById(R.id.txtLote);
        final Spinner spnZonaTransito=findViewById(R.id.spnZonaTransito);
        final TextView txtTelCel=findViewById(R.id.txtTelCel);
        final TextView txtKilometro=findViewById(R.id.txtKilometro);

        final Spinner spnNivelEducacion=findViewById(R.id.spnNivelEducacion);

        final Spinner spnHombresMenores=findViewById(R.id.spnHombresMenores);
        final Spinner spnHombresMayores=findViewById(R.id.spnHombresMayores);
        final Spinner spnHombresEmpleados=findViewById(R.id.spnHombresEmpleados);
        final Spinner spnMujeresMenores=findViewById(R.id.spnMujeresMenores);
        final Spinner spnMujeresMayores=findViewById(R.id.spnMujeresMayores);
        final Spinner spnMujeresEmpleadas=findViewById(R.id.spnMujeresEmpleadas);

        final Spinner spnRegimenTenencia=findViewById(R.id.spnRegimenTenencia);
        final Spinner spnTipoVivienda=findViewById(R.id.spnTipoVivienda);
        final Spinner spnNumeroHabitaciones=findViewById(R.id.spnNumeroHabitaciones);
        final Spinner spnIngresoMensual=findViewById(R.id.spnIngresoMensual);

        Button btnCrearRegistro=findViewById(R.id.btnCrearRegistro);
        final RecyclerView recRegistro=findViewById(R.id.recRegistro);

        final Spinner spnTelevisores=findViewById(R.id.spnTelevisores);
        final Spinner spnTelefonos=findViewById(R.id.spnTelefonos);
        final Spinner spnRefrigeradoras=findViewById(R.id.spnRefrigeradoras);
        final Spinner spnLavadoras=findViewById(R.id.spnLavadoras);
        final Spinner spnComputadoras=findViewById(R.id.spnComputadoras);
        final Spinner spnAspiradoras=findViewById(R.id.spnAspiradoras);
        final Spinner spnCocinasGas=findViewById(R.id.spnCocinasGas);
        final Spinner spnCocinasElectricas=findViewById(R.id.spnCocinasElectricas);
        final Spinner spnMicroondas=findViewById(R.id.spnMicroondas);

        final Spinner spnMaterialParedes=findViewById(R.id.spnMaterialParedes);
        final Spinner spnMaterialPisos=findViewById(R.id.spnMaterialPisos);
        final Spinner spnAbastecimientoAgua=findViewById(R.id.spnAbastecimientoAgua);
        final Spinner spnServiciosHigienicos=findViewById(R.id.spnServiciosHigienicos);
        final Spinner spnTipoAlumbrado=findViewById(R.id.spnTipoAlumbrado);

        final TextView txtNotas=findViewById(R.id.txtNotas);

        final TextView txtZonaCensal=findViewById(R.id.txtZonaCensal);
        final TextView txtManzanaHogar=findViewById(R.id.txtManzanaHogar);

        final TextView txtOtroVehiculo=findViewById(R.id.txtOtroVehiculo);

        final TextView txtOtroMaterialParedes=findViewById(R.id.txtOtroMaterialParedes);
        final TextView txtOtroMaterialPisos=findViewById(R.id.txtOtroMaterialPisos);
        final TextView txtOtroTipoAlumbrado=findViewById(R.id.txtOtroTipoAlumbrado);
        final TextView txtOtroTipoAbastecimientoAgua=findViewById(R.id.txtOtroTipoAbastecimientoAgua);
        final TextView txtOtroTipoServiciosHigienicos=findViewById(R.id.txtOtroTipoServiciosHigienicos);

        lblCoordenadasUbicacion=findViewById(R.id.lblCoordenadasUbicacion);

        final Spinner spnStatusEncuestas=findViewById(R.id.spnStatusEncuestas);


        final TextView lblFecha1=findViewById(R.id.lblFecha1);
        final TextView lblFecha2=findViewById(R.id.lblFecha2);
        final TextView lblFecha3=findViewById(R.id.lblFecha3);


        Button btnCrearPersona=findViewById(R.id.btnCrearPersona);
        RecyclerView recPersona=findViewById(R.id.recPersona);

        Button btnGuardarEncuesta1=findViewById(R.id.btnGuardarEncuesta1);

        Button btnCoordenadasUbicacion=findViewById(R.id.btnCoordenadasUbicacion);







        spnDominio.setEnabled(false);
        spnDistrito.setEnabled(false);
        spnVivienda.setEnabled(false);

        // txtZonaCensal y txtManzanaHogar fueron deshabilitados en el xml, ver si hay problemas con esto





        String[] listaTipoVia={"Seleccionar","Avenida","Jiron","Calle","Pasaje","Alameda","Malecon","Ovalo","Parque","Plaza","Carretera","Block","Trocha","Camino Rural","Bajada","Galeria","Prolongacion","Paseo","Plazuela","Portal","C. Afirmado","T. Carrozable","P. VIV.","Pueblo Joven","Poblado","Cooperativa","Asentamiento Humano"};
        ArrayAdapter<String> adapterTipoVia = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTipoVia);
        spnTipoVia.setAdapter(adapterTipoVia);

        String[] listaPiso={"--","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","-1","-2","-3","-4"};
        ArrayAdapter<String> adapterPiso = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPiso);
        spnPiso.setAdapter(adapterPiso);

        String[] listaNivelEducacion={"Seleccionar","Analfabeto","Primaria Incompleta","Primaria Completa","Secundaria Incompleta","Secundaria Completa","Superior no Universitaria Incompleta","Superior no Universitaria Completa","Universitaria Incompleta","Universitaria Completa","Maestria/Postgrado/Doctorado"};
        ArrayAdapter<String> adapterNivelEducacion = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNivelEducacion);
        spnNivelEducacion.setAdapter(adapterNivelEducacion);

        String[] listaHombresMenores={"--","0","1","2","3","4","5","6","7","8","9"};
        ArrayAdapter<String> adapterHombresMenores = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaHombresMenores);
        spnHombresMenores.setAdapter(adapterHombresMenores);

        String[] listaHombresMayores={"--","0","1","2","3","4","5","6","7","8","9"};
        ArrayAdapter<String> adapterHombresMayores = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaHombresMayores);
        spnHombresMayores.setAdapter(adapterHombresMayores);

        String[] listaHombresEmpleados={"--","0","1","2","3","4","5","6","7","8","9"};
        ArrayAdapter<String> adapterHombresEmpleados = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaHombresEmpleados);
        spnHombresEmpleados.setAdapter(adapterHombresEmpleados);

        String[] listaMujeresMenores={"--","0","1","2","3","4","5","6","7","8","9"};
        ArrayAdapter<String> adapterMujeresMenores = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaMujeresMenores);
        spnMujeresMenores.setAdapter(adapterMujeresMenores);

        String[] listaMujeresMayores={"--","0","1","2","3","4","5","6","7","8","9"};
        ArrayAdapter<String> adapterMujeresMayores = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaMujeresMayores);
        spnMujeresMayores.setAdapter(adapterMujeresMayores);

        String[] listaMujeresEmpleadas={"--","0","1","2","3","4","5","6","7","8","9"};
        ArrayAdapter<String> adapterMujeresEmpleadas = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaMujeresEmpleadas);
        spnMujeresEmpleadas.setAdapter(adapterMujeresEmpleadas);

        String[] listaRegimenTenencia={"Seleccionar","Propia","Alquilada","Usufructuada","Invasión","Otro"};
        ArrayAdapter<String> adapterRegimenTenencia = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaRegimenTenencia);
        spnRegimenTenencia.setAdapter(adapterRegimenTenencia);

        String[] listaTipoVivienda={"Seleccionar","Casa Independiente","Vivienda en Condominio","Departamento en Edificio","Vivienda en Quinta","Vivienda en Vecindad (Solar, Callejon)","Otros"};
        ArrayAdapter<String> adapterTipoVivienda = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTipoVivienda);
        spnTipoVivienda.setAdapter(adapterTipoVivienda);

        String[] listaNumeroHabitaciones={"--","0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        ArrayAdapter<String> adapterNumeroHabitaciones = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNumeroHabitaciones);
        spnNumeroHabitaciones.setAdapter(adapterNumeroHabitaciones);

        String[] listaTelevisores={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        ArrayAdapter<String> adapterTelevisores = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTelevisores);
        spnTelevisores.setAdapter(adapterTelevisores);

        String[] listaTelefonos={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        ArrayAdapter<String> adapterTelefonos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTelefonos);
        spnTelefonos.setAdapter(adapterTelefonos);

        String[] listaRefrigeradoras={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        ArrayAdapter<String> adapterRefrigeradoras = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaRefrigeradoras);
        spnRefrigeradoras.setAdapter(adapterRefrigeradoras);

        String[] listaLavadoras={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        ArrayAdapter<String> adapterLavadoras = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaLavadoras);
        spnLavadoras.setAdapter(adapterLavadoras);

        String[] listaComputadoras={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        ArrayAdapter<String> adapterComputadoras = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaComputadoras);
        spnComputadoras.setAdapter(adapterComputadoras);

        String[] listaAspiradoras={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        ArrayAdapter<String> adapterAspiradoras = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAspiradoras);
        spnAspiradoras.setAdapter(adapterAspiradoras);

        String[] listaCocinasGas={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        ArrayAdapter<String> adapterCocinasGas = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaCocinasGas);
        spnCocinasGas.setAdapter(adapterCocinasGas);

        String[] listaCocinasElectricas={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        ArrayAdapter<String> adapterCocinasElectricas = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaCocinasElectricas);
        spnCocinasElectricas.setAdapter(adapterCocinasElectricas);

        String[] listaMicroondas={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        ArrayAdapter<String> adapterMicroondas = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaMicroondas);
        spnMicroondas.setAdapter(adapterMicroondas);

        String[] listaIngresoMensual={"Seleccionar","Menos de S/ 600","S/ 601 - S/ 1000","S/ 1001 - S/ 1500","S/ 1501 - S/ 2000","S/ 2001 - S/ 3000","S/ 3001 - S/ 4000","S/ 4001 - S/ 7000","S/ 7001 - S/ 10000","Mayor de S/ 10000"};
        ArrayAdapter<String> adapterIngresoMensual = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaIngresoMensual);
        spnIngresoMensual.setAdapter(adapterIngresoMensual);

        String[] listaMaterialParedes={"Seleccionar","Ladrillo o Bloque de Cemento","Piedra o Sillar, con Cal o Cemento","Adobe o Tapia","Quincha","Piedra con Barro","Madera","Estera","Otro"};
        ArrayAdapter<String> adapterMaterialParedes = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaMaterialParedes);
        spnMaterialParedes.setAdapter(adapterMaterialParedes);

        String[] listaMaterialPisos={"Seleccionar","Parquet o Madera pulida","Laminas asfalticas / vinilicos o similares","Loseta, terrazos o similares","Madera (Entablados)","Cemento","Tierra","Otro"};
        ArrayAdapter<String> adapterMaterialPisos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaMaterialPisos);
        spnMaterialPisos.setAdapter(adapterMaterialPisos);

        String[] listaTipoAlumbrado={"Seleccionar","Electricidad","Kerosene (Mechero o Lamparin)","Petroleo/Gas (Lampara)","Vela","Otro"};
        ArrayAdapter<String> adapterTipoAlumbrado = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTipoAlumbrado);
        spnTipoAlumbrado.setAdapter(adapterTipoAlumbrado);

        String[] listaAbastecimientoAgua={"Seleccionar","Red publica dentro de la vivienda","Red publica fuera de la vivienda pero dentro del edificio","Pilon de uso publico","Camion/Cisterna u otro similar","Pozo","Rio, Acequia, Manantial o similar","Otro"};
        ArrayAdapter<String> adapterAbastecimientoAgua = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAbastecimientoAgua);
        spnAbastecimientoAgua.setAdapter(adapterAbastecimientoAgua);

        String[] listaServiciosHigienicos={"Seleccionar","Red publica dentro de la vivienda","Red publica fuera de la vivienda pero dentro del edificio","Pozo septico","Pozo ciego o negro / Letrina","Rio / Acequia / Canal","No tiene","Otro"};
        ArrayAdapter<String> adapterServiciosHigienicos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaServiciosHigienicos);
        spnServiciosHigienicos.setAdapter(adapterServiciosHigienicos);

        String[] listaStatusEncuestas={"Seleccionar","Completada","Pendiente","Observada"};
        ArrayAdapter<String> adapterStatusEncuestas = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaStatusEncuestas);
        spnStatusEncuestas.setAdapter(adapterStatusEncuestas);



        //SPINNERS TEMPORALES (?):


        String[] listaZonaTransito={"Selec.","Zona Transito 1","Zona Transito 2"};
        ArrayAdapter<String> adapterZonaTransito = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaZonaTransito);
        spnZonaTransito.setAdapter(adapterZonaTransito);

        String[] listaDistrito={"---","Cercado de Lima","Ancon","Ate","Barranco","Breña","Carabayllo","Comas","Chaclacayo","Chorrillos","El Agustino","Jesus Maria","La Molina","La Victoria","Lince","Lurigancho","Lurin","Magdalena del Mar","Miraflores","Pachacamac","Pucusana","Pueblo Libre","Puente Piedra","Punta Negra","Punta Hermosa","Rimac","San Bartolo","San Isidro","Independencia","San Juan de Miraflores","San Luis","San Martin de Porres","San Miguel","Santiago de Surco","Surquillo","Villa Maria del Triunfo","San Juan de Lurigancho","Santa Maria del Mar","Santa Rosa","Los Olivos","Cieneguilla","San Borja","Villa el Salvador","Santa Anita","Bellavista","Callao","Carmen de la Legua","La Perla","La Punta","Ventanilla","Mi Peru"};
        ArrayAdapter<String> adapterDistrito = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDistrito);
        spnDistrito.setAdapter(adapterDistrito);

        String[] listaDominio={"---","Centro de Lima","Cono Norte","Cono Sur","Cono Este","Callao"};
        ArrayAdapter<String> adapterDominio = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDominio);
        spnDominio.setAdapter(adapterDominio);

        String[] listaSegmento={"---","Segmento A","Segmento B","Segmento C","Segmento D","Segmento E"};
        ArrayAdapter<String> adapterSegmento = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaSegmento);
        spnSegmento.setAdapter(adapterSegmento);

        String[] listaVivienda={"---","Vivienda 1","Vivienda 2","Vivienda 3","Vivienda 4","Vivienda 5","Vivienda 6","Vivienda 7","Vivienda 8","Vivienda 9"};
        ArrayAdapter<String> adapterVivienda = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaVivienda);
        spnVivienda.setAdapter(adapterVivienda);

        // PUDEN SER TEMPORALES TAMBIEN: LOS 2 SPINNERS DEL RECYCLER DE TRAMOS (PANATALLA VIAJES)







        // A MAS TARDAR EN ESTE PUNTO, TODOS LOS CONTROLES (TextView) YA DEBEN TENER LOS VALORES INICIALES APROPIADOS (O BIEN VACIOS O BIEN EXTRAIDOS DE UN REGISTRO INCOMPLETO SELECCIONADO EN LA PANT. ANTERIOR)


        recRegistro.setItemViewCacheSize(50);
        recRegistro.setLayoutManager(new LinearLayoutManager(this));
        adapter=new AdaptadorListaVehiculos(this,listaVehiculos);
        recRegistro.setAdapter(adapter);


        recPersona.setItemViewCacheSize(30);
        recPersona.setLayoutManager(new LinearLayoutManager(this));
        adapterPersonas=new AdaptadorListaPersonas1(this,listaPersonas,3);
        recPersona.setAdapter(adapterPersonas);
        recPersona.setItemAnimator(null);



        if(LoginActivity.modificarEncuesta==false){

            Date currentTime = Calendar.getInstance().getTime();

        //    SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");

            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

            fechaCreacion=dt1.format(currentTime);

            btnFecha2.setEnabled(false);

            btnFecha3.setEnabled(false);

        }




        if(LoginActivity.modificarEncuesta==true){



            SQLiteDatabase b=sqlite.getWritableDatabase();


            final String indiceOriginal=LoginActivity.indiceModificarEncuesta;


         final Cursor c=b.rawQuery("SELECT * FROM Encuesta_1 WHERE Id_enc =?", new String []{LoginActivity.indiceModificarEncuesta});




            if(c.moveToFirst()) {

                do{


                    txtNumeroHogar.setText(c.getInt(c.getColumnIndex("Id_enc"))+"");

                    //DNI ENCUESTADOR

                    fechaCreacion=c.getString(c.getColumnIndex("Fyh_enc"));

                    if(c.getString(c.getColumnIndex("Fv1_enc"))!=null){f1= c.getString(c.getColumnIndex("Fv1_enc"));}

                    if(c.getString(c.getColumnIndex("Fv2_enc"))!=null){f2= c.getString(c.getColumnIndex("Fv2_enc"));}

                    if(c.getString(c.getColumnIndex("Fv3_enc"))!=null){f3= c.getString(c.getColumnIndex("Fv3_enc"));}


                    spnDominio.setSelection(eSpinner(spnDominio,c.getString(c.getColumnIndex("Dom_enc"))));

                    spnDistrito.setSelection(eSpinner(spnDistrito,c.getString(c.getColumnIndex("Dis_enc"))));

                    spnSegmento.setSelection(c.getInt(c.getColumnIndex("Seg_enc")));

                    spnVivienda.setSelection(c.getInt(c.getColumnIndex("Viv_enc")));

                    txtSupervisor.setText(c.getString(c.getColumnIndex("Sup_enc")));

                    //SELECCIONAR ACA EL RADIO BUTTON GROUP 1 (SUPERVISOR) EN BASE A LO SELECCIONADO

                    txtCodificador.setText(c.getString(c.getColumnIndex("Cod_enc")));

                    //SELECCIONAR ACA EL RADIO BUTTON GROUP 2 (CODIFICADOR) EN BASE A LO SELECCIONADO

                    txtNombreJefeHogar.setText(c.getString(c.getColumnIndex("Njh_Q1_enc")));

                    spnTipoVia.setSelection(c.getInt(c.getColumnIndex("Tvi_Q2a_enc")));

                    txtNombreCalle.setText(c.getString(c.getColumnIndex("Nombre_Calle")));

                    txtNumeroPuerta.setText(c.getString(c.getColumnIndex("Num_Q2a_enc")));

                    txtInterior.setText(c.getString(c.getColumnIndex("Int_Q2a_enc")));

                    spnPiso.setSelection(eSpinner(spnPiso,c.getString(c.getColumnIndex("Pis_Q2a_enc"))));

                    txtEtapa.setText(c.getString(c.getColumnIndex("Eta_Q2a_enc")));

                    txtManzana.setText(c.getString(c.getColumnIndex("Mzn_Q2a_enc")));

                    txtLote.setText(c.getString(c.getColumnIndex("Lote_Q2a_enc")));

                    txtKilometro.setText(c.getDouble(c.getColumnIndex("Km_Q2a_enc"))+"");        //PUEDE CAUSAR ERROR?

                    txtTelCel.setText(c.getString(c.getColumnIndex("Tel_Q2a_enc")));

                    spnZonaTransito.setSelection(eSpinner(spnZonaTransito,c.getString(c.getColumnIndex("Zon_Q2a_enc"))));

                    spnNivelEducacion.setSelection(c.getInt(c.getColumnIndex("NedQ3_enc")));

                    spnHombresMenores.setSelection(eSpinner(spnHombresMenores,c.getInt(c.getColumnIndex("RMen6H_Q4_enc"))+""));

                    spnHombresMayores.setSelection(eSpinner(spnHombresMayores,c.getInt(c.getColumnIndex("RMay6H_Q4_enc"))+""));

                    spnMujeresMayores.setSelection(eSpinner(spnMujeresMayores,c.getInt(c.getColumnIndex("RMay6M_Q4_enc"))+""));

                    spnMujeresMenores.setSelection(eSpinner(spnMujeresMenores,c.getInt(c.getColumnIndex("RMen6M_Q4_enc"))+""));

                    spnHombresEmpleados.setSelection(eSpinner(spnHombresEmpleados,c.getInt(c.getColumnIndex("REmhH_Q4_enc"))+""));

                    spnMujeresEmpleadas.setSelection(eSpinner(spnMujeresEmpleadas,c.getInt(c.getColumnIndex("REmhM_Q4_enc"))+""));

                    spnRegimenTenencia.setSelection(c.getInt(c.getColumnIndex("Rdt_Q5a_enc")));

                    spnTipoVivienda.setSelection(c.getInt(c.getColumnIndex("Tviv_Q5b_enc")));

                    spnNumeroHabitaciones.setSelection(eSpinner(spnNumeroHabitaciones,c.getInt(c.getColumnIndex("Hab_Q5c_enc"))+""));

                    spnIngresoMensual.setSelection(c.getInt(c.getColumnIndex("Ing_Q6_enc")));







                    int w=0;

                    for(int q=0;q<c.getInt(c.getColumnIndex("Bici_Und_Q7_enc"));q++){

                        listaVehiculos.add(new Object());
                        adapter.notifyItemInserted(w);

                        w++;
                    }

                    for(int q=0;q<c.getInt(c.getColumnIndex("Moto_Und_Q7_enc"));q++){

                        listaVehiculos.add(new Object());
                        adapter.notifyItemInserted(w);

                        w++;
                    }


                    //MOTOTAXI:

                    for(int q=0;q<c.getInt(c.getColumnIndex("Mototaxi_Unidades"));q++){

                        listaVehiculos.add(new Object());
                        adapter.notifyItemInserted(w);

                        w++;
                    }




                    for(int q=0;q<c.getInt(c.getColumnIndex("Carro_Und_Q7_enc"));q++){

                        listaVehiculos.add(new Object());
                        adapter.notifyItemInserted(w);

                        w++;
                    }


                    //TAXI:

                    for(int q=0;q<c.getInt(c.getColumnIndex("Taxi_Unidades"));q++){

                        listaVehiculos.add(new Object());
                        adapter.notifyItemInserted(w);

                        w++;
                    }




                    for(int q=0;q<c.getInt(c.getColumnIndex("Rural_Und_Q7_enc"));q++){

                        listaVehiculos.add(new Object());
                        adapter.notifyItemInserted(w);

                        w++;
                    }

                    for(int q=0;q<c.getInt(c.getColumnIndex("Micro_Und_Q7_enc"));q++){

                        listaVehiculos.add(new Object());
                        adapter.notifyItemInserted(w);

                        w++;
                    }

                    for(int q=0;q<c.getInt(c.getColumnIndex("Omnib_Und_Q7_enc"));q++){

                        listaVehiculos.add(new Object());
                        adapter.notifyItemInserted(w);

                        w++;
                    }

                    for(int q=0;q<c.getInt(c.getColumnIndex("Camio_Und_Q7_enc"));q++){

                        listaVehiculos.add(new Object());
                        adapter.notifyItemInserted(w);

                        w++;
                    }

                    for(int q=0;q<c.getInt(c.getColumnIndex("Trail_Und_Q7_enc"));q++){

                        listaVehiculos.add(new Object());
                        adapter.notifyItemInserted(w);

                        w++;
                    }

                    for(int q=0;q<c.getInt(c.getColumnIndex("Otro_Und_Q7_enc"));q++){

                        listaVehiculos.add(new Object());
                        adapter.notifyItemInserted(w);

                        w++;
                    }




                    AlertDialog alertDialog = new AlertDialog.Builder(PantallaEncuesta1.this).create();
                    alertDialog.setTitle("Atención");


                    alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {

                            SQLiteDatabase based=sqlite.getWritableDatabase();

                           // System.out.println("RRRRRRRRRRRRRRRRRRR "+indiceOriginal);

                            Cursor c=based.rawQuery("SELECT * FROM Encuesta_1 WHERE Id_enc =?", new String []{indiceOriginal});

                            if(c.moveToFirst()) {

                                do{

                            int w=0;

                            for(int q=0;q<c.getInt(c.getColumnIndex("Bici_Und_Q7_enc"));q++){

                              //  listaVehiculos.add(new Object());
                              //  adapter.notifyItemInserted(w);


                                Spinner spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnTipoVehiculo);
                                spnA.setSelection(0);

                                if(q==0){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Bici_Ant1_Q7_enc")));

                                }

                                if(q==1){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Bici_Ant2_Q7_enc")));

                                }

                                if(q==2){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Bici_Ant3_Q7_enc")));

                                }

                                if(q==3){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Bici_Ant4_Q7_enc")));

                                }

                                w++;
                            }




                            for(int q=0;q<c.getInt(c.getColumnIndex("Moto_Und_Q7_enc"));q++){

                             //   listaVehiculos.add(new Object());
                             //   adapter.notifyItemInserted(w);


                                Spinner spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnTipoVehiculo);
                                spnA.setSelection(1);

                                if(q==0){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Moto_Ant1_Q7_enc")));

                                }

                                if(q==1){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Moto_Ant2_Q7_enc")));

                                }

                                if(q==2){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Moto_Ant3_Q7_enc")));

                                }

                                if(q==3){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Moto_Ant4_Q7_enc")));

                                }

                                w++;
                            }





                            //MOTOTAXI:


                                    for(int q=0;q<c.getInt(c.getColumnIndex("Mototaxi_Unidades"));q++){

                                        //  listaVehiculos.add(new Object());
                                        //  adapter.notifyItemInserted(w);


                                        Spinner spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnTipoVehiculo);
                                        spnA.setSelection(2);

                                        if(q==0){

                                            spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                            spnA.setSelection(c.getInt(c.getColumnIndex("Mototaxi_Ant1")));

                                        }

                                        if(q==1){

                                            spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                            spnA.setSelection(c.getInt(c.getColumnIndex("Mototaxi_Ant2")));

                                        }

                                        if(q==2){

                                            spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                            spnA.setSelection(c.getInt(c.getColumnIndex("Mototaxi_Ant3")));

                                        }

                                        if(q==3){

                                            spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                            spnA.setSelection(c.getInt(c.getColumnIndex("Mototaxi_Ant4")));

                                        }

                                        w++;
                                    }








                            for(int q=0;q<c.getInt(c.getColumnIndex("Carro_Und_Q7_enc"));q++){

                             //   listaVehiculos.add(new Object());
                             //   adapter.notifyItemInserted(w);


                                Spinner spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnTipoVehiculo);
                                spnA.setSelection(3);

                                if(q==0){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Carro_Ant1_Q7_enc")));

                                }

                                if(q==1){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Carro_Ant2_Q7_enc")));

                                }

                                if(q==2){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Carro_Ant3_Q7_enc")));

                                }

                                if(q==3){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Carro_Ant4_Q7_enc")));

                                }

                                w++;
                            }




                            //TAXI:


                                    for(int q=0;q<c.getInt(c.getColumnIndex("Taxi_Unidades"));q++){

                                        //  listaVehiculos.add(new Object());
                                        //  adapter.notifyItemInserted(w);


                                        Spinner spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnTipoVehiculo);
                                        spnA.setSelection(4);

                                        if(q==0){

                                            spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                            spnA.setSelection(c.getInt(c.getColumnIndex("Taxi_Ant1")));

                                        }

                                        if(q==1){

                                            spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                            spnA.setSelection(c.getInt(c.getColumnIndex("Taxi_Ant2")));

                                        }

                                        if(q==2){

                                            spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                            spnA.setSelection(c.getInt(c.getColumnIndex("Taxi_Ant3")));

                                        }

                                        if(q==3){

                                            spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                            spnA.setSelection(c.getInt(c.getColumnIndex("Taxi_Ant4")));

                                        }

                                        w++;
                                    }









                            for(int q=0;q<c.getInt(c.getColumnIndex("Rural_Und_Q7_enc"));q++){

                             //   listaVehiculos.add(new Object());
                             //   adapter.notifyItemInserted(w);


                                Spinner spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnTipoVehiculo);
                                spnA.setSelection(5);

                                if(q==0){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Rural_Ant1_Q7_enc")));

                                }

                                if(q==1){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Rural_Ant2_Q7_enc")));

                                }

                                if(q==2){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Rural_Ant3_Q7_enc")));

                                }

                                if(q==3){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Rural_Ant4_Q7_enc")));

                                }

                                w++;
                            }




                            for(int q=0;q<c.getInt(c.getColumnIndex("Micro_Und_Q7_enc"));q++){

                             //   listaVehiculos.add(new Object());
                             //   adapter.notifyItemInserted(w);


                                Spinner spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnTipoVehiculo);
                                spnA.setSelection(6);

                                if(q==0){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Micro_Ant1_Q7_enc")));

                                }

                                if(q==1){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Micro_Ant2_Q7_enc")));

                                }

                                if(q==2){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Micro_Ant3_Q7_enc")));

                                }

                                if(q==3){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Micro_Ant4_Q7_enc")));

                                }

                                w++;
                            }




                            for(int q=0;q<c.getInt(c.getColumnIndex("Omnib_Und_Q7_enc"));q++){

                            //    listaVehiculos.add(new Object());
                            //    adapter.notifyItemInserted(w);


                                Spinner spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnTipoVehiculo);
                                spnA.setSelection(7);

                                if(q==0){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Omnib_Ant1_Q7_enc")));

                                }

                                if(q==1){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Omnib_Ant2_Q7_enc")));

                                }

                                if(q==2){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Omnib_Ant3_Q7_enc")));

                                }

                                if(q==3){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Omnib_Ant4_Q7_enc")));

                                }

                                w++;
                            }




                            for(int q=0;q<c.getInt(c.getColumnIndex("Camio_Und_Q7_enc"));q++){

                              //  listaVehiculos.add(new Object());
                              //  adapter.notifyItemInserted(w);


                                Spinner spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnTipoVehiculo);
                                spnA.setSelection(8);

                                if(q==0){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Camio_Ant1_Q7_enc")));

                                }

                                if(q==1){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Camio_Ant2_Q7_enc")));

                                }

                                if(q==2){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Camio_Ant3_Q7_enc")));

                                }

                                if(q==3){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Camio_Ant4_Q7_enc")));

                                }

                                w++;
                            }



                            for(int q=0;q<c.getInt(c.getColumnIndex("Trail_Und_Q7_enc"));q++){

                             //   listaVehiculos.add(new Object());
                             //   adapter.notifyItemInserted(w);


                                Spinner spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnTipoVehiculo);
                                spnA.setSelection(9);

                                if(q==0){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Trail_Ant1_Q7_enc")));

                                }

                                if(q==1){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Trail_Ant2_Q7_enc")));

                                }

                                if(q==2){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Trail_Ant3_Q7_enc")));

                                }

                                if(q==3){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Trail_Ant4_Q7_enc")));

                                }

                                w++;
                            }




                            for(int q=0;q<c.getInt(c.getColumnIndex("Otro_Und_Q7_enc"));q++){

                             //   listaVehiculos.add(new Object());
                             //   adapter.notifyItemInserted(w);


                                Spinner spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnTipoVehiculo);
                                spnA.setSelection(10);

                                if(q==0){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Otro_Ant1_Q7_enc")));

                                }

                                if(q==1){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Otro_Ant2_Q7_enc")));

                                }

                                if(q==2){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Otro_Ant3_Q7_enc")));

                                }

                                if(q==3){

                                    spnA=recRegistro.findViewHolderForAdapterPosition(w).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    spnA.setSelection(c.getInt(c.getColumnIndex("Otro_Ant4_Q7_enc")));

                                }

                                w++;
                            }


                                }while(c.moveToNext());

                            }

                            c.close();






                            based.beginTransaction();
                            try {

                                based.delete("Encuesta_1","Id_enc=?",new String[]{LoginActivity.indiceModificarEncuesta});   //PROBLEMAS ACA PORQUE ID_ENC ES INTEGER Y SE PASA STRING?

                                based.delete("Detalle_Informacion_Personal_Anexo_1","Enc_inpe=?",new String[]{LoginActivity.indiceModificarEncuesta});

                                based.delete("Detalle_de_Viajes_Anexo_1","Enc_dvia=?",new String[]{LoginActivity.indiceModificarEncuesta});


                                based.setTransactionSuccessful();
                            } catch(Exception e){
                                System.out.println("ERROR EN UNO DE LOS 3 DELETES EN LA PANTALLA1 !!!!!!!!!!");
                            } finally {
                                based.endTransaction();
                            }






                            //SIGUE ACA O EN EL FINALLY?


                            //PARA NOTIFICAR LA ELIMINACION ES NECESARIO SOLO EL SIGUIENTE NOTIFY (U OTRO TIPO DE NOTIFY) O TAMBIEN EL REMOVE DE LA LISTA?

                            //SyncActivity.lista.remove(LoginActivity.indicePosicion);
                            //SyncActivity.adapter.notifyItemRemoved(LoginActivity.indicePosicion);




                            SyncActivity.lista.clear();

                            SyncActivity.lista.addAll(SyncActivity.listarBase(getApplicationContext()));

                            SyncActivity.adapter.notifyDataSetChanged();








                            LoginActivity.modificarEncuesta=false;

                            LoginActivity.indiceModificarEncuesta="-100";

                            LoginActivity.indicePosicion=-100;







                            based.close();



                        }
                    });




                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    dialog.dismiss();

                                }
                            });


                    alertDialog.setMessage("Revise sus datos y presione 'Guardar Encuesta' cuando este listo para actualizar su registro.");
                    alertDialog.show();







                    spnTelevisores.setSelection(c.getInt(c.getColumnIndex("Telev_Und_Q8_enc")));

                    spnTelefonos.setSelection(c.getInt(c.getColumnIndex("Telef_Und_Q8_enc")));

                    spnRefrigeradoras.setSelection(c.getInt(c.getColumnIndex("Refri_Und_Q8_enc")));

                    spnLavadoras.setSelection(c.getInt(c.getColumnIndex("Lavad_Und_Q8_enc")));

                    spnComputadoras.setSelection(c.getInt(c.getColumnIndex("Compu_Und_Q8_enc")));

                    spnAspiradoras.setSelection(c.getInt(c.getColumnIndex("Aspir_Und_Q8_enc")));

                    spnCocinasGas.setSelection(c.getInt(c.getColumnIndex("Cogas_Und_Q8_enc")));

                    spnCocinasElectricas.setSelection(c.getInt(c.getColumnIndex("Coele_Und_Q8_enc")));

                    spnMicroondas.setSelection(c.getInt(c.getColumnIndex("Micro_Und_Q8_enc")));


                    spnMaterialParedes.setSelection(c.getInt(c.getColumnIndex("MatPrePa_enc")));

                    spnMaterialPisos.setSelection(c.getInt(c.getColumnIndex("MatPrePi_enc")));

                    spnTipoAlumbrado.setSelection(c.getInt(c.getColumnIndex("TipAlum_enc")));

                    spnAbastecimientoAgua.setSelection(c.getInt(c.getColumnIndex("TipAgua_enc")));

                    spnServiciosHigienicos.setSelection(c.getInt(c.getColumnIndex("TipHig_enc")));

                    txtNotas.setText(c.getString(c.getColumnIndex("Not_enc")));

                    txtManzanaHogar.setText(c.getString(c.getColumnIndex("Manza_enc")));

                    txtZonaCensal.setText(c.getString(c.getColumnIndex("Zonce_enc")));

                    txtOtroVehiculo.setText(c.getString(c.getColumnIndex("OtroTipo_Vehiculo")));

                    txtOtroMaterialParedes.setText(c.getString(c.getColumnIndex("OtroMat_Paredes")));

                    txtOtroMaterialPisos.setText(c.getString(c.getColumnIndex("OtroMat_Pisos")));

                    txtOtroTipoAlumbrado.setText(c.getString(c.getColumnIndex("OtroTipo_Alum")));

                    txtOtroTipoAbastecimientoAgua.setText(c.getString(c.getColumnIndex("OtroTipo_Agua")));

                    txtOtroTipoServiciosHigienicos.setText(c.getString(c.getColumnIndex("OtroTipo_ServHigienico")));

                    coordUbicacion=c.getString(c.getColumnIndex("Coordenadas_Ubicacion"));

                    spnStatusEncuestas.setSelection(eSpinner(spnStatusEncuestas,c.getString(c.getColumnIndex("Hog_enc"))));







                }while(c.moveToNext());

            }

            c.close();




            Cursor c2=b.rawQuery("SELECT * FROM Detalle_Informacion_Personal_Anexo_1 WHERE Enc_inpe =?", new String []{LoginActivity.indiceModificarEncuesta});



            List<Detalle_Informacion_Personal_Anexo_1> listPersonas=new ArrayList<>();

            if(c2.moveToFirst()) {

                do {

                    Detalle_Informacion_Personal_Anexo_1 pe=new Detalle_Informacion_Personal_Anexo_1();

                    //LOS 3 PRIMEROS CAMPOS SE AÑADEN DESPUES, ASEGURARME DE QUE SE AÑADAN BIEN EN LAS PRUEBAS DE INSERCION A AZURE!

                    pe.setNom_inpe(c2.getString(c2.getColumnIndex("Nom_inpe")));

                    pe.setPar_Q9_inpe(c2.getInt(c2.getColumnIndex("Par_Q9_inpe")));

                    pe.setSex_Q10_inpe(c2.getInt(c2.getColumnIndex("Sex_Q10_inpe")));

                    pe.setEdad_Q11_inpe(c2.getInt(c2.getColumnIndex("Edad_Q11_inpe")));

                    pe.setDisc_Q12a_inpe(c2.getInt(c2.getColumnIndex("Disc_Q12a_inpe")));

                    pe.setAyuv_Q12b_inpe(c2.getInt(c2.getColumnIndex("Ayuv_Q12b_inpe")));

                    pe.setOcu_Q13_inpe(c2.getInt(c2.getColumnIndex("Ocu_Q13_inpe")));

                    pe.setAct_Q14_inpe(c2.getInt(c2.getColumnIndex("Act_Q14_inpe")));

                    pe.setLic_Q15a_inpe(c2.getInt(c2.getColumnIndex("Lic_Q15a_inpe")));


                    pe.setOpeCelQ16_inpe(c2.getInt(c2.getColumnIndex("OpeCelQ16_inpe")));


                    pe.setEma_Q15b_inpe(c2.getString(c2.getColumnIndex("Ema_Q15b_inpe")));

                    pe.setTraDis_Q16a_inpe(c2.getString(c2.getColumnIndex("TraDis_Q16a_inpe")));

                    pe.setTraDir_Q16a_inpe(c2.getString(c2.getColumnIndex("TraDir_Q16a_inpe")));

                    pe.setTraRef_Q16a_inpe(c2.getString(c2.getColumnIndex("TraRef_Q16a_inpe")));

                    pe.setEstDis_Q16a_inpe(c2.getString(c2.getColumnIndex("EstDis_Q16a_inpe")));

                    pe.setEstDir_Q16a_inpe(c2.getString(c2.getColumnIndex("EstDir_Q16a_inpe")));

                    pe.setEstRef_Q16a_inpe(c2.getString(c2.getColumnIndex("EstRef_Q16a_inpe")));


                    pe.setViajeMasLargo_Persona(c2.getInt(c2.getColumnIndex("ViajeMasLargo_Persona")));                 // 4/5 A CAMBIAR




                    Cursor c3=b.rawQuery("SELECT * FROM Detalle_de_Viajes_Anexo_1 WHERE Enc_dvia =? AND Per_dvia =?", new String []{LoginActivity.indiceModificarEncuesta, ""+c2.getInt(c2.getColumnIndex("Per_inpe"))});

                    List<Detalle_de_Viajes_Anexo_1> listViajes=new ArrayList<>();

                    if(c3.moveToFirst()) {

                        do {

                            Detalle_de_Viajes_Anexo_1 vi=new Detalle_de_Viajes_Anexo_1();

                            //LOS PRIMEROS 4 CAMPOS SE ASIGNAN MAS ADELANTE, ASEGURARME DE QUE SE AÑADAN BIEN EN LAS PRUEBAS DE INSERCION A AZURE!

                            vi.setOriDis_Q17_dvia(c3.getString(c3.getColumnIndex("OriDis_Q17_dvia")));

                            vi.setOriDir_Q17_dvia(c3.getString(c3.getColumnIndex("OriDir_Q17_dvia")));

                            vi.setOriRef_Q17_dvia(c3.getString(c3.getColumnIndex("OriRef_Q17_dvia")));

                            vi.setOriZtra_Q17_dvia(c3.getString(c3.getColumnIndex("OriZtra_Q17_dvia")));

                            vi.setOriLug_Q18_dvia(c3.getInt(c3.getColumnIndex("OriLug_Q18_dvia")));

                            vi.setOriHor_Q19_dvia(c3.getInt(c3.getColumnIndex("OriHor_Q19_dvia")));

                            vi.setOriMin_Q19_dvia(c3.getInt(c3.getColumnIndex("OriMin_Q19_dvia")));

                            vi.setOriAmPm_Q19_dvia(c3.getInt(c3.getColumnIndex("OriAmPm_Q19_dvia")));

                            vi.setDesDis_Q20_dvia(c3.getString(c3.getColumnIndex("DesDis_Q20_dvia")));

                            vi.setDesDir_Q20_dvia(c3.getString(c3.getColumnIndex("DesDir_Q20_dvia")));

                            vi.setDesRef_Q20_dvia(c3.getString(c3.getColumnIndex("DesRef_Q20_dvia")));

                            vi.setDesZtra_Q20_dvia(c3.getString(c3.getColumnIndex("DesZtra_Q20_dvia")));

                            vi.setDesLug_Q21_dvia(c3.getInt(c3.getColumnIndex("DesLug_Q21_dvia")));

                            vi.setDesHor_Q22_dvia(c3.getInt(c3.getColumnIndex("DesHor_Q22_dvia")));

                            vi.setDesMin_Q22_dvia(c3.getInt(c3.getColumnIndex("DesMin_Q22_dvia")));

                            vi.setDesAmPm_Q22_dvia(c3.getInt(c3.getColumnIndex("DesAmPm_Q22_dvia")));

                            vi.setPro_Q23_dvia(c3.getInt(c3.getColumnIndex("Pro_Q23_dvia")));

                            vi.setTraMed1_Q24a_dvia(c3.getInt(c3.getColumnIndex("TraMed1_Q24a_dvia")));

                            vi.setTraTpo1_Q24b_dvia(c3.getInt(c3.getColumnIndex("TraTpo1_Q24b_dvia")));

                            vi.setTraCos1_Q24c_dvia(c3.getDouble(c3.getColumnIndex("TraCos1_Q24c_dvia")));             //CAMBIO

                            vi.setTransb12_Q24d_dvia(c3.getString(c3.getColumnIndex("Transb12_Q24d_dvia")));

                            vi.setTransb12_Q24e_dvia(c3.getInt(c3.getColumnIndex("Transb12_Q24e_dvia")));

                            vi.setTraMed2_Q24a_dvia(c3.getInt(c3.getColumnIndex("TraMed2_Q24a_dvia")));

                            vi.setTraTpo2_Q24b_dvia(c3.getInt(c3.getColumnIndex("TraTpo2_Q24b_dvia")));

                            vi.setTraCos2_Q24c_dvia(c3.getDouble(c3.getColumnIndex("TraCos2_Q24c_dvia")));               //CAMBIO

                            vi.setTransb23_Q24d_dvia(c3.getString(c3.getColumnIndex("Transb23_Q24d_dvia")));

                            vi.setTransb23_Q24e_dvia(c3.getInt(c3.getColumnIndex("Transb23_Q24e_dvia")));

                            vi.setTraMed3_Q24a_dvia(c3.getInt(c3.getColumnIndex("TraMed3_Q24a_dvia")));

                            vi.setTraTpo3_Q24b_dvia(c3.getInt(c3.getColumnIndex("TraTpo3_Q24b_dvia")));

                            vi.setTraCos3_Q24c_dvia(c3.getDouble(c3.getColumnIndex("TraCos3_Q24c_dvia")));                 //CAMBIO

                            vi.setTransb34_Q24d_dvia(c3.getString(c3.getColumnIndex("Transb34_Q24d_dvia")));

                            vi.setTransb34_Q24e_dvia(c3.getInt(c3.getColumnIndex("Transb34_Q24e_dvia")));

                            vi.setTraMed4_Q24a_dvia(c3.getInt(c3.getColumnIndex("TraMed4_Q24a_dvia")));

                            vi.setTraTpo4_Q24b_dvia(c3.getInt(c3.getColumnIndex("TraTpo4_Q24b_dvia")));

                            vi.setTraCos4_Q24c_dvia(c3.getDouble(c3.getColumnIndex("TraCos4_Q24c_dvia")));                  //CAMBIO

                            vi.setTransb45_Q24d_dvia(c3.getString(c3.getColumnIndex("Transb45_Q24d_dvia")));

                            vi.setTransb45_Q24e_dvia(c3.getInt(c3.getColumnIndex("Transb45_Q24e_dvia")));

                            vi.setTraMed5_Q24a_dvia(c3.getInt(c3.getColumnIndex("TraMed5_Q24a_dvia")));

                            vi.setTraTpo5_Q24b_dvia(c3.getInt(c3.getColumnIndex("TraTpo5_Q24b_dvia")));

                            vi.setTraCos5_Q24c_dvia(c3.getDouble(c3.getColumnIndex("TraCos5_Q24c_dvia")));                    //CAMBIO

                            vi.setTransb56_Q24d_dvia(c3.getString(c3.getColumnIndex("Transb56_Q24d_dvia")));

                            vi.setTransb56_Q24e_dvia(c3.getInt(c3.getColumnIndex("Transb56_Q24e_dvia")));

                            vi.setTraMed6_Q24a_dvia(c3.getInt(c3.getColumnIndex("TraMed6_Q24a_dvia")));

                            vi.setTraTpo6_Q24b_dvia(c3.getInt(c3.getColumnIndex("TraTpo6_Q24b_dvia")));

                            vi.setTraCos6_Q24c_dvia(c3.getDouble(c3.getColumnIndex("TraCos6_Q24c_dvia")));                      //CAMBIO

                            vi.setTransb67_Q24d_dvia(c3.getString(c3.getColumnIndex("Transb67_Q24d_dvia")));

                            vi.setTransb67_Q24e_dvia(c3.getInt(c3.getColumnIndex("Transb67_Q24e_dvia")));

                            vi.setTraMed7_Q24a_dvia(c3.getInt(c3.getColumnIndex("TraMed7_Q24a_dvia")));

                            vi.setTraTpo7_Q24b_dvia(c3.getInt(c3.getColumnIndex("TraTpo7_Q24b_dvia")));

                            vi.setTraCos7_Q24c_dvia(c3.getDouble(c3.getColumnIndex("TraCos7_Q24c_dvia")));                        //CAMBIO

                            vi.setMcar_Q25_dvia(c3.getInt(c3.getColumnIndex("Mcar_Q25_dvia")));

                            vi.setEsta_Q26a_dvia(c3.getInt(c3.getColumnIndex("Esta_Q26a_dvia")));

                            vi.setPago_Q26b_dvia(c3.getInt(c3.getColumnIndex("Pago_Q26b_dvia")));

                            vi.setTar_Q26c_dvia(c3.getDouble(c3.getColumnIndex("Tar_Q26c_dvia")));   // SE CAMBIO GETINT POR GETDOUBLE

                            vi.setTraRazem1_Q29_dvia(c3.getInt(c3.getColumnIndex("TraRazem1_Q29_dvia")));           //NO BORRAR

                            vi.setTranutp1_Q30_dvia(c3.getInt(c3.getColumnIndex("Tranutp1_Q30_dvia")));

                            vi.setNdsBusDis_Q30_dvia(c3.getInt(c3.getColumnIndex("NdsBusDis_Q30_dvia")));

                            vi.setNdsBusTpo_Q30_dvia(c3.getInt(c3.getColumnIndex("NdsBusTpo_Q30_dvia")));

                            vi.setNdsBusTar_Q30_dvia(c3.getDouble(c3.getColumnIndex("NdsBusTar_Q30_dvia")));  //DOUBLE?

                            vi.setNdsBustrb_Q30_dvia(c3.getInt(c3.getColumnIndex("NdsBustrb_Q30_dvia")));

                            vi.setNdsTaxiDis_Q30_dvia(c3.getInt(c3.getColumnIndex("NdsTaxiDis_Q30_dvia")));

                            vi.setNdsTaxiTpo_Q30_dvia(c3.getInt(c3.getColumnIndex("NdsTaxiTpo_Q30_dvia")));

                            vi.setNdsTaxiTar_Q30_dvia(c3.getInt(c3.getColumnIndex("NdsTaxiTar_Q30_dvia")));

                            vi.setNdsCarroTpo_Q30_dvia(c3.getInt(c3.getColumnIndex("NdsCarroTpo_Q30_dvia")));

                            vi.setNdsCarroCos_Q30_dvia(c3.getInt(c3.getColumnIndex("NdsCarroCos_Q30_dvia")));

                            vi.setNdsCarroPea_Q30_dvia(c3.getDouble(c3.getColumnIndex("NdsCarroPea_Q30_dvia")));

                            vi.setNdsCarroEsta_Q30_dvia(c3.getDouble(c3.getColumnIndex("NdsCarroEsta_Q30_dvia")));

                            vi.setCoordenadas_Origen(c3.getString(c3.getColumnIndex("Coordenadas_Origen")));      //cambio 7   IF NOT NULL?

                            vi.setCoordenadas_Destino(c3.getString(c3.getColumnIndex("Coordenadas_Destino")));      //cambio 8   IF NOT NULL?

                            vi.setDia_Viaje(c3.getString(c3.getColumnIndex("Dia_Viaje")));

                            vi.setMes_Viaje(c3.getString(c3.getColumnIndex("Mes_Viaje")));

                            vi.setPeaViaQ26d_dvia(c3.getDouble(c3.getColumnIndex("PeaViaQ26d_dvia")));

                            vi.setFreViaQ26e_dvia(c3.getInt(c3.getColumnIndex("FreViaQ26e_dvia")));

                            if(c3.getInt(c3.getColumnIndex("VialarQ27_dvia"))==1){
                                vi.setVialarQ27_dvia(true);
                            }else{
                                vi.setVialarQ27_dvia(false);
                            }

                            vi.setMedQ28_dvia(c3.getInt(c3.getColumnIndex("MedQ28_dvia")));

                            vi.setPqnutpQ30_dvia(c3.getInt(c3.getColumnIndex("PqnutpQ30_dvia")));

                            if(c3.getInt(c3.getColumnIndex("ConsenQ31_dvia"))==1){
                                vi.setConsenQ31_dvia(true);
                            }else{
                                vi.setConsenQ31_dvia(false);
                            }

                            vi.setNumCelQ32_dvia(c3.getInt(c3.getColumnIndex("NumCelQ32_dvia")));

                            vi.setOtraFrecuenciaViaje(c3.getString(c3.getColumnIndex("OtraFrecuenciaViaje")));





                            listViajes.add(vi);


                        } while (c3.moveToNext());
                    }

                    c3.close();




                    pe.setViajes((ArrayList<Detalle_de_Viajes_Anexo_1>) listViajes);         //ESTO ESTA BIEN???????? O SE ASIGNA EL ARRAY DE OTRA MANERA?

                    listPersonas.add(pe);




                } while (c2.moveToNext());

            }

            c2.close();





            listaPersonas.clear();

            for(Detalle_Informacion_Personal_Anexo_1 re : listPersonas){

                listaPersonas.add(re);

            }

            adapterPersonas.notifyDataSetChanged();



            /*

            listaPersonas= (ArrayList<Detalle_Informacion_Personal_Anexo_1>) listPersonas;   //ESTO ESTA BIEN???????? O SE ASIGNA EL ARRAY DE OTRA MANERA?

            adapterPersonas.notifyDataSetChanged();                                          //ESTO ESTA BIEN??????????

*/






            b.close();


            btnFecha1.setEnabled(false);




        }





        if(coordUbicacion==null){
            lblCoordenadasUbicacion.setText("No hay coordenadas guardadas");
        }
        else{
            lblCoordenadasUbicacion.setText("Coordenadas: "+coordUbicacion);
        }






        if(f1==null){
            lblFecha1.setText("No hay una fecha registrada de la visita 1");
        }
        else{
            lblFecha1.setText("Fecha de la visita 1: "+f1);
        }



        if(f2==null){
            lblFecha2.setText("No hay una fecha registrada de la visita 2");
        }
        else{
            lblFecha2.setText("Fecha de la visita 2: "+f2);
        }



        if(f3==null){
            lblFecha3.setText("No hay una fecha registrada de la visita 3");
        }
        else{
            lblFecha3.setText("Fecha de la visita 3: "+f3);
        }








      //  validarCampo(txtIngresoMensual, "valIngresoMensual","^[0-9]{1,7}");




        validarCampo(txtTelCel, "valTelCel","^[0-9]{6,9}$");


     //   validarCampo(txtKilometro, "valKilometro","^[0-9]{0,3}$");

        validarCampo(txtKilometro, "valKilometro","^$|^[0-9]\\d{0,3}(\\.\\d{1,2})?%?$");



        validarCampo(txtLote, "valLote","^[a-zA-Z0-9- Ññ]{0,9}$");

        validarCampo(txtManzana, "valManzana","^[a-zA-Z0-9- Ññ]{0,9}$");

        validarCampo(txtEtapa, "valEtapa","^[a-zA-Z0-9- Ññ]{0,9}$");

        validarCampo(txtInterior, "valInterior","^[a-zA-Z0-9- Ññ]{0,9}$");

        validarCampo(txtNumeroPuerta, "valNumeroPuerta","^[0-9]{1,5}$");

        validarCampo(txtNombreCalle, "valNombreCalle","^[a-zA-Z0-9-.,': áéíóúÁÉÍÓÚÑñÜü]{1,63}$");

        validarCampo(txtCodificador, "valCodificador","^[0-9]{7,8}$");

        validarCampo(txtSupervisor, "valSupervisor","^[0-9]{7,8}$");

        validarCampo(txtNumeroHogar, "valNumeroHogar","^[0-9]{1,5}$");

        validarCampo(txtNombreJefeHogar, "valNombreJefeHogar","^[a-zA-Z-.' áéíóúÁÉÍÓÚÑñÜü]{2,63}$");

        validarCampo(txtNotas, "valNotas","^[a-zA-Z0-9-.¡!?¿'/()=,: áéíóúÁÉÍÓÚÑñÜü]{0,255}$");

        validarCampo(txtManzanaHogar, "valManzanaHogar","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñ]{0,20}$");

        validarCampo(txtZonaCensal, "valZonaCensal","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñ]{0,20}$");

        validarCampo(txtOtroVehiculo, "valOtroVehiculo","^[a-zA-Z0-9-.,': áéíóúÁÉÍÓÚÑñÜü]{0,63}$");

        validarCampo(txtOtroMaterialParedes, "valOtroMaterialParedes","^[a-zA-Z0-9-.,': áéíóúÁÉÍÓÚÑñÜü]{0,63}$");

        validarCampo(txtOtroMaterialPisos, "valOtroMaterialPisos","^[a-zA-Z0-9-.,': áéíóúÁÉÍÓÚÑñÜü]{0,63}$");

        validarCampo(txtOtroTipoAlumbrado, "valOtroTipoAlumbrado","^[a-zA-Z0-9-.,': áéíóúÁÉÍÓÚÑñÜü]{0,63}$");

        validarCampo(txtOtroTipoAbastecimientoAgua, "valOtroTipoAbastecimientoAgua","^[a-zA-Z0-9-.,': áéíóúÁÉÍÓÚÑñÜü]{0,63}$");

        validarCampo(txtOtroTipoServiciosHigienicos, "valOtroTipoServiciosHigienicos","^[a-zA-Z0-9-.,': áéíóúÁÉÍÓÚÑñÜü]{0,63}$");

        //    ^$|^[0-9]\d{0,3}(\.\d{1,2})?%?$     validacion kilometros con decimales




        //ADAPTER ACA?






        btnCrearRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listaVehiculos.add(new Object());
                adapter.notifyItemInserted(listaVehiculos.size()-1);

            }
        });


        final View dialogView = View.inflate(this, R.layout.activity_fecha, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();


        dialogView.findViewById(R.id.btnSetFecha).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                DatePicker datePicker = (DatePicker) dialogView.findViewById(R.id.pckFecha);
                TimePicker timePicker = (TimePicker) dialogView.findViewById(R.id.pckHora);

                switch(switchFechas) {

                    case 1:
                        fecha1 = new GregorianCalendar(datePicker.getYear(),
                            datePicker.getMonth(),
                            datePicker.getDayOfMonth(),
                            timePicker.getCurrentHour(),
                            timePicker.getCurrentMinute());

                        break;

                    case 2:
                        fecha2 = new GregorianCalendar(datePicker.getYear(),
                                datePicker.getMonth(),
                                datePicker.getDayOfMonth(),
                                timePicker.getCurrentHour(),
                                timePicker.getCurrentMinute());
                        break;

                    default:
                        fecha3= new GregorianCalendar(datePicker.getYear(),
                                datePicker.getMonth(),
                                datePicker.getDayOfMonth(),
                                timePicker.getCurrentHour(),
                                timePicker.getCurrentMinute());

                }


                System.out.println("Boton funciona");

                // time = calendar.getTimeInMillis();
                alertDialog.dismiss();

            }
        });


    /*

        txtIngresoMensual.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtIngresoMensual, "valIngresoMensual","^[0-9]{1,7}$");


               // System.out.println(listaPersonas.size());
               // if(listaPersonas.size()>0){ System.out.println(listaPersonas.get(0).getViajes().size()+"   "+listaPersonas.get(0).getViajes().get(0).getOriDis_Q17_dvia()+"   "+listaPersonas.get(listaPersonas.size()-1).getTraDis_Q16a_inpe()+"   "+listaPersonas.get(listaPersonas.size()-1).getViajes().get(0).getOriDis_Q17_dvia());}

                //System.out.println(listaPersonas.get(0).getViajes().get(0).getOriDis_Q17_dvia()+"   "+listaPersonas.get(0).getTraDis_Q16a_inpe()+"   "+listaPersonas.get(1).getViajes().get(0).getOriDis_Q17_dvia()+"   "+listaPersonas.get(1).getTraDis_Q16a_inpe());

              //System.out.println(listaPersonas.get(0).getViajes().get(0).getOriDis_Q17_dvia()+"   "+listaPersonas.get(0).getViajes().get(1).getOriDis_Q17_dvia()+"   "+listaPersonas.get(0).getTraDis_Q16a_inpe()+"   "+listaPersonas.get(1).getViajes().get(0).getOriDis_Q17_dvia()+"   "+listaPersonas.get(1).getViajes().get(1).getOriDis_Q17_dvia()+"   "+listaPersonas.get(1).getTraDis_Q16a_inpe());


                if(txtIngresoMensual.getText().toString().matches("^[a-z]{0,10}$")){

                    valIngresoMensual=true;

                    System.out.println("aaaaaaaaaaaaaaaaaaaaaa");

                }
                else{
                    valIngresoMensual=false;

                    System.out.println("bbbbbbbbbbbbbbbbbb");
                }



            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


      */




        txtTelCel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtTelCel, "valTelCel","^[0-9]{6,9}$");

/*
                SQLiteDatabase bas=sqlite.getWritableDatabase();
                bas.execSQL("delete from "+ "Encuesta_1");
                bas.execSQL("delete from "+ "Detalle_Informacion_Personal_Anexo_1");
                bas.execSQL("delete from "+ "Detalle_de_Viajes_Anexo_1");

*/

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        txtNombreJefeHogar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtNombreJefeHogar, "valNombreJefeHogar","^[a-zA-Z-'. áéíóúÁÉÍÓÚÑñÜü]{2,63}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        txtKilometro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

              //  validarCampo(txtKilometro, "valKilometro","^[0-9]{0,3}$");

                validarCampo(txtKilometro, "valKilometro","^$|^[0-9]\\d{0,3}(\\.\\d{1,2})?%?$");

/*

                SQLiteDatabase db=sqlite.getWritableDatabase();

                Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'",null);

                if (c.moveToFirst()) {
                    while ( !c.isAfterLast() ) {
                        System.out.println("aaaaaaaaaa "+"Table Name=> "+c.getString(0));
                        c.moveToNext();
                    }
                }

                System.out.println(sqlite.numeroFilas("Encuesta_1"));
                System.out.println(sqlite.numeroFilas("Detalle_Informacion_Personal_Anexo_1"));
                System.out.println(sqlite.numeroFilas("Detalle_de_Viajes_Anexo_1"));
                System.out.println(sqlite.numeroColumnas("Encuesta_1"));
                System.out.println(sqlite.numeroColumnas("Detalle_Informacion_Personal_Anexo_1"));
                System.out.println(sqlite.numeroColumnas("Detalle_de_Viajes_Anexo_1"));


*/


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        txtLote.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtLote, "valLote","^[a-zA-Z0-9- Ññ]{0,9}$");

              //  System.out.println("FILAS: "+sqlite.numeroFilas("Encuesta_1")+"   COLUMNAS: "+sqlite.numeroColumnas("Encuesta_1"));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        txtManzana.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtManzana, "valManzana","^[a-zA-Z0-9- Ññ]{0,9}$");

               // System.out.println(fecha1);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        txtEtapa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtEtapa, "valEtapa","^[a-zA-Z0-9- Ññ]{0,9}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        txtInterior.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtInterior, "valInterior","^[a-zA-Z0-9- Ññ]{0,9}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        txtNumeroPuerta.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtNumeroPuerta, "valNumeroPuerta","^[0-9]{1,5}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        txtCodificador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtCodificador, "valCodificador","^[0-9]{7,8}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        txtSupervisor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtSupervisor, "valSupervisor","^[0-9]{7,8}$");

              //  DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
              //  System.out.println(sdf.format(fecha1.getTime()));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        txtNombreCalle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtNombreCalle, "valNombreCalle","^[a-zA-Z0-9-.,': áéíóúÁÉÍÓÚÑñÜü]{1,63}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        txtNotas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtNotas, "valNotas","^[a-zA-Z0-9-.¡!?¿'/()=,: áéíóúÁÉÍÓÚÑñÜü]{0,255}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        txtManzanaHogar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtManzanaHogar, "valManzanaHogar","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñ]{0,20}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        txtZonaCensal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtZonaCensal, "valZonaCensal","^[a-zA-Z0-9-.,: áéíóúÁÉÍÓÚÑñ]{0,20}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        txtOtroVehiculo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtOtroVehiculo, "valOtroVehiculo","^[a-zA-Z0-9-.,': áéíóúÁÉÍÓÚÑñÜü]{0,63}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        txtOtroMaterialParedes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtOtroMaterialParedes, "valOtroMaterialParedes","^[a-zA-Z0-9-.,': áéíóúÁÉÍÓÚÑñÜü]{0,63}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        txtOtroMaterialPisos.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtOtroMaterialPisos, "valOtroMaterialPisos","^[a-zA-Z0-9-.,': áéíóúÁÉÍÓÚÑñÜü]{0,63}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        txtOtroTipoAlumbrado.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtOtroTipoAlumbrado, "valOtroTipoAlumbrado","^[a-zA-Z0-9-.,': áéíóúÁÉÍÓÚÑñÜü]{0,63}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        txtOtroTipoAbastecimientoAgua.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtOtroTipoAbastecimientoAgua, "valOtroTipoAbastecimientoAgua","^[a-zA-Z0-9-.,': áéíóúÁÉÍÓÚÑñÜü]{0,63}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        txtOtroTipoServiciosHigienicos.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtOtroTipoServiciosHigienicos, "valOtroTipoServiciosHigienicos","^[a-zA-Z0-9-.,': áéíóúÁÉÍÓÚÑñÜü]{0,63}$");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        txtNumeroHogar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                validarCampo(txtNumeroHogar, "valNumeroHogar","^[0-9]{1,5}$");

            /*    int bici=0;
                Integer b1=null;
                Integer b2=null;
                Integer b3=null;
                Integer b4=null;

                int moto=0;
                Integer mo1=null;
                Integer mo2=null;
                Integer mo3=null;
                Integer mo4=null;

                int carro=0;
                Integer carro1=null;
                Integer carro2=null;
                Integer carro3=null;
                Integer carro4=null;

                int camioneta=0;
                Integer camioneta1=null;
                Integer camioneta2=null;
                Integer camioneta3=null;
                Integer camioneta4=null;

                int micro=0;
                Integer micro1=null;
                Integer micro2=null;
                Integer micro3=null;
                Integer micro4=null;

                int omni=0;
                Integer omni1=null;
                Integer omni2=null;
                Integer omni3=null;
                Integer omni4=null;

                int camion=0;
                Integer camion1=null;
                Integer camion2=null;
                Integer camion3=null;
                Integer camion4=null;

                int trailer=0;
                Integer t1=null;
                Integer t2=null;
                Integer t3=null;
                Integer t4=null;

                int otros=0;
                Integer o1=null;
                Integer o2=null;
                Integer o3=null;
                Integer o4=null;

                for(int c=0;c<listaVehiculos.size();c++){

                    Spinner saux=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnTipoVehiculo);
                    if(saux.getSelectedItemPosition()==0){
                        if(bici==0){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            b1=aux2.getSelectedItemPosition();
                        }
                        if(bici==1){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            b2=aux2.getSelectedItemPosition();
                        }
                        if(bici==2){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            b3=aux2.getSelectedItemPosition();
                        }
                        if(bici==3){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            b4=aux2.getSelectedItemPosition();
                        }
                        bici++;
                    }
                    if(saux.getSelectedItemPosition()==1){
                        if(moto==0){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            mo1=aux2.getSelectedItemPosition();
                        }
                        if(moto==1){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            mo2=aux2.getSelectedItemPosition();
                        }
                        if(moto==2){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            mo3=aux2.getSelectedItemPosition();
                        }
                        if(moto==3){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            mo4=aux2.getSelectedItemPosition();
                        }
                        moto++;
                    }
                    if(saux.getSelectedItemPosition()==2){
                        if(carro==0){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            carro1=aux2.getSelectedItemPosition();
                        }
                        if(carro==1){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            carro2=aux2.getSelectedItemPosition();
                        }
                        if(carro==2){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            carro3=aux2.getSelectedItemPosition();
                        }
                        if(carro==3){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            carro4=aux2.getSelectedItemPosition();
                        }
                        carro++;
                    }
                    if(saux.getSelectedItemPosition()==3){
                        if(camioneta==0){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            camioneta1=aux2.getSelectedItemPosition();
                        }
                        if(camioneta==1){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            camioneta2=aux2.getSelectedItemPosition();
                        }
                        if(camioneta==2){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            camioneta3=aux2.getSelectedItemPosition();
                        }
                        if(camioneta==3){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            camioneta4=aux2.getSelectedItemPosition();
                        }
                        camioneta++;
                    }
                    if(saux.getSelectedItemPosition()==4){
                        if(micro==0){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            micro1=aux2.getSelectedItemPosition();
                        }
                        if(micro==1){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            micro2=aux2.getSelectedItemPosition();
                        }
                        if(micro==2){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            micro3=aux2.getSelectedItemPosition();
                        }
                        if(micro==3){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            micro4=aux2.getSelectedItemPosition();
                        }
                        micro++;
                    }
                    if(saux.getSelectedItemPosition()==5){
                        if(omni==0){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            omni1=aux2.getSelectedItemPosition();
                        }
                        if(omni==1){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            omni2=aux2.getSelectedItemPosition();
                        }
                        if(omni==2){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            omni3=aux2.getSelectedItemPosition();
                        }
                        if(omni==3){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            omni4=aux2.getSelectedItemPosition();
                        }
                        omni++;
                    }
                    if(saux.getSelectedItemPosition()==6){
                        if(camion==0){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            camion1=aux2.getSelectedItemPosition();
                        }
                        if(camion==1){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            camion2=aux2.getSelectedItemPosition();
                        }
                        if(camion==2){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            camion3=aux2.getSelectedItemPosition();
                        }
                        if(camion==3){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            camion4=aux2.getSelectedItemPosition();
                        }
                        camion++;
                    }
                    if(saux.getSelectedItemPosition()==7){
                        if(trailer==0){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            t1=aux2.getSelectedItemPosition();
                        }
                        if(trailer==1){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            t2=aux2.getSelectedItemPosition();
                        }
                        if(trailer==2){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            t3=aux2.getSelectedItemPosition();
                        }
                        if(trailer==3){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            t4=aux2.getSelectedItemPosition();
                        }
                        trailer++;
                    }
                    if(saux.getSelectedItemPosition()==8){
                        if(otros==0){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            o1=aux2.getSelectedItemPosition();
                        }
                        if(otros==1){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            o2=aux2.getSelectedItemPosition();
                        }
                        if(otros==2){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            o3=aux2.getSelectedItemPosition();
                        }
                        if(otros==3){
                            Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                            o4=aux2.getSelectedItemPosition();
                        }
                        otros++;
                    }

                }

                System.out.println("NUMERO DE BICLICTEAS: "+bici+"  MOTOCICL: "+moto+"   CARROS: "+carro+"  CAMIONETA: "+camioneta+"  MICRO: "+micro+"  OMNI: "+omni+"  CAMION: "+camion+"  TRAILER: "+trailer+"  OTROS: "+otros);
                System.out.println(" "+b1+mo1+carro1+camioneta1+micro1+omni1+camion1+t1+o1+o2+o3+o4);




                int bici=0;
                int moto=0;
                int carro=0;
                int camioneta=0;
                int micro=0;
                int omni=0;
                int camion=0;
                int trailer=0;
                int otros=0;
                for(int c=0;c<listaVehiculos.size();c++){

                    Spinner saux=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnTipoVehiculo);
                    if(saux.getSelectedItemPosition()==0){
                        bici++;
                    }
                    if(saux.getSelectedItemPosition()==1){
                        moto++;
                    }
                    if(saux.getSelectedItemPosition()==2){
                        carro++;
                    }
                    if(saux.getSelectedItemPosition()==3){
                        camioneta++;
                    }
                    if(saux.getSelectedItemPosition()==4){
                        micro++;
                    }
                    if(saux.getSelectedItemPosition()==5){
                        omni++;
                    }
                    if(saux.getSelectedItemPosition()==6){
                        camion++;
                    }
                    if(saux.getSelectedItemPosition()==7){
                        trailer++;
                    }
                    if(saux.getSelectedItemPosition()==8){
                        otros++;
                    }

                }

                System.out.println("NUMERO DE BICLICTEAS: "+bici+"  MOTOCICL: "+moto+"   CARROS: "+carro+"  CAMIONETA: "+camioneta+"  MICRO: "+micro+"  OMNI: "+omni+"  CAMION: "+camion+"  TRAILER: "+trailer+"  OTROS: "+otros);

                */


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btnFecha1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  Intent i = new Intent(getApplicationContext(), FechaActivity.class);

                startActivity(i);

              //System.out.println("zxcvb "+vals.get("valIngresoMensual")+vals.get("valTelCel")+vals.get("valKilometro")+vals.get("valNombreCalle"));
              //System.out.println("asdfg "+vals.get("valLote")+vals.get("valManzana")+vals.get("valEtapa"));
              //System.out.println("qwerty "+vals.get("valInterior")+vals.get("valNumeroPuerta")+vals.get("valCodificador")+vals.get("valSupervisor")+vals.get("valNumeroHogar"));

             switchFechas=1;

                alertDialog.setView(dialogView);
                alertDialog.show();                        */


                Date currentTime = Calendar.getInstance().getTime();

                SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

                f1=dt1.format(currentTime);



                if(f1==null){
                    lblFecha1.setText("No hay una fecha registrada de la visita 1");
                }
                else{
                    lblFecha1.setText("Fecha de la visita 1: "+f1);
                }




                }});


        btnFecha2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

          /*      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

           //     System.out.println("asdff "+dateFormat.format(fecha1.getTime())+ "  3  "+dateFormat.format(fecha3.getTime()));

                switchFechas=2;

                alertDialog.setView(dialogView);
                alertDialog.show();


                System.out.println("asdff "+dateFormat.format(fecha1.getTime())  +"  3  "+dateFormat.format(fecha3.getTime()));

*/

                Date currentTime = Calendar.getInstance().getTime();

                SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

                f2=dt1.format(currentTime);



                if(f2==null){
                    lblFecha2.setText("No hay una fecha registrada de la visita 2");
                }
                else{
                    lblFecha2.setText("Fecha de la visita 2: "+f2);
                }




            }
        });



        btnFecha3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

        /*        switchFechas=3;

                alertDialog.setView(dialogView);
                alertDialog.show();
         */


                Date currentTime = Calendar.getInstance().getTime();

                SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

                f3=dt1.format(currentTime);



                if(f3==null){
                    lblFecha3.setText("No hay una fecha registrada de la visita 3");
                }
                else{
                    lblFecha3.setText("Fecha de la visita 3: "+f3);
                }



            }
        });





        btnCrearPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PantallaEncuesta1_Persona.listaViajes.clear();
                //notify aca??????????????????????????????????????????

                Intent i=new Intent(getApplicationContext(), PantallaEncuesta1_Persona.class);

                startActivity(i);


            }
        });




        btnCoordenadasUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LoginActivity.switchMapas=5;

                Intent i = new Intent(getApplicationContext(), MapsActivity.class);

                startActivity(i);



            }
        });





        btnGuardarEncuesta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //PREGUNTAR POR VALIDACIONES COMO: POR LO MENOS UN VEHICULO?, FECHAS, RADIOBUTTONS, AL MENOS UN ADULTO EN EL HOGAR Y BUSCAR OTRAS VALIDACIONES


                AlertDialog alertDialog = new AlertDialog.Builder(PantallaEncuesta1.this).create();
                alertDialog.setTitle("No se puede añadir el Registro");

                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                boolean tomado= false;

                SQLiteDatabase datos=sqlite.getReadableDatabase();

                String hogar=txtNumeroHogar.getText().toString();

                Cursor cursor2= datos.rawQuery("SELECT * FROM Encuesta_1 WHERE Id_enc =?", new String []{hogar});

             //   Cursor cursor2 = datos.rawQuery("SELECT * FROM Encuesta_1 WHERE Id_enc = " + hogar,null);

            /*    if(cursor2.getCount()>0){

                    tomado=true;

                }

*/

                if (cursor2.moveToFirst()) {

                    tomado=true;

                }



                if(listaPersonas.size()<1){

                    alertDialog.setMessage("No hay ninguna Persona creada. Todo hogar debe contar con al menos 1 persona.");
                    alertDialog.show();

                }



                else if(txtNumeroHogar.getText().toString().equals("")){

                    alertDialog.setMessage("Debe ingresar un número de hogar");
                    alertDialog.show();

                }





                else if(txtNumeroHogar.getText().toString().charAt(0)=='0'){

                    alertDialog.setMessage("No ingrese números de hogar que comiencen por 0. Por ejemplo, si debe ingresar '00046' ingrese solo '46' en su lugar.");
                    alertDialog.show();

                }





                else if(f1==null){

                    alertDialog.setMessage("Tiene que grabar al menos la fecha de su primera visita.");
                    alertDialog.show();

                }


                else if((spnMaterialParedes.getSelectedItemPosition()==8 && txtOtroMaterialParedes.getText().toString().length()<2) || (spnMaterialPisos.getSelectedItemPosition()==7 && txtOtroMaterialPisos.getText().toString().length()<2) || (spnTipoAlumbrado.getSelectedItemPosition()==5 && txtOtroTipoAlumbrado.getText().toString().length()<2) || (spnAbastecimientoAgua.getSelectedItemPosition()==7 && txtOtroTipoAbastecimientoAgua.getText().toString().length()<2) || (spnServiciosHigienicos.getSelectedItemPosition()==7 && txtOtroTipoServiciosHigienicos.getText().toString().length()<2) ){

                    alertDialog.setMessage("Ha seleccionado la opción 'Otro' en algún campo de 'Características de la Vivienda', especifique de que se trata en el campo de texto debajo del mismo.");
                    alertDialog.show();

                }


                else if(coordUbicacion==null){

                    alertDialog.setMessage("No ha grabado las coordenadas de su ubicación. Intentelo nuevamente.");
                    alertDialog.show();

                }


                else if(spnTipoVia.getSelectedItemPosition()==0 || spnNivelEducacion.getSelectedItemPosition()==0 || spnRegimenTenencia.getSelectedItemPosition()==0 || spnTipoVivienda.getSelectedItemPosition()==0 || spnIngresoMensual.getSelectedItemPosition()==0 || spnMaterialParedes.getSelectedItemPosition()==0 || spnMaterialPisos.getSelectedItemPosition()==0 || spnTipoAlumbrado.getSelectedItemPosition()==0 || spnAbastecimientoAgua.getSelectedItemPosition()==0 || spnServiciosHigienicos.getSelectedItemPosition()==0 || spnStatusEncuestas.getSelectedItemPosition()==0 || spnNumeroHabitaciones.getSelectedItemPosition()==0 || spnHombresMayores.getSelectedItemPosition()==0 || spnHombresMenores.getSelectedItemPosition()==0 || spnHombresEmpleados.getSelectedItemPosition()==0 || spnMujeresMayores.getSelectedItemPosition()==0 || spnMujeresMenores.getSelectedItemPosition()==0 || spnMujeresEmpleadas.getSelectedItemPosition()==0 || spnPiso.getSelectedItemPosition()==0 ){

                    alertDialog.setMessage("Ha pasado por alto algún campo, debe elegir una opción en cada uno de ellos y no dejar la opción por defecto 'Seleccionar' o '--'");
                    alertDialog.show();

                }

                else if(/* vals.get("valTelCel")!=true || */ vals.get("valKilometro")!=true || vals.get("valLote")!=true ||vals.get("valManzana")!=true || vals.get("valEtapa")!=true || vals.get("valInterior")!=true ||vals.get("valNumeroPuerta")!=true || vals.get("valNombreCalle")!=true /*|| vals.get("valCodificador")!=true */ /* ||vals.get("valSupervisor")!=true */ || vals.get("valNumeroHogar")!=true || vals.get("valNombreJefeHogar")!=true || vals.get("valNotas")!=true  || vals.get("valManzanaHogar")!=true  || vals.get("valZonaCensal")!=true  || vals.get("valOtroVehiculo")!=true  || vals.get("valOtroMaterialParedes")!=true  ||  vals.get("valOtroMaterialPisos")!=true  ||  vals.get("valOtroTipoAlumbrado")!=true  ||  vals.get("valOtroTipoAbastecimientoAgua")!=true  ||  vals.get("valOtroTipoServiciosHigienicos")!=true){

                    //PINTAR DE ROJO LOS CAMPOS OBLIGATORIOS SIEMPRE QUE SE ACTUALICen!!!!!!!!!!!!!!!!!!

                    alertDialog.setMessage("Ha ingresado caracteres no permitidos o ha dejado vacio algun campo obligatorio. Intentelo nuevamente.");
                    alertDialog.show();

                }else if(tomado==true){
                    alertDialog.setMessage("Ya ha ingresado un registro con este numero de hogar.");
                    alertDialog.show();
                }
                else{

                    SQLiteDatabase db=sqlite.getWritableDatabase();


                    db.beginTransaction();

                    try {

                        ContentValues valores = new ContentValues();




                        valores.put("Id_enc", txtNumeroHogar.getText().toString());

                        valores.put("Enc_enc",LoginActivity.usuario);

                        valores.put("Fyh_enc",fechaCreacion);

                     //   DateFormat f1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        if(f1!=null){valores.put("Fv1_enc", f1);}   //PODRIA SER NULO

                     //   DateFormat f2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        if(f2!=null){valores.put("Fv2_enc", f2);}  //PODRIA SER NULO

                     //   DateFormat f3 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        if(f3!=null){valores.put("Fv3_enc", f3);}  //PODRIA SER NULO

                        valores.put("Dom_enc", spnDominio.getSelectedItem().toString());

                        valores.put("Dis_enc", spnDistrito.getSelectedItem().toString());

                        valores.put("Seg_enc", spnSegmento.getSelectedItemPosition());

                        valores.put("Viv_enc", spnVivienda.getSelectedItemPosition());

                        valores.put("Sup_enc", txtSupervisor.getText().toString());

                        if(rbSupervisor1.isChecked()){
                            valores.put("SupM1_enc", 1);
                        }
                        else{
                            valores.put("SupM1_enc", 0);
                        }

                        if(rbSupervisor2.isChecked()){
                            valores.put("SupM2_enc", 1);
                        }
                        else{
                            valores.put("SupM2_enc", 0);
                        }
                        if(rbSupervisor3.isChecked()){
                            valores.put("SupM3_enc", 1);
                        }
                        else{
                            valores.put("SupM3_enc", 0);
                        }

                        valores.put("Cod_enc", txtCodificador.getText().toString());

                        if(rbCodificador1.isChecked()){
                            valores.put("CodM1_enc", 1);
                        }
                        else{
                            valores.put("CodM1_enc", 0);
                        }

                        if(rbCodificador2.isChecked()){
                            valores.put("CodM2_enc", 1);
                        }
                        else{
                            valores.put("CodM2_enc", 0);
                        }

                        if(rbCodificador3.isChecked()){
                            valores.put("CodM3_enc", 1);
                        }
                        else{
                            valores.put("CodM3_enc", 0);
                        }

                        valores.put("Njh_Q1_enc", txtNombreJefeHogar.getText().toString());

                        valores.put("Tvi_Q2a_enc", spnTipoVia.getSelectedItemPosition());

                        valores.put("Nombre_Calle", txtNombreCalle.getText().toString());

                        valores.put("Num_Q2a_enc", txtNumeroPuerta.getText().toString());

                        valores.put("Int_Q2a_enc", txtInterior.getText().toString());

                        valores.put("Pis_Q2a_enc", Integer.parseInt(spnPiso.getSelectedItem().toString()));

                        valores.put("Eta_Q2a_enc", txtEtapa.getText().toString());

                        valores.put("Mzn_Q2a_enc", txtManzana.getText().toString());

                        valores.put("Lote_Q2a_enc", txtLote.getText().toString());

                        if(!(txtKilometro.getText().toString().equals(""))){valores.put("Km_Q2a_enc", Double.parseDouble(txtKilometro.getText().toString()));} //SI EL CAMPO SE DEJA VACIO, NO SE SUBE NADA A SQLITE!

                        valores.put("Zon_Q2a_enc", spnZonaTransito.getSelectedItem().toString());

                        valores.put("Tel_Q2a_enc", txtTelCel.getText().toString());

                        valores.put("NedQ3_enc", spnNivelEducacion.getSelectedItemPosition());

                        valores.put("RMen6H_Q4_enc", Integer.parseInt(spnHombresMenores.getSelectedItem().toString()));

                        valores.put("RMen6M_Q4_enc", Integer.parseInt(spnMujeresMenores.getSelectedItem().toString()));

                        valores.put("RMay6H_Q4_enc", Integer.parseInt(spnHombresMayores.getSelectedItem().toString()));

                        valores.put("RMay6M_Q4_enc", Integer.parseInt(spnMujeresMayores.getSelectedItem().toString()));

                        valores.put("REmhH_Q4_enc", Integer.parseInt(spnHombresEmpleados.getSelectedItem().toString()));

                        valores.put("REmhM_Q4_enc", Integer.parseInt(spnMujeresEmpleadas.getSelectedItem().toString()));

                        valores.put("Rdt_Q5a_enc", spnRegimenTenencia.getSelectedItemPosition());

                        valores.put("Tviv_Q5b_enc", spnTipoVivienda.getSelectedItemPosition());

                        valores.put("Hab_Q5c_enc", Integer.parseInt(spnNumeroHabitaciones.getSelectedItem().toString()));

                        valores.put("Ing_Q6_enc", spnIngresoMensual.getSelectedItemPosition());

                        int bici=0;
                        Integer b1=null;
                        Integer b2=null;
                        Integer b3=null;
                        Integer b4=null;

                        int moto=0;
                        Integer mo1=null;
                        Integer mo2=null;
                        Integer mo3=null;
                        Integer mo4=null;

                        int carro=0;
                        Integer carro1=null;
                        Integer carro2=null;
                        Integer carro3=null;
                        Integer carro4=null;

                        int camioneta=0;
                        Integer camioneta1=null;
                        Integer camioneta2=null;
                        Integer camioneta3=null;
                        Integer camioneta4=null;

                        int micro=0;
                        Integer micro1=null;
                        Integer micro2=null;
                        Integer micro3=null;
                        Integer micro4=null;

                        int omni=0;
                        Integer omni1=null;
                        Integer omni2=null;
                        Integer omni3=null;
                        Integer omni4=null;

                        int camion=0;
                        Integer camion1=null;
                        Integer camion2=null;
                        Integer camion3=null;
                        Integer camion4=null;

                        int trailer=0;
                        Integer t1=null;
                        Integer t2=null;
                        Integer t3=null;
                        Integer t4=null;

                        int otros=0;
                        Integer o1=null;
                        Integer o2=null;
                        Integer o3=null;
                        Integer o4=null;



                        int mototaxi=0;
                        Integer mototaxi1=null;
                        Integer mototaxi2=null;
                        Integer mototaxi3=null;
                        Integer mototaxi4=null;


                        int taxi=0;
                        Integer taxi1=null;
                        Integer taxi2=null;
                        Integer taxi3=null;
                        Integer taxi4=null;





                        for(int c=0;c<listaVehiculos.size();c++){

                            Spinner saux=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnTipoVehiculo);


                            if(saux.getSelectedItemPosition()==0){
                                if(bici==0){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    b1=aux2.getSelectedItemPosition();
                                }
                                if(bici==1){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    b2=aux2.getSelectedItemPosition();
                                }
                                if(bici==2){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    b3=aux2.getSelectedItemPosition();
                                }
                                if(bici==3){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    b4=aux2.getSelectedItemPosition();
                                }
                                bici++;
                            }
                            if(saux.getSelectedItemPosition()==1){
                                if(moto==0){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    mo1=aux2.getSelectedItemPosition();
                                }
                                if(moto==1){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    mo2=aux2.getSelectedItemPosition();
                                }
                                if(moto==2){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    mo3=aux2.getSelectedItemPosition();
                                }
                                if(moto==3){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    mo4=aux2.getSelectedItemPosition();
                                }
                                moto++;
                            }




                            //MOTOTAXI:


                            if(saux.getSelectedItemPosition()==2){
                                if(mototaxi==0){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    mototaxi1=aux2.getSelectedItemPosition();
                                }
                                if(mototaxi==1){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    mototaxi2=aux2.getSelectedItemPosition();
                                }
                                if(mototaxi==2){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    mototaxi3=aux2.getSelectedItemPosition();
                                }
                                if(mototaxi==3){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    mototaxi4=aux2.getSelectedItemPosition();
                                }
                                mototaxi++;
                            }






                            if(saux.getSelectedItemPosition()==3){
                                if(carro==0){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    carro1=aux2.getSelectedItemPosition();
                                }
                                if(carro==1){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    carro2=aux2.getSelectedItemPosition();
                                }
                                if(carro==2){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    carro3=aux2.getSelectedItemPosition();
                                }
                                if(carro==3){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    carro4=aux2.getSelectedItemPosition();
                                }
                                carro++;
                            }





                              //TAXI:


                            if(saux.getSelectedItemPosition()==4){
                                if(taxi==0){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    taxi1=aux2.getSelectedItemPosition();
                                }
                                if(taxi==1){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    taxi2=aux2.getSelectedItemPosition();
                                }
                                if(taxi==2){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    taxi3=aux2.getSelectedItemPosition();
                                }
                                if(taxi==3){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    taxi4=aux2.getSelectedItemPosition();
                                }
                                taxi++;
                            }









                            if(saux.getSelectedItemPosition()==5){
                                if(camioneta==0){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    camioneta1=aux2.getSelectedItemPosition();
                                }
                                if(camioneta==1){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    camioneta2=aux2.getSelectedItemPosition();
                                }
                                if(camioneta==2){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    camioneta3=aux2.getSelectedItemPosition();
                                }
                                if(camioneta==3){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    camioneta4=aux2.getSelectedItemPosition();
                                }
                                camioneta++;
                            }
                            if(saux.getSelectedItemPosition()==6){
                                if(micro==0){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    micro1=aux2.getSelectedItemPosition();
                                }
                                if(micro==1){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    micro2=aux2.getSelectedItemPosition();
                                }
                                if(micro==2){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    micro3=aux2.getSelectedItemPosition();
                                }
                                if(micro==3){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    micro4=aux2.getSelectedItemPosition();
                                }
                                micro++;
                            }
                            if(saux.getSelectedItemPosition()==7){
                                if(omni==0){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    omni1=aux2.getSelectedItemPosition();
                                }
                                if(omni==1){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    omni2=aux2.getSelectedItemPosition();
                                }
                                if(omni==2){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    omni3=aux2.getSelectedItemPosition();
                                }
                                if(omni==3){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    omni4=aux2.getSelectedItemPosition();
                                }
                                omni++;
                            }
                            if(saux.getSelectedItemPosition()==8){
                                if(camion==0){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    camion1=aux2.getSelectedItemPosition();
                                }
                                if(camion==1){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    camion2=aux2.getSelectedItemPosition();
                                }
                                if(camion==2){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    camion3=aux2.getSelectedItemPosition();
                                }
                                if(camion==3){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    camion4=aux2.getSelectedItemPosition();
                                }
                                camion++;
                            }
                            if(saux.getSelectedItemPosition()==9){
                                if(trailer==0){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    t1=aux2.getSelectedItemPosition();
                                }
                                if(trailer==1){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    t2=aux2.getSelectedItemPosition();
                                }
                                if(trailer==2){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    t3=aux2.getSelectedItemPosition();
                                }
                                if(trailer==3){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    t4=aux2.getSelectedItemPosition();
                                }
                                trailer++;
                            }
                            if(saux.getSelectedItemPosition()==10){
                                if(otros==0){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    o1=aux2.getSelectedItemPosition();
                                }
                                if(otros==1){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    o2=aux2.getSelectedItemPosition();
                                }
                                if(otros==2){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    o3=aux2.getSelectedItemPosition();
                                }
                                if(otros==3){
                                    Spinner aux2=recRegistro.findViewHolderForAdapterPosition(c).itemView.findViewById(R.id.spnAntiguedadVehiculo);
                                    o4=aux2.getSelectedItemPosition();
                                }
                                otros++;
                            }

                        }

                        valores.put("Bici_Und_Q7_enc", bici);

                        valores.put("Bici_Ant1_Q7_enc", b1);

                        valores.put("Bici_Ant2_Q7_enc", b2);

                        valores.put("Bici_Ant3_Q7_enc", b3);

                        valores.put("Bici_Ant4_Q7_enc", b4);

                        valores.put("Moto_Und_Q7_enc", moto);

                        valores.put("Moto_Ant1_Q7_enc", mo1);

                        valores.put("Moto_Ant2_Q7_enc", mo2);

                        valores.put("Moto_Ant3_Q7_enc", mo3);

                        valores.put("Moto_Ant4_Q7_enc", mo4);

                        valores.put("Carro_Und_Q7_enc", carro);

                        valores.put("Carro_Ant1_Q7_enc", carro1);

                        valores.put("Carro_Ant2_Q7_enc", carro2);

                        valores.put("Carro_Ant3_Q7_enc", carro3);

                        valores.put("Carro_Ant4_Q7_enc", carro4);

                        valores.put("Rural_Und_Q7_enc", camioneta);

                        valores.put("Rural_Ant1_Q7_enc", camioneta1);

                        valores.put("Rural_Ant2_Q7_enc", camioneta2);

                        valores.put("Rural_Ant3_Q7_enc", camioneta3);

                        valores.put("Rural_Ant4_Q7_enc", camioneta4);

                        valores.put("Micro_Und_Q7_enc", micro);

                        valores.put("Micro_Ant1_Q7_enc", micro1);

                        valores.put("Micro_Ant2_Q7_enc", micro2);

                        valores.put("Micro_Ant3_Q7_enc", micro3);

                        valores.put("Micro_Ant4_Q7_enc", micro4);

                        valores.put("Omnib_Und_Q7_enc", omni);

                        valores.put("Omnib_Ant1_Q7_enc", omni1);

                        valores.put("Omnib_Ant2_Q7_enc", omni2);

                        valores.put("Omnib_Ant3_Q7_enc", omni3);

                        valores.put("Omnib_Ant4_Q7_enc", omni4);

                        valores.put("Camio_Und_Q7_enc", camion);

                        valores.put("Camio_Ant1_Q7_enc", camion1);

                        valores.put("Camio_Ant2_Q7_enc", camion2);

                        valores.put("Camio_Ant3_Q7_enc", camion3);

                        valores.put("Camio_Ant4_Q7_enc", camion4);

                        valores.put("Trail_Und_Q7_enc", trailer);

                        valores.put("Trail_Ant1_Q7_enc", t1);

                        valores.put("Trail_Ant2_Q7_enc", t2);

                        valores.put("Trail_Ant3_Q7_enc", t3);

                        valores.put("Trail_Ant4_Q7_enc", t4);

                        valores.put("Otro_Und_Q7_enc", otros);

                        valores.put("Otro_Ant1_Q7_enc", o1);

                        valores.put("Otro_Ant2_Q7_enc", o2);

                        valores.put("Otro_Ant3_Q7_enc", o3);

                        valores.put("Otro_Ant4_Q7_enc", o4);




                        //BLOQUE DONDE SE USAN LOS VALORES RECOLECTADOS


                        valores.put("Mototaxi_Unidades", mototaxi);

                        valores.put("Mototaxi_Ant1", mototaxi1);

                        valores.put("Mototaxi_Ant2", mototaxi2);

                        valores.put("Mototaxi_Ant3", mototaxi3);

                        valores.put("Mototaxi_Ant4", mototaxi4);

                        valores.put("Taxi_Unidades", taxi);

                        valores.put("Taxi_Ant1", taxi1);

                        valores.put("Taxi_Ant2", taxi2);

                        valores.put("Taxi_Ant3", taxi3);

                        valores.put("Taxi_Ant4", taxi4);





                        if(Integer.parseInt(spnTelevisores.getSelectedItem().toString())==0){
                            valores.put("Telev_Q8_enc", 0);              //SE USAN INTEGERS EN VEZ DE BOOLEANS EN LAS 9 COLUMNAS DE ESTE TIPO XQ SQLITE NO TIENE BOOLEANS, TENER EN CUENTA QUE 0=NO Y 1=SI
                        }
                        else{
                            valores.put("Telev_Q8_enc", 1);
                        }

                        valores.put("Telev_Und_Q8_enc", Integer.parseInt(spnTelevisores.getSelectedItem().toString()));

                        if(Integer.parseInt(spnTelefonos.getSelectedItem().toString())==0){
                            valores.put("Telef_Q8_enc", 0);              //SE USAN INTEGERS EN VEZ DE BOOLEANS EN LAS 9 COLUMNAS DE ESTE TIPO XQ SQLITE NO TIENE BOOLEANS, TENER EN CUENTA QUE 0=NO Y 1=SI
                        }
                        else{
                            valores.put("Telef_Q8_enc", 1);
                        }

                        valores.put("Telef_Und_Q8_enc", Integer.parseInt(spnTelefonos.getSelectedItem().toString()));

                        if(Integer.parseInt(spnRefrigeradoras.getSelectedItem().toString())==0){
                            valores.put("Refri_Q8_enc", 0);              //SE USAN INTEGERS EN VEZ DE BOOLEANS EN LAS 9 COLUMNAS DE ESTE TIPO XQ SQLITE NO TIENE BOOLEANS, TENER EN CUENTA QUE 0=NO Y 1=SI
                        }
                        else{
                            valores.put("Refri_Q8_enc", 1);
                        }

                        valores.put("Refri_Und_Q8_enc", Integer.parseInt(spnRefrigeradoras.getSelectedItem().toString()));

                        if(Integer.parseInt(spnLavadoras.getSelectedItem().toString())==0){
                            valores.put("Lavad_Q8_enc", 0);              //SE USAN INTEGERS EN VEZ DE BOOLEANS EN LAS 9 COLUMNAS DE ESTE TIPO XQ SQLITE NO TIENE BOOLEANS, TENER EN CUENTA QUE 0=NO Y 1=SI
                        }
                        else{
                            valores.put("Lavad_Q8_enc", 1);
                        }

                        valores.put("Lavad_Und_Q8_enc", Integer.parseInt(spnLavadoras.getSelectedItem().toString()));

                        if(Integer.parseInt(spnComputadoras.getSelectedItem().toString())==0){
                            valores.put("Compu_Q8_enc", 0);              //SE USAN INTEGERS EN VEZ DE BOOLEANS EN LAS 9 COLUMNAS DE ESTE TIPO XQ SQLITE NO TIENE BOOLEANS, TENER EN CUENTA QUE 0=NO Y 1=SI
                        }
                        else{
                            valores.put("Compu_Q8_enc", 1);
                        }

                        valores.put("Compu_Und_Q8_enc", Integer.parseInt(spnComputadoras.getSelectedItem().toString()));

                        if(Integer.parseInt(spnAspiradoras.getSelectedItem().toString())==0){
                            valores.put("Aspir_Q8_enc", 0);              //SE USAN INTEGERS EN VEZ DE BOOLEANS EN LAS 9 COLUMNAS DE ESTE TIPO XQ SQLITE NO TIENE BOOLEANS, TENER EN CUENTA QUE 0=NO Y 1=SI
                        }
                        else{
                            valores.put("Aspir_Q8_enc", 1);
                        }

                        valores.put("Aspir_Und_Q8_enc", Integer.parseInt(spnAspiradoras.getSelectedItem().toString()));

                        if(Integer.parseInt(spnCocinasGas.getSelectedItem().toString())==0){
                            valores.put("Cogas_Q8_enc", 0);              //SE USAN INTEGERS EN VEZ DE BOOLEANS EN LAS 9 COLUMNAS DE ESTE TIPO XQ SQLITE NO TIENE BOOLEANS, TENER EN CUENTA QUE 0=NO Y 1=SI
                        }
                        else{
                            valores.put("Cogas_Q8_enc", 1);
                        }

                        valores.put("Cogas_Und_Q8_enc", Integer.parseInt(spnCocinasGas.getSelectedItem().toString()));

                        if(Integer.parseInt(spnCocinasElectricas.getSelectedItem().toString())==0){
                            valores.put("Coele_Q8_enc", 0);              //SE USAN INTEGERS EN VEZ DE BOOLEANS EN LAS 9 COLUMNAS DE ESTE TIPO XQ SQLITE NO TIENE BOOLEANS, TENER EN CUENTA QUE 0=NO Y 1=SI
                        }
                        else{
                            valores.put("Coele_Q8_enc", 1);
                        }

                        valores.put("Coele_Und_Q8_enc", Integer.parseInt(spnCocinasElectricas.getSelectedItem().toString()));

                        if(Integer.parseInt(spnMicroondas.getSelectedItem().toString())==0){
                            valores.put("Micro_Q8_enc", 0);              //SE USAN INTEGERS EN VEZ DE BOOLEANS EN LAS 9 COLUMNAS DE ESTE TIPO XQ SQLITE NO TIENE BOOLEANS, TENER EN CUENTA QUE 0=NO Y 1=SI
                        }
                        else{
                            valores.put("Micro_Q8_enc", 1);
                        }

                        valores.put("Micro_Und_Q8_enc", Integer.parseInt(spnMicroondas.getSelectedItem().toString()));


                        valores.put("Sta_enc", 1);          //TENER EN CUENTA ESTE CAMPO (ESTADO ENCUESTA) EN ESTE CASO SE LE PUSO 1 (COMPLETA), EN EL FUTURO PUEDE VARIAR DE ACUERDO AL TIPO DE ENCUESTA



                        valores.put("MatPrePa_enc", spnMaterialParedes.getSelectedItemPosition());

                        valores.put("MatPrePi_enc", spnMaterialPisos.getSelectedItemPosition());

                        valores.put("TipAlum_enc", spnTipoAlumbrado.getSelectedItemPosition());

                        valores.put("TipAgua_enc", spnAbastecimientoAgua.getSelectedItemPosition());

                        valores.put("TipHig_enc", spnServiciosHigienicos.getSelectedItemPosition());

                        valores.put("Not_enc", txtNotas.getText().toString());

                        valores.put("Manza_enc", txtManzanaHogar.getText().toString());

                        valores.put("Zonce_enc", txtZonaCensal.getText().toString());

                        valores.put("OtroTipo_Vehiculo", txtOtroVehiculo.getText().toString());

                        valores.put("OtroMat_Paredes", txtOtroMaterialParedes.getText().toString());

                        valores.put("OtroMat_Pisos", txtOtroMaterialPisos.getText().toString());

                        valores.put("OtroTipo_Alum", txtOtroTipoAlumbrado.getText().toString());

                        valores.put("OtroTipo_Agua", txtOtroTipoAbastecimientoAgua.getText().toString());

                        valores.put("OtroTipo_ServHigienico", txtOtroTipoServiciosHigienicos.getText().toString());


                        valores.put("Coordenadas_Ubicacion", coordUbicacion);


                        valores.put("Hog_enc", spnStatusEncuestas.getSelectedItem().toString());          //USAR PARA VALIDAR EN SYNC LUEGO





                        db.insert("Encuesta_1", null, valores);





                        int numeroPersona=1;

                        for(Detalle_Informacion_Personal_Anexo_1 per : listaPersonas){

                            ContentValues values = new ContentValues();



                            values.put("Enc_inpe",txtNumeroHogar.getText().toString());

                            values.put("Per_inpe",numeroPersona);

                            //ACA VA EL NUMERO DE ENCUESTADOR, QUE SE OBTIENE EN LA PRIMERA PANTALLA CUANDO EL ENCUESTADOR SE LOGUEA (PREGUNTAR PORQUE EN LA BD SQLITE SE LLAMA Enc_enc Y EN LA ACCESS Doc_enc)
                            values.put("Doc_inpe",LoginActivity.usuario);

                            values.put("Nom_inpe",per.getNom_inpe());

                            values.put("Par_Q9_inpe",per.getPar_Q9_inpe());

                            values.put("Sex_Q10_inpe",per.getSex_Q10_inpe());

                            values.put("Edad_Q11_inpe",per.getEdad_Q11_inpe());

                            values.put("Disc_Q12a_inpe",per.getDisc_Q12a_inpe());

                            values.put("Ayuv_Q12b_inpe",per.getAyuv_Q12b_inpe());

                            values.put("Ocu_Q13_inpe",per.getOcu_Q13_inpe());

                            values.put("Act_Q14_inpe",per.getAct_Q14_inpe());

                            values.put("Lic_Q15a_inpe",per.getLic_Q15a_inpe());


                            values.put("OpeCelQ16_inpe",per.getOpeCelQ16_inpe());


                            values.put("Ema_Q15b_inpe",per.getEma_Q15b_inpe());

                            values.put("TraDis_Q16a_inpe",per.getTraDis_Q16a_inpe());

                            values.put("TraDir_Q16a_inpe",per.getTraDir_Q16a_inpe());

                            values.put("TraRef_Q16a_inpe",per.getTraRef_Q16a_inpe());

                            values.put("EstDis_Q16a_inpe",per.getEstDis_Q16a_inpe());

                            values.put("EstDir_Q16a_inpe",per.getEstDir_Q16a_inpe());

                            values.put("EstRef_Q16a_inpe",per.getEstRef_Q16a_inpe());


                            values.put("ViajeMasLargo_Persona",per.getViajeMasLargo_Persona());                   // 2/5 A CAMBIAR




                            db.insert("Detalle_Informacion_Personal_Anexo_1", null, values);


                            int numeroViaje=1;

                            for(Detalle_de_Viajes_Anexo_1 via : per.getViajes()){

                                ContentValues val = new ContentValues();



                                val.put("Enc_dvia",txtNumeroHogar.getText().toString());

                                val.put("Per_dvia",numeroPersona);

                                val.put("Via_dvia",numeroViaje);

                                //ACA VA EL NUMERO DE ENCUESTADOR, QUE SE OBTIENE EN LA PRIMERA PANTALLA CUANDO EL ENCUESTADOR SE LOGUEA (Doc_Encuestador)
                                val.put("Doc_Encuestador",LoginActivity.usuario);

                                val.put("OriDis_Q17_dvia",via.getOriDis_Q17_dvia());

                                val.put("OriDir_Q17_dvia",via.getOriDir_Q17_dvia());

                                val.put("OriRef_Q17_dvia",via.getOriRef_Q17_dvia());

                                val.put("OriZtra_Q17_dvia",via.getOriZtra_Q17_dvia());

                                val.put("OriLug_Q18_dvia",via.getOriLug_Q18_dvia());

                                val.put("OriHor_Q19_dvia",via.getOriHor_Q19_dvia());

                                val.put("OriMin_Q19_dvia",via.getOriMin_Q19_dvia());

                                val.put("OriAmPm_Q19_dvia",via.getOriAmPm_Q19_dvia());

                                val.put("DesDis_Q20_dvia",via.getDesDis_Q20_dvia());

                                val.put("DesDir_Q20_dvia",via.getDesDir_Q20_dvia());

                                val.put("DesRef_Q20_dvia",via.getDesRef_Q20_dvia());

                                val.put("DesZtra_Q20_dvia",via.getDesZtra_Q20_dvia());

                                val.put("DesLug_Q21_dvia",via.getDesLug_Q21_dvia());

                                val.put("DesHor_Q22_dvia",via.getDesHor_Q22_dvia());

                                val.put("DesMin_Q22_dvia",via.getDesMin_Q22_dvia());

                                val.put("DesAmPm_Q22_dvia",via.getDesAmPm_Q22_dvia());

                                val.put("Pro_Q23_dvia",via.getPro_Q23_dvia());

                                val.put("TraMed1_Q24a_dvia",via.getTraMed1_Q24a_dvia());

                                val.put("TraTpo1_Q24b_dvia",via.getTraTpo1_Q24b_dvia());

                                val.put("TraCos1_Q24c_dvia",via.getTraCos1_Q24c_dvia());

                                val.put("Transb12_Q24d_dvia",via.getTransb12_Q24d_dvia());

                                val.put("Transb12_Q24e_dvia",via.getTransb12_Q24e_dvia());

                                val.put("TraMed2_Q24a_dvia",via.getTraMed2_Q24a_dvia());

                                val.put("TraTpo2_Q24b_dvia",via.getTraTpo2_Q24b_dvia());

                                val.put("TraCos2_Q24c_dvia",via.getTraCos2_Q24c_dvia());

                                val.put("Transb23_Q24d_dvia",via.getTransb23_Q24d_dvia());

                                val.put("Transb23_Q24e_dvia",via.getTransb23_Q24e_dvia());

                                val.put("TraMed3_Q24a_dvia",via.getTraMed3_Q24a_dvia());

                                val.put("TraTpo3_Q24b_dvia",via.getTraTpo3_Q24b_dvia());

                                val.put("TraCos3_Q24c_dvia",via.getTraCos3_Q24c_dvia());

                                val.put("Transb34_Q24d_dvia",via.getTransb34_Q24d_dvia());

                                val.put("Transb34_Q24e_dvia",via.getTransb34_Q24e_dvia());

                                val.put("TraMed4_Q24a_dvia",via.getTraMed4_Q24a_dvia());

                                val.put("TraTpo4_Q24b_dvia",via.getTraTpo4_Q24b_dvia());

                                val.put("TraCos4_Q24c_dvia",via.getTraCos4_Q24c_dvia());

                                val.put("Transb45_Q24d_dvia",via.getTransb45_Q24d_dvia());

                                val.put("Transb45_Q24e_dvia",via.getTransb45_Q24e_dvia());

                                val.put("TraMed5_Q24a_dvia",via.getTraMed5_Q24a_dvia());

                                val.put("TraTpo5_Q24b_dvia",via.getTraTpo5_Q24b_dvia());

                                val.put("TraCos5_Q24c_dvia",via.getTraCos5_Q24c_dvia());

                                val.put("Transb56_Q24d_dvia",via.getTransb56_Q24d_dvia());

                                val.put("Transb56_Q24e_dvia",via.getTransb56_Q24e_dvia());

                                val.put("TraMed6_Q24a_dvia",via.getTraMed6_Q24a_dvia());

                                val.put("TraTpo6_Q24b_dvia",via.getTraTpo6_Q24b_dvia());

                                val.put("TraCos6_Q24c_dvia",via.getTraCos6_Q24c_dvia());

                                val.put("Transb67_Q24d_dvia",via.getTransb67_Q24d_dvia());

                                val.put("Transb67_Q24e_dvia",via.getTransb67_Q24e_dvia());

                                val.put("TraMed7_Q24a_dvia",via.getTraMed7_Q24a_dvia());

                                val.put("TraTpo7_Q24b_dvia",via.getTraTpo7_Q24b_dvia());

                                val.put("TraCos7_Q24c_dvia",via.getTraCos7_Q24c_dvia());

                                val.put("Mcar_Q25_dvia",via.getMcar_Q25_dvia());

                                val.put("Esta_Q26a_dvia",via.getEsta_Q26a_dvia());

                                val.put("Pago_Q26b_dvia",via.getPago_Q26b_dvia());

                                val.put("Tar_Q26c_dvia",via.getTar_Q26c_dvia());

                                val.put("TraRazem1_Q29_dvia",via.getTraRazem1_Q29_dvia());           //NO BORRAR

                                val.put("Tranutp1_Q30_dvia",via.getTranutp1_Q30_dvia());

                                val.put("NdsBusDis_Q30_dvia",via.getNdsBusDis_Q30_dvia());

                                val.put("NdsBusTpo_Q30_dvia",via.getNdsBusTpo_Q30_dvia());

                                val.put("NdsBusTar_Q30_dvia",via.getNdsBusTar_Q30_dvia());

                                val.put("NdsBustrb_Q30_dvia",via.getNdsBustrb_Q30_dvia());

                                val.put("NdsTaxiDis_Q30_dvia",via.getNdsTaxiDis_Q30_dvia());

                                val.put("NdsTaxiTpo_Q30_dvia",via.getNdsTaxiTpo_Q30_dvia());

                                val.put("NdsTaxiTar_Q30_dvia",via.getNdsTaxiTar_Q30_dvia());

                                val.put("NdsCarroTpo_Q30_dvia",via.getNdsCarroTpo_Q30_dvia());

                                val.put("NdsCarroCos_Q30_dvia",via.getNdsCarroCos_Q30_dvia());

                                val.put("NdsCarroPea_Q30_dvia",via.getNdsCarroPea_Q30_dvia());

                                val.put("NdsCarroEsta_Q30_dvia",via.getNdsCarroEsta_Q30_dvia());

                                val.put("Coordenadas_Origen",via.getCoordenadas_Origen());        //cambio 5   IF NOT NULL?

                                val.put("Coordenadas_Destino",via.getCoordenadas_Destino());        //cambio 6   IF NOT NULL?

                                val.put("Dia_Viaje",via.getDia_Viaje());

                                val.put("Mes_Viaje",via.getMes_Viaje());

                                val.put("PeaViaQ26d_dvia",via.getPeaViaQ26d_dvia());

                                val.put("FreViaQ26e_dvia",via.getFreViaQ26e_dvia());

                                if(via.isVialarQ27_dvia()){
                                val.put("VialarQ27_dvia",1);}
                                else{val.put("VialarQ27_dvia",0);}

                                val.put("MedQ28_dvia",via.getMedQ28_dvia());

                                val.put("PqnutpQ30_dvia",via.getPqnutpQ30_dvia());

                                if(via.isConsenQ31_dvia()){
                                    val.put("ConsenQ31_dvia",1);
                                }else{val.put("ConsenQ31_dvia",0);}

                                val.put("NumCelQ32_dvia",via.getNumCelQ32_dvia());

                                val.put("OtraFrecuenciaViaje",via.getOtraFrecuenciaViaje());






                                db.insert("Detalle_de_Viajes_Anexo_1", null, val);

                                numeroViaje++;


                            }

                            numeroPersona++;

                        }

                        db.setTransactionSuccessful();
                        System.out.println("Transaccion exitosa");


                        //ACA IRIA UN NOTIFY INSERTED ITEM PARA EL RECYCLER VIEW DEL SYNC ACTIVITY ???????????????????

                        //EL FINISH() (Y EL NOTIFY()) IRIAN AQUI O EN EL FINALLY?

                        //SyncActivity.lista=SyncActivity.listarBase();

                        finish();


                    }
                    catch(Exception e){
                        System.out.println("Error en la insercion a la base de datos (Mostrar popup aqui?)");
                        e.printStackTrace();
                    }
                    finally{
                        db.endTransaction();

                        System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
                        //SyncActivity.adapter.notifyItemInserted(SyncActivity.lista.size()-1);

                        //SyncActivity.lista=SyncActivity.listarBase(getApplicationContext());

                       // SyncActivity.adapter.notifyItemInserted(SyncActivity.lista.size()-1);


                        SyncActivity.lista.clear();

                        SyncActivity.lista.addAll(SyncActivity.listarBase(getApplicationContext()));

                        SyncActivity.adapter.notifyDataSetChanged();


                    }

                }

            }
            });



    }


    @Override
    public void onBackPressed() {

        AlertDialog alertDialog = new AlertDialog.Builder(PantallaEncuesta1.this).create();
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

        alertDialog.setMessage("Si decide volver a la pantalla anterior se perderán todos los datos que ha ingresado en esta pantalla. Use el botón 'Guardar Encuesta' para guardar sus datos correctamente.");
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

            vals.put(val,true);

            System.out.println("aaaaaaaaaaaaaaaaaaaaaa");

        }
        else{
            vals.put(val,false);

            System.out.println("bbbbbbbbbbbbbbbbbb");
        }


    }




}
