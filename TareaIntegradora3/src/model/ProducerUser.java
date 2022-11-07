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
public class ProducerUser extends User {
    private String url;
 

    public ProducerUser(String url, String nickName, String id, LocalDate date) {
        super(nickName, id, date);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }
 
}
