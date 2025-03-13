package io.ylab.repository.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.ylab.model.UserModel;
import io.ylab.repository.AccountRepository;

/**
 * Реализация интерфейса {@link AccountRepository}.
 * Реализует crud операции для пользователей.
 */
public class AccountRepositoryImp implements AccountRepository {
    private Map<Integer, UserModel> users;

    public AccountRepositoryImp() { 
        this.users = new HashMap<>();
    }

    @Override
    public UserModel getById(int id) {
        return users.get(id);
    }

    @Override
    public void save(String name, String email, String password) {
        UserModel userToSave = new UserModel(name, email, password);
        users.put(userToSave.getId(), userToSave);
    }

    @Override
    public void update(int id, UserModel userToSave) {
        UserModel userToUpdate = users.get(id);
        users.replace(id, userToUpdate, userToSave);
    }

    @Override
    public void delete(int id) {
        users.remove(id);
    }

    @Override
    public List<UserModel> getAll() {
        return users.values().stream().toList();
    }

    @Override
    public void blockUser(int id) {
        UserModel user = users.get(id);
        user.setStatus(false);
        users.replace(id, user, user);
    }
}
