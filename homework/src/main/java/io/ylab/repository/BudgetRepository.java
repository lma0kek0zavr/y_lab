package io.ylab.repository;

import io.ylab.model.BudgetModel;
import io.ylab.model.UserModel;

public interface BudgetRepository {
    BudgetModel get(UserModel user);
    void save(UserModel user, double amount);
    void update(UserModel user, double amount);
}
