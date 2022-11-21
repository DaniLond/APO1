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
public class Creator extends Producer {
    private ArrayList<Podcast> poscasts;

    public Creator(String url, String nickName, String id, LocalDate date) {
        super(url, nickName, id, date);
        this.poscasts = new ArrayList<Podcast>();
    }

    public ArrayList<Podcast> getPoscasts() {
        return poscasts;
    }

    public void setPoscasts(ArrayList<Podcast> poscasts) {
        this.poscasts = poscasts;
    }
    
}
