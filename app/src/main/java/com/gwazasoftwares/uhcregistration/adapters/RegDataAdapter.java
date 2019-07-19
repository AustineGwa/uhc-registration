package com.gwazasoftwares.uhcregistration.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gwazasoftwares.uhcregistration.R;
import com.gwazasoftwares.uhcregistration.models.RegData;

import java.util.List;

public class RegDataAdapter extends RecyclerView.Adapter<RegDataAdapter.RegDataViewHolder> {

    List<RegData> regDataList;

    public RegDataAdapter(List<RegData> regDataList) {
        this.regDataList = regDataList;
    }

    @NonNull
    @Override
    public RegDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reg_data_row, parent, false);
        RegDataViewHolder regDataViewHolder = new RegDataViewHolder(view);
        return regDataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RegDataViewHolder holder, int position) {
        holder.name.setText(regDataList.get(position).getFullName());
        holder.gender.setText(regDataList.get(position).getGender());
        holder.county.setText(regDataList.get(position).getCounty());

    }

    @Override
    public int getItemCount() {
        return regDataList.size();
    }


    class RegDataViewHolder extends RecyclerView.ViewHolder{
        public  TextView name, gender,county;
        public RegDataViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            gender = itemView.findViewById(R.id.gender);
            county = itemView.findViewById(R.id.county);
        }


    }

}
