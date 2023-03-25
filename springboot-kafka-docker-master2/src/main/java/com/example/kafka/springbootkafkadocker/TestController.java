package com.example.kafka.springbootkafkadocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final com.example.kafka.springbootkafkadocker.Producer producer;

    @Autowired
    public TestController(com.example.kafka.springbootkafkadocker.Producer producer) {
        this.producer = producer;
    }
    @PostMapping("/publish")
    public void messageToTopic(@RequestParam("message") String message) {
        for (int i = 0; i < 2000; i++){
            this.producer.sendMessage(message+i);
    }

    }
}
