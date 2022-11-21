/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Timer;

/**
 *
 * @author DANIELA LONDOÑO
 */
public class Song extends Audio {

    private String album;
    private double valueSale;
    private int numTimeSold;
    private Genre gener;
   
    
    public Song(String album, double valueSale, int gener, String name, String url, double duration) {
        super(name, url, duration);
        this.album = album;
        this.valueSale = valueSale;
        this.numTimeSold = 0;
        this.gener = Genre.values()[gener];
  
    }



    public void setAlbum(String album) {
        this.album = album;
    }

    public void setValueSale(double valueSale) {
        this.valueSale = valueSale;
    }

    public void setNumTimeSold(int numTimeSold) {
        this.numTimeSold = numTimeSold;
    }

    public void setGener(Genre gener) {
        this.gener = gener;
    }

    public String getAlbum() {
        return album;
    }

    public double getValueSale() {
        return valueSale;
    }

    public int getNumTimeSold() {
        return numTimeSold;
    }

    public Genre getGener() {
        return gener;
    }

}
