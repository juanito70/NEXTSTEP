package com.example.nextstep;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.PlacesClient;

import java.util.Arrays;

public class pantallafarmacia extends AppCompatActivity implements OnMapReadyCallback {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationClient;
    private PlacesClient placesClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallafarmacia);

        // Inicializar Places API
        Places.initialize(getApplicationContext(), "AIzaSyCBJ3Mcabf4KAPlGJ-PJ3vd8l4lo7_itAs");
        placesClient = Places.createClient(this);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        getLocationPermission();
    }

    private void getLocationPermission() {
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getDeviceLocation();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    private void getDeviceLocation() {
        try {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                fusedLocationClient.getLastLocation().addOnCompleteListener(this, task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        Location location = task.getResult();
                        LatLng currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15));

                        // Buscar hospitales cercanos
                        findNearbyHospitals(currentLocation);
                    } else {
                        // Manejar el caso en que no se obtiene la ubicación
                        Toast.makeText(this, "No se pudo obtener la ubicación actual", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    private void findNearbyHospitals(LatLng currentLocation) {
        // Configurar la solicitud de lugares
        FindCurrentPlaceRequest request = FindCurrentPlaceRequest.newInstance(Arrays.asList(
                Place.Field.NAME, Place.Field.LAT_LNG));

        placesClient.findCurrentPlace(request).addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult() != null) {
                for (PlaceLikelihood placeLikelihood : task.getResult().getPlaceLikelihoods()) {
                    Place place = placeLikelihood.getPlace();
                    if (place.getTypes().contains(Place.Type.HOSPITAL)) {
                        LatLng hospitalLocation = place.getLatLng();
                        if (hospitalLocation != null) {
                            mMap.addMarker(new MarkerOptions()
                                    .position(hospitalLocation)
                                    .title(place.getName()));
                        }
                    }
                }
            } else {
                // Manejar errores
                Exception exception = task.getException();
                if (exception != null) {
                    exception.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getDeviceLocation();
            } else {
                // Permiso denegado, mostrar mensaje al usuario
                Toast.makeText(this, "Permiso de ubicación denegado", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
