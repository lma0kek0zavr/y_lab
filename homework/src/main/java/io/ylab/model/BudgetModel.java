package io.ylab.model;

/**
 * Сущность бюджета
 */
public class BudgetModel {
    private int monthlyBudget;
    private int income;
    private int expense;

    public BudgetModel(int monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public int getMonthlyBudget() {
        return monthlyBudget;
    }

    public void setMonthlyBudget(int monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }
}
