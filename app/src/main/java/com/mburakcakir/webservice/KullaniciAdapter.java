package com.mburakcakir.webservice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KullaniciAdapter extends RecyclerView.Adapter<KullaniciAdapter.KullaniciViewHolder> {

    private List<KullaniciBilgileri> kullaniciBilgileriList;

    public KullaniciAdapter(List<KullaniciBilgileri> kullaniciBilgileris) {
        kullaniciBilgileriList = kullaniciBilgileris;
    }


    @NonNull
    @Override
    public KullaniciViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user, parent, false);
        return new KullaniciViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KullaniciViewHolder holder, int position) {
        holder.siralamaNo.setText("" + kullaniciBilgileriList.get(position).getSiralamaNo());
        holder.baslik.setText(kullaniciBilgileriList.get(position).getBaslik());
        holder.paragraf.setText(kullaniciBilgileriList.get(position).getParagraf());
    }

    @Override
    public int getItemCount() {
        return kullaniciBilgileriList.size();
    }

    public class KullaniciViewHolder extends RecyclerView.ViewHolder {

        TextView siralamaNo, baslik, paragraf;

        public KullaniciViewHolder(@NonNull View itemView) {
            super(itemView);
            siralamaNo = itemView.findViewById(R.id.siralamaNo);
            baslik = itemView.findViewById(R.id.baslik);
            paragraf = itemView.findViewById(R.id.paragraf);
        }
    }
}
