package com.example.kafka.springbootkafkadocker;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Message {
    @Id
    @GeneratedValue
    @Column(name = "corelatiId")
    private Integer id;
    @Column(name = "message")
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public Message() {
    }
}
