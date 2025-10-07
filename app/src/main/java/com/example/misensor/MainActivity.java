package com.example.misensor;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SensorManager gestorSensores;
    private Button button;
    private SensorAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        button = findViewById(R.id.button);

        gestorSensores = (SensorManager) getSystemService(SENSOR_SERVICE);

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        cargarSensores();

        button.setOnClickListener(v -> cargarSensores());

    }
    private void cargarSensores() {
        List<Sensor> lista = gestorSensores.getSensorList(Sensor.TYPE_ALL);
        adaptador = new SensorAdapter(lista);
        recyclerView.setAdapter(adaptador);
    }
}