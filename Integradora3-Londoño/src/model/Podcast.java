/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DANIELA LONDOÑO
 */
public class Podcast extends Audio {
    private String description;
    private Category category;

    public Podcast(String description, int category, String name, String url, double duracion) {
        super(name, url, duracion);
        this.description = description;
        this.category = Category.values()[category];
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }
    
    
}
