package com.auction.model;
import javax.persistence.*;

@Entity
@Table(name = "USER", schema = "auction")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "USERNAME", unique = true, length = 30)
    private String username;

    @Column(name = "MAIL", length = 30, unique = true)
    private String mail;

    @Column(name = "PHONE", length = 20, unique = true)
    private String phone;

    @Column(name = "COUNTRY", length = 3)
    private String country;

    @Column(name = "NAME", length = 40)
    private String name;

    @Column(name = "surname", length = 40)
    private String surname;

    @Column(name = "PATRONYMIC", length = 40)
    private String patronymic;

    @Column(name = "PASSWORD", length = 20)
    private String password;

    @Column(name = "CITY", length = 40)
    private String city;

    @Column(name = "TOKEN", length = 100)
    private String token;

    @Column(name="Profile", length = 10)
    private String profile;

    @Column(name = "AVATAR", columnDefinition = "longblob")
    @Lob
    private byte[] avatar;

    @ManyToOne
    @JoinColumn(name = "USER_CARD")
    private Card card;

    @Column(name = "RATING")
    private Integer rating;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
