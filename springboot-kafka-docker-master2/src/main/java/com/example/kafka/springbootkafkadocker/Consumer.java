package com.example.kafka.springbootkafkadocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import com.example.kafka.springbootkafkadocker.Message;

import java.util.Arrays;

@Service
public class Consumer {
    @Autowired
     MessageDataRepository messageDataRepository;

    @KafkaListener(topics = "test_topic5",groupId = "group_id")
    public void consumeMessage(String message){

        System.out.println(message);
       // String last = message.substring(message.lastIndexOf(' ') + 1);
        Message msg = new Message();

        //msg.setId(Integer.parseInt(String.valueOf(last)));
        msg.setMessage(message);
        messageDataRepository.save(msg);
    }
}
