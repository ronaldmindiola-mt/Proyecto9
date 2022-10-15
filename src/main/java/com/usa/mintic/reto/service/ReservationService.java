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
        if(r.getReservationId()==null){
            return reservationRepository.saveReservation(r);
        }else{
            Optional<Reservation> element = reservationRepository.getReservation(r.getReservationId());
            if(element.isPresent()){
                return r;
            }else {
                return reservationRepository.saveReservation(r);
            }
        }
    }

    public Reservation updateReservation(Reservation r){
        if(r.getReservationId()!=null){
            Optional<Reservation> element = reservationRepository.getReservation(r.getReservationId());
            if(element.isPresent()){

                if(r.getReservationId()!=null){
                    element.get().setReservationId(r.getReservationId());
                }
                if(r.getBike()!=null){
                    element.get().setBike(r.getBike());
                }
                if(r.getClient()!=null){
                    element.get().setClient(r.getClient());
                }
                if(r.getStartDate()!=null){
                    element.get().setStartDate(r.getStartDate());
                }
                if(r.getDevotionDate()!=null){
                    element.get().setDevotionDate(r.getDevotionDate());
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
