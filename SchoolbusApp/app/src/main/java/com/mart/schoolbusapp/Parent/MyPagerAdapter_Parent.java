package com.mart.schoolbusapp.Parent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mart.schoolbusapp.Parent.P_DataDriver;
import com.mart.schoolbusapp.Parent.P_STD;
import com.mart.schoolbusapp.Parent.P_Tracking;

/**
 * Created by Mart_ on 9/12/2559.
 */

public class MyPagerAdapter_Parent extends FragmentPagerAdapter {
    public MyPagerAdapter_Parent(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if(position == 0)
            return new P_Tracking();
        else if(position == 1)
            return new P_STD();
        else if(position == 2)
            return new P_DataDriver();
        else
            return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
