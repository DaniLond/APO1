/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DANIELA LONDOÑO
 */
public class Treasure {
    private String name;
    private String URL;
    private int score;
    private int positionX;
    private int positionY;

    public Treasure(String name, String URL, int score) {
        this.name = name;
        this.URL = URL;
        this.score = score;
        this.positionX = 0;
        this.positionY = 0;
    }

    public String getName() {
        return name;
    }

    public String getURL() {
        return URL;
    }

    public int getScore() {
        return score;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return "\nname=" + name + "\nURL=" + URL + "\nscore=" + score + "\npositionX=" + positionX + "\npositionY=" + positionY ;
    }    
}
