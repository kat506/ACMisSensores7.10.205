package com.example.misensor;

import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.ViewHolder> {
    private final List<Sensor> listaSensores;

    public SensorAdapter(List<Sensor> listaSensores) {
        this.listaSensores = listaSensores;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sensor, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sensor sensor = listaSensores.get(position);

        holder.txtName.setText("Nombre: " + sensor.getName());
        holder.txtVendor.setText("Fabricante: " + sensor.getVendor());
        holder.txtVersion.setText("Versión: " + sensor.getVersion());
        holder.txtResolution.setText("Resolución: " + sensor.getResolution());
    }

    @Override
    public int getItemCount() {
        return listaSensores.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtVendor, txtVersion, txtResolution;

        ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtVendor = itemView.findViewById(R.id.txtVendor);
            txtVersion = itemView.findViewById(R.id.txtVersion);
            txtResolution = itemView.findViewById(R.id.txtResolution);
        }
    }
}
