package hust.soict.hedspi.aims.screen.customer.controller;
import hust.soict.hedspi.aims.exception.*;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import hust.soict.hedspi.aims.exception.PlayerException;
public class ItemController {
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    private Media media;
    private Cart cart;

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
    	try {
    	    cart.addMedia(media);
    	} catch (LimitExceededException e) {
    	    System.err.println(e.getMessage());
    	}
        System.out.println("Added to cart: " + media.getTitle());
    }

    @FXML
    void btnPlayClicked (ActionEvent event) {
    	 if (media instanceof Playable) {
    	        try {
    	            ((Playable) media).play();
    	            String message = "Playing Media: " + ((Media) media).getTitle();
                            
             javax.swing.JOptionPane.showMessageDialog(null,
                     message,
                     "Playback Info",
                     javax.swing.JOptionPane.INFORMATION_MESSAGE);
    	        } catch (PlayerException e) {
    	        	javax.swing.JOptionPane.showMessageDialog(null,
    	        	          e.getMessage(),
    	        	        "Illegal DVD Length",
    	        	        javax.swing.JOptionPane.ERROR_MESSAGE);
    	        }
    	 }
    }
}
