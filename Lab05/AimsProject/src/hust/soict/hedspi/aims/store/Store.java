package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;
import hust.soict.hedspi.aims.exception.*;
public class Store {

    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
   

    public void addMedia(Media media) throws MediaAlreadyExistsException {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("New disc has been added to store: " + media.getTitle());
        } else {
            throw new MediaAlreadyExistsException("ERROR: Media already exists in store: " + media.getTitle());
        }
    }

    public void removeMedia(Media media) throws MediaNotFoundException {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The disc has been removed: " + media.getTitle());
        } else {
            throw new MediaNotFoundException("ERROR: Media not found in store: " + media.getTitle());
        }
    }

    public void printStore() {
        int i = 1;
        for (Media media : itemsInStore) {
            System.out.println(i + ". " + media.toString());
            i++;
        }
    }

    public void titlesearch(String title) {
        boolean found = false;
        for (Media media : itemsInStore) {
            if (media.isMatch(title)) {
                System.out.println("Found disc: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Not found");
    }

    public Media findMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title.trim())) {
                return media;
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
