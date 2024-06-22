package com.example.nextstep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class Dpantallausuario extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dpantallausuario);

        ImageView notificacionImageView = findViewById(R.id.notificacion);

        notificacionImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dpantallausuario.this, pantallanotificacion.class);
                startActivity(intent);
            }
        });

        ImageView cuentaImageView = findViewById(R.id.cuenta);

        cuentaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dpantallausuario.this, Dpantallausuario.class);
                startActivity(intent);
            }
        });

        ImageView casaImageView = findViewById(R.id.incioprincital);

        casaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dpantallausuario.this, desarrollo.class);
                startActivity(intent);
            }
        });
    }
}
