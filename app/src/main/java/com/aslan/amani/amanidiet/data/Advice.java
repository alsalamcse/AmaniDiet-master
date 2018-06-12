package com.aslan.amani.amanidiet.data;

/**
 * Created by aodai on 11/06/2018.
 */

public class Advice {

    private String Advice;
    private String type;

    private String keyId;

    private String email;

    public Advice() {
    }


    public Advice(String advice, String type, String keyId) {
        Advice = advice;
        this.type = type;
        this.keyId = keyId;
    }

    public Advice(String advice, String type) {
        Advice = advice;
        this.type = type;
        this.email = email;
    }

    public String getAdvice() {
        return Advice;
    }

    public void setAdvice(String advice) {
        Advice = advice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
