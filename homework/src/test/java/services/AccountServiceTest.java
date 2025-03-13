package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.ylab.repository.imp.AccountRepositoryImp;
import io.ylab.service.AccountService;
import io.ylab.service.imp.AccountServiceImp;

public class AccountServiceTest {
    @Test
    @DisplayName("Should create account")
    void createAccount() {
        AccountService accountService = new AccountServiceImp(new AccountRepositoryImp());

        accountService.createAccount("name1", "email1", "password1");

        assertEquals(1, accountService.getAllAccounts().size());
    }

    @Test
    @DisplayName("Should get all accounts")
    void getAllAccounts() {
        AccountService accountService = new AccountServiceImp(new AccountRepositoryImp());

        accountService.createAccount("name3", "email3", "password3");
        accountService.createAccount("name4", "email4", "password4");

        assertEquals(2, accountService.getAllAccounts().size());
    }

    @Test
    @DisplayName("Should update user name")
    void updateUserName() {
        AccountService accountService = new AccountServiceImp(new AccountRepositoryImp());

        accountService.createAccount("name4", "email4", "password4");
        accountService.updateUserName(accountService.getAllAccounts().get(0).getId(), "name5");

        assertEquals("name5", accountService.getAllAccounts().get(0).getName());
    }

    @Test
    @DisplayName("Should delete account")
    void deleteAccount() {
        AccountService accountService = new AccountServiceImp(new AccountRepositoryImp());

        accountService.createAccount("name2", "email2", "password2");
        accountService.deleteAccount(accountService.getAllAccounts().get(0).getId());
        
        assertEquals(0, accountService.getAllAccounts().size());
    }
}
