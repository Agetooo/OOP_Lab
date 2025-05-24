// CartController.java - updated for Lab 8 (Place Order feature)
package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.net.URL;
import java.util.Comparator;
import java.util.Optional;
import java.util.ResourceBundle;

public class CartController implements Initializable {
    private Cart cart;
    private Store store;

    @FXML 
    private TableView<Media> tblMedia;
    @FXML 
    private TableColumn<Media, Integer> colMediaId;
    @FXML 
    private TableColumn<Media, String> colMediaTitle;
    @FXML 
    private TableColumn<Media, String> colMediaCategory;
    @FXML 
    private TableColumn<Media, Float> colMediaCost;
    @FXML 
    private Label costLabel;
    @FXML 
    private Button btnPlay;
    @FXML 
    private Button btnRemove;
    @FXML 
    private Button btnPlaceOrder;
    @FXML 
    private TextField tfFilter;
    @FXML 
    private ToggleGroup filterCategory;
    @FXML 
    private RadioButton radioBtnFilterId;
    @FXML 
    private RadioButton radioBtnFilterTitle;

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> updateButtonBar(newValue)
        );
    }

    public void showCart() {
        if (cart != null) {
            ObservableList<Media> mediaList = FXCollections.observableArrayList(cart.getItemsOrdered());
            tblMedia.setItems(mediaList);
            updateTotalCost();
        }
    }

    private void updateTotalCost() {
        if (cart != null) {
            float total = 0;
            for (Media m : cart.getItemsOrdered()) {
                total += m.getCost();
            }
            costLabel.setText(String.format("%.2f $", total));
        }
    }

    private void updateButtonBar(Media media) {
        boolean isSelected = media != null;
        btnPlay.setVisible(isSelected && media instanceof Playable);
        btnRemove.setVisible(isSelected);
    }

    @FXML
    private void btnViewStorePressed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Store.fxml"));
            Parent storeView = loader.load();

            ViewStoreController viewStoreController = loader.getController();
            viewStoreController.ViewStoreController(store);
            viewStoreController.setCart(cart);
            viewStoreController.loadStoreItems();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(storeView));
            stage.setTitle("Store");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnPlayPressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia instanceof Playable) {
	        try {
	            ((Playable) selectedMedia).play();
	            String message = "Playing Media: " + ((Media) selectedMedia).getTitle();
                        
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

    @FXML
    private void btnRemovePressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null && cart != null) {
            cart.removeMedia(selectedMedia);
            showCart();
        }
    }

    @FXML
    private void onFilterKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            String filterText = tfFilter.getText().trim();

            if (filterText.isEmpty()) {
                // Nếu rỗng, hiển thị lại toàn bộ cart
                tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));
                return;
            }

            ObservableList<Media> filtered = FXCollections.observableArrayList();
            if (radioBtnFilterId.isSelected()) {
                try {
                    int id = Integer.parseInt(filterText);
                    for (Media m : cart.getItemsOrdered()) {
                        if (m.getId() == id) filtered.add(m);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid ID");
                }
            } else if (radioBtnFilterTitle.isSelected()) { // đảm bảo radioBtnFilterTitle không null
                for (Media m : cart.getItemsOrdered()) {
                    if (m.getTitle().toLowerCase().contains(filterText.toLowerCase())) filtered.add(m);
                }
            }

            tblMedia.setItems(filtered);
        }
    }


    

    @FXML
    private void btnPlaceOrderPressed(ActionEvent event) {
        cart.clear();
        tblMedia.getItems().clear();
        updateTotalCost();

        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle("Order Placed");
        success.setHeaderText(null);
        success.setContentText("Your order has been placed successfully.");
        success.showAndWait();
    }
}
