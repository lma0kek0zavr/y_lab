package io.ylab.service;

import java.util.List;

import io.ylab.model.UserModel;

/**
 * Интерфейс сервиса для работы с пользователями
 */
public interface AccountService {
    /**
     * Создать нового пользователя
     * @param name имя
     * @param email почта
     * @param password пароль
     */
    void createAccount(String name, String email, String password);

    /**
     * Удалить пользователя по id
     * @param id id пользователя
     */
    void deleteAccount(int id);

    /**
     * Обновить имя пользователя
     * @param id id пользователя
     * @param name новое имя
     */
    void updateUserName(int id, String name);

    /**
     * Обновить пароль пользователя
     * @param id id пользователя
     * @param password новый пароль
     */
    void updatePassword(int id, String password);

    /**
     * Обновить почту пользователя
     * @param id id пользователя
     * @param email новая почта
     */
    void updateEmail(int id, String email);

    /**
     * Заблокировать пользователя
     * @param id id пользователя
     */
    void blockAccount(int id);

    /**
     * Получить всех пользователей
     * @return {@code List<UserModel>}
     */
    List<UserModel> getAllAccounts();

    /**
     * Получить пользователя по id
     * @param id id пользователя
     * @return {@code UserModel}
     */
    UserModel getAccountById(int id);
}
