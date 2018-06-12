package com.aslan.amani.amanidiet.data;

/**
 * Created by aodai on 11/06/2018.
 */

public class Exercise {

    private double pushups;
    private double pullups;
    private double squats;

    private String keyId;

    private String email;

    public Exercise() {
    }

    public Exercise(double pushups, double pullups, double squats) {
        this.pushups = pushups;
        this.pullups = pullups;
        this.squats = squats;
        this.email = email;
    }

    public Exercise(double pushups, double pullups, double squats, String keyId) {
        this.pushups = pushups;
        this.pullups = pullups;
        this.squats = squats;
        this.keyId = keyId;
    }

    public double getPushups() {
        return pushups;
    }

    public void setPushups(double pushups) {
        this.pushups = pushups;
    }

    public double getPullups() {
        return pullups;
    }

    public void setPullups(double pullups) {
        this.pullups = pullups;
    }

    public double getSquats() {
        return squats;
    }

    public void setSquats(double squats) {
        this.squats = squats;
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
