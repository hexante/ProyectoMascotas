package com.example.proyectomascota;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistroUsuario extends AppCompatActivity {

    private EditText txtemail;
    private EditText txtcontraseña;
    private Button btnregistro;
    private ProgressDialog progressDialog;

    //declaramos un objeto firebase

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        //iniciamos el objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        //referenciamos los views

        txtemail = (EditText) findViewById(R.id.txtcorreo);
        txtcontraseña = (EditText) findViewById(R.id.txtContrasena);

        btnregistro = (Button) findViewById(R.id.btnregistro);

        progressDialog = new ProgressDialog(this);


        //
        btnregistro.setOnClickListener((View.OnClickListener) this);
    }
    private void registrarUsuario (){

        //obtenemos el correo y contraseña desde la caja de texto
        String email = txtemail.getText().toString().trim();
        String contraseña = txtcontraseña.getText().toString().trim();

        //verificamos que las cajas no esten vacias
        if(TextUtils.isEmpty(email)){//igual que .equals

            Toast.makeText(this,"Se debe ingresar un email",Toast.LENGTH_LONG).show();
            return;        }
        if (TextUtils.isEmpty(contraseña)){

            Toast.makeText(this,"se debe ingresar una contraseña",Toast.LENGTH_LONG).show();
            return;        }

        progressDialog.setMessage("Realizando Registro En Linea...");
        progressDialog.show();



        firebaseAuth.createUserWithEmailAndPassword(email,contraseña)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //chaquiamos if correcto
                        if (task.isSuccessful()){

                            Toast.makeText(RegistroUsuario.this,"Se  ha registrado email",Toast.LENGTH_LONG).show();
                        }else{

                            Toast.makeText(RegistroUsuario.this,"No se pudo registrar el usuario",Toast.LENGTH_LONG).show();
                        }

                        progressDialog.dismiss();
                    }
                });


    }


    public void onClick(View view) {
        //invocamos el metodo registro
        registrarUsuario();
    }
}
