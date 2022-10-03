package model;

/**
 *
 * @author USUARIO
 */
public class Level {
    private int numberID;
    private int scoreLevel;
    private Treasure[] treasures;
    private Enemy[] enemies;
    private LevelComplexity levelComplexity;


    public Level(int numberID) {
        this.numberID = numberID;
        this.scoreLevel = 0;
        this.treasures = new Treasure[5];
        this.enemies = new Enemy[4];
        this.levelComplexity= null;
    }

    public LevelComplexity getLevelComplexity() {
        return levelComplexity;
    }

    public void setLevelComplexity(LevelComplexity levelComplexity) {
        this.levelComplexity = levelComplexity;
    }
    
    
    public int getNumberID() {
        return numberID;
    }
    
    public int getScoreLevel() {
        return scoreLevel;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public void setNumberID(int numberID) {
        this.numberID = numberID;
    }

    public void setScoreLevel(int scoreLevel) {
        this.scoreLevel = scoreLevel;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    public void setEnemies(Enemy[] enemies) {
        this.enemies = enemies;
    }
    
    /**
     * Descripcion: Allows you to add a treasure to the list of treasures
     * @param treasure Treasure
     * @return boolean
     */
    public boolean addTreasure(Treasure treasure){
        for(int i= 0 ; i < this.treasures.length ; i++){
            if(this.treasures[i] == null){
                this.treasures[i]= treasure;
                    return true;                    
                }
            }
            return false;
    }
    
    /**
     * Descripcion: Allow you to add a enemy to the list of enemies
     * @param enemy Enemy
     * @return boolean
     */
    public boolean addEnemy(Enemy enemy){
        for(int i= 0 ; i < this.enemies.length ; i++){
            if(this.enemies[i] == null){
                this.enemies[i]= enemy;
                    return true;                    
                }
            }
            return false;
    }
    
    /**
     * Descripcion: Show the treasure that are in the list of Treasures
     * @return treasure String
     */
    public String showTreasure(){
        String treasure= "";
        for(int i =0; i < this.treasures.length; i++){
            if(this.treasures[i] != null){
                treasure += this.treasures[i].toString();
            }
        }
        return treasure;
    }
    
    /**
     * Descripcion: Show enemy that are in the list of enemies
     * @return enemy String
     */
    public String showEnemy(){
        String enemy= "";
        for(int i =0; i < this.enemies.length; i++){
            if(this.enemies[i] != null){
                enemy += "Treasure N° " + i + this.enemies[i].toString();
            }
        }
        return enemy;
    }

    @Override
    public String toString() {
        return "\nLevel" + "\nnumberID=" + numberID + "\nscoreLevel=" + scoreLevel + "\ntreasures=";
    }
    
}