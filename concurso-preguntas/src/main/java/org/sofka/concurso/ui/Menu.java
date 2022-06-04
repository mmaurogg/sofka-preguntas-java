package org.sofka.concurso.ui;

import org.sofka.concurso.utilities.DataAccess;
import org.sofka.concurso.utilities.Messages;
import org.sofka.concurso.utilities.MyException;
import org.sofka.concurso.utilities.MyScanner;

public class Menu {

    static Messages messages = Messages.getInstance();
    static MyScanner scanner = MyScanner.getInstance();
    static MenuGame menuGame = MenuGame.getInstance();

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
                messages.showIncorrectChoise();
            }
        }
    }
    
    private static Boolean selectOption(Integer option) {
        switch (option) {
            case 1:
                MenuGame.getInstance().createGame();
                break;
            case 2:
                DataAccess.getInstance().getGames();
                break;
            case 0:
                messages.showGoodBye();
                return false;
                
            default:
                messages.showIncorrectChoise();

        }
        return true;
    }

}


