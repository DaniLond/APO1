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

    public NeoTunesController() {
        this.users = new ArrayList<User>();
        this.audios = new ArrayList<Audio>();
    }

    public ArrayList<User> getUsers() {
        return users;
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
     * @return boolean
     */
    public boolean registerSong(String album, double valueSale, int gener, String name, String url, double duracion) {
        Song song = new Song(album, valueSale, gener, name, url, duracion);
        return this.audios.add(song);
    }

    /**
     * Description: register poscast with the date enter by user
     *
     * @param description String
     * @param category int
     * @param name String
     * @param url String
     * @param duration double
     * @return boolean
     */
    public boolean registerPodcast(String description, int category, String name, String url, double duration) {
        Podcast poscast = new Podcast(description, category, name, url, duration);
        return this.audios.add(poscast);
    }
    // Falta en el diagrama de clases desde aqui
    
    /**
     * Descrption: register a playlist of a user
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

    /**
     * Description: Show the audios registered in the system.it has the option to choose which type to choose
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
     * Description: Show the audios of a user's report list. it has the option to choose which type to choose
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
     *  Description: Show the playlist of an user
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
}
