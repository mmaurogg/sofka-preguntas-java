package org.sofka.concurso.ui;

import org.sofka.concurso.utilities.Messages;
import org.sofka.concurso.utilities.MyScanner;
import org.sofka.concurso.utilities.DataAccess;

import java.util.ArrayList;
import java.util.Collections;

import org.sofka.concurso.domain.Game;
import org.sofka.concurso.domain.Player;
import org.sofka.concurso.domain.Question;

public class MenuGame {

    static Messages messages = Messages.getInstance();
    static MyScanner scanner = MyScanner.getInstance();
    static DataAccess dataAccess = DataAccess.getInstance();

    public static MenuGame getInstance() {
        return new MenuGame();
    }

    public Boolean createGame() {

        Boolean flag = true;
        Integer score = 0;

        Player player = createPlayer();
        ArrayList<Question> questions = getQuestions();

        messages.showMessage("Comencemos");

        for (Question question : questions) {
            messages.showMessage(question.getStatement());

            messages.showMessage("Seleccione la respuesta correcta");

            ArrayList<String> options = new ArrayList<>();

            for (int i = 0; i < question.getoptions().length; i++) {
                String option = question.getoptions()[i];
                options.add(option);
            }
            options.add(question.getAnswer());

            Collections.shuffle(options);

            for (int i = 0; i < options.size(); i++) {
                String option = options.get(i);
                messages.showMessage(i + ". " + option);
            }

            int selection = scanner.getInteger();

            // Validar respuesta
            flag = validateResponse(options.get(selection - 1), question.getAnswer());

            if (!flag) {
                score = 0;
                messages.showMessage("perdió el juego, su puntuación es: " + score);
                saveGame(player, questions, score);
                return flag;
            }

            messages.showMessage("es correcto");

            score++;

            if (score != 5) {
                messages.showMessage("su puentiación es: " + score + " ¿Desea reclamar su premio? (y/n)");
                String reward = scanner.getString();

                if (reward.equalsIgnoreCase("y")) {
                    messages.showMessage("Ganaste: " + score + " puntos");
                    saveGame(player, questions, score);
                    return flag;
                }
            }

        }

        messages.showMessage("Ha ganado el premio mayor, su puntuación " + score);
        saveGame(player, questions, score);
        return flag;

    }

    private Player createPlayer() {
        messages.showMessage("Ingrese su nombre: ");
        String username = scanner.getString();
        return new Player(username);
    }

    private Boolean validateResponse(String response, String correctAnswer) {
        return response.equals(correctAnswer);
    }

    private void saveGame(Player player, ArrayList<Question> questions, Integer score) {
        Game game = new Game(player, questions, score);

        dataAccess.setGame(game);
    }

    static ArrayList<Question> getQuestions() {

        String ans[] = { "resp1", "resp2", "resp3" };
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

        return questions;
    }

}
