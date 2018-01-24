package com.boshware.fitciti.Login;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.boshware.fitciti.Home.MainActivity;
import com.boshware.fitciti.JSONModel.IsRegisteredUserModel;
import com.boshware.fitciti.R;
import com.boshware.fitciti.RESTful.ApiClient;
import com.boshware.fitciti.RESTful.IApi;
import com.boshware.fitciti.SignUp.SignUpActivity;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;




import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    /**
     *
     */
    TextView mTxtViewLogin;

    /**
     * Retrofit
     */
    private IApi apiInterface;
    private boolean isRegister;


    /**
     * Firebase
     */
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private FirebaseUser user;
    public static final int RC_SIGN_IN=1;

    /**
     * Constructor.
     */
    public LoginActivity(){
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        if(CheckNetworkStatus()){
            firebaseLogin();
        }
        else{
            mTxtViewLogin = (TextView) findViewById(R.id.txtViewLogin);
            mTxtViewLogin.setText("İnternet bağlantınızı kontrol ediniz.");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SignOutUser();
    }
    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
    @Override
    protected void onPause() {
        super.onPause();
        if(mAuthStateListener!=null){
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
    }
    /**
     * Login işlemini dinle.
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try{
            if (requestCode == RC_SIGN_IN) {
                if (resultCode == RESULT_OK) {
                    user = mFirebaseAuth.getCurrentUser();
                    isRegisteredUser(user.getUid());

                } else if (resultCode == RESULT_CANCELED) {
                    finish();

                }
            }
        }
        catch(Exception ex){
            Log.e("LoginActivity",ex.getMessage());
        }
    }

    /**
     * Eğer kullanıcı varsa yönlendir yoksa giriş ekranı getir.
     */
    private void firebaseLogin(){
        try{
            mAuthStateListener = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                    FirebaseUser user =firebaseAuth.getCurrentUser();

                    if(user!=null){
                       isRegisteredUser(user.getUid());
                    }
                    else{

                        startActivityForResult(
                                AuthUI.getInstance()
                                        .createSignInIntentBuilder()
                                        .setIsSmartLockEnabled(false)
                                        .setAvailableProviders(
                                                Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                                              new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                                        .build(),RC_SIGN_IN);
                    }
                }
            };
        }catch (Exception ex){
            Log.e("LoginActivity",ex.getMessage());
        }


    }

    /**
     * User is signed out.
     * @return
     */
    public boolean SignOutUser(){
        try{
            mFirebaseAuth.getInstance().signOut();
            //AuthUI.getInstance().signOut(Login.this);
        }catch (Exception ex){
            Log.e("Login",ex.getMessage());
            return false;
        }
        return true;

    }

    /**
     *  Network Connectivity Status is Checked.
     */
    private boolean CheckNetworkStatus(){
        // Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {
            return  true;
        }
        else {

            return  false;

        }
    }


    /**
     *  Web Api is Called with Retrofit.
     * @param uID
     */
    private void isRegisteredUser(final String uID) {

        apiInterface = ApiClient.getApiClient().create(IApi.class);

        retrofit2.Call<IsRegisteredUserModel> call = apiInterface.getIsRegisteredUser(uID);

        call.enqueue(new Callback<IsRegisteredUserModel>() {

            @Override
            public void onResponse(Call<IsRegisteredUserModel> call, Response<IsRegisteredUserModel> response) {

                if (response.isSuccessful()) {
                    try {
                        isRegister = response.body().getIsRegister();
                        ChangeActivity(isRegister);
                    } catch (Exception ex) {

                        Log.e("Login::isRegisteredUser", ex.getMessage());
                    }
                }
            }



            @Override
            public void onFailure(Call<IsRegisteredUserModel> call, Throwable t) {
                Log.e("Login::onFailure",t.getMessage());
                isRegisteredUser(uID);
            }
        });


    }

    /**
     * Activity is changed.
     * @param value
     */
    private void ChangeActivity(boolean value){
        try{
            if (value) {
                Toast.makeText(LoginActivity.this, "Ana Sayfaya yönlendiriliyor.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

            } else {
                Toast.makeText(LoginActivity.this, "Kayıt Devam yönlendiriliyor.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, SignUpActivity.class);
                startActivity(intent);
            }
        }catch (Exception ex){
            Log.e("Login::ChangeActivity",ex.getMessage());
        }
    }

    /**
     * This is returned curren User.
     */
    public static FirebaseUser GetCurrentUser(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
           return user;
        } else {
            return null;
        }
    }
}




