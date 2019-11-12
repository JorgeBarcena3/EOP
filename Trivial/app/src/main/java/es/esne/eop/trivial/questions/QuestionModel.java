package es.esne.eop.trivial.questions;

/**
 * Question model
 * @author Carolina on Dec. 2018
 */
public class QuestionModel {

    /**
     * Question type definition
     */
    public enum Type{
        BLUE,   //Geography
        PINK,   //Entertainment
        YELLOW, //History
        BROWN,  //Arts & literature
        GREEN,  //Sciences & nature
        ORANGE  //Sports & leisure
    }

    /**
     * Number of answers
     */
    private static final int NUMBER_OF_ANSWERS=3;

    /**
     * Question type
     */
    private Type type;

    /**
     * Question statement
     */
    private String statement;

    /**
     * Question answers
     */
    private String[] answers;

    /**
     * Question correct answer (values 1, 2, 3)
     */
    private int correct;

    /**
     * Constructor
     * @param type      Question type
     * @param statement Question statement
     * @param answer1   Question first answer
     * @param answer2   Question second answer
     * @param answer3   Questior third answer
     * @param correct   Question correct answer (values 1, 2, 3)
     */
    QuestionModel(Type type,String statement,String answer1,String answer2,String answer3,int correct){
        this.type=type;
        this.statement=statement;
        this.answers=new String[NUMBER_OF_ANSWERS];
        this.answers[0]=answer1;
        this.answers[1]=answer2;
        this.answers[2]=answer3;
        this.correct=correct;
    }

    /**
     * Gets question type
     * @return Question type
     */
    public Type getType() {
        return type;
    }

    /**
     * Gets question statement
     * @return Question statement
     */
    public String getStatement() {
        return statement;
    }

    /**
     * Gets question first answer
     * @return First answer
     */
    public String getAnswer1() {
        return answers[0];
    }

    /**
     * Gets question second answer
     * @return Second answer
     */
    public String getAnswer2() {
        return answers[1];
    }

    /**
     * Gets question third answer
     * @return Third answer
     */
    public String getAnswer3() {
        return answers[2];
    }

    /**
     * Gets number of correct answer
     * @return Number of correct answer
     */
    public int getCorrect() {
        return correct;
    }

    /**
     * Converts current object into a readable String
     * @return Readable object
     */
    public String toReadableString(){
        return "\nPregunta:" +
                "\n\tTipo: " + getType() +
                "\n\tEnunciado: " + getStatement() +
                "\n\tRespuesta 1: " + getAnswer1() +
                "\n\tRespuesta 2: " + getAnswer2() +
                "\n\tRespuesta 3: " + getAnswer3() +
                "\n\tCorrecta: " + getCorrect();
    }

    /**
     * Converts current object into a readable HTML String
     * @return Readable HTML object
     */
    public String toHtmlReadableString(){
        return "<p styles=\"margin: 1em;\"><strong>Pregunta</strong>:" +
                "<br>&nbsp;&nbsp;<strong>Tipo:</strong> " + getType() +
                "<br>&nbsp;&nbsp;<strong>Enunciado:</strong> " + getStatement() +
                "<br>&nbsp;&nbsp;<strong>Respuesta 1</strong>: " + getAnswer1() +
                "<br>&nbsp;&nbsp;<strong>Respuesta 2</strong>: " + getAnswer2() +
                "<br>&nbsp;&nbsp;<strong>Respuesta 3</strong>: " + getAnswer3() +
                "<br>&nbsp;&nbsp;<strong>Correcta:</strong> " + getCorrect() +
                "</p>";
    }
}
