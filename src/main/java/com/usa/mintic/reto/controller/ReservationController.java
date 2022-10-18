package com.usa.mintic.reto.controller;

import com.usa.mintic.reto.entities.ReportClient;
import com.usa.mintic.reto.entities.Reservation;
import com.usa.mintic.reto.entities.Status;
import com.usa.mintic.reto.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservations(){return reservationService.getReservations();}

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation saveReservation(@RequestBody Reservation r){
        return reservationService.saveReservation(r);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation updateReservation(@RequestBody Reservation r){
        return reservationService.updateReservation(r);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable("id") int reservationId){
        return reservationService.deleteReservation(reservationId);
    }
    @GetMapping("/report-status")
    public Status getStatus(){
        return reservationService.getStatus();
    }
    @GetMapping("/report-clients")
    public List<ReportClient> getReportClient(){
        return reservationService.getReportClient();
    }

    @GetMapping("/report-dates/{startDate}/{devolutionDate}")
    public List<Reservation> getReportdate(@PathVariable String startDate,@PathVariable String devolutionDate) {
        Date date1= new Date();
        Date date2= new Date();
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            date2=new SimpleDateFormat("yyyy-MM-dd").parse(devolutionDate);
        } catch (ParseException ex) {
            Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reservationService.getReportDates(date1,date2);
    }

}
