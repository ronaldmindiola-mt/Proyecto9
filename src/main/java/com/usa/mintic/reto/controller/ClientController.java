package com.usa.mintic.reto.controller;

import com.usa.mintic.reto.entities.Client;
import com.usa.mintic.reto.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getClients(){return clientService.getClients();}

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int id){return clientService.getClient(id);}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client saveClient(@RequestBody Client c) { return clientService.saveClient(c);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateClient(@RequestBody Client c){return clientService.updateClient(c);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteClient(@PathVariable("id") int id){ return clientService.deleteClient(id);}

}
