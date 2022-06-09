package com.example.asus.proyectoencuestas;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;

import java.net.MalformedURLException;

public class LoginActivity extends AppCompatActivity {

    public static MobileServiceClient mClient;

    public static String usuario;



    public static boolean modificarViaje=false;

    public static int indiceModificarViaje=-100;


    public static boolean modificarPersona=false;

    public static int indiceModificarPersona=-100;


    public static boolean modificarEncuesta=false;

    public static int indicePosicion=-100;

    public static String indiceModificarEncuesta="-100";


    public static int switchMapas=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        try {
            mClient = new MobileServiceClient(

                    "https://proyectoencuestas.azurewebsites.net",
                    this
            );

            System.out.println("EXITO --------------------------------------------------------------------------------------------------------------------------------------------------------------");

        } catch (MalformedURLException e) {
            System.out.println("ERROR URL --------------------------------------------------------------------------------------------------------------------------------------------------------------");
            e.printStackTrace();
        }


        AzureServiceAdapter.Initialize(this);



        SQLite sqlite= new SQLite(getApplicationContext(),"BDEncuestasEscom", null,3);

        SQLiteDatabase db=sqlite.getWritableDatabase();

       /* Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'",null);

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



        final TextView txtUsuario=findViewById(R.id.txtUsuario);
        final TextView txtClave=findViewById(R.id.txtClave);
        Button btnLogin=findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if( (txtUsuario.getText().toString().matches("^[0-9]{8}$"))==false || (txtUsuario.getText().toString().equals(txtClave.getText().toString())==false)  ){


                    AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
                    alertDialog.setTitle("Atención");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });

                    alertDialog.setMessage("Usuario o contraseña incorrectos.");
                    alertDialog.show();

                }

                else {

                    usuario = txtUsuario.getText().toString();

                    //ACA IRIA LA VALIDACION DE USUARIO Y CLAVE (DOBLE VALIDACION SQLITE Y AZURE?) SI LA PASA SE INICIA EL ACTIVITY

                    Intent i = new Intent(getApplicationContext(), EncuestasActivity.class);

                    startActivity(i);

                }

            }
        });


    }
}
