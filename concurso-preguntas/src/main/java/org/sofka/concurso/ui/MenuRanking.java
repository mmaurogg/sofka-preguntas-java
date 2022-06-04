package org.sofka.concurso.ui;

import org.sofka.concurso.domain.Game;
import org.sofka.concurso.domain.Player;
import org.sofka.concurso.domain.Question;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class MenuRanking {

    public static ArrayList<Game> getGames(){

        ArrayList<Game> games = new ArrayList<>();

        Player player = new Player("pepito");

        String ans[] = {"resp1","resp2","resp3"};
        String anscorrect = "respC";

        Question question1 = new Question(1, "pregunta1", ans, anscorrect);
        Question question2 = new Question(2, "pregunta2", ans, anscorrect);
        Question question3 = new Question(3, "pregunta3", ans, anscorrect);
        Question question4 = new Question(4, "pregunta4", ans, anscorrect);
        Question question5 = new Question(5, "pregunta5", ans, anscorrect);

        ArrayList<Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);

        Game game = new Game(player, questions, 3);

        games.add(game);

        return games;
    }

    /*public static void viewRanking(ArrayList<Game> games){
        System.out.println("Jugador| Puntaje");
        for (Game game: games) {
            System.out.println(game.getPlayer().getUsername() + "  | " + game.getPlayer().getScore());
        }
    }*/

    public static void viewRanking(String name, Integer score){
        System.out.println("Jugador| Puntaje");
        System.out.println(name + "  | " + score);
    }


}
