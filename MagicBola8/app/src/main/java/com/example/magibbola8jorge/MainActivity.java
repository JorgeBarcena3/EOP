package com.example.magibbola8jorge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    //Almacenan las variables globlales
    public static final String NAME = "name";
    public static final String QUESTION = "question";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obetenemos el boton, y nos suscribimos el evento OnClick
        Button button=(Button)findViewById(R.id.botonPreguntar);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            /**
             * Cuando el usuario haga click en el botón se llamará al
             * método ChangeActivity
             */
            public void onClick(View view){
                ChangeActivity();
            }
        });

    }

    boolean ComprobarRespuesta( String question_to_check, String user_name){

        boolean isCorrect = (question_to_check.contains("?") && question_to_check.contains("¿")) && (!user_name.isEmpty());
         return isCorrect;
    }

    //Al pultar el boton
    void ChangeActivity(){

    //Obtemeos los labes del activity Main
        EditText text_name = (EditText) findViewById(R.id.Nombrelbl);
        EditText text_question = (EditText) findViewById(R.id.preguntalbl);

      //Obtenemos el texto de los labels
        String user_name = text_name.getText().toString();
        String user_question = text_question.getText().toString();

  //Comprobamos si la pregunta es buena
        if(ComprobarRespuesta(user_question, user_name)){

            //Creamos el intent con la siguiente Activity
            Intent intent = new Intent (this, MostrarRespuesta.class);

          //Le pasamos los parametros
            intent.putExtra(QUESTION, user_question);
            intent.putExtra(NAME, user_name);

            //Comenzamos la activity
            startActivity(intent);

        }
        else{
            //Retormanos el error
            Toast.makeText(getBaseContext(), R.string.pregunta_fallada, Toast.LENGTH_LONG ).show();
        }

    }

    //Al restaurar la aplicacion
    @Override
    protected void onResume() {
        super.onResume();

        //Cogemos los campos
        EditText text_name = (EditText) findViewById(R.id.Nombrelbl);
        EditText text_question = (EditText) findViewById(R.id.preguntalbl);

        //Reiniciamos los campos
        text_name.setText("");
        text_question.setText("");

    }


}
