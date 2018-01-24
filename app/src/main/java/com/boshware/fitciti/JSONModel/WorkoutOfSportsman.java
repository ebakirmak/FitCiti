package com.boshware.fitciti.JSONModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Emre on 20.1.2018.
 */

public class WorkoutOfSportsman {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("TrainerID")
    @Expose
    private Integer trainerID;
    @SerializedName("TrainingID")
    @Expose
    private Integer trainingID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Regetition")
    @Expose
    private Integer regetition;
    @SerializedName("Set")
    @Expose
    private Integer set;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(Integer trainerID) {
        this.trainerID = trainerID;
    }

    public Integer getTrainingID() {
        return trainingID;
    }

    public void setTrainingID(Integer trainingID) {
        this.trainingID = trainingID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRegetition() {
        return regetition;
    }

    public void setRegetition(Integer regetition) {
        this.regetition = regetition;
    }

    public Integer getSet() {
        return set;
    }

    public void setSet(Integer set) {
        this.set = set;
    }
}
