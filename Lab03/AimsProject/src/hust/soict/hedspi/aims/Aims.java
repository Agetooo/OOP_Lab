package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.*;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void main(String[] args) {
    	Media dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95);
        store.addMedia(dvd1);

        Media dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction", "George Lucas", 87, 24.95);
        store.addMedia(dvd2);

        Media dvd3 = new DigitalVideoDisc("Aladdin","Animation", 18);
        store.addMedia(dvd3);
        
        Media dvd4 = new DigitalVideoDisc("Natra","Animation", 19.99);
        Media dvd5 = new DigitalVideoDisc("Avengers: Endgame","Science Fiction", 24.99);
        Media dvd6 = new DigitalVideoDisc("Inception","Horror", 14.99);
        store.addMedia(dvd4);
        store.addMedia(dvd5);
        store.addMedia(dvd6);
        Media dvd7 =new DigitalVideoDisc("KungfuPanda","Animation", 20);
        Media dvd8 =new DigitalVideoDisc("Interstellar","Science Fiction",40);
        store.addMedia(dvd7);
        store.addMedia(dvd8);
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    viewCart();
                    break;
                case 0:
                    System.out.println("Exiting AIMS...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void viewStore() {
    	
        while (true) {
            store.printStore();
            storeMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter media title: ");
                    String title = scanner.nextLine();
                    store.titlesearch(title);
                    break;
                case 2:
                    Scanner sc = new Scanner(System.in);

                    System.out.println("Enter the title of the media you want to add to cart:");
                    String title1 = sc.nextLine();
                    Media mediaToAdd = store.findMediaByTitle(title1);
                    cart.addMedia(new DigitalVideoDisc(title1), store); 

                    break;
                case 3:
                    System.out.print("Enter media title to play: ");
                    title = scanner.nextLine();
                    Media media = store.findMediaByTitle(title);
                    if (media instanceof Playable) ((Playable) media).play();
                    else System.out.println("Cannot play this media.");
                    break;
                case 4:
                    viewCart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void updateStore() {
        System.out.println("1. Add media\n2. Remove media");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            System.out.println("Choose media type to add:");
            System.out.println("1. DigitalVideoDisc");
            System.out.println("2. Book");
            System.out.println("3. CompactDisc");
            int mediaChoice = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter id: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter category: ");
            String category = scanner.nextLine();
            System.out.print("Enter cost: ");
            float cost = Float.parseFloat(scanner.nextLine());

            if (mediaChoice == 1) {  
                System.out.print("Enter length: ");
                int length = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter director: ");
                String director = scanner.nextLine();
                DigitalVideoDisc med = new DigitalVideoDisc(id, title, category, cost, length, director);
                store.addMedia(med);
            } else if (mediaChoice == 2) {  
                System.out.print("Enter author(s): ");
                String author = scanner.nextLine();
                Media med = new Book(id, title, category, cost);
                ((Book) med).addAuthor(author);  
                store.addMedia(med);
            } else if (mediaChoice == 3) { 
                System.out.print("Enter director: ");
                String director = scanner.nextLine();
                System.out.print("Enter artist: ");
                String artist = scanner.nextLine();
                System.out.print("Enter number of tracks: ");
                int numTracks = Integer.parseInt(scanner.nextLine());
                Track[] tracks = new Track[numTracks];
                for (int i = 0; i < numTracks; i++) {
                    System.out.print("Enter track " + (i + 1) + " title: ");
                    String trackTitle = scanner.nextLine();
                    System.out.print("Enter track " + (i + 1) + " length: ");
                    int trackLength = Integer.parseInt(scanner.nextLine());
                    tracks[i] = new Track(trackTitle, trackLength);
                }
                int length =0;
                Media med = new CompactDisc(id, title, category, cost, length, director, artist, tracks);
                store.addMedia(med);
            } else {
                System.out.println("Invalid choice!");
            }

        } else if (choice == 2) {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine();
            Media media = store.findMediaByTitle(title);
            if (media != null) {
                store.removeMedia(media);
                System.out.println("Removed.");
            } else {
                System.out.println("Media not found.");
            }
        }
    }



    private static void viewCart() {
        while (true) {
            cart.printCartDetails();
            cartMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Filter by: 1. ID | 2. Title");
                    int filter = Integer.parseInt(scanner.nextLine());
                    if (filter == 1) {
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        cart.filterById(id);
                    } else {
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        cart.filterByTitle(title);
                    }
                    break;
                case 2:
                    System.out.println("Sort by: 1. Title | 2. Cost");
                    int sort = Integer.parseInt(scanner.nextLine());
                    if (sort == 1) cart.sortByTitle();
                    else cart.sortByCost();
                    break;
                case 3:
                    System.out.print("Enter title to remove: ");
                    String title = scanner.nextLine();
                    cart.removeMediaByTitle(title);
                    break;
                case 4:
                    System.out.print("Enter title to play: ");
                    String t = scanner.nextLine();
                    Media m = cart.findMediaByTitle(t);
                    if (m instanceof Playable) ((Playable) m).play();
                    else System.out.println("Cannot play this media.");
                    break;
                case 5:
                    System.out.println("Order placed!");
                    cart.clear();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
