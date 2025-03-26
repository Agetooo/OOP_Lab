
public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart anOrder = new Cart();

	    // Create new DVD objects and add them to the cart
	    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95);
	    anOrder.addDigitalVideoDisc(dvd1);

	    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction", "George Lucas", 87, 24.95);
	    anOrder.addDigitalVideoDisc(dvd2);

	    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin","Animation", 18);
	    anOrder.addDigitalVideoDisc(dvd3);
	    
	    DigitalVideoDisc dvd4 = new DigitalVideoDisc("Natra","Animation", 19.99);
	    DigitalVideoDisc dvd5 = new DigitalVideoDisc("Avengers: Endgame","Science Fiction", 24.99);
	    DigitalVideoDisc dvd6 = new DigitalVideoDisc("Inception","Horror", 14.99);
	    
	    DigitalVideoDisc[] dvdarray = {dvd4,dvd5,dvd6};
	    anOrder.addDigitalVideoDisc( dvdarray );
	    
	    DigitalVideoDisc dvd7 =new DigitalVideoDisc("KungfuPanda","Animation", 20);
	    DigitalVideoDisc dvd8 =new DigitalVideoDisc("Interstellar","Science Fiction",40);
	    anOrder.addDigitalVideoDisc(dvd7,dvd8);

	    // Print total cost of the items in the cart
	    anOrder.displayCart();
	    anOrder.totalCost();
	    DigitalVideoDisc.displayNumber();
	    
	
	    DigitalVideoDisc dvdToRemove = dvd3;
	    anOrder.removeDigitalVideoDisc(dvdToRemove);
	    anOrder.totalCost();
	    DigitalVideoDisc.displayNumber();

	}

	}

