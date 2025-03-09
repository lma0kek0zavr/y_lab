package io.ylab.model;

public class TargetModel {
    private int id;
    private double target;
    private double currentSavings;

    private static int targetId = 0;

    public TargetModel(double amount) {
        this.id = ++targetId;
        this.target = amount;
        this.currentSavings = 0;
    }

    public int getId() {
        return id;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public double getCurrentSavings() {
        return currentSavings;
    }

    public void setCurrentSavings(double currentSavings) {
        this.currentSavings = currentSavings;
    }
}
