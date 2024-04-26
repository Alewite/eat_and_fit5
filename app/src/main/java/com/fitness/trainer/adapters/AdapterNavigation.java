package com.fitness.trainer.adapters;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.fitness.trainer.fragments.FragmentCategories;
import com.fitness.trainer.fragments.FragmentPrograms;
import com.github.ksoichiro.android.observablescrollview.CacheFragmentStatePagerAdapter;
import com.fitness.trainer.R;

/**
 * Design and developed by pongodev.com
 *
 * AdapterNavigation is created to create tab view of workout category and program.
 * Created using CacheFragmentStatePagerAdapter.
 */
public class AdapterNavigation extends CacheFragmentStatePagerAdapter {

    // Create variables to store page titles
    private  String[] sPagerTitles;

    // Constructor to set context and page titles data
    public AdapterNavigation(Context c, FragmentManager fm) {
        super(fm);

        Context mContext = c;

        // Get page titles from strings.xml
        sPagerTitles = mContext.getResources().getStringArray(R.array.home_pager_titles);
    }

    @Override
    protected Fragment createItem(int position) {
        // Initialize fragments.
        // Please be sure to pass scroll position to each fragments using setArguments.
        Fragment f;
        switch (position) {
            case 0: {
                // Set first tab with workout category
                f = new FragmentCategories();
                break;
            }
            case 1:
            default: {
                // set second tab with day program
                f = new FragmentPrograms();
                break;
            }
        }
        return f;
    }

    @Override
    public int getCount() {
        return sPagerTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return sPagerTitles[position];
    }
}