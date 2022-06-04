package org.sofka.concurso.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.sofka.concurso.domain.Game;

public class xxx {

    static String NOMBRE_RECURSO = "games.txt";

    public static void agregarGame(Game game) {
        boolean anexar = false;
        try {
            anexar = existe(NOMBRE_RECURSO);
            escribir(game, NOMBRE_RECURSO, anexar);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


    public static boolean existe(String nombreRecurso) {
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }
    
    public static void escribir(Game game, String nombreRecurso, boolean anexar) {
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(game);
            salida.close();
            System.out.println("Se ha escrito información al archivo: " + game.getPlayer().getUsername()+ " ");
        } catch (Exception ex) {
            System.out.println("Excepción al escribir games: " + ex.getMessage());
        }
    }
}
