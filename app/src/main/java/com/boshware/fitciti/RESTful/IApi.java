package com.boshware.fitciti.RESTful;

import com.boshware.fitciti.JSONModel.IsRegisteredUserModel;
import com.boshware.fitciti.JSONModel.MessageDetailModel;
import com.boshware.fitciti.JSONModel.MessageListModel;
import com.boshware.fitciti.JSONModel.TrainingOfSportsman;
import com.boshware.fitciti.JSONModel.WorkoutOfSportsman;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Emre on 4.1.2018.
 */

public interface IApi {

    @GET("Sportsman/GetisRegisteredSportsman/")
    Call<IsRegisteredUserModel> getIsRegisteredUser(@Query("sportsmanID") String sportsmanID);

    @POST("Sportsman/SetRegisterUser/")
    Call<Boolean>  SetRegisterUser (
            @Query("sID") String sID,
            @Query("saiName") String saiName,
            @Query("saiSurname") String saiSurname,
            @Query("saiEmail") String saiEmail,
            @Query("saiPhoto") String saiPhoto,
            @Query("spiWeight") String spiWeight,
            @Query("spiHeight") String spiHeight,
            @Query("spiBirthdate") String spiBirthdate,
            @Query("spiGoal") String spiGoal,
            @Query("spiDailyActivity") String spiDailyActivity,
            @Query("sliCountry") int sliCountry,
            @Query("sliProvince") int sliProvince,
            @Query("sliTown") int sliTown
            );

    @GET("TrainingOfSportsman/Get/")
    Call<List<TrainingOfSportsman>> getTrainingOfSportsman(@Query("sportsmanid") String sportsmanID);

    @GET("WorkoutOfSportsman/Get/")
    Call<List<WorkoutOfSportsman>> getWorkoutOfSportsman(@Query("trainingID") int trainingID);

    @GET("SportsmanMessages/GetMessageList/")
    Call<List<MessageListModel>> getMessageList(@Query("sendingID") String sportsmanID);

    @GET("SportsmanMessages/GetMessageDetails/")
    Call<List<MessageDetailModel>> getMessageDetails(@Query("sendingID") String sportsmanID, @Query("receiveID") String receiveID);

}
