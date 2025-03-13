package io.ylab.service;

/**
 * Интерфейс сервиса для авторизации
 */
public interface AuthService {
    /**
     * Авторизация пользователя
     * @param id id пользователя
     */
    boolean login(int id, String password);
}
