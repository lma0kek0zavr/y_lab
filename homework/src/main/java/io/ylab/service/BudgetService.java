package io.ylab.service;

import io.ylab.model.BudgetModel;
import io.ylab.model.UserModel;
import io.ylab.repository.BudgetRepository;

public class BudgetService {
    private BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public double getMonthlyBudget(UserModel user) {
        return budgetRepository.get(user).getMonthlyBudget();
    }

    public void setMonthlyBudget(UserModel user, double amount) {
        budgetRepository.save(user, amount);
    }

    public double getExpense(UserModel user) { 
        return budgetRepository.get(user).getExpense();
    }

    public void setExpense(UserModel user, double expense) { 
        budgetRepository.update(user, expense);
    }

    public boolean checkBudget(UserModel user) { 
        BudgetModel budget = budgetRepository.get(user);
        return budget.getMonthlyBudget() > budget.getExpense();
    }
}
