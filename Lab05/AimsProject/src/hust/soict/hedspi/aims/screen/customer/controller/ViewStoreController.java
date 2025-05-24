package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;  // sửa import đúng
import java.io.IOException;

public class ViewStoreController {
    @FXML
    private GridPane gridPane;

    private Store store;
    private Cart cart;


    public void ViewStoreController(Store store) {
        this.store = store;
     
        loadStoreItems();
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void loadStoreItems() {
        if (store == null) return;  // phòng ngừa null

        gridPane.getChildren().clear();
        int column = 0;
        int row = 0;

        for (Media media : store.getItemsInStore()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Item.fxml"));
                AnchorPane anchorPane = loader.load();

                ItemController itemController = loader.getController();
                itemController.setData(media);
                itemController.setCart(cart);

                anchorPane.setPrefWidth(305);
                anchorPane.setPrefHeight(175);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void btnViewCartPressed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml"));
            Parent root = loader.load();

            CartController cartController = loader.getController();
            cartController.setCart(cart);
            cartController.setStore(store);
            cartController.showCart();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
