
public class DigitalVideoDisc {
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	private String title;
	private String category;
	private String director;
	private int length;
	private double cost;
	

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	public double getCost() {
		return cost;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		assignID();
	}

	public DigitalVideoDisc(String title, String category, double cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		assignID();
	}

	public DigitalVideoDisc(String title, String category, String director, double cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		assignID();
	}

	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		assignID();
	}
	public void assignID() {
		nbDigitalVideoDiscs++;
	   this.id= 100+nbDigitalVideoDiscs;
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

	public int getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	}
	
