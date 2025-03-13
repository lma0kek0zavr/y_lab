package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.ylab.model.UserModel;
import io.ylab.repository.AccountRepository;
import io.ylab.repository.BudgetRepository;
import io.ylab.repository.TargetRepository;
import io.ylab.repository.TransactionRepository;
import io.ylab.repository.imp.AccountRepositoryImp;
import io.ylab.repository.imp.BudgetRepositoryImp;
import io.ylab.repository.imp.TargetRepositoryImp;
import io.ylab.repository.imp.TransactionRepositoryImp;
import io.ylab.service.TransactionService;
import io.ylab.service.imp.TransactionServiceImp;
import io.ylab.util.TransactionType;

public class TransactionServiceTest {
    AccountRepository accountRepository = new AccountRepositoryImp();
        BudgetRepository budgetRepository = new BudgetRepositoryImp();
        TargetRepository targetRepository = new TargetRepositoryImp();
        TransactionRepository transactionRepository = new TransactionRepositoryImp();
    @Test
    @DisplayName("Should create transaction")
    void createTransaction() {
        TransactionService transactionService = new TransactionServiceImp(transactionRepository);

        UserModel user = new UserModel("name1", "email1", "password1");
        transactionService.createTransaction(user, "category1", "description1", 100, TransactionType.INCOME);

        assertEquals(1, transactionService.getTransactionsByType(user, TransactionType.INCOME).size());
    }

    @Test
    @DisplayName("Should delete transaction")
    void deleteTransaction() {
        TransactionService transactionService = new TransactionServiceImp(transactionRepository);

        UserModel user = new UserModel("name1", "email1", "password1");
        transactionService.createTransaction(user, "category1", "description1", 100, TransactionType.INCOME);
        transactionService.deleteTransaction(user, 1);

        assertEquals(0, transactionService.getTransactionsByType(user, TransactionType.INCOME).size());
    }

    @Test
    @DisplayName("Should get transactions by type")
    void getTransactionsByType() {
        TransactionService transactionService = new TransactionServiceImp(transactionRepository);

        UserModel user = new UserModel("name1", "email1", "password1");
        transactionService.createTransaction(user, "category1", "description1", 100, TransactionType.INCOME);
        assertEquals(1, transactionService.getTransactionsByType(user, TransactionType.INCOME).size());
    }

    @Test
    @DisplayName("Should update transaction amount")
    void updateTransactionAmount() {
        TransactionService transactionService = new TransactionServiceImp(transactionRepository);

        UserModel user = new UserModel("name1", "email1", "password1");
        transactionService.createTransaction(user, "category1", "description1", 100, TransactionType.INCOME);
        transactionService.updateTransactionAmount(user, 2, 200);

        assertEquals(200, transactionService.getTransactionsByType(user, TransactionType.INCOME).get(0).getAmount());
    }

    @Test
    @DisplayName("Should update transaction category")
    void updateTransactionCategory() {
        TransactionService transactionService = new TransactionServiceImp(transactionRepository);

        UserModel user = new UserModel("name1", "email1", "password1");
        transactionService.createTransaction(user, "category1", "description1", 100, TransactionType.INCOME);
        transactionService.updateTransactionCategory(user, 3, "category2");

        assertEquals("category2", transactionService.getTransactionsByType(user, TransactionType.INCOME).get(0).getCategory());
    }

    @Test
    @DisplayName("Should update transaction description")
    void updateTransactionDescription() {
        TransactionService transactionService = new TransactionServiceImp(transactionRepository);

        UserModel user = new UserModel("name1", "email1", "password1");
        transactionService.createTransaction(user, "category1", "description1", 100, TransactionType.INCOME);
        transactionService.updateTransactionDescription(user, 6, "description2");

        assertEquals("description2", transactionService.getTransactionsByType(user, TransactionType.INCOME).get(0).getDescription());
    }
}
