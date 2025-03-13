package io.ylab.model;

import java.time.LocalDate;

import io.ylab.util.TransactionType;

/**
 * Сущность транзакций
 */
public class TransactionModel {
    private int id;
    private String category;
    private String description;
    private int amount;
    private LocalDate time;
    private TransactionType type;

    private static int transactionId = 0;

    public TransactionModel(String category, String description, int amount, TransactionType type) {
        this.id = ++transactionId;
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.time = LocalDate.now();
        this.type = type;
    }

    public int getId() {
        return id;
    }
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return time;
    }

    public void setDate(LocalDate time) {
        this.time = time;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    
    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", time=" + time +
                ", type=" + type +
                '}';
    }
}
