package io.ylab.service;

import java.util.List;

import io.ylab.model.UserModel;
import io.ylab.repository.AccountRepository;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository userRepository) {
        this.accountRepository = userRepository;
    }

    public UserModel getById(int id) {
        return accountRepository.getById(id);
    }

    public void createAccount(String name, String email, String password) {
        accountRepository.save(name, email, password);
    }

    public void deleteAccount(int id) {
        accountRepository.delete(id);
    }

    public void updateUserName(int id, String name) {
        UserModel user = accountRepository.getById(id);
        user.setName(name);
        accountRepository.update(id, user);
    }

    public void updatePassword(int id, String password) {
        UserModel user = accountRepository.getById(id);
        user.setPassword(password);
        accountRepository.update(id, user);
    }

    public void updateEmail(int id, String email) {
        UserModel user = accountRepository.getById(id);
        user.setEmail(email);
        accountRepository.update(id, user);
    }

    public void blockAccount(int id) {
        accountRepository.blockUser(id);
    }

    public List<UserModel> getAllAccounts() {
        return accountRepository.getAll();
    }
}
