package com.boshware.fitciti.JSONModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Emre on 20.1.2018.
 */

public class TrainingOfSportsman {



    @SerializedName("TrainingID")
    @Expose
    private Integer trainingID;
    @SerializedName("TrainingName")
    @Expose
    private String trainingName;
    @SerializedName("SportsmanID")
    @Expose
    private String sportsmanID;

    public Integer getTrainingID() {
        return trainingID;
    }

    public void setTrainingID(Integer trainingID) {
        this.trainingID = trainingID;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getSportsmanID() {
        return sportsmanID;
    }

    public void setSportsmanID(String sportsmanID) {
        this.sportsmanID = sportsmanID;
    }
}
