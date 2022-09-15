package com.meshalkina.calculator_for_running.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.meshalkina.calculator_for_running.util.InterestingFacts.getFact;

public class InterestingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button OkButton;

    @FXML
    private Text interestingFact;

    @FXML
    void openNewStage(ActionEvent event) {
        Stage stage = (Stage) OkButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        interestingFact.setText(getFact());
    }

}


