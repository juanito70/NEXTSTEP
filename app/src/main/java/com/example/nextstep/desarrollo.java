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

        ImageView usuarioImageView = findViewById(R.id.cuenta);
        TextView taxiTextView = findViewById(R.id.taxi_text);

        taxiImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(desarrollo.this, pantallausuario.class);
                startActivity(intent);
            }
        });

        taxiTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(desarrollo.this, Dpantallausuario.class);
                startActivity(intent);
            }
        });

        ImageView taxiImageView = findViewById(R.id.taxi);
        TextView taxiTextView = findViewById(R.id.taxi_text);

        taxiImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(desarrollo.this, pantallanotificacion.class);
                startActivity(intent);
            }
        });

        taxiTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(desarrollo.this, pantallanotificacion.class);
                startActivity(intent);
            }
        });

    }
}