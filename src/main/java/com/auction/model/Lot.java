package com.auction.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "LOT", schema = "auction")
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOT_ID")
    private Integer lotId;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "SUBCATEGORY_ID")
    private Subcategory subcategory;

    @Column(name = "NAME", length = 30)
    private String name;

    @Column(name = "STEP")
    private Integer step;

    @Column(name = "MIN_PRICE")
    private Integer minPrice;

    @Column(name = "DATE_OF_PUT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfPut;

    @Column(name = "SELL_DATE")
    @Temporal(TemporalType.DATE)
    private Date sellDate;

    @Column(name = "FILTER", length = 30)
    private String filter;

    @Column(name = "DEAL_TYPE", length = 15)
    private String dealType;

    @Column(name = "STATE")
    private Byte state;

    @Column(name = "COUNTRY", columnDefinition="char(3)")
    private String country;

    @Column(name = "PRICE_FOR_SELLING")
    private Integer priceForSelling;

    @Column(name = "IS_APPROVED")
    private Boolean isApproved;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "pictureId")
    @JsonIgnore
    private Set<Pictures> picturesSet;

    public Set<Pictures> getPicturesSet() {
        return picturesSet;
    }

    public void setPicturesSet(Set<Pictures> picturesSet) {
        this.picturesSet = picturesSet;
    }

    public Integer getLotId() {
        return lotId;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Date getDateOfPut() {
        return dateOfPut;
    }

    public void setDateOfPut(Date dateOfPut) {
        this.dateOfPut = dateOfPut;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPriceForSelling() {
        return priceForSelling;
    }

    public void setPriceForSelling(Integer priceForSelling) {
        this.priceForSelling = priceForSelling;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
