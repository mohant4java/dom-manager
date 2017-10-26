package com.dmc.dao;

import com.dmc.model.Flat;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FlatRepository extends JpaRepository<Flat, Long> {
    Flat findByName(String name);
}

