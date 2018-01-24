package com.boshware.fitciti.Home;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.boshware.fitciti.FitCiti.Model.Training.Training;
import com.boshware.fitciti.Home.Messages.MessageDetailAdapter;
import com.boshware.fitciti.Home.Messages.MessageFragment;
import com.boshware.fitciti.Home.Messages.MessagesListAdapter;
import com.boshware.fitciti.Home.Trainings.TrainingSchedulesAdapter;
import com.boshware.fitciti.Home.Trainings.WorkoutDetailsAdapter;
import com.boshware.fitciti.JSONModel.MessageDetailModel;
import com.boshware.fitciti.JSONModel.MessageListModel;
import com.boshware.fitciti.Login.LoginActivity;
import com.boshware.fitciti.JSONModel.TrainingOfSportsman;
import com.boshware.fitciti.JSONModel.WorkoutOfSportsman;
import com.boshware.fitciti.R;
import com.boshware.fitciti.RESTful.ApiClient;
import com.boshware.fitciti.RESTful.IApi;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements MainActivityFunctionsInterface {

    /**
     * Firebase user
     */
    private FirebaseUser firebaseUser;
    /**
     * Fragments process is managed.
     */
    android.support.v4.app.FragmentManager fragmentManager;
    FragmentTransaction transaction;

    /**
     * Retrofit
     */
    private IApi apiInterface;

    /**
     * BottomNavigationView
     */
    BottomNavigationView bottomNavigationView;

    /**
     * init(): All requirements is loader in this function
     */
    private void init(){

        fragmentManager = getSupportFragmentManager();

        /**
         * Fragments process is managed.
         */
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content,new MainFragment()).commit();
        NavigationChange();


        /**
         * Firebaseuser
         */
        firebaseUser = LoginActivity.GetCurrentUser();


    }

    private void NavigationChange(){
        /**
         * MainFragment is initialized.
         */
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                transaction= fragmentManager.beginTransaction();
                switch (item.getItemId()){
                    case R.id.action_mainpage:
                        transaction.replace(R.id.content,new MainFragment()).commit();
                        break;
                    case R.id.action_message:
                        transaction.replace(R.id.content,new MessageFragment()).commit();
                        RESTfulGetMessageList();
                        break;
                    case R.id.action_search:
                        transaction.replace(R.id.content,new SearchFragment()).commit();
                        break;
                    case R.id.action_qr:
                        transaction.replace(R.id.content,new QrFragment()).commit();
                        break;
                    case R.id.action_profile:
                        transaction.replace(R.id.content,new ProfileFragment()).commit();
                        break;

                }
                return true;
            }
        });
    }
    /**Sportsman Class*/
    private com.boshware.fitciti.FitCiti.Model.Sportsman.Sportsman sportsman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();





    }

    /**
     *
     */
    @Override
    public void ChangeFragment(Fragment fragment){
        /**
         * Fragments process is managed.
         */
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content,fragment).commit();
        transaction.addToBackStack(fragment.getTag());
    }










    /** Sporcunun antrenmanlarını getirir.*/

    private void SetTrainingsOfSportsman(List<TrainingOfSportsman> trainingOfSportsmanList){
        Training training;
        sportsman = new com.boshware.fitciti.FitCiti.Model.Sportsman.Sportsman();
        sportsman.setSID(firebaseUser.getUid());
        for(int i =0;i<trainingOfSportsmanList.size();i++){
            training = new Training();
            training.setSportsmanID(trainingOfSportsmanList.get(i).getSportsmanID());
            training.setTrainingID(trainingOfSportsmanList.get(i).getTrainingID());
            training.setTrainingName(trainingOfSportsmanList.get(i).getTrainingName());
            sportsman.setTrainings(training);
        }

    }

    private void GetTrainingsOfSportsman(List<TrainingOfSportsman> trainingOfSportsmanList) {
        if(trainingOfSportsmanList!=null){

            SetTrainingsOfSportsman(trainingOfSportsmanList);
            final ListView myList = (ListView) findViewById(R.id.listTrainings);
            TrainingSchedulesAdapter workoutSchedulesAdapter = new TrainingSchedulesAdapter(this,sportsman.getTrainings());
            myList.setAdapter(workoutSchedulesAdapter);

        }
        else {
            Toast.makeText(this,"veri yok",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void RESTfulGetTrainingOfSportsman(){
        apiInterface = ApiClient.getApiClient().create(IApi.class);

        retrofit2.Call<List<TrainingOfSportsman>> callTraining = apiInterface.getTrainingOfSportsman(firebaseUser.getUid());

        callTraining.enqueue(new Callback<List<TrainingOfSportsman>>() {
            @Override
            public void onResponse(Call<List<TrainingOfSportsman>> call, Response<List<TrainingOfSportsman>> response) {
              GetTrainingsOfSportsman(response.body());
                Log.e("Trainings Of Sportsman","BAŞARILI");
            }

            @Override
            public void onFailure(Call<List<TrainingOfSportsman>> call, Throwable t) {
                Log.e("Trainings Of Sportsman",t.getMessage());
            }
        });


    }




    /** Alınan antrenman (training) id göre antrenman içerikleri getirilecek.*/
    @Override
    public void RESTfulGetWorkoutOfSportsman(int trainingID){


        apiInterface = ApiClient.getApiClient().create(IApi.class);

        retrofit2.Call<List<WorkoutOfSportsman>> callTraining = apiInterface.getWorkoutOfSportsman(trainingID);

        callTraining.enqueue(new Callback<List<WorkoutOfSportsman>>() {
            @Override
            public void onResponse(Call<List<WorkoutOfSportsman>> call, Response<List<WorkoutOfSportsman>> response) {
                GetWorkoutOfSportsman(response.body());
                Log.e("Workout Of Sportsman",response.isSuccessful()+"");
            }

            @Override
            public void onFailure(Call<List<WorkoutOfSportsman>> call, Throwable t) {
                Log.e("Workout Of Sportsman",t.getMessage());
            }
        });
    }

    private void GetWorkoutOfSportsman(List<WorkoutOfSportsman> workoutOfSportsmen) {
        if(workoutOfSportsmen!=null){
            ListView myList = (ListView) findViewById(R.id.fwdListWorkouts);
            WorkoutDetailsAdapter workoutDetailsAdapter = new WorkoutDetailsAdapter(this,workoutOfSportsmen);
            myList.setAdapter(workoutDetailsAdapter);
        }
        else {
            Toast.makeText(this,"veri yok",Toast.LENGTH_SHORT).show();
        }
    }


    /** Sporcunun mesajlaştığı kişileri göstermektedir **/
    @Override
    public void RESTfulGetMessageList() {
        apiInterface = ApiClient.getApiClient().create(IApi.class);

        retrofit2.Call<List<MessageListModel>> callMessageList = apiInterface.getMessageList(firebaseUser.getUid());

        callMessageList.enqueue(new Callback<List<MessageListModel>>() {
            @Override
            public void onResponse(Call<List<MessageListModel>> call, Response<List<MessageListModel>> response) {
                GetMessageList(response.body());
                Log.e("Get Message List",response.isSuccessful()+"");
            }

            @Override
            public void onFailure(Call<List<MessageListModel>> call, Throwable t) {
                Log.e("Get Message List",t.getMessage()+"");
            }
        });
    }

    private void GetMessageList(List<MessageListModel> messageListModels){
        if(messageListModels != null){
            ListView myList = (ListView) findViewById(R.id.fmListView);
            MessagesListAdapter messagesListAdapter = new MessagesListAdapter(this,messageListModels);
            myList.setAdapter(messagesListAdapter);
        }
        else{
            Toast.makeText(this,"veri yok",Toast.LENGTH_SHORT).show();
        }
    }

    /** Sporcunun mesajlarını göstermektedir **/
    @Override
    public void RESTfulGetMessageDetails(String receiveID) {

        apiInterface = ApiClient.getApiClient().create(IApi.class);

        retrofit2.Call<List<MessageDetailModel>> callMessageDetail = apiInterface.getMessageDetails(firebaseUser.getUid(),receiveID);

        callMessageDetail.enqueue(new Callback<List<MessageDetailModel>>() {
            @Override
            public void onResponse(Call<List<MessageDetailModel>> call, Response<List<MessageDetailModel>> response) {
                GetMessageDetails(response.body());
            }

            @Override
            public void onFailure(Call<List<MessageDetailModel>> call, Throwable t) {

            }
        });
    }

    private void GetMessageDetails(List<MessageDetailModel> messageDetailModels){
        if(messageDetailModels != null){
            ListView myList = (ListView) findViewById(R.id.fmdListView);
            MessageDetailAdapter messageDetailAdapter = new MessageDetailAdapter(this,messageDetailModels);
            myList.setAdapter(messageDetailAdapter);
        }
        else{
            Toast.makeText(this,"veri yok",Toast.LENGTH_SHORT).show();
        }
    }
}
