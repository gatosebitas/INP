package com.example.fernando.myapplicationmap.presenter;


import com.example.fernando.myapplicationmap.model.Zona_Cast;

import java.util.List;

/**
 * Created by fernando on 02/01/2018.
 */

public interface MainActivityPresenter {

    void listarzonas(String nodo); //interactor

    void showZonas(List<Zona_Cast> list_ZonaCast);


}
