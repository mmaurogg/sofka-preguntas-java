package org.sofka.concurso.domain;

public class Player {
    private String username;
    private int score;

    public Player(username){
        this.username = username;
    }

    public String getUsername() {
        return this username;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String chooseAnswer(String[] answerOptions){

    }

    public String toString(){
        return "Juagador: " + this.username + " Puntaje: " + this.score;
    }
}
