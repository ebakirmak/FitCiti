package com.boshware.fitciti.FitCiti.Model.Sportsman;

import com.boshware.fitciti.FitCiti.Model.Training.Training;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emre on 22.1.2018.
 */

public class Sportsman {

    private ArrayList<Training> Trainings;

    public Sportsman(){
        this.Trainings = new ArrayList<Training>();
    }

    public ArrayList<Training> getTrainings() {
        return Trainings;
    }

    public void setTrainings(Training trainings) {
        this.Trainings.add(trainings);
    }

    private String sID;

    private Integer saiID;

    private Integer spiID;

    private Integer sliID;

    private String saiName;

    private String saiSurname;

    private String saiEmail;

    private Object saiPhoto;

    private Integer spiWeight;

    private Integer spiHeight;

    private String spiBirthdate;

    private String spiGoal;

    private String spiDailyActivity;

    private String sliCountry;

    private String sliProvince;

    private String sliTown;

    private Object sliLongitude;

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

    public String getSliCountry() {
        return sliCountry;
    }

    public void setSliCountry(String sliCountry) {
        this.sliCountry = sliCountry;
    }

    public String getSliProvince() {
        return sliProvince;
    }

    public void setSliProvince(String sliProvince) {
        this.sliProvince = sliProvince;
    }

    public String getSliTown() {
        return sliTown;
    }

    public void setSliTown(String sliTown) {
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
