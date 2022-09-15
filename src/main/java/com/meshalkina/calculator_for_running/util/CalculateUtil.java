package com.meshalkina.calculator_for_running.util;

import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateUtil {

    public double getPace(double speed) {
        return 60 / speed;
    }

    public double getSpeed(double pace) {
        return 60 / pace;
    }

    public String paceFormat(double pace) throws NumberFormatException {
        int hours = (int) pace / 60;
        int minutes = (int) (pace % 60);
        BigDecimal secondsPrecision = new BigDecimal(((pace - Math.floor(pace)) * 100) * 0.6).setScale(2, RoundingMode.HALF_UP);
        int seconds = secondsPrecision.intValue();

        String paceForm;
        if (hours == 0) {
            paceForm = String.format("%s мин. %s сек.", minutes, seconds);
        } else {
            paceForm = String.format("%s ч. %s мин. %s сек.", hours, minutes, seconds);
        }
        return paceForm;
    }

    public double speedFormat(TextField min, TextField sec) {
            double minute = Integer.parseInt(min.getText());
            double second = Double.parseDouble(sec.getText());
            second = (second / 100) / 0.6;
            double time = minute + second;
            return time;
    }
}
