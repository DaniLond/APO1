/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author DANIELA LONDOÑO
 */
public class Standard extends Consumer implements Sellable {

    private Song[] songs;
    private Playlist[] playlist;

    public Standard(String nickName, String id, LocalDate date) {
        super(nickName, id, date);
        this.songs = new Song[100];
        this.playlist = new Playlist[20];
    }

    public Song[] getSongs() {
        return songs;
    }

    public Playlist[] getPlaylist() {
        return playlist;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public void setPlaylist(Playlist[] playlist) {
        this.playlist = playlist;
    }

    public boolean addPlaylist(Playlist playlist) {
        for (int i = 0; i < this.playlist.length; i++) {
            if (this.playlist[i] == null) {
                this.playlist[i] = playlist;
                return true;
            }
        }
        return false;
    }

    public boolean addSong(Song song) {
        for (int i = 0; i < this.songs.length; i++) {
            if (this.songs[i] == null) {
                this.songs[i] = song;
                return true;
            }
        }
        return false;
    }

    public String showPlaylist() {

        String plaString = "";
        for (int i = 0; i < this.playlist.length; i++) {
            if (this.playlist[i] != null) {
                plaString += "Playlist N" + i + " " + this.playlist[i].toString() + "\n";
            }
        }
        return plaString;
    }

    public String showAudios(int selection, int index) {
        String msg = "";
        for (int i = 0; i < this.playlist[index].getAudios().size(); i++) {
            if (!this.playlist[index].getAudios().isEmpty()) {
                switch (selection) {
                    case 1:
                        msg += "\n" + (i) + "." + this.playlist[index].getAudios().get(i).getName();
                        break;
                    case 2:
                        if (this.playlist[index].getAudios().get(i) instanceof Podcast) {
                            msg += "\n" + (i) + "." + this.playlist[index].getAudios().get(i).getName();
                        }
                        break;
                    case 3:
                        if (this.playlist[index].getAudios().get(i) instanceof Song) {
                            msg += "\n" + (i) + "." + this.playlist[index].getAudios().get(i).getName();
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

    @Override
    public boolean toBuy(Song song, double money) {
        if (money < song.getValueSale()) {
            return false;
        } else {
            this.addSong(song);
            return true;
        }
    }

}
