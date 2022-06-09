package com.example.asus.proyectoencuestas;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class AdaptadorListaPersonas1 extends RecyclerView.Adapter<AdaptadorListaPersonas1.ViewHolder>{

    private List<Detalle_de_Viajes_Anexo_1> listaV=new ArrayList<>();
    private List<Detalle_Informacion_Personal_Anexo_1> listaP=new ArrayList<>();
    private LayoutInflater mInflater;
    private int tipo;


    AdaptadorListaPersonas1(Context context, List<Detalle_Informacion_Personal_Anexo_1>listaP, int algo){

        this.listaP=listaP;
        this.mInflater=LayoutInflater.from(context);
        tipo=1;
    }

    AdaptadorListaPersonas1(Context context, List<Detalle_de_Viajes_Anexo_1>listaV){

        this.listaV=listaV;
        this.mInflater=LayoutInflater.from(context);
        tipo=2;
    }


    @NonNull
    @Override
    public AdaptadorListaPersonas1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.fila_persona_viaje, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorListaPersonas1.ViewHolder holder, int position) {

        if(tipo==1){

            Detalle_Informacion_Personal_Anexo_1 P=listaP.get(position);

            holder.txtPersonaViaje.setText(P.getNom_inpe()+" - "+P.getEdad_Q11_inpe());

        }

        else{

            Detalle_de_Viajes_Anexo_1 V=listaV.get(position);

            holder.txtPersonaViaje.setText("Viaje de la(s): "+V.getOriHor_Q19_dvia()+":"+V.getOriMin_Q19_dvia()+" a las "+V.getDesHor_Q22_dvia()+":"+V.getDesMin_Q22_dvia());

        }

    }

    @Override
    public int getItemCount() {

        if(tipo==1){
            return listaP.size();
        }
        else{
            return listaV.size();
        }

    }


    public class ViewHolder extends RecyclerView.ViewHolder{


        public Button btnModificarPersona;
        public Button btnEliminarPersona;
        public TextView txtPersonaViaje;


        public ViewHolder(final View itemView) {
            super(itemView);

            btnEliminarPersona=itemView.findViewById(R.id.btnEliminarPersona);
            btnModificarPersona=itemView.findViewById(R.id.btnModificarPersona);
            txtPersonaViaje=itemView.findViewById(R.id.txtPersonaViaje);


            btnEliminarPersona.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(tipo==1){
                        listaP.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                    }
                    else{
                        listaV.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                    }

                }
            });


            btnModificarPersona.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(tipo==1){

                        LoginActivity.modificarPersona=true;

                        LoginActivity.indiceModificarPersona=getAdapterPosition();

                        Intent i=new Intent(itemView.getContext(),PantallaEncuesta1_Persona.class);

                        startActivity(itemView.getContext(),i,null);



                    }
                    else{

                        System.out.println("AAAAAAAAAAAAAAAAAAAAAA "+getAdapterPosition());

                        LoginActivity.modificarViaje=true;

                        LoginActivity.indiceModificarViaje=getAdapterPosition();

                        Intent i=new Intent(itemView.getContext(),PantallaEncuesta1_Viaje.class);

                        startActivity(itemView.getContext(),i,null);


                    }


                }
            });



        }



    }


}
