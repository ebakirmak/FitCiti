package com.boshware.fitciti.SignUp;

import android.content.Intent;

import com.boshware.fitciti.JSONModel.AccountInfoModel;
import com.boshware.fitciti.JSONModel.LocationInfoModel;
import com.boshware.fitciti.JSONModel.PersonInfoModel;

import java.util.ArrayList;

/**
 * Created by Emre on 28.12.2017.
 */

public interface SignUpFunctionsInterface {
    void ChangeFragment(android.support.v4.app.Fragment fragment);

    void ChangeActivity(Intent intent);

    void SignUpSportsman(AccountInfoModel accountInfo, PersonInfoModel personInfo, LocationInfoModel locationInfo);

    ArrayList<String> GetSportsmanAccountInfos();

}
