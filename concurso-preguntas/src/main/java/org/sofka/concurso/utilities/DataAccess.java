package org.sofka.concurso.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.sofka.concurso.domain.Game;

public class DataAccess {

    public static DataAccess getInstance(){
        return new DataAccess();
    }

    static Messages messages = Messages.getInstance();

    static String NAME_FILE = "games.txt";

    public void setGame(Game game) {
        boolean add = false;
        try {
            add = inPlace(NAME_FILE);
            write(game, NAME_FILE, add);
        } catch (Exception ex) {
            messages.showMessage(ex.getMessage());
        }
    }


    private static boolean inPlace(String nombreRecurso) {
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }
    
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
