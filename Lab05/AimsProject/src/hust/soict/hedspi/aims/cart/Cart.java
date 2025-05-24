package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.exception.*;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.media.comparator.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.Scanner;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("ERROR: The number of media has reached its limit.");
        }
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Added: " + media.getTitle());
        } else {
            System.out.println("Item already in cart!!");
        }
    }

    public void addMedia(Media media, Store store) throws Exception {
        Scanner sc = new Scanner(System.in);
        Media storeMedia = store.findMediaByTitle(media.getTitle());

        int attempts = 0;
        while (storeMedia == null && attempts < 3) {
            System.out.println("This item does not exist in the store. Please enter another title:");
            String newTitle = sc.nextLine();
            storeMedia = store.findMediaByTitle(newTitle);
            attempts++;
        }

        if (storeMedia == null) {
            throw new Exception("Failed to find media in store after 3 attempts.");
        }

        if (itemsOrdered.contains(storeMedia)) {
            throw new Exception("Item already in cart!");
        }

        addMedia(storeMedia);
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Item not found in cart: " + media.getTitle());
        }
    }

    public double totalCost() {
        double total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void printCartDetails() {
        try {
            System.out.println("***********************CART***********************");
            System.out.println("Ordered Items:");
            int i = 1;
            for (Media media : itemsOrdered) {
                System.out.println(i + ". " + media.toString());
                i++;
            }
            System.out.printf("Total cost: %.2f $\n", totalCost());
            System.out.println("***************************************************");
        } catch (Exception e) {
            System.err.println("Error printing cart: " + e.getMessage());
        }
    }

    public void idsearch(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found: " + media);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Not found");
    }

    public void titlesearch(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Found: " + media);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Not found");
    }

    public void addMedia(Media media1, Media media2) throws LimitExceededException {
        addMedia(media1);
        addMedia(media2);
    }

    public void addMedia(Media media1, Media media2, Media media3, Media media4) throws LimitExceededException {
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
        try {
            Media media = findMediaByTitle(title);
            if (media != null) {
                removeMedia(media);
            } else {
                throw new NullPointerException("Media with title \"" + title + "\" not found.");
            }
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
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
