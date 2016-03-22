package com.example.mwongera.dividers;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import butterknife.Bind;
import butterknife.ButterKnife;

public class SampleActivity extends AppCompatActivity {

    @Bind(R.id.pager) ViewPager viewPager;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_activity);
        ButterKnife.bind(this);
        initializeViewPager();
    }

    private void initializeViewPager() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentPagerAdapter pagerAdapter = new SampleFragmentPagerAdapter(fragmentManager, this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(pagerAdapter.getCount());
    }
}