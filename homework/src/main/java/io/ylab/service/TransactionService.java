package io.ylab.service;

import java.time.LocalDateTime;
import java.util.List;

import io.ylab.model.TransactionModel;
import io.ylab.model.UserModel;
import io.ylab.repository.TransactionRepository;
import io.ylab.util.TransactionType;

public class TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void createTransaction(UserModel user, TransactionModel transaction) {
        transactionRepository.save(user, transaction);
    }

    public void updateTransactionAmount(UserModel user, int id, double amount) {
        TransactionModel transaction = transactionRepository.get(user, id);
        transaction.setAmount(amount);
        transactionRepository.update(user, transaction);
    }

    public void updateTransactionCategory(UserModel user, int id, String category) {
        TransactionModel transaction = transactionRepository.get(user, id);
        transaction.setCategory(category);
        transactionRepository.update(user, transaction);
    }

    public void updateTransactionDescription(UserModel user, int id, String description) {
        TransactionModel transaction = transactionRepository.get(user, id);
        transaction.setDescription(description);
        transactionRepository.update(user, transaction);
    }

    public void deleteTransaction(UserModel user, TransactionModel transaction) {
        transactionRepository.delete(user, transaction);
    }

    public List<TransactionModel> getTransactionsByDate(UserModel user, LocalDateTime date) {
        return transactionRepository.filterTransaction(user, t -> t.getDate().equals(date));
    }

    public List<TransactionModel> getTransactionsByCategory(UserModel user, String category) {
        return transactionRepository.filterTransaction(user, t -> t.getCategory().equals(category));
    }

    public List<TransactionModel> getTransactionsByType(UserModel user, TransactionType type) {
        return transactionRepository.filterTransaction(user, t -> t.getType().equals(type));
    }
}
