package com.auction.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FACT_SALE", schema = "auction")
public class FactSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FACT_SALE_ID")
    private Integer factSaleId;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "LOT_ID")
    private Lot lot;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SALE_TIME")
    private Date saleTime;

    @Column(name = "PRICE")
    private Integer price;

    public Integer getFactSaleId() {
        return factSaleId;
    }

    public void setFactSaleId(Integer factSaleId) {
        this.factSaleId = factSaleId;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
}
