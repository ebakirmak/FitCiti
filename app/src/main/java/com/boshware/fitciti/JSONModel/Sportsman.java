package com.boshware.fitciti.JSONModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Emre on 29.12.2017.
 */

public class Sportsman {


    @SerializedName("sID")
    @Expose
    private String sID;
    @SerializedName("saiID")
    @Expose
    private Integer saiID;
    @SerializedName("spiID")
    @Expose
    private Integer spiID;
    @SerializedName("sliID")
    @Expose
    private Integer sliID;
    @SerializedName("saiName")
    @Expose
    private String saiName;
    @SerializedName("saiSurname")
    @Expose
    private String saiSurname;
    @SerializedName("saiEmail")
    @Expose
    private String saiEmail;
    @SerializedName("saiPhoto")
    @Expose
    private Object saiPhoto;
    @SerializedName("spiWeight")
    @Expose
    private Integer spiWeight;
    @SerializedName("spiHeight")
    @Expose
    private Integer spiHeight;
    @SerializedName("spiBirthdate")
    @Expose
    private String spiBirthdate;
    @SerializedName("spiGoal")
    @Expose
    private String spiGoal;
    @SerializedName("spiDailyActivity")
    @Expose
    private String spiDailyActivity;
    @SerializedName("sliCountry")
    @Expose
    private int sliCountry;
    @SerializedName("sliProvince")
    @Expose
    private int sliProvince;
    @SerializedName("sliTown")
    @Expose
    private int sliTown;
    @SerializedName("sliLongitude")
    @Expose
    private Object sliLongitude;
    @SerializedName("sliLatitude")
    @Expose
    private Object sliLatitude;

    public String getSID() {
        return sID;
    }

    public void setSID(String sID) {
        this.sID = sID;
    }

    public Integer getSaiID() {
        return saiID;
    }

    public void setSaiID(Integer saiID) {
        this.saiID = saiID;
    }

    public Integer getSpiID() {
        return spiID;
    }

    public void setSpiID(Integer spiID) {
        this.spiID = spiID;
    }

    public Integer getSliID() {
        return sliID;
    }

    public void setSliID(Integer sliID) {
        this.sliID = sliID;
    }

    public String getSaiName() {
        return saiName;
    }

    public void setSaiName(String saiName) {
        this.saiName = saiName;
    }

    public String getSaiSurname() {
        return saiSurname;
    }

    public void setSaiSurname(String saiSurname) {
        this.saiSurname = saiSurname;
    }

    public String getSaiEmail() {
        return saiEmail;
    }

    public void setSaiEmail(String saiEmail) {
        this.saiEmail = saiEmail;
    }

    public Object getSaiPhoto() {
        return saiPhoto;
    }

    public void setSaiPhoto(Object saiPhoto) {
        this.saiPhoto = saiPhoto;
    }

    public Integer getSpiWeight() {
        return spiWeight;
    }

    public void setSpiWeight(Integer spiWeight) {
        this.spiWeight = spiWeight;
    }

    public Integer getSpiHeight() {
        return spiHeight;
    }

    public void setSpiHeight(Integer spiHeight) {
        this.spiHeight = spiHeight;
    }

    public String getSpiBirthdate() {
        return spiBirthdate;
    }

    public void setSpiBirthdate(String spiBirthdate) {
        this.spiBirthdate = spiBirthdate;
    }

    public String getSpiGoal() {
        return spiGoal;
    }

    public void setSpiGoal(String spiGoal) {
        this.spiGoal = spiGoal;
    }

    public String getSpiDailyActivity() {
        return spiDailyActivity;
    }

    public void setSpiDailyActivity(String spiDailyActivity) {
        this.spiDailyActivity = spiDailyActivity;
    }

    public int getSliCountry() {
        return sliCountry;
    }

    public void setSliCountry(int sliCountry) {
        this.sliCountry = sliCountry;
    }

    public int getSliProvince() {
        return sliProvince;
    }

    public void setSliProvince(int sliProvince) {
        this.sliProvince = sliProvince;
    }

    public int getSliTown() {
        return sliTown;
    }

    public void setSliTown(int sliTown) {
        this.sliTown = sliTown;
    }

    public Object getSliLongitude() {
        return sliLongitude;
    }

    public void setSliLongitude(Object sliLongitude) {
        this.sliLongitude = sliLongitude;
    }

    public Object getSliLatitude() {
        return sliLatitude;
    }

    public void setSliLatitude(Object sliLatitude) {
        this.sliLatitude = sliLatitude;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }
}
