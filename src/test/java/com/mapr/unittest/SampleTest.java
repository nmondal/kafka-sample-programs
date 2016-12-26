package com.mapr.unittest;

import com.mapr.examples.Consumer;
import com.mapr.examples.Producer;
import info.batey.kafka.unit.KafkaUnitRule;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.junit.Rule;
import org.junit.Test;


public class SampleTest{

    @Rule
    public KafkaUnitRule kafkaUnitRule = new KafkaUnitRule() ;


    @Test
    public void producerConsumer() throws Exception {
        kafkaUnitRule.getKafkaUnit().createTopic(Producer.TOPIC1 );
        kafkaUnitRule.getKafkaUnit().createTopic(Producer.TOPIC2 );
        // create producer ...
        KafkaProducer<String,String> producer = kafkaUnitRule.getKafkaUnit().producer() ;
        // call produce()?
        Producer.produce( producer );
        // create consumer ...
        KafkaConsumer<String,String> consumer = kafkaUnitRule.getKafkaUnit().consumer() ;
        // call consume
        Consumer.consume( consumer , 10000 );
    }

}
