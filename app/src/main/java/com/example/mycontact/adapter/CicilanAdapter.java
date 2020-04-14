package com.example.mycontact.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycontact.R;
import com.example.mycontact.model.Cicilan;
import com.example.mycontact.model.CicilanData;
import com.example.mycontact.model.Transaction;
import com.example.mycontact.network.ApiClient;
import com.example.mycontact.network.ApiEndPoint;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CicilanAdapter extends RecyclerView.Adapter<CicilanAdapter.ViewHolder> {

    private ApiEndPoint apiEndPoint;

    private Cicilan listCicilan;
    private Context context;

    public CicilanAdapter(Cicilan listCicilan, Context context) {
        this.listCicilan = listCicilan;
        this.context = context;
        apiEndPoint = ApiClient.getRetrofit().create(ApiEndPoint.class);
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
        holder.bind(listCicilan.getCicilanData().get(position), position);
    }

    @Override
    public int getItemCount() {
        return listCicilan.getCicilanData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvCicilan, tvTransDate;
        ImageView imgDeletePay;

        public ViewHolder(@NonNull View v) {
            super(v);

            tvTitle = v.findViewById(R.id.tv_cicilan_title);
            tvCicilan = v.findViewById(R.id.tv_jumlah_cicilan);
            tvTransDate = v.findViewById(R.id.tv_trans_date_cicilan);
            imgDeletePay = v.findViewById(R.id.img_delete_cicilan);

        }

        void bind(CicilanData cicilan, int position) {

            tvTitle.setText(cicilan.getType());
            tvCicilan.setText(cicilan.getCicilan());
            tvTransDate.setText(cicilan.getDate());

            imgDeletePay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                    alert
                            .setTitle("Hapus Transaksi")
                            .setMessage("Yakin Hapus Transaksi" + cicilan.getType())
                            .setNegativeButton("Batal", null)
                            .setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    deletePayment(position);
                                }
                            })
                    .show();
                }
            });

        }

        void deletePayment(int position) {
            Call<Transaction> deletePay = apiEndPoint.deletePayment(listCicilan.getCicilanData().get(position).getId());
            deletePay.enqueue(new Callback<Transaction>() {
                @Override
                public void onResponse(Call<Transaction> call, Response<Transaction> response) {
                    listCicilan.getCicilanData().remove(position);
                    notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<Transaction> call, Throwable t) {

                }
            });
        }
    }
}
