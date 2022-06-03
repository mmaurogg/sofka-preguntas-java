package org.sofka.concurso.ui;

import org.sofka.concurso.utilities.Messages;
import org.sofka.concurso.utilities.MyException;
import org.sofka.concurso.utilities.MyScanner;

import java.util.ArrayList;
import java.util.Collections;

import org.sofka.concurso.domain.Game;
import org.sofka.concurso.domain.Player;
import org.sofka.concurso.domain.Question;

public class MenuGame {

    static Messages messages = Messages.getInstance();
    static MyScanner scanner = MyScanner.getInstance();

    public static Boolean createGame(){
        
        Player player = createPlayer();

        Boolean flag = true;
        ArrayList<Question> questions = questions();
        
        Game game = new Game(player, questions);

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

            int seleccion = scanner.getInteger();

            // Validar respuesta
            flag = validateResponse(options.get(seleccion - 1), question.getAnswer());
            
            if(!flag){
                System.out.println("perdió el juego");
                return flag;
            }

        }

        return flag;

    }

    private static Player createPlayer(){
        messages.showMessage("Ingrese su nombre: ");
        String username = scanner.getString();
        Player player = new Player(username);
        return player;

    }

    static Boolean validateResponse(String response, String correctAnswer){
        return response.equals(correctAnswer); 
    }

    static ArrayList<Question> questions(){

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
