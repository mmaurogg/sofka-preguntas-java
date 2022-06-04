package org.sofka.concurso.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.sofka.concurso.domain.Game;

public class DataAccess {

    public static DataAccess getInstance(){
        return new DataAccess();
    }

    static Messages messages = Messages.getInstance();

    static String NAME_FILE = "games.txt";

    public void setGame(Game game) {
        Boolean add = false;
        try {
            add = inPlace(NAME_FILE);
            write(game, NAME_FILE, add);
        } catch (Exception ex) {
            messages.showMessage(ex.getMessage());
        }
    }

    public void getGames() {
        ArrayList<String> games = new ArrayList<>();
        try {
            games = list(NAME_FILE);
            for(String game: games){
                messages.showMessage("game = " + game);
            }
        } catch (Exception ex) {
            messages.showMessage("Error de acceso a datos");
        }
    }

    private boolean inPlace(String nombreRecurso) {
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }
    
    private void write(Game game, String nombreRecurso, boolean add) {
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, add));
            salida.println(game);
            salida.close();
            messages.showMessage("Se ha escrito información al archivo: " + game.getPlayer().getUsername());
        } catch (IOException ex) {
            messages.showMessage("Excepción al write games: " + ex.getMessage());
        }
    }

    private ArrayList<String> list(String nombreRecurso) throws IOException{
        File archivo = new File(nombreRecurso);
        ArrayList<String> games = new ArrayList<>();
        try {
            BufferedReader entry = new BufferedReader(new FileReader(archivo));
            String line = null;
            line = entry.readLine();
            while (line != null) {
                String l = line;
                games.add(l);
                line = entry.readLine();
            }
            entry.close();
        } catch (Exception ex) {
            messages.showMessage(ex.getMessage());
        }
        return games;
    }
}
