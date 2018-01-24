package com.boshware.fitciti.JSONModel;

/**
 * Created by Emre on 4.1.2018.
 */

public class PersonInfoModel {
    private Integer Weight;
    private Integer Height;
    private String Birthdate;
    private String Goal;
    private String DailyActivity;

    public Integer getHeight() {
        return Height;
    }

    public Integer getWeight() {
        return Weight;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public String getDailyActivity() {
        return DailyActivity;
    }

    public String getGoal() {
        return Goal;
    }

    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }

    public void setDailyActivity(String dailyActivity) {
        DailyActivity = dailyActivity;
    }

    public void setGoal(String goal) {
        Goal = goal;
    }

    public void setHeight(Integer height) {
        Height = height;
    }

    public void setWeight(Integer weight) {
        Weight = weight;
    }

}
