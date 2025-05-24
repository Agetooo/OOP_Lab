package hust.soict.hedspi.aims.screen.manager;
import javax.swing.*;
import hust.soict.hedspi.aims.exception.*;
import java.awt.*;
import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.media.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        add(createForm(), BorderLayout.CENTER);
    }

    @Override
    public JPanel createForm() {
        JPanel panel = new JPanel(new GridLayout(0, 2));
        JTextField IdField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField directorField = new JTextField();
        JTextField lengthField = new JTextField();
        JTextField costField = new JTextField();
        panel.add(new JLabel("Id: "));
        panel.add(IdField);
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Director:"));
        panel.add(directorField);
        panel.add(new JLabel("Length:"));
        panel.add(lengthField);
        panel.add(new JLabel("Cost:"));
        panel.add(costField);

        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                	int id=Integer.parseInt(IdField.getText());
                    String title = titleField.getText();
                    String category = categoryField.getText();
                    String director = directorField.getText();
                    int length = Integer.parseInt(lengthField.getText());
                    float cost = Float.parseFloat(costField.getText());

                    DigitalVideoDisc dvd = new DigitalVideoDisc(id,title, category, cost, length, director);
                    try {
                    	store.addMedia(dvd);
                    } catch (MediaAlreadyExistsException q) {
                        System.err.println(q.getMessage());
                    }

                    JOptionPane.showMessageDialog(null, "DVD added successfully!");
                    IdField.setText("");
                    titleField.setText("");
                    categoryField.setText("");
                    directorField.setText("");
                    lengthField.setText("");
                    costField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input for id or length or cost", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(addButton);
        return panel;
    }
}

