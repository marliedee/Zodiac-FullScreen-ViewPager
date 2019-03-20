package org.pursuit.viewpagerappfromscratch.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewPagerRetrofitInstance {

    private static Retrofit ViewRetro;
    public static Retrofit getInstance() {
        if (ViewRetro != null) {
            return ViewRetro;
        }
        ViewRetro = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return ViewRetro;
    }
    private ViewPagerRetrofitInstance(){

    }
}
