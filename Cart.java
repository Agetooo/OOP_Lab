
public class Cart {
	public static final int MAX_NUMMBER_ORDERED=20;
	private DigitalVideoDisc itemOrdered[] =
			new DigitalVideoDisc[MAX_NUMMBER_ORDERED];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered< MAX_NUMMBER_ORDERED) {
			itemOrdered[qtyOrdered]=disc;
			qtyOrdered++;
            System.out.println("New disc has been added: " + disc.getTitle());
        } else {
            System.out.println("The cart is full.");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
	         int index = -1;
	        for (int i=0;i<qtyOrdered;i++) {
	        	if (itemOrdered[i]==disc) {
	        		index=i;
	        		break;
	        	}
	        }
	      if (index!=-1) {
	        for (int i=index;i<qtyOrdered;i++) {
	        	itemOrdered[i]=itemOrdered[i+1];
	        }
	        itemOrdered[qtyOrdered-1]=null;
	        qtyOrdered --;
	        DigitalVideoDisc.decreaseNbDigitalVideoDiscs();
	      System.out.println("The disc has been removed: " + disc.getTitle());
	      }else {
        System.out.println("The disc was not found in the cart.");
	      }
	      displayCart();
	}
	public void totalCost() {
		double total=0;
		for (int i=0;i<qtyOrdered;i++) {
			total+=itemOrdered[i].getCost();
		}
		System.out.println("Total Cost is:  " +total);
	}
	

	public void displayCart() {
		System.out.println("\nThe cart now is ");
		for (int i=1;i<=qtyOrdered;i++) {
			DigitalVideoDisc disc = itemOrdered[i-1];
			//System.out.println( i + "%10s" + disc.getTitle()+ "%10s"+ disc.getCost() );
			System.out.printf( "%d| %20s |%10.2f\n" ,i, disc.getTitle(), disc.getCost() );
		}
	}
	//public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
	//    for (DigitalVideoDisc dvd : dvdList) {
	//        addDigitalVideoDisc(dvd);
	//    }
	//}
	  public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
	      for (DigitalVideoDisc dvd : dvds) {
	          addDigitalVideoDisc(dvd);
	       }
	  }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
           addDigitalVideoDisc(dvd1);
           addDigitalVideoDisc(dvd2);
}

	

	
}
