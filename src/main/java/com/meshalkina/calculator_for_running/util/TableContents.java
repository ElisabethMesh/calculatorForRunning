package com.meshalkina.calculator_for_running.util;

import com.meshalkina.calculator_for_running.model.TableData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class TableContents {
    public void setTable(double time, TableView<TableData> tab) {
        CalculateUtil calculateUtil = new CalculateUtil();
        ObservableList<TableData> list = FXCollections.observableArrayList(
                new TableData(5.0, calculateUtil.paceFormat(5.0 * time)),
                new TableData(10.0, calculateUtil.paceFormat(10.0 * time)),
                new TableData(15.0, calculateUtil.paceFormat(15.0 * time)),
                new TableData(21.1, calculateUtil.paceFormat(21.1 * time)),
                new TableData(42.2, calculateUtil.paceFormat(42.2 * time))
        );
        tab.setItems(list);
    }
}
