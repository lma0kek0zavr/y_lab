package io.ylab.repository;

import java.util.List;
import java.util.function.Predicate;

import io.ylab.model.TransactionModel;
import io.ylab.model.UserModel;

public interface TransactionRepository {
    TransactionModel get(UserModel user, int id);
    void save(UserModel user, TransactionModel transaction);
    void delete(UserModel user, TransactionModel transaction);
    void update(UserModel user, TransactionModel transaction);
    List<TransactionModel> getAll(UserModel user);
    default List<TransactionModel> filterTransaction(UserModel user, Predicate<TransactionModel> filter) {
        List<TransactionModel> transactions = getAll(user);
        return transactions.stream().filter(filter).toList();
    }
}
