package org.sofka.concurso.utilities;

import org.jboss.logging.Logger;

/** 
 * Esta clase define todos los mensajes que se mostrarán en la app
 * @author Mauricio Gómez
 * @version 1.0.0
*/
public class Messages {
    
    private static final Logger logger = Logger.getLogger(Messages.class);

    /**
     * Método para instanciar la clase Messages
     * @return new Messages();
     */
    public static Messages getInstance(){
        return new Messages();
    }

    /**
     * Método para imprimir una cadena de String que reciba
     */
    public void showMessage(String message) {
        logger.info(message);
    }

    /**
     * Método para imprimir en consola mensaje de bienvenida
     */
    public void showWelcome() {
        logger.info("¡BIENVENIDO AL GRAN CONCURSO DE PREGUNTAS MILLONARIAS!!");
    }

    /**
     * Método para imprimir en consola mensaje de bienvenida
     */
    public void showStartOptions() {
        logger.info("Digite una opción:\n1. jugar\n2. Ver ranking\n0. Salir");
    }

    /**
     * Método para imprimir mensaje presione tecla para continuar
     */
    public void pressAnyKeyToContinue() {
        logger.info("Presione cualquier tecla para continuar");
        try {
            System.in.read();
        } catch (Exception exception) {
            throw new MyException(exception.getMessage(), exception);
        }
    }

        /**
     * Método para imprimir en consola error de mensaje mensaje
     */
    public void showIncorrectChoise() {
        logger.info("La opcion ingresada no es correcta");
    }


    /**
     * Método para imprimir en consola mensaje de despedida
     */
    public void showGoodBye() {
        logger.info("Felicitaciones por su participación");
    }

}