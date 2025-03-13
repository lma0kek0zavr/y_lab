package io.ylab.service;

import java.util.Map;

import io.ylab.model.UserModel;
import io.ylab.util.TransactionType;

/**
 * Интерфейс сервиса для аналитики
 */
public interface AnalyticService {
    int getCurrentBalance(UserModel user);
    int getTotalIncome(UserModel user);
    int getTotalExpense(UserModel user);
    Map<TransactionType, Integer> getTransactionsByType(UserModel user);
    String getReport(UserModel user);
}
