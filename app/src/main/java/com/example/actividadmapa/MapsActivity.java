package com.example.actividadmapa;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.actividadmapa.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    public static double latitud, longitud;
    public static float zoom;
    public static int centrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng centrado = new LatLng(latitud, longitud);
        LatLng noCentrado = new LatLng(0,0);
        mMap.addMarker(new MarkerOptions().position(centrado).title("Ubicación"));
        if(centrar==0){
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centrado, zoom));
        }else{
            mMap.moveCamera(CameraUpdateFactory.newLatLng(noCentrado));
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}