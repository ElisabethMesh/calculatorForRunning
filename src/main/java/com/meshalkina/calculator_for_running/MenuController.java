package com.meshalkina.calculator_for_running;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button getPaceButton;

    @FXML
    private Button getSpeedButton;

    @FXML
    void initialize() {
        getPaceButton.setOnAction(event -> {
            getPaceButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(MenuController.class.getResource("getPace.fxml"));
            show(loader);
        });

        getSpeedButton.setOnAction(event -> {
            getSpeedButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(MenuController.class.getResource("getSpeed.fxml"));
            show(loader);
        });
    }

    private void show(FXMLLoader loader) {
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Calculator");
        stage.show();
    }
}

