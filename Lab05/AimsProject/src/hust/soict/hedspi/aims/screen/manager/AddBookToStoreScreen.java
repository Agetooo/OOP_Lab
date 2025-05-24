package hust.soict.hedspi.aims.screen.manager;
import javax.swing.*;
import hust.soict.hedspi.aims.exception.*;
import java.awt.*;
import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.media.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class AddBookToStoreScreen extends AddItemToStoreScreen  {
	ArrayList<String> authors = new ArrayList<>();
	public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book to Store");
        add(createForm(), BorderLayout.CENTER);
    }
	@Override
    public JPanel createForm() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Book Information"));

        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField costField = new JTextField();

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryField);
        inputPanel.add(new JLabel("Cost ($):"));
        inputPanel.add(costField);
        JPanel authorPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        authorPanel.setBorder(BorderFactory.createTitledBorder("Add Authors"));

        JTextField authorNameField = new JTextField();
        authorPanel.add(new JLabel("Author Name:"));
        authorPanel.add(authorNameField);

        JButton addAuthorButton = new JButton("Add Author");
        addAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String author = authorNameField.getText().trim();
                if (!author.isEmpty()) {
                    authors.add(author);
                    JOptionPane.showMessageDialog(null, "Author added: " + author);
                    authorNameField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Author name is empty.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JButton addBookButton = new JButton("Add Book to Store");
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String title = titleField.getText();
                    String category = categoryField.getText();
                    float cost = Float.parseFloat(costField.getText());

                    Book book = new Book(title, category, cost);
                    for (String author : authors) {
                        book.addAuthor(author);
                    }
                    try {
                    	store.addMedia(book);
                    } catch (MediaAlreadyExistsException q) {
                        System.err.println(q.getMessage());
                    }

                    JOptionPane.showMessageDialog(null, "Book added successfully!");
                    titleField.setText("");
                    categoryField.setText("");
                    costField.setText("");
                    authors.clear();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid cost value", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel formPanel = new JPanel(new BorderLayout());
        formPanel.add(inputPanel, BorderLayout.NORTH);
        formPanel.add(authorPanel, BorderLayout.CENTER);
        formPanel.add(addAuthorButton, BorderLayout.EAST);
        formPanel.add(addBookButton, BorderLayout.SOUTH);

        panel.add(formPanel, BorderLayout.NORTH);
        return panel;
    }
}
