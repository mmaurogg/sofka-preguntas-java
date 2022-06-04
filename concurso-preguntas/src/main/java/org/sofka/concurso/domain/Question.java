package org.sofka.concurso.domain;

/**
 * Question representa una pregunta dentro del juego
 *
 * @author Mauricio Gómez - mmaurogg@gmail.com
 * @author Óscar Farfán - oscarfarfan92@gmail.com
 *
 * @version 1.0.0.000 3-06-2022
 */
public class Question {
    
    private Integer difficulty;
    private String statement;
    private String[] options;
    private String answer;

    /**
     * Crea una pregunta que recibe como parámetros la dificultad, la declaración, las opciones
     * y la respuesta correcta
     *
     * @param difficulty dificultad de la pregunta
     * @param statement declaración de la pregunta
     * @param options opciones de la pregunta
     * @param answer respuesta correcta de la pregunta
     */
    public Question(Integer difficulty, String statement, String[] options, String answer) {
        this.difficulty = difficulty;
        this.statement = statement;
        this.options = options;
        this.answer = answer;
    }

    /**
     * Retorna la dificultad de la pregunta
     *
     * @return devuelve la dificultad de la pregunta
     */
    public Integer getDifficulty() {
        return difficulty;
    }

    /**
     * Modifica la dificultad de la pregunta
     *
     * @param difficulty recibe la nueva dificultad de la pregunta
     */
    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Retorna la declaración o texto de la pregunta
     *
     * @return devuelve la declaración o texto de la pregunta
     */
    public String getStatement() {
        return statement;
    }

    /**
     * Modifica la declaración o texto de la pregunta
     *
     * @param statement recibe la nueva la declaración o texto de la pregunta
     */
    public void setStatement(String statement) {
        this.statement = statement;
    }

    /**
     * Retorna las opciones de respuesta de la pregunta
     *
     * @return devuelve las opciones de respuesta de la pregunta
     */
    public String[] getoptions() {
        return options;
    }

    /**
     * Modifica las opciones de la pregunta
     *
     * @param options recibe las nuevas opciones de la pregunta
     */
    public void setoptions(String[] options) {
        this.options = options;
    }

    /**
     * Retorna la respuesta correcta de la pregunta
     *
     * @return devuelve la respuesta correcta de la pregunta
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Modifica la respuesta correcta de la pregunta
     *
     * @param answer recibe la nueva respuesta correcta de la pregunta
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Retorna los datos de la pregunta
     *
     * @return devuelve los datos de la pregunta
     */
    public String toString(){
        return "pregunta: " + this.statement + " Respuesta: " + answer;
    }
}
