/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hust.soict.dsai.aims.media;

import java.util.Comparator;

/**
 *
 * @author User
 */
public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media o1, Media o2) {
        int cos = Double.compare(o1.getCost(),o2.getCost());
        if (cos != 0 ) return cos;
        return (o1.getTitle()).compareTo(o2.getTitle());
    } 
}