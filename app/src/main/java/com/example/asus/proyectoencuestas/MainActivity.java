package com.example.asus.proyectoencuestas;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public String[] listaNivel={"Ninguno","Primaria","Secundaria","Superior no Universitaria","Sup. Universitaria Incompleta","Sup. Universitaria Completa","Sup. Univ. con Maestria/Doctorado"};

    public boolean val1;
    public boolean val2;
    public boolean val3;

    public static String lugar;

    public String empleado="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("nuevo");

        val1=false;
        val2=false;
        val3=false;



        //NO OLVIDAR INSERTAR CAMPOS ENCUESTA Y EMPLEADO MAS ADELANTE EN LA SINCRONIZACION (JUNTO CON CODIGO GENERAL?)

        //GET LOCATION DEL USUARIO PARA QUE SEA LA UBICCION EN EL MAPA POR DEFECTO

        //IMPLEMENTAR EN EL ONCLICK BTN INGRESAR MENSAJE DE ERROR DICIENDO QUE VALOR(ES) SON LOS QUE FALTAN

        //ARREGLAR VALIDACION DE LUGAR

        //CAMBIAR LINEA DE LA CONEXION A BASE DE DATOS DE LA EncuestasActivity A LA PRIMERA ACTIVIDAD DE LA APLICACION SIEMPRE

        //CAMBIAR CAMPO USUARIO EN INSERCION A BASE DE DATOS (QUE INGRESE REALMENTE UN CODIGO DE USUARIO)

        //APRENDER COMO INGRESAR A AZURE AUTO_INCREMENTS PARA CAMPOS COMO CODIGO

        //HASTA EL MOMENTO EL CODIGO ELMINA DE LA BASE DE DATOS LOCAL SI LA INSERCION EN AZURE ES "EXITOSA", VER SI HYA ALGUNA FORMA MEJOR DE HACERLO (EJ. CHEQUEANDO CON UN QUERY A AZURE)

        //IMPLEMENTAR REGISTROS LOCALES INCOMPLETOS?

        //IMPLEMENTAR OPCIONES PARA MARCAR TODOS O NINGUN REGISTRO CHECKOBX DE LOS REGISTROS ANTES DE SINCRONIZAR CON LA BASE DE DATOS

        //ASEGURARME QUE LA SENTENCIA VACUUM EN EL DELETE DEL SQL FUNCIONE BIEN

        //ASEGURARME DE QUE NO HAYAN PROBLEMAS CON EL SCROLL DEL RECYCLERVIEW Y SU LISTA, EN ESPECIAL EL NOTIFYDATASETCHANGED()

        //DETALLES ESTETICOS Y OTROS COMO CEÑIR BUSQUEDA GOOGLEMAPS A LIMA Y ESPECIALMENTE ACTUALIZAR AUTOMATICAMENTE LOS REGISTROS LOCALES DESPUES DE SINCRONIZAR!!!!!!!!!!!!!!!!!!!



        final TextView txt1 = findViewById(R.id.txt1);
        final TextView txt2 = findViewById(R.id.txt2);
        final TextView txt3 = findViewById(R.id.txt3);
        final Spinner spn1 = findViewById(R.id.spn1);
        Button btn1 = findViewById(R.id.btn1);
        Button btnIngresar = findViewById(R.id.btnIngresar);


        final SQLiteHelper sqlite= new SQLiteHelper(this,"ENCUESTAS", null,1);



        /*EN EL PASE BOTON GRABAR:
        System.out.println("qqqqq "+val3);

                txt1.setText("");
                txt2.setText("");
                txt3.setText("");

                System.out.println("qqqq "+val3);

*/


        ArrayAdapter<String> adapterNivel = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNivel);
        spn1.setAdapter(adapterNivel);


        System.out.println("xxxxxxxxxxx"+txt1.getText()+val1);






        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MapsActivity.class);

                System.out.println("--------------------------------------------------------------"+spn1.getSelectedItemPosition());

                startActivity(i);
            }
        });



        btnIngresar.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                if(val1==true && val2==true && val3==true && lugar!=null){


                SQLiteDatabase encuestas=sqlite.getWritableDatabase();

                ContentValues valores = new ContentValues();
              //valores.put("empleado", empleado);
             // valores.put("encuesta",numero);  //INSERTAR AMBOS EN LA SINCRONIZACION A LA BASE DE DATOS
                valores.put("nombres",txt1.getText().toString());
                valores.put("apellidos",txt2.getText().toString());
                valores.put("edad",Integer.parseInt(txt3.getText().toString()));
                valores.put("nivel",spn1.getSelectedItemPosition());
                valores.put("ubicacion",lugar);
                encuestas.insert("encuesta1",null,valores);




                System.out.println("qqqqqqqq "+val3);

                txt1.setText("");
                txt2.setText("");
                txt3.setText("");

                System.out.println("qqqq "+val3);


                    Intent in=new Intent(getApplicationContext(), SyncActivity.class);

                    startActivity(in);


                }

                else{

                    //IMPLEMENAR AQUI POP-UP MOSTRANDO MENSAJE DE ERROR

                    System.out.println("FALTAN CAMPOS");

                }



            }
        });


        txt1.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(txt1.getText().toString().matches("^.{1,63}$")){

                    val1=true;

                    System.out.println("aaaaaaaaaaaaaaaaaaaaaa");

                }
                else{
                    val1=false;

                    System.out.println("bbbbbbbbbbbbbbbbbb");
                }

            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        txt2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(txt2.getText().toString().matches("^.{1,63}$")){

                    val2=true;

                    System.out.println("aaaaaaaaaaaaaaaaaaaaaa");

                }
                else{
                    val2=false;

                    System.out.println("bbbbbbbbbbbbbbbbbb");


            }


        }

            @Override
            public void afterTextChanged(Editable s) {

            }});




        txt3.addTextChangedListener(new TextWatcher(){


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if(txt3.getText().toString().matches("^[0-9]{1,3}$")){

                    val3=true;

                    System.out.println("aaaaaaaaaaaaaaaaaaaaaa");

                }
                else{
                    val3=false;

                    System.out.println("bbbbbbbbbbbbbbbbbb");


                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });





    }
}
