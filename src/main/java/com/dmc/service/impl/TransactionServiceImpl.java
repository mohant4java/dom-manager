package com.dmc.service.impl;

import com.dmc.dao.FlatRepository;
import com.dmc.dto.TransactionDto;
import com.dmc.model.Flat;
import com.dmc.model.Transactions;
import com.dmc.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private FlatRepository flatRepository;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    @Override
    @Transactional
    public void addTransaction(String flatName, Transactions transactions) {
        Flat flat = flatRepository.findByName(flatName);
        flat.getTransactions().add(transactions);
    }

    @Override
    @Transactional
    public void addMaintenance(String month, float sftRate) {
        Timestamp currentTimestamp = new Timestamp(new Date().getTime());
        flatRepository.findAll().stream().forEach(flat -> {
            Transactions tx = new Transactions();
            tx.setAmount(Math.round(flat.getAbsoluteMainteance(sftRate)));
            tx.setStatus(Transactions.STATUS.PENDING.toString());
            tx.setType(Transactions.TYPE.MAINTENANCE.toString());
            tx.setComments("Maintenance for "+month);
            tx.setLastUpdatedOn(currentTimestamp);
            tx.setFlat(flat);
            try {
                tx.setRequestedDate(new Timestamp(format.parse(month).getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            flat.getTransactions().add(tx);
        });
    }

    @Override
    public List<TransactionDto> getTransactions() {
        List<Flat> flats = flatRepository.findAll();
        List<TransactionDto> transactionDtos  = new ArrayList<>();
        for(Flat flat : flats){
            List<Transactions> transactions = flat.getTransactions();
            transactionDtos.addAll(transactions.stream().map(tx->convert(flat,tx)).collect(Collectors.toList()));
        }
        System.out.println("Getting all transactions");
        return  transactionDtos;
    }

    private TransactionDto convert(Flat flat, Transactions transactions) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setAmount(transactionDto.getAmount());
        transactionDto.setComments(transactionDto.getComments());
        transactionDto.setFlat(flat.getName());
        transactionDto.setId(transactions.getId());
        transactionDto.setLastUpdatedOn(transactions.getLastUpdatedOn());
        transactionDto.setReference(transactions.getReference());
        transactionDto.setIn(transactions.getIn());
        transactionDto.setOut(transactions.getOut());
        transactionDto.setType(transactions.getType());
        transactionDto.setStatus(transactions.getStatus());
        return transactionDto;
    }


}
