package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.ylab.model.UserModel;
import io.ylab.service.AccountService;
import io.ylab.service.BudgetService;
import io.ylab.storage.BudgetStorage;
import io.ylab.storage.UserStorage;

public class BudgetServiceTest {
    @Test
    void shouldCreateBudget() {
        BudgetService budgetService = new BudgetService(new BudgetStorage());
        AccountService accountService = new AccountService(new UserStorage());
        accountService.createAccount("name1", "email1", "password1");
        UserModel user = accountService.getAllAccounts().get(0);
        budgetService.setMonthlyBudget(user, 1000);
        assertEquals(1000, budgetService.getMonthlyBudget(user));
    }

    @Test
    void shouldReturnTrueWhenBudgetIsOver() {
        BudgetService budgetService = new BudgetService(new BudgetStorage());
        AccountService accountService = new AccountService(new UserStorage());
        accountService.createAccount("name1", "email1", "password1");
        UserModel user = accountService.getAllAccounts().get(0);
        budgetService.setMonthlyBudget(user, 1000);
        budgetService.setExpense(user, 2000);
        assertEquals(true, budgetService.checkBudget(user));
    }

    @Test
    void shouldReturnTrueWhenBudgetIsNotOver() {
        BudgetService budgetService = new BudgetService(new BudgetStorage());
        AccountService accountService = new AccountService(new UserStorage());
        accountService.createAccount("name1", "email1", "password1");
        UserModel user = accountService.getAllAccounts().get(0);
        budgetService.setMonthlyBudget(user, 1000);
        budgetService.setExpense(user, 500);
        assertEquals(true, budgetService.checkBudget(user));
    }
}
