package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public void addMedia(Media media) {
		if (!itemsInStore.contains(media)) {
			itemsInStore.add(media);
		System.out.println("New disc has been added to store: " + media.getTitle());
		}
		else {
		System.out.println("Already in store");
		}
	}
	public void removeMedia(Media media) {
		if(itemsInStore.contains(media)) {
			itemsInStore.remove(media);
		    System.out.println("The disc has been removed: " + media.getTitle());
              }else {
            System.out.println("The disc was not found in the store.");
    }
	}
	public void printStore() {
		int i=1;
		for (Media media : itemsInStore) {
			System.out.println(i  + ". " + media.toString());
			i++;
			}
	}
	public void titlesearch(String title) {
		int found=0;
		for(Media media: itemsInStore) {
			if (media.isMatch(title)) {
				System.out.println("Found disc" + media.toString());
				found=1;
				break;
			}
		}
		if(found==0) System.out.println("Not found");
	}
	public Media findMediaByTitle(String title) {
	    for (Media media : itemsInStore) {
	        if (media.getTitle().equalsIgnoreCase(title.trim())) {
	            return media;
	        }
	    }
	    return null; 
	}
}

