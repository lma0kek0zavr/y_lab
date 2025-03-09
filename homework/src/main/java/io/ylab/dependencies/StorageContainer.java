package io.ylab.dependencies;

import io.ylab.storage.BudgetStorage;
import io.ylab.storage.TargetStorage;
import io.ylab.storage.TransactionStorage;
import io.ylab.storage.UserStorage;

public enum StorageContainer {
    GET_STORAGE;

    private static final UserStorage userStorage = new UserStorage();
    private static final TransactionStorage transactionStorage = new TransactionStorage();
    private static final BudgetStorage budgetStorage = new BudgetStorage();
    private static final TargetStorage targetStorage = new TargetStorage();

    public UserStorage userStorage() { return userStorage; }
    public TransactionStorage transactionStorage() { return transactionStorage; }
    public BudgetStorage budgetStorage() { return budgetStorage; }
    public TargetStorage TargetStorage() { return targetStorage; }
}
