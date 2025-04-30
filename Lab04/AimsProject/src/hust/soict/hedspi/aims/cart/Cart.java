package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.*;
import java.util.Scanner;
import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.media.comparator.*;
import java.util.ArrayList;
import java.util.Collections;
public class Cart {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>(); 
	public void addMedia(Media media) {
		if(!itemsOrdered.contains(media)) {
			itemsOrdered.add(media);
			System.out.println("Added "+ media.getTitle() );
		}
		else {
		System.out.println("Item already in cart!!");		
		}
	}
	public void addMedia(Media media, Store store) {
	    Scanner sc = new Scanner(System.in);

	    Media storeMedia = store.findMediaByTitle(media.getTitle());

	    // Nếu chưa tìm thấy media trong store, yêu cầu người dùng nhập lại
	    while (storeMedia == null) {
	        System.out.println("This item does not exist in the store. Please enter another title:");
	        String newTitle = sc.nextLine();
	        storeMedia = store.findMediaByTitle(newTitle);
	    }

	    // Kiểm tra media đã tồn tại trong giỏ chưa
	    for (Media item : itemsOrdered) {
	        if (item.getTitle().equalsIgnoreCase(storeMedia.getTitle())) {
	            System.out.println("Item already in cart!!");
	            return;
	        }
	    }

	    // Thêm vào giỏ hàng
	    itemsOrdered.add(storeMedia);
	    System.out.println("Added " + storeMedia.getTitle());
	}

	public void removeMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("Removed: " + media.getTitle());
	    } else {
	        System.out.println("Item not found in cart: " + media.getTitle());
	    }
	}
	public double totalCost() {
		double total=0;
		for (Media media: itemsOrdered) {
			total+=media.getCost();
		}
		return total;
	}
	public void printCartDetails() {
	    System.out.println("***********************CART***********************");
	    System.out.println("Ordered Items:");
	    int i=1;
	    for (Media media: itemsOrdered) {
	        System.out.println(i  + ". " + media.toString());
	        i++;
	    }
	    System.out.printf("Total cost: %.2f $\n", totalCost());
	    System.out.println("***************************************************");
	}

	public void idsearch(int id) {
		int found=0;
		for(Media media: itemsOrdered) {
			if (media.getId() == id) {
				System.out.println("Found disc" + media.toString());
				found=1;
				break;
			}
		}
		if(found==0) System.out.println("Not found");
	}
	public void titlesearch(String title) {
		int found=0;
		for(Media media: itemsOrdered) {
			if (media.isMatch(title)) {
				System.out.println("Found disc" + media.toString());
				found=1;
				break;
			}
		}
		if(found==0) System.out.println("Not found");
	}
	//public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
	//    for (DigitalVideoDisc dvd : dvdList) {
	//        addDigitalVideoDisc(dvd);
	//    }
	//}
	  
    public void addMedia(Media media1, Media media2) {
    	   addMedia(media1);
    	   addMedia(media2);
}
    public void addMedia(Media media1, Media media2,Media media3, Media media4) {
 	   addMedia(media1);
 	   addMedia(media2);
 	   addMedia(media3);
 	   addMedia(media4);
}
    public void sortByTitle() {
        Collections.sort(itemsOrdered, new MediaTitleCostComparator());
    }
    public void sortByCost() {
        Collections.sort(itemsOrdered, new MediaCostTitleComparator());
    }
    public void clear() {
        itemsOrdered.clear();
        System.out.println("The cart has been emptied.");
    }
    public Media findMediaByTitle(String title) {
	    for (Media media : itemsOrdered) {
	        if (media.getTitle().equalsIgnoreCase(title.trim())) {
	            return media;
	        }
	    }
	    return null; 
	}
    public void removeMediaByTitle(String title) {
        Media media = findMediaByTitle(title);
        if (media != null) {
            removeMedia(media); 
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Media with title \"" + title + "\" not found in cart.");
        }
    }
    public void filterByTitle(String title) {
        boolean found = false;
        System.out.println("Filtering by title: \"" + title + "\"");
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase().trim())) {
                System.out.println(media.toString()); 
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title containing \"" + title + "\"");
        }
    }
    public void filterById(int id) {
        boolean found = false;
        System.out.println("Filtering by ID: " + id);
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media.toString()); 
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with ID = " + id);
        }
    }




	
}
