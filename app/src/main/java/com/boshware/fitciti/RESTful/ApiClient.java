package com.boshware.fitciti.RESTful;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Emre on 4.1.2018.
 */

public class ApiClient {
    //public static final String MASK_URL = "http://192.168.1.107:9810/api/";
    //public  static final String MASK_URL = "http://localhost:58792/api/";
    public  static final String MASK_URL = "https://fitcitiapp.azurewebsites.net/api/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(MASK_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
