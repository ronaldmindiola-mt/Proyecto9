package com.usa.mintic.reto.repository;

import com.usa.mintic.reto.entities.Bike;
import com.usa.mintic.reto.repository.crud.BikeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BikeRepository {

    @Autowired
    private BikeCrudRepository bikeCrudRepository;

    public List<Bike> getBikes(){ return (List<Bike>) bikeCrudRepository.findAll();}

    public Optional<Bike> getBike(int id){ return bikeCrudRepository.findById(id);}

    public Bike saveBike(Bike b){ return bikeCrudRepository.save(b);}

    public void deleteBike(Bike b){ bikeCrudRepository.delete(b);}

}
