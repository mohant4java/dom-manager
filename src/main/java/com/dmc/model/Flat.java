package com.dmc.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="flat")
public class Flat {

    public enum FLAT_TYPE { TWO_BHK, THREE_BHK}

    @Column( unique = true, nullable = false, length = 5)
    private String name;
    @Column( unique = true, nullable = false)
    private int sft;
    @Column( unique = true, nullable = false)
    private int terraceSft;
    @Column( unique = true, nullable = false, length = 5)
    private String type;

    private List<Resident> residents;
    private List<Transactions> transactions;

    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSft() {
        return sft;
    }

    public void setSft(int sft) {
        this.sft = sft;
    }

    public int getTerraceSft() {
        return terraceSft;
    }

    public void setTerraceSft(int terraceSft) {
        this.terraceSft = terraceSft;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Resident> getResidents() {
        return residents;
    }

    public void setResidents(List<Resident> residents) {
        this.residents = residents;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public long getAbsoluteMainteance(float sftRate){
        return Math.round((this.sft + this.terraceSft * (1.0/3)) * sftRate);
    }
}
