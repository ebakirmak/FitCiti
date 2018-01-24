package com.boshware.fitciti.JSONModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Emre on 23.1.2018.
 */

public class MessageListModel {
    @SerializedName("ReceiveID")
    @Expose
    private String receiveID;
    @SerializedName("MessageID")
    @Expose
    private Integer messageID;
    @SerializedName("ReceiveName")
    @Expose
    private String receiveName;
    @SerializedName("Message")
    @Expose
    private String message;

    public String getReceiveID() {
        return receiveID;
    }

    public void setReceiveID(String receiveID) {
        this.receiveID = receiveID;
    }

    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
