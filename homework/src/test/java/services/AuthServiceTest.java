package services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.ylab.repository.AccountRepository;
import io.ylab.repository.imp.AccountRepositoryImp;
import io.ylab.service.AccountService;
import io.ylab.service.imp.AccountServiceImp;
import io.ylab.service.AuthService;
import io.ylab.service.imp.AuthServiceImp;

public class AuthServiceTest {
    @Test
    @DisplayName("Should login correctly")
    void loginCorrectly() {
        AccountRepository accountRepository = new AccountRepositoryImp();
        AccountService accountService = new AccountServiceImp(accountRepository);
        AuthService authService = new AuthServiceImp(accountRepository);

        accountService.createAccount("name1", "email1", "password1");
        accountService.createAccount("name2", "email2", "password2");
        accountService.createAccount("name3", "email3", "password3");

        assertEquals(true, authService.login(1, "password1"));
    }

    @Test
    @DisplayName("Should throw exception when password incorrect")
    void throwExceptionWhenPasswordIncorrect() {
        AccountRepository accountRepository = new AccountRepositoryImp();
        AccountService accountService = new AccountServiceImp(accountRepository);
        AuthService authService = new AuthServiceImp(accountRepository);

        accountService.createAccount("name1", "email1", "password1");
        assertThrows(IllegalArgumentException.class, () -> authService.login(1, "password2"));
    }

    @Test
    @DisplayName("Should throw exception when user not found")
    void throwExceptionWhenUserNotFound() { 
        AccountRepository accountRepository = new AccountRepositoryImp();
        AuthService authService = new AuthServiceImp(accountRepository);
        
        assertThrows(IllegalArgumentException.class, () -> authService.login(1, "password1"));
    }
}
