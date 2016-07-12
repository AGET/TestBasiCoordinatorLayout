package com.aldo.aget.testbasicoordinatorlayout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorDatos
        extends RecyclerView.Adapter<AdaptadorDatos.DatosViewHolder>
        implements View.OnClickListener {

    private View.OnClickListener listener;
    private ArrayList<Datos> datos;

    public AdaptadorDatos(ArrayList<Datos> datos) {
        this.datos = datos;
    }

    @Override
    public DatosViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.listitem_datos, viewGroup, false);

        itemView.setOnClickListener(this);
        //android:background="?android:attr/selectableItemBackground"

        DatosViewHolder tvh = new DatosViewHolder(itemView);

        return tvh;
    }

    @Override
    public void onBindViewHolder(DatosViewHolder viewHolder, int pos) {
        Datos item = datos.get(pos);

        viewHolder.bindDatos(item);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null)
            listener.onClick(view);
    }

    public static class DatosViewHolder
            extends RecyclerView.ViewHolder {

        private TextView txtTitulo;
        private TextView txtSubtitulo;

        public DatosViewHolder(View itemView) {
            super(itemView);

            txtTitulo = (TextView) itemView.findViewById(R.id.LblTitulo);
            txtSubtitulo = (TextView) itemView.findViewById(R.id.LblSubTitulo);
        }

        public void bindDatos(Datos t) {
            txtTitulo.setText(t.getTitulo());
            txtSubtitulo.setText(t.getSubtitulo());
        }
    }
}
