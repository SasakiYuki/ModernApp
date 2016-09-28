package com.wacode.yuki.modernapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
    }

    private void setViews() {
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        FragmentManager manager = getSupportFragmentManager();
        ViewPager viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        ExampleFragmentPagerAdapter adapter = new ExampleFragmentPagerAdapter(manager);
        viewPager.setAdapter(adapter);
        setDrawer();
        TabLayout tabLayout = (TabLayout) findViewById(R.id.main_tab);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.main_drawer_navigation);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(select);
    }

    private NavigationView.OnNavigationItemSelectedListener select = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            //本来ならここで分岐の処理を
            drawerLayout.closeDrawers();
            return true;
        }
    };
}
