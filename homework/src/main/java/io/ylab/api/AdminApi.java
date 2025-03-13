package io.ylab.api;

import io.ylab.service.AccountService;

/**
 * Иммитация api для администратора
 */
public class AdminApi {
    private AccountService accountService;

    public AdminApi(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Возвращает список всех пользователей в виде строки.
     *
     * @return строка со списком пользователей.
     */
    public String getAllUsers() {
        return accountService.getAllAccounts().toString();
    }

    /**
     * Удаляет пользователя с заданным id.
     *
     * @param id id пользователя, которого нужно удалить.
     */
    public void deleteUser(int id) {
        accountService.deleteAccount(id);
    }

    /**
     * Блокирует пользователя с заданным id.
     *
     * @param id id пользователя, которого нужно заблокировать.
     */
    public void blockUser(int id) {
        accountService.blockAccount(id);
    }
}
