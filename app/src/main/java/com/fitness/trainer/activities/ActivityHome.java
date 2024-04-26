package com.fitness.trainer.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.fitness.trainer.fragments.FragmentCategories;
import com.fitness.trainer.fragments.FragmentPrograms;
import com.google.samples.apps.iosched.ui.widget.SlidingTabLayout;
import com.fitness.trainer.R;
import com.fitness.trainer.adapters.AdapterNavigation;
import com.fitness.trainer.utils.Utils;

/**
 * Design and developed by pongodev.com
 *
 * ActivityHome is created to display workout category and program in tab view.
 * Created using AppCompatActivity.
 */
public class ActivityHome extends AppCompatActivity implements
        FragmentCategories.OnSelectedCategoryListener,
        FragmentPrograms.OnSelectedDayListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Connect view objects with view ids in xml
        View mHeaderView = findViewById(R.id.header);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        ViewPager mPager = (ViewPager) findViewById(R.id.pager);
        SlidingTabLayout mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);

        // Set adapter object
        AdapterNavigation mAdapterNavigation =
                new AdapterNavigation(this, getSupportFragmentManager());

        // Set elevation to header view
        ViewCompat.setElevation(mHeaderView, getResources().getDimension(R.dimen.toolbar_elevation));
        // Set tab bar adapter to the pager
        mPager.setAdapter(mAdapterNavigation);
        // Set toolbar as actionbar
        setSupportActionBar(mToolbar);

        // Configure tab layout
        mSlidingTabLayout.setCustomTabView(R.layout.tab_indicator, android.R.id.text1);
        mSlidingTabLayout.setSelectedIndicatorColors(ContextCompat.
                getColor(this, R.color.accent_color));
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(mPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_home, menu);
        return true;
    }

    @Override
    public void onSelectedCategory(String selectedID, String selectedName) {
        // On workout category selected open ActivityWorkouts and pass
        // selected values to that activity
        Intent detailIntent = new Intent(this, ActivityWorkouts.class);
        detailIntent.putExtra(Utils.ARG_WORKOUT_ID, selectedID);
        detailIntent.putExtra(Utils.ARG_WORKOUT_NAME, selectedName);
        detailIntent.putExtra(Utils.ARG_PARENT_PAGE, Utils.ARG_WORKOUTS);
        startActivity(detailIntent);
        overridePendingTransition(R.anim.open_next, R.anim.close_main);
    }

    @Override
    public void onSelectedDay(String selectedID, String selectedName) {
        // On day selected open ActivityWorkouts and pass
        // selected values to that activity
        Intent detailIntent = new Intent(this, ActivityWorkouts.class);
        detailIntent.putExtra(Utils.ARG_WORKOUT_ID, selectedID);
        detailIntent.putExtra(Utils.ARG_WORKOUT_NAME, selectedName);
        detailIntent.putExtra(Utils.ARG_PARENT_PAGE, Utils.ARG_PROGRAMS);
        startActivity(detailIntent);
        overridePendingTransition(R.anim.open_next, R.anim.close_main);

    }

}

