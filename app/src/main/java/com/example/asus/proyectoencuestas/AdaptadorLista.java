package com.example.asus.proyectoencuestas;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.ViewHolder>{

    private List<Encuesta_1> lista;
    private LayoutInflater mInflater;

    AdaptadorLista(Context context, List<Encuesta_1> lista){

        this.lista=lista;
        this.mInflater=LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public AdaptadorLista.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.fila_registro, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdaptadorLista.ViewHolder holder, int position) {

        Encuesta_1 reg=lista.get(position);

        holder.txtInfo.setText("Hogar Numero "+reg.getId_enc()+":  "+reg.getNombre_Calle()+" "+reg.getNum_Q2a_enc()+" - "+reg.getDis_enc());



    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtInfo;
        public CheckBox chk1;
        public Button btnModificarTabla;

        public ViewHolder(final View itemView){

            super(itemView);
            txtInfo=itemView.findViewById(R.id.txtInfo);
            chk1=itemView.findViewById(R.id.chk1);
            btnModificarTabla=itemView.findViewById(R.id.btnModificarTabla);




            btnModificarTabla.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    LoginActivity.modificarEncuesta=true;

                    LoginActivity.indicePosicion=getAdapterPosition();

                    LoginActivity.indiceModificarEncuesta=lista.get(getAdapterPosition()).getId_enc()+"";

                    Intent i=new Intent(itemView.getContext(),PantallaEncuesta1.class);

                    startActivity(itemView.getContext(),i,null);


                }
            });


        }





    }




}
