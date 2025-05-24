package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import hust.soict.hedspi.aims.exception.*;
public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        Parent root = fxmlLoader.load();

        ViewStoreController viewStoreController = fxmlLoader.getController();
        viewStoreController.ViewStoreController(store);
        viewStoreController.setCart(cart);

        viewStoreController.loadStoreItems();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    



    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        try {
        	store.addMedia(new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 0, 14.99f));
        	store.addMedia(new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 0, 19.99f));
        	store.addMedia(new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 17.50f));
        	store.addMedia(new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 16.75f));
        	store.addMedia(new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 21.00f));
        	store.addMedia(new DigitalVideoDisc("Fight Club", "Drama", "David Fincher", 139, 15.95f));
        	store.addMedia(new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 18.49f));
        	store.addMedia(new DigitalVideoDisc("The Matrix", "Sci-Fi", "The Wachowskis", 136, 20.00f));
        	store.addMedia(new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 22.99f));
        	store.addMedia(new DigitalVideoDisc("The Pianist", "Biography", "Roman Polanski", 150, 13.99f));

        	store.addMedia(new DigitalVideoDisc("Gladiator", "Action", "Ridley Scott", 155, 15.50f));
        	store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 88, 12.00f));
        	store.addMedia(new DigitalVideoDisc("Jurassic Park", "Adventure", "Steven Spielberg", 127, 17.99f));
        	store.addMedia(new DigitalVideoDisc("The Avengers", "Action", "Joss Whedon", 143, 19.50f));
        	store.addMedia(new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 20.00f));
        	store.addMedia(new DigitalVideoDisc("Saving Private Ryan", "War", "Steven Spielberg", 169, 18.99f));
        	store.addMedia(new DigitalVideoDisc("The Social Network", "Drama", "David Fincher", 120, 14.50f));
        	store.addMedia(new DigitalVideoDisc("Guardians of the Galaxy", "Sci-Fi", "James Gunn", 121, 18.00f));
        	store.addMedia(new DigitalVideoDisc("The Departed", "Crime", "Martin Scorsese", 151, 16.00f));
        	store.addMedia(new DigitalVideoDisc("Mad Max: Fury Road", "Action", "George Miller", 120, 17.00f));

        	store.addMedia(new DigitalVideoDisc("The Wolf of Wall Street", "Biography", "Martin Scorsese", 180, 19.99f));
        	store.addMedia(new DigitalVideoDisc("La La Land", "Musical", "Damien Chazelle", 128, 15.75f));
        	store.addMedia(new DigitalVideoDisc("The Grand Budapest Hotel", "Comedy", "Wes Anderson", 99, 14.25f));
        	store.addMedia(new DigitalVideoDisc("The Prestige", "Drama", "Christopher Nolan", 130, 17.50f));
        	store.addMedia(new DigitalVideoDisc("Whiplash", "Drama", "Damien Chazelle", 106, 15.00f));
        	store.addMedia(new DigitalVideoDisc("Django Unchained", "Western", "Quentin Tarantino", 165, 18.50f));
        	store.addMedia(new DigitalVideoDisc("Avatar", "Sci-Fi", "James Cameron", 162, 21.50f));
        	store.addMedia(new DigitalVideoDisc("The Inception", "Sci-Fi", "Christopher Nolan", 148, 21.00f));
        	store.addMedia(new DigitalVideoDisc("The Silence of the Lambs", "Thriller", "Jonathan Demme", 118, 14.00f));
        	store.addMedia(new DigitalVideoDisc("Black Panther", "Action", "Ryan Coogler", 134, 18.75f));

        	store.addMedia(new DigitalVideoDisc("Spider-Man: Into the Spider-Verse", "Animation", "Bob Persichetti", 117, 16.99f));
        	store.addMedia(new DigitalVideoDisc("Coco", "Animation", "Lee Unkrich", 105, 15.50f));
        	store.addMedia(new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 14.99f));
        	store.addMedia(new DigitalVideoDisc("Joker", "Drama", "Todd Phillips", 122, 19.00f));
        	store.addMedia(new DigitalVideoDisc("Avengers: Endgame", "Action", "Anthony Russo", 181, 22.00f));
        	store.addMedia(new DigitalVideoDisc("The Lord of the Rings: The Fellowship of the Ring", "Fantasy", "Peter Jackson", 178, 19.50f));
        	store.addMedia(new DigitalVideoDisc("The Lord of the Rings: The Two Towers", "Fantasy", "Peter Jackson", 179, 19.50f));
        	store.addMedia(new DigitalVideoDisc("The Lord of the Rings: The Return of the King", "Fantasy", "Peter Jackson", 201, 19.99f));
        	store.addMedia(new DigitalVideoDisc("Harry Potter and the Sorcerer's Stone", "Fantasy", "Chris Columbus", 152, 18.00f));
        	store.addMedia(new DigitalVideoDisc("Harry Potter and the Chamber of Secrets", "Fantasy", "Chris Columbus", 161, 18.00f));

        	store.addMedia(new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban", "Fantasy", "Alfonso Cuarón", 142, 18.50f));
        	store.addMedia(new DigitalVideoDisc("Harry Potter and the Goblet of Fire", "Fantasy", "Mike Newell", 157, 18.50f));
        	store.addMedia(new DigitalVideoDisc("Harry Potter and the Order of the Phoenix", "Fantasy", "David Yates", 138, 18.99f));
        	store.addMedia(new DigitalVideoDisc("Harry Potter and the Half-Blood Prince", "Fantasy", "David Yates", 153, 18.99f));
        	store.addMedia(new DigitalVideoDisc("Harry Potter and the Deathly Hallows: Part 1", "Fantasy", "David Yates", 146, 19.99f));
        	store.addMedia(new DigitalVideoDisc("Harry Potter and the Deathly Hallows: Part 2", "Fantasy", "David Yates", 130, 19.99f));
        	store.addMedia(new DigitalVideoDisc("Star Wars: Episode IV - A New Hope", "Sci-Fi", "George Lucas", 121, 17.00f));
        	store.addMedia(new DigitalVideoDisc("Star Wars: Episode V - The Empire Strikes Back", "Sci-Fi", "Irvin Kershner", 124, 17.50f));
        	store.addMedia(new DigitalVideoDisc("Star Wars: Episode VI - Return of the Jedi", "Sci-Fi", "Richard Marquand", 131, 17.50f));
        	store.addMedia(new DigitalVideoDisc("Star Wars: The Force Awakens", "Sci-Fi", "J.J. Abrams", 138, 18.00f));
        	store.addMedia(new DigitalVideoDisc("Star Wars: The Last Jedi", "Sci-Fi", "Rian Johnson", 152, 18.00f));
        	store.addMedia(new CompactDisc(101, "Greatest Hits", "Music", 20.5f, 0, "Some Director", "Famous Artist", new Track[0]));
        	store.addMedia(new Book(101, "1984", "Dystopian", 12.50f));
        	store.addMedia(new Book(102, "To Kill a Mockingbird", "Classic", 14.00f));
        	store.addMedia(new Book(103, "Pride and Prejudice", "Romance", 11.75f));
        	store.addMedia(new Book(104, "The Great Gatsby", "Classic", 13.20f));
        	store.addMedia(new Book(105, "Moby-Dick", "Adventure", 15.90f));
        	store.addMedia(new Book(106, "The Catcher in the Rye", "Classic", 12.99f));
        	store.addMedia(new Book(107, "The Hobbit", "Fantasy", 16.50f));
        	store.addMedia(new Book(108, "War and Peace", "Historical", 18.75f));
        	store.addMedia(new Book(109, "Brave New World", "Science Fiction", 13.40f));
        	store.addMedia(new Book(110, "Jane Eyre", "Gothic", 14.60f));

        } catch (MediaAlreadyExistsException e) {
            System.err.println(e.getMessage());
        }

        launch(args);
    }
}