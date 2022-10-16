package com.usa.mintic.reto.service;


import com.usa.mintic.reto.entities.Reservation;
import com.usa.mintic.reto.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getReservations(){return reservationRepository.getReservations();}

    public Optional<Reservation> getReservation(int id){return reservationRepository.getReservation(id);}

    public Reservation saveReservation(Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepository.saveReservation(r);
        }else{
            Optional<Reservation> element = reservationRepository.getReservation(r.getIdReservation());
            if(element.isPresent()){
                return r;
            }else {
                return reservationRepository.saveReservation(r);
            }
        }
    }

    public Reservation updateReservation(Reservation r){
        if(r.getIdReservation()!=null){
            Optional<Reservation> element = reservationRepository.getReservation(r.getIdReservation());
            if(element.isPresent()){

                if(r.getIdReservation()!=null){
                    element.get().setIdReservation(r.getIdReservation());
                }

                if(r.getStartDate()!=null){
                    element.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate()!=null){
                    element.get().setDevolutionDate(r.getDevolutionDate());
                }
                reservationRepository.saveReservation(element.get());
                return element.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }

    public boolean deleteReservation(int id){
        boolean flag = false;
        Optional<Reservation> element = reservationRepository.getReservation(id);
        if(element.isPresent()){
            reservationRepository.deleteReservation(element.get());
            flag = true;
        }
        return flag;
    }
}
