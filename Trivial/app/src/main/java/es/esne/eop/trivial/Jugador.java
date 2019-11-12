package es.esne.eop.trivial;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import es.esne.eop.trivial.questions.QuestionModel;

public class Jugador {
    //Lista de preguntas acertadas
    public List<QuestionModel.Type> preguntasAcertadas;
    //Lista de preguntas por acertar
    public List<QuestionModel.Type> preguntasPorAcertar;

    //Contador de preguntas
    int contadorPreguntas;

    //Constructor
    Jugador(){
        preguntasAcertadas = new ArrayList<>();
        preguntasPorAcertar =new ArrayList<QuestionModel.Type>(EnumSet.allOf(QuestionModel.Type.class));
        contadorPreguntas = 0;
    }


    //Se acierta una categoria
    public void acertarPregunta(QuestionModel.Type _type) {

        preguntasAcertadas.add(_type);
        preguntasPorAcertar.remove(_type);


    }

    //Obtener un tipo random de pregunta, entre las posibles
    public QuestionModel.Type obtenerPregunta(){

        contadorPreguntas++;
        Random random = new Random();
        return preguntasPorAcertar.get( random.nextInt(preguntasPorAcertar.size()) );

    }

}
