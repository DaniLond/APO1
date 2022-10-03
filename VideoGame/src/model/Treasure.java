package model;

/**
 *
 * @author USUARIO
 */
public class Treasure {
    private String name;
    private String URL;
    private int score;
    private double positionX;
    private double positionY;

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

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
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

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return "\nname=" + name + "\nURL=" + URL + "\nscore=" + score + "\npositionX=" + positionX + "\npositionY=" + positionY ;
    }
    
    
}