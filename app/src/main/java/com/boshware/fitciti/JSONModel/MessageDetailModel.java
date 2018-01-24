package com.boshware.fitciti.JSONModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Emre on 23.1.2018.
 */

public class MessageDetailModel {

    @SerializedName("ID")
    @Expose
    private int iD;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Surname")
    @Expose
    private String surname;
    @SerializedName("SendSportsmanID")
    @Expose
    private String sendSportsmanID;
    @SerializedName("ReceiverSportsmanID")
    @Expose
    private String receiverSportsmanID;
    @SerializedName("Message")
    @Expose
    private String message;

    public int getID() {
        return iD;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSendSportsmanID() {
        return sendSportsmanID;
    }

    public void setSendSportsmanID(String sendSportsmanID) {
        this.sendSportsmanID = sendSportsmanID;
    }

    public String getReceiverSportsmanID() {
        return receiverSportsmanID;
    }

    public void setReceiverSportsmanID(String receiverSportsmanID) {
        this.receiverSportsmanID = receiverSportsmanID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
