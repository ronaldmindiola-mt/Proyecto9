package com.usa.mintic.reto.repository;

import com.usa.mintic.reto.entities.Message;
import com.usa.mintic.reto.repository.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getMessages(){ return (List<Message>) messageCrudRepository.findAll();}

    // Revisar
    public Optional<Message> getMessage(int id){return messageCrudRepository.findById("id");}

    public Message saveMessage(Message m){ return messageCrudRepository.save(m);}

    public void deleteMessage(Message m){messageCrudRepository.delete(m);}

}
