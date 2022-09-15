package com.meshalkina.calculator_for_running.model;

public class TableData {

    private Double distance;
    private String totalTime;

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public TableData() {
    }

    public TableData(Double distance, String totalTime) {
        this.distance = distance;
        this.totalTime = totalTime;
    }

    @Override
    public String toString() {
        return "ResultTable{" +
                "distance=" + distance +
                ", totalTime=" + totalTime +
                '}';
    }
}
