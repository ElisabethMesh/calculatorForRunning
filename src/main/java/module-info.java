module com.meshalkina.calculator_for_running {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.meshalkina.calculator_for_running to javafx.fxml;
    exports com.meshalkina.calculator_for_running;
    exports com.meshalkina.calculator_for_running.controller;
    opens com.meshalkina.calculator_for_running.controller to javafx.fxml;
    exports com.meshalkina.calculator_for_running.model;
    opens com.meshalkina.calculator_for_running.model to javafx.fxml;
    exports com.meshalkina.calculator_for_running.util;
    opens com.meshalkina.calculator_for_running.util to javafx.fxml;
}