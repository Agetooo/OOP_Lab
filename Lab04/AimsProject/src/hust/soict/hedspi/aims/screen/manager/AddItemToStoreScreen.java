package hust.soict.hedspi.aims.screen.manager;
import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.store.*;
public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        setLayout(new BorderLayout());
        add(createNorth(), BorderLayout.NORTH);
        setSize(1024, 768);
        setVisible(true);
    }

    public JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(new StoreManagerScreen(store).createMenuBar());
        return north;
    }

    public abstract JPanel createForm();  
}
