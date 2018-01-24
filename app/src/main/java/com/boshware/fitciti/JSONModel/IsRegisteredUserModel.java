package com.boshware.fitciti.JSONModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Emre on 4.1.2018.
 */

public class IsRegisteredUserModel {

    @SerializedName("sID")
    @Expose
    private String sID;

    @SerializedName("isRegister")
    @Expose
    private Boolean isRegister;

    public String getsID() {
        return sID;
    }

    public void setRegister(Boolean register) {
        isRegister = register;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public  Boolean getIsRegister(){
        return this.isRegister;
    }
}
