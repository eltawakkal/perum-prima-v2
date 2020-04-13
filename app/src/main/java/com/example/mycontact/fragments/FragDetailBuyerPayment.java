package com.example.mycontact.fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycontact.DetailActivity;
import com.example.mycontact.R;
import com.example.mycontact.adapter.CicilanAdapter;
import com.example.mycontact.model.Buyer;
import com.example.mycontact.model.Cicilan;
import com.example.mycontact.model.Transaction;
import com.example.mycontact.network.ApiClient;
import com.example.mycontact.network.ApiEndPoint;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragDetailBuyerPayment extends Fragment {

    private ApiEndPoint apiEndPoint;
    private Buyer buyer;
    private List<Cicilan> listBuyer;
    private CicilanAdapter adapter;

    private RecyclerView recCicilan;
    private TextView tvTotalCicilan;
    private FloatingActionButton fanAddCicilan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_buyer_detail_payment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        apiEndPoint = ApiClient.getRetrofit().create(ApiEndPoint.class);

        recCicilan = v.findViewById(R.id.rec_cicilan);
        tvTotalCicilan = v.findViewById(R.id.tv_total_cicilan);
        fanAddCicilan = v.findViewById(R.id.fab_add_cicilan);

        fanAddCicilan.setOnClickListener( view-> {
            addCicilanView();
        });

        buyer = getArguments().getParcelable(DetailActivity.CONTACT_KEY);
        getCicilanFromServer();
    }

    void getCicilanFromServer() {
        Call<List<Cicilan>> callCicilan = apiEndPoint.getCicilan(buyer.getId(), buyer.getHouseId(), buyer.getUnit());
        callCicilan.enqueue(new Callback<List<Cicilan>>() {
            @Override
            public void onResponse(Call<List<Cicilan>> call, Response<List<Cicilan>> response) {
                listBuyer = response.body();

                setRecItems();
                tvTotalCicilan.setText(listBuyer.get(0).getTotalCicilan());
            }

            @Override
            public void onFailure(Call<List<Cicilan>> call, Throwable t) {

            }
        });
    }

    void setRecItems() {
        adapter = new CicilanAdapter(listBuyer, getContext());
        recCicilan.setLayoutManager(new LinearLayoutManager(getContext()));
        recCicilan.setAdapter(adapter);
    }

    void addCicilanView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_add_cicilan, null, false);

        EditText edtCicilan = view.findViewById(R.id.edt_cicilan_cicilan);
        EditText edtTransDate = view.findViewById(R.id.edt_trans_date_cicilan);

        edtTransDate.setOnClickListener(v -> pickDate(edtTransDate));

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        alert
                .setCancelable(false)
                .setTitle("Tambah Transaksi Baru")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Tambah", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String cicilan = edtCicilan.getText().toString();
                        String transDate = edtTransDate.getText().toString();
                        addDataToServer(cicilan, transDate);

                    }
                });
        alert.setView(view);
        alert.show();
    }

    void addDataToServer(String cicilan, String transDate) {
        String type = "";

        if (listBuyer.get(0).getListCicilan().size() == 0) {
            type = "Booking Fee";
        } else {
            type = "Cicilan Ke " + (listBuyer.get(0).getListCicilan().size());
        }
        Call<Transaction> callCicilan = apiEndPoint.addCicilan(buyer.getId(), buyer.getHouseId(), buyer.getUnit(), cicilan, transDate, type);
        callCicilan.enqueue(new Callback<Transaction>() {
            @Override
            public void onResponse(Call<Transaction> call, Response<Transaction> response) {
                getCicilanFromServer();
            }

            @Override
            public void onFailure(Call<Transaction> call, Throwable t) {
                Log.d("gagalAddCicilan", t.getMessage());
            }
        });
    }

    void pickDate(EditText edt) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                edt.setText(year + "-"  + (month+1) + "-" + dayOfMonth);
            }
        }, year, month, day);
        datePickerDialog.show();
    }
}
