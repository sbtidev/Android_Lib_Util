package br.com.sbs.android_lib_util.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class SectionFragmentAdapter extends FragmentStatePagerAdapter{

    List<Fragment> fragments;
    List<String> titles;

    public SectionFragmentAdapter(FragmentManager fm, List<String> titles, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0: fragments.size();
    }


}
