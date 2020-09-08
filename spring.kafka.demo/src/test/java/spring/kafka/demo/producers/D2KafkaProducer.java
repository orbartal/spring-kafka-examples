package spring.kafka.demo.producers;

import java.util.Map;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class D2KafkaProducer extends KafkaProducer <Integer, String> {
	
	public D2KafkaProducer(Map<String, Object> configs) {
		super(configs);
	}

	public Future<RecordMetadata> sendMessage(String topic, String data) {
		return super.send(new ProducerRecord<>(topic, data));
	}

}
