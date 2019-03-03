package com.example.proyectomascota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Usuario,Fundacion;
    boolean usuario,fundacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Usuario = (Button) findViewById(R.id.IngresoU);
        Fundacion = (Button) findViewById(R.id.IngresoF);
      //  usuario = false;
      //  fundacion = false;


        Usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = true;
                Intent IngreoUsuario = new Intent(getApplicationContext(), IngresoUsuario.class);
               // IngreoUsuario.putExtra("usuario",usuario);
              //  IngreoUsuario.putExtra("fundacion",fundacion);
                startActivity(IngreoUsuario);

            }
        });

        Fundacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fundacion = true;
                Intent IngreoFundacion = new Intent(getApplicationContext(), IngresoUsuario.class);
              //  IngreoFundacion.putExtra("usuario",usuario);
             //   IngreoFundacion.putExtra("fundacion",fundacion);
                startActivity(IngreoFundacion);

            }
        });


    }
}
