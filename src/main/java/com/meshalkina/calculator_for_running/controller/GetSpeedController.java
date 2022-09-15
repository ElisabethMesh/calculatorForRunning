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
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import static com.meshalkina.calculator_for_running.util.ImageEvents.openFactWindow;
import static com.meshalkina.calculator_for_running.util.ImageEvents.openMenuWindow;

public class GetSpeedController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button calculate;

    @FXML
    private TableColumn<?, ?> distance;

    @FXML
    private ImageView interesting;

    @FXML
    private TextField paceMin;

    @FXML
    private TextField paceSec;

    @FXML
    private Text resultSpeed;

    @FXML
    private TableView<TableData> resultTable;

    @FXML
    private ImageView returnButton;

    @FXML
    private TableColumn<?, ?> totalTime;

    @FXML
    void initialize() {
        calculate.setOnAction(event -> {
            distance.setCellValueFactory(new PropertyValueFactory<>("distance"));
            totalTime.setCellValueFactory(new PropertyValueFactory<>("totalTime"));

            TableContents tableContents = new TableContents();
            CalculateUtil calculateUtil = new CalculateUtil();

            double time = calculateUtil.speedFormat(paceMin, paceSec);
            double result = calculateUtil.getSpeed(time);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");

            if (time <= 0) {
                resultSpeed.setText("0");
                tableContents.setTable(0, resultTable);
                return;
            } else {
                resultSpeed.setText(String.valueOf(decimalFormat.format(result)));
                tableContents.setTable(time, resultTable);
            }
        });

        try {
            openMenuWindow(returnButton);
            openFactWindow(interesting);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

