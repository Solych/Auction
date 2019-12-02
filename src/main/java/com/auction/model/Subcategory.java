package com.auction.model;

import javax.persistence.*;

@Entity
@Table(name = "SUBCATEGORY", schema = "auction")
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBCATEGORY_ID")
    private Integer subcategoryId;

    @Column(name = "SUBCATEGORY_NAME", length = 70)
    private String subcategoryName;

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }
}
