package com.example.asus.proyectoencuestas;

import com.microsoft.windowsazure.mobileservices.*;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.internal.on;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;

import java.net.MalformedURLException;

public class EncuestasActivity extends AppCompatActivity {

   // public static MobileServiceClient mClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuestas);

        /*
        try {
            mClient = new MobileServiceClient(
                    "https://proyectoencuestas.azurewebsites.net",
                    this
            );
        } catch (MalformedURLException e) {
            System.out.println("ERROR URL -------------------------------------------------");
            e.printStackTrace();
        }
*/


        // CODIGO DE INSERCION:

        /*
        final TodoItem item = new TodoItem();
        item.Text = "Awesome item";
        mClient.getTable(TodoItem.class).insert(item, new TableOperationCallback<TodoItem>() {
            public void onCompleted(TodoItem entity, Exception exception, ServiceFilterResponse response) {
                if (exception == null) {
                    System.out.println("Insercion Exitosa");
                } else {
                    exception.printStackTrace();
                    System.out.println("Insercion Fallida");
                }
            }
        });
*/


        Button btnE1=findViewById(R.id.btnE1);
     //   Button btnSincronizar=findViewById(R.id.btnSincronizar);


        //CAMBIAR A LA PRIMERA ACTIVIDAD DE LA APLICACION (?)

        //AzureServiceAdapter.Initialize(this);



        btnE1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(), SyncActivity.class);

                startActivity(i);

            }



        });


    /*    btnSincronizar.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                SQLiteHelper db=new SQLiteHelper(view.getContext(), "ENCUESTAS",null,1);

                System.out.println("aaaaaaaaaaaaaaaaaaaa "+db.getNumeroFilas("encuesta1"));


            }
        });

*/

    }
}
