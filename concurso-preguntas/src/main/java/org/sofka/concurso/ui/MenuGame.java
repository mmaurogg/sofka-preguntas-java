package org.sofka.concurso.ui;

import org.sofka.concurso.utilities.Messages;
import org.sofka.concurso.utilities.MyScanner;
import org.sofka.concurso.utilities.DataAccess;

import java.util.ArrayList;
import java.util.Collections;

import org.sofka.concurso.domain.Game;
import org.sofka.concurso.domain.Player;
import org.sofka.concurso.domain.Question;

/**
 * Menu representa el menú de opciones del juego
 *
 * @author Mauricio Gómez - mmaurogg@gmail.com
 * @author Óscar Farfán - oscarfarfan92@gmail.com
 *
 * @version 1.0.0.000 3-06-2022
 */
public class MenuGame {

    static Messages messages = Messages.getInstance();
    static MyScanner scanner = MyScanner.getInstance();
    static DataAccess dataAccess = DataAccess.getInstance();

    /**
     * Muestra al jugador las preguntas y valida si la respuesta ingresada por el jugador es correcta
     *
     * @return devuelve verdadero o falso dependiendo si la respuesta ingresada por el jugador es correcta
     */
    public static Boolean createGame(){
        
        Boolean flag = true;
        Integer score = 0;
        
        Player player = createPlayer();
        ArrayList<Question> questions = getQuestions();
        
        messages.showMessage("Comencemos");
                
        for(Question question : questions){
            messages.showMessage(question.getStatement());

            System.out.println("Seleccione la respuesta correcta");

            ArrayList<String> options = new ArrayList<>();

            for (int i = 0; i < question.getoptions().length; i++) {
                String option = question.getoptions()[i];
                options.add(option);
            }
            options.add(question.getAnswer());

            Collections.shuffle(options);

            System.out.println(options);

            int selection = scanner.getInteger();

            // Validar respuesta
            flag = validateResponse(options.get(selection - 1), question.getAnswer());
            
            if(!flag){
                score = 0;
                System.out.println("perdió el juego, su puntuación es: " + score);
                saveGame(player, questions, score);
                return flag;
            }

            System.out.println("es correcto");

            score++;

            if(score != 5){
                            System.err.println("su puentiación es: "+score+" ¿Desea reclamar su premio? (y/n)");
            String reward = scanner.getString();
            if(reward.equalsIgnoreCase("y")){
                System.out.println("Ganaste: " + score + " puntos");
                saveGame(player, questions, score);
                return flag;
            }
            }


        }

        System.out.println("Ha ganado el premio mayor, su puntuación "+score);
        saveGame(player, questions, score);
        return flag;

    }

    /**
     * Solicita el nombre del jugador y crea el objeto jugador
     *
     * @return devuelve la instancia del jugador
     */
    private static Player createPlayer(){
        messages.showMessage("Ingrese su nombre: ");
        String username = scanner.getString();
        
        return new Player(username);

    }

    /**
     * Valida la respuesta del usuario
     *
     * @param response respuesta ingresada por el usuario
     * @param correctAnswer respuesta coreecta de la pregunta
     * @return devuelve verdadero si la respuesta es correcta y falso si es incorrecta
     */
    private static Boolean validateResponse(String response, String correctAnswer){
        return response.equals(correctAnswer); 
    }

    /**
     * Guarda el jugador y el puntaje en un archivo de texto llamado games.txt
     *
     * @param player jugador que se va a guardar
     * @param questions preguntas del juego
     * @param score puntaje del jugador
     */
    private static void saveGame(Player player, ArrayList<Question> questions, Integer score){
        Game game = new Game(player, questions, score);

        dataAccess.setGame(game);
    }

    /**
     * Retornma las preguntas del juego
     *
     * @return devuelve las preguntas del juego
     */
    static ArrayList<Question> getQuestions(){

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

        return questions;
    }

}
