/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ui;

import java.util.Random;
import java.util.Scanner;
import model.Enemy;
import model.GameController;
import model.Level;
import model.TypeEnemy;

/**
 *
 * @author DANIELA LONDOÑO
 */
public class GameManager {

    static Random random = new Random();
    public static Scanner sc = new Scanner(System.in);
    public static GameController gameController = new GameController();

    /**
     * Descripcion: The system allows you to register levels, these will have a
     * number that identifies it, the points that are required to go to the next
     * level given by the user.
     */
    public static void registerLevel() {
        Level level = null;

        boolean first = true;
        for (int i = 0; i < gameController.getLevels().length; i++) {
            boolean exit = false;
            int score = 0;
            do {
                System.out.println("Enter the score for the level " + (i));
                score = sc.nextInt();
                if (first) {
                    if (score > 10) {
                        level = gameController.registerLevel(i);
                        level.setScoreLevel(score);
                        first = false;
                        exit = true;
                    } else {
                        System.out.println("The score must be greater than 10");
                    }
                } else {
                    if (score > gameController.getLevels()[i - 1].getScoreLevel()) {
                        level = gameController.registerLevel(i);
                        level.setScoreLevel(score);
                        exit = true;
                    } else {
                        System.out.println("the score must be larger than the previous level " + gameController.getLevels()[i - 1].getScoreLevel());
                    }
                }
            } while (exit == false);

        }
    }

    /**
     * Descripcion: It allows to register players in the systems. To do this,
     * the system will ask for a nickname, which cannot be already repeated, and
     * a name
     */
    public static void registerPlayer() {
        boolean exit = false;
        sc.nextLine();
        String nickname = "";
        while (exit == false) {
            System.out.println("Enter the nickname");
            nickname = sc.nextLine();
            if (gameController.comparePlayer(nickname)) {
                System.out.println("This nickname already exists");
            } else {
                exit = true;
            }
        }

        System.out.println("Enter the name");
        String name = sc.nextLine();

        if (gameController.registerPlayer(nickname, name)) {
            System.out.println("Player successfully register");
        } else {
            System.out.println("Error could not register Player");
        }
    }

    /**
     * Descripcion: Allows you to register enemies in the system. To do this,
     * the system will ask for a name of the enemy, a type, scores that add and
     * subtract
     */
    private static void registerEnemy() {
        System.out.println("Enter the name");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.println(gameController.toStringEnemy());
        System.out.println("Enter the opcion of type enemy");
        int typeEnemy = sc.nextInt();

        System.out.println("Enter the remaining score");
        int subtractionScore = sc.nextInt();

        System.out.println("Enter the score that addition");
        int additionScore = sc.nextInt();

        if (gameController.registerEnemy(name, typeEnemy, subtractionScore, additionScore)) {
            System.out.println("Enemy successfully register");
        } else {
            System.out.println("Error could not register enemy");
        }
    }

    /**
     * Descripcion: Allows you to add enemies to a level. To do this, the
     * enemies and levels are shown and the user types the enemy and the level
     * where they are going to do this functionality.
     */
    private static void addEnemytoLevel() {
        System.out.println("these are the levels that are registered: ");
        System.out.println(gameController.showLevel());

        System.out.println("choose the position in which the Level is located");
        int levelID = sc.nextInt();

        System.out.println("these are the Emenies that are resgisted: ");
        System.out.println(gameController.showEnemy());

        System.out.println("choose the position in which the enemy is located");
        int enemyID = sc.nextInt();

        if (gameController.addEnemyToLevel(enemyID, levelID)) {
            System.out.println("the enemy successdully registered in the level");
            gameController.dignificarLevelOfComplexity(levelID);
            System.out.println("El nivel de complejidad es: " + gameController.getLevels()[levelID].getLevelComplexity());
        } else {
            System.out.println("the enemy could not be registered in the level");
        }

    }

    /**
     * Descripcion: allows you to register treasures at one level. For them, ask
     * for the name, a link to the image and the score it adds.
     */
    private static void registerTreasure() {
        System.out.println("Enter the name");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.println("Enter the URL");
        String URL = sc.nextLine();

        System.out.println("Enter the score");
        int score = sc.nextInt();

        if (gameController.registerTreasure(name, URL, score)) {
            System.out.println("Enemy successfully register");
        } else {
            System.out.println("Error could not register enemy");
        }
    }
    
    /**
     * Descripcion: Check the level a player is at
     */
    private static void consultLevelOfPlayer(){
        System.out.println("This are the player resgisted" + gameController.showPlayer()); 
        System.out.println("Choose the position of player");
        int indexPlayer= sc.nextInt();
        
        System.out.println("The level of player is: " + gameController.consultLevelOfPlayer(indexPlayer));
        if(gameController.consultLevelOfPlayer(indexPlayer) == null){
            System.out.println("This player is not registered");
        }
    }

