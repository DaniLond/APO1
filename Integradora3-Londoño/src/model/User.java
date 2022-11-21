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
public abstract class User {
    private String nickName;
    private String id;
    private LocalDate date;

    public User(String nickName, String id, LocalDate date) {
        this.nickName = nickName;
        this.id = id;
        this.date = date;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNickName() {
        return nickName;
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }
    
}
