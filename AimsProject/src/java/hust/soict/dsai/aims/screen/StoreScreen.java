package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

import java.awt.event.*;

public class StoreScreen extends JFrame {
    private Store store;
    
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // Method to create a menu bar
JMenuBar createMenuBar() {
    // Create the main menu named "Options"
    JMenu menu = new JMenu("Options");

    // Create a submenu "Update Store" with three options
    JMenu smUpdateStore = new JMenu("Update Store");
    smUpdateStore.add(new JMenuItem("Add Book")); // Add a book option
    smUpdateStore.add(new JMenuItem("Add CD"));   // Add a CD option
    smUpdateStore.add(new JMenuItem("Add DVD"));  // Add a DVD option

    // Add the submenu to the main menu
    menu.add(smUpdateStore);
    menu.add(new JMenuItem("View store")); // Add "View store" menu item
    menu.add(new JMenuItem("View cart"));  // Add "View cart" menu item

    // Create a menu bar
    JMenuBar menuBar = new JMenuBar();
    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT)); // Set layout to align left
    menuBar.add(menu); // Add the main menu to the menu bar

    return menuBar; // Return the constructed menu bar
}


    
JPanel createHeader() {
    JPanel header = new JPanel();
    header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

    JLabel title = new JLabel("AIMS");
    title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
    title.setForeground(Color.CYAN);

    JButton cart = new JButton("View cart");
    cart.setPreferredSize(new Dimension(100, 50));
    cart.setMaximumSize(new Dimension(100, 50));

    header.add(Box.createRigidArea(new Dimension(10, 10)));
    header.add(title);
    header.add(Box.createHorizontalGlue());
    header.add(cart);
    header.add(Box.createRigidArea(new Dimension(10, 10)));

    return header;
}

    
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemInStore();
        for (int i = 0; i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        container.add(new JButton("Add to cart"));
        if (media instanceof Playable) {
            container.add(new JButton("Play"));
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}


    public StoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main (String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
            "Animation","Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
            "Science Fiction","George Lucas", 87, 24.95f);
        store.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
            "Animation", 18.99f);
        store.addMedia(dvd3);

CompactDisc cd1 = new CompactDisc("Baby One More Time", "Pop", 15.99f);

        Track track1 = new Track("Baby One More Time", 3);
        Track track2 = new Track("You Drive Me Crazy", 3);
        Track track3 = new Track("Sometimes", 3);
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        cd1.addTrack(track3);
        store.addMedia(cd1);

        Book book1 = new Book(1, "Harry Potter", "Fantasy", 20f);
        store.addMedia(book1);
        Book book2 = new Book(2, "Deezer", "Action", 69f);
        store.addMedia(book2);
        new StoreScreen(store);
        
    }

}
