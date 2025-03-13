package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.ylab.repository.AccountRepository;
import io.ylab.repository.imp.AccountRepositoryImp;
import io.ylab.service.AccountService;
import io.ylab.service.imp.AccountServiceImp;
import io.ylab.service.NotificationService;
import io.ylab.service.imp.NotificationServiceImp;

public class NotificationServiceTest {
    @Test
    @DisplayName("Should send notification")
    void sendNotification() { 
        AccountRepository accountRepository = new AccountRepositoryImp();
        NotificationService notificationService = new NotificationServiceImp(accountRepository);

        assertEquals("Notification", notificationService.sendNotification("Notification"));
    }


    @Test
    @DisplayName("Should subscribe to notification")
    void subcribe() {
        AccountRepository accountRepository = new AccountRepositoryImp();
        AccountService accountService = new AccountServiceImp(accountRepository);
        NotificationService notificationService = new NotificationServiceImp(accountRepository);

        accountService.createAccount("name1", "email1", "password1");

        assertEquals("Subscribed to " + accountRepository.getById(1).getEmail(), notificationService.subscribe(1));
    }
}
