package com.jimmy.uabcs.bibliouabcs.views;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jimmy.uabcs.bibliouabcs.R;
import com.jimmy.uabcs.bibliouabcs.models.LoginResponse;
import com.jimmy.uabcs.bibliouabcs.utils.PrefsUtils;
import com.jimmy.uabcs.bibliouabcs.utils.Utils;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.internal.Util;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;
    @Bind(R.id.nav_view)
    NavigationView navigationView;
    private PrefsUtils mPrefs;
    private MenuItem lastClickedItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPrefs = new PrefsUtils();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        LoginResponse response = mPrefs.getUserDetails();

        Utils.startFragment(getSupportFragmentManager(), new BooksFragment());
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        View headerLayout = navigationView.getHeaderView(0);
        TextView userName = (TextView)headerLayout.findViewById(R.id.username);
        TextView userEmail = (TextView)headerLayout.findViewById(R.id.useremail);;
        userName.setText(response.getEmail());
        userEmail.setText(response.getPassword());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            drawer.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        boolean fragmentTransaction = false;
        Fragment fragment = null;
        int id = item.getItemId();

        switch(id){
            case R.id.nav_about:
                fragmentTransaction = true;
                fragment = new AboutFragment();
                break;
            case R.id.nav_byAuthor:
                fragmentTransaction = true;
                fragment = new AuthorsFragment();
                break;
            case R.id.nav_byPublisher:
                fragmentTransaction = true;
                fragment = new PublisherFragment();
                break;
            case R.id.nav_byTitle:
                fragmentTransaction = true;
                fragment = new BooksFragment();
                break;
        }

        if(fragmentTransaction) {
            Utils.startFragment(getSupportFragmentManager(), fragment);
            if(lastClickedItem != null)
                lastClickedItem.setChecked(false);
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        lastClickedItem = item;
        return true;
    }


}
