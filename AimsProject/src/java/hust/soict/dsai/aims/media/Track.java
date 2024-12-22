/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hust.soict.dsai.aims.media;

import java.util.Objects;

/**
 *
 * @author User
 */
public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    @Override
    public void play() {
        if (length > 0) {
            System.out.println("Playing Track: " + this.title);
            System.out.println("Track length: " + this.length);
        } else {
            System.out.println("Cannot play Track: " + this.title + " - Invalid length.");
        }
    }
    @Override
     public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
       Media other = (Media) obj;
        return super.equals(other);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.title);
        hash = 71 * hash + this.length;
        return hash;
    }
    
}