package io.ylab.repository.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.ylab.model.TargetModel;
import io.ylab.model.UserModel;
import io.ylab.repository.AccountRepository;
import io.ylab.repository.TargetRepository;

/**
 * Реализация интерфейса {@link AccountRepository}.
 * Реализует crud операции для целей пользователя.
 */
public class TargetRepositoryImp implements TargetRepository {
    private Map<UserModel, List<TargetModel>> userTargets;

    public TargetRepositoryImp() {
        this.userTargets = new HashMap<>();
    }

    @Override
    public TargetModel get(UserModel user, int id) {
        return userTargets.get(user).stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(UserModel user, int amount) {
        TargetModel target = new TargetModel(amount);
        if (!userTargets.containsKey(user)) {
            userTargets.put(user, new ArrayList<>());
        }
        userTargets.get(user).add(target);
    }

    @Override
    public void update(UserModel user, TargetModel targetToSave) {
        TargetModel targetToUpdate = get(user, targetToSave.getId());
        userTargets.get(user).remove(targetToUpdate);
        userTargets.get(user).add(targetToSave);
    }

    @Override
    public List<TargetModel> getAll(UserModel user) {
        return userTargets.get(user);
    }
    
}
