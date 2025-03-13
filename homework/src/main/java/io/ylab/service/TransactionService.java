package io.ylab.service;

import java.time.LocalDateTime;
import java.util.List;

import io.ylab.model.TransactionModel;
import io.ylab.model.UserModel;
import io.ylab.util.TransactionType;

/**
 * Интерфейс сервиса для работы с транзакциями пользователя
 */
public interface TransactionService {
    /**
     * Добавить новую транзакцию
     * @param user пользователь
     * @param category категория транзакции
     * @param description описание транзакции
     * @param amount сумма транзакции
     * @param type тип транзакции
     */
    void createTransaction(UserModel user, String category, String description, int amount, TransactionType type);

    /**
     * Обновить сумму транзакции пользователя
     * @param user пользователь
     * @param id id транзакции
     * @param amount сумма транзакции
     */
    void updateTransactionAmount(UserModel user, int id, int amount);

    /**
     * Обновить категорию транзакции пользователя
     * @param user пользователь
     * @param id id транзакции
     * @param category сумма транзакции
     */
    void updateTransactionCategory(UserModel user, int id, String category);

    /**
     * Обновить описание транзакции пользователя
     * @param user пользователь
     * @param id id транзакции
     * @param description сумма транзакции
     */
    void updateTransactionDescription(UserModel user, int id, String description);

    void deleteTransaction(UserModel user, int id);

    /**
     * Получить транзакции пользователя по дате
     * @param user пользователь
     * @param date дата
     * @return {@code List<TransactionModel>}
     */
    List<TransactionModel> getTransactionsByDate(UserModel user, LocalDateTime date);

    /**
     * Получить транзакции пользователя по категории
     * @param user пользователь
     * @param category категория
     * @return {@code List<TransactionModel>}
     */
    List<TransactionModel> getTransactionsByCategory(UserModel user, String category);

    /**
     * Получить транзакции пользователя по дате
     * @param user пользователь
     * @param type тип транзакции
     * @return {@code List<TransactionModel>}
     */
    List<TransactionModel> getTransactionsByType(UserModel user, TransactionType type);
}
