package model;

/**
 *
 * @author USUARIO
 */
public class Player {
    private String nickname;
    private String name;
    private int initialScore;
    private int numberLive;
    private Level level;

    public Player(String nickname, String name) {
        this.nickname = nickname;
        this.name = name;
        this.initialScore = 10;
        this.numberLive = 5; 
        this.level= null;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public int getInitialScore() {
        return initialScore;
    }

    public int getNumberLive() {
        return numberLive;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean setInitialScore(int initialScore) {
        this.initialScore = initialScore;
        return true;
    }

    public void setNumberLive(int numberLive) {
        this.numberLive = numberLive;
    }
    

    @Override
    public String toString() {
        return 
               "\nnickname=" + nickname +
                "\nname=" + name + 
                "\ninitialScore=" + initialScore +
                "\nnumberLive=" + numberLive;
    }
       
}