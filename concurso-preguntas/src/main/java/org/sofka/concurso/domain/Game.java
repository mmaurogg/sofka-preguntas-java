package org.sofka.concurso.domain;


public class Game {
    
    private Player player;
    private Question[] question;
    private Integer score;
    
    public Game(Player player, Question[] question) {
        this.player = player;
        this.question = question;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Question[] getQuestion() {
        return question;
    }

    public void setQuestion(Question[] question) {
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

}
