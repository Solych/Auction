package com.auction.model;

import javax.persistence.*;

@Entity
@Table(name = "CARD", schema = "auction")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARD_ID")
    private Integer cardId;

    @Column(name = "CVC", columnDefinition="char")
    private String cvc;

    @Column(name = "NUMBER", columnDefinition="char")
    private String number;

    @Column(name = "VALID", columnDefinition="char")
    private String valid;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }
}
