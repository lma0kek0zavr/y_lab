package io.ylab.repository;

import io.ylab.model.BudgetModel;
import io.ylab.model.UserModel;

/**
 * Интерфейс репозитория для работы с бюджетом пользователя.
 */
public interface BudgetRepository {
    /**
     * Получить бюджет пользователя
     * @param user пользователь
     * @return {@code BudgetModel}
     */
    BudgetModel get(UserModel user);

    /**
     * Добавить новый бюджет пользователю
     * @param user пользователь
     * @param amount сумма
     */
    void save(UserModel user, int amount);

    /**
     * Обновить бюджет пользователя
     * @param user пользователь
     * @param budget сущность бюджета
     */
    void update(UserModel user, BudgetModel budget);
}
