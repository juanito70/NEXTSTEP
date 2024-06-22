package com.example.nextstep;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.pm.PackageManager;
import android.net.Uri;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class pantallataxi extends AppCompatActivity {

    private static final String TAXI_MAXIM_PACKAGE_NAME = "com.taximaxim.passenger";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button openTaxiMaximButton = findViewById(R.id.openTaxiMaximButton);
        openTaxiMaximButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAppInstalled(pantallataxi.this, TAXI_MAXIM_PACKAGE_NAME)) {
                    Intent launchIntent = getPackageManager().getLaunchIntentForPackage(TAXI_MAXIM_PACKAGE_NAME);
                    if (launchIntent != null) {
                        startActivity(launchIntent);
                    }
                } else {
                    // Open Play Store to download the app
                    Intent playStoreIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + TAXI_MAXIM_PACKAGE_NAME));
                    startActivity(playStoreIntent);
                }
            }
        });
    }

    private boolean isAppInstalled(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }



        ImageView notificacionImageView = findViewById(R.id.notificacion);

        notificacionImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pantallataxi.this, pantallanotificacion.class);
                startActivity(intent);
            }
        });

        ImageView cuentaImageView = findViewById(R.id.cuenta);

        cuentaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pantallataxi.this, Dpantallausuario.class);
                startActivity(intent);
            }
        });

        ImageView casaImageView = findViewById(R.id.incioprincital);

        casaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pantallataxi.this, desarrollo.class);
                startActivity(intent);
            }
        });
    }
}