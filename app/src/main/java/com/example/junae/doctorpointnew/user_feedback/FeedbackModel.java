package com.example.junae.doctorpointnew.user_feedback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by junae on 12/6/2017.
 */

public class FeedbackModel {
    @SerializedName("user_mail")
    @Expose
    private String user_mail;
    @SerializedName("user_feedback")
    @Expose
    private String user_feedback;

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String getUser_feedback() {
        return user_feedback;
    }

    public void setUser_feedback(String user_feedback) {
        this.user_feedback = user_feedback;
    }
}
