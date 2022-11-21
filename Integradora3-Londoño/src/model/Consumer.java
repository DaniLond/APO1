/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author DANIELA LONDOÑO
 */
public class Consumer extends User {

    private ArrayList<Audio> audioHistory;
    private ArrayList<Shop> shopping;

    public Consumer(String nickName, String id, LocalDate date) {
        super(nickName, id, date);
        this.audioHistory = new ArrayList<Audio>();
        this.shopping = new ArrayList<Shop>();
    }

    public ArrayList<Audio> getAudioHistory() {
        return audioHistory;
    }

    public ArrayList<Shop> getShopping() {
        return shopping;
    }

    public String mostGenreUser() {
        Genre genre = null;
        int veces = 0;
        int contador = 0;
        for (int i = 0; i < this.audioHistory.size(); i++) {
            if (this.audioHistory.get(i) instanceof Song) {
                contador = 0;
                for (int j = 0; j < this.audioHistory.size(); j++) {
                    if (this.audioHistory.get(j) instanceof Song) {
                        if (i != j && ((Song) this.audioHistory.get(i)).getGener().equals(((Song)this.audioHistory.get(j)).getGener())) {
                            contador++;
                        } 
                    }
                }
                if (contador > veces) {
                    genre = ((Song)this.audioHistory.get(i)).getGener();
                    veces= contador;
                }
            }
        }
        return "The most repeated genre of the user " + this.getNickName() + " is: " + genre.name() + " with " + (veces + 1) + " reproductions";
    }
    
    
    public String mostCategoryUser() {
        Category category = null;
        int veces = 0;
        int contador = 0;
        for (int i = 0; i < this.audioHistory.size(); i++) {
            if (this.audioHistory.get(i) instanceof Podcast) {
                contador = 0;
                for (int j = 0; j < this.audioHistory.size(); j++) {
                    if (this.audioHistory.get(j) instanceof Podcast) {
                        if (i != j && ((Podcast) this.audioHistory.get(i)).getCategory().equals(((Podcast)this.audioHistory.get(j)).getCategory())) {
                            contador++;
                        } 
                    }
                }
                if (contador > veces) {
                    category = ((Podcast)this.audioHistory.get(i)).getCategory();
                    veces= contador;
                }
            }
        }
        return "The most repeated category of the user " + this.getNickName() + " is: " + category.name() + " with " + (veces + 1) + " reproductions";
    }
}
