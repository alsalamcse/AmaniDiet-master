package com.aslan.amani.amanidiet.data;

/**
 * Created by aodai on 11/06/2018.
 */

public class Meals {

    private String description;
    private String time;

    private String keyId;

    private String email;

    public Meals() {
    }

    public Meals(String description, String time, String keyId) {
        this.description = description;
        this.time = time;
        this.keyId = keyId;
    }

    public Meals(String description, String time) {
        this.description = description;
        this.time = time;
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
