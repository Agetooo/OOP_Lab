package hust.soict.hedspi.test.cart;
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
            101, "Best of 2025","Pop",15.99f, 0, "DJ Future","Various Artists",trackList);


	    // Create new DVD objects and add them to the cart
	    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95);
	    anOrder.addMedia(dvd1);

	    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction", "George Lucas", 87, 24.95);
	    anOrder.addMedia(dvd2);

	    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin","Animation", 18);
	    anOrder.addMedia(dvd3);
	    
	    DigitalVideoDisc dvd4 = new DigitalVideoDisc("Natra","Animation", 19.99);
	    DigitalVideoDisc dvd5 = new DigitalVideoDisc("Avengers: Endgame","Science Fiction", 24.99);
	    DigitalVideoDisc dvd6 = new DigitalVideoDisc("Inception","Horror", 14.99);
	    anOrder.addMedia(dvd4,dvd5);
	    anOrder.addMedia(dvd6);
	    DigitalVideoDisc dvd7 =new DigitalVideoDisc("KungfuPanda","Animation", 20);
	    DigitalVideoDisc dvd8 =new DigitalVideoDisc("Interstellar","Science Fiction",40);
	    anOrder.addMedia(dvd7,dvd8);

	    // Print total cost of the items in the cart
	   
	    anOrder.printCartDetails();
	    anOrder.titlesearch("aladd");
	    
	
	    DigitalVideoDisc dvdToRemove = dvd3;
	    anOrder.removeMedia(dvdToRemove);
	    anOrder.idsearch(104);
	    
	    DigitalVideoDisc dvd9 = new DigitalVideoDisc(192,"The Matrix","Science Fiction",199,136,"The Wachowskis");
	    anOrder.addMedia(dvd9);
	    anOrder.printCartDetails();

    // Tạo một số đối tượng cụ thể (giả sử bạn đã có lớp CD, Book,... kế thừa từ Media)
    DigitalVideoDisc dvd = new DigitalVideoDisc("The Matrix", "Sci-fi", "Wachowski", 136, 19.95f);
    Book book1 = new Book("Effective Java", "Programming", 29.99f);
    book1.addAuthor("Joshua Bloch");

    mediae.add(cd);
    mediae.add(dvd);
    mediae.add(book1);

    // In ra thông tin từng media (toString() được gọi một cách đa hình)
    for (Media m : mediae) {
        System.out.println(m.toString());
    }
    cd.play();
    dvd.play();
    DigitalVideoDisc dvd10 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95);
    DigitalVideoDisc dvd11 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95);
    DigitalVideoDisc dvd12 = new DigitalVideoDisc("Aladdin", "Animation", 18.99);
    DigitalVideoDisc dvd13 = new DigitalVideoDisc("Aladdin", "Animation", 19.99);
    
    anOrder.addMedia(dvd10, dvd12, dvd13, dvd11);

    // Print original cart
    System.out.println("Original cart:");
    anOrder.printCartDetails();

    // Sort by title and print
    System.out.println("\nSorted by title (then cost):");
    anOrder.sortByTitle();
    anOrder.printCartDetails();

    // Sort by cost and print
    System.out.println("\nSorted by cost (then title):");
    anOrder.sortByCost();
    anOrder.printCartDetails();
	}
}
