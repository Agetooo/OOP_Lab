package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	private int length;
	private String director;
	public Disc() {
		super();
	}
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	public Disc(int id, String title, String category, float cost,int length, String director) {
		super(id,title,category,cost);
		this.length = length;
		this.director = director;
	}
	 public Disc(String title, String category, double cost) {
	        super(title, category, cost);
	    }
	 public Disc(String title) {
		 super(title);
	 }
	 public Disc(int id, String title, String category, float cost) {
	        super(id, title, category, cost);
	   }
	
	

}
