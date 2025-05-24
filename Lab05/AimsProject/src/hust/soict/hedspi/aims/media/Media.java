package hust.soict.hedspi.aims.media;
public abstract class Media implements Comparable<Media> {
	public int id;
	public String title;
	public String category;
	public double cost;

	public Media() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}
	
	public double getCost() {
		return cost;
	}

	public Media(int id, String title, String category, double cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public Media(String title, String category, double cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public Media(String title) {
		this.title = title;;
	 }
	public boolean isMatch(String title) {
	    return this.title != null && this.title.equalsIgnoreCase(title);
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;
        Media other = (Media) o;
        if (this.title == null || other.title == null) {
            return false;
        }
        return this.title.equalsIgnoreCase(other.title) && this.cost == other.cost;
    }

    @Override
    public int compareTo(Media other) {
        if (other == null) {
            throw new NullPointerException("So sánh với đối tượng null");
        }
        int titleCompare = this.title.compareToIgnoreCase(other.title);
        if (titleCompare != 0) {
            return titleCompare;
        }
        return Double.compare(this.cost, other.cost);
    }
}
