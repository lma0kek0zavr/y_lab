package io.ylab;

import io.ylab.repository.AccountRepository;
import io.ylab.repository.BudgetRepository;
import io.ylab.repository.TargetRepository;
import io.ylab.repository.TransactionRepository;
import io.ylab.repository.imp.AccountRepositoryImp;
import io.ylab.repository.imp.BudgetRepositoryImp;
import io.ylab.repository.imp.TargetRepositoryImp;
import io.ylab.repository.imp.TransactionRepositoryImp;
import io.ylab.service.AccountService;
import io.ylab.service.AnalyticService;
import io.ylab.service.AuthService;
import io.ylab.service.BudgetService;
import io.ylab.service.NotificationService;
import io.ylab.service.TargetService;
import io.ylab.service.TransactionService;
import io.ylab.service.imp.AccountServiceImp;
import io.ylab.service.imp.AnalyticServiceImp;
import io.ylab.service.imp.AuthServiceImp;
import io.ylab.service.imp.BudgetServiceImp;
import io.ylab.service.imp.NotificationServiceImp;
import io.ylab.service.imp.TargetServiceImp;
import io.ylab.service.imp.TransactionServiceImp;
import io.ylab.util.TransactionType;

public class App {
    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepositoryImp();
        BudgetRepository budgetRepository = new BudgetRepositoryImp();
        TargetRepository targetRepository = new TargetRepositoryImp();
        TransactionRepository transactionRepository = new TransactionRepositoryImp();

        //Account service
        AccountService accountService = new AccountServiceImp(accountRepository);
        accountService.createAccount("Ivan", "ivan@mail.ru", "123");
        accountService.createAccount("Petr", "petr@mail.ru", "123");
        System.out.println(accountService.getAllAccounts().toString());
        accountService.updateUserName(1, "vasilyi");
        accountService.updateEmail(1, "vasilyi@mail.ru");
        System.out.println(accountService.getAllAccounts().toString());
        accountService.blockAccount(1);
        System.out.println(accountService.getAllAccounts().toString());
        accountService.deleteAccount(1);
        System.out.println(accountService.getAllAccounts().toString());

        //Budget service
        BudgetService budgetService = new BudgetServiceImp(budgetRepository);
        budgetService.setMonthlyBudget(accountService.getAccountById(2), 1000);
        budgetService.setExpense(accountService.getAccountById(2), 500);
        System.out.println(budgetService.checkBudget(accountService.getAccountById(2)));

        //Transaction service
        TransactionService transactionService = new TransactionServiceImp(transactionRepository);
        transactionService.createTransaction(accountService.getAccountById(2), "food", "milk", 100, TransactionType.EXPENSE);
        transactionService.createTransaction(accountService.getAccountById(2), "food", "chocolate", 200, TransactionType.EXPENSE);
        transactionService.createTransaction(accountService.getAccountById(2), "money", "salary", 250, TransactionType.INCOME);
        transactionService.updateTransactionAmount(accountService.getAccountById(2), 1, 300);
        transactionService.updateTransactionCategory(accountService.getAccountById(2), 2, "yumy");
        transactionService.updateTransactionDescription(accountService.getAccountById(2), 2, "dark chocolate");
        System.out.println(transactionService.getTransactionsByType(accountService.getAccountById(2), TransactionType.EXPENSE).toString());
        System.out.println(transactionService.getTransactionsByCategory(accountService.getAccountById(2), "yumy").toString());

        //Auth service
        AuthService authService = new AuthServiceImp(accountRepository);
        System.out.println(authService.login(2, "123"));

        //Target service
        TargetService targetService = new TargetServiceImp(targetRepository);
        targetService.createTarget(accountService.getAccountById(2), 15000);
        targetService.updateSavings(accountService.getAccountById(2), 1, 5000);
        System.out.println(targetService.checkTarget(accountService.getAccountById(2), 1));

        //Notification service
        NotificationService notificationService = new NotificationServiceImp(accountRepository);
        System.out.println(notificationService.subscribe(2));
        System.out.println(notificationService.sendNotification("Hello"));

        //Analytic service
        AnalyticService analyticService = new AnalyticServiceImp(budgetRepository, transactionRepository);
        System.out.println(analyticService.getCurrentBalance(accountService.getAccountById(2)));
        System.out.println(analyticService.getTotalIncome(accountService.getAccountById(2)));
        System.out.println(analyticService.getTotalExpense(accountService.getAccountById(2)));
        System.out.println(analyticService.getTransactionsByType(accountService.getAccountById(2)));
        System.out.println(analyticService.getReport(accountService.getAccountById(2)));
    }
}