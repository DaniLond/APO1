/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DANIELA LONDOÑO
 */
public abstract class Audio {
    private String name;
    private String url;
    private double duracion;
    private int numPlays;

    public Audio(String name, String url, double duracion) {
        this.name = name;
        this.url = url;
        this.duracion = duracion;
        this.numPlays = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public void setNumPlays(int numPlays) {
        this.numPlays = numPlays;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public double getDuracion() {
        return duracion;
    }

    public int getNumPlays() {
        return numPlays;
    }
    
}
