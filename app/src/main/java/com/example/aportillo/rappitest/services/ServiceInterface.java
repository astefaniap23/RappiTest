package com.example.aportillo.rappitest.services;

/**
 * Created by aportillo on 27/09/2016.
 */
public interface ServiceInterface<T> {
    void onSuccess(T Objet);
    void onError();
}

