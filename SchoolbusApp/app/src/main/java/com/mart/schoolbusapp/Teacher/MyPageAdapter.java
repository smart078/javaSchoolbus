package com.mart.schoolbusapp.Teacher;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mart.schoolbusapp.ListEN_Fragment;
import com.mart.schoolbusapp.ListMN_Fragment;

/**
 * Created by Mart_ on 2/12/2559.
 */

public class MyPageAdapter extends FragmentPagerAdapter {

    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return new ListMN_Fragment();
        else if(position == 1)
            return new ListEN_Fragment();
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
