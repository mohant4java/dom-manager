package com.dmc;

import com.dmc.dto.TransactionDto;
import com.dmc.model.Transactions;
import com.dmc.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import javax.ws.rs.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Path("/treasury")
public class TreasuryResource {

    @Autowired
    private TransactionService transactionService;

    @POST
    @Path("/{flatName}")
    public void addTransaction(@PathParam("flatName") String flatName, Transactions transactions){
            transactionService.addTransaction(flatName, transactions);
    }

    @POST
    @Path("/maintenance")
    public void addTransaction(@QueryParam("month") String month, @QueryParam("sftRate") float sftRate){
        transactionService.addMaintenance(month, sftRate);
    }

    @GET
    @Path("/transactions")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<TransactionDto> getPendingTransactions(@QueryParam("status") String status ){
        return (status ==null || status.trim().length() == 0) ? transactionService.getTransactions(): transactionService.getTransactions().stream().filter(tx -> tx.getStatus().equals(status)).collect(Collectors.toList());
    }
}
