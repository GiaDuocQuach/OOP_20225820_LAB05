package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
    public static int maxDvdInStore=100;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    private static int qtyAvailable = 0;
    public void addMedia(Media media) {
        if (qtyAvailable < maxDvdInStore) {
            itemsInStore.add(media);
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The store is almost full.");
        }
    }
    public void removeMedia(Media media) {
        if(itemsInStore.remove(media)){
            System.out.println("Removed from cart: " + media.getTitle());
        } else {
            System.out.println("Media not found in cart.");
        }
    }
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (title.equals(media.getTitle())) {
                return media;
            }
        }
        System.out.println("No match is found!"); 
        return null;
    }

    public ArrayList<Media> getItemInStore() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}