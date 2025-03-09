package io.ylab.repository;

import java.util.List;

import io.ylab.model.UserModel;

public interface AccountRepository {
    UserModel getById(int id);
    void save(String name, String email, String password);
    void delete(int id);
    List<UserModel> getAll();
    void update(int id, UserModel user);
    void blockUser(int id);
}
