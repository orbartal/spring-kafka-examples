package spring.kafka.demo.simplest.producer;

import org.springframework.stereotype.Component;

import spring.kafka.demo.common.config.C1KafkaPropertiesFactory;
import spring.kafka.demo.common.producer.KafkaProducerString;

@Component
public class D1KafkaProducer extends KafkaProducerString {

	public D1KafkaProducer(C1KafkaPropertiesFactory propertiesFactory) {
		super(propertiesFactory);
	}

}
