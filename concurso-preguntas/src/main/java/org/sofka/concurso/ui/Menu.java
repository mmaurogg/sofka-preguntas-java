package org.sofka.concurso.ui;

import org.sofka.concurso.utilities.Messages;
import org.sofka.concurso.utilities.MyException;
import org.sofka.concurso.utilities.MyScanner;

import java.util.ArrayList;

import org.sofka.concurso.domain.Game;
import org.sofka.concurso.domain.Player;
import org.sofka.concurso.domain.Question;



import org.jboss.logging.Logger;


public class Menu {


    private static final Logger logger = Logger.getLogger(Messages.class);

    static Messages messages = Messages.getInstance();
    static MyScanner scanner = MyScanner.getInstance();

    public static Menu getInstance() {
        return new Menu();
    }

    public void menu(){
    
        Boolean flag = true;
        messages.showWelcome();

        while (Boolean.TRUE.equals(flag)) {
            try {
                messages.showStartOptions();
                flag = selectOption(scanner.getInteger());
            } catch (MyException myException) {
                messages.showMessage(myException.getMessage());
                messages.pressAnyKeyToContinue();
            }
        }
    }
    
    private static Boolean selectOption(Integer option) {
        switch (option) {
            case 1:
                Player player = createPlayer();
                createGame(player);
                break;
            case 2:
                //TODO: crear menu ranking 
                break;
            case 0:
                messages.showGoodBye();
                return false;
                
            default:
                messages.showIncorrectChoise();
                messages.pressAnyKeyToContinue();

        }
        return true;
    }

    private static Player createPlayer(){
        messages.showMessage("Ingrese su nombre: ");
        String username = scanner.getString();
        Player player = new Player(username);
        return player;

    }

    private static void createGame(Player player){
        Game game = new Game(player, questions());
        
        messages.showMessage("Comencemos");
        
        ArrayList<Question> preguntas = questions();
        
        for(Question pregunta : preguntas){
            messages.showMessage(pregunta.getStatement());

            System.out.println("Seleccione la respuesta correcta");

            for (int i = 0; i < pregunta.getAnswer().length; i++) {
                String respuesta = pregunta.getAnswer()[i];
                System.out.println((i+1) + " " + respuesta);

            }

            int seleccion = scanner.getInteger();

            if(seleccion == 1){
                System.out.println("correcto");
            } else {
                System.out.println("incorrecto");
            }
            
        }

    }



    static ArrayList<Question> questions(){

        String ans[] = {"resp1","resp2","resp3","resp4"};
        Question question1 = new Question(1, "pregunta1", ans);
        Question question2 = new Question(2, "pregunta2", ans);
        Question question3 = new Question(3, "pregunta3", ans);
        Question question4 = new Question(4, "pregunta4", ans);
        Question question5 = new Question(5, "pregunta5", ans);
    
        ArrayList<Question> questions = new ArrayList<>(); 
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);

        return questions;
    }


}


