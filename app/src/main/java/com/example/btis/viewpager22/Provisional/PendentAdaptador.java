package com.example.btis.viewpager22.Provisional;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.btis.viewpager22.R;

import java.util.List;

/**
 * Created by BTIS on 24/03/2017.
 */

public class PendentAdaptador extends RecyclerView.Adapter<PendentAdaptador.PendentViewHolder> {

    private List<Pendent> items;

    public static class PendentViewHolder extends RecyclerView.ViewHolder{

        //Camps dels ítems que formen la CardView
        public ImageView escutLocal;
        public ImageView escutVisitant;
        public TextView equipLocal;
        public TextView equipVisitant;
        public TextView data;
        public TextView hora;


        public PendentViewHolder(View v) {
            super(v);

            escutLocal = (ImageView) v.findViewById(R.id.escutLocal);
            escutVisitant = (ImageView) v.findViewById(R.id.escutVisitant);
            equipLocal = (TextView) v.findViewById(R.id.equipLocal);
            equipVisitant = (TextView) v.findViewById(R.id.equipVisitant);
            data = (TextView) v.findViewById(R.id.data);
            hora = (TextView) v.findViewById(R.id.hora);
        }
    }

     public PendentAdaptador(List<Pendent> items) { this.items=items;}


    @Override
    public PendentViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pendents_row, parent, false);

        return new PendentViewHolder(v);


    }

    @Override
    public void onBindViewHolder(PendentViewHolder viewHolder, int i) {

        viewHolder.escutLocal.setImageResource(items.get(i).getEscutLocal());
        viewHolder.escutVisitant.setImageResource(items.get(i).getEscutVisitant());
        viewHolder.equipLocal.setText(items.get(i).getNomLocal());
        viewHolder.equipVisitant.setText(items.get(i).getNomVisitant());
        viewHolder.data.setText("Dissabte "+String.valueOf(items.get(i).getDia()));
        viewHolder.hora.setText(items.get(i).getHora());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
