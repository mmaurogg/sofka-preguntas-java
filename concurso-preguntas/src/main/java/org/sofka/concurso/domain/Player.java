package org.sofka.concurso.domain;

/**
 * Player representará a un jugador
 *
 * @author Mauricio Gómez - mmaurogg@gmail.com
 * @author Óscar Farfán - oscarfarfan92@gmail.com
 *
 * @version 1.0.0.000 3-06-2022
 */
public class Player {

    private String username;
    private Integer score;

    /**
     * Crea a un jugador que recibe como parámetros el nombre
     * @param username nombre del jugador
     */
    public Player(String username){
        this.username = username;
    }

    /**
     * Retorna el nombre del usuario
     *
     * @return devuelve el nombre del jugador
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Retorna el puntaje del jugador
     *
     * @return devuelve el puntaje del jugador
     */
    public Integer getScore() {
        return this.score;
    }

    /**
     * Modifica el puntaje del usuario
     *
     * @param score recibe el nuevo puntaje a asignar al usuario
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * Retorna los datos del jugador
     *
     * @return devuelve los datos del jugador
     */
    public String toString(){
        return "Juagador: " + this.username;
    }
}
