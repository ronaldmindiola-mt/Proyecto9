package com.usa.mintic.reto.repository;

import com.usa.mintic.reto.entities.Reservation;
import com.usa.mintic.reto.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getReservations(){return (List<Reservation>) reservationCrudRepository.findAll();}

    public Optional<Reservation> getReservation(int id){return reservationCrudRepository.findById(id);}

    public Reservation saveReservation(Reservation r){ return reservationCrudRepository.save(r);}

    public void deleteReservation(Reservation r){reservationCrudRepository.delete(r);}

}
