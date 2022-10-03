package model;

/**
 *
 * @author USUARIO
 */
public class Enemy {
    private String name;
    private TypeEnemy type;
    private int subtractionScore;
    private int additionScore;
    private int positionX;
    private int positionY;

    public Enemy(String name, int type, int subtractionScore , int additionScore) {
        this.name = name;
        this.type = TypeEnemy.values()[type];
        this.subtractionScore = subtractionScore;
        this.additionScore= additionScore;
        this.positionX = 0;
        this.positionY= 0;
    }

    public void setAdditionScore(int additionScore) {
        this.additionScore = additionScore;
    }

    public int getAdditionScore() {
        return additionScore;
    }

    public String getName() {
        return name;
    }

    public TypeEnemy getType() {
        return type;
    }

    public int getSubtractionScore() {
        return subtractionScore;
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

    public void setType(TypeEnemy type) {
        this.type = type;
    }

    public void setSubtractionScore(int subtractionScore) {
        this.subtractionScore = subtractionScore;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
 

    @Override
    public String toString() {
        return "\nname=" + name + "\ntype=" + type + "\nsubtractionScore=" + subtractionScore + "\npositionX=" + positionX + "\npositionY=" + positionY;
    }
           
}
