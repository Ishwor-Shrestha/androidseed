package com.sample.androidseed;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by User on 9/4/2015.
 */
public class BaseMenu extends AppCompatActivity {

    RecyclerView navList;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    DrawerLayout dlNav;
    ActionBarDrawerToggle mDrawerToggle;

    protected void onCreateBase(){

        //---------------Toolbar------------------
        Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        //----------------------------------------

        String[] nav_titles = {"History", "Category", "Backup/Restore", "Report"};
        String nav_icons[] = {getResources().getString(R.string.hourglass), getResources().getString(R.string.label), getResources().getString(R.string.restore), getResources().getString(R.string.trending_up)};

        navList = (RecyclerView) findViewById(R.id.rvNav);
        adapter = new NavAdapter(getApplicationContext(), nav_titles, nav_icons);
        navList.setHasFixedSize(true);
        navList.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        navList.setLayoutManager(layoutManager);

        dlNav = (DrawerLayout) findViewById(R.id.dlMain);
        mDrawerToggle = new ActionBarDrawerToggle((Activity) this, dlNav, R.string.open_drawer, R.string.close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        dlNav.setDrawerListener(mDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //ToDo add settings layout
        } else if (id == R.id.action_about) {
            //ToDo add about layout
        }

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
