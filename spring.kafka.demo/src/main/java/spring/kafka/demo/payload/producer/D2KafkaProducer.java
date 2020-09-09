package spring.kafka.demo.payload.producer;

import org.springframework.stereotype.Component;

import spring.kafka.demo.common.config.C1KafkaPropertiesFactory;
import spring.kafka.demo.common.producer.KafkaProducerDto;

@Component
public class D2KafkaProducer extends KafkaProducerDto {

	public D2KafkaProducer(C1KafkaPropertiesFactory propertiesFactory) {
		super(propertiesFactory);
	}

}
