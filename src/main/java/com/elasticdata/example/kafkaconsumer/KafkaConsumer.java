package com.elasticdata.example.kafkaconsumer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "test-elastic",groupId = "test-group")
    public void testElasticConsume(ConsumerRecord<Integer, String> quote) {
        log.info("received: {}",quote);
    }
}
