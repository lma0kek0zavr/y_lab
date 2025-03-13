package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.ylab.model.UserModel;
import io.ylab.repository.BudgetRepository;
import io.ylab.repository.TransactionRepository;
import io.ylab.repository.imp.BudgetRepositoryImp;
import io.ylab.repository.imp.TransactionRepositoryImp;
import io.ylab.service.AnalyticService;
import io.ylab.service.BudgetService;
import io.ylab.service.TransactionService;
import io.ylab.service.imp.AnalyticServiceImp;
import io.ylab.service.imp.BudgetServiceImp;
import io.ylab.service.imp.TransactionServiceImp;
import io.ylab.util.TransactionType;

public class AnalyticServiceTest {
    @Test
    @DisplayName("should return current balance")
    void returnCurrentBalance() { 
        TransactionRepository transactionRepository = new TransactionRepositoryImp();
        BudgetRepository budgetRepository = new BudgetRepositoryImp();
        BudgetService budgetService = new BudgetServiceImp(budgetRepository);
        TransactionService transactionService = new TransactionServiceImp(transactionRepository);
        AnalyticService analyticService = new AnalyticServiceImp(budgetRepository, transactionRepository);

        UserModel user = new UserModel("name1", "email1", "password1");

        transactionService.createTransaction(user, "category1", "description1", 100, TransactionType.EXPENSE);
        budgetService.setMonthlyBudget(user, 1000);

        assertEquals(900, analyticService.getCurrentBalance(user));
    }

    @Test
    @DisplayName("should return total income")
    void returnTotalIncome() { 
        TransactionRepository transactionRepository = new TransactionRepositoryImp();
        AnalyticService analyticService = new AnalyticServiceImp(new BudgetRepositoryImp(), transactionRepository);
        TransactionService transactionService = new TransactionServiceImp(transactionRepository);
        
        UserModel user = new UserModel("name1", "email1", "password1");

        transactionService.createTransaction(user, "category1", "description1", 100, TransactionType.INCOME);

        assertEquals(100, analyticService.getTotalIncome(user));
    }

    @Test
    @DisplayName("should return total expense")
    void returnTotalExpense() { 
        TransactionRepository transactionRepository = new TransactionRepositoryImp();
        AnalyticService analyticService = new AnalyticServiceImp(new BudgetRepositoryImp(), transactionRepository);
        TransactionService transactionService = new TransactionServiceImp(transactionRepository);
        
        UserModel user = new UserModel("name1", "email1", "password1");

        transactionService.createTransaction(user, "category1", "description1", 100, TransactionType.EXPENSE);

        assertEquals(100, analyticService.getTotalExpense(user));
    }
}
