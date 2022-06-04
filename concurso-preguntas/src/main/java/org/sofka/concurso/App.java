package org.sofka.concurso;

import org.sofka.concurso.ui.Menu;

/**
 * Clase que ejecuta el programa
 *
 * @author Mauricio Gómez - mmaurogg@gmail.com
 * @author Óscar Farfán - oscarfarfan92@gmail.com
 *
 * @version 1.0.0.000 28-05-2022
 */
public class App {

    static Menu menu = Menu.getInstance();


    public static void main( String[] args )
    {
        menu.menu();
    }



}




