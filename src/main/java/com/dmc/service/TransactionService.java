package com.dmc.service;

import com.dmc.dto.TransactionDto;
import com.dmc.model.Transactions;

import java.util.List;

public interface TransactionService {
    void addTransaction(String flatName, Transactions transactions);
    void addMaintenance(String month, float sftRate);

    List<TransactionDto> getTransactions();
}

