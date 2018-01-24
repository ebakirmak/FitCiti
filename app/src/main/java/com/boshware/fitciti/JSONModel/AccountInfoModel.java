package com.boshware.fitciti.JSONModel;

/**
 * Created by Emre on 4.1.2018.
 */

public class AccountInfoModel {
    private String Name;
    private String Surname;
    private String Email;
    private String Photo;

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoto() {
        return Photo;
    }

    public String getSurname() {
        return Surname;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }
}
