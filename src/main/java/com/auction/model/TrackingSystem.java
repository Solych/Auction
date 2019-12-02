package com.auction.model;

import javax.persistence.*;

@Entity
@Table(name = "TRACKING_SYSTEM", schema = "auction")
public class TrackingSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRACKING_SYSTEM_ID")
    private Integer trackingSystemId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "LOT_ID")
    private Lot lot;
}
