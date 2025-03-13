package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.ylab.model.UserModel;
import io.ylab.repository.imp.TargetRepositoryImp;
import io.ylab.service.TargetService;
import io.ylab.service.imp.TargetServiceImp;

public class TargetserviceTest {
    @Test
    @DisplayName("Should create target")
    void createTarget() {
        TargetService targetService = new TargetServiceImp(new TargetRepositoryImp());

        UserModel user = new UserModel("name1", "email1", "password1");
        targetService.createTarget(user, 1000);

        assertEquals(1, targetService.getAllTargets(user).size());
    }
}
