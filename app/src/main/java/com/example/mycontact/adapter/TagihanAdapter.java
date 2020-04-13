package com.example.mycontact.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycontact.R;
import com.example.mycontact.model.Tagihan;

import java.util.List;

public class TagihanAdapter extends RecyclerView.Adapter<TagihanAdapter.ViewHolder> {

    private List<Tagihan> listTagihan;
    private Context context;

    public TagihanAdapter(List<Tagihan> listTagihan, Context context) {
        this.listTagihan = listTagihan;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.row_tagihan, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(listTagihan.get(position));
    }

    @Override
    public int getItemCount() {
        return listTagihan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvType;
        ImageView imgCall;

        public ViewHolder(@NonNull View v) {
            super(v);

            tvName = v.findViewById(R.id.tv_name_tagihan);
            tvType = v.findViewById(R.id.tv_type_tagihan);
            imgCall = v.findViewById(R.id.img_call_tagihan);

        }

        void bind(Tagihan tagihan) {
            tvName.setText(tagihan.getNama() + "(" + tagihan.getUnit() + ")");
            tvType.setText("Tagihan untuk " + tagihan.getType());

            imgCall.setOnClickListener(v -> {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + tagihan.getNo_telp()));
                context.startActivity(callIntent);
            });
        }
    }
}
