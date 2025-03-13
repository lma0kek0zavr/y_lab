package io.ylab.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.ylab.model.TransactionModel;
import io.ylab.model.UserModel;
import io.ylab.repository.BudgetRepository;
import io.ylab.repository.TransactionRepository;
import io.ylab.service.AnalyticService;
import io.ylab.util.TransactionType;

/**
 * Реализация интерфейса {@link AnalyticService}.
 * Содержит методы для аналитики.
 */
public class AnalyticServiceImp implements AnalyticService {
    private BudgetRepository budgetRepository;
    private TransactionRepository transactionRepository;

    public AnalyticServiceImp(BudgetRepository budgetRepository, TransactionRepository transactionRepository) {
        this.budgetRepository = budgetRepository;
        this.transactionRepository = transactionRepository;
    }

    public int getCurrentBalance(UserModel user) { 
        int budget = budgetRepository.get(user).getMonthlyBudget();
        List<TransactionModel> expenseList = transactionRepository.filterTransaction(user, t -> t.getType().equals(TransactionType.EXPENSE));
        int expense = expenseList.stream()
                .mapToInt(TransactionModel::getAmount)
                .sum();
        return budget - expense;
    }

    public int getTotalIncome(UserModel user) { 
        List<TransactionModel> incomeList = transactionRepository.filterTransaction(user, t -> t.getType().equals(TransactionType.INCOME));
        return incomeList.stream()
                .mapToInt(TransactionModel::getAmount)
                .sum();
    }

    public int getTotalExpense(UserModel user) { 
        List<TransactionModel> expenseList = transactionRepository.filterTransaction(user, t -> t.getType().equals(TransactionType.EXPENSE));
        return expenseList.stream()
                .mapToInt(TransactionModel::getAmount)
                .sum();
    }

    public Map<TransactionType, Integer> getTransactionsByType(UserModel user) {
        Map<TransactionType, Integer> transactions = new HashMap<>(); 
        int income = getTotalIncome(user);
        int expense = getTotalExpense(user);
        transactions.put(TransactionType.INCOME, income);
        transactions.put(TransactionType.EXPENSE, expense);
        return transactions;
    }

    public String getReport(UserModel user) { 
        int balance = getCurrentBalance(user);
        Map<TransactionType, Integer> transactions = getTransactionsByType(user);
        return String.format("Balance: %d \nIncome: %d \nExpense: %d", 
                balance, 
                transactions.get(TransactionType.INCOME), 
                transactions.get(TransactionType.EXPENSE));
    }
}
