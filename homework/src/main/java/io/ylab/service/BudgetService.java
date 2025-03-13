package io.ylab.service;

import io.ylab.model.UserModel;

/**
 * Интерфейс сервиса для работы с бюджетом пользователя
 */
public interface BudgetService {
    int getMonthlyBudget(UserModel user);
    void setMonthlyBudget(UserModel user, int amount);
    int getExpense(UserModel user);
    void setExpense(UserModel user, int expense);
    boolean checkBudget(UserModel user);
}
