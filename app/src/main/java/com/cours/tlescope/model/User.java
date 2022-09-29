package com.cours.tlescope.model;

public class User {
    public int userId;
    public String userName;
    public String userPrenom;
    public String userMdp;
    public String userMail;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User(String userName, String userPrenom, String userMdp, String userMail) {
        this.userName = userName;
        this.userPrenom = userPrenom;
        this.userMdp = userMdp;
        this.userMail = userMail;
    }

    public User(String userMail, String userMdp) {
        this.userMdp = userMdp;
        this.userMail = userMail;
    }

    public String getUserPrenom() {
        return userPrenom;
    }

    public void setUserPrenom(String userPrenom) {
        this.userPrenom = userPrenom;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMdp() {
        return userMdp;
    }

    public void setUserMdp(String userMdp) {
        this.userMdp = userMdp;
    }
}
