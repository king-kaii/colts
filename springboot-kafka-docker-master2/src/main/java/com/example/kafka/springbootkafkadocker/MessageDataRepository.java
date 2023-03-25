package com.example.kafka.springbootkafkadocker;

import org.springframework.data.repository.CrudRepository;

public interface MessageDataRepository extends CrudRepository<Message, Integer> {
}

