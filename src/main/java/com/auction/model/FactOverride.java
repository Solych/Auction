package com.auction.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FACT_OVERRIDE", schema = "auction")
public class FactOverride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FACT_OVERRIDE_ID")
    private Integer factOverrideId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "LOT_ID")
    private Lot lot;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OVERRIDE_TIME")
    private Date overrideTime;

    @Column(name = "PRICE")
    private Integer price;

    public Integer getFactOverrideId() {
        return factOverrideId;
    }

    public void setFactOverrideId(Integer factOverrideId) {
        this.factOverrideId = factOverrideId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Date getOverrideTime() {
        return overrideTime;
    }

    public void setOverrideTime(Date overrideTime) {
        this.overrideTime = overrideTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
