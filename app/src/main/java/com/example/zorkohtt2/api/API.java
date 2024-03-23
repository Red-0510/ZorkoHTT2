package com.example.zorkohtt2.api;

import com.example.zorkohtt2.models.LoginResponse;
import com.example.zorkohtt2.models.Mob;
import com.example.zorkohtt2.models.MobOtp;
import com.example.zorkohtt2.models.Otpverify;
//import com.example.zorkohtt2.models.mob;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {
//    @FormUrlEncoded
    @POST("user/register")
    Call<LoginResponse> userOtp(@Body Mob mobileNumber);

//    @FormUrlEncoded
    @POST("user/verify-otp")
    Call<Otpverify> otpVerify(@Body MobOtp mobOtp);
}
