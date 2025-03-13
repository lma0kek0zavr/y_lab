package io.ylab.api;

import io.ylab.model.UserModel;
import io.ylab.service.imp.BudgetServiceImp;
import io.ylab.service.imp.NotificationServiceImp;

/**
 * Иммитация api для финансовых операций
 */
public class FinanceApi {
    private BudgetServiceImp budgetService;
    private NotificationServiceImp notificationService;

    public FinanceApi(BudgetServiceImp budgetService, NotificationServiceImp notificationService) {
        this.budgetService = budgetService;
        this.notificationService = notificationService;
    }

    /**
    * Проверяет, превышен ли бюджет пользователя.
    *
    * @param user Пользователь чей бюджет проверяется.
    * @return Строка с уведомлением о превышении бюджета.
    */
    public String notifyAboutOverExpense(UserModel user) {
        return budgetService.checkBudget(user) ? notificationService.sendNotification("Your budget is over") : null;
    }
}
