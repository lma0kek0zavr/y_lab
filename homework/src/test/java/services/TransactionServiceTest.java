package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.ylab.model.TransactionModel;
import io.ylab.model.UserModel;
import io.ylab.service.TransactionService;
import io.ylab.storage.TransactionStorage;
import io.ylab.util.TransactionType;

public class TransactionServiceTest {
    @Test
    void shouldCreateTransaction() {
        TransactionService transactionService = new TransactionService(new TransactionStorage());
        UserModel user = new UserModel("name1", "email1", "password1");
        TransactionModel transaction = new TransactionModel("category1", "description1", 100, TransactionType.INCOME);
        transactionService.createTransaction(user, transaction);
        assertEquals(1, transactionService.getTransactionsByType(user, TransactionType.INCOME).size());
    }

    @Test
    void shouldDeleteTransaction() {
        TransactionService transactionService = new TransactionService(new TransactionStorage());
        UserModel user = new UserModel("name1", "email1", "password1");
        TransactionModel transaction = new TransactionModel("category1", "description1", 100, TransactionType.INCOME);
        transactionService.createTransaction(user, transaction);
        transactionService.deleteTransaction(user, transaction);
        assertEquals(0, transactionService.getTransactionsByType(user, TransactionType.INCOME).size());
    }

    @Test
    void shouldGetTransactionsByType() {
        TransactionService transactionService = new TransactionService(new TransactionStorage());
        UserModel user = new UserModel("name1", "email1", "password1");
        TransactionModel transaction = new TransactionModel("category1", "description1", 100, TransactionType.INCOME);
        transactionService.createTransaction(user, transaction);
        assertEquals(1, transactionService.getTransactionsByType(user, TransactionType.INCOME).size());
    }

    @Test
    void shouldUpdateTransactionAmount() {
        TransactionService transactionService = new TransactionService(new TransactionStorage());
        UserModel user = new UserModel("name1", "email1", "password1");
        TransactionModel transaction = new TransactionModel("category1", "description1", 100, TransactionType.INCOME);
        transactionService.createTransaction(user, transaction);
        transactionService.updateTransactionAmount(user, transaction.getId(), 200);
        assertEquals(200, transaction.getAmount());
    }

    @Test
    void shouldUpdateTransactionCategory() {
        TransactionService transactionService = new TransactionService(new TransactionStorage());
        UserModel user = new UserModel("name1", "email1", "password1");
        TransactionModel transaction = new TransactionModel("category1", "description1", 100, TransactionType.INCOME);
        transactionService.createTransaction(user, transaction);
        transactionService.updateTransactionCategory(user, transaction.getId(), "category2");
        assertEquals("category2", transaction.getCategory());
    }

    @Test
    void shouldUpdateTransactionDescription() {
        TransactionService transactionService = new TransactionService(new TransactionStorage());
        UserModel user = new UserModel("name1", "email1", "password1");
        TransactionModel transaction = new TransactionModel("category1", "description1", 100, TransactionType.INCOME);
        transactionService.createTransaction(user, transaction);
        transactionService.updateTransactionDescription(user, transaction.getId(), "description2");
        assertEquals("description2", transaction.getDescription());
    }
}
