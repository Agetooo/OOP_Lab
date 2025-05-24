package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.exception.PlayerException;
import javax.swing.JOptionPane;
public class Track implements Playable {
	private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
	public Track() {
		super();
	}

	@Override
	public void play() throws PlayerException {
	    if (this.getLength() > 0) {
	        System.out.println("Playing Track: " + this.getTitle());
	        System.out.println("Track length: " + this.getLength());
	    } else {
	        throw new PlayerException("ERROR: Track length is non-positive!");
	    }
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Track)) return false;
	    Track track = (Track) o;
	    return this.length == track.length &&
	           this.title.equalsIgnoreCase(track.title);
	}
}

