package es.esne.eop.trivial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

import es.esne.eop.trivial.questions.QuestionDB;
import es.esne.eop.trivial.questions.QuestionModel;

public class MainActivity extends Activity {

    //Gajos de preguntas
    ImageView deportes;
    ImageView geografia;
    ImageView historia;
    ImageView espectaculos;
    ImageView ciencia;
    ImageView arte;

    //labels de preguntas
    ImageView preguntaImagen;
    TextView preguntaCategoria;
    TextView preguntaActual;

    //Botones
    Button respuesta1;
    Button respuesta3;
    Button respuesta2;

    //PreguntaActual
    QuestionModel pregunta;

    //Jugador
    Jugador jugador = new Jugador();

    //Servicio de vibracion
    Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarConLayout();
        suscribirseAOnClick();
        generarPregunta(QuestionModel.Type.BROWN);
        //Cogemos el servicio de vibracion
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);


    }

    private void suscribirseAOnClick() {

        respuesta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int correcto = pregunta.getCorrect();
                if(correcto != 1){
                    incorrecto();
                }
                else
                {
                    correcto();
                }

                if(!checkFinal()) {
                    QuestionModel.Type _type = jugador.obtenerPregunta();
                    generarPregunta(_type);
                }
            }


        });

        respuesta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int correcto = pregunta.getCorrect();
                if(correcto != 2){
                    incorrecto();
                }
                else
                {
                    correcto();
                }
                if(!checkFinal()) {
                    QuestionModel.Type _type = jugador.obtenerPregunta();
                    generarPregunta(_type);
                }
            }
        });

        respuesta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int correcto = pregunta.getCorrect();
                if(correcto != 3){
                    incorrecto();
                }
                else
                {
                 correcto();
                }
                if(!checkFinal()) {
                    QuestionModel.Type _type = jugador.obtenerPregunta();
                    generarPregunta(_type);
                }
            }
        });
    }

    //Cuando es incorrecto
    private void incorrecto() {
        //Vibracion
        vibrator.vibrate(200);
    }

    //Cuando es correcto
    private void correcto() {
        //Vibracion
        vibrator.vibrate(50);


        jugador.acertarPregunta(pregunta.getType());
        obtenerGajo();
    }

    //SI es el final cambiamos de pantalla
    private boolean checkFinal() {

        if(jugador.preguntasPorAcertar.size() == 0) {
            Intent intent = new Intent(this, FinalActivity.class);

            intent.putExtra("CONTADORPREGUNTAS", jugador.contadorPreguntas);

            startActivity(intent);
            return true;
        }
        return false;

    }



    //Al restaurar la aplicacion
    @Override
    protected void onResume() {
        super.onResume();

        //Reiniciamos los campos
       jugador = new Jugador();

       //Restauramos los gajos
        geografia.setImageResource(R.color.white);
        espectaculos.setImageResource(R.color.white);
        historia.setImageResource(R.color.white);
        arte.setImageResource(R.color.white);
        ciencia.setImageResource(R.color.white);
        deportes.setImageResource(R.color.white);

    }


    private void obtenerGajo() {

        switch (pregunta.getType()){
            case BLUE:
                geografia.setImageResource(R.color.colorGeografia);
                break;
            case PINK:
                espectaculos.setImageResource(R.color.colorEspectaculos);
                break;
            case YELLOW:
                historia.setImageResource(R.color.colorHistoria);
                break;
            case BROWN:
                arte.setImageResource(R.color.colorArteYLiteratura);
                break;
            case GREEN:
                ciencia.setImageResource(R.color.colorCienciasYNaturaleza);
                break;
            case ORANGE:
                deportes.setImageResource(R.color.colorDeportesYOcio);
                break;
        }
    }


    private void inicializarConLayout() {

        //Gajos de preguntas
         deportes = findViewById(R.id.Deportes);
         geografia = findViewById(R.id.Geografia);
         historia = findViewById(R.id.Historia);
         espectaculos = findViewById(R.id.Espectaculos);
         ciencia = findViewById(R.id.Ciencia);
         arte = findViewById(R.id.Arte);

        //labels de preguntas
        preguntaImagen = findViewById(R.id.PreguntaImagen);
        preguntaCategoria = findViewById(R.id.PreguntaCategoria);
        preguntaActual = findViewById(R.id.PreguntaActual);

        //Botones
        respuesta1 = findViewById(R.id.Pregunta1);
        respuesta3 = findViewById(R.id.Pregunta2);
        respuesta2 = findViewById(R.id.Pregunta3);

    }

    private void generarPregunta(QuestionModel.Type _type){

         pregunta = QuestionDB.getRandomQuestion(_type);
        setPreguntasType(_type);
        preguntaActual.setText(pregunta.getStatement());
        respuesta1.setText(pregunta.getAnswer1());
        respuesta2.setText(pregunta.getAnswer2());
        respuesta3.setText(pregunta.getAnswer3());

    }

    private void generarPregunta(){

         pregunta = QuestionDB.getRandomQuestion();
        setPreguntasType(pregunta.getType());
        preguntaActual.setText(pregunta.getStatement());
        respuesta1.setText(pregunta.getAnswer1());
        respuesta2.setText(pregunta.getAnswer2());
        respuesta3.setText(pregunta.getAnswer3());

    }

    private void setPreguntasType(QuestionModel.Type _type) {
        switch (_type){
            case BLUE:
                preguntaImagen.setImageResource(R.color.colorGeografia);
                preguntaCategoria.setText("Geografia");
                break;
            case PINK:
                preguntaImagen.setImageResource(R.color.colorEspectaculos);
                preguntaCategoria.setText("Espectaculos");
                break;
            case YELLOW:
                preguntaImagen.setImageResource(R.color.colorHistoria);
                preguntaCategoria.setText("Historia");
                break;
            case BROWN:
                preguntaImagen.setImageResource(R.color.colorArteYLiteratura);
                preguntaCategoria.setText("Arte y literatura");
                break;
            case ORANGE:
                preguntaImagen.setImageResource(R.color.colorDeportesYOcio);
                preguntaCategoria.setText("Deportes y ocio");
                break;
            case GREEN:
                preguntaImagen.setImageResource(R.color.colorCienciasYNaturaleza);
                preguntaCategoria.setText("Ciencias y Naturaleza");
                break;

        }
    }


}
