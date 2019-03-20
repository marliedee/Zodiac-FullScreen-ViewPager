package org.pursuit.viewpagerappfromscratch.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.pursuit.viewpagerappfromscratch.fragments.ZodiacFragment;

import java.util.List;

public class ZodiacViewPagerAdapter extends FragmentPagerAdapter {
    private final List<ZodiacFragment> zodiacFragmentList;

    public ZodiacViewPagerAdapter(FragmentManager fm, List<ZodiacFragment> zodiacFragmentList) {
        super(fm);
        this.zodiacFragmentList = zodiacFragmentList;
    }

    @Override
    public Fragment getItem(int i) {
        return zodiacFragmentList.get(i);    }

    @Override
    public int getCount() {
        return zodiacFragmentList.size();
    }
}
