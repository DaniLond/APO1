/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author DANIELA LONDOÑO
 */
class Playlist {
    private String name;
    private String code;
    private ArrayList<Audio> audios;

    public Playlist(String name) {
        this.name = name;
        this.code = "";
        this.audios= new ArrayList<Audio>();
    }

    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    public ArrayList<Audio> getAudios() {
        return audios;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public void addAudio(Audio audio){
        this.audios.add(audio);
    }
   
    public boolean deleteAudio(Audio auido){
        return this.audios.remove(auido);
    }

    @Override
    public String toString() {
        return "name=" + name ;
    }
    
    
}
