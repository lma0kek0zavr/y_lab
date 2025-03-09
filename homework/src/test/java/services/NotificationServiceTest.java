package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.ylab.repository.AccountRepository;
import io.ylab.service.AccountService;
import io.ylab.service.NotificationService;
import io.ylab.storage.UserStorage;

public class NotificationServiceTest {
    @Test
    void shouldSendNotification() { 
        AccountRepository accountRepository = new UserStorage();
        NotificationService notificationService = new NotificationService(accountRepository);
        assertEquals("Notification", notificationService.sendNotification("Notification"));
    }

    @Test
    void shouldSubcribe() {
        AccountRepository accountRepository = new UserStorage();
        AccountService accountService = new AccountService(accountRepository);
        NotificationService notificationService = new NotificationService(accountRepository);
        accountService.createAccount("name1", "email1", "password1");
        assertEquals("Subscribed to " + accountRepository.getById(1).getEmail(), notificationService.subscribe(1));
    }
}
