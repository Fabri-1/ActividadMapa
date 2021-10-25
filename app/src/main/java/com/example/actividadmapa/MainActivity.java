package com.example.actividadmapa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText textLatitud,textLongitud, textZoom;
    private CheckBox cbxCentrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textLatitud = findViewById(R.id.latitud);
        textLongitud = findViewById(R.id.longitud);
        textZoom = findViewById(R.id.zoom);
        cbxCentrar = findViewById(R.id.centrar);

    }

    public void siguiente (View v){
        Intent intent = new Intent(this,MapsActivity.class);
        double latitud = Double.parseDouble(textLatitud.getText().toString());
        double longitud = Double.parseDouble(textLongitud.getText().toString());
        float zoom = Float.parseFloat(textZoom.getText().toString());

        MapsActivity.latitud = latitud;
        MapsActivity.longitud = longitud;
        MapsActivity.zoom = zoom;
        if(cbxCentrar.isChecked()){
            MapsActivity.centrar=0;
        }else{
            MapsActivity.centrar=1;
        }
        startActivity(intent);
    }

}