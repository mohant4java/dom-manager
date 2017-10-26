package com.dmc.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="resident")
public class Resident {
    public enum RESIDENT_TYPE {OWNER, TENANT};
    private Long id;
    private String name;
    private String phoneNumber;
    private String type;
    private boolean isPrimaryResident;
    private Timestamp in;
    private Timestamp out;
    private Flat flat;



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPrimaryResident() {
        return isPrimaryResident;
    }

    public void setPrimaryResident(boolean primaryResident) {
        isPrimaryResident = primaryResident;
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
    @ManyToOne(fetch = FetchType.EAGER)
    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }
}
