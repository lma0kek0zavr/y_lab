package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.ylab.service.AccountService;
import io.ylab.storage.UserStorage;


public class AccountServiceTest {
    @Test
    void shouldCreateAccount() {
        AccountService accountService = new AccountService(new UserStorage());
        accountService.createAccount("name1", "email1", "password1");
        assertEquals(1, accountService.getAllAccounts().size());
    }

    @Test
    void shouldGetAllAccounts() {
        AccountService accountService = new AccountService(new UserStorage());
        accountService.createAccount("name3", "email3", "password3");
        accountService.createAccount("name4", "email4", "password4");
        assertEquals(2, accountService.getAllAccounts().size());
    }

    @Test
    void shouldUpdateUserName() {
        AccountService accountService = new AccountService(new UserStorage());
        accountService.createAccount("name4", "email4", "password4");
        accountService.updateUserName(accountService.getAllAccounts().get(0).getId(), "name5");
        assertEquals("name5", accountService.getById(1).getName());
    }

    @Test
    void shouldDeleteAccount() {
        AccountService accountService = new AccountService(new UserStorage());
        accountService.createAccount("name2", "email2", "password2");
        accountService.deleteAccount(accountService.getAllAccounts().get(0).getId());
        assertEquals(0, accountService.getAllAccounts().size());
    }
}
