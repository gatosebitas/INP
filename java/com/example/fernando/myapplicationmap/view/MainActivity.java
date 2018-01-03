package com.example.fernando.myapplicationmap.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.fernando.myapplicationmap.R;
import com.example.fernando.myapplicationmap.model.Zona_Cast;
import com.example.fernando.myapplicationmap.presenter.MainActivityPresenter;
import com.example.fernando.myapplicationmap.presenter.MainActivityPresenterImpl;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback,MainActivityView {

    private GoogleMap mMap;

    private MainActivityPresenter presenter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        presenter =new MainActivityPresenterImpl(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

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

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cortadura) {

                Intent intent = new Intent(this, CardActivity.class);
                startActivity(intent);

        } else if (id == R.id.nav_sangrado) {
            Intent intent = new Intent(this, Cards2Activity.class);
            startActivity(intent);

        } else if (id == R.id.nav_fractura) {
            Intent intent = new Intent(this, Cards3Activity.class);
            startActivity(intent);

        } else if (id == R.id.nav_desgarros) {
            Intent intent = new Intent(this, Cards2Activity.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        presenter.listarzonas("Zonas");
    }

    public void refresh(View view){


        Log.i("Holi3","funcionando");
            }






    public void cargarDatos(){
        presenter.listarzonas("Zona");
    }

    @Override
    public void showZonas(List<Zona_Cast> list_ZonaCast) {
        for(Zona_Cast z:list_ZonaCast){
            Double latitud=z.getLat();
            Double longitud= z.getLongitud();
            Double radius= z.getRadius();
            int primaryColor=z.getPrimaryColor();
            int secondColor=z.getSecondColor();
            String title=z.getTitle();
            String subtitle=z.getSubtitle();
            Log.i("tag", "Latitud:  " + latitud);

            Log.i("tag", "longitud:  " +longitud);



            LatLng coordenadas=new LatLng(latitud,longitud);
            mMap.addMarker(new MarkerOptions()
                    .position(coordenadas)
                    .title(title)
                    .snippet(subtitle)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))


            );

            Circle circle = mMap.addCircle(new CircleOptions()
                    .center(coordenadas)
                    .radius(radius)
                    .strokeColor(primaryColor)
                    .fillColor(secondColor)
            );
        }
    }



}
