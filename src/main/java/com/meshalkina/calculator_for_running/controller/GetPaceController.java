package com.meshalkina.calculator_for_running.controller;

import com.meshalkina.calculator_for_running.model.TableData;
import com.meshalkina.calculator_for_running.util.CalculateUtil;
import com.meshalkina.calculator_for_running.util.TableContents;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.meshalkina.calculator_for_running.util.ImageEvents.openFactWindow;
import static com.meshalkina.calculator_for_running.util.ImageEvents.openMenuWindow;

public class GetPaceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button calculate;

    @FXML
    private TableColumn<TableData, Double> distance;

    @FXML
    private ImageView interesting;

    @FXML
    private Text resultPace;

    @FXML
    private TableView<TableData> resultTable;

    @FXML
    private ImageView returnButton;

    @FXML
    private TextField speed;

    @FXML
    private TableColumn<TableData, String> totalTime;

    @FXML
    void initialize() {
        calculate.setOnAction(event -> {
            distance.setCellValueFactory(new PropertyValueFactory<>("distance"));
            totalTime.setCellValueFactory(new PropertyValueFactory<>("totalTime"));

            TableContents tableContents = new TableContents();
            CalculateUtil calculateUtil = new CalculateUtil();

            if (Double.parseDouble(speed.getText()) <= 0) {
                resultPace.setText("0");
                tableContents.setTable(0, resultTable);
                return;
            }

            double result = calculateUtil.getPace(Double.parseDouble(speed.getText()));
            String resultFormat = calculateUtil.paceFormat(result);
            resultPace.setText(resultFormat);

            tableContents.setTable(result, resultTable);
        });

        try {
            openMenuWindow(returnButton);
            openFactWindow(interesting);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}