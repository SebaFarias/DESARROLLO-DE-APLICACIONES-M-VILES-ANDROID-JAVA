package com.example.mapistasjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mapistasjava.databinding.ActivityMainBinding;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager;
import com.mapbox.maps.Style;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private SymbolManager symbolManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate( getLayoutInflater());
        setContentView(binding.getRoot());
        binding.mapView.getMapboxMap().loadStyleUri(Style.OUTDOORS);
    }

    @Override
    protected void onStart() {
        super.onStart();
        binding.mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        binding.mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        binding.mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.mapView.onDestroy();
    }
}

