/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hust.soict.dsai.test.disc.TestPassingParameter;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

/**
 *
 * @author User
 */
public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD =new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD =new DigitalVideoDisc("Cinderella");
        
        swap(jungleDVD,cinderellaDVD);
        System.out.println("jungle dvd title: "+ jungleDVD.getTitle());
        System.out.println("cinderella dvd title: "+ cinderellaDVD.getTitle());
        
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("junggle dvd title: "+jungleDVD.getTitle());      
    }
    
//    public static void swap(Object o1,Object o2) {
//      Object tmp =o1;
//      o1=o2;
//      o2=tmp;
//    }
    /*cách giải quyết swap
    */
    public static void swap(DigitalVideoDisc...dvds){
        if(dvds.length==2){
            DigitalVideoDisc temp =dvds[0];
            dvds[0]=dvds[1];
            dvds[1]=temp;
        }
    }
    public static void changeTitle(DigitalVideoDisc dvd,String title) {
       String oldTitle =dvd.getTitle();
       dvd.setTitle(title);
       dvd =new DigitalVideoDisc(oldTitle);
    }
}
