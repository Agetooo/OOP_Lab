package hust.soict.hedspi.aims.media;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc() {
        super();
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist, Track[] tracks) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        // Thêm từng track vào danh sách
        for (Track track : tracks) {
            this.addTrack(track);
        }
    }

    public String getArtist() {
        return artist;
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
    public void play() throws PlayerException {
        if (this.tracks == null || this.tracks.size() == 0) {
            throw new PlayerException("ERROR: CD has no tracks to play");
        }

        StringBuilder message = new StringBuilder();
        message.append("Playing CD: ").append(this.getTitle()).append("\n");

        for (Track track : tracks) {
            try {
                track.play();
                message.append("Playing track: ").append(track.getTitle()).append("\n");
            } catch (PlayerException e) {
                message.append("Error playing track: ").append(track.getTitle()).append("\n");
                message.append("   → ").append(e.getMessage()).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, message.toString(), "CD Playback", JOptionPane.INFORMATION_MESSAGE);
    }



    @Override
    public String toString() {
        return "ID - " + getId() + " CompactDisc - " + getTitle() + " - " + getCategory() + " - " + getArtist() + " : " + getCost() + " $";
    }
}
