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
import com.example.mycontact.model.Mutasi;

import java.util.List;

public class MutationAdapter extends RecyclerView.Adapter<MutationAdapter.ViewHolder> {

    private List<Mutasi> listMutasi;
    private Context context;

    public MutationAdapter(List<Mutasi> listMutasi, Context context) {
        this.listMutasi = listMutasi;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.row_mutasi, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(listMutasi.get(position));
    }

    @Override
    public int getItemCount() {
        return listMutasi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvType, tvTransDate, tvCicilan;

        public ViewHolder(@NonNull View v) {
            super(v);

            tvName = v.findViewById(R.id.tv_name_row_mutation);
            tvType = v.findViewById(R.id.tv_type_row_mutation);
            tvCicilan = v.findViewById(R.id.tv_cicilan_row_mutation);
            tvTransDate = v.findViewById(R.id.tv_trans_date_row_mutation);

        }

        void bind(Mutasi mutasi) {
            tvName.setText(mutasi.getNama());
            tvType.setText(mutasi.getType());
            tvCicilan.setText(mutasi.getCicilan());
            tvTransDate.setText(mutasi.getTransDate());
        }
    }
}
