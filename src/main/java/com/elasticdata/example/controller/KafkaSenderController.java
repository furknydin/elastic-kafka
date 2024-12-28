package com.elasticdata.example.controller;


import com.elasticdata.example.kafkaproducer.KafkaSender;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaSenderController {

    private final KafkaSender kafkaSender;

    public KafkaSenderController(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    @PostMapping("/send")
    public ResponseEntity<Boolean> sendKafkaMessage(@RequestBody Request request) {
        kafkaSender.sendMessage(request.getTopicName(), request.getMessage());

        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
