package io.ylab.service.imp;

import java.time.LocalDateTime;
import java.util.List;

import io.ylab.model.TransactionModel;
import io.ylab.model.UserModel;
import io.ylab.repository.TransactionRepository;
import io.ylab.service.TransactionService;
import io.ylab.util.TransactionType;

/**
 * Реализация интерфейса {@link TransactionService}.
 * Содержит методы для работы с транзакциями.
 */
public class TransactionServiceImp implements TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionServiceImp(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void createTransaction(UserModel user, String category, String description, int amount, TransactionType type) {
        transactionRepository.save(user, category, description, amount, type);
    }

    public void updateTransactionAmount(UserModel user, int id, int amount) {
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

    public void deleteTransaction(UserModel user, int id) {
        transactionRepository.delete(user, id);
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
