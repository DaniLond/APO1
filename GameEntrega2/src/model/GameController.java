/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Random;

/**
 *
 * @author DANIELA LONDOÑO
 */
public class GameController {

    private Level[] levels;
    private Player[] players;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private int positionHDX;
    private int positionHDY;
    static Random random = new Random();

    public GameController() {
        this.levels = new Level[10];
        this.players = new Player[20];
        this.treasures = new Treasure[50];
        this.enemies = new Enemy[25];
        this.positionHDX = 1280;
        this.positionHDY = 720;
    }

    public Level[] getLevels() {
        return levels;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public int getPositionHDX() {
        return positionHDX;
    }

    public int getPositionHDY() {
        return positionHDY;
    }

    /**
     * Show the type enemies that are registered
     *
     * @return type String
     */
    public String toStringEnemy() {
        TypeEnemy typeEnemy[] = TypeEnemy.values();
        String type = "Type of enemies";
        for (int i = 0; i < typeEnemy.length; i++) {
            type += "\n" + i + ")" + typeEnemy[i];
        }
        return type;
    }

    /**
     * Descripcion: Register a new level in the list of levels
     *
     * @param id int
     * @return level Level
     */
    public Level registerLevel(int id) {
        Level level = new Level(id);
        if (this.levels[id] == null) {
            this.levels[id] = level;
        }
        return level;
    }

    /**
     * Descripcion: Verify that the nickname is not already resgistered is not
     * already registered
     *
     * @param nickname String
     * @return boolean
     */
    public boolean comparePlayer(String nickname) {
        for (int i = 0; i < this.players.length; i++) {
            if (this.players[i] != null) {
                if (this.players[i].getNickname().equals(nickname)) {
                    i = players.length;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Descripcion: Register a new player in the list of players and initializes
     * the player's level to 0
     *
     * @param nickname String
     * @param name String 
     * @return boolean
     */
    public boolean registerPlayer(String nickname, String name) {
        Player player = new Player(nickname, name);
        player.setLevel(this.levels[0]);
        for (int i = 0; i < this.players.length; i++) {
            if (this.players[i] == null) {
                this.players[i] = player;
                return true;
            }
        }
        return false;
    }

    /**
     * Descripcion: Register a new enemy in the list of players and assigns you
     * the required position
     *
     * @param name String
     * @param type int
     * @param subtractionScore int
     * @param additionScore int
     * @return boolean
     */
    public boolean registerEnemy(String name, int type, int subtractionScore, int additionScore) {
        Enemy enemy = new Enemy(name, type, subtractionScore, additionScore);
        enemy.setPositionX(random.nextInt(positionHDX));
        enemy.setPositionY(random.nextInt(positionHDY));
        for (int i = 0; i < this.enemies.length; i++) {
            if (this.enemies[i] == null) {
                this.enemies[i] = enemy;
                return true;
            }
        }
        return false;
    }

    /**
     * Add a enemy to a level and verify that the enemy is not already
     * registered
     *
     * @param enemyID int
     * @param levelID int
     * @return boolean
     */
    public boolean addEnemyToLevel(int enemyID, int levelID) {
        for (int i = 0; i < this.levels.length; i++) {
            for (int j = 0; j < this.enemies.length; j++) {
                for (int m = 0; m < this.levels[levelID].getEnemies().length; m++) {
                    if (this.levels[levelID].getEnemies()[m] != null) {
                        if (!(this.levels[levelID].getEnemies()[m].equals(this.enemies[enemyID]))) {
                            this.levels[levelID].addEnemy(enemies[enemyID]);
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        this.levels[levelID].addEnemy(enemies[enemyID]);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Descripcion: Show the enemys that are registered in the list of enemies
     *
     * @return enemy String
     */
    public String showEnemy() {

        String enemy = "";
        for (int i = 0; i < this.enemies.length; i++) {
            if (this.enemies[i] != null) {
                enemy += "Enemy N° " + i + this.enemies[i].toString() + "\n";
            }
        }
        return enemy;
    }

    /**
     * Descrpcion: Show the level that are registered in the list of levels
     *
     * @return boolean
     */
    public String showLevel() {

        String level = "";
        for (int i = 0; i < this.levels.length; i++) {
            if (this.levels[i] != null) {
                level += "Level N°" + i + this.levels[i].toString() + "\n";
            }
        }
        return level;
    }

    /**
     * Descrpcion: Register a new treasure in the list of treasures and assigns
     * you the required position
     *
     * @param name String
     * @param URL String
     * @param score int 
     * @return boolean
     */
    public boolean registerTreasure(String name, String URL, int score) {
        Treasure treasure = new Treasure(name, URL, score);
        treasure.setPositionX(random.nextInt(positionHDX));
        treasure.setPositionY(random.nextInt(positionHDY));
        for (int i = 0; i < this.treasures.length; i++) {
            if (this.treasures[i] == null) {
                this.treasures[i] = treasure;
                return true;
            }
        }
        return false;
    }
    
    /**
     *  Descripcion: Check the level a player is at
     * @param indexPlayer int
     * @return Level
     */
    public Level consultLevelOfPlayer( int indexPlayer){
        return this.players[indexPlayer].getLevel();
    }

    /**
     * Descrpcion: Show the treasure that are registered in the list of
     * treasures
     *
     * @return boolean
     */
    public String showTreasure() {

        String treasure = "";
        for (int i = 0; i < this.treasures.length; i++) {
            if (this.treasures[i] != null) {
                treasure += "Treasure N°" + i + this.treasures[i].toString() + "\n";
            }
        }
        return treasure;
    }

    /**
     * Descripcion: Add a treasure to a level
     *
     * @param treasureID int
     * @param levelID int 
     * @return boolean
     */
    public boolean addTreasureToLevel(int treasureID, int levelID) {
        Treasure treasure = this.treasures[treasureID];
        treasure.setPositionX(random.nextInt(this.positionHDX));
        treasure.setPositionY(random.nextInt(this.positionHDY));
        for (int i = 0; i < this.levels.length; i++) {
            for (int j = 0; j < this.treasures.length; j++) {
                this.levels[levelID].addTreasure(treasure);
                return true;
            }
        }
        return false;
    }

    /**
     * Descrpcion: Defines the level of complexity that a given level has,
     * according to the points awarded by enemies and treasure and those removed
     * by enemies that kill the player
     *
     * @param levelID int
     */
    public void dignificarLevelOfComplexity(int levelID) {
        int scoresTreasures = 0;
        int scoresEnemies = 0;
        for (int i = 0; i < this.levels[levelID].getTreasures().length; i++) {
            if (this.levels[levelID].getTreasures()[i] != null) {
                scoresTreasures += this.levels[levelID].getTreasures()[i].getScore();
            }
        }
        for (int j = 0; j < this.levels[levelID].getEnemies().length; j++) {
            if (this.levels[levelID].getEnemies()[j] != null) {
                scoresEnemies += this.levels[levelID].getEnemies()[j].getAdditionScore();
            }
        }

        if (scoresTreasures > scoresEnemies) {
            this.levels[levelID].setLevelComplexity(LevelComplexity.LOW);
        } else {
            if (scoresTreasures == scoresEnemies) {
                this.levels[levelID].setLevelComplexity(LevelComplexity.MEDIUM);
            } else {
                if (scoresTreasures < scoresEnemies) {
                    this.levels[levelID].setLevelComplexity(LevelComplexity.TALL);
                }
            }
        }
    }

    /**
     * Descripcion: Show the player that are registered in the list of players
     *
     * @return player String
     */
    public String showPlayer() {

        String player = "";
        for (int i = 0; i < this.players.length; i++) {
            if (this.players[i] != null) {
                player += "Player N°" + i + this.players[i].toString() + "\n";
            }
        }
        return player;
    }

    /**
     * Descripcion: Increases a player's level according to their score and the
     * score requiered to pass the level
     *
     * @param playerID int 
     * @return boolean
     */
    public boolean increaseLevel(int playerID) {
        for (int i = 0; i < this.levels.length; i++) {
            if (this.players[playerID].getInitialScore() >= this.levels[i].getScoreLevel() && this.players[playerID].getInitialScore() < this.levels[i + 1].getScoreLevel()) {
                this.players[playerID].setLevel(this.levels[i + 1]);
                return true;
            }
        }
        return false;
    }

    /**
     * Descripcion: allows you to obtain the number of treasures that exist in
     * all levels
     *
     * @return contador int
     */
    public int reportTreasure() {
        int contador = 0;
        for (int i = 0; i < this.levels.length; i++) {
            for (int j = 0; j < this.levels[i].getTreasures().length; j++) {
                if (this.levels[i].getTreasures()[j] != null) {
                    contador++;
                }
            }
        }
        return contador;
    }

    /**
     * Descripcion: reports the amount found of an enemy type in all levels
     *
     * @param typeID int
     * @return contador int
     */
    public int reportTypeEnemy(int typeID) {
        int contador = 0;
        TypeEnemy typeEnemy = TypeEnemy.values()[typeID];
        for (int i = 0; i < this.levels.length; i++) {
            for (int j = 0; j < this.levels[i].getEnemies().length; j++) {
                if (this.levels[i].getEnemies()[j] != null) {
                    if (this.levels[i].getEnemies()[j].getType().equals(typeEnemy)) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    /**
     * Descripcion: Determines the most repeated treasure in all levels
     *
     * @return treasure Treasure
     */
    public Treasure treasureMoreRepeated() {
        Treasure treasure = null;
        int contador = 0;
        int veces = 0;
        for (int i = 0; i < this.levels.length; i++) {
            for (int j = 0; j < this.levels[i].getTreasures().length; j++) {
                for (int m = 0; m < this.levels[i].getTreasures().length; m++) {
                    if (this.levels[i].getTreasures()[j] != null && this.levels[i].getTreasures()[m] != null) {
                        if (j != m && this.levels[i].getTreasures()[j].equals(this.levels[i].getTreasures()[m])) {
                            veces = contador++;
                        }
                    }
                }
                if (contador > veces) {
                    treasure = this.levels[i].getTreasures()[j];
                    veces = contador;
                }
            }
        }
        return treasure;
    }

    /**
     * Descripcion: Determine the enemy that gives the highest score
     *
     * @return enemy Enemy
     */
    public Enemy enemyWithHigherScore() {
        Enemy enemy = null;
        for (int i = 0; i < this.enemies.length; i++) {
            for (int j = 0; j < this.enemies.length; j++) {
                if (this.enemies[i] != null && this.enemies[j] != null) {
                    if (i != j && this.enemies[i].getAdditionScore() > this.enemies[j].getAdditionScore()) {
                        enemy = this.enemies[i];
                    } else {
                        enemy = this.enemies[i];
                    }
                }
            }
        }
        return enemy;
    }

    /**
     * Descripcion: Search for an enemy in recorded levels
     *
     * @param enemy Enemy
     * @return level Level
     */
    public Level searchEnemyOflevel(Enemy enemy) {
        Level level = null;
        for (int i = 0; i < this.levels.length; i++) {
            for (int j = 0; j < this.levels[i].getEnemies().length; j++) {
                if (this.levels[i].getEnemies() != null) {
                    if (enemy.equals(this.levels[i].getEnemies()[j])) {
                        level = this.levels[i];
                    }
                }
            }
        }
        return level;
    }
    
    /**
     * Descripcion: Check if a letter is a consonant
     * @param letra char
     * @return boolean
     */
    public boolean esConsonante(char letra) {
        char[] consonantes= {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'x', 'z', 'w', 'y'};
        for(int i=0; i  < consonantes.length ; i++){
            if(letra == consonantes[i]){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Descripcion: Count the consonants that exist in the name of the enemies
     * @return consonants int
     */
    public int consonantsOfEnemies() {
        int consonants = 0;
        for (int i = 0; i < this.enemies.length; i++) {
            if (this.enemies[i] != null) {
                for (int j = 0; j < this.enemies[i].getName().length(); j++) {
                    char letra= this.enemies[i].getName().charAt(i);
                    if(esConsonante(letra)){
                       consonants++; 
                    }
                }
            }
        }
        return consonants;
    }

    /**
     * Descripcion: Obtains the top5 of the players, to do so organizes the players from highest to lowest, according to their score
     * @param players Player[]
     * @return players Player[]
     */
    public Player[] getTop5(Player[] players){
        Player max;
        for(int i=0; i < players.length; i++){
            if(players[i] != null){
               for(int j=i; j < players.length - 1; j++){
                if(players[j+1] != null){
                    if(players[i].getInitialScore() < players[j+1].getInitialScore()){
                        max= players[j+1];
                        players[j+1]= players[i];
                        players[i]= max;
                    }
                }
            }
            }
        }
        return players;    
    }

    /**
     * Descripcion: Show the top5 of the players
     * @param orderedArray Player[]
     * @return msg String
     */
    public String showTop5(Player[] orderedArray) {
        String msg= "";
        for (int i = 0; i < 5; i++) {
            if(orderedArray[i] != null){
                msg+= "\nTop " + (i+1) + " . " + orderedArray[i].getName() + " Puntaje: " + orderedArray[i].getInitialScore();
            }
        }
        return msg;
    }
    
    
}
