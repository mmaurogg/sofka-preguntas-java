package org.sofka.concurso.domain;

import java.util.ArrayList;

public class Game {
    
    private Player player;
    private ArrayList<Question> questions;
    private Integer score;
    
    public Game(Player player, ArrayList<Question> questions, Integer score) {
        this.player = player;
        this.questions = questions;
        this.score = score;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

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
     * Método para mostrar los datos del juego
     */
    public String toString(){
        return this.player + " Puntaje: " + this.score;
    }

}
