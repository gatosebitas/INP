package com.example.fernando.myapplicationmap.presenter;

import android.util.Log;

import com.example.fernando.myapplicationmap.model.MainActivityInteractor;
import com.example.fernando.myapplicationmap.model.MainActivityInteractorImpl;
import com.example.fernando.myapplicationmap.model.Zona_Cast;
import com.example.fernando.myapplicationmap.view.MainActivityView;

import java.util.List;

/**
 * Created by fernando on 02/01/2018.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {
    private MainActivityView activityView;
    private MainActivityInteractor Interactor;

    public MainActivityPresenterImpl(MainActivityView activityView) {
        this.activityView = activityView;
        Interactor= new MainActivityInteractorImpl(this);
    }

    @Override
    public void listarzonas(String nodo) {
        Interactor.listarzonas(nodo);
    }

    @Override
    public void showZonas(List<Zona_Cast> list_ZonaCast) {
        activityView.showZonas(list_ZonaCast);
    }


}
