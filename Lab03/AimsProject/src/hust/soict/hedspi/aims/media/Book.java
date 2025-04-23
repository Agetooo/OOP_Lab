package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media{

 
    private ArrayList<String> authors = new ArrayList<>();

    public Book() {
        super();
    }
    public Book(String title) {
        super(title);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }else {
            System.out.println("Author already exists.");
        }
    }

    public void removeAuthor(String authorName) {
    	if(authors.contains(authorName)) authors.remove(authorName); 
    else {
        System.out.println("Author not found.");
    }
    }
    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - " + authors + ": " + getCost() + "$";
    }

}
