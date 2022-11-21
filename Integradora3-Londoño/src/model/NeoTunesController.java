/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author DANIELA LONDOÑO
 */
public class NeoTunesController {

    private ArrayList<User> users;
    private ArrayList<Audio> audios;
    static Random random = new Random();
    private Advertisement advertisement;

    public NeoTunesController() {
        this.users = new ArrayList<User>();
        this.audios = new ArrayList<Audio>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Audio> getAudios() {
        return audios;
    }

    /**
     * Descrption: Register consumer user
     *
     * @param nickname String
     * @param id String
     * @param option int
     * @return boolean
     */
    public boolean registerConsumer(String nickname, String id, int option) {
        boolean registerd = false;
        switch (option) {
            case 1:
                Standard standard = new Standard(nickname, id, LocalDate.now());
                this.users.add(standard);
                registerd = true;
                break;
            case 2:
                Premium premium = new Premium(nickname, id, LocalDate.now());
                this.users.add(premium);
                registerd = true;
                break;
            default:
                break;
        }
        return registerd;
    }

    /**
     * Description: register producer user
     *
     * @param url String
     * @param nickName String
     * @param id String
     * @param option int
     * @return boolean
     */
    public boolean registerProducer(String url, String nickName, String id, int option) {
        boolean registered = false;
        switch (option) {
            case 1:
                Artist artist = new Artist(url, nickName, id, LocalDate.now());
                this.users.add(artist);
                registered = true;
                break;
            case 2:
                Creator creator = new Creator(url, nickName, id, LocalDate.now());
                this.users.add(creator);
                registered = true;
                break;
            default:
                break;
        }
        return registered;
    }

    /**
     * Descrption: Show genres that are registered in the system
     *
     * @return String
     */
    public String toStringGener() {
        Genre typeGenre[] = Genre.values();
        String genString = "Genre";
        for (int i = 0; i < typeGenre.length; i++) {
            genString += "\n" + i + ")" + typeGenre[i];
        }
        return genString;
    }

    /**
     * Descrption: Show categories that are registered in the system
     *
     * @return String
     */
    public String toStringCategory() {
        Category typeCategory[] = Category.values();
        String catString = "Category";
        for (int i = 0; i < typeCategory.length; i++) {
            catString += "\n" + i + ")" + typeCategory[i];
        }
        return catString;
    }

    /**
     * Descrption: register song with the dates enter by user
     *
     * @param album String
     * @param valueSale souble
     * @param gener int
     * @param name String
     * @param url String
     * @param duracion double
     * @param indexArtist int
     * @return boolean
     */
    public boolean registerSong(String album, double valueSale, int gener, String name, String url, double duracion, int indexArtist) {
        Song song = new Song(album, valueSale, gener, name, url, duracion);
        if (this.users.get(indexArtist) instanceof Artist) {
            ((Artist) this.users.get(indexArtist)).getSongs().add(song);
        }
        this.audios.add(song);
        return true;
    }

    public double convertirHoursToDouble(int min, int seg, int horas) {
        return horas + min / 60 + seg / 3600;
    }

    /**
     * Description: register poscast with the date enter by user
     *
     * @param description String
     * @param category int
     * @param name String
     * @param url String
     * @param duration double
     * @param indexCreator int
     * @return boolean
     */
    public boolean registerPodcast(String description, int category, String name, String url, double duration, int indexCreator) {
        Podcast poscast = new Podcast(description, category, name, url, duration);
        if (this.users.get(indexCreator) instanceof Creator) {
            ((Creator) this.users.get(indexCreator)).getPoscasts().add(poscast);
        }
        this.audios.add(poscast);
        return true;
    }

    /**
     * Descrption: register a playlist of a user
     *
     * @param name String
     * @param index int
     * @return boolean
     */
    public boolean registerPlaylist(String name, int index) {
        Playlist playlist = new Playlist(name);
        if (this.users.get(index) instanceof Standard) {
            return ((Standard) this.users.get(index)).addPlaylist(playlist);
        }
        if (this.users.get(index) instanceof Premium) {
            return ((Premium) this.users.get(index)).getPlaylist().add(playlist);
        }
        return false;
    }

    /**
     * Description: Add an audio to a list
     *
     * @param indexPlayList int
     * @param indexAudio int
     * @param indexUser int
     * @return boolean
     */
    public boolean addElementToPlaylist(int indexPlayList, int indexAudio, int indexUser) {
        if (this.users.get(indexUser) instanceof Standard) {
            ((Standard) this.users.get(indexUser)).getPlaylist()[indexPlayList].addAudio(this.audios.get(indexAudio));
            return true;
        }
        if (this.users.get(indexUser) instanceof Premium) {
            ((Premium) this.users.get(indexUser)).getPlaylist().get(indexPlayList).addAudio(this.audios.get(indexAudio));
            return true;
        }
        return false;
    }

    /**
     * Description: Delete an audio from a playlist
     *
     * @param indexPlayList int
     * @param indexAudio int
     * @param indexUser int
     * @return boolean
     */
    public boolean deleteElementToPlaylist(int indexPlayList, int indexAudio, int indexUser) {
        if (this.users.get(indexUser) instanceof Standard) {
            ((Standard) this.users.get(indexUser)).getPlaylist()[indexPlayList].deleteAudio(this.audios.get(indexAudio));
            return true;
        }
        if (this.users.get(indexUser) instanceof Premium) {
            ((Premium) this.users.get(indexUser)).getPlaylist().get(indexPlayList).deleteAudio(this.audios.get(indexAudio));
            return true;
        }
        return false;
    }

    /**
     * Descrption: Edit the name of a playlist
     *
     * @param index int
     * @param name String
     * @param indexUser int
     * @return boolean
     */
    public boolean editNameofPlaylist(int index, String name, int indexUser) {
        if (this.users.get(indexUser) instanceof Standard) {
            ((Standard) this.users.get(indexUser)).getPlaylist()[index].setName(name);
            return true;
        }
        if (this.users.get(indexUser) instanceof Premium) {
            ((Premium) this.users.get(indexUser)).getPlaylist().get(index).setName(name);
            return true;
        }
        return true;
    }

    /**
     * Description: Edit playlist, includes adding and removing audio
     *
     * @param indexPlayList int
     * @param indexAudio int
     * @param indexUser int
     * @param option int
     * @return boolean
     */
    public boolean editPlaylist(int indexPlayList, int indexAudio, int indexUser, int option) {
        switch (option) {
            case 1:
                return addElementToPlaylist(indexPlayList, indexAudio, indexUser);
            case 2:
                return deleteElementToPlaylist(indexPlayList, indexAudio, indexUser);
            default:
                break;
        }
        return false;
    }

    /**
     * Description: Show the user registered in the system
     *
     * @return String
     */
    public String showUser() {

        String users = "";
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i) instanceof Premium || this.users.get(i) instanceof Standard) {
                users += "User N" + i + " " + this.users.get(i).getNickName() + "\n";
            }

        }
        return users;
    }

    public String showProducer(int option) {
        String producer = "";
        for (int i = 0; i < this.users.size(); i++) {
            if (option == 1) {
                if (this.users.get(i) instanceof Artist) {
                    producer += "Artist N" + i + " " + ((Artist) this.users.get(i)).getNickName() + "\n";
                }
            }
            if (option == 2) {
                if (this.users.get(i) instanceof Creator) {
                    producer += "Creator N" + i + " " + ((Creator) this.users.get(i)).getNickName() + "\n";
                }
            }
        }
        return producer;
    }

    /**
     * Description: Show the audios registered in the system.it has the option
     * to choose which type to choose
     *
     * @param selection int
     * @return String
     */
    public String showAudios(int selection) {
        String msg = "";
        for (int i = 0; i < this.audios.size(); i++) {
            if (!this.audios.isEmpty()) {
                switch (selection) {
                    case 1:
                        msg += "\n" + (i) + "." + this.audios.get(i).getName();
                        break;
                    case 2:
                        if (this.audios.get(i) instanceof Podcast) {
                            msg += "\n" + (i) + "." + this.audios.get(i).getName();
                        }
                        break;
                    case 3:
                        if (this.audios.get(i) instanceof Song) {
                            msg += "\n" + (i) + "." + this.audios.get(i).getName();
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        if (msg.equals("")) {
            msg = "There are no Audios registered yet";
        }
        return msg;
    }

    /**
     * Description: Show the audios of a user's report list. it has the option
     * to choose which type to choose
     *
     * @param selection int
     * @param indexPlaylist int
     * @param indexUser int
     * @return String
     */
    public String showAudiosPlaylist(int selection, int indexPlaylist, int indexUser) {
        String msg = "";
        if (this.users.get(indexUser) instanceof Standard) {
            msg = ((Standard) this.users.get(indexUser)).showAudios(selection, indexPlaylist);
        }
        if (this.users.get(indexUser) instanceof Premium) {
            msg = ((Premium) this.users.get(indexUser)).showAudios(selection, indexPlaylist);
        }
        return msg;
    }

    /**
     * Description: Show the playlist of an user
     *
     * @param indexUser int
     * @return String
     */
    public String showPlaylistOfUser(int indexUser) {
        String msg = "";
        if (this.users.get(indexUser) instanceof Standard) {
            msg = ((Standard) this.users.get(indexUser)).showPlaylist();
        }
        if (this.users.get(indexUser) instanceof Premium) {
            msg = ((Premium) this.users.get(indexUser)).showPlaylist();
        }
        return msg;
    }

    /**
     * Description: Generates a matrix of 6x6
     *
     * @return newMatrix int[][]
     */
    public int[][] generateMatrix() {

        int[][] newMatrix = new int[6][6];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = random.nextInt(10);
            }
        }
        return newMatrix;
    }

    /**
     * Description: Print an matrix
     *
     * @param matrix int[][]
     * @return msg String
     */
    public String printMatrix(int[][] matrix) {

        String msg = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                msg += matrix[i][j] + " ";
            }
            msg += "\n";
        }
        return msg;
    }

    /**
     * Description: Traverse the matrix in the form of N and generate the code
     *
     * @param matrix int[][]
     * @return msg String
     */
    public String generateCodeN(int[][] matrix) {

        String msg = "";
        for (int i = matrix.length; i > 0; i--) { // Gets the values of the first column of the matrix
            msg += matrix[i - 1][0];
        }
        for (int i = 1, j = 1; i < matrix.length - 1; i++, j++) { // Gets the values of the diagonal of the matrix           
            msg += matrix[i][j];
        }
        for (int i = matrix.length; i > 0; i--) { // Gets the values of the last column of the matrix
            msg += matrix[i - 1][matrix[0].length - 1];
        }
        return msg;
    }

    /**
     * Description: Treverse the matrix in the form of T and generate the code
     *
     * @param matrix int[][]
     * @return msg String
     */
    public String generateCodeT(int[][] matrix) {
        String msg = "";

        for (int j = 0; j < matrix.length / 2; j++) {
            msg += matrix[0][j];
        }

        for (int i = 1; i < matrix.length; i++) {
            msg += matrix[i][2];
        }

        for (int i = matrix.length; i > 0; i--) {
            msg += matrix[i - 1][3];
        }

        for (int j = (matrix.length / 2) + 1; j < matrix.length; j++) {
            msg += matrix[0][j];
        }
        return msg;
    }

    /**
     * Description: loops through the Matrix from bottom to top and from right
     * to left, where it will only choose an odd number greater than 1, from the
     * result of the sum of positions j and i
     *
     * @param matrix int[][]
     * @return msg String
     */
    public String generateCodeImpar(int[][] matrix) {
        String msg = "";

        for (int i = matrix.length; i > 0; i--) {
            for (int j = matrix.length; j > 0; j--) {
                if ((i + j) % 2 != 0 && (i + j) != 1) {
                    msg += matrix[i - 1][j - 1];
                }

            }
        }
        return msg;
    }

    /**
     * Description: Determines if only podcasts exits in a list
     *
     * @param indexUser int
     * @param indexPlaylist int
     * @return boolean
     */
    public boolean isPlaylistOfPodcast(int indexUser, int indexPlaylist) {

        if (this.users.get(indexUser) instanceof Standard) {
            for (int i = 0; i < ((Standard) this.users.get(indexUser)).getPlaylist()[indexPlaylist].getAudios().size(); i++) {
                if (((Standard) this.users.get(indexUser)).getPlaylist()[indexPlaylist].getAudios().get(i) instanceof Song) {
                    return false;
                }
            }
        }
        if (this.users.get(indexUser) instanceof Premium) {
            for (int i = 0; i < ((Premium) this.users.get(indexUser)).getPlaylist().get(indexPlaylist).getAudios().size(); i++) {
                if (((Premium) this.users.get(indexUser)).getPlaylist().get(indexPlaylist).getAudios().get(i) instanceof Song) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Description: Determines if only song exits in a list
     *
     * @param indexUser int
     * @param indexPlaylist int
     * @return boolean
     */
    public boolean isPlaylistOfSong(int indexUser, int indexPlaylist) {

        if (this.users.get(indexUser) instanceof Standard) {
            for (int i = 0; i < ((Standard) this.users.get(indexUser)).getPlaylist()[indexPlaylist].getAudios().size(); i++) {
                if (((Standard) this.users.get(indexUser)).getPlaylist()[indexPlaylist].getAudios().get(i) instanceof Podcast) {
                    return false;
                }
            }
        }
        if (this.users.get(indexUser) instanceof Premium) {
            for (int i = 0; i < ((Premium) this.users.get(indexUser)).getPlaylist().get(indexPlaylist).getAudios().size(); i++) {
                if (((Premium) this.users.get(indexUser)).getPlaylist().get(indexPlaylist).getAudios().get(i) instanceof Podcast) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Description: Generate the code of the playlist accordiang to the
     * following conditions: if the only song, in N, if it is only a podcast in
     * T and if in both in arrimaba there was down and taking the sum of the odd
     * positions
     *
     * @param indexUser int
     * @param indexPlaylist int
     * @param matrix int[][]
     * @return msg String
     */
    public String sharePlaylist(int indexUser, int indexPlaylist, int[][] matrix) {
        String msg = "";

        if (this.users.get(indexUser) instanceof Premium || this.users.get(indexUser) instanceof Standard) {
            if (this.users.get(indexUser) instanceof Standard) {
                if (((Standard) this.users.get(indexUser)).getPlaylist()[indexPlaylist].getAudios().isEmpty()) {
                    msg = "The list is empty";
                }
            } else {
                if (this.users.get(indexUser) instanceof Premium) {
                    if (((Premium) this.users.get(indexUser)).getPlaylist().get(indexPlaylist).getAudios().isEmpty()) {
                        msg = "The list is empty";
                    }
                }

            }
        } else {
            if (isPlaylistOfSong(indexUser, indexPlaylist)) {
                msg = generateCodeN(matrix);
            } else {
                if (isPlaylistOfPodcast(indexUser, indexPlaylist)) {
                    msg = generateCodeT(matrix);
                } else {
                    msg = generateCodeImpar(matrix);
                }
            }
        }
        return msg;
    }

    /**
     * Description: Initiates the ad and randomly chooses the ones it has
     * registered
     */
    public void startAdvertisement() {
        int rand = random.nextInt(2);
        advertisement = Advertisement.values()[rand];
        if (advertisement == Advertisement.COCACOLA) {
            System.out.println("Coca-Cola - Open Happiness.");
        } else {
            if (advertisement == Advertisement.NIKE) {
                System.out.println("Nike - Just Do It.");
            }
        }
    }

    /**
     * Description: Reproduces an audio taking into account the type of the user
     * who reproduces it
     *
     * @param indexAudio int
     * @param indexUser int
     * @param countSong int
     * @return msg String
     */
    public String reproduceAudio(int indexAudio, int indexUser, int countSong) {
        String msg = "";
        if (this.users.get(indexUser) instanceof Standard) {
            if (this.audios.get(indexAudio) instanceof Song) {
                if (countSong == 2) {
                    startAdvertisement();
                }
                msg = this.audios.get(indexAudio).play();
            }
            if (this.audios.get(indexAudio) instanceof Podcast) {
                startAdvertisement();
                msg = this.audios.get(indexAudio).play();
            }
        }

        if (this.users.get(indexUser) instanceof Premium) {
            msg = this.audios.get(indexAudio).play();
        }

        ((Consumer) this.users.get(indexUser)).getAudioHistory().add(this.audios.get(indexAudio));
        this.audios.get(indexAudio).setNumPlays(this.audios.get(indexAudio).getNumPlays() + 1);

        if (this.audios.get(indexAudio) instanceof Song) {
            for (int i = 0; i < this.users.size(); i++) {
                if (this.users.get(i) instanceof Artist) {
                    for (int j = 0; j < ((Artist) this.users.get(i)).getSongs().size(); j++) {
                        if (((Artist) this.users.get(i)).getSongs().get(j).equals(this.audios.get(indexAudio))) {
                            ((Artist) this.users.get(i)).setNumberReproductions(((Artist) this.users.get(i)).getNumberReproductions() + 1);
                            ((Artist) this.users.get(i)).setPlayedTime(((Artist) this.users.get(i)).getPlayedTime() + this.audios.get(indexAudio).getDuracion());
                        }
                    }
                }
            }
        }
        if (this.audios.get(indexAudio) instanceof Podcast) {
            for (int i = 0; i < this.users.size(); i++) {
                if (this.users.get(i) instanceof Creator) {
                    for (int j = 0; j < ((Creator) this.users.get(i)).getPoscasts().size(); j++) {
                        if (((Creator) this.users.get(i)).getPoscasts().get(j).equals(this.audios.get(indexAudio))) {
                            ((Creator) this.users.get(i)).setNumberReproductions(((Creator) this.users.get(i)).getNumberReproductions() + 1);
                            ((Creator) this.users.get(i)).setPlayedTime(((Creator) this.users.get(i)).getPlayedTime() + this.audios.get(indexAudio).getDuracion());
                        }
                    }
                }
            }
        }

        return msg;

    }

    /**
     * Description: It allows a user to buy a song that the system has
     * registered. To do this, the user chooses that song, enters the value and
     * if it is not essential, the operation is carried out. In addition, the
     * registration of a purchase will be made
     *
     * @param indexUser int
     * @param indexAudio int
     * @param money double
     * @return boolean
     */
    public boolean buySong(int indexUser, int indexAudio, double money) { //Me falta fecha de operacion y validar que salga el mensaje cuando la lista de standar este llena
        Shop shop = null;
        if (this.audios.get(indexAudio) instanceof Song) {
            if (this.users.get(indexUser) instanceof Consumer) {
                if (this.users.get(indexUser) instanceof Premium) {
                    return ((Premium) this.users.get(indexUser)).toBuy(((Song) this.audios.get(indexAudio)), money);
                }
                if (this.users.get(indexUser) instanceof Standard) {
                    return ((Standard) this.users.get(indexUser)).toBuy(((Song) this.audios.get(indexAudio)), money);
                }
            }

            shop = new Shop(LocalDate.now(), ((Song) this.audios.get(indexAudio)));
            ((Consumer) this.users.get(indexUser)).getShopping().add(shop);
            ((Song) this.audios.get(indexAudio)).setNumTimeSold(((Song) this.audios.get(indexAudio)).getNumTimeSold() + 1);
        }
        return false;
    }

    /**
     * Description: returns the value of the audio
     *
     * @param indexAudio int
     * @return value double
     */
    public double valueSong(int indexAudio) {
        double value = 0;
        if (this.audios.get(indexAudio) instanceof Song) {
            value = ((Song) this.audios.get(indexAudio)).getValueSale();
        }
        return value;
    }

    /**
     * Description: Shows the most listened to songs in the entire system
     * @return String
     */
    public String reportSongViews() {
        int reproductions = 0;
        for (int i = 0; i < this.audios.size(); i++) {
            if (this.audios.get(i) instanceof Song) {
                reproductions += ((Song) this.audios.get(i)).getNumPlays();
            }
        }

        return "The have reproduced " + reproductions + " song across the platform\n";
    }

    /**
     * Description: Shows the most listened to podcast in the entire system
     * @return String
     */
    public String reportPodcastViews() {
        int reproductions = 0;
        for (int i = 0; i < this.audios.size(); i++) {
            if (this.audios.get(i) instanceof Podcast) {
                reproductions += ((Podcast) this.audios.get(i)).getNumPlays();
            }
        }

        return "The have reproduced " + reproductions + " Podcast across the platform\n";
    }

    /**
     * Description: Shows the most listened genre of a user
     * @param indexUser int
     * @return String
     */
    public String mostGenreUser(int indexUser) {
        String msg = "";
        if (this.users.get(indexUser) instanceof Consumer) {
            msg = ((Consumer) this.users.get(indexUser)).mostGenreUser();
        }
        return msg;
    }

    /**
     * Description: Shows the consumer users registered in the system
     * @return String
     */
    public String showConsumer() {

        String users = "";
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i) instanceof Consumer) {
                users += "User N" + i + " " + this.users.get(i).getNickName() + "\n";
            }

        }
        return users;
    }

    /**
     * Description: Shows the most listened genre in all system
     * @return String
     */
    public String mostGenreSystem() {
        String msg = "";
        Genre genre = null;
        int veces = 0;
        int contador = 0;
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i) instanceof Consumer) {
                contador = 0;
                for (int j = 0; j < ((Consumer) this.users.get(i)).getAudioHistory().size(); j++) {
                    if (((Consumer) this.users.get(i)).getAudioHistory().get(j) instanceof Song) {
                        for (int m = 0; m < ((Consumer) this.users.get(i)).getAudioHistory().size(); m++) {
                            if (((Consumer) this.users.get(i)).getAudioHistory().get(m) instanceof Song) {
                                if (j != m && ((Song) ((Consumer) this.users.get(i)).getAudioHistory().get(j)).getGener().equals(((Song) ((Consumer) this.users.get(i)).getAudioHistory().get(m)).getGener())) {
                                    contador++;
                                }
                            }
                        }
                    }
                }
                if (contador > veces) {
                    genre = ((Song) ((Consumer) this.users.get(i)).getAudioHistory().get(i)).getGener();
                    veces = contador;
                }
            }
        }
        return "The most listened to genre in the entire system is: " + genre.name() + " with " + (veces + 1) + " reproductions";
    }

    /**
     * Description: Shows the most listened category in all system
     * @return String
     */
    public String mostCategorySystem() {
        String msg = "";
        Category category = null;
        int veces = 0;
        int contador = 0;
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i) instanceof Consumer) {
                contador = 0;
                for (int j = 0; j < ((Consumer) this.users.get(i)).getAudioHistory().size(); j++) {
                    if (((Consumer) this.users.get(i)).getAudioHistory().get(j) instanceof Podcast) {
                        for (int m = 0; m < ((Consumer) this.users.get(i)).getAudioHistory().size(); m++) {
                            if (((Consumer) this.users.get(i)).getAudioHistory().get(m) instanceof Podcast) {
                                if (j != m && ((Podcast) ((Consumer) this.users.get(i)).getAudioHistory().get(j)).getCategory().equals(((Podcast) ((Consumer) this.users.get(i)).getAudioHistory().get(m)).getCategory())) {
                                    contador++;
                                }
                            }
                        }
                    }
                }
                if (contador > veces) {
                    category = ((Podcast) ((Consumer) this.users.get(i)).getAudioHistory().get(i)).getCategory();
                    veces = contador;
                }
            }
        }
        return "The most listened to genre in the entire system is: " + category.name() + " with " + (veces + 1) + " reproductions";
    }

    /**
     * Description: Shows the most listened category of a user
     * @param indexUser int
     * @return String
     */
    public String mostCategoryUser(int indexUser) {
        String msg = "";
        if (this.users.get(indexUser) instanceof Consumer) {
            msg = ((Consumer) this.users.get(indexUser)).mostCategoryUser();
        }
        return msg;
    }

    /**
     * Description: Shows the top5 producers
     * @return msg String
     */
    public String top5() {
        String msg = "no songs or podcasts have been listened to";
        Artist[] top5A = new Artist[5];
        Creator[] top5C = new Creator[5];
        ArrayList<Artist> artists = new ArrayList<Artist>();
        ArrayList<Creator> creators = new ArrayList<Creator>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) instanceof Artist) {
                artists.add((Artist) users.get(i));
            } else if (users.get(i) instanceof Creator) {
                creators.add((Creator) users.get(i));
            }
        }

        Producer max = null;
        int counter = 0;
        max = artists.get(0);
        for (int i = 0; i < artists.size(); i++) {

            if (artists.get(i).getNumberReproductions() > max.getNumberReproductions()) {
                max = artists.get(i);
            }
            if (i == artists.size() - 1) {
                if ((top5A[4] == null)) {

                    top5A[counter] = (Artist) max;
                    counter++;
                    artists.remove(max);
                    if (artists.size() > 0) {
                        max = artists.get(0);
                        i = 0;
                    }
                }
            }

        }

        counter = 0;
        max = creators.get(0);
        for (int i = 0; i < creators.size(); i++) {

            if (creators.get(i).getNumberReproductions() > max.getNumberReproductions()) {
                max = creators.get(i);
            }
            if (i == creators.size() - 1) {
                if ((top5C[4] == null)) {

                    top5C[counter] = (Creator) max;
                    counter++;
                    creators.remove(max);
                    if (creators.size() > 0) {
                        max = creators.get(0);
                        i = 0;
                    }
                }
            }

        }
        for (int i = 0; i < top5A.length; i++) {
            if (top5A[i] != null) {
                msg = "The top 5 artists are:\n ";
                msg += (i + 1) + "." + top5A[i].getNickName() + " with " + top5A[i].getNumberReproductions() + " plays";
            }
        }
        for (int i = 0; i < top5C.length; i++) {
            if (top5C[i] != null) {
                msg += "\nThe top 5 content creators are:\n ";
                msg += (i + 1) + "." + top5C[i].getNickName() + " with " + top5C[i].getNumberReproductions() + " plays";
            }
        }

        return msg;

    }

    /**
     * Description: Shows the top 10 of the audios
     * @return msg String
     */
    public String top10() {
        String msg = "no songs or podcasts have been listened to";
        Song[] top10A = new Song[10];
        Podcast[] top10P = new Podcast[10];
        ArrayList<Song> songs = new ArrayList<Song>();
        ArrayList<Podcast> podcasts = new ArrayList<Podcast>();
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                songs.add((Song) audios.get(i));
            } else if (audios.get(i) instanceof Podcast) {
                podcasts.add((Podcast) audios.get(i));
            }
        }

        int counter = 0;
        Audio max = null;
        max = songs.get(0);
        for (int i = 0; i < songs.size(); i++) {

            if (songs.get(i).getNumPlays() > max.getNumPlays()) {
                max = songs.get(i);
            }
            if (i == songs.size() - 1) {
                if ((top10A[9] == null)) {

                    top10A[counter] = (Song) max;
                    counter++;
                    songs.remove(max);
                    if (songs.size() > 0) {
                        max = songs.get(0);
                        i = 0;
                    }
                }
            }

        }

        counter = 0;
        max = podcasts.get(0);
        for (int i = 0; i < podcasts.size(); i++) {

            if (podcasts.get(i).getNumPlays() > max.getNumPlays()) {
                max = podcasts.get(i);
            }
            if (i == podcasts.size() - 1) {
                if ((top10P[9] == null)) {

                    top10P[counter] = (Podcast) max;
                    counter++;
                    podcasts.remove(max);
                    if (podcasts.size() > 0) {
                        max = podcasts.get(0);
                        i = 0;
                    }
                }
            }

        }
        for (int i = 0; i < top10A.length; i++) {
            if (top10A[i] != null) {
                msg = "The top 10 songs are:\n ";
                msg += (i + 1) + "." + top10A[i].getName() + "with genre: " + top10A[i].getGener().name() + " with "
                        + top10A[i].getNumPlays() + " plays";
            }
        }

        for (int i = 0; i < top10P.length; i++) {
            if (top10P[i] != null) {
                msg += "\nThe top 10 podcasts are:\n ";
                msg += (i + 1) + "." + top10P[i].getName() + "with Category: " + top10P[i].getCategory().name()
                        + " with " + top10P[i].getNumPlays() + " plays";
            }
        }

        return msg;
    }
    
}
