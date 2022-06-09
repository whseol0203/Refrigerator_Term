package com.example.refrigerator;

import com.google.firebase.firestore.FirebaseFirestore;

public class UserInfo {
    private String userName;
    private String id;
    private String pwd;
    private String userMode;
    private boolean isLogin;

    public UserInfo(String userName, String id, String pwd, String userMode) {
        this.userName = userName;
        this.id = id;
        this.pwd = pwd;
        this.userMode = userMode;
    }

    public UserInfo getUserInfo(){
        return this;
    }

    public String getUserMode() {
        return userMode;
    }

    public String getUserName() {
        return userName;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setUserMode(String userMode) {
        this.userMode = userMode;
    }

    public boolean isLogin(){
        return isLogin;
    }
}
