package com.example.Covid19.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Covid19.model.kasus_harian.KasusHarianDataItem;
import com.example.kasuscovid_19.R;

import java.util.ArrayList;

public class KasusHarianAdapter extends RecyclerView.Adapter<KasusHarianAdapter.ViewHolder> {

    private ArrayList<KasusHarianDataItem> kasusHarianItem = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<KasusHarianDataItem> items){
        kasusHarianItem.clear();
        kasusHarianItem.addAll(items);
        notifyDataSetChanged();
    }

    public KasusHarianAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kasusharian,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.TVtanggal.setText(kasusHarianItem.get(position).getTanggal()+"");
        holder.TVterkonfirmasi.setText("Terkonfimasi: " +kasusHarianItem.get(position).getConfirmationDiisolasi()+" Orang");
        holder.TVsembuh.setText("Sembuh: " +kasusHarianItem.get(position).getConfirmationSelesai()+" Orang");
        holder.TVmeninggal.setText("Meninggal: " +kasusHarianItem.get(position).getConfirmationMeninggal()+" Orang");
    }

    @Override
    public int getItemCount() {
        return kasusHarianItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TVtanggal,TVterkonfirmasi,TVsembuh,TVmeninggal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            TVtanggal = itemView.findViewById(R.id.itemkasusharian_tv_tanggal);
            TVterkonfirmasi = itemView.findViewById(R.id.itemkasusharian_confirmed);
            TVsembuh = itemView.findViewById(R.id.itemkasusharian_sembuh);
            TVmeninggal = itemView.findViewById(R.id.itemkasusharian_ded);
        }
    }
}
