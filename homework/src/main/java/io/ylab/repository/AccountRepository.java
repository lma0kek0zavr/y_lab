package io.ylab.repository;

import java.util.List;

import io.ylab.model.UserModel;

/**
 * Интерфейс репозитория для работы с пользователями.
 */
public interface AccountRepository { 
    /**
     * Получить пользователя по id
     * @param id
     * @return {@code UserModel}
     */
    UserModel getById(int id);

    /**
     * Сохранить пользователя
     * @param name имя
     * @param email почта
     * @param password пароль
     */
    void save(String name, String email, String password);

    /**
     * Обновить пользователя
     * @param id id пользователя
     * @param user пользователь
     */
    void update(int id, UserModel user);

    /**
     * Удалить пользователя
     * @param id id пользователя
     */
    void delete(int id);

    /**
     * Получить всех пользователей
     * @return {@code List<UserModel>}
     */
    List<UserModel> getAll();

    /**
     * Заблокировать пользователя
     * @param id id пользователя
     */
    void blockUser(int id);
}
