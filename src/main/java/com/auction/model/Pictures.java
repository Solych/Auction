package com.auction.model;

import javax.persistence.*;

@Entity
@Table(name = "PICTURES", schema = "auction")
public class Pictures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PICTURE_ID")
    private Integer pictureId;

    @Column(name = "PICTURE", columnDefinition = "longblob")
    @Lob
    private String picture;

    @ManyToOne
    @JoinColumn(name = "LOT_ID")
    private Lot lot;

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }
}
