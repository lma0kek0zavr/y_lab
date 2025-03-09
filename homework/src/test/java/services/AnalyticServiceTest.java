package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.ylab.model.TransactionModel;
import io.ylab.model.UserModel;
import io.ylab.repository.BudgetRepository;
import io.ylab.repository.TransactionRepository;
import io.ylab.service.AnalyticService;
import io.ylab.service.BudgetService;
import io.ylab.service.TransactionService;
import io.ylab.storage.BudgetStorage;
import io.ylab.storage.TransactionStorage;
import io.ylab.util.TransactionType;

public class AnalyticServiceTest {
    @Test
    void shouldReturnCurrentBalance() { 
        TransactionRepository transactionRepository = new TransactionStorage();
        UserModel user = new UserModel("name1", "email1", "password1");
        BudgetRepository budgetRepository = new BudgetStorage();
        BudgetService budgetService = new BudgetService(budgetRepository);
        TransactionService transactionService = new TransactionService(transactionRepository);
        transactionService.createTransaction(user, new TransactionModel("category1", "description1", 100, TransactionType.EXPENSE));
        AnalyticService analyticService = new AnalyticService(budgetRepository, transactionRepository);
        budgetService.setMonthlyBudget(user, 1000.0);
        assertEquals(900, analyticService.getCurrentBalance(user));
    }

    @Test
    void shouldReturnTotalIncome() { 
        TransactionRepository transactionRepository = new TransactionStorage();
        UserModel user = new UserModel("name1", "email1", "password1");
        AnalyticService analyticService = new AnalyticService(new BudgetStorage(), transactionRepository);
        TransactionService transactionService = new TransactionService(transactionRepository);
        transactionService.createTransaction(user, new TransactionModel("category1", "description1", 100, TransactionType.INCOME));
        assertEquals(100, analyticService.getTotalIncome(user));
    }

    @Test
    void shouldReturnTotalExpense() { 
        TransactionRepository transactionRepository = new TransactionStorage();
        UserModel user = new UserModel("name1", "email1", "password1");
        AnalyticService analyticService = new AnalyticService(new BudgetStorage(), transactionRepository);
        TransactionService transactionService = new TransactionService(transactionRepository);
        transactionService.createTransaction(user, new TransactionModel("category1", "description1", 100, TransactionType.EXPENSE));
        assertEquals(100, analyticService.getTotalExpense(user));
    }
}
