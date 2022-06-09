package com.example.asus.proyectoencuestas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorListaViaje extends RecyclerView.Adapter<AdaptadorListaViaje.ViewHolder> {

    private List<Object> lista=new ArrayList<>();
    private LayoutInflater mInflater;


    AdaptadorListaViaje(Context context, List<Object>lista){

        this.lista=lista;
        this.mInflater=LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public AdaptadorListaViaje.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.fila_viaje, parent, false);
        return new AdaptadorListaViaje.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorListaViaje.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder{


        public Spinner spnCostoViaje;
        public Spinner spnTiempoViaje;
        public Spinner spnMedioViaje;
        public Spinner spnTransbordo;                      //AVERIGUAR PUEDE SER TEMPORAL
        public Spinner spnNumeroTransbordo;                //AVERIGUAR PUEDE SER TEMPORAL
        public Button btnEliminarViaje;




       // String[] listaCostoViaje={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50"};
        // String[] listaCostoViaje={"0","0.1","0.2","0.3","0.4","0.5","0.6","0.7","0.8","0.9","1.0","1.1","1.2","1.3","1.4","1.5","1.6","1.7","1.8","1.9","2.0","2.1","2.2","2.3","2.4","2.5","2.6","2.7","2.8","2.9","3.0","3.1","3.2","3.3","3.4","3.5","3.6","3.7","3.8","3.9","4.0","4.1","4.2","4.3","4.4","4.5","4.6","4.7","4.8","4.9","5.0","5.1","5.2","5.3","5.4","5.5","5.6","5.7","5.8","5.9","6.0","6.1","6.2","6.3","6.4","6.5","6.6","6.7","6.8","6.9","7.0","7.1","7.2","7.3","7.4","7.5","7.6","7.7","7.8","7.9","8.0","8.1","8.2","8.3","8.4","8.5","8.6","8.7","8.8","8.9","9.0","9.1","9.2","9.3","9.4","9.5","9.6","9.7","9.8","9.9","10.0","10.1","10.2","10.3","10.4","10.5","10.6","10.7","10.8","10.9","11.0","11.1","11.2","11.3","11.4","11.5","11.6","11.7","11.8","11.9","12.0","12.1","12.2","12.3","12.4","12.5","12.6","12.7","12.8","12.9","13.0","13.1","13.2","13.3","13.4","13.5","13.6","13.7","13.8","13.9","14.0","14.1","14.2","14.3","14.4","14.5","14.6","14.7","14.8","14.9","15.0","15.1","15.2","15.3","15.4","15.5","15.6","15.7","15.8","15.9","16.0","16.1","16.2","16.3","16.4","16.5","16.6","16.7","16.8","16.9","17.0","17.1","17.2","17.3","17.4","17.5","17.6","17.7","17.8","17.9","18.0","18.1","18.2","18.3","18.4","18.5","18.6","18.7","18.8","18.9","19.0","19.1","19.2","19.3","19.4","19.5","19.6","19.7","19.8","19.9","20.0","20.1","20.2","20.3","20.4","20.5","20.6","20.7","20.8","20.9","21.0","21.1","21.2","21.3","21.4","21.5","21.6","21.7","21.8","21.9","22.0","22.1","22.2","22.3","22.4","22.5","22.6","22.7","22.8","22.9","23.0","23.1","23.2","23.3","23.4","23.5","23.6","23.7","23.8","23.9","24.0","24.1","24.2","24.3","24.4","24.5","24.6","24.7","24.8","24.9","25.0","25.1","25.2","25.3","25.4","25.5","25.6","25.7","25.8","25.9","26.0","26.1","26.2","26.3","26.4","26.5","26.6","26.7","26.8","26.9","27.0","27.1","27.2","27.3","27.4","27.5","27.6","27.7","27.8","27.9","28.0","28.1","28.2","28.3","28.4","28.5","28.6","28.7","28.8","28.9","29.0","29.1","29.2","29.3","29.4","29.5","29.6","29.7","29.8","29.9","30.0","31.0","32.0","33.0","34.0","35.0","36.0","37.0","38.0","39.0","40.0","41.0","42.0","43.0","44.0","45.0","46.0","47.0","48.0","49.0","50.0"};

        String[] listaCostoViaje={"0","0.1","0.2","0.3","0.4","0.5","0.6","0.7","0.8","0.9","1.0","1.1","1.2","1.3","1.4","1.5","1.6","1.7","1.8","1.9","2.0","2.1","2.2","2.3","2.4","2.5","2.6","2.7","2.8","2.9","3.0","3.1","3.2","3.3","3.4","3.5","3.6","3.7","3.8","3.9","4.0","4.1","4.2","4.3","4.4","4.5","4.6","4.7","4.8","4.9","5.0","5.1","5.2","5.3","5.4","5.5","5.6","5.7","5.8","5.9","6.0","6.1","6.2","6.3","6.4","6.5","6.6","6.7","6.8","6.9","7.0","7.1","7.2","7.3","7.4","7.5","7.6","7.7","7.8","7.9","8.0","8.1","8.2","8.3","8.4","8.5","8.6","8.7","8.8","8.9","9.0","9.1","9.2","9.3","9.4","9.5","9.6","9.7","9.8","9.9","10.0","10.1","10.2","10.3","10.4","10.5","10.6","10.7","10.8","10.9","11.0","11.1","11.2","11.3","11.4","11.5","11.6","11.7","11.8","11.9","12.0","12.1","12.2","12.3","12.4","12.5","12.6","12.7","12.8","12.9","13.0","13.1","13.2","13.3","13.4","13.5","13.6","13.7","13.8","13.9","14.0","14.1","14.2","14.3","14.4","14.5","14.6","14.7","14.8","14.9","15.0","15.1","15.2","15.3","15.4","15.5","15.6","15.7","15.8","15.9","16.0","16.1","16.2","16.3","16.4","16.5","16.6","16.7","16.8","16.9","17.0","17.1","17.2","17.3","17.4","17.5","17.6","17.7","17.8","17.9","18.0","18.1","18.2","18.3","18.4","18.5","18.6","18.7","18.8","18.9","19.0","19.1","19.2","19.3","19.4","19.5","19.6","19.7","19.8","19.9","20.0","20.1","20.2","20.3","20.4","20.5","20.6","20.7","20.8","20.9","21.0","21.1","21.2","21.3","21.4","21.5","21.6","21.7","21.8","21.9","22.0","22.1","22.2","22.3","22.4","22.5","22.6","22.7","22.8","22.9","23.0","23.1","23.2","23.3","23.4","23.5","23.6","23.7","23.8","23.9","24.0","24.1","24.2","24.3","24.4","24.5","24.6","24.7","24.8","24.9","25.0","25.1","25.2","25.3","25.4","25.5","25.6","25.7","25.8","25.9","26.0","26.1","26.2","26.3","26.4","26.5","26.6","26.7","26.8","26.9","27.0","27.1","27.2","27.3","27.4","27.5","27.6","27.7","27.8","27.9","28.0","28.1","28.2","28.3","28.4","28.5","28.6","28.7","28.8","28.9","29.0","29.1","29.2","29.3","29.4","29.5","29.6","29.7","29.8","29.9","30.0","31.0","32.0","33.0","34.0","35.0","36.0","37.0","38.0","39.0","40.0","41.0","42.0","43.0","44.0","45.0","46.0","47.0","48.0","49.0","50.0","51.0","52.0","53.0","54.0","55.0","56.0","57.0","58.0","59.0","60.0","61.0","62.0","63.0","64.0","65.0","66.0","67.0","68.0","69.0","70.0","71.0","72.0","73.0","74.0","75.0","76.0","77.0","78.0","79.0","80.0","81.0","82.0","83.0","84.0","85.0","86.0","87.0","88.0","89.0","90.0","91.0","92.0","93.0","94.0","95.0","96.0","97.0","98.0","99.0","100.0","101.0","102.0","103.0","104.0","105.0","106.0","107.0","108.0","109.0","110.0","111.0","112.0","113.0","114.0","115.0","116.0","117.0","118.0","119.0","120.0"};

        String[] listaMedioViaje={"Caminando","Bicicleta","Motocicleta","Mototaxi","Carro Particular","Taxi","Taxi app","Colectivo","Combi","Microbús/Coaster","Ómnibus","Corredor","Metropolitano","Alimentador","Camión Pequeño","Camión","Trailer","Tren"};
        String[] listaTiempoViaje={"0","1","2","3","4","5","10","15","20","25","30","35","40","45","50","55","60","70","80","90","100","110","120","130","140","150","160","170","180","190","200","210","220","230","240","250","260","270","280","290","300","310","320","330","340","350","360","390","420","450","480","510","540","570","600","630","660","690","720","750","780","810","840","870","900","930","960","990","1020"};
        String[] listaTransbordo={"Seleccionar","Paradero","Calle"};
        String[] listaNumeroTransbordo={"0","1","5","10","15","30","45","60","90","120"};


        public ViewHolder(View itemView) {
            super(itemView);
            spnCostoViaje=itemView.findViewById(R.id.spnCostoViaje);
            spnTiempoViaje=itemView.findViewById(R.id.spnTiempoViaje);
            spnMedioViaje=itemView.findViewById(R.id.spnMedioViaje);
            spnTransbordo=itemView.findViewById(R.id.spnTransbordo);
            spnNumeroTransbordo=itemView.findViewById(R.id.spnNumeroTransbordo);
            btnEliminarViaje=itemView.findViewById(R.id.btnEliminarViaje);


            ArrayAdapter<String> adapterCostoViaje = new ArrayAdapter(itemView.getContext(), android.R.layout.simple_list_item_1, listaCostoViaje);
            spnCostoViaje.setAdapter(adapterCostoViaje);

            ArrayAdapter<String> adapterMedioViaje = new ArrayAdapter(itemView.getContext(), android.R.layout.simple_list_item_1, listaMedioViaje);
            spnMedioViaje.setAdapter(adapterMedioViaje);

            ArrayAdapter<String> adapterTiempoViaje = new ArrayAdapter(itemView.getContext(), android.R.layout.simple_list_item_1, listaTiempoViaje);
            spnTiempoViaje.setAdapter(adapterTiempoViaje);

            ArrayAdapter<String> adapterTransbordo = new ArrayAdapter(itemView.getContext(), android.R.layout.simple_list_item_1, listaTransbordo);  //EL SPINNER PUEDE SER TEMPORAL , AVERIGUAR
            spnTransbordo.setAdapter(adapterTransbordo);

            ArrayAdapter<String> adapterNumeroTransbordo = new ArrayAdapter(itemView.getContext(), android.R.layout.simple_list_item_1, listaNumeroTransbordo);  //EL SPINNER PUEDE SER TEMPORAL , AVERIGUAR
            spnNumeroTransbordo.setAdapter(adapterNumeroTransbordo);



            btnEliminarViaje.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lista.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                }
            });


        }
    }



}
