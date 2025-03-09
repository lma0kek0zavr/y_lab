package io.ylab.repository;

import java.util.List;

import io.ylab.model.TargetModel;
import io.ylab.model.UserModel;

public interface TargetRepository {
    TargetModel get(UserModel user, int id);
    void save(UserModel user, TargetModel targetModel);
    List<TargetModel> getAll(UserModel user);
}
