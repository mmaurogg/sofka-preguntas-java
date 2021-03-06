package org.sofka.concurso.utilities;

import org.jboss.logging.Logger;

/** 
 * Esta clase define todos los mensajes que se mostrarán en la app
 * @author Mauricio Gómez - mmaurogg@gmail.com
 * @author Óscar Farfán - oscarfarfan92@gmail.com
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
        logger.info("Digite una opción:\n1. Jugar\n2. Ver historial de juegos\n0. Salir");
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