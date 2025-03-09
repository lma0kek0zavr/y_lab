package services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.ylab.repository.AccountRepository;
import io.ylab.service.AccountService;
import io.ylab.service.AuthService;
import io.ylab.storage.UserStorage;

public class AuthServiceTest {
    @Test
    void shouldLoginCorrectly() {
        AccountRepository accountRepository = new UserStorage();
        AccountService accountService = new AccountService(accountRepository);
        AuthService authService = new AuthService(accountRepository);
        accountService.createAccount("name1", "email1", "password1");
        accountService.createAccount("name2", "email2", "password2");
        accountService.createAccount("name3", "email3", "password3");
        assertEquals(true, authService.login(1, "password1"));
        assertThrows(IllegalArgumentException.class, () -> authService.login(1, "password2"));
    }

    @Test
    void shouldThrowExceptionWhenPasswordIncorrect() {
        AccountRepository accountRepository = new UserStorage();
        AccountService accountService = new AccountService(accountRepository);
        AuthService authService = new AuthService(accountRepository);
        accountService.createAccount("name1", "email1", "password1");
        assertThrows(IllegalArgumentException.class, () -> authService.login(1, "password2"));
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() { 
        AccountRepository accountRepository = new UserStorage();
        AuthService authService = new AuthService(accountRepository);
        assertThrows(IllegalArgumentException.class, () -> authService.login(1, "password1"));
    }
}
