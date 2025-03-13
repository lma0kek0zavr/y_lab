package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.ylab.model.UserModel;
import io.ylab.repository.imp.AccountRepositoryImp;
import io.ylab.repository.imp.BudgetRepositoryImp;
import io.ylab.service.AccountService;
import io.ylab.service.BudgetService;
import io.ylab.service.imp.AccountServiceImp;
import io.ylab.service.imp.BudgetServiceImp;

public class BudgetServiceTest {
    @Test
    @DisplayName("Should create budget")
    void createBudget() {
        BudgetService budgetService = new BudgetServiceImp(new BudgetRepositoryImp());
        AccountService accountService = new AccountServiceImp(new AccountRepositoryImp());

        accountService.createAccount("name1", "email1", "password1");
        UserModel user = accountService.getAllAccounts().get(0);
        budgetService.setMonthlyBudget(user, 1000);

        assertEquals(1000, budgetService.getMonthlyBudget(user));
    }

    @Test
    @DisplayName("Should check is budget over")
    void returnTrueWhenBudgetIsOver() {
        BudgetService budgetService = new BudgetServiceImp(new BudgetRepositoryImp());
        AccountService accountService = new AccountServiceImp(new AccountRepositoryImp());

        accountService.createAccount("name1", "email1", "password1");
        UserModel user = accountService.getAllAccounts().get(0);
        budgetService.setMonthlyBudget(user, 1000);
        budgetService.setExpense(user, 2000);

        assertEquals(false, budgetService.checkBudget(user));
    }

    @Test
    @DisplayName("Should check is budget not over")
    void returnTrueWhenBudgetIsNotOver() {
        BudgetService budgetService = new BudgetServiceImp(new BudgetRepositoryImp());
        AccountService accountService = new AccountServiceImp(new AccountRepositoryImp());

        accountService.createAccount("name1", "email1", "password1");
        UserModel user = accountService.getAllAccounts().get(0);
        budgetService.setMonthlyBudget(user, 1000);
        budgetService.setExpense(user, 500);
        
        assertEquals(true, budgetService.checkBudget(user));
    }
}
