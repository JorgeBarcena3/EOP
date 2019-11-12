package com.example.mascotavirtual;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //Declaramos las imagenes de las mascotas
    private ImageView mascotaEnfadada;
    private ImageView mascotaContenta;

    //Declaramos las imagenes de las necesidades
    private ImageView hambre;
    private ImageView baño;
    private ImageView sueño;
    private ImageView mascotaImg;

    //Declaramos nuestra mascota
    Mascota mascota = new Mascota();

    //Botones
    private ImageButton boton_comer;
    private ImageButton boton_sueño;
    private ImageButton boton_baño;

    //Texto
    private TextView textoEstado;

    //Servicio
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos las imagenes
        inicializarImagenes();

        //Configuramos los botones
        confirgurarBotones();
    }


    @Override
    protected void onResume() {
        super.onResume();

        //Se obtiene un estado aleatorio
        mascota.cambiarEstadoAleatorio();
        mascotaImg.setImageResource(R.drawable.angry);
        textoEstado.setText("Tengo " + mascota.estadoActual.toString());

    }

    @Override
    protected void onPause() {
        super.onPause();

        //Comienza la cuenta atras
        empezarCuentaAtras();

    }

    public void onDestroy() {

        super.onDestroy();
        stopService(intent);
    }

    private void confirgurarBotones() {

        boton_comer=findViewById(R.id.HambreBtn);
        boton_comer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Check what is the current need
                Estado need = mascota.estadoActual;


                if (mascota.necesidadSatisfecha(Estado.Hambre)) {

                    //Satisface la necesidad
                    mascota.estadoActual = null;
                    mascotaImg.setImageResource(R.drawable.happy);
                    textoEstado.setText(R.string.texto_no_necesidad);


                }
                else
                    Toast.makeText(getBaseContext(), R.string.texto_error, Toast.LENGTH_SHORT).show();

            }
        });

        boton_sueño=findViewById(R.id.sueñoBtn);
        boton_sueño.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Check what is the current need
                Estado need = mascota.estadoActual;


                if (mascota.necesidadSatisfecha(Estado.Sueño)) {

                    //Satisface la necesidad
                    mascota.estadoActual = null;
                    mascotaImg.setImageResource(R.drawable.happy);
                    textoEstado.setText(R.string.texto_no_necesidad);


                }
            }
        });

        boton_baño=findViewById(R.id.BañoBtn);
        boton_baño.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Check what is the current need
                Estado need = mascota.estadoActual;


                if (mascota.necesidadSatisfecha(Estado.Baño)) {

                    //Satisface la necesidad
                    mascota.estadoActual = null;
                    mascotaImg.setImageResource(R.drawable.happy);
                    textoEstado.setText(R.string.texto_no_necesidad);


                }
            }
        });


    }

    private void inicializarImagenes() {
        mascotaImg = findViewById(R.id.ImagenEstado);
        mascotaImg.setImageResource(R.drawable.happy);

        textoEstado = findViewById(R.id.tipo_de_estado);
        textoEstado.setText("No tengo ninguna necesidad");
    }

    private void empezarCuentaAtras(){
        intent = new Intent(getBaseContext(), CuentaAtrasService.class);
        startService(intent);
    }

}
