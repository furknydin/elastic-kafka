package com.elasticdata.example.kafkaproducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaSender {
    private static final Logger logger = LoggerFactory.getLogger(KafkaSender.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topicName,String msg) {
        kafkaTemplate.send(topicName, msg);

        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, msg);
        future.whenComplete((result,ex) -> {
            if (ex == null) {
                logger.info("Message: {} with offset: {}",msg,result.getRecordMetadata().offset());
            } else {
                logger.error("Unable to send message : {}  due to: {}",msg,ex.getMessage());
            }
        });
    }
}
