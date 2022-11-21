/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author DANIELA LONDOÑO
 */
public class Premium extends Consumer implements Sellable{

    private ArrayList<Song> songs;
    private ArrayList<Playlist> playlist;

    public Premium(String nickName, String id, LocalDate date) {
        super(nickName, id, date);
        this.songs = new ArrayList<Song>();
        this.playlist = new ArrayList<Playlist>();
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setPlaylist(ArrayList<Playlist> playlist) {
        this.playlist = playlist;
    }

    public ArrayList<Playlist> getPlaylist() {
        return playlist;
    }

    public String showPlaylist() {

        String plaString = "";
        for (int i = 0; i < this.playlist.size(); i++) {

            plaString += "Playlist N" + i +" "+ this.playlist.get(i).toString() + "\n";

        }
        return plaString;
    }

    public String showAudios(int selection, int index) {
        String msg = "";
        for (int i = 0; i < this.playlist.get(index).getAudios().size(); i++) {
            if (!this.playlist.get(index).getAudios().isEmpty()) {
                switch (selection) {
                    case 1:
                        msg += "\n" + (i) + "." + this.playlist.get(index).getAudios().get(i).getName();
                        break;
                    case 2:
                        if (this.playlist.get(index).getAudios().get(i) instanceof Podcast) {
                            msg += "\n" + (i) + "." + this.playlist.get(index).getAudios().get(i).getName();
                        }
                        break;
                    case 3:
                        if (this.playlist.get(index).getAudios().get(i) instanceof Song) {
                            msg += "\n" + (i) + "." + this.playlist.get(index).getAudios().get(i).getName();
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
        if(money < song.getValueSale()){
            return false;
        }else{
            this.songs.add(song);
            return true;
        }
    }
}
