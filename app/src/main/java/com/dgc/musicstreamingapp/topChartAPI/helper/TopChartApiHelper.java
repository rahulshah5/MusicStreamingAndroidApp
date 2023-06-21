package com.dgc.musicstreamingapp.topChartAPI.helper;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TopChartApiHelper {

    private static Retrofit retrofit=null;
    private static String BASE_URL="https://spotify117.p.rapidapi.com/";

    public static Retrofit getInstanceForNewReleases(){
        if(retrofit ==null) {

//            OkHttpClient client = new OkHttpClient.Builder()
//                    .addInterceptor(new HeaderInterceptor())
//                    .build();

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
