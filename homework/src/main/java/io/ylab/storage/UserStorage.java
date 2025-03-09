package io.ylab.storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.ylab.model.UserModel;
import io.ylab.repository.AccountRepository;

public class UserStorage implements AccountRepository {
    private Map<Integer, UserModel> users;

    public UserStorage() {
        users = new HashMap<>();
    }

    @Override
    public UserModel getById(int id) {
        return users.get(id);
    }

    @Override
    public void save(String name, String email, String password) {
        UserModel user = new UserModel(name, email, password);
        users.put(user.getId(), user);
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
    public void update(int id, UserModel user) {
        UserModel userToUpdate = users.get(id);
        users.replace(id, userToUpdate, user);
    }

    @Override
    public void blockUser(int id) {
        users.get(id).setStatus(true);
    }
}
