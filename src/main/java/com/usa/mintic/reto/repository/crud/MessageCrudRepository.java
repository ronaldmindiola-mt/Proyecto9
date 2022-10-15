package com.usa.mintic.reto.repository.crud;

import com.usa.mintic.reto.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, String> {
}
