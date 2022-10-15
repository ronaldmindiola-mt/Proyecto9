package com.usa.mintic.reto.service;

import com.usa.mintic.reto.entities.Bike;
import com.usa.mintic.reto.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> getBikes(){ return bikeRepository.getBikes();}

    public Optional<Bike> getBike(int id){ return bikeRepository.getBike(id);}

    public Bike saveBike(Bike b){
        if(b.getId()==null){
            return bikeRepository.saveBike(b);
        }else{
            Optional<Bike> element = bikeRepository.getBike(b.getId());
            if(element.isPresent()){
                return b;
            }else{
                return bikeRepository.saveBike(b);
            }
        }
    }

    public Bike updateBike(Bike b){
        if(b.getId()!=null){
            Optional<Bike> element = bikeRepository.getBike(b.getId());
            if(element.isPresent()){
                if(b.getName()!=null){
                    element.get().setName(b.getName());
                }
                if(b.getDescription()!=null){
                    element.get().setDescription(b.getDescription());
                }
                if(b.getBrand()!=null){
                    element.get().setBrand(b.getBrand());
                }
                /*
                if(b.getCategory()!=null){
                    element.get().setCategory(b.getCategory());
                }
                */

                bikeRepository.saveBike(element.get());
                return element.get();
            }else{
                return b;
            }
        }else{
            return b;
        }
    }

    public boolean deleteBike(int id){
        boolean flag = false;
        Optional<Bike> element = bikeRepository.getBike(id);
        if(element.isPresent()){
            bikeRepository.deleteBike(element.get());
            flag=true;
        }
        return flag;
    }
}
