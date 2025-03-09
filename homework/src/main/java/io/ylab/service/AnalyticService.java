package io.ylab.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.ylab.model.TransactionModel;
import io.ylab.model.UserModel;
import io.ylab.repository.BudgetRepository;
import io.ylab.repository.TransactionRepository;
import io.ylab.util.TransactionType;

public class AnalyticService {
    private BudgetRepository budgetRepository;
    private TransactionRepository transactionRepository;

    public AnalyticService(BudgetRepository budgetRepository, TransactionRepository transactionRepository) {
        this.budgetRepository = budgetRepository;
        this.transactionRepository = transactionRepository;
    }

    public double getCurrentBalance(UserModel user) { 
        double budget = budgetRepository.get(user).getMonthlyBudget();
        List<TransactionModel> expenseList = transactionRepository.filterTransaction(user, t -> t.getType().equals(TransactionType.EXPENSE));
        double expense = expenseList.stream()
                .mapToDouble(TransactionModel::getAmount)
                .sum();
        return budget - expense;
    }

    public double getTotalIncome(UserModel user) { 
        List<TransactionModel> incomeList = transactionRepository.filterTransaction(user, t -> t.getType().equals(TransactionType.INCOME));
        return incomeList.stream()
                .mapToDouble(TransactionModel::getAmount)
                .sum();
    }

    public double getTotalExpense(UserModel user) { 
        List<TransactionModel> expenseList = transactionRepository.filterTransaction(user, t -> t.getType().equals(TransactionType.EXPENSE));
        return expenseList.stream()
                .mapToDouble(TransactionModel::getAmount)
                .sum();
    }

    public Map<TransactionType, Double> getTransactionsByType(UserModel user) {
        Map<TransactionType, Double> transactions = new HashMap<>(); 
        double income = getTotalIncome(user);
        double expense = getTotalExpense(user);
        transactions.put(TransactionType.INCOME, income);
        transactions.put(TransactionType.EXPENSE, expense);
        return transactions;
    }

    public String getReport(UserModel user) { 
        double balance = getCurrentBalance(user);
        Map<TransactionType, Double> transactions = getTransactionsByType(user);
        return String.format("Balance: %.2f\n Income: %.2f\n Expense: %.2f", 
                balance, 
                transactions.get(TransactionType.INCOME), 
                transactions.get(TransactionType.EXPENSE));
    }
}
