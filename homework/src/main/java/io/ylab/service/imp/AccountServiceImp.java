package io.ylab.service.imp;

import java.util.List;

import io.ylab.model.UserModel;
import io.ylab.repository.AccountRepository;
import io.ylab.service.AccountService;

/**
 * Реализация интерфейса {@link AccountService}.
 * Содержит методы для работы с пользователями.
 */
public class AccountServiceImp implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void createAccount(String name, String email, String password) {
        accountRepository.save(name, email, password);
    }

    @Override
    public void deleteAccount(int id) {
        accountRepository.delete(id);
    }

    @Override
    public void updateUserName(int id, String name) {
        UserModel user = accountRepository.getById(id);
        user.setName(name);
        accountRepository.update(id, user);
    }

    @Override
    public void updatePassword(int id, String password) {
        UserModel user = accountRepository.getById(id);
        user.setPassword(password);
        accountRepository.update(id, user);
    }

    @Override
    public void updateEmail(int id, String email) {
        UserModel user = accountRepository.getById(id);
        user.setEmail(email);
        accountRepository.update(id, user);
    }

    @Override
    public void blockAccount(int id) {
        accountRepository.blockUser(id);
    }

    @Override
    public List<UserModel> getAllAccounts() {
        return accountRepository.getAll();
    }

    @Override
    public UserModel getAccountById(int id) {
        return accountRepository.getById(id);
    }
}
