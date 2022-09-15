package com.meshalkina.calculator_for_running.util;

import com.meshalkina.calculator_for_running.MenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ImageEvents {

    public static void openMenuWindow(ImageView view) throws IOException {
        view.setPickOnBounds(true);
        view.setOnMouseClicked((MouseEvent me) -> {
            view.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(MenuController.class.getResource("menu.fxml"));
            try {
                loader.load();
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Menu");
            stage.show();
        });
    }

    public static void openFactWindow(ImageView view) throws IOException {
        view.setPickOnBounds(true);
        view.setOnMouseClicked((MouseEvent me) -> {
            FXMLLoader fxmlLoader = new FXMLLoader(MenuController.class.getResource("interesting.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 400, 150);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Interesting fact");
            stage.show();
        });
    }
}
