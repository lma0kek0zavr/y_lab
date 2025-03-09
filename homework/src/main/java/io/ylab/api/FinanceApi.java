package io.ylab.api;

import io.ylab.model.UserModel;
import io.ylab.service.BudgetService;
import io.ylab.service.NotificationService;

public class FinanceApi {
    private BudgetService budgetService;
    private NotificationService notificationService;

    public FinanceApi(BudgetService budgetService, NotificationService notificationService) {
        this.budgetService = budgetService;
        this.notificationService = notificationService;
    }

    public String notifyAboutOverExpense(UserModel user) {
        return budgetService.checkBudget(user) ? notificationService.sendNotification("Your budget is over") : null;
    }
}