    /**
     * Descripcion: The system allows adding a treasure to a level. To do this,
     * the system shows the treasures and players and the user chooses the level
     * and the treasure to carry out this functionality. Also add it as many
     * times as the user wants.
     */
    private static void addTreasuretoLevel() {
        System.out.println("these are the levels that are registered: ");
        System.out.println(gameController.showLevel());

        System.out.println("choose the position in which the Level is located");
        int levelID = sc.nextInt();

        System.out.println("these are the treasure that are resgisted: ");
        System.out.println(gameController.showTreasure());

        System.out.println("choose the position in which the treasure is located");
        int treasureID = sc.nextInt();

        System.out.println("How many times do you want to add the treasure?");
        int times = sc.nextInt();

        for (int i = 0; i < times; i++) {
            if (gameController.addTreasureToLevel(treasureID, levelID)) {
                System.out.println("the treasure successdully registered in the level");
                gameController.dignificarLevelOfComplexity(levelID);
                System.out.println("El nivel de complejidad es: " + gameController.getLevels()[levelID].getLevelComplexity());
            } else {
                System.out.println("the treasure could not be registered in the level");
            }
        }
    }

    /**
     * Descripcion: Allows you to modify a player's score. To do this, the
     * system displays the players, the user chooses the player they want and
     * enters the new score. Finally, the previous score is modified.
     */
    private static void changeScoreToPlayer() {
        System.out.println("These are the resgistered players");
        System.out.println(gameController.showPlayer());
        System.out.println("Choose the player whose score you want to modify");
        int playerID = sc.nextInt();

        System.out.println("Enter the new score of player");
        int score = sc.nextInt();

        if (gameController.getPlayers()[playerID].setInitialScore(score)) {
            System.out.println("Modified player score");
        } else {
            System.out.println("Could not change the score");
        }

    }

    /**
     * Descripcion: It allows to increase the level to a player. For them, the
     * user chooses the player and the system modifies the level according to
     * the required points and the player's points, in case it is not achieved,
     * the system shows the score that has to be obtained.
     */
    private static void increaseLevel() {
        System.out.println("These are the resgistered players");
        System.out.println(gameController.showPlayer());
        System.out.println("The player chooses what he wants to increase the level to");
        int playerID = sc.nextInt();

        if (gameController.increaseLevel(playerID)) {
            System.out.println("Increased level");
            System.out.println("The player stay on the level: " + gameController.getPlayers()[playerID].getLevel().getNumberID());
        } else {
            int numberID = gameController.getPlayers()[playerID].getLevel().getNumberID();
            System.out.println("The player requires the following score: " + gameController.getLevels()[numberID].getScoreLevel());
        }
    }

    /**
     * Descripcion: Shows the report of all the enemies and treasure that are in
     * a level
     */
    private static void reportTreasuresAndEnemies() {
        System.out.println("these are the levels that are registered: ");
        System.out.println(gameController.showLevel());

        System.out.println("choose the position in which the Level is located");
        int levelID = sc.nextInt();

        System.out.println("These are the enemies of that level:");
        System.out.println(gameController.getLevels()[levelID].showEnemy());

        System.out.println("These are the treasure of that level:");
        System.out.println(gameController.getLevels()[levelID].showTreasure());
    }

    /**
     * Descripcion: reports how many enemies found referring to a type of enemy
     * entered by the user
     */
    private static void reportTypeEnemy() {
        System.out.println(gameController.toStringEnemy());
        System.out.println("Enter the opcion of type enemy");
        int typeID = sc.nextInt();

        System.out.println("There are " + gameController.reportTypeEnemy(typeID) + " " + TypeEnemy.values()[typeID]);
    }

    private static void enemyWithHigherScoreAndLevel() {
        Enemy enemy = gameController.enemyWithHigherScore();
        System.out.println("The enemy with higher score is: " + enemy.toString());
        if (gameController.searchEnemyOflevel(enemy) != null) {
            System.out.println("The level of enemy is: " + gameController.searchEnemyOflevel(enemy));
        } else {
            System.out.println("The enemy is not on a level");
        }
    }

    /**
     * Descripcion: Show the option that the user can choose
     */
    public static void menu() {
        System.out.println("welcome");

        boolean exit = false;

        while (!exit) {
            System.out.println("Enter a option\n1.Register player\n2.Register enemy\n3.Add enemy to a level\n4.Register treasure\n5.Add treasure to a level\n6.Modify a player's score\n7.Check a player's level\n8.Level up a player\n9.Report treasure and enemies of a level\n10.Report amount of treasure in all levels\n11.Report of type enemy in all levels\n12.Most repeated treasure report\n13.Report of the enemy that gives the highest score and its level\n14.Calculate the number of consonants of enemy names\n15.Report of top5 ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    registerPlayer();
                    break;
                case 2:
                    registerEnemy();
                    break;
                case 3:
                    addEnemytoLevel();
                    break;
                case 4:
                    registerTreasure();
                    break;
                case 5:
                    addTreasuretoLevel();
                    break;
                case 6:
                    changeScoreToPlayer();
                    break;
                case 7:
                    consultLevelOfPlayer();
                    break;
                case 8:
                    increaseLevel();
                    break;
                case 9:
                    reportTreasuresAndEnemies();
                    break;
                case 10:
                    System.out.println("At all levels there is: " + gameController.reportTreasure() + " treasures");
                    break;
                case 11:
                    reportTypeEnemy();
                    break;
                case 12:
                    System.out.println("The most repeated treasure is:" + gameController.treasureMoreRepeated().toString());
                    break;
                case 13:
                    enemyWithHigherScoreAndLevel();
                    break;
                case 14:
                    System.out.println("The total of the consonants of the enemies is: " + gameController.consonantsOfEnemies());
                    break;
                case 15:
                    System.out.println("TOP5" + gameController.showTop5(gameController.getTop5(gameController.getPlayers())));
                    break;
                default:
                    exit = true;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        registerLevel();
        menu();
    }
}
