package com.sofka.taller.utilidades;

/** 
 * Esta clase existe para capturar las excepcions y darles formato
 * @author Mauricio Gómez
 * @version 1.0.0
*/
public class MyException extends RuntimeException {

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Exception exception) {
        super(message, exception);
    }

}