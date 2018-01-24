package com.boshware.fitciti.FitCiti.Model.Messages;

/**
 * Created by Emre on 23.1.2018.
 */

public class MessagesList {

    private Integer MessageID;

    private String Message;

    private String ReceiveID;

    private String ReceiveName;


    public void setMessage(String message) {
        Message = message;
    }

    public void setMessageID(Integer messageID) {
        MessageID = messageID;
    }

    public void setReceiveID(String receiveID) {
        ReceiveID = receiveID;
    }

    public void setReceiveName(String receiveName) {
        ReceiveName = receiveName;
    }

    public Integer getMessageID() {
        return MessageID;
    }

    public String getMessage() {
        return Message;
    }

    public String getReceiveID() {
        return ReceiveID;
    }

    public String getReceiveName() {
        return ReceiveName;
    }

}
