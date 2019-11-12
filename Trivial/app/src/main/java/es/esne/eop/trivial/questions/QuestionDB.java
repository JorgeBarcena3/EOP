package es.esne.eop.trivial.questions;

import java.util.Random;

/**
 * Questions data
 * Bibliography: question types, question statements and correct answer are extracted from:
 *      Horn Abbot International Limited, Trivial Pursuit Ed. Genus, Spain, 1995.
 * @author Carolina on Dec. 2018
 */
public class QuestionDB {

    /**
     * Collection of questions
     */
    private static final QuestionModel[] QUESTIONS={
        new QuestionModel(
                QuestionModel.Type.BLUE,
                "¿De qué estado norteamericano forman parte las islas Aleutianas?",
                "California",
                "Alaska",
                "Oregón",
            2),
        new QuestionModel(
                QuestionModel.Type.PINK,
                "¿Cuál fue el primer programa-concurso creado por Narciso Ibáñez Serrador?",
                "Un, dos, tres...",
                "No te rías que es peor",
                "Historias desde la cripta",
                1),
        new QuestionModel(
                QuestionModel.Type.YELLOW,
                "¿Cuál era el nombre romano de Andalucía?",
                "Al-Ándalus",
                "Emérita Augusta",
                "Bética",
                3),
        new QuestionModel(
                QuestionModel.Type.BROWN,
                "¿Con qué país relacionas el \"Romance de Roldán\"?",
                "España",
                "Argentina",
                "Francia",
                3),
        new QuestionModel(
                QuestionModel.Type.GREEN,
                "¿A qué edad pasa una potra a ser yegua?",
                "A los 5 años",
                "A los 6 años",
                "A los 7 años",
                1),
        new QuestionModel(
                QuestionModel.Type.ORANGE,
                "¿Hasta qué número cuenta un árbitro de lucha libre cuando un luchador es abatido?",
                "Hasta 5",
                "Hasta 3",
                "Hasta 10",
                2),
        new QuestionModel(
                QuestionModel.Type.BLUE,
                "¿Qué país marítimo tiene menor longitud de costa?",
                "Mónaco",
                "San Marino",
                "Malta",
                1),
        new QuestionModel(
                QuestionModel.Type.PINK,
                "¿Qué actor se presentaba en una película como Forest Gump?",
                "Harrison Ford",
                "Nicolas Cage",
                "Tom Hanks",
                3),
        new QuestionModel(
                QuestionModel.Type.YELLOW,
                "¿Quién fue el primer presidente católico romano de Estados Unidos?",
                "John F. Kennedy",
                "George Bush Sr.",
                "George Bush Jr.",
                1),
        new QuestionModel(
                QuestionModel.Type.BROWN,
                "¿Cómo llamó Federico García Lorca a la serie de romances que dedicó al pueblo andaluz?",
                "\"Un poeta en Nueva York\"",
                "\"Romancero gitano\"",
                "\"Romanzas desde Andalucía\"",
                2),
        new QuestionModel(
                QuestionModel.Type.GREEN,
                "¿Cuántas patas tiene un cangrejo?",
                "6",
                "8",
                "10",
                3),
        new QuestionModel(
                QuestionModel.Type.ORANGE,
                "¿Qué orden numérico ocupan los primeros juegos olímpicos del siglo XXI?",
                "10",
                "25",
                "50",
                2),
        new QuestionModel(
                QuestionModel.Type.BLUE,
                "¿En qué país viven los verdaderos bohemios?",
                "Austria",
                "República Checa",
                "Eslovaquia",
                3),
        new QuestionModel(
                QuestionModel.Type.PINK,
                "¿Quién fue la primera actriz que apareció en un sello de Correos?",
                "Lina Morgan",
                "Grace Kelly",
                "Sara Montiel",
                2),
        new QuestionModel(
                QuestionModel.Type.YELLOW,
                "¿Por qué nombre se conoce a la Organización Internacional de la Policía Criminal?",
                "INTERPOL",
                "EUROPOL",
                "OIPC",
                1),
        new QuestionModel(
                QuestionModel.Type.BROWN,
                "¿Hasta qué fecha dice el refrán que \"no te quites el sayo\"?",
                "Hasta el 20 de abril",
                "Hasta el 7 de julio",
                "Hasta el 40 de mayo",
                3),
        new QuestionModel(
                QuestionModel.Type.GREEN,
                "¿A qué país se llega taladrando un agujero recto desde Buenos Aires pasando por el centro de la Tierra?",
                "Rusia",
                "India",
                "China",
                3),
        new QuestionModel(
                QuestionModel.Type.ORANGE,
                "¿Dónde se sitúan las copas de vino en la mesa?",
                "A la izquierda",
                "A la derecha",
                "Al centro",
                1)
    };

    /**
     * Gets a random question
     * @return Random question model
     */
    public static QuestionModel getRandomQuestion(){
        return QUESTIONS[new Random().nextInt(QUESTIONS.length)];
    }

    /**
     * Gets a random questions from a question type
     * @param type Question type
     * @return Random question model object from question type
     */
    public static QuestionModel getRandomQuestion(QuestionModel.Type type){
        int randomIndex = new Random().nextInt(3);
        switch (type){
            case BLUE:
                randomIndex = randomIndex*6;
                break;
            case PINK:
                randomIndex = randomIndex*6 + 1;
                break;
            case YELLOW:
                randomIndex = randomIndex*6 + 2;
                break;
            case BROWN:
                randomIndex = randomIndex*6 + 3;
                break;
            case GREEN:
                randomIndex = randomIndex*6 + 4;
                break;
            case ORANGE:
                randomIndex = randomIndex*6 + 5;
                break;
        }
        return QUESTIONS[randomIndex];
    }
}
