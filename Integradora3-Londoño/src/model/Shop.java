/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author DANIELA LONDOÑO
 */
public class Shop {
    private LocalDate date;
    private Song song;

    public Shop(LocalDate date, Song song) {
        this.date = date;
        this.song = song;
    }

    public LocalDate getDate() {
        return date;
    }

    public Song getSong() {
        return song;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSong(Song song) {
        this.song = song;
    }
    
    
}
