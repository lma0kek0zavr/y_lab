package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.ylab.model.TargetModel;
import io.ylab.model.UserModel;
import io.ylab.service.TargetService;
import io.ylab.storage.TargetStorage;

public class TargetserviceTest {
    @Test
    void shouldCreateTarget() {
        TargetService targetService = new TargetService(new TargetStorage());
        UserModel user = new UserModel("name1", "email1", "password1");
        TargetModel target = new TargetModel(1000);
        targetService.createTarget(user, target);
        assertEquals(1, targetService.getAllTargets(user).size());
    }
}
