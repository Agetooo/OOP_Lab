package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.exception.PlayerException;
import javax.swing.JOptionPane;
public class DigitalVideoDisc extends Disc implements Playable{
	private static int nbDigitalVideoDiscs = 0;
	private String director;
	private int length;
	
	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}
	public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

	 public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
	        super(title, category, cost);
	        this.director = director;
	        this.length = length;
	        assignID();
	    }
	 public DigitalVideoDisc(int id, String title, String category, float cost) {
	        super(id, title, category, cost);
	    }

	public DigitalVideoDisc(String title, String category, double cost) {
		super(title,category,cost);
		assignID();
	}

	public DigitalVideoDisc(String title, String category, String director, double cost) {
		super(title,category,cost);
		this.director = director;
		assignID();
	}

	public DigitalVideoDisc(String title) {
		super(title);
		assignID();
	}
	public void assignID() {
		nbDigitalVideoDiscs++;
	   this.id= nbDigitalVideoDiscs +100;
	}
	
	 public static void decreaseNbDigitalVideoDiscs() {
	        if (nbDigitalVideoDiscs > 0) {
	            nbDigitalVideoDiscs--;
	        }
	    }
	 public static int getNbDigitalVideoDiscs() {
	        return nbDigitalVideoDiscs;
	    }
	 public static void displayNumber() {
	        System.out.println("\nNumber of orders now is: " + getNbDigitalVideoDiscs());
	    }


	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
	    return " ID - " + id + " - DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
	}

	public boolean isMatch(String title) {
	    return this.title != null && this.title.equalsIgnoreCase(title);
	}

	@Override
	public void play() throws PlayerException {
	    if (this.getLength() <= 0) {
	        throw new PlayerException("ERROR: DVD length is non-positive!");
	    }

	    System.out.println("Playing DVD: " + this.getTitle());
	    System.out.println("Length: " + this.getLength());
	}
}

	
