package com.example.nextstep;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class desarrollo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desarrollo);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //botones de pantalla principal

         //boton de pantallahostital
        ImageView hospitalImageView = findViewById(R.id.hospital);
        TextView hospitalTextView = findViewById(R.id.hostital);

        hospitalImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(desarrollo.this, pantallahospital.class);
                startActivity(intent);
            }
        });

        hospitalTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(desarrollo.this, pantallahospital.class);
                startActivity(intent);
            }
        });

        //boton de pantallahotel
        ImageView hotelImageView = findViewById(R.id.hotel);
        TextView hotelTextView = findViewById(R.id.hotel_text);

        hotelImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(desarrollo.this, pantallahotel.class);
                startActivity(intent);
            }
        });

        hotelTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(desarrollo.this, pantallahotel.class);
                startActivity(intent);
            }
        });

        //boton de pantallataxi
        ImageView taxiImageView = findViewById(R.id.taxi);
        TextView taxiTextView = findViewById(R.id.taxi_text);

        taxiImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(desarrollo.this, pantallataxi.class);
                startActivity(intent);
            }
        });

        taxiTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(desarrollo.this, pantallataxi.class);
                startActivity(intent);
            }
        });

        //boton de pantallafarmacia
        ImageView farmaciaImageView = findViewById(R.id.farmacia);
        TextView farmaciaTextView = findViewById(R.id.FARnombre);

        farmaciaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(desarrollo.this, pantallafarmacia.class);
                startActivity(intent);
            }
        });

        farmaciaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(desarrollo.this, pantallafarmacia.class);
                startActivity(intent);
            }
        });

        //boton de Dpantallarestautante
        ImageView restauranteImageView = findViewById(R.id.restaurante);
        TextView restauranteTextView = findViewById(R.id.RESnombre);

          restauranteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(desarrollo.this, Dpantallarestautante.class);
                startActivity(intent);
            }
        });

        restauranteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(desarrollo.this, Dpantallarestautante.class);
                startActivity(intent);
            }
        });

        //boton de Dpantallausuario
        ImageView cuentaImageView = findViewById(R.id.cuenta);

        cuentaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(desarrollo.this, Dpantallausuario.class);
                startActivity(intent);
            }
        });


        //boton de notificacion
        ImageView notificacionImageView = findViewById(R.id.notificacion);

        notificacionImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(desarrollo.this, pantallanotificacion.class);
                startActivity(intent);
            }
        });

        //boton de ubicacion
        ImageView ubicacionImageView = findViewById(R.id.ubicacion);

        ubicacionImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(desarrollo.this, ubicacionpantalla.class);
                startActivity(intent);
            }
        });

    }
}