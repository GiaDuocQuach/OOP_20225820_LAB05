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
public class CompactDisc extends Disc implements Playable{
     private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(String artist, ArrayList<Track> tracks, String title, String category, float cost, int length, String director) {
        super(title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    
   
    public CompactDisc(String artist, ArrayList<Track> tracks, String title, String category, float cost) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String artist, ArrayList<Track> tracks, String title) {
        super(title);
        this.artist = artist;
        this.tracks = tracks;
    }

  

  

 
    public String getArtist() {
        return artist;
    }
    
     public CompactDisc(String title, String category, float cost, String artist, ArrayList<Track> tracks) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String title, String artist, ArrayList<Track> tracks) {
        super(title);
        this.artist = artist;
        this.tracks = tracks;
    }
        // Add track
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track already exists in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Track added successfully.");
        }
    }

    // Remove track
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed successfully.");
        } else {
            System.out.println("Track not found in the CD.");
        }
    }

    // Get total length of the CD
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play(){
        for(Track track : tracks){
            track.play();
        }
    }

    public Iterable<Track> getTracks() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
