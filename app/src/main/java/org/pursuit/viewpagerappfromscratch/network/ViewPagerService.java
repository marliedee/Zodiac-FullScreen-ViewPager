package org.pursuit.viewpagerappfromscratch.network;

import org.pursuit.viewpagerappfromscratch.model.ZodiacWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ViewPagerService {


    String END_POINT_URL = "JDVila/storybook/master/zodiac.json";
    @GET(END_POINT_URL)
    Call<ZodiacWrapper> getZodiacList();
}
