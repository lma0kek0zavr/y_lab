package io.ylab.repository.imp;

import java.util.HashMap;
import java.util.Map;

import io.ylab.model.BudgetModel;
import io.ylab.model.UserModel;
import io.ylab.repository.AccountRepository;
import io.ylab.repository.BudgetRepository;

/**
 * Реализация интерфейса {@link AccountRepository}.
 * Реализует crud операции для бюджета пользователя.
 */
public class BudgetRepositoryImp implements BudgetRepository {
    private Map<UserModel, BudgetModel> userBudget;

    public BudgetRepositoryImp() {
        this.userBudget = new HashMap<>();
    }

    @Override
    public BudgetModel get(UserModel user) {
        return userBudget.get(user);
    }

    @Override
    public void save(UserModel user, int amount) {
        BudgetModel budget = new BudgetModel(amount);
        userBudget.put(user, budget);
    }

    @Override
    public void update(UserModel user, BudgetModel budgetToSave) {
        BudgetModel budgetToUpdate = userBudget.get(user);
        userBudget.replace(user, budgetToUpdate, budgetToSave);
    }
    
}
