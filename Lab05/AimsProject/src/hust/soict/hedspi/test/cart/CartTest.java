package hust.soict.hedspi.test.cart;
import hust.soict.hedspi.aims.exception.*;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;

import java.util.ArrayList;
import java.util.List;

public class CartTest {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        List<Media> mediae = new ArrayList<Media>();

        Track track1 = new Track("Song 1", 4);
        Track track2 = new Track("Song 2", 5);
        Track track3 = new Track("Song 3", 6);
        Track[] trackList = {track1, track2, track3};

        CompactDisc cd = new CompactDisc(
                101, "Best of 2025", "Pop", 15.99f, 0,
                "DJ Future", "Various Artists", trackList);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Natra", "Animation", 19.99);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Avengers: Endgame", "Science Fiction", 24.99);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Inception", "Horror", 14.99);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("KungfuPanda", "Animation", 20);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc("Interstellar", "Science Fiction", 40);

        try {
            anOrder.addMedia(dvd4, dvd5);
            anOrder.addMedia(dvd6, dvd3);
            anOrder.addMedia(dvd1, dvd2);
            anOrder.addMedia(dvd7, dvd8);
        } catch (LimitExceededException e) {
            System.err.println("Cannot add media to cart: " + e.getMessage());
        }

        anOrder.printCartDetails();
        anOrder.titlesearch("aladd");

        DigitalVideoDisc dvdToRemove = dvd3;
        anOrder.removeMedia(dvdToRemove);
        anOrder.idsearch(104);
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Matrix", "Sci-fi", "Wachowski", 136, 19.95f);
        Book book1 = new Book("Effective Java", "Programming", 29.99f);
        book1.addAuthor("Joshua Bloch");

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book1);

        for (Media m : mediae) {
            System.out.println(m.toString());
        }

        try {
            cd.play();
            dvd.play();
        } catch (Exception e) {
            System.err.println("Error during play: " + e.getMessage());
        }

        DigitalVideoDisc dvd10 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95);
        DigitalVideoDisc dvd11 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95);
        DigitalVideoDisc dvd12 = new DigitalVideoDisc("Aladdin", "Animation", 18.99);
        DigitalVideoDisc dvd13 = new DigitalVideoDisc("Aladdin", "Animation", 19.99);

        try {
            anOrder.addMedia(dvd10, dvd12, dvd13, dvd11);
        } catch (LimitExceededException e) {
            System.err.println("Cannot add more media: " + e.getMessage());
        }

        System.out.println("Original cart:");
        anOrder.printCartDetails();

        System.out.println("\nSorted by title (then cost):");
        anOrder.sortByTitle();
        anOrder.printCartDetails();

        System.out.println("\nSorted by cost (then title):");
        anOrder.sortByCost();
        anOrder.printCartDetails();
    }
}
