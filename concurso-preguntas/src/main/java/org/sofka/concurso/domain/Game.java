package org.sofka.concurso.domain;

import java.util.ArrayList;

/**
 * Game representa un juego
 *
 * @author Mauricio Gómez - mmaurogg@gmail.com
 * @author Óscar Farfán - oscarfarfan92@gmail.com
 *
 * @version 1.0.0.000 3-06-2022
 */
public class Game {
    
    private Player player;
    private ArrayList<Question> questions;
    private Integer score;

    /**
     * Crea a un juego que recibe como parámetros el jugador, las preguntas y el puntaje
     *
     * @param player jugador
     * @param questions preguntas
     * @param score puntaje
     */
    public Game(Player player, ArrayList<Question> questions, Integer score) {
        this.player = player;
        this.questions = questions;
        this.score = score;
    }

    /**
     * Retorna el jugador
     *
     * @return devuelve el jugador
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Modifica el jugador
     *
     * @param player recibe el nuevo jugador a asignar al juego
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Retorna las preguntas
     *
     * @return devuelve las preguntas
     */
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    /**
     * Modifica las preguntas del juego
     *
     * @param questions recibe las nuevas preguntas del juego
     */
    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    /**
     * Calcula la puntuación del juego
     *
     * @param success recibe la validación
     * @return devuelve el puntaje calculado
     */
    public Integer computeScore(boolean success){
        final Integer SCORE_SUCCESS = 10;
        
        if(!success){
            this.score = 0;
            return score;
        }

        this.score += SCORE_SUCCESS;

        return score;
    }

    /**
     * Retorna los datos del juego
     *
     * @return devuelve los datos del juego
     */
    public String toString(){
        return this.player + " Puntaje: " + this.score;
    }

}
