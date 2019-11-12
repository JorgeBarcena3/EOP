package com.example.magibbola8jorge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.magibbola8jorge.MainActivity.NAME;
import static com.example.magibbola8jorge.MainActivity.QUESTION;

//Controla la actividad MostrarRepuesta
public class MostrarRespuesta extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_respuesta);

        Intent intent = this.getIntent();

        Button button=(Button)findViewById(R.id.volverAPreguntar);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
         //Finalizamos la actividad
            public void onClick(View view){
                finish();
            }
        });

     //Guardamos el parametro del nombre
        String name = intent.getStringExtra(NAME);

    //Guardamos el parametro de la question
        String question = intent.getStringExtra(QUESTION);

   //Obtenemos la respuesta
        String answer = Bola8.getMagic8BallResponse();


     //Obtenemos el inputlbl de la respuesta
        TextView text_elemnt = (TextView) findViewById(R.id.Respuesta);

    //Obtenemos el texto de la respuesta
        String mensaje = text_elemnt.getText().toString();

     //Damos formato
        mensaje = "Hey " + name + ", " + answer + ".";

 //Cambiamos el texto
        text_elemnt.setText(mensaje);

    }

}