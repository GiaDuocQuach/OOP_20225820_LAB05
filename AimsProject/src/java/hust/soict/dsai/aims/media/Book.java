/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hust.soict.dsai.aims.media;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Book extends Media{
    

    private ArrayList<String> authors = new ArrayList<String>();
    private static int nbBook = 0;
    public Book(int par, String title, String category, float cost) {
        super(title, category, cost);
        nbBook++;
        setId(nbBook);
        this.authors=authors;
    }



    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

   
    
     public void addAuthor(String authorName) {
        for (String author : authors){
            if (author.equals(authorName)){
               
                System.out.println("Error, cannot add authorname!");
            }
        }
        authors.add(authorName);
    }
    public void removeAuthor(String authorName) {
        for (String author : authors){
            if (author.equals(authorName)){
                authors.remove(authorName);
                System.out.println("Remove success!");
            }
        }
       authors.add(authorName);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
