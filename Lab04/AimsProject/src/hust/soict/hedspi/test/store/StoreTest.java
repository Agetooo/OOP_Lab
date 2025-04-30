package hust.soict.hedspi.test.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
public class StoreTest {
	public static void main(String[] args) {
	   Store List = new Store();

       DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95);
       List.addMedia(dvd1);

       DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction", "George Lucas", 87, 24.95);
       List.addMedia(dvd2);

       DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin","Animation", 18);
       List.addMedia(dvd3);
       List.printStore();
       
       List.addMedia(dvd3);
       List.printStore();
       
}
	
}
