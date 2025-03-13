package io.ylab.service;

import java.util.List;

import io.ylab.model.TargetModel;
import io.ylab.model.UserModel;

/**
 * Интерфейс сервиса для работы с целями пользователя
 */
public interface TargetService {
    void createTarget(UserModel user, int target);
    void updateSavings(UserModel user, int id, int newSavings);
    List<TargetModel> getAllTargets(UserModel user);
    String checkTarget(UserModel user, int id);
}
