package com.boshware.fitciti.Home;

/**
 * Created by Emre on 28.12.2017.
 */

public interface MainActivityFunctionsInterface {

    void ChangeFragment(android.support.v4.app.Fragment fragment);

    void RESTfulGetTrainingOfSportsman();

    void RESTfulGetWorkoutOfSportsman(int trainingID);

    void RESTfulGetMessageList();

    void RESTfulGetMessageDetails(String receiveID);
}
