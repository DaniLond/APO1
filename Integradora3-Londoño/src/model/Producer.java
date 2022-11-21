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
public class Producer extends User {
    private String url;
    private int numberReproductions;
    private double playedTime;

    public Producer(String url, String nickName, String id, LocalDate date) {
        super(nickName, id, date);
        this.url = url;
        this.numberReproductions = 0;
        this.playedTime = 0;
    }

    public void setNumberReproductions(int numberReproductions) {
        this.numberReproductions = numberReproductions;
    }

    public void setPlayedTime(double playedTime) {
        this.playedTime = playedTime;
    }

    public int getNumberReproductions() {
        return numberReproductions;
    }

    public double getPlayedTime() {
        return playedTime;
    }

    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }
 
}
