package org.pursuit.viewpagerappfromscratch;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import org.pursuit.viewpagerappfromscratch.controller.ZodiacViewPagerAdapter;
import org.pursuit.viewpagerappfromscratch.fragments.ZodiacFragment;
import org.pursuit.viewpagerappfromscratch.model.Zodiac;
import org.pursuit.viewpagerappfromscratch.model.ZodiacWrapper;
import org.pursuit.viewpagerappfromscratch.network.ViewPagerRetrofitInstance;
import org.pursuit.viewpagerappfromscratch.network.ViewPagerService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;
    private Retrofit retro;
    private final String TAG = "MAIN_ACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.main_viewP_container);
        final List<ZodiacFragment> fragmentList = new ArrayList<>();


        retro = ViewPagerRetrofitInstance.getInstance();

        ViewPagerService service = retro.create(ViewPagerService.class);
        final Call<ZodiacWrapper> zodiacList = service.getZodiacList();
        zodiacList.enqueue(new Callback<ZodiacWrapper>() {
            @Override
            public void onResponse(Call<ZodiacWrapper> call, Response<ZodiacWrapper> response) {
                for (Zodiac zodiac : response.body().getZodiac()) {
                    fragmentList.add(ZodiacFragment.newInstance(zodiac.getName(),zodiac.getNumber(), zodiac.getImage()));
                }


                viewPager.setAdapter(new ZodiacViewPagerAdapter(getSupportFragmentManager(), fragmentList));                }


            @Override
            public void onFailure(Call<ZodiacWrapper> call, Throwable t) {
                Log.d(TAG, "onResponse: " + t.getMessage());
            }
        });

}

}
