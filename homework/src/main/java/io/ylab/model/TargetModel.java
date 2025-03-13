package io.ylab.model;

/**
 * Сущность цели
 */
public class TargetModel {
    private int id;
    private int target;
    private int currentSavings;

    private static int targetId = 0;

    public TargetModel(int amount) {
        this.id = ++targetId;
        this.target = amount;
        this.currentSavings = 0;
    }

    public int getId() {
        return id;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getCurrentSavings() {
        return currentSavings;
    }

    public void setCurrentSavings(int currentSavings) {
        this.currentSavings = currentSavings;
    }

    
    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", target=" + target +
                ", currentSavings=" + currentSavings +
                '}';
    }
}
