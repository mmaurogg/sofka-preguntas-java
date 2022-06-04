package org.sofka.concurso.data;

import java.util.ArrayList;

import org.sofka.concurso.domain.Question;

/**
 * Arreglo de objetos de donde se extraerán las preguntas del juego
 */
public class QuestionsGame {

    public static ArrayList<Question> Questions() {

    String[] ansA = { "respA1", "respA2", "respA3" };
    String[] ansB = { "respB1", "respB2", "respB3" };
    String anscorrect = "respC";

    Question question1 = new Question(1, "preguntaA1", ansA, anscorrect);
    Question question2 = new Question(2, "preguntaA2", ansA, anscorrect);
    Question question3 = new Question(3, "preguntaA3", ansA, anscorrect);
    Question question4 = new Question(4, "preguntaA4", ansA, anscorrect);
    Question question5 = new Question(5, "preguntaA5", ansA, anscorrect);

    Question question6 = new Question(1, "preguntaB1", ansB, anscorrect);
    Question question7 = new Question(2, "preguntaB2", ansB, anscorrect);
    Question question8 = new Question(3, "preguntaB3", ansB, anscorrect);
    Question question9 = new Question(4, "preguntaB4", ansB, anscorrect);
    Question question10 = new Question(5, "preguntaB5", ansB, anscorrect);

    ArrayList<Question> questions = new ArrayList<>();
    questions.add(question1);
    questions.add(question2);
    questions.add(question3);
    questions.add(question4);
    questions.add(question5);
    questions.add(question6);
    questions.add(question7);
    questions.add(question8);
    questions.add(question9);
    questions.add(question10);

    return questions;
    }


}
