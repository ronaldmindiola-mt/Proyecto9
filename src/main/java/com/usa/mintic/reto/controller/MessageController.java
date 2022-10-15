package com.usa.mintic.reto.controller;

import com.usa.mintic.reto.entities.Message;
import com.usa.mintic.reto.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getMessages(){return messageService.getMessages();}

    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int id){return messageService.getMessage(id);}
    //public Optional<Message> getMessage(@PathVariable("id") int id){return messageService.getMessage(id);}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message saveMessage(@RequestBody Message m){
        return messageService.saveMessage(m);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message updateMessage(@RequestBody Message message) {
        return messageService.updateMessage(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMessage(@PathVariable("id") int messageId) {
        return messageService.deleteMessage(messageId);
    }

}
