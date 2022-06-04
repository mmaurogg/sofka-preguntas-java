package org.sofka.concurso.ui;

import org.sofka.concurso.utilities.DataAccess;
import org.sofka.concurso.utilities.Messages;
import org.sofka.concurso.utilities.MyException;
import org.sofka.concurso.utilities.MyScanner;

/**
 * Menu representa el menú de opciones del juego
 *
 * @author Mauricio Gómez - mmaurogg@gmail.com
 * @author Óscar Farfán - oscarfarfan92@gmail.com
 *
 * @version 1.0.0.000 3-06-2022
 */
public class Menu {

    static Messages messages = Messages.getInstance();
    static MyScanner scanner = MyScanner.getInstance();
    static MenuGame menuGame = MenuGame.getInstance();

    /**
     * Retorna una nueva instancia de la clase Menu
     *
     * @return devuelve una nueva instancia de la clase Menu
     */
    public static Menu getInstance() {
        return new Menu();
    }

    /**
     * Inicializa el juego mostrando el mensaje de bienvenida y el menú inicial de opciones
     */
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

    /**
     * Evalua la opción ingresada por el jugador y de acuerdo a esto le muestra la información
     *
     * @param option recibe la opción elegida por el jugador
     * @return devuelve verdadero o falso dependiendo si el jugador quiere continuar o salir del juego
     */
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


