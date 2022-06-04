package org.sofka.concurso.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.sofka.concurso.domain.Game;

/**
 * Acceso a Datos se crea para acceder al archivo games.txt
 *
 * @author Mauricio Gómez - mmaurogg@gmail.com
 * @author Óscar Farfán - oscarfarfan92@gmail.com
 *
 * @version 1.0.0.000 3-06-2022
 */
public class DataAccess {

    /**
     * Retorna la instancia del objeto
     *
     * @return devuelve la instancia del objeto
     */
    public static DataAccess getInstance(){
        return new DataAccess();
    }

    static Messages messages = Messages.getInstance();

    static String NAME_FILE = "games.txt";

    /**
     * Inserta información al archivo txt
     *
     * @param game recibe el juego
     */
    public void setGame(Game game) {
        boolean add = false;
        try {
            add = inPlace(NAME_FILE);
            write(game, NAME_FILE, add);
        } catch (Exception ex) {
            messages.showMessage(ex.getMessage());
        }
    }

    /**
     * Valida si el archivo txt existe
     *
     * @param nombreRecurso recibe el nombre del archivo txt
     * @return devuelve verdadero si el archivo existe, sino devuelve falso
     */
    private static boolean inPlace(String nombreRecurso) {
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    /**
     * Escribe información en el archivo txt
     *
     * @param game recibe el juego
     * @param nombreRecurso recibe el nombre del recurso
     * @param add recibe la existencia del archivo
     */
    private static void write(Game game, String nombreRecurso, boolean add) {
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, add));
            salida.println(game);
            salida.close();
            messages.showMessage("Se ha escrito información al archivo: " + game.getPlayer().getUsername()+ " ");
        } catch (IOException ex) {
            messages.showMessage("Excepción al write games: " + ex.getMessage());
        }
    }
}
