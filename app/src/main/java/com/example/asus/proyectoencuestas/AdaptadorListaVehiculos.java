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

import java.util.ArrayList;
import java.util.List;

public class AdaptadorListaVehiculos extends RecyclerView.Adapter<AdaptadorListaVehiculos.ViewHolder> {

    private List<Object> lista=new ArrayList<>();
    private LayoutInflater mInflater;

    AdaptadorListaVehiculos(Context context, List<Object>lista){

        this.lista=lista;
        this.mInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.fila_vehiculo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{


        public Spinner spnAntiguedadVehiculo;
        public Spinner spnTipoVehiculo;
        public Button btnEliminarVehiculo;


        String[] listaAntiguedad={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80"};

        //ANTIGUA LISTA:
    //    String[] listaTipo={"Bicicleta","Motocicleta","Carro Particular","Camioneta Rural","Microbus/Coaster","Omnibus","Camión","Trailer","Otros"};

        String[] listaTipo={"Bicicleta","Motocicleta","Mototaxi","Carro Particular","Taxi","Camioneta Rural","Microbus/Coaster","Omnibus","Camión","Trailer","Otros"};


        public ViewHolder(View itemView) {

            super(itemView);
            spnAntiguedadVehiculo = itemView.findViewById(R.id.spnAntiguedadVehiculo);
            spnTipoVehiculo = itemView.findViewById(R.id.spnTipoVehiculo);
            btnEliminarVehiculo=itemView.findViewById(R.id.btnEliminarVehiculo);


            ArrayAdapter<String> adapterTipo = new ArrayAdapter(itemView.getContext(), android.R.layout.simple_list_item_1, listaTipo);
            spnTipoVehiculo.setAdapter(adapterTipo);

            ArrayAdapter<String> adapterAntiguedad = new ArrayAdapter(itemView.getContext(), android.R.layout.simple_list_item_1, listaAntiguedad);
            spnAntiguedadVehiculo.setAdapter(adapterAntiguedad);


            btnEliminarVehiculo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    System.out.println(spnTipoVehiculo.getSelectedItemPosition());

                    lista.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());


                }
            });

        }


}}
