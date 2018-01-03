package com.example.fernando.myapplicationmap.view;

import android.graphics.Color;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.fernando.myapplicationmap.AsyncTaskCompleteListener;
import com.example.fernando.myapplicationmap.R;
import com.example.fernando.myapplicationmap.model.Zona;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String ZONA_NODE = "Zonas";
    private GoogleMap mMap;
    private DatabaseReference databaseReference;
    private StorageReference mStorageRef;
    private List<String> zonas_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        zonas_name = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(ZONA_NODE).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                zonas_name.clear();
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Zona zona = snapshot.getValue(Zona.class);
                        Log.i("tag", "Lat:  " + zona.getLat());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        /*
        Escribe en Firebase las zonas
         */
        leerZona();
        Log.i("Hola", "mundo");
        miUbicacion();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        LatLng x = new LatLng(-34, 151.5);
        LatLng y = new LatLng(-34, 152);
        LatLng z = new LatLng(-33, 152);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.addMarker(new MarkerOptions().position(x).title("X"));
        mMap.addMarker(new MarkerOptions().position(y).title("Y"));
        mMap.addMarker(new MarkerOptions()
                .position(z)
                .title("Z")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).anchor(3, 3)
        );

        Circle circle = mMap.addCircle(new CircleOptions()
                .center(sydney)
                .radius(10000)
                .strokeColor(Color.RED)
                .fillColor(Color.BLUE));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }


    public void leerZona() {

        //escribir
        //Zona zona = new Zona(databaseReference.push().getKey(), "16", "16","","","","","");
        //databaseReference.child(ZONA_NODE).child(zona.getId()).setValue(zona);


    }


    public void miUbicacion() {
/*
        Log.i("miubi", "location");
        new HttpNetTask(this, new AsyncTaskCompleteListener() {
            @Override
            public void onHttpTaskComplete(String data) {
                try {
                    JSONObject jsonObj = new JSONObject(data);
                    Log.i("json", jsonObj.getString("location"));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).execute("https://www.googleapis.com/geolocation/v1/geolocate", "{key:AIzaSyD4XLllfjnTzJv7yuFIM9mWf9mzwVq6HMo}");

*/
    }



}



