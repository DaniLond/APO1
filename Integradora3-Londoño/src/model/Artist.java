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
public class Artist extends Producer {
    private ArrayList<Song> songs;

    public Artist(String url, String nickName, String id, LocalDate date) {
        super(url, nickName, id, date);
        this.songs = new ArrayList<Song>();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
    
}
