package hust.soict.hedspi.aims.media.comparator;

import hust.soict.hedspi.aims.media.Media;
import java.util.Comparator;

public class MediaTitleCostComparator implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        int titleComparison = media1.getTitle().compareToIgnoreCase(media2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        return Double.compare(media2.getCost(), media1.getCost()); 
    }
}