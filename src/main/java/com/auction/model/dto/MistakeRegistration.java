package com.auction.model.dto;

public class MistakeRegistration {
    private boolean isUsername;
    private boolean isMail;

    public boolean isUsername() {
        return isUsername;
    }

    public void setUsername(boolean username) {
        isUsername = username;
    }

    public boolean isMail() {
        return isMail;
    }

    public void setMail(boolean mail) {
        isMail = mail;
    }

    public MistakeRegistration() {
        this.isUsername = false;
        this.isMail = false;
    }
}
