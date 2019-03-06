package com.example.proyectomascota;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class IngresoUsuario extends AppCompatActivity {


    Button btnregitro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_usuario);

        btnregitro = (Button) findViewById(R.id.btninicioregistro);

        btnregitro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent IngreoUsuario = new Intent(getApplicationContext(), RegistroUsuario.class);
                // IngreoUsuario.putExtra("usuario",usuario);
                //  IngreoUsuario.putExtra("fundacion",fundacion);
                startActivity(IngreoUsuario);

            }
        });


    }



}
