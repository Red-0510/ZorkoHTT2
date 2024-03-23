package com.example.zorkohtt2.models;

public class LoginResponse {
    private boolean success;

    public boolean isSuccess() {
        return success;
    }


    public LoginResponse(boolean error) {
        this.success = error;

    }
}
