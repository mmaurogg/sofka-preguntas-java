package org.sofka.concurso.domain;

import java.util.ArrayList;

public class Game {
    
    private Player player;
    private ArrayList<Question> question;
    private Integer score;
    
    public Game(Player player, ArrayList<Question> question) {
        this.player = player;
        this.question = question;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Question> getQuestion() {
        return question;
    }

    public void setQuestion(ArrayList<Question> question) {
        this.question = question;
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
        return "Juagador: " + this.player + " Puntaje: " + this.score;
    }

}
