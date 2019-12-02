package com.auction.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MESSAGE", schema = "auction")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    private Integer messageId;

    @ManyToOne
    @JoinColumn(name = "TO_USER")
    private User toUser;

    @ManyToOne
    @JoinColumn(name = "FROM_USER")
    private User fromUser;

    @Column(name = "MESSAGE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date messageDate;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }
}
