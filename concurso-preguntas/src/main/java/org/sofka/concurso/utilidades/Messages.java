package com.sofka.taller.utilidades;

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


}