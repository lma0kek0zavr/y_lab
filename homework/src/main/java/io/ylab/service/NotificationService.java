package io.ylab.service;

import io.ylab.model.UserModel;
import io.ylab.repository.AccountRepository;

public class NotificationService {
    private AccountRepository accountRepository;

    public NotificationService(AccountRepository accountRepository) {
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
