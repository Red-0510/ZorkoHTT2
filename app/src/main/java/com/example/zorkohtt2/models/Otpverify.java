package com.example.zorkohtt2.models;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class Otpverify {
    @SerializedName("success")
    private boolean success;
    @SerializedName("data")

    private Data data;

    public void setData(Data data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public Otpverify(boolean success, Data data) {
        this.success = success;
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public class Data{
        @SerializedName("token")

        private String token;

        public Data(String token) {
            this.token = token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }


    }
}

