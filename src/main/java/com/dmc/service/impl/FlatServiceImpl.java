package com.dmc.service.impl;

import com.dmc.dao.FlatRepository;
import com.dmc.model.Flat;
import com.dmc.service.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlatServiceImpl implements FlatService {

    @Autowired
    FlatRepository flatRepository;

    @Override
    public List<Flat> getFlats() {
        return flatRepository.findAll();
    }

    @Override
    public Flat getFlatByName(String flatName) {
        return flatRepository.findByName(flatName);
    }

    @Override
    @Transactional
    public void addFlat(Flat flat) {
        flatRepository.save(flat);
    }

    @Override
    @Transactional
    public void updateFlat(Flat flat) {
        flatRepository.save(flat);
    }
}
