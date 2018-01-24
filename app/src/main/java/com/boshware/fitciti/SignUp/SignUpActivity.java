package com.boshware.fitciti.SignUp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.boshware.fitciti.Home.MainActivity;
import com.boshware.fitciti.Login.LoginActivity;
import com.boshware.fitciti.JSONModel.AccountInfoModel;
import com.boshware.fitciti.JSONModel.LocationInfoModel;
import com.boshware.fitciti.JSONModel.PersonInfoModel;
import com.boshware.fitciti.JSONModel.Sportsman;
import com.boshware.fitciti.R;
import com.boshware.fitciti.RESTful.ApiClient;
import com.boshware.fitciti.RESTful.IApi;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignUpActivity extends AppCompatActivity implements SignUpFunctionsInterface {


    /**
     * Web Service Api
     */
    private IApi apiInterface;

    /**
     * Fragments process is managed.
     */
    android.support.v4.app.FragmentManager fragmentManager;
    FragmentTransaction transaction;

    /**
     * Model User
     */
    private Sportsman sportsman;

    /**
     * Firebase User
     */
    private FirebaseUser firebaseUser;

    public SignUpActivity(){


    }

    private void init(){
        /**
         * Fragments process is initialized.
         */
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.signUpContainer,new AccountInfoFragment()).commit();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent  i = new Intent(this,LoginActivity.class);
        LoginActivity loginActivity = new LoginActivity();
        loginActivity.SignOutUser();
        ChangeActivity(i);
    }

    @Override
    public void ChangeFragment(Fragment fragment){
        /**
         * Fragments process is managed.
         */
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.signUpContainer,fragment).commit();
        transaction.addToBackStack(fragment.getTag());
    }

    @Override
    public void ChangeActivity(Intent intent) {
        startActivity(intent);
    }

    @Override
    public void SignUpSportsman(AccountInfoModel accountInfo, PersonInfoModel personInfo, LocationInfoModel locationInfo) {

        if(sportsman == null)
            sportsman = new Sportsman();

        if(accountInfo != null) {
            this.sportsman.setSaiName(accountInfo.getName());
            this.sportsman.setSaiSurname(accountInfo.getSurname());
            this.sportsman.setSaiEmail(accountInfo.getEmail());
        }

        if(personInfo != null)
        {
            this.sportsman.setSpiWeight(personInfo.getWeight());
            this.sportsman.setSpiHeight(personInfo.getHeight());
            this.sportsman.setSpiBirthdate(personInfo.getBirthdate());
            this.sportsman.setSpiDailyActivity(personInfo.getDailyActivity());
            this.sportsman.setSpiGoal(personInfo.getGoal());
        }

        if(locationInfo != null){
            this.sportsman.setSliCountry(locationInfo.getCountry());
            this.sportsman.setSliProvince(locationInfo.getProvince());
            //this.sportsman.setSliTown(locationInfo.getTown());
            this.sportsman.setsID(firebaseUser.getUid());

            //Kayıt edip anasayfaya kayıt olmazsa hata göster.
            SignupUser(sportsman);

        }

    }

    @Override
    public ArrayList<String> GetSportsmanAccountInfos() {
        firebaseUser = LoginActivity.GetCurrentUser();
        Log.e("User::",firebaseUser.getDisplayName() + firebaseUser.getUid());
        ArrayList<String> infos = new ArrayList<>();
        ArrayList<String > names = new ArrayList<>();
        for (String name: firebaseUser.getDisplayName().split(" ")){
            names.add(name);
        }
        String name="", surname="";
        for(int i=0;i<names.size()-1;i++){
            name += names.get(i);
            surname = names.get(i+1);
        }
        infos.add(name);
        infos.add(surname);
        infos.add(firebaseUser.getEmail());
        return infos;
    }

    private Boolean SignUp=false;

    private Boolean SignupUser(Sportsman sportsman) {

        if(sportsman!=null){
            apiInterface = ApiClient.getApiClient().create(IApi.class);

            retrofit2.Call<Boolean> call = apiInterface.SetRegisterUser(
                    sportsman.getSID().toString(),
                    sportsman.getSaiName(),
                    sportsman.getSaiSurname(),
                    sportsman.getSaiEmail(),
                    "Foto yok",
                    sportsman.getSpiWeight().toString(),
                    sportsman.getSpiHeight().toString(),
                    sportsman.getSpiBirthdate(),
                    sportsman.getSpiGoal(),
                    sportsman.getSpiDailyActivity(),
                    1,
                    sportsman.getSliProvince(),
                    0);

            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    if(response.body()){
                        SignUp = true;
                        Log.e("SignUpUser::",SignUp.toString());

                    }

                    else
                        SignUp = false;
                    Log.e("SignUpUser::",SignUp.toString());
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {

                }
            });
            Toast.makeText(this,"Kayıt işlemi başarılı",Toast.LENGTH_SHORT).show();
            ChangeActivity(new Intent(this,MainActivity.class));
            return true;
        }
        else
            return  false;

    }
}
