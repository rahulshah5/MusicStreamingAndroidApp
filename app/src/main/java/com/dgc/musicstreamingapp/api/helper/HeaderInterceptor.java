package com.dgc.musicstreamingapp.api.helper;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request.Builder requestBuilder = originalRequest.newBuilder()
                .header("X-RapidAPI-Key", "a3da52ec2emsh7f1b06e20ef4024p1acf60jsnb77c2ec7f1c7")
                .header("X-RapidAPI-Host", "spotify23.p.rapidapi.com");
        Request newRequest = requestBuilder.build();
        return chain.proceed(newRequest);
    }
}