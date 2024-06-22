package com.example.nextstep;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar botones y configurar listeners de clic
        Button btnInicioSesion = findViewById(R.id.Inicio);
        Button btnRegistrarse = findViewById(R.id.button5);

        btnInicioSesion.setOnClickListener(v -> abrirPantallaInicio());
        btnRegistrarse.setOnClickListener(v -> abrirPantallaRegistro());
    }

    private void abrirPantallaInicio() {
        Intent intent = new Intent(MainActivity.this, pantallainicio.class);
        startActivity(intent);
    }

    private void abrirPantallaRegistro() {
        Intent intent = new Intent(MainActivity.this, pantallaregistro.class);
        startActivity(intent);
    }


}