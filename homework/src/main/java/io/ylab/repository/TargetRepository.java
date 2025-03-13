package io.ylab.repository;

import java.util.List;

import io.ylab.model.TargetModel;
import io.ylab.model.UserModel;

/**
 * Интерфейс репозитория для работы с целями пользователя.
 */
public interface TargetRepository {
    /**
     * Получить цель пользователя
     * @param user
     * @param id
     * @return {@code TargetModel}
     */
    TargetModel get(UserModel user, int id);

    /**
     * Добавить новую цель пользователю
     * @param user пользователь
     * @param target сумма цели
     */
    void save(UserModel user, int target);

    /**
     * Обновить цель пользователя
     * @param user пользователь
     * @param target сумма цели
     */
    void update(UserModel user, TargetModel target);

    /**
     * Получить все цели пользователя
     * @param user пользователь
     * @return {@code List<TargetModel>}
     */
    List<TargetModel> getAll(UserModel user);
}
