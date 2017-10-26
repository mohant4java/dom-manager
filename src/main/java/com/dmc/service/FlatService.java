package com.dmc.service;

import com.dmc.model.Flat;

import java.util.List;

public interface FlatService {
    List<Flat> getFlats();
    Flat getFlatByName(String flatName);
    void addFlat(Flat flat);
    void updateFlat(Flat flat);
}
