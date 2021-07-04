package com.example.Covid19.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kasuscovid_19.R;
import com.example.Covid19.model.fasilitas_kesehatan.FasilitasKesehatanDataItem;

import java.util.ArrayList;

public class FasilitasKesehatanAdapter extends RecyclerView.Adapter<FasilitasKesehatanAdapter.ViewHolder> {
    private ArrayList<FasilitasKesehatanDataItem> fasilitasKesehatanDataItems = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<FasilitasKesehatanDataItem> items){
        fasilitasKesehatanDataItems.clear();
        fasilitasKesehatanDataItems.addAll(items);
        notifyDataSetChanged();
    }

    public FasilitasKesehatanAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FasilitasKesehatanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fasilitaskesehatan,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FasilitasKesehatanAdapter.ViewHolder holder, int position) {
        holder.TVnamaRS.setText(fasilitasKesehatanDataItems.get(position).getNama());
        holder.TValamatRS.setText(fasilitasKesehatanDataItems.get(position).getAlamat());
        holder.btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q="+ fasilitasKesehatanDataItems.get(position).getAlamat()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fasilitasKesehatanDataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TVnamaRS,TValamatRS;
        Button btn_map;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            TVnamaRS = itemView.findViewById(R.id.itemfaskes_namaRS);
            TValamatRS = itemView.findViewById(R.id.itemfaskes_alamatRS);
            btn_map = itemView.findViewById(R.id.itemfasilitaskesehatan_btn_map);
        }
    }
}
