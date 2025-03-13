package io.ylab.repository.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.ylab.model.TransactionModel;
import io.ylab.model.UserModel;
import io.ylab.repository.AccountRepository;
import io.ylab.repository.TransactionRepository;
import io.ylab.util.TransactionType;

/**
 * Реализация интерфейса {@link AccountRepository}.
 * Реализует crud операции для транзакций пользователя.
 */
public class TransactionRepositoryImp implements TransactionRepository {
    private Map<UserModel, List<TransactionModel>> userTransactions;

    public TransactionRepositoryImp() {
        this.userTransactions = new HashMap<>();
    }

    @Override
    public TransactionModel get(UserModel user, int id) {
        return userTransactions.get(user).stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(UserModel user, String category, String description, int amount, TransactionType type) {
        TransactionModel transaction = new TransactionModel(category, description, amount, type);
        if (!userTransactions.containsKey(user)) {
            userTransactions.put(user, new ArrayList<>());
        }
        userTransactions.get(user).add(transaction);
    }

    @Override
    public void delete(UserModel user, int id) {
        TransactionModel transaction = get(user, id);
        userTransactions.get(user).remove(transaction);
    }

    @Override
    public void update(UserModel user, TransactionModel transaction) {
        TransactionModel transactionToUpdate = get(user, transaction.getId());
        userTransactions.get(user).remove(transactionToUpdate);
        userTransactions.get(user).add(transaction);
    }

    @Override
    public List<TransactionModel> getAll(UserModel user) {
        return userTransactions.get(user);
    }
}
