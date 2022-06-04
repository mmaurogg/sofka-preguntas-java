package org.sofka.concurso.ui;

import org.sofka.concurso.utilities.Messages;
import org.sofka.concurso.utilities.MyScanner;
import org.sofka.concurso.utilities.DataAccess;

import java.util.ArrayList;
import java.util.Collections;

import org.sofka.concurso.data.QuestionsGame;
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
        Game game = new Game(player, questions);

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
                messages.showMessage((i+1) + ". " + option);
            }

            int selection = scanner.getInteger();

            // Validar respuesta
            flag = validateResponse(options.get(selection - 1), question.getAnswer());

            if (!flag) {
                score = 0;
                messages.showMessage("perdió el juego, su puntuación es: " + score);
                saveGame(player, game, score);
                return flag;
            }

            messages.showMessage("es correcto");

            score++;

            if (score != 5) {
                messages.showMessage("su puentiación es: " + score + " ¿Desea reclamar su premio? (y/n)");
                String reward = scanner.getString();

                if (reward.equalsIgnoreCase("y")) {
                    messages.showMessage("Ganaste: " + score + " puntos");
                    saveGame(player, game, score);
                    return flag;
                }
            }
        }

        messages.showMessage("Ha ganado el premio mayor, su puntuación " + score);
        saveGame(player, game, score);
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

    private void saveGame( Player player, Game game, Integer score) {
        player.setScore(score);
        game.setScore(score);
        
        messages.showMessage("Juego guardado correctamente");
    
    }

    private static ArrayList<Question> getQuestions() {

        final int NUMBER_QUESTION = 5;
        ArrayList<Question> questions = new ArrayList<>();
        
        for (int i = 1; i < (NUMBER_QUESTION + 1); i++) {
            Question question = aleatoryQuestion(filtterArray(QuestionsGame.Questions(), i));
            questions.add(question);
        }
        
        return questions;
    };

    /**
     * Función para seleccionar una pregunta aleatoriamente entre un set de preguntas
     * @param questions arrPreguntas set de preguntas a elegir
     * @return pregunta elegida aleatoriamente
     */
    private static Question aleatoryQuestion(ArrayList<Question> questions){
        int aleatoryIndex = (int) Math.floor(Math.random() * questions.size());
        return questions.get(aleatoryIndex);
    };
    
    /**
     * Función para filtrar un set de preguntas por su nivel de dificultad
     * @param arr arreglo de preguntas con diferentes niveles de difucultad o categorías
     * @param dificultad es el nivel de dificultado o categoria por la que se quieren filtrar las preguntas
     * @returns arreglo con preguntas del mismo nivel de dificultad o categoría
     */
    private static ArrayList<Question> filtterArray ( ArrayList<Question> questions, int difficulty) {
        ArrayList<Question> arrayQuestions = new ArrayList<>();
    
        for (Question question : questions) {
            if (difficulty == question.getDifficulty()) {
                arrayQuestions.add(question);
            }
        }
        return arrayQuestions;
    }
}
