package com.usa.mintic.reto.controller;

import com.usa.mintic.reto.entities.Bike;
import com.usa.mintic.reto.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("/all")
    public List<Bike> getBikes(){ return bikeService.getBikes();}

    @GetMapping("/{id}")
    public Optional<Bike> getBike(@PathVariable("id") int id){ return  bikeService.getBike(id);}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike saveBike(@RequestBody Bike b) { return bikeService.saveBike(b);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike updateBike(@RequestBody Bike b) { return bikeService.updateBike(b);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteBike(@PathVariable("id") int id){ return bikeService.deleteBike(id);}






}
