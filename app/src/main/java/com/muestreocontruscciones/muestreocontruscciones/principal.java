package com.muestreocontruscciones.muestreocontruscciones;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.muestreocontruscciones.muestreocontruscciones.view.AnalystFragment;
import com.muestreocontruscciones.muestreocontruscciones.view.CollaboratorFragment;
import com.muestreocontruscciones.muestreocontruscciones.view.OperationFragment;
import com.muestreocontruscciones.muestreocontruscciones.view.ProjectFragment;
import com.muestreocontruscciones.muestreocontruscciones.view.SampleFragment;
import com.muestreocontruscciones.muestreocontruscciones.view.TaskFragment;
import com.muestreocontruscciones.muestreocontruscciones.view.WorkingHourFragment;

public class principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_account) {

        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_project) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new ProjectFragment()).commit();
        } else if (id == R.id.nav_operation) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new OperationFragment()).commit();
        } else if (id == R.id.nav_tasks) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new TaskFragment()).commit();
        } else if (id == R.id.nav_analyst) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new AnalystFragment()).commit();
        } else if (id == R.id.nav_collaborator) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new CollaboratorFragment(this)).commit();
        } else if (id == R.id.nav_working_hour) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new WorkingHourFragment()).commit();
        } else if (id == R.id.nav_sample) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new SampleFragment()).commit();
        } else if (id == R.id.nav_account) {
            //fragmentManager.beginTransaction().replace(R.id.content_frame, new ).commit();
            //manejo de la cuenta
        } else if (id == R.id.loggout) {
            //fragmentManager.beginTransaction().replace(R.id.content_frame, new ).commit();
            //hacia el login
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
