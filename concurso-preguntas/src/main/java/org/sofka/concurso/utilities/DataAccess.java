package org.sofka.concurso.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
        Boolean add = false;
        try {
            add = inPlace(NAME_FILE);
            write(game, NAME_FILE, add);
        } catch (Exception ex) {
            messages.showMessage(ex.getMessage());
        }
    }

    /**
     * obtiene los datos de la persistencia de datos
     */
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

    /**
     * Valida si el archivo txt existe
     *
     * @param resource recibe el nombre del archivo txt
     * @return devuelve verdadero si el archivo existe, sino devuelve falso
     */
    private boolean inPlace(String resource) {
        File archivo = new File(resource);
        return archivo.exists();
    }
    
    /**
     * Escribe información en el archivo txt
     *
     * @param game recibe el juego
     * @param resource recibe el nombre del recurso
     * @param add recibe la existencia del archivo
     */
    private void write(Game game, String resource, boolean add) {
        File archivo = new File(resource);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, add));
            salida.println(game);
            salida.close();
            messages.showMessage("Se ha escrito información al archivo: " + game.getPlayer().getUsername());
        } catch (IOException ex) {
            messages.showMessage("Excepción al write games: " + ex.getMessage());
        }
    }

    /**
     * Lista los elementos del archivo de persistencia de datos en el archivo de texto
     * @param resource el nombre del archivo de texto donde se encuentran los datos
     * @return lista de juegos del archivo de texto o persistencia de datos
     * @throws IOException excepciones en la ejecucion del código
     */
    private ArrayList<String> list(String resource) throws IOException{
        File archivo = new File(resource);
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
