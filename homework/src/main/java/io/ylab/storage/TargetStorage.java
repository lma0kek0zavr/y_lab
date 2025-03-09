package io.ylab.storage;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.ylab.model.TargetModel;
import io.ylab.model.UserModel;
import io.ylab.repository.TargetRepository;

public class TargetStorage implements TargetRepository{
    private Map<UserModel, List<TargetModel>> userTargets;

    public TargetStorage() {
        userTargets = new HashMap<>();
    }

    @Override
    public TargetModel get(UserModel user, int id) {
        return userTargets.get(user).stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(UserModel user, TargetModel targetModel) {
        if(!userTargets.containsKey(user)) {
            userTargets.put(user, new ArrayList<>());
        }
        userTargets.get(user).add(targetModel);
    }

    @Override
    public List<TargetModel> getAll(UserModel user) {
        return userTargets.get(user);
    }
}
