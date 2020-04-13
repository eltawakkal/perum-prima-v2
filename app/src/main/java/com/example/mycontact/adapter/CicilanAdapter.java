package com.example.mycontact.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycontact.R;
import com.example.mycontact.model.Cicilan;
import com.example.mycontact.model.ListCicilan;

import java.util.List;

public class CicilanAdapter extends RecyclerView.Adapter<CicilanAdapter.ViewHolder> {

    private List<Cicilan> listCicilan;
    private Context context;

    public CicilanAdapter(List<Cicilan> listCicilan, Context context) {
        this.listCicilan = listCicilan;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.row_cicilan, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(listCicilan.get(0).getListCicilan().get(position));
    }

    @Override
    public int getItemCount() {
        return listCicilan.get(0).getListCicilan().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvCicilan, tvTransDate;
        ImageView imgStatus;

        public ViewHolder(@NonNull View v) {
            super(v);

            tvTitle = v.findViewById(R.id.tv_cicilan_title);
            tvCicilan = v.findViewById(R.id.tv_jumlah_cicilan);
            tvTransDate = v.findViewById(R.id.tv_trans_date_cicilan);
            imgStatus = v.findViewById(R.id.img_status_cicilan);

        }

        void bind(ListCicilan cicilan) {

            int img;

            if (cicilan.getStatus().equals("0")) {
                img = R.drawable.ic_warning;
            } else {
                img = R.drawable.ic_check_circle;
            }

            tvTitle.setText(cicilan.getType());
            tvCicilan.setText(cicilan.getCicilan());
            tvTransDate.setText(cicilan.getDate());
            imgStatus.setImageResource(img);
        }
    }
}
