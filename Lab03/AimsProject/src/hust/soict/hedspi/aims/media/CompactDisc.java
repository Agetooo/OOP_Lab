package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
	public CompactDisc() {
		super();
	}
	public String getArtist() {
		return artist;
	}
	public CompactDisc(int id, String title, String category, float cost,int length, String director,String artist, Track[] tracks) {
		super(id,title,category,cost,length,director);
		this.artist = artist;
		 for (Track track : tracks) {
		        this.addTrack(track);
		 }
	}
    public void addTrack(Track track) {
	        if (!tracks.contains(track)) {
	            tracks.add(track);
	        } else {
	            System.out.println("Track " + track.getTitle() + " already exists in the CD.");
	        }
	    }

	public void removeTrack(Track track) {
	        if (tracks.contains(track)) {
	            tracks.remove(track);
	        } else {
	            System.out.println("Track " + track.getTitle() + " does not exist in the CD.");
	        }
	    }

	    @Override
	public int getLength() {
	        int totalLength = 0;
	        for (Track track : tracks) {
	            totalLength += track.getLength();
	        }
	        return totalLength;
	    }
	    @Override
	    public void play() {
	        System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
	        System.out.println("CD length: " + this.getLength());
	        for (Track track : tracks) {
	            track.play(); 
	        }
	    }
	    @Override
	    public String toString() {
	        return "CompactDisc - " + getTitle() + " - " + getCategory() + " - " + getArtist() + " : " + getCost() + " $";
	    }

}

