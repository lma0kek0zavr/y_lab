package io.ylab.service.imp;

import io.ylab.model.UserModel;
import io.ylab.repository.AccountRepository;
import io.ylab.service.NotificationService;

/**
 * Реализация интерфейса {@link NotificationService}.
 * Содержит методы для отправки уведомлений.
 */
public class NotificationServiceImp implements NotificationService {
    private AccountRepository accountRepository;

    public NotificationServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public String sendNotification(String message) {
        return message;
    }

    public String subscribe(int id) { 
        UserModel user = accountRepository.getById(id);
        String email = user.getEmail();
        return "Subscribed to " + email;
    }
}
