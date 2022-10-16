package com.usa.mintic.reto.service;

import com.usa.mintic.reto.entities.Client;
import com.usa.mintic.reto.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients(){return clientRepository.getClients();}

    public Optional<Client> getClient(int id){return clientRepository.getClient(id);}

    public Client saveClient(Client c){
        if(c.getIdClient()==null){
            return clientRepository.saveClient(c);
        }else{
            Optional<Client> element = clientRepository.getClient(c.getIdClient());
            if(element.isPresent()){
                return c;
            }else{
                return clientRepository.saveClient(c);
            }
        }
    }

    public Client updateClient(Client c){
        if(c.getIdClient()!=null){
            Optional<Client> element = clientRepository.getClient(c.getIdClient());
            if(element.isPresent()){
                if(c.getName()!=null){
                    element.get().setName(c.getName());
                }
                if(c.getEmail()!=null){
                    element.get().setEmail(c.getEmail());
                }
                if(c.getPassword()!=null){
                    element.get().setPassword(c.getPassword());
                }
                if(c.getAge()!=null){
                    element.get().setAge(c.getAge());
                }
                clientRepository.saveClient(element.get());
                return element.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }
    public boolean deleteClient(int id){
        boolean flag = false;
        Optional<Client> element = clientRepository.getClient(id);
        if(element.isPresent()){
            clientRepository.deleteClient(element.get());
            flag = true;
        }
        return flag;
    }
}
