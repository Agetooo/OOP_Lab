package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.exception.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private ArrayList<Track> trackList = new ArrayList<>();

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD to Store");
        add(createForm(), BorderLayout.CENTER);
    }

    @Override
    public JPanel createForm() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("CD Information"));
        JTextField IdField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField costField = new JTextField();
        JTextField directorField = new JTextField();
        JTextField artistField = new JTextField();
        inputPanel.add(new JLabel("Id:"));
        inputPanel.add(IdField);
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryField);
        inputPanel.add(new JLabel("Director:"));
        inputPanel.add(directorField);
        inputPanel.add(new JLabel("Artist:"));
        inputPanel.add(artistField);
        inputPanel.add(new JLabel("Cost:"));
        inputPanel.add(costField);

        JPanel trackPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        trackPanel.setBorder(BorderFactory.createTitledBorder("Add Tracks"));

        JTextField trackTitleField = new JTextField();
        JTextField trackLengthField = new JTextField();

        trackPanel.add(new JLabel("Track Title:"));
        trackPanel.add(trackTitleField);
        trackPanel.add(new JLabel("Track Length (mins):"));
        trackPanel.add(trackLengthField);

        JButton addTrackButton = new JButton("Add Track");
        addTrackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trackTitle = trackTitleField.getText();
                int trackLength;

                try {
                    trackLength = Integer.parseInt(trackLengthField.getText());
                    Track track = new Track(trackTitle, trackLength);
                    trackList.add(track);

                    JOptionPane.showMessageDialog(null, "Track added: " + trackTitle);
                    trackTitleField.setText("");
                    trackLengthField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid track length", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

      
        JButton addCDButton = new JButton("Add CD to Store");
        addCDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                	int id = Integer.parseInt(IdField.getText());
                    String title = titleField.getText();
                    String category = categoryField.getText();
                    String director = directorField.getText();
                    String artist = artistField.getText();
                    float cost = Float.parseFloat(costField.getText());

                    Track[] tracksArray = new Track[trackList.size()];
                    trackList.toArray(tracksArray);

                    CompactDisc cd = new CompactDisc(id, title, category, cost, 0, director, artist, tracksArray);
                    try {
                    	store.addMedia(cd);
                    } catch (MediaAlreadyExistsException q) {
                        System.err.println(q.getMessage());
                    }

                    JOptionPane.showMessageDialog(null, "CD added successfully!");
                    titleField.setText("");
                    categoryField.setText("");
                    costField.setText("");
                    directorField.setText("");
                    artistField.setText("");
                    trackList.clear();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input for id or length or cost", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel trackControlPanel = new JPanel();
        trackControlPanel.setLayout(new BorderLayout());
        trackControlPanel.add(trackPanel, BorderLayout.CENTER);
        trackControlPanel.add(addTrackButton, BorderLayout.SOUTH);

        JPanel formPanel = new JPanel(new BorderLayout());
        formPanel.add(inputPanel, BorderLayout.NORTH);
        formPanel.add(trackControlPanel, BorderLayout.CENTER);
        formPanel.add(addCDButton, BorderLayout.SOUTH);

        panel.add(formPanel, BorderLayout.NORTH);
        return panel;
    }
}
