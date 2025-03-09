package io.ylab.service;

import java.util.List;

import io.ylab.model.TargetModel;
import io.ylab.model.UserModel;
import io.ylab.repository.TargetRepository;

public class TargetService {
    private TargetRepository targetRepository;

    public TargetService(TargetRepository targetRepository) {
        this.targetRepository = targetRepository;
    }

    public void createTarget(UserModel user, TargetModel targetModel) {
        targetRepository.save(user, targetModel);
    }

    public double checkTarget(UserModel user, int id) { 
        TargetModel target = targetRepository.get(user, id);
        return (target.getTarget() / 100) * target.getCurrentSavings();
    }

    public List<TargetModel> getAllTargets(UserModel user) {
        return targetRepository.getAll(user);
    }
}
