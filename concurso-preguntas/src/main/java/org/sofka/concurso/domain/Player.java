package org.sofka.concurso.domain;

public class Player {

    private String username;
    private Integer score;

    public Player(String username){
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String toString(){
        return "Juagador: " + this.username;
    }
}
