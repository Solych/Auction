package com.auction.model.dto;

import java.util.Date;

public class PuttingLot {
    private String name;
    private int categoryIndex;
    private int subcategoryIndex;
    private String optionalField;
    private Byte state;
    private int minPrice;
    private int step;
    private String dealType;
    private String description;
    private String[] photos;
    private String country;
    private Integer priceForSelling;
    private Date sellDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryIndex() {
        return categoryIndex;
    }

    public void setCategoryIndex(int categoryIndex) {
        this.categoryIndex = categoryIndex;
    }

    public int getSubcategoryIndex() {
        return subcategoryIndex;
    }

    public void setSubcategoryIndex(int subcategoryIndex) {
        this.subcategoryIndex = subcategoryIndex;
    }

    public String getOptionalField() {
        return optionalField;
    }

    public void setOptionalField(String optionalField) {
        this.optionalField = optionalField;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getPhotos() {
        return photos;
    }

    public void setPhotos(String[] photos) {
        this.photos = photos;
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

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }
}
