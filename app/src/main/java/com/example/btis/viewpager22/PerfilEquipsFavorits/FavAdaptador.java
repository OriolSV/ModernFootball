package com.example.btis.viewpager22.PerfilEquipsFavorits;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.btis.viewpager22.PerfilPartitsPendents.Pendent;
import com.example.btis.viewpager22.R;

import java.util.List;

/**
 * Created by BTIS on 24/03/2017.
 */

public class FavAdaptador extends RecyclerView.Adapter<FavAdaptador.FavoritsViewHolder> {

    private List<Favorit> items;

    public static class FavoritsViewHolder extends RecyclerView.ViewHolder{

        //Camps dels ítems que formen la CardView
        public ImageView escutFav;
        public TextView equipFav;


        public FavoritsViewHolder(View v) {
            super(v);

            escutFav = (ImageView) v.findViewById(R.id.escutFav);
            equipFav = (TextView) v.findViewById(R.id.equipFav);

        }
    }

     public FavAdaptador(List<Favorit> items) { this.items=items;}


    @Override
    public FavoritsViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.equipsfav_row, parent, false);

        return new FavoritsViewHolder(v);


    }

    @Override
    public void onBindViewHolder(FavoritsViewHolder viewHolder, int i) {

        viewHolder.escutFav.setImageResource(items.get(i).getEscutFav());
        viewHolder.equipFav.setText(items.get(i).getNomFav());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
