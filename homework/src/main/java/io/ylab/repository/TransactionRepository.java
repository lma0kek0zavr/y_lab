package io.ylab.repository;

import java.util.List;
import java.util.function.Predicate;

import io.ylab.model.TransactionModel;
import io.ylab.model.UserModel;
import io.ylab.util.TransactionType;

/**
 * Интерфейс репозитория для работы с транзакциями пользователя.
 */
public interface TransactionRepository {
    /**
     * Получить транзакцию пользователя
     * @param user пользователь
     * @param id id транзакции
     * @return {@code TransactionModel}
     */
    TransactionModel get(UserModel user, int id);

    /**
     * Добавить транзакцию пользователя
     * @param user пользователь
     * @param category категория транзакции
     * @param description описание транзакции
     * @param amount сумма транзакции
     * @param type тип транзакции
     */
    void save(UserModel user, String category, String description, int amount, TransactionType type);

    /**
     * Удалить транзакцию пользователя
     * @param user пользователь
     * @param id id транзакции
     */
    void delete(UserModel user, int id);

    /**
     * Обновить транзакцию пользователя
     * @param user пользователь
     * @param transaction транзакция
     */
    void update(UserModel user, TransactionModel transaction);

    /**
     * Получить все транзакции пользователя
     * @param user пользователь
     * @return {@code List<TransactionModel>}
     */
    List<TransactionModel> getAll(UserModel user);

    /**
     * default метод для фильтрации транзакций пользователя
     * @param user пользователь
     * @param filter условие для фильтрации
     * @return {@code List<TransactionModel>}
     */
    default List<TransactionModel> filterTransaction(UserModel user, Predicate<TransactionModel> filter) {
        List<TransactionModel> transactions = getAll(user);
        return transactions.stream().filter(filter).toList();
    }
}
