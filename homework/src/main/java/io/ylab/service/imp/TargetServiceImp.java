package io.ylab.service.imp;

import java.util.List;

import io.ylab.model.TargetModel;
import io.ylab.model.UserModel;
import io.ylab.repository.TargetRepository;
import io.ylab.service.TargetService;

/**
 * Реализация интерфейса {@link TargetService}.
 * Содержит методы для работы с целями.
 */
public class TargetServiceImp implements TargetService {
    private TargetRepository targetRepository;

    public TargetServiceImp(TargetRepository targetRepository) {
        this.targetRepository = targetRepository;
    }

    @Override
    public void createTarget(UserModel user, int target) {
        targetRepository.save(user, target);
    }

    @Override
    public void updateSavings(UserModel user, int id, int newSavings) {
        TargetModel target = targetRepository.get(user, id);
        target.setCurrentSavings(newSavings);
        targetRepository.update(user, target);
    }

    @Override
    public String checkTarget(UserModel user, int id) { 
        TargetModel target = targetRepository.get(user, id);
        double percentage = (double)target.getCurrentSavings() / target.getTarget() * 100;
        return String.format("%.1f %%", percentage);
    }

    @Override
    public List<TargetModel> getAllTargets(UserModel user) {
        return targetRepository.getAll(user);
    }
}
