package io.ylab.storage;

import java.util.HashMap;
import java.util.Map;

import io.ylab.model.BudgetModel;
import io.ylab.model.UserModel;
import io.ylab.repository.BudgetRepository;

public class BudgetStorage implements BudgetRepository {
    Map<UserModel, BudgetModel> budgets;

    public BudgetStorage() {
        this.budgets = new HashMap<>();
    }

    @Override
    public BudgetModel get(UserModel user) {
        return budgets.get(user);
    }

    @Override
    public void save(UserModel user, double amount) {
        budgets.put(user, new BudgetModel(amount));
    }

    @Override
    public void update(UserModel user, double amount) {
        budgets.get(user).setMonthlyBudget(amount);
    }
}
