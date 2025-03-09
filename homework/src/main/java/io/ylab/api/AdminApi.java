package io.ylab.api;

import io.ylab.service.AccountService;

public class AdminApi {
    private AccountService accountService;

    public AdminApi(AccountService accountService) {
        this.accountService = accountService;
    }

    public String getAllUsers() {
        return accountService.getAllAccounts().toString();
    }

    public void deleteUser(int id) {
        accountService.deleteAccount(id);
    }

    public void blockUser(int id) {
        accountService.blockAccount(id);
    }
}
