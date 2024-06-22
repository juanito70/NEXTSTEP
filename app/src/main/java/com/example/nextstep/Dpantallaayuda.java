package com.example.nextstep;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Dpantallaayuda extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dpantallaayuda);

        Button ayudaButton = findViewById(R.id.mensaje);

        ayudaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void enviarMensajesDeAyuda() {
        String numeroTelefono1 = "919679896"; // Primer número de teléfono
        String numeroTelefono2 = "948277913"; // Segundo número de teléfono
        String mensaje = "Necesito ayuda con mi aplicación.";

        enviarMensaje(numeroTelefono1, mensaje);
        enviarMensaje(numeroTelefono2, mensaje);
    }

    private void enviarMensaje(String numeroTelefono, String mensaje) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:" + numeroTelefono));
        intent.putExtra("sms_body", mensaje);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // Maneja el caso en que no hay ninguna aplicación de mensajería disponible
            Toast.makeText(Dpantallaayuda.this, "No hay ninguna aplicación de mensajería disponible.", Toast.LENGTH_SHORT).show();
        }
    }
}