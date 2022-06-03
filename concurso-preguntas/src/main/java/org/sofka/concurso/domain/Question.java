package org.sofka.concurso.domain;

public class Question {
    
    private Integer difficulty;
    private String statement;
    private String[] answer;

    
    public Question(Integer difficulty, String statement, String[] answer) {
        this.difficulty = difficulty;
        this.statement = statement;
        this.answer = answer;
    }


    public Integer getDifficulty() {
        return difficulty;
    }


    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }


    public String getStatement() {
        return statement;
    }


    public void setStatement(String statement) {
        this.statement = statement;
    }


    public String[] getAnswer() {
        return answer;
    }


    public void setAnswer(String[] answer) {
        this.answer = answer;
    }

    
}
