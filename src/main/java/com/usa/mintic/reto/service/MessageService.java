package com.usa.mintic.reto.service;

import com.usa.mintic.reto.entities.Message;
import com.usa.mintic.reto.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessages(){return messageRepository.getMessages();}

    public Optional<Message> getMessage(int id){return messageRepository.getMessage(id);}

    public Message saveMessage(Message m){
        if(m.getMessageId()==null){
            return messageRepository.saveMessage(m);
        }else{
            Optional<Message> element = messageRepository.getMessage(m.getMessageId());
            if(element.isPresent()){
                return m;
            }else {
                return messageRepository.saveMessage(m);
            }
        }
    }
    public Message updateMessage(Message message){
        if(message.getMessageId()!=null){
            Optional<Message> element= messageRepository.getMessage(message.getMessageId());
            if(element.isPresent()){
                if(message.getMessageText()!=null){
                    element.get().setMessageText(message.getMessageText());
                }
                messageRepository.saveMessage(element.get());
                return element.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    public boolean deleteMessage(int id) {
        boolean flag = false;
        Optional<Message> element = messageRepository.getMessage(id);
        if(element.isPresent()){
            messageRepository.deleteMessage(element.get());
            flag = true;
        }
        return flag;
    }

}
