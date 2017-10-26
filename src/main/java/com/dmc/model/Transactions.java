package com.dmc.model;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="transactions")
public class Transactions {
    public enum TYPE { MAINTENANCE, LATE_PAYMENT , GUEST_ROOM_1, GUEST_ROOM2, CLUB_HOUSE, FD_INTEREST, TENANT_MOVE_IN, TENANT_MOVE_OUT, RE_SALE }
    public enum STATUS { PENDING, PAID , APPROVED}
    private long id;
    private Timestamp RequestedDate;
    private Timestamp lastUpdatedOn;
    private Flat flat;
    private String type;
    private int amount;
    private String status;
    private String reference;
    private String comments;
    private Timestamp in;
    private Timestamp out;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(Timestamp lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    @ManyToOne(fetch = FetchType.EAGER)

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Timestamp getIn() {
        return in;
    }

    public void setIn(Timestamp in) {
        this.in = in;
    }

    public Timestamp getOut() {
        return out;
    }

    public void setOut(Timestamp out) {
        this.out = out;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getRequestedDate() {
        return RequestedDate;
    }

    public void setRequestedDate(Timestamp requestedDate) {
        RequestedDate = requestedDate;
    }
}
