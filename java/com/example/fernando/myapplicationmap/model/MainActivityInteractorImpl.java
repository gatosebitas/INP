package com.example.fernando.myapplicationmap.model;

import android.util.Log;

import com.example.fernando.myapplicationmap.presenter.MainActivityPresenter;
import com.google.android.gms.maps.GoogleMap;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fernando on 02/01/2018.
 */

public class MainActivityInteractorImpl implements MainActivityInteractor {

   private MainActivityPresenter presenter;


    private static final String ZONA_NODE = "Zonas";
    private GoogleMap mMap;
    private DatabaseReference databaseReference;
    private StorageReference mStorageRef;
    private List<Zona_Cast> list_ZonaCast;
    private Zona_Cast zonaCast;


    public MainActivityInteractorImpl(MainActivityPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void listarzonas(String nodo) {

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        list_ZonaCast = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(ZONA_NODE).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Zona zona = snapshot.getValue(Zona.class);
                        String id=zona.getId();
                        Double latitud=Double.parseDouble(zona.getLat());
                        Double longitud= Double.parseDouble(zona.getLongitud());
                        int primaryColor=Integer.parseInt(zona.getPrimaryColor());
                        Double radius= Double.parseDouble(zona.getRadius());
                        int secondColor=Integer.parseInt(zona.getSecondColor());
                        String subtitle=zona.getSubtitle();
                        String title=zona.getTitle();
                        zonaCast = new Zona_Cast(id,latitud,longitud,primaryColor,radius,secondColor,subtitle,title);
                        list_ZonaCast.add(zonaCast);
                        presenter.showZonas(list_ZonaCast);


                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }



        });


    }


}
