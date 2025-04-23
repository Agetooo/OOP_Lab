package hust.soict.hedspi.aims.media.comparator;

import hust.soict.hedspi.aims.media.Media;
import java.util.Comparator;

public class MediaCostTitleComparator implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        int costComparison = Double.compare(media2.getCost(), media1.getCost()); // Higher cost first
        if (costComparison != 0) {
            return costComparison;
        }
        return media1.getTitle().compareToIgnoreCase(media2.getTitle());
    }
}