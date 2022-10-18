package com.usa.mintic.reto.service;


import com.usa.mintic.reto.entities.Client;
import com.usa.mintic.reto.entities.ReportClient;
import com.usa.mintic.reto.entities.Reservation;
import com.usa.mintic.reto.entities.Status;
import com.usa.mintic.reto.repository.ClientRepository;
import com.usa.mintic.reto.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ClientRepository clientRepository;

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

    public Status getStatus() {
        Status status = new Status();
        List<Reservation> reservations=reservationRepository.getReservations();
        int contF=0;
        int contC=0;
        for(Reservation res:reservations){
            if(res.getStatus().equals("completed")){
                contF=contF+1;
            }else if(res.getStatus().equals("cancelled")){
                contC=contC+1;
            }
        }
        status.setCompleted(contF);
        status.setCancelled(contC);
        return status;
    }

    public List<ReportClient> getReportClient() {
        List<ReportClient> repoclient = new ArrayList<ReportClient>();
        List<Client> clients=clientRepository.getClients();
        int total=0;
        for(Client cli:clients){
            for(Reservation res:cli.getReservations()){
                total=total+1;
            }
            ReportClient reportclient= new ReportClient();
            reportclient.setTotal(total);
            reportclient.setClient(cli);
            repoclient.add(reportclient);
            total=0;
        }
        return repoclient;
    }
    public List<Reservation> getReportDates(Date date1, Date date2) {
        List<Reservation> reservations= reservationRepository.getReservations();
        List<Reservation> reservationsDate =new ArrayList<Reservation>();
        for(Reservation res:reservations){
            if(date1.compareTo(res.getStartDate()) * res.getStartDate().compareTo(date2) >= 0){
                reservationsDate.add(res);
            }
        }
        return reservationsDate;
    }
}
