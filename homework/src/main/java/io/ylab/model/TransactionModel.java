package io.ylab.model;

import java.time.LocalDateTime;

import io.ylab.util.TransactionType;

public class TransactionModel {
    private int id;
    private String category;
    private String description;
    private double amount;
    private LocalDateTime time;
    private TransactionType type;

    private static int transactionId = 0;

    public TransactionModel(String category, String description, double amount, TransactionType type) {
        this.id = ++transactionId;
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.time = LocalDateTime.now();
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return time;
    }

    public void setDate(LocalDateTime time) {
        this.time = time;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
