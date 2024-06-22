package com.example.nextstep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class pantallainicio extends AppCompatActivity {

    Button btn_login;
    EditText correo, password;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallainicio);
        mAuth = FirebaseAuth.getInstance();

    correo = findViewById(R.id.correo);
    password = findViewById(R.id.contraseña);
    btn_login = findViewById(R.id.Inicio);

    btn_login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String emailUser = correo.getText().toString().trim();
            String passUser = password.getText().toString().trim();

            if(emailUser.isEmpty() && passUser.isEmpty()){
                Toast.makeText(pantallainicio.this,"", Toast.LENGTH_SHORT).show();
            }else {
                loginUser(emailUser, passUser);
            }

        }

    });

    }

    private void loginUser(String emailUser, String passUser) {
        mAuth.signInWithEmailAndPassword(emailUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    finish();
                    startActivity(new Intent(pantallainicio.this, desarrollo.class));
                    Toast.makeText(pantallainicio.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(pantallainicio.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(pantallainicio.this,"Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}