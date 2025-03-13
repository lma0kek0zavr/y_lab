package io.ylab.service.imp;

import io.ylab.repository.AccountRepository;
import io.ylab.service.AuthService;

/**
 * Реализация интерфейса {@link AuthService}.
 * Содержит методы для авторизации.
 */
public class AuthServiceImp implements AuthService {
    private AccountRepository accountRepository;

    public AuthServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean login(int id, String password) { 
        if (!identify(id)) {
            throw new IllegalArgumentException("User not found");
        }

        if (!authenticate(id, password)) {
            throw new IllegalArgumentException("Wrong password");
        }

        return true;
    }

    private boolean identify(int id) { 
        return accountRepository.getById(id) != null;
    }

    private boolean authenticate(int id, String password) { 
        return accountRepository.getById(id).getPassword().equals(password);
    }
}
