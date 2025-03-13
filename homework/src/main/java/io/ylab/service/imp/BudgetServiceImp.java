package io.ylab.service.imp;

import io.ylab.model.BudgetModel;
import io.ylab.model.UserModel;
import io.ylab.repository.BudgetRepository;
import io.ylab.service.BudgetService;

/**
 * Реализация интерфейса {@link BudgetService}.
 * Содержит методы для работы с бюджетом.
 */
public class BudgetServiceImp implements BudgetService {
    private BudgetRepository budgetRepository;

    public BudgetServiceImp(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public int getMonthlyBudget(UserModel user) {
        return budgetRepository.get(user).getMonthlyBudget();
    }

    public void setMonthlyBudget(UserModel user, int amount) {
        budgetRepository.save(user, amount);
    }

    public int getExpense(UserModel user) { 
        return budgetRepository.get(user).getExpense();
    }

    public void setExpense(UserModel user, int expense) { 
        BudgetModel budget = budgetRepository.get(user);
        budget.setExpense(expense);
        budgetRepository.update(user, budget);
    }

    public boolean checkBudget(UserModel user) { 
        BudgetModel budget = budgetRepository.get(user);
        return budget.getMonthlyBudget() > budget.getExpense();
    }
}
